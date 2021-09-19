package ru.romanov.events.components;

import lombok.*;
import ru.romanov.events.enums.TripStates;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Trip {
    private String destination;
    private Car car;
    private TripStates state;

    public Trip(String destination, Car car) {
        this.destination = destination;
        this.car = car;
    }
}
