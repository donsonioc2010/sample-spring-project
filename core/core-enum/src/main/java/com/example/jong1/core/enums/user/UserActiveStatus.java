package com.example.jong1.core.enums.user;

import com.example.jong1.core.enums.common.EnumMapperType;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 계정의 활성화 여부와 관련한 Enum상태값
 */

@RequiredArgsConstructor
public enum UserActiveStatus implements EnumMapperType {
    INACTIVE("비활성"),
    ACTIVE("활성"),
    PENDING("대기 중"),
    LEAVE("탈퇴");

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
