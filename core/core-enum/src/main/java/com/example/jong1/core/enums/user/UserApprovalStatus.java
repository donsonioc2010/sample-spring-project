package com.example.jong1.core.enums.user;

import com.example.jong1.core.enums.common.EnumMapperType;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 계정의 승인 상태 여부 종류 상태값
 */

@RequiredArgsConstructor
public enum UserApprovalStatus implements EnumMapperType {
    APPROVED("승인됨"),
    REJECTED("거절됨"),
    PENDING_APPROVAL("승인 대기 중");

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
