package com.youhogeon.finance.kis_api.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AnnotationUtil {
    public static Set<Annotation> getAllAnnotations(Class<?> clazz) {
        Set<Annotation> annotations = new HashSet<>();
        collectAnnotations(clazz, annotations);
        return annotations;
    }

    private static void collectAnnotations(Class<?> clazz, Set<Annotation> annotations) {
        for (Annotation annotation : clazz.getAnnotations()) {
            if (annotations.add(annotation)) {
                collectAnnotations(annotation.annotationType(), annotations);
            }
        }
    }

    public static boolean contains(Annotation[] annotations, Class<? extends Annotation> annotationClass) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(annotationClass)) {
                return true;
            }
        }

        return false;
    }

    public static boolean contains(Annotation[] annotations, Class<? extends Annotation> annotationClass, Object... expectedValues) {
        for (Annotation annotation : annotations) {
            if (compareAnnotation(annotation, annotationClass, expectedValues)) {
                return true;
            }
        }

        return false;
    }

    public static <T extends Annotation> List<T> getAnnotations(Annotation[] annotations, Class<T> annotationClass) {
        List<T> result = new ArrayList<>();

        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(annotationClass)) {
                @SuppressWarnings("unchecked")
                T t = (T)annotation;

                result.add(t);
            }
        }

        return result;
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
