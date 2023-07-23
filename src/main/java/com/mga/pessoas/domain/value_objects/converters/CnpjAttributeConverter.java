package com.mga.pessoas.domain.value_objects.converters;

import com.mga.pessoas.domain.value_objects.Cnpj;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply=true)
public class CnpjAttributeConverter implements AttributeConverter<Cnpj, String> {

    @Override
    public Cnpj convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new Cnpj(dbData);
    }

    @Override
    public String convertToDatabaseColumn(Cnpj attribute) {
        return attribute == null ? null : attribute.getCnpj();
    }
}
