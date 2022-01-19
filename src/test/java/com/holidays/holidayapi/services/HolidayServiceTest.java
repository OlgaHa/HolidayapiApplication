package com.holidays.holidayapi.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HolidayServiceTest {

    @Autowired
    HolidayService holidayService;

    @Test
    void isHoliday_return_true() throws ParseException {
        boolean result = holidayService.isHoliday("LV", "31122021");
        assertTrue(result);
    }

    @Test
    void isHoliday_return_false() throws ParseException {
        boolean result = holidayService.isHoliday("LV", "30122021");
        assertFalse(result);
    }

    @Test
    void getHolidaysNumber() {
        int result = holidayService.getHolidaysNumber("LV", "2021");
        assertEquals(14, result);
    }
}