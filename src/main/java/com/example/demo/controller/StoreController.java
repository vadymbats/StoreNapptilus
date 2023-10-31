package com.example.demo.controller;

import com.example.demo.entity.overview.ItemOverviewDto;
import com.example.demo.service.def.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("store")
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;

    //Por variar entre path y request params
    @GetMapping("/{brandId}/{productId}")
    public ResponseEntity<ItemOverviewDto> getItem(@PathVariable(value = "brandId") int brandId, @PathVariable(value = "productId") int productId,
                                                   @RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm:ss") LocalDateTime date) {
        return ResponseEntity.ok(storeService.getFilteredItem(brandId, productId, date));
    }
}
