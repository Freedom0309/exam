package com.jcohy.exam.enums;

public interface BaseEnum<E extends Enum<E>> {
    String getEnumValue();
}