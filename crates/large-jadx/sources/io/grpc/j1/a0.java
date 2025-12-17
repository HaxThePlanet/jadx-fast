package io.grpc.j1;

import io.grpc.d;
import io.grpc.d1;
import io.grpc.e1;
import io.grpc.f1;
import io.grpc.i0;
import io.grpc.l;
import io.grpc.o0.f;
import io.grpc.o0.i;
import io.grpc.s;
import io.grpc.t0;
import io.grpc.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class a0 implements io.grpc.j1.k1 {

    private final i0 a;
    private final Object b;
    private final Executor c;
    private final f1 d;
    private Runnable e;
    private Runnable f;
    private Runnable g;
    private io.grpc.j1.k1.a h;
    private Collection<io.grpc.j1.a0.e> i;
    private d1 j;
    private o0.i k;
    private long l;

    class a implements Runnable {

        final io.grpc.j1.k1.a a;
        a(io.grpc.j1.a0 a0, io.grpc.j1.k1.a k1$a2) {
            this.a = a2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(true);
        }
    }

    class b implements Runnable {

        final io.grpc.j1.k1.a a;
        b(io.grpc.j1.a0 a0, io.grpc.j1.k1.a k1$a2) {
            this.a = a2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(false);
        }
    }

    class c implements Runnable {

        final io.grpc.j1.k1.a a;
        c(io.grpc.j1.a0 a0, io.grpc.j1.k1.a k1$a2) {
            this.a = a2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c();
        }
    }

    class d implements Runnable {

        final d1 a;
        final io.grpc.j1.a0 b;
        d(io.grpc.j1.a0 a0, d1 d12) {
            this.b = a0;
            this.a = d12;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.a(this.b).a(this.a);
        }
    }

    private class e extends io.grpc.j1.b0 {

        private final o0.f j;
        private final s k;
        private final l[] l;
        final io.grpc.j1.a0 m;
        private e(io.grpc.j1.a0 a0, o0.f o0$f2, l[] l3Arr3) {
            this.m = a0;
            super();
            this.k = s.i();
            this.j = f2;
            this.l = l3Arr3;
        }

        e(io.grpc.j1.a0 a0, o0.f o0$f2, l[] l3Arr3, io.grpc.j1.a0.a a0$a4) {
            super(a0, f2, l3Arr3);
        }

        static Runnable A(io.grpc.j1.a0.e a0$e, io.grpc.j1.s s2) {
            return e.B(s2);
        }

        private Runnable B(io.grpc.j1.s s) {
            this.k.j(this.k.c());
            return x(s.b(this.j.c(), this.j.b(), this.j.a(), this.l));
        }

        static l[] y(io.grpc.j1.a0.e a0$e) {
            return e.l;
        }

        static o0.f z(io.grpc.j1.a0.e a0$e) {
            return e.j;
        }

        @Override // io.grpc.j1.b0
        public void c(d1 d1) {
            Runnable remove;
            boolean z;
            super.c(d1);
            Object obj3 = a0.i(this.m);
            synchronized (obj3) {
                if (!this.m.q()) {
                    if (a0.l(this.m).remove(this)) {
                        a0.n(this.m).b(a0.m(this.m));
                        if (a0.h(this.m) != null) {
                            a0.n(this.m).b(a0.j(this.m));
                            a0.k(this.m, 0);
                        }
                    }
                }
                a0.n(this.m).a();
            }
        }

        @Override // io.grpc.j1.b0
        public void j(io.grpc.j1.x0 x0) {
            boolean str;
            if (this.j.a().j()) {
                x0.a("wait_for_ready");
            }
            super.j(x0);
        }

        @Override // io.grpc.j1.b0
        protected void v(d1 d1) {
            int i;
            l lVar;
            final l[] objArr = this.l;
            i = 0;
            while (i < objArr.length) {
                objArr[i].i(d1);
                i++;
            }
        }
    }
    a0(Executor executor, f1 f12) {
        super();
        this.a = i0.a(a0.class, 0);
        Object object = new Object();
        this.b = object;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.i = linkedHashSet;
        this.c = executor;
        this.d = f12;
    }

    static io.grpc.j1.k1.a a(io.grpc.j1.a0 a0) {
        return a0.h;
    }

    static d1 h(io.grpc.j1.a0 a0) {
        return a0.j;
    }

    static Object i(io.grpc.j1.a0 a0) {
        return a0.b;
    }

    static Runnable j(io.grpc.j1.a0 a0) {
        return a0.g;
    }

    static Runnable k(io.grpc.j1.a0 a0, Runnable runnable2) {
        a0.g = runnable2;
        return runnable2;
    }

    static Collection l(io.grpc.j1.a0 a0) {
        return a0.i;
    }

    static Runnable m(io.grpc.j1.a0 a0) {
        return a0.f;
    }

    static f1 n(io.grpc.j1.a0 a0) {
        return a0.d;
    }

    private io.grpc.j1.a0.e o(o0.f o0$f, l[] l2Arr2) {
        int obj3;
        int obj4;
        a0.e eVar = new a0.e(this, f, l2Arr2, 0);
        this.i.add(eVar);
        if (p() == 1) {
            this.d.b(this.e);
        }
        return eVar;
    }

    public final io.grpc.j1.q b(u0<?, ?> u0, t0 t02, d d3, l[] l4Arr4) {
        io.grpc.j1.t1 t1Var;
        int i;
        d1 d1Var;
        long l;
        int obj7;
        t0 obj8;
        Object obj9;
        try {
            t1Var = new t1(u0, t02, d3);
            obj7 = 0;
            i = -1;
            obj8 = this.b;
            obj7 = new f0(this.j, l4Arr4);
            this.d.a();
            return obj7;
            d1Var = this.k;
            obj7 = o(t1Var, l4Arr4);
            obj7 = o(t1Var, l4Arr4);
            i = this.l;
            obj7 = r0.j(d1Var.a(t1Var), d3.j());
            obj7 = obj7.b(t1Var.c(), t1Var.b(), t1Var.a(), l4Arr4);
        } catch (Throwable th) {
        }
        try {
            obj7 = d1Var;
            throw u0;
            t02 = this.d;
            t02.a();
            throw u0;
        }
    }

    @Override // io.grpc.j1.k1
    public final void c(d1 d1) {
        f1 f1Var;
        boolean obj4;
        final Object obj = this.b;
        synchronized (obj) {
        }
    }

    @Override // io.grpc.j1.k1
    public final void d(d1 d1) {
        Object iterator;
        Collection next;
        boolean emptyList;
        io.grpc.j1.r.a rEFUSED;
        l[] objArr;
        Object obj7;
        c(d1);
        iterator = this.b;
        next = this.i;
        final Runnable runnable = this.g;
        this.g = 0;
        synchronized (iterator) {
            this.i = Collections.emptyList();
            if (runnable != null) {
            }
        }
        iterator = next.iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            emptyList = new f0(d1, r.a.REFUSED, a0.e.y((a0.e)next2));
            next = next2.x(emptyList);
            if (next != null) {
            }
            next.run();
        }
        this.d.execute(runnable);
    }

    @Override // io.grpc.j1.k1
    public final Runnable e(io.grpc.j1.k1.a k1$a) {
        this.h = a;
        a0.a aVar = new a0.a(this, a);
        this.e = aVar;
        a0.b bVar = new a0.b(this, a);
        this.f = bVar;
        a0.c cVar = new a0.c(this, a);
        this.g = cVar;
        return null;
    }

    @Override // io.grpc.j1.k1
    public i0 f() {
        return this.a;
    }

    @Override // io.grpc.j1.k1
    final int p() {
        final Object obj = this.b;
        return this.i.size();
        synchronized (obj) {
            obj = this.b;
            return this.i.size();
        }
    }

    @Override // io.grpc.j1.k1
    public final boolean q() {
        int i;
        final Object obj = this.b;
        synchronized (obj) {
            i = 1;
            try {
                return i;
                throw th;
            }
        }
    }

    @Override // io.grpc.j1.k1
    final void r(o0.i o0$i) {
        boolean linkedHashSet;
        boolean z;
        Object collection;
        int i3;
        Collection next;
        int i2;
        d dVar;
        boolean z2;
        Executor executor;
        Object obj = this.b;
        this.k = i;
        this.l = l += i2;
        synchronized (obj) {
            if (!q()) {
            } else {
                try {
                    ArrayList arrayList2 = new ArrayList(this.i);
                    ArrayList arrayList = new ArrayList();
                    Iterator iterator = arrayList2.iterator();
                    while (iterator.hasNext()) {
                        next = iterator.next();
                        dVar = a0.e.z(next).a();
                        i2 = r0.j(i.a(a0.e.z((a0.e)next)), dVar.j());
                        z2 = this.c;
                        if (i2 != 0 && dVar.e() != null) {
                        }
                        z2 = this.c;
                        if (dVar.e() != null) {
                        }
                        i2 = a0.e.A(next, i2);
                        if (i2 != 0) {
                        }
                        arrayList.add(next);
                        z2.execute(i2);
                        z2 = dVar.e();
                    }
                    next = iterator.next();
                    dVar = a0.e.z(next).a();
                    i2 = r0.j(i.a(a0.e.z((a0.e)next)), dVar.j());
                    z2 = this.c;
                    if (i2 != 0 && dVar.e() != null) {
                    }
                    z2 = this.c;
                    if (dVar.e() != null) {
                    }
                    z2 = dVar.e();
                    i2 = a0.e.A(next, i2);
                    if (i2 != 0) {
                    }
                    z2.execute(i2);
                    arrayList.add(next);
                    Object obj8 = this.b;
                    if (!q()) {
                    }
                    this.i.removeAll(arrayList);
                    if (this.i.isEmpty()) {
                    }
                    linkedHashSet = new LinkedHashSet();
                    this.i = linkedHashSet;
                    this.d.b(this.f);
                    z = this.g;
                    if (!q() && this.j != null && z != null) {
                    }
                    this.d.b(this.f);
                    if (this.j != null) {
                    }
                    z = this.g;
                    if (z != null) {
                    }
                    this.d.b(z);
                    this.g = 0;
                    this.d.a();
                    throw th;
                    throw i;
                } catch (Throwable th) {
                }
            }
        }
    }
}
