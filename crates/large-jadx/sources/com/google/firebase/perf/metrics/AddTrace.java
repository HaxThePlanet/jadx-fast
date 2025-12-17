package com.google.firebase.perf.metrics;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
@Retention(RetentionPolicy.CLASS)
public @interface AddTrace {
    @Override // java.lang.annotation.Annotation
    public abstract boolean enabled() default true;

    @Override // java.lang.annotation.Annotation
    public abstract String name();
}
