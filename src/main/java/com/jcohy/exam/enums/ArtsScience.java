package com.jcohy.exam.enums;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public static List getList(){
        List<Map<String, String>> lists = new ArrayList<>();

        Map<String, String> map = new LinkedHashMap<>();
        map.put(ARTS.value, ARTS.cnName);

        lists.add(map);
        Map<String, String> map1 = new LinkedHashMap<>();
        map1.put(SCIENCE.value, SCIENCE.cnName);
        lists.add(map1);

        return lists;
    }

}
