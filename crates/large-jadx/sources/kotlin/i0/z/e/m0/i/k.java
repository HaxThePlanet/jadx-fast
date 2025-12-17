package kotlin.i0.z.e.m0.i;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.utils.j;
import kotlin.reflect.jvm.internal.impl.utils.j.b;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class k {

    static final class a extends p implements l<H, w> {

        final j<H> $conflictedHandles;
        a(j<H> j) {
            this.$conflictedHandles = j;
            super(1);
        }

        public final void a(H h) {
            n.e(h, "it");
            this.$conflictedHandles.add(h);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a(object);
            return w.a;
        }
    }
    public static final <H> Collection<H> a(Collection<? extends H> collection, l<? super H, ? extends a> l2) {
        int i;
        Object str;
        Object empty;
        Object invoke;
        boolean next;
        boolean z;
        n.f(collection, "<this>");
        n.f(l2, "descriptorByHandle");
        final int i2 = 1;
        if (collection.size() <= i2) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        j obj8 = j.c.a();
        while (empty2 ^= i2 != 0) {
            str = j.c.a();
            k.a aVar = new k.a(str);
            Collection collection2 = j.s(p.X(linkedList), linkedList, l2, aVar);
            n.e(collection2, "val conflictedHandles = SmartSet.create<H>()\n\n        val overridableGroup =\n            OverridingUtil.extractMembersOverridableInBothWays(nextHandle, queue, descriptorByHandle) { conflictedHandles.add(it) }");
            if (collection2.size() == i2 && str.isEmpty()) {
            } else {
            }
            empty = j.O(collection2, l2);
            n.e(empty, "selectMostSpecificMember(overridableGroup, descriptorByHandle)");
            Iterator iterator = collection2.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                n.e(next, "it");
                if (!j.E((a)l2.invoke(empty), (a)l2.invoke(next))) {
                }
                str.add(next);
            }
            if (empty3 ^= i2 != 0) {
            }
            obj8.add(empty);
            obj8.addAll(str);
            next = iterator.next();
            n.e(next, "it");
            if (!j.E(invoke, (a)l2.invoke(next))) {
            }
            str.add(next);
            if (str.isEmpty()) {
            } else {
            }
            i = p.y0(collection2);
            n.e(i, "overridableGroup.single()");
            obj8.add(i);
        }
        return obj8;
    }
}
