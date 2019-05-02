package com.jcohy.exam.enums;

public enum JobStatus implements BaseEnum {

    NORMAL("0","正常"),
    OFFLINE("1","下线");

    private final String value;
    private final String cnName;
    JobStatus(String value, String cnName){
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
