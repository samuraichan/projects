package starter.data.entiy.converter;

import javax.persistence.AttributeConverter;

import starter.types.PhoneValueType;

/*
 * register a converter so that we can use the value of the enum which is NOT a String, but could be an ID of some sort
 */
public class PhoneValueTypeConverter implements AttributeConverter<PhoneValueType, Integer> {

  @Override
  public Integer convertToDatabaseColumn(PhoneValueType attribute) {
    if (attribute == null) {
      return null;
    }

    return attribute.getValue();
  }

  @Override
  public PhoneValueType convertToEntityAttribute(Integer dbData) {
    if ( dbData == null ) {
      return null;
    }

    return PhoneValueType.valueOf(dbData);
  }
}
