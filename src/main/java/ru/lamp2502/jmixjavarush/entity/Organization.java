package ru.lamp2502.jmixjavarush.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum Organization implements EnumClass<String> {

    PAO_TRANSNEFN("PAO_TRANSNEFN"),
    VYKSUNSKI_STEEL_FACTORY("VYKSUNSKI_STEEL_FACTORY"),
    FACTORY_1("FACTORY_1"),
    FACTORY_2("FACTORY_2"),
    FACTORY_3("FACTORY_3");

    private String id;

    Organization(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Organization fromId(String id) {
        for (Organization at : Organization.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}