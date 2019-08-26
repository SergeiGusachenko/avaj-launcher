package com.academyplus.vehicles;

public class AircraftFactory<P extends Aircraft> {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type.toLowerCase()) {
            case "helicopter":
                return new Helicopter(name, coordinates);
            case "baloon":
                return new Baloon(name, coordinates);
            case "jetplane":
                return new JetPlane(name, coordinates);
        }
        return null;
    }
}
