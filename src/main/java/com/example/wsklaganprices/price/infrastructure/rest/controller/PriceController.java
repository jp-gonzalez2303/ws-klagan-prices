package com.example.wsklaganprices.price.infrastructure.rest.controller;

import com.example.wsklaganprices.price.application.usecases.IPriceService;
import com.example.wsklaganprices.price.domain.model.dto.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicio rest expuesto  para el manejo de las funcionalidades de precios
 */
@RestController
@RequestMapping("/price")
public class PriceController {

    private final IPriceService priceService;

    @Autowired
    public PriceController(IPriceService priceService) {
        this.priceService = priceService;
    }


    /**
     * Servicio Rest que consulta todos los precios que se encuentran en la tabla
     *
     * @return List<PriceDto> listado de precios
     */
    @GetMapping()
    public ResponseEntity<List<PriceDto>> findAll() {

        return new ResponseEntity<>(priceService.findAll(), HttpStatus.OK);

    }

 
    /**
     * Servicio Rest que consulta precios por los sigueintes parametros filtrando de la prioridad
     *
     * @param applicationDate fecha de aplicacion del precio
     * @param productId       id del producto
     * @param brandId         id de la cadena del grupo
     * @return PriceDto precio consultado
     */
    @GetMapping("/find-by-application-product-brand")
    public ResponseEntity<PriceDto> findByApplicationDateAndProductIdAndBrandId(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime applicationDate,
            @RequestParam Integer productId,
            @RequestParam Integer brandId) {

        return new ResponseEntity<>(priceService.findByApplicationDateAndProductIdAndBrandId(applicationDate, productId, brandId), HttpStatus.OK);

    }


}
