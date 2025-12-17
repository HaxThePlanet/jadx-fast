package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "Lkotlinx/serialization/internal/MapLikeDescriptor;", "keyDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "valueDesc", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LinkedHashMapClassDesc extends kotlinx.serialization.internal.MapLikeDescriptor {
    public LinkedHashMapClassDesc(SerialDescriptor keyDesc, SerialDescriptor valueDesc) {
        Intrinsics.checkNotNullParameter(keyDesc, "keyDesc");
        Intrinsics.checkNotNullParameter(valueDesc, "valueDesc");
        super("kotlin.collections.LinkedHashMap", keyDesc, valueDesc, 0);
    }
}
