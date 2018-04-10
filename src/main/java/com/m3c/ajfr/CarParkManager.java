package com.m3c.ajfr;

public class CarParkManager {

    private CarPark carPark;

    public CarParkManager(CarPark carPark) {
        this.carPark = carPark;
    }

    public void requestCarParkSpace() throws InterruptedException {
        synchronized (carPark) { //Doesn't matter what it is locked on so long as there is consistency between synchronized (x) x.wait() and x.notifyAll()
            while(!carPark.hasAvailableSpaces()){
                System.out.println(Thread.currentThread().getName() + " is waiting for a space");
                carPark.wait();
            }
                carPark.addCar();
                System.out.println(Thread.currentThread().getName()+" parked - Spaces available = "+carPark.getSpaces());
        }
    }

    public void leaveCarPark() {
        synchronized (carPark) {
            carPark.removeCar();
            carPark.notifyAll();
            System.out.println(Thread.currentThread().getName() + " leaving - Spaces available = " + carPark.getSpaces());
        }
    }

}
