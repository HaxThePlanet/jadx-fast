package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

/* loaded from: classes.dex */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\u0008\u0087\u0002\u0018\u00002\u00020\u0001B(\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003R\u000f\u0010\u0005\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0007R\u000f\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0007R\u000f\u0010\u0006\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/annotation/Size;", "", "value", "", "min", "max", "multiple", "()J", "annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD, AnnotationTarget.ANNOTATION_CLASS})
public @interface Size {
    @Override // java.lang.annotation.Annotation
    public abstract long max() default 9223372036854775807L;

    @Override // java.lang.annotation.Annotation
    public abstract long min() default -9223372036854775808L;

    @Override // java.lang.annotation.Annotation
    public abstract long multiple() default 1L;

    @Override // java.lang.annotation.Annotation
    public abstract long value() default -1L;
}
