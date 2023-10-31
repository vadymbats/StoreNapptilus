package com.example.demo.entity.repository;

import com.example.demo.entity.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

    @Query("select i from Item i where i.brandId = :brandId and i.productId = :productId and :appDate >= i.startDate and :appDate <= i.endDate")
    List<Item> findWithFilter(@Param("appDate") LocalDateTime date, @Param("brandId") int brandId, @Param("productId") int productId);
}
