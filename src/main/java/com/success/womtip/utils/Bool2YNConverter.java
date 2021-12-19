package com.success.womtip.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class Bool2YNConverter implements AttributeConverter<Boolean, String> {

    /**
     * Boolean 값을 Y 또는 N 으로 컨버트
     *
     * @param attribute boolean 값
     * @return String true 인 경우 Y 또는 false 인 경우 N
     **/

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? "Y" : "N";
    }

    /**
     * Y 또는 N 값을 Boolean 으로 컨버트
     *
     * @param dbData Y 또는  N
     * @return Boolean 대소문자 상관없이 Y 인 경우 true, N 인 경우 false
     **/

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Y".equalsIgnoreCase(dbData);
    }
}
