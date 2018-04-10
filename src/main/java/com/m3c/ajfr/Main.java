package com.m3c.ajfr;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        CarPark carPark = new CarPark(25);
        final CarParkManager carParkManager = new CarParkManager(carPark);
        List<Thread> threads = new ArrayList<>();
        final Random randomGenerator = new Random();
        int numberCars = 50;
        for(int i = 1; i<=numberCars;i++){
            Runnable car = () -> {
                try {
                    carParkManager.requestCarParkSpace();
                    Thread.sleep(randomGenerator.nextInt(2));
                    carParkManager.leaveCarPark();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
                Thread thread = new Thread(car);
                thread.setName("Car-"+i);
                threads.add(thread);
        }

        for(Thread t : threads){
            t.start();
        }
    }
}
