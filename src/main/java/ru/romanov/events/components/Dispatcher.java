package ru.romanov.events.components;

import ru.romanov.events.annotations.Add;
import ru.romanov.events.annotations.Remove;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    List<Car> needRepairCars = new ArrayList<>();

    List<Driver> drivers = new ArrayList<>();

    @Inject
    Event<Trip> addTripEvent;

    public void addTrip(Trip trip) {
        System.out.println(trip + " - новый рейс, водитель, проверяй!");
        addTripEvent.fire(trip);
    }

    public void takeCarOnRepair(@Observes Car car) {
        needRepairCars.add(car);
        System.out.println("Получил заявку на ремонт машины - " + needRepairCars.get(needRepairCars.indexOf(car)));
    }

    public void addDriver(@Observes @Add Driver driver) {
        drivers.add(driver);
        System.out.println(driver + " принят в работу");
    }

    public void removeDriver(@Observes @Remove Driver driver) {
        System.out.println(driver + " отстранен от работы");
        drivers.remove(driver);
    }
}
