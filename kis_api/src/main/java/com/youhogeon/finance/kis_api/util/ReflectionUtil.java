package com.youhogeon.finance.kis_api.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.youhogeon.finance.kis_api.api.annotation.Seq;

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

    public static List<Field> getSortedSeqFields(Class<?> clazz) {
        List<Field> seqFields = new ArrayList<>();
        Class<?> current = clazz;

        while (current != null) {
            for (Field field : current.getDeclaredFields()) {
                if (field.isAnnotationPresent(Seq.class)) {
                    seqFields.add(field);
                }
            }
            current = current.getSuperclass();
        }

        seqFields.sort(Comparator.comparingInt(field -> field.getAnnotation(Seq.class).value()));

        return seqFields;
    }

    public static <T> T[] createObjects(String[][] body, Class<T> dataType) {
        List<Field> sortedFields = ReflectionUtil.getSortedSeqFields(dataType);

        @SuppressWarnings("unchecked")
        T[] objects = (T[]) Array.newInstance(dataType, body.length);

        for (int i = 0; i < body.length; i++) {
            String[] row = body[i];
            T obj;
            try {
                obj = dataType.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Could not create instance of " + dataType.getName() + " class", e);
            }

            for (int j = 0; j < sortedFields.size() && j < row.length; j++) {
                Field field = sortedFields.get(j);
                field.setAccessible(true);
                String value = row[j];

                try {
                    Class<?> type = field.getType();
                    if (type.equals(String.class)) {
                        field.set(obj, value);
                    } else if (type.equals(int.class) || type.equals(Integer.class)) {
                        field.set(obj, Integer.parseInt(value));
                    } else if (type.equals(long.class) || type.equals(Long.class)) {
                        field.set(obj, Long.parseLong(value));
                    } else if (type.equals(double.class) || type.equals(Double.class)) {
                        field.set(obj, Double.parseDouble(value));
                    } else {
                        field.set(obj, value);
                    }
                } catch (IllegalAccessException | NumberFormatException e) {
                    throw new RuntimeException("필드 주입 실패", e);
                }
            }
            objects[i] = obj;
        }

        return objects;
    }

}
