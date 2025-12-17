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
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE, ElementType.TYPE, ElementType.PACKAGE})
public @interface Nls {

    public static enum Capitalization {

        NotSpecified,
        Title,
        Sentence;
    }
    @Override // java.lang.annotation.Annotation
    public abstract org.jetbrains.annotations.Nls.Capitalization capitalization() default Nls$Capitalization.NotSpecified;
}
