package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0000\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u000c\u0010\u000c\u001a\u00020\u0007*\u00020\u0007H\u0002\u001a$\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\u000e\u0018\u00010\u0003\"\u0008\u0008\u0000\u0010\u000e*\u00020\u000f*\u0008\u0012\u0004\u0012\u0002H\u000e0\u0002H\u0000\"\"\u0010\u0000\u001a\u0016\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0002\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"BUILTIN_SERIALIZERS", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "PrimitiveDescriptorSafe", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "checkName", "", "capitalize", "builtinSerializerOrNull", "T", "", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PrimitivesKt {

    private static final Map<KClass<?>, KSerializer<?>> BUILTIN_SERIALIZERS;
    static {
        PrimitivesKt.BUILTIN_SERIALIZERS = PlatformKt.initBuiltins();
    }

    public static final SerialDescriptor PrimitiveDescriptorSafe(String serialName, PrimitiveKind kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        PrimitivesKt.checkName(serialName);
        PrimitiveSerialDescriptor primitiveSerialDescriptor = new PrimitiveSerialDescriptor(serialName, kind);
        return (SerialDescriptor)primitiveSerialDescriptor;
    }

    public static final <T> KSerializer<T> builtinSerializerOrNull(KClass<T> $this$builtinSerializerOrNull) {
        Intrinsics.checkNotNullParameter($this$builtinSerializerOrNull, "<this>");
        return (KSerializer)PrimitivesKt.BUILTIN_SERIALIZERS.get($this$builtinSerializerOrNull);
    }

    private static final String capitalize(String $this$capitalize) {
        int i2;
        String string;
        int substring;
        int str;
        int i;
        String valueOf;
        substring = 1;
        str = 0;
        i2 = (CharSequence)$this$capitalize.length() > 0 ? substring : str;
        if (i2 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            char charAt = $this$capitalize.charAt(str);
            i = 0;
            if (Character.isLowerCase(charAt)) {
                valueOf = CharsKt.titlecase(charAt);
            } else {
                valueOf = String.valueOf(charAt);
            }
            substring = $this$capitalize.substring(substring);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            string = stringBuilder.append((CharSequence)valueOf).append(substring).toString();
        } else {
            string = $this$capitalize;
        }
        return string;
    }

    private static final void checkName(String serialName) {
        Object next;
        String serialName2;
        boolean equal;
        Iterator iterator = PrimitivesKt.BUILTIN_SERIALIZERS.values().iterator();
        for (KSerializer next : iterator) {
        }
    }
}
