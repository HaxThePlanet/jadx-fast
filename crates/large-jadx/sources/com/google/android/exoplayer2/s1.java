package com.google.android.exoplayer2;

import android.os.Handler;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.drm.u.a;
import com.google.android.exoplayer2.j2.h1;
import com.google.android.exoplayer2.source.h0;
import com.google.android.exoplayer2.source.h0.a;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.source.y.b;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.source.z.a;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
final class s1 {

    private final List<com.google.android.exoplayer2.s1.c> a;
    private final IdentityHashMap<w, com.google.android.exoplayer2.s1.c> b;
    private final Map<Object, com.google.android.exoplayer2.s1.c> c;
    private final com.google.android.exoplayer2.s1.d d;
    private final z.a e;
    private final u.a f;
    private final HashMap<com.google.android.exoplayer2.s1.c, com.google.android.exoplayer2.s1.b> g;
    private final Set<com.google.android.exoplayer2.s1.c> h;
    private h0 i;
    private boolean j;
    private b0 k;

    private static final class b {

        public final y a;
        public final y.b b;
        public final com.google.android.exoplayer2.s1.a c;
        public b(y y, y.b y$b2, com.google.android.exoplayer2.s1.a s1$a3) {
            super();
            this.a = y;
            this.b = b2;
            this.c = a3;
        }
    }

    public interface d {
        public abstract void b();
    }

    private final class a implements z, u {

        private final com.google.android.exoplayer2.s1.c a;
        private z.a b;
        private u.a c;
        final com.google.android.exoplayer2.s1 v;
        public a(com.google.android.exoplayer2.s1 s1, com.google.android.exoplayer2.s1.c s1$c2) {
            this.v = s1;
            super();
            this.b = s1.a(s1);
            this.c = s1.b(s1);
            this.a = c2;
        }

        private boolean a(int i, y.a y$a2) {
            com.google.android.exoplayer2.s1.c cVar;
            z.a aVar;
            u.a aVar2;
            int i2;
            u.a obj4;
            int obj5;
            if (a2 != null) {
                if (s1.c(this.a, a2) == null) {
                    return 0;
                }
            } else {
                obj5 = 0;
            }
            obj4 = s1.d(this.a, i);
            aVar = this.b;
            if (aVar.a == obj4) {
                if (!p0.b(aVar.b, obj5)) {
                    this.b = s1.a(this.v).F(obj4, obj5, 0);
                }
            } else {
            }
            aVar2 = this.c;
            if (aVar2.a == obj4) {
                if (!p0.b(aVar2.b, obj5)) {
                    this.c = s1.b(this.v).u(obj4, obj5);
                }
            } else {
            }
            return 1;
        }

