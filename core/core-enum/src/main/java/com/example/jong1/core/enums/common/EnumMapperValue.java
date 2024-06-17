package com.example.jong1.core.enums.common;

import lombok.Getter;

/**
 * EnumMapperType을 변환한다.
 */

@Getter
public class EnumMapperValue {

    private String code;
    private String title;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        this.code = enumMapperType.getCode();
        this.title = enumMapperType.getTitle();
    }

    @Override
    public String toString() {
        return String.format("""
            {
                "code" : %s,
                "title" : %s
            }""", code, title
        );

    }
}
