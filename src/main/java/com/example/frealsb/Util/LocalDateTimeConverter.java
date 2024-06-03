package com.example.frealsb.Util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Converter
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime entityValue) {
        if (entityValue != null) {
            return Date.from(entityValue.atZone(ZoneId.systemDefault()).toInstant());
        }
        return null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date databaseValue) {
        if (databaseValue != null) {
            return LocalDateTime.ofInstant(databaseValue.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }
}
