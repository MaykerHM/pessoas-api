package com.mga.pessoas.domain.value_objects.converters;

import com.mga.pessoas.domain.value_objects.Cpf;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CpfAttributeConverter implements AttributeConverter<Cpf, String> {

    @Override
    public Cpf convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new Cpf(dbData);
    }

    @Override
    public String convertToDatabaseColumn(Cpf attribute) {
        return attribute == null ? null : attribute.toString();
    }
}
