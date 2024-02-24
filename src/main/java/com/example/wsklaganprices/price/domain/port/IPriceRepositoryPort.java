package com.example.wsklaganprices.price.domain.port;

import com.example.wsklaganprices.price.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Puerto para la definicion de consultas hacia base de datos
 */
public interface IPriceRepositoryPort {

    List<Price> findAll();


    List<Price> findByApplicationDateAndProductIdAndBrandId(LocalDateTime applicationDate, Integer productId, Integer brandId);

}
