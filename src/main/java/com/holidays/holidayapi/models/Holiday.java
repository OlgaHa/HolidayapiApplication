package com.holidays.holidayapi.models;

import lombok.Data;

import java.util.List;

@Data
public class Holiday {
    String date;
    String localName;
    String name;
    String countryCode;
    Boolean fixed;
    Boolean global;
    List<String> counties;
    String launchYear;
    List<String> types;
}
