package kotlinx.serialization;

import java.lang.annotation.Annotation;
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
@Target({})
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0002\u0018\u00002\u00020\u0001B,\u0012*\u0010\u0002\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00050\u00040\u0003\"\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00050\u0004R#\u0010\u0002\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00050\u00040\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlinx/serialization/UseSerializers;", "", "serializerClasses", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "()[Ljava/lang/Class;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Retention(AnnotationRetention.BINARY)
@Target(allowedTargets = AnnotationTarget.FILE)
public @interface UseSerializers {
    public abstract Class<? extends kotlinx.serialization.KSerializer<?>>[] serializerClasses();
}
