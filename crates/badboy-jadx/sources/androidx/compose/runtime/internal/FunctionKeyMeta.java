package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Repeatable;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.internal.RepeatableContainer;

/* loaded from: classes.dex */
@ComposeCompilerApi
@Repeatable(FunctionKeyMeta$Container.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003R\u000f\u0010\u0005\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/runtime/internal/FunctionKeyMeta;", "", "key", "", "startOffset", "endOffset", "()I", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(allowedTargets = AnnotationTarget.CLASS)
public @interface FunctionKeyMeta {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @Retention(AnnotationRetention.RUNTIME)
    @Target(allowedTargets = AnnotationTarget.CLASS)
    @RepeatableContainer
    public @interface Container {
        @Override // java.lang.annotation.Annotation
        public abstract androidx.compose.runtime.internal.FunctionKeyMeta[] value();
    }
    @Override // java.lang.annotation.Annotation
    public abstract int endOffset();

    @Override // java.lang.annotation.Annotation
    public abstract int key();

    @Override // java.lang.annotation.Annotation
    public abstract int startOffset();
}
