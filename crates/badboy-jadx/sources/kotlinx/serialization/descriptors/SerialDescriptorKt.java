package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0003\"$\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"$\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\u0004\u001a\u0004\u0008\n\u0010\u0006¨\u0006\u000b", d2 = {"elementDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getElementDescriptors", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/lang/Iterable;", "elementNames", "", "getElementNames$annotations", "getElementNames", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SerialDescriptorKt {
    public static final Iterable<kotlinx.serialization.descriptors.SerialDescriptor> getElementDescriptors(kotlinx.serialization.descriptors.SerialDescriptor $this$elementDescriptors) {
        Intrinsics.checkNotNullParameter($this$elementDescriptors, "<this>");
        SerialDescriptorKt.special$$inlined.Iterable.1 anon = new SerialDescriptorKt.special$$inlined.Iterable.1($this$elementDescriptors);
        return (Iterable)anon;
    }

    @ExperimentalSerializationApi
    public static void getElementDescriptors$annotations(kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor) {
    }

    public static final Iterable<String> getElementNames(kotlinx.serialization.descriptors.SerialDescriptor $this$elementNames) {
        Intrinsics.checkNotNullParameter($this$elementNames, "<this>");
        SerialDescriptorKt.special$$inlined.Iterable.2 anon = new SerialDescriptorKt.special$$inlined.Iterable.2($this$elementNames);
        return (Iterable)anon;
    }

    @ExperimentalSerializationApi
    public static void getElementNames$annotations(kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor) {
    }
}
