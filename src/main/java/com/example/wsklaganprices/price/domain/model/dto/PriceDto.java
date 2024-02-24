package com.example.wsklaganprices.price.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class PriceDto {

    private Long productId;
    private Long brandId;
    private Integer priceList;
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime endDate;
    private Double price;
}
