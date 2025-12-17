package kotlin.reflect.jvm.internal.impl.descriptors.h1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.f.b;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class k implements kotlin.reflect.jvm.internal.impl.descriptors.h1.g {

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.h1.g> a;

    static final class a extends p implements l<kotlin.reflect.jvm.internal.impl.descriptors.h1.g, kotlin.reflect.jvm.internal.impl.descriptors.h1.c> {

        final b $fqName;
        a(b b) {
            this.$fqName = b;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.reflect.jvm.internal.impl.descriptors.h1.c a(kotlin.reflect.jvm.internal.impl.descriptors.h1.g g) {
            n.f(g, "it");
            return g.o(this.$fqName);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((g)object);
        }
    }

    static final class b extends p implements l<kotlin.reflect.jvm.internal.impl.descriptors.h1.g, h<? extends kotlin.reflect.jvm.internal.impl.descriptors.h1.c>> {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.h1.k.b a;
        static {
            k.b bVar = new k.b();
            k.b.a = bVar;
        }

        b() {
            super(1);
        }

        public final h<kotlin.reflect.jvm.internal.impl.descriptors.h1.c> a(kotlin.reflect.jvm.internal.impl.descriptors.h1.g g) {
            n.f(g, "it");
            return p.M(g);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((g)object);
        }
    }
    public k(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.h1.g> list) {
        n.f(list, "delegates");
        super();
        this.a = list;
    }

    public k(kotlin.reflect.jvm.internal.impl.descriptors.h1.g... gArr) {
        n.f(gArr, "delegates");
        super(i.a0(gArr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean isEmpty() {
        Object iterator;
        boolean empty;
        int i;
        iterator = this.a;
        i = 1;
        if (iterator instanceof Collection != null && iterator.isEmpty()) {
            if (iterator.isEmpty()) {
            } else {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    if (!(g)iterator.next().isEmpty()) {
                        break;
                    } else {
                    }
                }
            }
        } else {
        }
        return i;
    }

    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.h1.c> iterator() {
        return i.p(p.M(this.a), k.b.a).iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public kotlin.reflect.jvm.internal.impl.descriptors.h1.c o(b b) {
        n.f(b, "fqName");
        k.a aVar = new k.a(b);
        return (c)i.o(i.v(p.M(this.a), aVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.g
    public boolean u1(b b) {
        boolean next;
        int obj3;
        n.f(b, "fqName");
        Iterator iterator = p.M(this.a).iterator();
        for (g next2 : iterator) {
        }
        obj3 = 0;
        return obj3;
    }
}
