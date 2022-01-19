This is an application to detect number of holidays in a specific country in a specific year, and whether a concrete day is a holiday in a chosen country.
How the application works:

run HolidayapiApplication;

to make sure the app works in the browser open http://localhost:8080/holidayapi;

the line  "Welcome to the HolidayapiApplication!" should be displayed;

to check if the date is a holiday in the browser open link in the format http://localhost:8080/holidayapi/{coutry code}/{date in the format ddMMyyyy}
(for instance http://localhost:8080/holidayapi/AL/25122021);

you should be able to see "yes" if the chosen date is a holiday in this country or "no" if it's not;

to find out the holiday number in a specific country in the browser open link in the format http://localhost:8080/holidayapi/{coutry code}/{year} (for example http://localhost:8080/holidayapi/AL/2021);

you should be able to see number of holidays in the chosen country;

if the dates are not in correct format the message "Please, check the date format" will appear;

to get Swagger documentation open localhost:8080/swagger-ui/;
