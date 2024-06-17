package com.example.jong1.core.enums.user;

import com.example.jong1.core.enums.common.EnumMapperType;
import lombok.RequiredArgsConstructor;

/**
 * 구독 여부 상태값
 */

@RequiredArgsConstructor
public enum SubscriptionStatus implements EnumMapperType {
    SUBSCRIBED("구독중"),
    UNSUBSCRIBED("비구독중"),
    TRIAL("체험판");

    private final String value;

    @Override
    public String getCode() {
        return "";
    }

    @Override
    public String getTitle() {
        return "";
    }
}
