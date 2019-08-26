package com.academyplus.weather;
import com.academyplus.vehicles.Flyable;
import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers;


    public Tower()
    {
        observers = new ArrayList<>();
    }

    public void register(Flyable flyable){

        if (flyable == null)
            return;
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged()
    {
        for(int i = 0; i < observers.size(); i++)
        {
            observers.get(i).updateConditions();
        }
    }
}
