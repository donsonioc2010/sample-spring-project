package com.example.jong1.core.enums.payments;

import com.example.jong1.core.enums.common.EnumMapperType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CommissionCutting implements EnumMapperType {
    ROUND("반올림"),
    CEIL("올림"),
    FLOOR("버림");

    private final String value;

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return value;
    }
}
