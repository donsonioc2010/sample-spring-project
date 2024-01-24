package com.example.jong1.core.api.controller.v1.request;

import com.example.jong1.core.api.domain.ExampleData;

public record ExampleRequestDto(String data) {
    public ExampleData toExampleData() {
        return new ExampleData(data, data);
    }
}
