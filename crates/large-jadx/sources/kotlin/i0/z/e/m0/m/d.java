package kotlin.i0.z.e.m0.m;

import java.util.Collection;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.f.e;
import kotlin.k0.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;

/* loaded from: classes3.dex */
public final class d {

    private final e a;
    private final h b;
    private final Collection<e> c;
    private final l<x, String> d;
    private final kotlin.i0.z.e.m0.m.b[] e;

    static final class a extends p implements l {

        public static final kotlin.i0.z.e.m0.m.d.a a;
        static {
            d.a aVar = new d.a();
            d.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Void a(x x) {
            n.f(x, "<this>");
            return null;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((x)object);
        }
    }

    static final class b extends p implements l {

        public static final kotlin.i0.z.e.m0.m.d.b a;
        static {
            d.b bVar = new d.b();
            d.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Void a(x x) {
            n.f(x, "<this>");
            return null;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((x)object);
        }
    }

    static final class c extends p implements l {

        public static final kotlin.i0.z.e.m0.m.d.c a;
        static {
            d.c cVar = new d.c();
            d.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Void a(x x) {
            n.f(x, "<this>");
            return null;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((x)object);
        }
    }
    public d(Collection<e> collection, kotlin.i0.z.e.m0.m.b[] b2Arr2, l<? super x, String> l3) {
        n.f(collection, "nameList");
        n.f(b2Arr2, "checks");
        n.f(l3, "additionalChecks");
        final kotlin.i0.z.e.m0.m.b[] arr = new b[b2Arr2.length];
        int i = 0;
        System.arraycopy(b2Arr2, i, arr, i, b2Arr2.length);
        super(0, 0, collection, l3, arr);
    }

    public d(Collection collection, kotlin.i0.z.e.m0.m.b[] b2Arr2, l l3, int i4, g g5) {
        kotlin.i0.z.e.m0.m.d.c obj3;
        obj3 = i4 &= 4 != 0 ? d.c.a : obj3;
        super(collection, b2Arr2, obj3);
    }

    private d(e e, h h2, Collection<e> collection3, l<? super x, String> l4, kotlin.i0.z.e.m0.m.b... b5Arr5) {
        super();
        this.a = e;
        this.b = h2;
        this.c = collection3;
        this.d = l4;
        this.e = b5Arr5;
    }

    public d(e e, kotlin.i0.z.e.m0.m.b[] b2Arr2, l<? super x, String> l3) {
        n.f(e, "name");
        n.f(b2Arr2, "checks");
        n.f(l3, "additionalChecks");
        final kotlin.i0.z.e.m0.m.b[] arr = new b[b2Arr2.length];
        int i = 0;
        System.arraycopy(b2Arr2, i, arr, i, b2Arr2.length);
        super(e, 0, 0, l3, arr);
    }

    public d(e e, kotlin.i0.z.e.m0.m.b[] b2Arr2, l l3, int i4, g g5) {
        kotlin.i0.z.e.m0.m.d.a obj3;
        obj3 = i4 &= 4 != 0 ? d.a.a : obj3;
        super(e, b2Arr2, obj3);
    }

    public d(h h, kotlin.i0.z.e.m0.m.b[] b2Arr2, l<? super x, String> l3) {
        n.f(h, "regex");
        n.f(b2Arr2, "checks");
        n.f(l3, "additionalChecks");
        final kotlin.i0.z.e.m0.m.b[] arr = new b[b2Arr2.length];
        int i = 0;
        System.arraycopy(b2Arr2, i, arr, i, b2Arr2.length);
        super(0, h, 0, l3, arr);
    }

    public d(h h, kotlin.i0.z.e.m0.m.b[] b2Arr2, l l3, int i4, g g5) {
        kotlin.i0.z.e.m0.m.d.b obj3;
        obj3 = i4 &= 4 != 0 ? d.b.a : obj3;
        super(h, b2Arr2, obj3);
    }

    public final kotlin.i0.z.e.m0.m.c a(x x) {
        int i;
        String str;
        n.f(x, "functionDescriptor");
        kotlin.i0.z.e.m0.m.b[] objArr = this.e;
        i = 0;
        while (i < objArr.length) {
            i++;
            str = objArr[i].a(x);
        }
        Object obj5 = this.d.invoke(x);
        if ((String)obj5 != null) {
            c.b bVar = new c.b((String)obj5);
            return bVar;
        }
        return c.c.b;
    }

    public final boolean b(x x) {
        e eVar;
        h hVar;
        e eVar2;
        Object obj4;
        n.f(x, "functionDescriptor");
        final int i = 0;
        if (this.a != null && !n.b(x.getName(), this.a)) {
            if (!n.b(x.getName(), this.a)) {
                return i;
            }
        }
        String str2 = x.getName().c();
        n.e(str2, "functionDescriptor.name.asString()");
        if (this.b != null && !this.b.d(str2)) {
            str2 = x.getName().c();
            n.e(str2, "functionDescriptor.name.asString()");
            if (!this.b.d(str2)) {
                return i;
            }
        }
        Collection collection = this.c;
        if (collection != null && !collection.contains(x.getName())) {
            if (!collection.contains(x.getName())) {
                return i;
            }
        }
        return 1;
    }
}
