package androidx.compose.ui.tooling.preview;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Repeatable;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.internal.RepeatableContainer;

/* loaded from: classes.dex */
@Documented
@Repeatable(Preview$Container.class)
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\t\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\u0082\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0003\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003\u0012\u0008\u0008\u0003\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0006R\u000f\u0010\u0005\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0014R\u000f\u0010\u000f\u001a\u00020\u0010¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0015R\u000f\u0010\u0012\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0016R\u000f\u0010\n\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0017R\u000f\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0016R\u000f\u0010\u0008\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0014R\u000f\u0010\t\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0016R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0016R\u000f\u0010\u000e\u001a\u00020\r¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0018R\u000f\u0010\u000c\u001a\u00020\r¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u0018R\u000f\u0010\u0011\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0014R\u000f\u0010\u0013\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000f\u0010\u0007\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0014¨\u0006\u0019", d2 = {"Landroidx/compose/ui/tooling/preview/Preview;", "", "name", "", "group", "apiLevel", "", "widthDp", "heightDp", "locale", "fontScale", "", "showSystemUi", "", "showBackground", "backgroundColor", "", "uiMode", "device", "wallpaper", "()I", "()J", "()Ljava/lang/String;", "()F", "()Z", "ui-tooling-preview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@MustBeDocumented
@Repeatable
@Retention(AnnotationRetention.BINARY)
@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION})
public @interface Preview {

    @Retention(RetentionPolicy.CLASS)
    @Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @Retention(AnnotationRetention.BINARY)
    @Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION})
    @RepeatableContainer
    public @interface Container {
        @Override // java.lang.annotation.Annotation
        public abstract androidx.compose.ui.tooling.preview.Preview[] value();
    }
    @Override // java.lang.annotation.Annotation
    public abstract int apiLevel() default -1;

    @Override // java.lang.annotation.Annotation
    public abstract long backgroundColor() default 0L;

    @Override // java.lang.annotation.Annotation
    public abstract String device() default "";

    @Override // java.lang.annotation.Annotation
    public abstract float fontScale() default 1f;

    @Override // java.lang.annotation.Annotation
    public abstract String group() default "";

    @Override // java.lang.annotation.Annotation
    public abstract int heightDp() default -1;

    @Override // java.lang.annotation.Annotation
    public abstract String locale() default "";

    @Override // java.lang.annotation.Annotation
    public abstract String name() default "";

    @Override // java.lang.annotation.Annotation
    public abstract boolean showBackground() default false;

    @Override // java.lang.annotation.Annotation
    public abstract boolean showSystemUi() default false;

    @Override // java.lang.annotation.Annotation
    public abstract int uiMode() default 0;

    @Override // java.lang.annotation.Annotation
    public abstract int wallpaper() default -1;

    @Override // java.lang.annotation.Annotation
    public abstract int widthDp() default -1;
}
