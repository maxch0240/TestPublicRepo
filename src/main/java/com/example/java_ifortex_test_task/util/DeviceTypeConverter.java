package com.example.java_ifortex_test_task.util;

import com.example.java_ifortex_test_task.entity.DeviceType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

//В связи с тем что Hibernate по умолчанию пытается преобразовывать числовые значения из БД в enum,
//используя их порядковый номер (метод ordinal()), что эквивалентно индексу в массиве значений enum (0, 1)
//Мной было решено отойти от условий задачи и добавить свой конвертер для более корректной работы
@Converter(autoApply = true)
public class DeviceTypeConverter implements AttributeConverter<DeviceType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(DeviceType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public DeviceType convertToEntityAttribute(Integer dbValue) {
        if (dbValue == null) {
            return null;
        }
        return DeviceType.fromCode(dbValue);
    }
}
