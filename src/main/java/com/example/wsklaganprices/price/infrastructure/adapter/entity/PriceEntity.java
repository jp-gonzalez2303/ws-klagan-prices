package com.example.wsklaganprices.price.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "PRICE")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class PriceEntity {


    @Id
    @Column(name = "PRICE_LIST")
    private Integer priceList;


    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CURR")
    private String currency;

}
