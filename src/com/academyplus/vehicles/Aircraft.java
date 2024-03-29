package com.academyplus.vehicles;

public class Aircraft{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;


    protected Aircraft(String name, Coordinates coordinates)
    {
        this.coordinates = coordinates;
        this.name = name;
        this.id = this.nextId();
    }

    private long nextId()
    {
        return ++(Aircraft.idCounter);
    }

}