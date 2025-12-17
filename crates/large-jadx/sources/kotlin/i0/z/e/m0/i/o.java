package kotlin.i0.z.e.m0.i;

import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* loaded from: classes3.dex */
public final class o {
    public static final b a(Collection<? extends b> collection) {
        int i;
        Object next;
        int intValue;
        kotlin.reflect.jvm.internal.impl.descriptors.u visibility;
        n.f(collection, "descriptors");
        collection.isEmpty();
        i = 0;
        final Iterator obj4 = collection.iterator();
        while (obj4.hasNext()) {
            next = obj4.next();
            if (i == 0) {
            } else {
            }
            intValue = t.d(i.getVisibility(), (b)next.getVisibility());
            if (intValue != null && intValue.intValue() < 0) {
            }
            if (intValue.intValue() < 0) {
            }
            i = next;
        }
        n.d(i);
        return i;
    }
}
