package com.example.demo.service.def;

import com.example.demo.entity.overview.ItemOverviewDto;

import java.time.LocalDateTime;

@FunctionalInterface
public interface StoreService {

    ItemOverviewDto getFilteredItem(int brandId, int productId, LocalDateTime date);
}
