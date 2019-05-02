package com.jcohy.exam.enums;

public enum DeliveryStatus implements BaseEnum {

    NOTVIEWED("0","未查看"),
    VIEWED("1","已查看"),
    NOTCOMMUNICATE("2","待沟通"),
    NOTMEETING("3", "待面试"),
    MEETED("4", "已面试"),
    REFUSED("5", "已拒绝");


    private final String value;
    private final String cnName;
    DeliveryStatus(String value, String cnName){
        this.cnName=cnName;
        this.value=value;
    }
    public String getValue() {
        return value;
    }
    public String getCnName() {
        return cnName;
    }
    public String getEnumValue() {
        return this.value;
    }
}
