package kotlinx.serialization.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005H\u0001\u001a \u0010\u0000\u001a\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005H\u0001¨\u0006\u0007", d2 = {"throwSubtypeNotRegistered", "", "subClassName", "", "baseClass", "Lkotlin/reflect/KClass;", "subClass", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AbstractPolymorphicSerializerKt {
    public static final Void throwSubtypeNotRegistered(String subClassName, KClass<?> baseClass) {
        String string;
        int str;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = stringBuilder.append("in the polymorphic scope of '").append(baseClass.getSimpleName()).append('\'').toString();
        if (subClassName == null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            string = stringBuilder2.append("Class discriminator was missing and no default serializers were registered ").append(string2).append('.').toString();
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            string = stringBuilder3.append("Serializer for subclass '").append(subClassName).append("' is not found ").append(string2).append(".\nCheck if class with serial name '").append(subClassName).append("' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '").append(subClassName).append("' has to be '@Serializable', and the base class '").append(baseClass.getSimpleName()).append("' has to be sealed and '@Serializable'.").toString();
        }
        SerializationException serializationException = new SerializationException(string);
        throw serializationException;
    }

    public static final Void throwSubtypeNotRegistered(KClass<?> subClass, KClass<?> baseClass) {
        String simpleName;
        Intrinsics.checkNotNullParameter(subClass, "subClass");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        if (subClass.getSimpleName() != null) {
        } else {
            simpleName = String.valueOf(subClass);
        }
        AbstractPolymorphicSerializerKt.throwSubtypeNotRegistered(simpleName, baseClass);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }
}
