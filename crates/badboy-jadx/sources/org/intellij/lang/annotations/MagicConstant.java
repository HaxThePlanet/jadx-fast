package org.intellij.lang.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes5.dex */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
public @interface MagicConstant {
    @Override // java.lang.annotation.Annotation
    public abstract long[] flags() default {};

    public abstract Class<?> flagsFromClass() default V.class;

    @Override // java.lang.annotation.Annotation
    public abstract long[] intValues() default {};

    @Override // java.lang.annotation.Annotation
    public abstract String[] stringValues() default {};

    public abstract Class<?> valuesFromClass() default V.class;
}
