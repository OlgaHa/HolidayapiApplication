package com.holidays.holidayapi.services;

import com.holidays.holidayapi.models.Holiday;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class HolidayService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final Calendar calendar = Calendar.getInstance();

    private static final DateFormat
            originalFormat = new SimpleDateFormat("ddMMyyyy"),
            targetFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Value("${holidayapi.url}")
    private String holidayapiUrl;

    public Boolean isHoliday(String country, String dateString) throws ParseException {
        Date date = originalFormat.parse(dateString);
        String formattedDate = targetFormat.format(date);
        calendar.setTime(date);

        return this.getAllCountryHolidays(country, String.valueOf(calendar.get(Calendar.YEAR))).stream().anyMatch(holiday -> holiday.getDate().equals(formattedDate));
    }

    public int getHolidaysNumber(String country, String year) {
        return this.getAllCountryHolidays(country, year).toArray().length;
    }

    private List<Holiday> getAllCountryHolidays(String country, String year) {
        Map<String, String> params = new HashMap<>();
        params.put("country", country);
        params.put("year", year);
        Holiday[] holidays = restTemplate.getForObject(holidayapiUrl, Holiday[].class, params);
        return Arrays.asList(holidays != null ? holidays : new Holiday[0]);
    }
}
