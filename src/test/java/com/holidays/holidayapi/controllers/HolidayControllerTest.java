package com.holidays.holidayapi.controllers;

import com.holidays.holidayapi.services.HolidayService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class HolidayControllerTest {

    @Autowired
    private HolidayService holidayService;

    @Autowired
    private MockMvc mvc;


    @Test
    void welcome_response() throws Exception {
        mvc.perform(get("/holidayapi/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void holidayResponse_check_year() throws Exception {
        mvc.perform(get("/holidayapi/LV/2021")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void holidayResponse_check_full_date() throws Exception {
        mvc.perform(get("/holidayapi/LV/31122021")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void holidayResponse_incorrect_full_date() throws Exception {
        mvc.perform(get("/holidayapi/LV/3122021")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void holidayResponse_full_date_not_holiday() throws Exception {
        mvc.perform(get("/holidayapi/LV/30122021")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}