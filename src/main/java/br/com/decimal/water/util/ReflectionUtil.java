package br.com.decimal.water.util;

import java.lang.reflect.Field;

public class ReflectionUtil {

	public static Object copyAttributesFromTo(Object dest, Object source) throws IllegalArgumentException, IllegalAccessException {
		Field [] fieldsDest = dest.getClass().getDeclaredFields();
		Field [] fieldsSource = source.getClass().getDeclaredFields();

		for (Field currentFieldFromTheFirstClass : fieldsDest) {
			for (Field currentFieldFromTheSecondClass : fieldsSource) {
				String nameOfTheFirstField = currentFieldFromTheFirstClass.getName();
				String nameOfTheSecondField = currentFieldFromTheSecondClass.getName();
				
				if(currentFieldFromTheSecondClass.toString().contains("static")) {
					continue;
				}
				
				if (nameOfTheFirstField.equals(nameOfTheSecondField)) {
					currentFieldFromTheFirstClass.setAccessible(true);
					currentFieldFromTheSecondClass.setAccessible(true);

					currentFieldFromTheFirstClass.set(dest, currentFieldFromTheSecondClass.get(source));
				}
			}
		}

		return dest;
	}

}
