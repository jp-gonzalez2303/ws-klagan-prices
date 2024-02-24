package com.example.wsklaganprices.price.domain.model;

import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Price {

    private Long priceList;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private Integer priority;
    private Double price;
    private String currency;
}
