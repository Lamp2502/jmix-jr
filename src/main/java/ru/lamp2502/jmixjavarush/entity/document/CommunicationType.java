package ru.lamp2502.jmixjavarush.entity.document;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum CommunicationType implements EnumClass<String> {

    KIT("KIT"),
    APPENDIX("APPENDIX");

    private String id;

    CommunicationType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CommunicationType fromId(String id) {
        for (CommunicationType at : CommunicationType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}