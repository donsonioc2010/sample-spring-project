package com.example.jong1.core.enums.user;

import com.example.jong1.core.enums.common.EnumMapperType;
import lombok.RequiredArgsConstructor;

/**
 * 어떤 종류의 OAuth 가입자 Enum
 */

@RequiredArgsConstructor
public enum OAuthType implements EnumMapperType {
    SITE("사이트"),
    KAKAO("카카오"),
    NAVER("네이버"),
    FACEBOOK("페이스북"),
    INSTAGRAM("인스타그램"),
    APPLE("애플"),
    GOOGLE("구글");

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
