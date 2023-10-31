package com.example.demo.controller;

import com.example.demo.entity.overview.ItemOverviewDto;
import com.example.demo.service.def.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StoreController.class)
public class StoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoreService service;

    @Test
    void getItemShouldReturnOk() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2020, Month.APRIL, 1, 12, 30, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");

        when(service.getFilteredItem(1, 1, dateTime)).thenReturn(ItemOverviewDto.builder().build());

        this.mockMvc.perform(get("/store/1/1").param("date", dateTime.format(formatter)))
                .andExpect(status().isOk());
    }
}
