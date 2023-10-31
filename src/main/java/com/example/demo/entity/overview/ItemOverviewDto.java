package com.example.demo.entity.overview;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@Builder
public class ItemOverviewDto {

    private int brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int productId;

    private double price;

    private String curr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemOverviewDto that = (ItemOverviewDto) o;
        return brandId == that.brandId && productId == that.productId && Double.compare(that.price, price) == 0 && startDate.equals(that.startDate) && endDate.equals(that.endDate) && curr.equals(that.curr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, startDate, endDate, productId, price, curr);
    }
}
