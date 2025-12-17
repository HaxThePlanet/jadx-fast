package kotlinx.serialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.SerialDescriptorForNullable;
import kotlinx.serialization.modules.SerializersModule;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0003\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0002*\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a\u001a\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000b*\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a\u0018\u0010\u000c\u001a\u00020\u0002*\u00020\u00022\n\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u0001H\u0000\"$\u0010\u0000\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000e", d2 = {"capturedKClass", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getCapturedKClass$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getCapturedKClass", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlin/reflect/KClass;", "getContextualDescriptor", "Lkotlinx/serialization/modules/SerializersModule;", "descriptor", "getPolymorphicDescriptors", "", "withContext", "context", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContextAwareKt {
    public static final KClass<?> getCapturedKClass(kotlinx.serialization.descriptors.SerialDescriptor $this$capturedKClass) {
        KClass capturedKClass;
        Intrinsics.checkNotNullParameter($this$capturedKClass, "<this>");
        if ($this$capturedKClass instanceof ContextDescriptor) {
            capturedKClass = obj.kClass;
        } else {
            if ($this$capturedKClass instanceof SerialDescriptorForNullable) {
                capturedKClass = ContextAwareKt.getCapturedKClass((SerialDescriptorForNullable)$this$capturedKClass.getOriginal$kotlinx_serialization_core());
            } else {
                capturedKClass = 0;
            }
        }
        return capturedKClass;
    }

    @ExperimentalSerializationApi
    public static void getCapturedKClass$annotations(kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor) {
    }

    @ExperimentalSerializationApi
    public static final kotlinx.serialization.descriptors.SerialDescriptor getContextualDescriptor(SerializersModule $this$getContextualDescriptor, kotlinx.serialization.descriptors.SerialDescriptor descriptor) {
        int descriptor2;
        int i;
        KSerializer contextual$default;
        Intrinsics.checkNotNullParameter($this$getContextualDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        KClass capturedKClass = ContextAwareKt.getCapturedKClass(descriptor);
        descriptor2 = 0;
        i = 0;
        contextual$default = SerializersModule.getContextual$default($this$getContextualDescriptor, capturedKClass, descriptor2, 2, descriptor2);
        if (capturedKClass != null && contextual$default != null) {
            i = 0;
            contextual$default = SerializersModule.getContextual$default($this$getContextualDescriptor, capturedKClass, descriptor2, 2, descriptor2);
            if (contextual$default != null) {
                descriptor2 = contextual$default.getDescriptor();
            }
        }
        return descriptor2;
    }

    @ExperimentalSerializationApi
    public static final List<kotlinx.serialization.descriptors.SerialDescriptor> getPolymorphicDescriptors(SerializersModule $this$getPolymorphicDescriptors, kotlinx.serialization.descriptors.SerialDescriptor descriptor) {
        Collection emptyList;
        Object next;
        kotlinx.serialization.descriptors.SerialDescriptor it;
        int i;
        Intrinsics.checkNotNullParameter($this$getPolymorphicDescriptors, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        KClass capturedKClass = ContextAwareKt.getCapturedKClass(descriptor);
        if (capturedKClass == null) {
            return CollectionsKt.emptyList();
        }
        Object obj2 = obj.polyBase2Serializers.get(capturedKClass);
        if ((Map)obj2 != null) {
            emptyList = (Map)obj2.values();
        } else {
            emptyList = 0;
        }
        if (emptyList == null) {
            emptyList = CollectionsKt.emptyList();
        }
        final int i2 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)emptyList, 10));
        final int i4 = 0;
        final Iterator iterator = emptyList.iterator();
        for (Object next : iterator) {
            i = 0;
            (Collection)arrayList.add((KSerializer)next.getDescriptor());
        }
        return (List)arrayList;
    }

    public static final kotlinx.serialization.descriptors.SerialDescriptor withContext(kotlinx.serialization.descriptors.SerialDescriptor $this$withContext, KClass<?> context) {
        Intrinsics.checkNotNullParameter($this$withContext, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        ContextDescriptor contextDescriptor = new ContextDescriptor($this$withContext, context);
        return (SerialDescriptor)contextDescriptor;
    }
}
