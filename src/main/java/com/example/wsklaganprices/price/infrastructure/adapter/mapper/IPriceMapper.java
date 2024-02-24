package com.example.wsklaganprices.price.infrastructure.adapter.mapper;


import com.example.wsklaganprices.price.domain.model.Price;
import com.example.wsklaganprices.price.infrastructure.adapter.entity.PriceEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPriceMapper {

    @Mapping(source = "priceList",target = "priceList")
    @Mapping(source = "brandId",target = "brandId")
    @Mapping(source = "startDate",target = "startDate")
    @Mapping(source = "endDate",target = "endDate")
    @Mapping(source = "productId",target = "productId")
    @Mapping(source = "priority",target = "priority")
    @Mapping(source = "price",target = "price")
    @Mapping(source = "currency",target = "currency")
    PriceEntity toEntity(Price priceDto);

    @InheritInverseConfiguration
    Price toDomain(PriceEntity price);


}
