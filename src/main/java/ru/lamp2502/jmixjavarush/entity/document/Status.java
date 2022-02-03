package ru.lamp2502.jmixjavarush.entity.document;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum Status implements EnumClass<String> {

    IN_WORK("IN_WORK "),
    FAMILIARIZATION("FAMILIARIZATION"),
    LOADING_IN_LKK("LOADING_IN_LKK"),
    APPOINTMENT_OF_EXECUTIVE("APPOINTMENT_OF_EXECUTIVE"),
    OPERATE("OPERATE"),
    COMPLETED("COMPLETED");

    private String id;

    Status(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Status fromId(String id) {
        for (Status at : Status.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}