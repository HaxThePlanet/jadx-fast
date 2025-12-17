package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.d;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001:\u0002\u0007\u0008B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016\u0082\u0001\u0005\t\n\u000b\u000c\r¨\u0006\u000e", d2 = {"Lkotlinx/serialization/descriptors/SerialKind;", "", "()V", "hashCode", "", "toString", "", "CONTEXTUAL", "ENUM", "Lkotlinx/serialization/descriptors/SerialKind$ENUM;", "Lkotlinx/serialization/descriptors/SerialKind$CONTEXTUAL;", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "Lkotlinx/serialization/descriptors/StructureKind;", "Lkotlinx/serialization/descriptors/PolymorphicKind;", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class c {
    public c(g g) {
        super();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String str = c0.b(getClass()).o();
        n.d(str);
        return str;
    }
}
