package com.youhogeon.finance.kis_api.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
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

}
