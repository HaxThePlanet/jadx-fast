package kotlinx.serialization.modules;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006B!\u0008\u0010\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0008\u0012\n\u0010\t\u001a\u0006\u0012\u0002\u0008\u00030\u0008¢\u0006\u0004\u0008\u0005\u0010\n¨\u0006\u000b", d2 = {"Lkotlinx/serialization/modules/SerializerAlreadyRegisteredException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "msg", "", "<init>", "(Ljava/lang/String;)V", "baseClass", "Lkotlin/reflect/KClass;", "concreteClass", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SerializerAlreadyRegisteredException extends java.lang.IllegalArgumentException {
    public SerializerAlreadyRegisteredException(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        super(msg);
    }

    public SerializerAlreadyRegisteredException(KClass<?> baseClass, KClass<?> concreteClass) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(concreteClass, "concreteClass");
        StringBuilder stringBuilder = new StringBuilder();
        super(stringBuilder.append("Serializer for ").append(concreteClass).append(" already registered in the scope of ").append(baseClass).toString());
    }
}
