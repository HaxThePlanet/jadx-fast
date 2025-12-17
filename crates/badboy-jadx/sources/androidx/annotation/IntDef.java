package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

/* loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.ANNOTATION_TYPE)
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\"\u0012\u000c\u0008\u0002\u0010\u0002\u001a\u00020\u0003\"\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006R\u000f\u0010\u0005\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0008R\u000f\u0010\u0007\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\t¨\u0006\n", d2 = {"Landroidx/annotation/IntDef;", "", "value", "", "", "flag", "", "open", "()Z", "()[I", "annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@Target(allowedTargets = AnnotationTarget.ANNOTATION_CLASS)
public @interface IntDef {
    @Override // java.lang.annotation.Annotation
    public abstract boolean flag() default false;

    @Override // java.lang.annotation.Annotation
    public abstract boolean open() default false;

    @Override // java.lang.annotation.Annotation
    public abstract int[] value() default {};
}
