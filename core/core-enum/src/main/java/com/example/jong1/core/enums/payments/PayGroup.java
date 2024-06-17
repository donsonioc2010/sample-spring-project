package com.example.jong1.core.enums.payments;

import com.example.jong1.core.enums.common.EnumMapperType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 결제방식 그룹화
 */
@Getter
@RequiredArgsConstructor
public enum PayGroup implements EnumMapperType {
    CASH("현금", Arrays.asList(PayType.ACCOUNT_TRANSFER, PayType.REMITTANCE, PayType.TOSS)),
    CARD("카드", Arrays.asList(PayType.KAKAO_PAY, PayType.NAVER_PAY, PayType.CARD, PayType.PAYCO)),
    ETC("기타", Arrays.asList(PayType.POINT, PayType.COUPON)),
    EMPTY("없음", Collections.EMPTY_LIST);

    private final String title;
    private final List<PayType> payList;

    public static PayGroup findByPayType(PayType payType) {
        return Arrays.stream(PayGroup.values())
            .filter(payGroup -> payGroup.hasPayCode(payType))
            .findAny()
            .orElse(EMPTY);
    }

    public boolean hasPayCode(PayType payType) {
        return payList.stream()
            .anyMatch(pay -> pay.equals(payType));
    }


    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }

}
