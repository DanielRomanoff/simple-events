package ru.romanov.events.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Names {
    Герман(1),
    Антон(2),
    Саша(3),
    Миша(4),
    Артём(5),
    Марк(6),
    Иван(7),
    Мария(8),
    Анна(9),
    Алиса(10),
    Полина(11);

    private final int id;

    public int getId() {
        return id;
    }

    public static Names getById(int id){
        for (Names outcomesType : Names.values()) {
            if (outcomesType.getId() == id)
                return outcomesType;
        }
        return null;
    }
}
