package org.jetbrains.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes5.dex */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface Contract {
    @Override // java.lang.annotation.Annotation
    public abstract String mutates() default "";

    @Override // java.lang.annotation.Annotation
    public abstract boolean pure() default false;

    @Override // java.lang.annotation.Annotation
    public abstract String value() default "";
}
