package com.academyplus.weather;

import com.academyplus.vehicles.AircraftFactory;
import com.academyplus.vehicles.Flyable;

import java.io.BufferedReader;
import java.io.IOException;

public class Simulator{

    BufferedReader br;
    public Simulator(BufferedReader br)
    {
        this.br = br;
    }

    public void simulation() throws IOException {
        int countOfSimulation = 0;
        String st;
        int i = 0;
        AircraftFactory factory = new AircraftFactory();
        Flyable aircraft;
        WeatherTower weatherTower = new WeatherTower();
        String arr[];
        while ((st = br.readLine()) != null)
        {
            if (i == 0)
                countOfSimulation = Integer.parseInt(st);
            else
            {
                arr = st.split(" ");
                aircraft = factory.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
                weatherTower.register(aircraft);
                aircraft.registerTower(weatherTower);
            }
            i++;
        }
        while(countOfSimulation != 0)
        {
            weatherTower.changeWeather();
            countOfSimulation--;
        }
    }

}