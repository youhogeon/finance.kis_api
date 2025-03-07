package com.youhogeon.finance.kis_api.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionUtil {

    public static Field[] getAllFields(Class<?> clazz) {
        if (clazz == null) {
            return new Field[0];
        }

        Field[] fields = clazz.getDeclaredFields();

        Field[] parentFields = getAllFields(clazz.getSuperclass());

        Field[] allFields = new Field[fields.length + parentFields.length];
        System.arraycopy(fields, 0, allFields, 0, fields.length);
        System.arraycopy(parentFields, 0, allFields, fields.length, parentFields.length);

        return allFields;
    }

    public static List<Field> getAllFieldsByAnnotation(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        Field[] allFields = getAllFields(clazz);

        List<Field> annotatedFields = new ArrayList<>();

        for (Field field : allFields) {
            Annotation annotation = field.getAnnotation(annotationClass);

            if (annotation == null) {
                continue;
            }

            annotatedFields.add(field);
        }

        return annotatedFields;
    }

    public static boolean compareAnnotation(Annotation annotation, Class<? extends Annotation> annotationClass, Object... expectedValues) {
        if (annotation == null) {
            return false;
        }

        if (annotation.annotationType() != annotationClass) {
            return false;
        }

        try {
            Method[] methods = annotationClass.getDeclaredMethods();
            if (methods.length != expectedValues.length) {
                return false;
            }

            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];

                if (method.getParameterCount() != 0) {
                    return false; // ApiData는 파라미터 있는 메서드 불허
                }

                Object actualValue = method.invoke(annotation);

                if (actualValue instanceof Object[] && expectedValues[i] instanceof Object[]) {
                    if (!Arrays.equals((Object[]) actualValue, (Object[]) expectedValues[i])) {
                        return false;
                    }
                } else {
                    if (!actualValue.equals(expectedValues[i])) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {

        }

        return true;
    }

}
