package ru.romanov.events.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CarStates {
    OK(1),
    NEED_REPAIR(2);

    private final int id;

    public int getId() {
        return id;
    }

    public static CarStates getById(int id){
        for (CarStates outcomesType : CarStates.values()) {
            if (outcomesType.getId() == id)
                return outcomesType;
        }
        return null;
    }
}
