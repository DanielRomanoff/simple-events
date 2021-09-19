package ru.romanov.events;

import ru.romanov.events.components.Car;
import ru.romanov.events.components.Dispatcher;
import ru.romanov.events.components.Trip;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * Разработать систему «Автобаза».
 * Диспетчер распределяет заявки на Рейсы между Водителями и назначает для этого Автомобиль.
 * Водитель делает отметку о выполнении Рейса и состоянии Автомобиля.
 * Водитель может сделать заявку на ремонт.
 * Диспетчер может отстранить Водителя от работы.
 * Между классами могут передаваться разные сообщения.
 * */

public class App {
    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        SeContainer container = initializer.initialize();

        Dispatcher dispatcher = container.select(Dispatcher.class).get();
        dispatcher.addTrip(new Trip("До Парижа", new Car("Рено логан")));
        dispatcher.addTrip(new Trip("До Казани!", new Car("Порше")));
        dispatcher.addTrip(new Trip("До Москвы!", new Car("Лада калина")));
        dispatcher.addTrip(new Trip("До Питера!", new Car("Ламбо")));
        dispatcher.addTrip(new Trip("До Оттавы!", new Car("Феррари")));
        dispatcher.addTrip(new Trip("До Калининграда!", new Car("Инфинити")));

    }
}
