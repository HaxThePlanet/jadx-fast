package kotlinx.serialization.c;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b", d2 = {"throwArrayMissingFieldException", "", "seenArray", "", "goldenMaskArray", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "throwMissingFieldException", "seen", "", "goldenMask", "kotlinx-serialization-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class j {
    public static final void a(int i, int i2, SerialDescriptor serialDescriptor3) {
        int i3;
        int i4;
        int obj3;
        int obj4;
        n.f(serialDescriptor3, "descriptor");
        ArrayList arrayList = new ArrayList();
        obj3 &= i2;
        obj4 = 0;
        i3 = obj4 + 1;
        while (obj3 & 1 != 0) {
            arrayList.add(serialDescriptor3.c(obj4));
            obj3 >>>= 1;
            obj4 = i3;
            i3 = obj4 + 1;
        }
        obj3 = new MissingFieldException(arrayList, serialDescriptor3.a());
        throw obj3;
    }
}
