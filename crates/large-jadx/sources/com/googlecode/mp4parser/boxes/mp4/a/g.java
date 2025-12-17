package com.googlecode.mp4parser.boxes.mp4.a;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes2.dex */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface g {
    @Override // java.lang.annotation.Annotation
    public abstract int objectTypeIndication() default -1;

    @Override // java.lang.annotation.Annotation
    public abstract int[] tags();
}
