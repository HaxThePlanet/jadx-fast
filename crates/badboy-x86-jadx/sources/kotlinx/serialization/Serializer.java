package kotlinx.serialization;

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

/* loaded from: classes5.dex */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\u000c\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004¨\u0006\u0005", d2 = {"Lkotlinx/serialization/Serializer;", "", "forClass", "Lkotlin/reflect/KClass;", "()Ljava/lang/Class;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(allowedTargets = AnnotationTarget.CLASS)
@ExperimentalSerializationApi
public @interface Serializer {
    public abstract Class<?> forClass();
}
