package com.example.wsklaganprices.price.application.mapper;


import com.example.wsklaganprices.price.domain.model.Price;
import com.example.wsklaganprices.price.domain.model.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPriceDtoMapper {

    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "price", target = "price")
    PriceDto toDto(Price priceDto);


}
