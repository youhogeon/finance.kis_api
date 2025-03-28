package com.youhogeon.finance.kis_api.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.youhogeon.finance.kis_api.api.annotation.Seq;

public class ReflectionUtil {

    private static Map<Class<?>, Field[]> fieldsCache = new HashMap<>();
    public static Field[] getAllFields(Class<?> clazz) {
        if (clazz == null) {
            return new Field[0];
        }

        if (fieldsCache.containsKey(clazz)) {
            return fieldsCache.get(clazz);
        }

        Field[] fields = clazz.getDeclaredFields();

        Field[] parentFields = getAllFields(clazz.getSuperclass());

        Field[] allFields = new Field[fields.length + parentFields.length];
        System.arraycopy(fields, 0, allFields, 0, fields.length);
        System.arraycopy(parentFields, 0, allFields, fields.length, parentFields.length);

        fieldsCache.put(clazz, allFields);

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
                    } else if (Number.class.isAssignableFrom(type)) {
                        field.set(obj, new BigDecimal(value));
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

    private static Map<Class<?>, Class<?>> genericCache = new HashMap<>();

    public static <T> Class<T> getGenericParameterType(Object instance) {
        return getGenericParameterType(instance, 0);
    }

    public static <T> Class<T> getGenericParameterType(Object instance, int index) {
        return getGenericParameterType(instance.getClass(), index);
    }

    public static <T> Class<T> getGenericParameterType(Class<?> clazz) {
        return getGenericParameterType(clazz, 0);
    }

    @SuppressWarnings("unchecked")
    public static <T> Class<T> getGenericParameterType(Class<?> clazz, int index) {
        if (genericCache.containsKey(clazz)) {
            return (Class<T>) genericCache.get(clazz);
        }

        Type generic = clazz.getGenericSuperclass();
        if (generic instanceof ParameterizedType) {
            Class<T> type = extractType((ParameterizedType) generic, index);
            if (type != null) {
                genericCache.put(clazz, type);
                return type;
            }
        }

        Type[] interfaces = clazz.getGenericInterfaces();
        for (Type type : interfaces) {
            if (type instanceof ParameterizedType) {
                Class<T> result = extractType((ParameterizedType) type, index);
                if (result != null) {
                    genericCache.put(clazz, result);
                    return result;
                }
            }
        }

        genericCache.put(clazz, null);
        return null;
    }

    @SuppressWarnings("unchecked")
    private static <T> Class<T> extractType(ParameterizedType pt, int index) {
        Type[] typeArgs = pt.getActualTypeArguments();
        if (index < typeArgs.length) {
            Type typeArg = typeArgs[index];
            if (typeArg instanceof Class) {
                return (Class<T>) typeArg;
            } else if (typeArg instanceof ParameterizedType) {
                return (Class<T>) ((ParameterizedType) typeArg).getRawType();
            }
        }
        return null;
    }

    public static Field getFieldFromClassHierarchy(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        Class<?> current = clazz;
        while (current != null) {
            try {
                Field field = current.getDeclaredField(fieldName);
                field.setAccessible(true);

                return field;
            } catch (NoSuchFieldException e) {
                current = current.getSuperclass();
            }
        }

        throw new NoSuchFieldException("Field " + fieldName + " not found in class hierarchy");
    }


}
