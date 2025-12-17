package kotlin.i0.z.e.m0.m.n;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.i.v.h.b;
import kotlin.reflect.jvm.internal.impl.utils.i;

/* loaded from: classes3.dex */
public final class a {
    public static final <T> Collection<T> a(Collection<? extends T> collection, Collection<? extends T> collection2) {
        n.f(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet != null) {
            (LinkedHashSet)collection.addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final i<h> b(Iterable<? extends h> iterable) {
        Object next;
        int i;
        h.b bVar;
        n.f(iterable, "scopes");
        i iVar = new i();
        final Iterator obj4 = iterable.iterator();
        while (obj4.hasNext()) {
            next = obj4.next();
            Object obj = next;
            if ((h)obj != null && (h)obj != h.b.b) {
            } else {
            }
            i = 0;
            if (i != 0) {
            }
            iVar.add(next);
            if ((h)obj != h.b.b) {
            } else {
            }
            i = 1;
        }
        return iVar;
    }
}
