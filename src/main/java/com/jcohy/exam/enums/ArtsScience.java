package com.jcohy.exam.enums;

public enum ArtsScience implements BaseEnum {

    ARTS("0", "文科"),
    SCIENCE("1", "理科");

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
