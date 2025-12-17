package kotlin.reflect.jvm.internal.impl.descriptors.h1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;

/* loaded from: classes3.dex */
public final class l implements kotlin.reflect.jvm.internal.impl.descriptors.h1.g {

    private final kotlin.reflect.jvm.internal.impl.descriptors.h1.g a;
    private final boolean b;
    private final l<b, Boolean> c;
    public l(kotlin.reflect.jvm.internal.impl.descriptors.h1.g g, l<? super b, Boolean> l2) {
        n.f(g, "delegate");
        n.f(l2, "fqNameFilter");
        super(g, 0, l2);
    }

    public l(kotlin.reflect.jvm.internal.impl.descriptors.h1.g g, boolean z2, l<? super b, Boolean> l3) {
        n.f(g, "delegate");
        n.f(l3, "fqNameFilter");
        super();
        this.a = g;
        this.b = z2;
        this.c = l3;
    }

    private final boolean d(kotlin.reflect.jvm.internal.impl.descriptors.h1.c c) {
        l lVar;
        b obj2;
        obj2 = c.d();
        if (obj2 != null && (Boolean)this.c.invoke(obj2).booleanValue()) {
            obj2 = (Boolean)this.c.invoke(obj2).booleanValue() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean isEmpty() {
        int i;
        Object iterator;
        boolean empty;
        int i2;
        iterator = this.a;
        final int i3 = 0;
        if (iterator instanceof Collection != null && (Collection)iterator.isEmpty()) {
            if ((Collection)iterator.isEmpty()) {
                i = i3;
            } else {
                iterator = iterator.iterator();
                for (c next : iterator) {
                }
            }
        } else {
        }
        if (this.b) {
            if (i == 0) {
            } else {
                i2 = i3;
            }
        } else {
            i2 = i;
        }
        return i2;
    }

    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.h1.c> iterator() {
        Object next;
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (d((c)next)) {
            }
            arrayList.add(next);
        }
        return arrayList.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public kotlin.reflect.jvm.internal.impl.descriptors.h1.c o(b b) {
        kotlin.reflect.jvm.internal.impl.descriptors.h1.g booleanValue;
        kotlin.reflect.jvm.internal.impl.descriptors.h1.c obj2;
        n.f(b, "fqName");
        if ((Boolean)this.c.invoke(b).booleanValue()) {
            obj2 = this.a.o(b);
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean u1(b b) {
        kotlin.reflect.jvm.internal.impl.descriptors.h1.g booleanValue;
        boolean obj2;
        n.f(b, "fqName");
        if ((Boolean)this.c.invoke(b).booleanValue()) {
            obj2 = this.a.u1(b);
        } else {
            obj2 = 0;
        }
        return obj2;
    }
}
