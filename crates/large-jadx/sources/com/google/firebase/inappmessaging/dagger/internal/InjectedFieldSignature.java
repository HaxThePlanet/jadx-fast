package com.google.firebase.inappmessaging.dagger.internal;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes2.dex */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface InjectedFieldSignature {
    @Override // java.lang.annotation.Annotation
    public abstract String value();
}
