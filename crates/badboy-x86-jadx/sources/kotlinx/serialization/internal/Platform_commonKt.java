package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000^\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000\u001a\u001f\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0008H\u0000¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0\u000b\"\u0004\u0008\u0000\u0010\u000c*\u0006\u0012\u0002\u0008\u00030\u000bH\u0081\u0008\u001a\u001d\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0\r\"\u0004\u0008\u0000\u0010\u000c*\u0006\u0012\u0002\u0008\u00030\rH\u0081\u0008\u001a\u001d\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0\u000e\"\u0004\u0008\u0000\u0010\u000c*\u0006\u0012\u0002\u0008\u00030\u000eH\u0081\u0008\u001a\u0010\u0010\u000f\u001a\u00020\u0010*\u0006\u0012\u0002\u0008\u00030\u0011H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u0002*\u0006\u0012\u0002\u0008\u00030\u0011H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0000\u001a\u0012\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0011*\u00020\u0016H\u0000\u001a\u000c\u0010\u0017\u001a\u00020\u0016*\u00020\u0018H\u0000\u001a6\u0010\u0019\u001a\u00020\u001a\"\u0004\u0008\u0000\u0010\u000c\"\u0004\u0008\u0001\u0010\u001b*\u0008\u0012\u0004\u0012\u0002H\u000c0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\u001b0\u001eH\u0080\u0008ø\u0001\u0000\"\u0016\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u001f", d2 = {"cachedSerialNames", "", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "EMPTY_DESCRIPTOR_ARRAY", "", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "compactArray", "", "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "cast", "Lkotlinx/serialization/KSerializer;", "T", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/DeserializationStrategy;", "serializerNotRegistered", "", "Lkotlin/reflect/KClass;", "notRegisteredMessage", "className", "kclass", "", "Lkotlin/reflect/KType;", "typeOrThrow", "Lkotlin/reflect/KTypeProjection;", "elementsHashCodeBy", "", "K", "", "selector", "Lkotlin/Function1;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Platform_commonKt {

    private static final SerialDescriptor[] EMPTY_DESCRIPTOR_ARRAY;
    static {
        Platform_commonKt.EMPTY_DESCRIPTOR_ARRAY = new SerialDescriptor[0];
    }

    public static final Set<String> cachedSerialNames(SerialDescriptor $this$cachedSerialNames) {
        int i;
        HashSet set;
        String elementName;
        Intrinsics.checkNotNullParameter($this$cachedSerialNames, "<this>");
        if ($this$cachedSerialNames instanceof CachedNames) {
            return (CachedNames)$this$cachedSerialNames.getSerialNames();
        }
        HashSet hashSet = new HashSet($this$cachedSerialNames.getElementsCount());
        i = 0;
        while (i < $this$cachedSerialNames.getElementsCount()) {
            (Collection)hashSet.add($this$cachedSerialNames.getElementName(i));
            i++;
        }
        return (Set)hashSet;
    }

    public static final <T> DeserializationStrategy<T> cast(DeserializationStrategy<?> $this$cast) {
        Intrinsics.checkNotNullParameter($this$cast, "<this>");
        int i = 0;
        return $this$cast;
    }

    public static final <T> KSerializer<T> cast(KSerializer<?> $this$cast) {
        Intrinsics.checkNotNullParameter($this$cast, "<this>");
        int i = 0;
        return $this$cast;
    }

    public static final <T> SerializationStrategy<T> cast(SerializationStrategy<?> $this$cast) {
        Intrinsics.checkNotNullParameter($this$cast, "<this>");
        int i = 0;
        return $this$cast;
    }

    public static final SerialDescriptor[] compactArray(List<? extends SerialDescriptor> $this$compactArray) {
        int $this$toTypedArray$iv;
        int i2;
        int i;
        boolean empty;
        int arr;
        i2 = 0;
        empty = i3;
        arr = 0;
        if ((Collection)empty) {
            if ((Collection)empty.isEmpty()) {
                i = 1;
            } else {
                i = arr;
            }
        } else {
        }
        $this$toTypedArray$iv = i == 0 ? $this$compactArray : 0;
        if ($this$toTypedArray$iv != 0) {
            i2 = 0;
            if ((SerialDescriptor[])(Collection)$this$toTypedArray$iv.toArray(new SerialDescriptor[arr]) == null) {
                $this$toTypedArray$iv = Platform_commonKt.EMPTY_DESCRIPTOR_ARRAY;
            }
        } else {
        }
        return $this$toTypedArray$iv;
    }

    public static final <T, K> int elementsHashCodeBy(Iterable<? extends T> $this$elementsHashCodeBy, Function1<? super T, ? extends K> selector) {
        int accumulator$iv;
        Object next;
        int i4;
        Object obj;
        int i3;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$elementsHashCodeBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i5 = 0;
        final int i7 = 0;
        accumulator$iv = i6;
        final Iterator iterator = $this$elementsHashCodeBy.iterator();
        while (iterator.hasNext()) {
            i3 = 0;
            Object invoke = selector.invoke(iterator.next());
            if (invoke != null) {
            } else {
            }
            i2 = 0;
            accumulator$iv = i;
            i2 = invoke.hashCode();
        }
        return accumulator$iv;
    }

    public static final KClass<Object> kclass(KType $this$kclass) {
        Intrinsics.checkNotNullParameter($this$kclass, "<this>");
        kotlin.reflect.KClassifier classifier = $this$kclass.getClassifier();
        if (classifier instanceof KClass) {
            return (KClass)classifier;
        }
        if (classifier instanceof KTypeParameter) {
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Captured type parameter ").append(classifier).append(" from generic non-reified function. Such functionality cannot be supported because ").append(classifier).append(" is erased, either specify serializer explicitly or make calling function inline with reified ").append(classifier).append('.').toString());
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Only KClass supported as classifier, got ").append(classifier).toString());
        throw illegalArgumentException2;
    }

    public static final String notRegisteredMessage(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Serializer for class '").append(className).append("' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n").toString();
    }

    public static final String notRegisteredMessage(KClass<?> $this$notRegisteredMessage) {
        String simpleName;
        Intrinsics.checkNotNullParameter($this$notRegisteredMessage, "<this>");
        if ($this$notRegisteredMessage.getSimpleName() == null) {
            simpleName = "<local class name not available>";
        }
        return Platform_commonKt.notRegisteredMessage(simpleName);
    }

    public static final Void serializerNotRegistered(KClass<?> $this$serializerNotRegistered) {
        Intrinsics.checkNotNullParameter($this$serializerNotRegistered, "<this>");
        SerializationException serializationException = new SerializationException(Platform_commonKt.notRegisteredMessage($this$serializerNotRegistered));
        throw serializationException;
    }

    public static final KType typeOrThrow(KTypeProjection $this$typeOrThrow) {
        Intrinsics.checkNotNullParameter($this$typeOrThrow, "<this>");
        KType type = $this$typeOrThrow.getType();
        if (type == null) {
        } else {
            return type;
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Star projections in type arguments are not allowed, but had ").append($this$typeOrThrow.getType()).toString().toString());
        throw illegalArgumentException;
    }
}
