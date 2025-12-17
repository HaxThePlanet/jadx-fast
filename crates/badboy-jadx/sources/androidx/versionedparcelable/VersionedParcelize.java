package androidx.versionedparcelable;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes5.dex */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface VersionedParcelize {
    @Override // java.lang.annotation.Annotation
    public abstract boolean allowSerialization() default false;

    @Override // java.lang.annotation.Annotation
    public abstract int[] deprecatedIds() default {};

    @Override // java.lang.annotation.Annotation
    public abstract Class factory() default V.class;

    @Override // java.lang.annotation.Annotation
    public abstract boolean ignoreParcelables() default false;

    @Override // java.lang.annotation.Annotation
    public abstract boolean isCustom() default false;

    @Override // java.lang.annotation.Annotation
    public abstract String jetifyAs() default "";
}
