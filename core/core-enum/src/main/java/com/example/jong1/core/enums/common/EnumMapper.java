package com.example.jong1.core.enums.common;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EnumMapper {

    private final Map<String, List<EnumMapperValue>> factory = new LinkedHashMap<>();

    public void put(Class<? extends EnumMapperType> elementList) {
        factory.put(elementList.getSimpleName(), toEnumValues(elementList));
    }

    public void put(String key, Class<? extends EnumMapperType> elementList) {
        factory.put(key, toEnumValues(elementList));
    }

    private List<EnumMapperValue> toEnumValues(Class<? extends EnumMapperType> elementList) {
        return Arrays.stream(elementList.getEnumConstants())
            .map(EnumMapperValue::new)
            .toList();
    }

    public List<EnumMapperValue> get(String key) {
        return factory.get(key);
    }

    public Map<String, List<EnumMapperValue>> get(List<String> keys) {
        if (keys == null || keys.isEmpty()) {
            return new LinkedHashMap<>();
        }
        return keys.stream()
            .collect(Collectors.toMap(Function.identity(), factory::get));
    }

    public Set<String> getKeySet() {
        return factory.keySet();
    }

    public Map<String, List<EnumMapperValue>> getAll() {
        return factory;
    }
}
