package com.academyplus.weather;


import com.academyplus.vehicles.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private String string[];

    private WeatherProvider() {

    }

    public static WeatherProvider getWeatherProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int  weatherCount = 0;
        weatherCount = coordinates.getHeight() +coordinates.getLatitude() + coordinates.getLongitude();
        if(weatherCount % 4 == 0) {
            return "RAIN";
        }
        else if (weatherCount % 4 == 1) {
            return "FOG";
        }
        else if (weatherCount % 4 == 2) {
            return "SUN";
        }
        else if (weatherCount % 4 == 3) {
            return "SNOW";
        }
        return null;
    }
}