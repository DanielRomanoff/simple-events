package ru.romanov.events.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.romanov.events.enums.CarStates;

@Data
@AllArgsConstructor
public class Car {
    private String name;
    private CarStates state;

    public Car(String name) {
        this.name = name;
    }
}
