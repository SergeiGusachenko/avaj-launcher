package com.academyplus.vehicles;

import com.academyplus.weather.Simulator;

import java.io.*;
public class Main
{
    public static void main(String[] args)throws Exception
    {
        int i = 1;
        File file = new File("/Users/sergeygusachenko/JAVA/src/com/academyplus/scenario.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Simulator simulator = new Simulator(br);
        simulator.simulation();
    }
}