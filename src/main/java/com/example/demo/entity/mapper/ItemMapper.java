package com.example.demo.entity.mapper;

import com.example.demo.entity.Item;
import com.example.demo.entity.overview.ItemOverviewDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemOverviewDto toItemOverviewDto(Item item);
}
