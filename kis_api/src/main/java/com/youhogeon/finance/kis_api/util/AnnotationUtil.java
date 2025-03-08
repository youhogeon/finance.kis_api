package com.youhogeon.finance.kis_api.util;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
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
            if (ReflectionUtil.compareAnnotation(annotation, annotationClass, expectedValues)) {
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

}
