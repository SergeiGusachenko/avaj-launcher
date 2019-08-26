package com.academyplus.vehicles;

import com.academyplus.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if(weather == null)
            return;
        if (weather.equals("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2,coordinates.getLatitude(), coordinates.getHeight() + 4);
            System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " Let's enjoy the good weather and take some pics.");
        }
        else if (weather.equals("RAIN")){
            this.coordinates =  new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),coordinates.getHeight() - 5);
            System.out.println("Baloon#" + this.name + "(" + this.id + ")" + "  Damn you rain! You messed up my baloon.");
        }
        else if(weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
        }
        else if(weather.equals("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(), coordinates.getHeight() - 15);
            System.out.println("Baloon#" + this.name + "(" + this.id + ")" + "  It's snowing. We're gonna crash.");
        }
        if(coordinates.getHeight() <= 0 || coordinates.getHeight() >= 100)
        {
            System.out.println("Baloon#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

        this.weatherTower = weatherTower;
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }

}