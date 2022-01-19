package com.holidays.holidayapi.controllers;

import com.holidays.holidayapi.services.HolidayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/holidayapi")
public class HolidayController {

    private final HolidayService holidayService;
    private final Pattern yearPattern = Pattern.compile("\\d{4}");
    private final Pattern datePattern = Pattern.compile("\\d{8}");

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping
    public String welcome() {
        return "Welcome to the HolidayapiApplication!";
    }

    @GetMapping(value = "/{country}/{date}")
    public String holidayResponse(@PathVariable(name = "country") String country, @PathVariable(name = "date") String date) throws ParseException {
        String response = "Please, check the date format";

        if (date.matches(String.valueOf(datePattern))) {
            if (holidayService.isHoliday(country, date)) {
                response = "yes";
            } else {
                response = "no";
            }
        } else if (date.matches(String.valueOf(yearPattern))) {
            response = String.valueOf(holidayService.getHolidaysNumber(country, date));
        }

        return response;
    }
}
