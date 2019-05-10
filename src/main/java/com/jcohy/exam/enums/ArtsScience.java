package com.jcohy.exam.enums;

public enum ArtsScience implements BaseEnum {

    ARTS("文科", "文科"),
    SCIENCE("理科", "理科");

    private final String cnName;
    private final String value;

    ArtsScience(String value, String cnName) {
        this.value = value;
        this.cnName = cnName;
    }

    public String getValue() {
        return value;
    }
    public String getCnName() {
        return cnName;
    }

    @Override
    public String getEnumValue() {
        return this.value;
    }

}
