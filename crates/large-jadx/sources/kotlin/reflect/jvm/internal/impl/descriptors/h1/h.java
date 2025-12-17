package kotlin.reflect.jvm.internal.impl.descriptors.h1;

import java.util.Iterator;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;

/* loaded from: classes3.dex */
public final class h implements kotlin.reflect.jvm.internal.impl.descriptors.h1.g {

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.h1.c> a;
    public h(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.h1.c> list) {
        n.f(list, "annotations");
        super();
        this.a = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.h1.c> iterator() {
        return this.a.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public kotlin.reflect.jvm.internal.impl.descriptors.h1.c o(b b) {
        return g.b.a(this, b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public String toString() {
        return this.a.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean u1(b b) {
        return g.b.b(this, b);
    }
}
