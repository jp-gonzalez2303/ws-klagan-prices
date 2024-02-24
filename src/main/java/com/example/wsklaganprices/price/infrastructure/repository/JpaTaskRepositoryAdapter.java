package com.example.wsklaganprices.price.infrastructure.repository;

import com.example.wsklaganprices.price.domain.model.Price;
import com.example.wsklaganprices.price.domain.port.IPriceRepositoryPort;
import com.example.wsklaganprices.price.infrastructure.adapter.mapper.IPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Adapter para la implementacion de JPA para las consultas a base de datos
 */
@Component
public class JpaTaskRepositoryAdapter implements IPriceRepositoryPort {

    private final IPriceRepository jpaPriceRepository;

    private final IPriceMapper priceMapper;

    @Autowired
    public JpaTaskRepositoryAdapter(IPriceRepository jpaPriceRepository, IPriceMapper priceMapper) {
        this.jpaPriceRepository = jpaPriceRepository;
        this.priceMapper = priceMapper;
    }

    /**
     * Funcionalidad que devuelve todos los precios de la tabla
     * @return
     */
    @Override
    public List<Price> findAll() {
        return jpaPriceRepository.findAll()
                .stream()
                .map(priceMapper::toDomain)
                .collect(Collectors.toList());
    }


    /**
     *  Funcionalidad de busqueda de precios bajo los siguientes parametros
     * @param applicationDate fecha de aplicacion del precio
     * @param productId       id del producto
     * @param brandId         id de la cadena del grupo
     * @return List<Price>
     */
    @Override
    public List<Price> findByApplicationDateAndProductIdAndBrandId(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return jpaPriceRepository.findByApplicationDateAndProductIdAndBrandId(applicationDate, productId, brandId)
                .stream()
                .map(priceMapper::toDomain)
                .collect(Collectors.toList());
    }
}
