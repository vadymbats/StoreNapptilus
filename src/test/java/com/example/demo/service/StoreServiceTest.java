package com.example.demo.service;

import com.example.demo.entity.overview.ItemOverviewDto;
import com.example.demo.service.def.StoreService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
class StoreServiceTest {

    @Autowired
    private StoreService service;

    private static Stream<Arguments> provideArgs(){
        return Stream.of(
                Arguments.of(1, 35455, LocalDateTime.of(2020, Month.JUNE, 14, 10, 0, 0),
                        ItemOverviewDto.builder()
                                .brandId(1)
                                .productId(35455)
                                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0))
                                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                                .price(35.5)
                                .curr("EUR")
                                .build()),
                Arguments.of(1, 35455, LocalDateTime.of(2020, Month.JUNE, 14, 16, 0, 0),
                        ItemOverviewDto.builder()
                                .brandId(1)
                                .productId(35455)
                                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 15, 0, 0))
                                .endDate(LocalDateTime.of(2020, Month.JUNE, 14, 18, 30, 0))
                                .price(25.45)
                                .curr("EUR")
                                .build()),
                Arguments.of(1, 35455, LocalDateTime.of(2020, Month.JUNE, 14, 21, 0, 0),
                        ItemOverviewDto.builder()
                                .brandId(1)
                                .productId(35455)
                                .startDate(LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0))
                                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                                .price(35.5)
                                .curr("EUR")
                                .build()),
                Arguments.of(1, 35455, LocalDateTime.of(2020, Month.JUNE, 15, 10, 0, 0),
                        ItemOverviewDto.builder()
                                .brandId(1)
                                .productId(35455)
                                .startDate(LocalDateTime.of(2020, Month.JUNE, 15, 0, 0, 0))
                                .endDate(LocalDateTime.of(2020, Month.JUNE, 15, 11, 0, 0))
                                .price(30.5)
                                .curr("EUR")
                                .build()),
                Arguments.of(1, 35455, LocalDateTime.of(2020, Month.JUNE, 16, 21, 0, 0),
                        ItemOverviewDto.builder()
                                .brandId(1)
                                .productId(35455)
                                .startDate(LocalDateTime.of(2020, Month.JUNE, 15, 16, 0, 0))
                                .endDate(LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59))
                                .price(38.95)
                                .curr("EUR")
                                .build())
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgs")
    @SqlGroup({
            @Sql(value = "classpath:schema.sql", executionPhase = BEFORE_TEST_METHOD),
            @Sql(value = "classpath:data.sql", executionPhase = BEFORE_TEST_METHOD)
    })
    void getItemSuccessfully(int brandId, int productId, LocalDateTime date, ItemOverviewDto result) {
        var actual = service.getFilteredItem(brandId, productId, date);
        assertEquals(result, actual);
    }
}
