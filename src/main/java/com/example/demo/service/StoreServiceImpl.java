package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.entity.mapper.ItemMapper;
import com.example.demo.entity.overview.ItemOverviewDto;
import com.example.demo.entity.repository.ItemRepository;
import com.example.demo.service.def.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final ItemRepository itemRepository;
    private final ItemMapper mapper;

    @Override
    public ItemOverviewDto getFilteredItem(int brandId, int productId, LocalDateTime date) {
        //Según los datos de entrada, asumimos que nunca habrá conflicto de prioridades, siempre habrá un max
        var filteredItem = itemRepository.findWithFilter(date, brandId, productId).stream()
                .max(Comparator.comparing(Item::getPriority));
        return filteredItem.map(mapper::toItemOverviewDto).orElseThrow(NoSuchElementException::new);
    }
}
