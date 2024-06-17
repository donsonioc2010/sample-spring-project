package com.example.jong1.core.enums.payments;

import com.example.jong1.core.enums.common.EnumMapperType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CommissionType  implements EnumMapperType {
    PERCENT("퍼센트"),
    MONEY("금액");

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
