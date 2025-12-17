package com.google.firebase.inappmessaging.display.dagger.internal;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* loaded from: classes2.dex */
@Target(ElementType.TYPE)
public @interface ComponentDefinitionType {
    public abstract Class<?> value();
}
