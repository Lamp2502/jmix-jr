package ru.lamp2502.jmixjavarush.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum Action implements EnumClass<String> {

    ACTION_1("ACTION_1"),
    ACTION_2("ACTION_2"),
    ACTION_3("ACTION_3"),
    ACTION_4("ACTION_4"),
    ACTION_5("ACTION_5");

    private String id;

    Action(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Action fromId(String id) {
        for (Action at : Action.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}