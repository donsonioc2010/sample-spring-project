package com.example.jong1.core.enums.payments;

import com.example.jong1.core.enums.common.EnumMapperType;
import lombok.RequiredArgsConstructor;

/**
 * 결제의 종류에 대한 Enum
 */

@RequiredArgsConstructor
public enum PayType implements EnumMapperType {
    ACCOUNT_TRANSFER("계좌이체"),
    REMITTANCE("무통장입금"),
    TOSS("토스"),
    PAYCO("페이코"),
    CARD("카드"),
    KAKAO_PAY("카카오페이"),
    NAVER_PAY("네이버페이"),
    POINT("포인트"),
    COUPON("쿠폰");

    private final String title;

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
