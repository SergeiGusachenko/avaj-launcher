package com.academyplus.vehicles;


import com.academyplus.weather.WeatherTower;

public interface Flyable{
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}