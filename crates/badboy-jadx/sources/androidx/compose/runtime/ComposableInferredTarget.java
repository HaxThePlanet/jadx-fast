package androidx.compose.runtime;

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
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\u0008\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004¨\u0006\u0005", d2 = {"Landroidx/compose/runtime/ComposableInferredTarget;", "", "scheme", "", "()Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Retention(AnnotationRetention.BINARY)
@Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER})
public @interface ComposableInferredTarget {
    @Override // java.lang.annotation.Annotation
    public abstract String scheme();
}
