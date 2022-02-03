package ru.lamp2502.jmixjavarush.entity.document;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum Type implements EnumClass<String> {

    SPECIFICATION("SPECIFICATION"),
    PRICE_LIST("PRICE_LIST "),
    SCHEDULE_PERFORMANCE("SCHEDULE_PERFORMANCE "),
    SUPPLEMENTARY_AGREEMENT("SUPPLEMENTARY_AGREEMENT "),
    INFORMATION_ABOUT_CHAIN_OF_OWNERS("INFORMATION_ABOUT_CHAIN_OF_OWNERS "),
    WORKING_DOCUMENTATION_FOR_CMD("WORKING_DOCUMENTATION_FOR_CMD ");

    private String id;

    Type(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Type fromId(String id) {
        for (Type at : Type.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}