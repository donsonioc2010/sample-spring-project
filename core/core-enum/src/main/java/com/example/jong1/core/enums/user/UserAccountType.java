package com.example.jong1.core.enums.user;

import com.example.jong1.core.enums.common.EnumMapperType;
import lombok.RequiredArgsConstructor;

/**
 * 계정 종류
 */

@RequiredArgsConstructor
public enum UserAccountType implements EnumMapperType {
    GUEST("게스트"),
    USER("사용자"),
    ADMIN("관리자");

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
