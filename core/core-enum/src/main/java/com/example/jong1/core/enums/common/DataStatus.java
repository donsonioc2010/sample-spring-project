package com.example.jong1.core.enums.common;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DataStatus implements EnumMapperType {
    USE("사용"),
    DEL("삭제");

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
