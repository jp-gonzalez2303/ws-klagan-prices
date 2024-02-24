package com.example.wsklaganprices.price.infrastructure.repository;

import com.example.wsklaganprices.price.infrastructure.adapter.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface IPriceRepository extends JpaRepository<PriceEntity, Integer> {



    @Query("select prices  from PriceEntity  prices where :applicationDate between prices.startDate and prices.endDate " +
            "and prices.productId =:productId and prices.brandId = :brandId")
    List<PriceEntity> findByApplicationDateAndProductIdAndBrandId(@Param("applicationDate") LocalDateTime applicationDate,
                                                                  @Param("productId") Integer productId,
                                                                  @Param("brandId") Integer brandId);

}
