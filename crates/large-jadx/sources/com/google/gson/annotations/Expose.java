package com.google.gson.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes2.dex */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Expose {
    @Override // java.lang.annotation.Annotation
    public abstract boolean deserialize() default true;

    @Override // java.lang.annotation.Annotation
    public abstract boolean serialize() default true;
}
