package com.googlecode.mp4parser.boxes.mp4.a;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Descriptor.java */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
/* loaded from: classes2.dex */
public @interface g {
    int objectTypeIndication() default -1;

    int[] tags();
}
