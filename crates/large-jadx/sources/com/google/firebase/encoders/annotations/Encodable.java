package com.google.firebase.encoders.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes2.dex */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Encodable {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Field {
        @Override // java.lang.annotation.Annotation
        public abstract boolean inline() default false;

        @Override // java.lang.annotation.Annotation
        public abstract String name() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Ignore {
    }
}
