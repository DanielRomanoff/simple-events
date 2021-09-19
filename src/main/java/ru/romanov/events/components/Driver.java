package ru.romanov.events.components;

import lombok.Getter;
import lombok.Setter;
import ru.romanov.events.annotations.Add;
import ru.romanov.events.annotations.Remove;
import ru.romanov.events.enums.CarStates;
import ru.romanov.events.enums.Names;
import ru.romanov.events.enums.TripStates;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


@Getter
@Setter
public class Driver {

    @Inject
    Event<Car> needRepairEvent;

    @Add
    @Inject
    Event<Driver> addDriverEvent;

    @Remove
    @Inject
    Event<Driver> removeDriverEvent;

    private String name;

    private List<Trip> trips = new ArrayList<>();

    private Car car;

    {
        name = Objects.requireNonNull(Names.getById(new Random()
                        .ints(1, 12)
                        .findAny()
                        .getAsInt()
                ))
                .toString();
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", trips=" + trips +
                ", car=" + car +
                '}';
    }

    public void addTrip(@Observes Trip trip) {
        trips.add(trip);
        System.out.println(this + "\n" + trip + " - получил рейс, спасибо!");
        addDriverEvent.fire(this);
        completeTrip(trip);
    }

    public void completeTrip(Trip trip) {
        trips.get(trips.indexOf(trip)).setState(TripStates.SUCCESS);
        trip.getCar()
                .setState(CarStates
                        .getById(new Random()
                                .ints(1, 3)
                                .findAny().getAsInt()));
        System.out.println("Завершил рейс - " + trip + "\nСостояние машины - " + trip.getCar().getState());
        if (trip.getCar().getState() == CarStates.NEED_REPAIR) {
            needRepairEvent.fire(trip.getCar());
            removeDriverEvent.fire(Driver.this);
        }
        trips.remove(trip);
    }

}