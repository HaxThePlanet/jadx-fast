package kotlinx.serialization.c;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "Lkotlinx/serialization/internal/MapLikeDescriptor;", "keyDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "valueDesc", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends kotlinx.serialization.c.g {
    public d(SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2) {
        n.f(serialDescriptor, "keyDesc");
        n.f(serialDescriptor2, "valueDesc");
        super("kotlin.collections.LinkedHashMap", serialDescriptor, serialDescriptor2, 0);
    }
}
