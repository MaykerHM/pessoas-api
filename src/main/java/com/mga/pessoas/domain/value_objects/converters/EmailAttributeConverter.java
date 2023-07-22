package com.mga.pessoas.domain.value_objects.converters;

import com.mga.pessoas.domain.value_objects.Email;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EmailAttributeConverter implements AttributeConverter<Email, String> {

    @Override
    public Email convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new Email(dbData);
    }

    @Override
    public String convertToDatabaseColumn(Email attribute) {
        return attribute == null ? null : attribute.toString();
    }
}
