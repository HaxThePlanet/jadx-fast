package com.google.firebase.inappmessaging.dagger.multibindings;

import com.google.firebase.inappmessaging.dagger.MapKey;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes2.dex */
@MapKey
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IntKey {
    @Override // java.lang.annotation.Annotation
    public abstract int value();
}
