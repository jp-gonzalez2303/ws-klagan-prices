package com.example.wsklaganprices.rest;


import com.example.wsklaganprices.price.application.usecases.IPriceService;
import com.example.wsklaganprices.price.domain.model.dto.PriceDto;
import com.example.wsklaganprices.price.infrastructure.repository.IPriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TestRest {


    private final String URI_SERVICE_PRICES = "/price/find-by-application-product-brand";
    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    private IPriceRepository userRepository;

    @Autowired
    private IPriceService priceService;


    @Test
    public void testCase1() {
        

        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        Integer productId = 35455;
        Integer brandId = 1;
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URI_SERVICE_PRICES)
                .queryParam("applicationDate", applicationDate)
                .queryParam("productId", productId)
                .queryParam("brandId", brandId);


        ResponseEntity<PriceDto> response = testRestTemplate.getForEntity(builder.toUriString(), PriceDto.class);


        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getPriceList(),1);
    }


    @Test
    public void testCase2() {
        

        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
        Integer productId = 35455;
        Integer brandId = 1;
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URI_SERVICE_PRICES)
                .queryParam("applicationDate", applicationDate)
                .queryParam("productId", productId)
                .queryParam("brandId", brandId);


        ResponseEntity<PriceDto> response = testRestTemplate.getForEntity(builder.toUriString(), PriceDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getPriceList(),2);
    }


    @Test
    public void testCase3() {
        

        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
        Integer productId = 35455;
        Integer brandId = 1;
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URI_SERVICE_PRICES)
                .queryParam("applicationDate", applicationDate)
                .queryParam("productId", productId)
                .queryParam("brandId", brandId);


        ResponseEntity<PriceDto> response = testRestTemplate.getForEntity(builder.toUriString(), PriceDto.class);


        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getPriceList(),1);
    }


    @Test
    public void testCase4() {
        

        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        Integer productId = 35455;
        Integer brandId = 1;
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URI_SERVICE_PRICES)
                .queryParam("applicationDate", applicationDate)
                .queryParam("productId", productId)
                .queryParam("brandId", brandId);


        ResponseEntity<PriceDto> response = testRestTemplate.getForEntity(builder.toUriString(), PriceDto.class);


        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getPriceList(),3);
    }


    @Test
    public void testCase5() {
        

        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        Integer productId = 35455;
        Integer brandId = 1;
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URI_SERVICE_PRICES)
                .queryParam("applicationDate", applicationDate)
                .queryParam("productId", productId)
                .queryParam("brandId", brandId);


        ResponseEntity<PriceDto> response = testRestTemplate.getForEntity(builder.toUriString(), PriceDto.class);


        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getPriceList(),4);
    }


}
