package ru.lamp2502.jmixjavarush.entity.document;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum Content implements EnumClass<String> {

    SUPPLY_OF_MTR("SUPPLY_OF_MTR "),
    PRICES_FOR_SUPPLY_TO_CONTRACT("PRICES_FOR_SUPPLY_TO_CONTRACT "),
    FOR_OBJECT_NUMBER_1("FOR_OBJECT_NUMBER_1"),
    TO_CONTRACT_FOR_SUPPLY_OF_MTP("TO_CONTRACT_FOR_SUPPLY_OF_MTP "),
    FOR_OBJECT_NUMBER_2("FOR_OBJECT_NUMBER_2");

    private String id;

    Content(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Content fromId(String id) {
        for (Content at : Content.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}