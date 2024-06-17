package com.example.jong1.core.enums.user;

import com.example.jong1.core.enums.common.EnumMapperType;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 계정 잠김여부 상태값
 */

@RequiredArgsConstructor
public enum UserLockStatus implements EnumMapperType {
    LOCKED("잠김"),
    UNLOCKED("잠김 해제");

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
