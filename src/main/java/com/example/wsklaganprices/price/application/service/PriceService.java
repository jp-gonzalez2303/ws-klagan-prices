package com.example.wsklaganprices.price.application.service;

import com.example.wsklaganprices.price.application.mapper.IPriceDtoMapper;
import com.example.wsklaganprices.price.application.usecases.IPriceService;
import com.example.wsklaganprices.price.domain.model.Price;
import com.example.wsklaganprices.price.domain.model.dto.PriceDto;
import com.example.wsklaganprices.price.domain.port.IPriceRepositoryPort;
import com.example.wsklaganprices.price.infrastructure.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Servicio encargado de la logica de los casos de uso co nrespecto a precios
 */
@Service
@Slf4j
public class PriceService implements IPriceService {


    private final IPriceRepositoryPort priceRepositoryPort;
    private final IPriceDtoMapper dtoMapper;

    @Autowired
    public PriceService(IPriceRepositoryPort priceRepositoryPort, IPriceDtoMapper dtoMapper) {
        this.priceRepositoryPort = priceRepositoryPort;
        this.dtoMapper = dtoMapper;
    }

    /**
     * Caso de uso para busqueda de precio bajo parametros y priorizando por el campo priority de la entidad
     *
     * @param applicationDate fecha de aplicacion del precio
     * @param productId       id del producto
     * @param brandId         id de la cadena del grupo
     * @return PriceDto
     */
    @Override
    public PriceDto findByApplicationDateAndProductIdAndBrandId(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        log.info("Se inicia consulta de precios conforme a los filtros applicationDate: {},productId: {}, brandId: {} ", applicationDate, productId, brandId);
        List<Price> prices = priceRepositoryPort.findByApplicationDateAndProductIdAndBrandId(applicationDate, productId, brandId);

        if (prices.isEmpty())
            throw new ResourceNotFoundException("No se encuentra registros con los parametros");

        log.info("Se encuentran los siguientes precios {}", prices);

        return prices.stream()
                .max(Comparator.comparingInt(Price::getPriority)).map(dtoMapper::toDto).get();
    }

    /**
     * Servicio de consulta de todos los precios de la tabla
     *
     * @return List<PriceDto>
     */
    @Override
    public List<PriceDto> findAll() {

        log.info("Se inicia consulta de todos los precios en base de datos");
        return priceRepositoryPort.findAll()
                .stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
