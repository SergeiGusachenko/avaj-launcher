package com.academyplus.weather;

import com.academyplus.vehicles.Coordinates;

public  class WeatherTower extends Tower{

    public void changeWeather()
    {
        super.conditionsChanged();
    }

    public WeatherTower()
    {
        super();
    }

    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates);
    }
}