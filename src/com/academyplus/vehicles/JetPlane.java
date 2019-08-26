package com.academyplus.vehicles;


import com.academyplus.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates){
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
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10,coordinates.getLatitude(), coordinates.getHeight() + 2);
        }
        else if (weather.equals("RAIN")){
            this.coordinates =  new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),coordinates.getHeight());
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.");
        }
        else if(weather.equals("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());

        }
        else if(weather.equals("SNOW")){
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): OMG! Winter is coming!");
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(), coordinates.getHeight() - 12);
        }
        if(coordinates.getHeight() <= 0 || coordinates.getHeight() >= 100)
        {
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

        this.weatherTower = weatherTower;
        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}