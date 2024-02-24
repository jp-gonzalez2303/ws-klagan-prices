package com.example.wsklaganprices.price.application.usecases;

import com.example.wsklaganprices.price.domain.model.dto.PriceDto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface para definicio nde contrato de casos de uso
 */
public interface IPriceService {

    /**
     * Caso de uso para busqueda de precio bajo parametros y priorizando por el campo prioridad de la entidad
     */
    PriceDto findByApplicationDateAndProductIdAndBrandId(LocalDateTime applicationDate, Integer productId, Integer brandId);

    /**
     * Servicio de consulta de todos los precios de la tabla
     */
    List<PriceDto> findAll();
}
