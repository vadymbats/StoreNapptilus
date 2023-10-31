package com.example.demo.controller.exception;

import com.example.demo.controller.StoreController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StoreControllerExceptionHandler.class)
public class StoreControllerExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StoreControllerExceptionHandler handler;

    @MockBean
    private StoreController controller;

    @Test
    void callWillRetrieveException() throws Exception {
        LocalDateTime date = LocalDateTime.of(2020, Month.APRIL, 1, 12, 30, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");

        when(controller.getItem(1, 1, date)).thenThrow(new NoSuchElementException());

        var resp = mockMvc.perform(get("/store/1/1").param("date", date.format(formatter))).andExpect(status().isNotFound());

    }
}
