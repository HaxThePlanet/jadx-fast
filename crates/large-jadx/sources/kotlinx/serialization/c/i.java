package kotlinx.serialization.c;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000V\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\u001a\u0012\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007*\u00020\u0002H\u0000\u001a\u001d\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\u0008\u0000\u0010\u000b*\u0006\u0012\u0002\u0008\u00030\nH\u0081\u0008\u001a\u001d\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u000c\"\u0004\u0008\u0000\u0010\u000b*\u0006\u0012\u0002\u0008\u00030\u000cH\u0081\u0008\u001a\u001d\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r\"\u0004\u0008\u0000\u0010\u000b*\u0006\u0012\u0002\u0008\u00030\rH\u0081\u0008\u001a\u001f\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0000¢\u0006\u0002\u0010\u0010\u001a6\u0010\u0011\u001a\u00020\u0012\"\u0004\u0008\u0000\u0010\u000b\"\u0004\u0008\u0001\u0010\u0013*\u0008\u0012\u0004\u0012\u0002H\u000b0\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00130\u0016H\u0080\u0008ø\u0001\u0000\u001a\u0012\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0018*\u00020\u001aH\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u001c*\u0006\u0012\u0002\u0008\u00030\u0018H\u0000\"\u001e\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00018\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u0005\u0012\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u001d", d2 = {"EMPTY_DESCRIPTOR_ARRAY", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getEMPTY_DESCRIPTOR_ARRAY$annotations", "()V", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "cachedSerialNames", "", "", "cast", "Lkotlinx/serialization/DeserializationStrategy;", "T", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/SerializationStrategy;", "compactArray", "", "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsHashCodeBy", "", "K", "", "selector", "Lkotlin/Function1;", "kclass", "Lkotlin/reflect/KClass;", "", "Lkotlin/reflect/KType;", "serializerNotRegistered", "", "kotlinx-serialization-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class i {

    private static final SerialDescriptor[] a;
    static {
        i.a = new SerialDescriptor[0];
    }

    public static final SerialDescriptor[] a(List<? extends SerialDescriptor> list) {
        String str;
        int i2;
        boolean empty;
        Object[] i;
        int obj3;
        str = 0;
        if (list != null) {
            if (list.isEmpty()) {
                i2 = 1;
            } else {
                i2 = str;
            }
        } else {
        }
        if (i2 == 0) {
        } else {
            obj3 = i;
        }
        if (obj3 == null) {
        } else {
            obj3 = obj3.toArray(new SerialDescriptor[str]);
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Array<T>");
            i = obj3;
        }
        if (i == null) {
            i = i.a;
        }
        return i;
    }
}
