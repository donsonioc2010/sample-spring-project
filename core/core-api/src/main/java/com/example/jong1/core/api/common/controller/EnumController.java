package com.example.jong1.core.api.common.controller;

import com.example.jong1.core.enums.common.EnumMapper;
import com.example.jong1.core.enums.common.EnumMapperValue;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enum")
public class EnumController {

    private final EnumMapper enumMapper;

    @GetMapping("/all")
    public ResponseEntity<Map<String, List<EnumMapperValue>>> fetchEnumAllMap() {
        return ResponseEntity.ok(enumMapper.getAll());
    }
}