        @Override // com.google.android.exoplayer2.source.z
        public void I(int i, y.a y$a2, v v3) {
            boolean obj1;
            if (a(i, a2)) {
                this.b.d(v3);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void J(int i, y.a y$a2, s s3, v v4) {
            boolean obj1;
            if (a(i, a2)) {
                this.b.s(s3, v4);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void K(int i, y.a y$a2, v v3) {
            boolean obj1;
            if (a(i, a2)) {
                this.b.E(v3);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void M(int i, y.a y$a2, Exception exception3) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.f(exception3);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void N(int i, y.a y$a2, s s3, v v4) {
            boolean obj1;
            if (a(i, a2)) {
                this.b.B(s3, v4);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void U(int i, y.a y$a2) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.c();
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void c0(int i, y.a y$a2) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.b();
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void g0(int i, y.a y$a2, s s3, v v4) {
            boolean obj1;
            if (a(i, a2)) {
                this.b.v(s3, v4);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void i0(int i, y.a y$a2, int i3) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.e(i3);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void j0(int i, y.a y$a2) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.g();
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void l0(int i, y.a y$a2, s s3, v v4, IOException iOException5, boolean z6) {
            boolean obj1;
            if (a(i, a2)) {
                this.b.y(s3, v4, iOException5, z6);
            }
        }

        @Override // com.google.android.exoplayer2.source.z
        public void n0(int i, y.a y$a2) {
            boolean obj1;
            if (a(i, a2)) {
                this.c.d();
            }
        }
    }

    static final class c implements com.google.android.exoplayer2.r1 {

        public final u a;
        public final Object b;
        public final List<y.a> c;
        public int d;
        public boolean e;
        public c(y y, boolean z2) {
            super();
            u uVar = new u(y, z2);
            this.a = uVar;
            ArrayList obj2 = new ArrayList();
            this.c = obj2;
            obj2 = new Object();
            this.b = obj2;
        }

        @Override // com.google.android.exoplayer2.r1
        public com.google.android.exoplayer2.g2 a() {
            return this.a.K();
        }

        @Override // com.google.android.exoplayer2.r1
        public void b(int i) {
            this.d = i;
            this.e = false;
            this.c.clear();
        }

        @Override // com.google.android.exoplayer2.r1
        public Object getUid() {
            return this.b;
        }
    }
    public s1(com.google.android.exoplayer2.s1.d s1$d, h1 h12, Handler handler3) {
        super();
        this.d = d;
        h0.a obj3 = new h0.a(0);
        this.i = obj3;
        obj3 = new IdentityHashMap();
        this.b = obj3;
        obj3 = new HashMap();
        this.c = obj3;
        obj3 = new ArrayList();
        this.a = obj3;
        obj3 = new z.a();
        this.e = obj3;
        u.a aVar = new u.a();
        this.f = aVar;
        HashMap hashMap = new HashMap();
        this.g = hashMap;
        HashSet hashSet = new HashSet();
        this.h = hashSet;
        if (h12 != null) {
            obj3.a(handler3, h12);
            aVar.a(handler3, h12);
        }
    }

    private void B(int i, int i2) {
        Object remove;
        boolean z;
        Object obj;
        int obj6;
        final int i3 = 1;
        i2 -= i3;
        while (obj6 >= i) {
            remove = this.a.remove(obj6);
            this.c.remove(remove.b);
            f(obj6, -i4);
            remove.e = i3;
            if (this.j) {
            }
            obj6--;
            u((s1.c)remove);
        }
    }

    static z.a a(com.google.android.exoplayer2.s1 s1) {
        return s1.e;
    }

    static u.a b(com.google.android.exoplayer2.s1 s1) {
        return s1.f;
    }

    static y.a c(com.google.android.exoplayer2.s1.c s1$c, y.a y$a2) {
        return s1.m(c, a2);
    }

    static int d(com.google.android.exoplayer2.s1.c s1$c, int i2) {
        return s1.q(c, i2);
    }

    private void f(int i, int i2) {
        while (i < this.a.size()) {
            Object obj = this.a.get(i);
            obj.d = i3 += i2;
            i++;
        }
    }

    private void i(com.google.android.exoplayer2.s1.c s1$c) {
        Object map;
        Object obj2;
        obj2 = this.g.get(c);
        if ((s1.b)obj2 != null) {
            obj2.a.f(obj2.b);
        }
    }

    private void j() {
        Object next;
        boolean empty;
        Iterator iterator = this.h.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next.c.isEmpty()) {
            }
            i((s1.c)next);
            iterator.remove();
        }
    }

    private void k(com.google.android.exoplayer2.s1.c s1$c) {
        Object map;
        Object obj2;
        this.h.add(c);
        obj2 = this.g.get(c);
        if ((s1.b)obj2 != null) {
            obj2.a.o(obj2.b);
        }
    }

    private static Object l(Object object) {
        return q0.v(object);
    }

    private static y.a m(com.google.android.exoplayer2.s1.c s1$c, y.a y$a2) {
        int i;
        int cmp;
        long l;
        i = 0;
        while (i < c.c.size()) {
            i++;
        }
        return null;
    }

    private static Object n(Object object) {
        return q0.w(object);
    }

    private static Object o(com.google.android.exoplayer2.s1.c s1$c, Object object2) {
        return q0.y(c.b, object2);
    }

    private static int q(com.google.android.exoplayer2.s1.c s1$c, int i2) {
        return i2 += obj0;
    }

    private void s(y y, com.google.android.exoplayer2.g2 g22) {
        this.d.b();
    }

    private void u(com.google.android.exoplayer2.s1.c s1$c) {
        boolean empty;
        y yVar;
        com.google.android.exoplayer2.s1.a aVar;
        if (c.e && c.c.isEmpty()) {
            if (c.c.isEmpty()) {
                Object remove = this.g.remove(c);
                g.e((s1.b)remove);
                remove.a.b(remove.b);
                remove.a.e(remove.c);
                remove.a.i(remove.c);
                this.h.remove(c);
            }
        }
    }

    private void x(com.google.android.exoplayer2.s1.c s1$c) {
        final u uVar = c.a;
        h0 h0Var = new h0(this);
        s1.a aVar = new s1.a(this, c);
        s1.b bVar = new s1.b(uVar, h0Var, aVar);
        this.g.put(c, bVar);
        uVar.d(p0.w(), aVar);
        uVar.h(p0.w(), aVar);
        uVar.n(h0Var, this.k);
    }

    public com.google.android.exoplayer2.g2 A(int i, int i2, h0 h03) {
        int i4;
        int i3;
        if (i >= 0 && i <= i2 && i2 <= p()) {
            if (i <= i2) {
                i4 = i2 <= p() ? 1 : 0;
            } else {
            }
        } else {
        }
        g.a(i4);
        this.i = h03;
        B(i, i2);
        return h();
    }

    public com.google.android.exoplayer2.g2 C(List<com.google.android.exoplayer2.s1.c> list, h0 h02) {
        B(0, this.a.size());
        return e(this.a.size(), list, h02);
    }

    public com.google.android.exoplayer2.g2 D(h0 h0) {
        int length;
        h0 obj3;
        final int i = p();
        if (h0.getLength() != i) {
            obj3 = h0.g().e(0, i);
        }
        this.i = obj3;
        return h();
    }

    public com.google.android.exoplayer2.g2 e(int i, List<com.google.android.exoplayer2.s1.c> list2, h0 h03) {
        boolean empty;
        boolean empty2;
        int i2;
        Object obj;
        h0 obj6;
        if (!list2.isEmpty()) {
            this.i = h03;
            obj6 = i;
            while (obj6 < size += i) {
                empty = list2.get(obj6 - i);
                if (obj6 > 0) {
                } else {
                }
                (s1.c)empty.b(0);
                f(obj6, empty.a.K().p());
                this.a.add(obj6, empty);
                this.c.put(empty.b, empty);
                if (this.j) {
                }
                obj6++;
                x(empty);
                if (this.b.isEmpty()) {
                } else {
                }
                i(empty);
                this.h.add(empty);
                Object obj2 = this.a.get(obj6 + -1);
                empty.b(i5 += obj);
            }
        }
        return h();
    }

    public w g(y.a y$a, f f2, long l3) {
        y.a obj3 = a.c(s1.l(a.a));
        obj3 = this.c.get(s1.n(a.a));
        g.e((s1.c)obj3);
        k((s1.c)obj3);
        obj3.c.add(obj3);
        obj3 = obj3.a.G(obj3, f2, l3);
        this.b.put(obj3, obj3);
        j();
        return obj3;
    }

    public com.google.android.exoplayer2.g2 h() {
        int i;
        int i2;
        int i3;
        if (this.a.isEmpty()) {
            return g2.a;
        }
        i2 = i;
        while (i < this.a.size()) {
            Object obj = this.a.get(i);
            obj.d = i2;
            i2 += i3;
            i++;
        }
        x1 x1Var = new x1(this.a, this.i);
        return x1Var;
    }

    public int p() {
        return this.a.size();
    }

    public boolean r() {
        return this.j;
    }

    public void t(y y, com.google.android.exoplayer2.g2 g22) {
        s(y, g22);
    }

    public com.google.android.exoplayer2.g2 v(int i, int i2, int i3, h0 h04) {
        int i6;
        int i5;
        int i4;
        int obj4;
        int obj7;
        int i7 = 1;
        if (i >= 0 && i <= i2 && i2 <= p() && i3 >= 0) {
            if (i <= i2) {
                if (i2 <= p()) {
                    i6 = i3 >= 0 ? i7 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        g.a(i6);
        this.i = h04;
        if (i != i2) {
            if (i == i3) {
            } else {
                i5 = obj.d;
                p0.n0(this.a, i, i2, i3);
                while (obj7 <= Math.max(i11 -= i7, i2 + -1)) {
                    obj4 = this.a.get(obj7);
                    obj4.d = i5;
                    i5 += obj4;
                    obj7++;
                }
            }
            return h();
        }
        return h();
    }

    public void w(b0 b0) {
        int i;
        Set set;
        int obj4;
        final int i2 = 1;
        g.f(z ^= i2);
        this.k = b0;
        obj4 = 0;
        while (obj4 < this.a.size()) {
            i = this.a.get(obj4);
            x((s1.c)i);
            this.h.add(i);
            obj4++;
        }
        this.j = i2;
    }

    public void y() {
        com.google.android.exoplayer2.s1.a aVar;
        Object th;
        y yVar;
        Object str;
        y.b bVar;
        String str2;
        Iterator iterator = this.g.values().iterator();
        for (s1.b next2 : iterator) {
            next2.a.b(next2.b);
            next2.a.e(next2.c);
            next2.a.i(next2.c);
            v.d("MediaSourceList", "Failed to release child source.", th);
        }
        this.g.clear();
        this.h.clear();
        this.j = false;
    }

    public void z(w w) {
        Object remove = this.b.remove(w);
        g.e((s1.c)remove);
        remove.a.l(w);
        remove.c.remove(w.a);
        if (!this.b.isEmpty()) {
            j();
        }
        u((s1.c)remove);
    }
}
