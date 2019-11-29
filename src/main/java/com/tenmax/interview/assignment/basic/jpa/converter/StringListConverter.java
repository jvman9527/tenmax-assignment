package com.tenmax.interview.assignment.basic.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 將字串清單轉換成逗號分隔值
 */
@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    public static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return String.join(SEPARATOR, attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return arrayToList(dbData.split(SEPARATOR));
    }

    private List<String> arrayToList(String[] stringArray) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, stringArray);
        return list;
    }

}

