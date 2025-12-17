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
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0087\u0002\u0018\u00002\u00020\u0001:\u0002\u000c\rB4\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008R\u0015\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\tR\u0015\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\tR\u000f\u0010\u0007\u001a\u00020\u0008¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\nR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u000b¨\u0006\u000e", d2 = {"Landroidx/annotation/RequiresPermission;", "", "value", "", "allOf", "", "anyOf", "conditional", "", "()[Ljava/lang/String;", "()Z", "()Ljava/lang/String;", "Read", "Write", "annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER})
public @interface RequiresPermission {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\n\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004¨\u0006\u0005", d2 = {"Landroidx/annotation/RequiresPermission$Read;", "", "value", "Landroidx/annotation/RequiresPermission;", "()Landroidx/annotation/RequiresPermission;", "annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.VALUE_PARAMETER})
    public @interface Read {
        @Override // java.lang.annotation.Annotation
        public abstract androidx.annotation.RequiresPermission value() default @RequiresPermission;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\n\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004¨\u0006\u0005", d2 = {"Landroidx/annotation/RequiresPermission$Write;", "", "value", "Landroidx/annotation/RequiresPermission;", "()Landroidx/annotation/RequiresPermission;", "annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.VALUE_PARAMETER})
    public @interface Write {
        @Override // java.lang.annotation.Annotation
        public abstract androidx.annotation.RequiresPermission value() default @RequiresPermission;
    }
    @Override // java.lang.annotation.Annotation
    public abstract String[] allOf() default {};

    @Override // java.lang.annotation.Annotation
    public abstract String[] anyOf() default {};

    @Override // java.lang.annotation.Annotation
    public abstract boolean conditional() default false;

    @Override // java.lang.annotation.Annotation
    public abstract String value() default "";
}
