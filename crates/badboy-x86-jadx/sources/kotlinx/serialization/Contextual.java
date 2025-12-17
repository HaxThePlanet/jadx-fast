package kotlinx.serialization;

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

/* loaded from: classes5.dex */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE_USE)
@Metadata(d1 = "\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002", d2 = {"Lkotlinx/serialization/Contextual;", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Retention(AnnotationRetention.BINARY)
@Target(allowedTargets = {AnnotationTarget.PROPERTY, AnnotationTarget.TYPE})
public @interface Contextual {
}
