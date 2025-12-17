package io.grpc.n1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;
import io.grpc.a;
import io.grpc.a.b;
import io.grpc.a.c;
import io.grpc.d1;
import io.grpc.o0;
import io.grpc.o0.b;
import io.grpc.o0.b.a;
import io.grpc.o0.d;
import io.grpc.o0.e;
import io.grpc.o0.f;
import io.grpc.o0.g;
import io.grpc.o0.h;
import io.grpc.o0.i;
import io.grpc.o0.j;
import io.grpc.q;
import io.grpc.r;
import io.grpc.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes3.dex */
final class a extends o0 {

    static final a.c<io.grpc.n1.a.d<r>> g;
    private static final d1 h;
    private final o0.d b;
    private final Map<y, o0.h> c;
    private final Random d;
    private q e;
    private io.grpc.n1.a.e f;

    static final class d {

        T a;
        d(T t) {
            super();
            this.a = t;
        }
    }

    class a implements o0.j {

        final o0.h a;
        final io.grpc.n1.a b;
        a(io.grpc.n1.a a, o0.h o0$h2) {
            this.b = a;
            this.a = h2;
            super();
        }

        @Override // io.grpc.o0$j
        public void a(r r) {
            a.f(this.b, this.a, r);
        }
    }

    private static abstract class e extends o0.i {
        e(io.grpc.n1.a.a a$a) {
            super();
        }

        @Override // io.grpc.o0$i
        abstract boolean c(io.grpc.n1.a.e a$e);
    }

    static final class b extends io.grpc.n1.a.e {

        private final d1 a;
        b(d1 d1) {
            super(0);
            n.p(d1, "status");
            this.a = (d1)d1;
        }

        @Override // io.grpc.n1.a$e
        public o0.e a(o0.f o0$f) {
            o0.e obj1;
            if (this.a.p()) {
                obj1 = o0.e.g();
            } else {
                obj1 = o0.e.f(this.a);
            }
            return obj1;
        }

        @Override // io.grpc.n1.a$e
        boolean c(io.grpc.n1.a.e a$e) {
            boolean z;
            d1 d1Var;
            Object obj3;
            if (e instanceof a.b) {
                if (!k.a(this.a, e.a)) {
                    if (this.a.p() && e.a.p()) {
                        obj3 = e.a.p() ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj3;
        }

        @Override // io.grpc.n1.a$e
        public String toString() {
            j.b bVar = j.b(a.b.class);
            bVar.d("status", this.a);
            return bVar.toString();
        }
    }

    static final class c extends io.grpc.n1.a.e {

        private static final AtomicIntegerFieldUpdater<io.grpc.n1.a.c> c;
        private final List<o0.h> a;
        private volatile int b;
        static {
            a.c.c = AtomicIntegerFieldUpdater.newUpdater(a.c.class, "b");
        }

        c(List<o0.h> list, int i2) {
            super(0);
            n.e(empty ^= 1, "empty list");
            this.a = list;
            this.b = i2--;
        }

        private o0.h d() {
            int size;
            int incrementAndGet;
            size = this.a.size();
            final AtomicIntegerFieldUpdater num = a.c.c;
            incrementAndGet = num.incrementAndGet(this);
            if (incrementAndGet >= size) {
                size = incrementAndGet % size;
                num.compareAndSet(this, incrementAndGet, size);
                incrementAndGet = size;
            }
            return (o0.h)this.a.get(incrementAndGet);
        }

        @Override // io.grpc.n1.a$e
        public o0.e a(o0.f o0$f) {
            return o0.e.h(d());
        }

        @Override // io.grpc.n1.a$e
        boolean c(io.grpc.n1.a.e a$e) {
            boolean hashSet;
            int i;
            List size;
            Object obj4;
            if (!e instanceof a.c) {
                return 0;
            }
            if ((a.c)e != this) {
                hashSet = new HashSet(this.a);
                if (this.a.size() == e.a.size() && hashSet.containsAll(e.a)) {
                    hashSet = new HashSet(this.a);
                    if (hashSet.containsAll(e.a)) {
                        i = 1;
                    }
                }
            } else {
            }
            return i;
        }

        @Override // io.grpc.n1.a$e
        public String toString() {
            j.b bVar = j.b(a.c.class);
            bVar.d("list", this.a);
            return bVar.toString();
        }
    }
    static {
        a.g = a.c.a("state-info");
        a.h = d1.f.r("no subchannels ready");
    }

    a(o0.d o0$d) {
        super();
        HashMap hashMap = new HashMap();
        this.c = hashMap;
        a.b bVar = new a.b(a.h);
        this.f = bVar;
        n.p(d, "helper");
        this.b = (o0.d)d;
        Random obj3 = new Random();
        this.d = obj3;
    }

    static void f(io.grpc.n1.a a, o0.h o0$h2, r r3) {
        a.k(h2, r3);
    }

    private static List<o0.h> g(Collection<o0.h> collection) {
        int size;
        boolean z;
        ArrayList arrayList = new ArrayList(collection.size());
        final Iterator obj3 = collection.iterator();
        while (obj3.hasNext()) {
            size = obj3.next();
            if (a.j((o0.h)size)) {
            }
            arrayList.add(size);
        }
        return arrayList;
    }

    private static io.grpc.n1.a.d<r> h(o0.h o0$h) {
        Object obj1 = h.c().b(a.g);
        n.p(obj1, "STATE_INFO");
        return (a.d)obj1;
    }

    static boolean j(o0.h o0$h) {
        int obj1;
        obj1 = (r)obj1.a.c() == q.READY ? 1 : 0;
        return obj1;
    }

    private void k(o0.h o0$h, r r2) {
        Object qVar;
        boolean equals;
        q tRANSIENT_FAILURE;
        q iDLE;
        if (this.c.get(a.n(h.a())) != h) {
        }
        tRANSIENT_FAILURE = q.TRANSIENT_FAILURE;
        if (r2.c() != tRANSIENT_FAILURE) {
            if (r2.c() == q.IDLE) {
                this.b.d();
            }
        } else {
        }
        q iDLE2 = q.IDLE;
        if (r2.c() == iDLE2) {
            h.e();
        }
        final io.grpc.n1.a.d obj4 = a.h(h);
        if ((r)obj4.a.c().equals(tRANSIENT_FAILURE) && !r2.c().equals(q.CONNECTING) && r2.c().equals(iDLE2)) {
            if (!r2.c().equals(q.CONNECTING)) {
                if (r2.c().equals(iDLE2)) {
                }
            }
        }
        obj4.a = r2;
        p();
    }

    private static <T> Set<T> l(Set<T> set, Set<T> set2) {
        HashSet hashSet = new HashSet(set);
        hashSet.removeAll(set2);
        return hashSet;
    }

    private void m(o0.h o0$h) {
        h.f();
        obj2.a = r.a(q.SHUTDOWN);
    }

    private static y n(y y) {
        y yVar = new y(y.a());
        return yVar;
    }

    private static Map<y, y> o(List<y> list) {
        int next;
        y yVar;
        HashMap hashMap = new HashMap(size *= 2);
        final Iterator obj3 = list.iterator();
        for (y next : obj3) {
            hashMap.put(a.n(next), next);
        }
        return hashMap;
    }

    private void p() {
        Object tRANSIENT_FAILURE;
        int i;
        d1 nextInt;
        Object rEADY;
        boolean cVar;
        Object obj;
        boolean z;
        q qVar;
        q cONNECTING;
        tRANSIENT_FAILURE = a.g(i());
        if (tRANSIENT_FAILURE.isEmpty()) {
            i = 0;
            nextInt = a.h;
            Iterator iterator = i().iterator();
            while (iterator.hasNext()) {
                obj = dVar.a;
                if ((r)obj.c() != q.CONNECTING) {
                } else {
                }
                i = 1;
                if (nextInt != a.h) {
                } else {
                }
                nextInt = obj.d();
                if (!nextInt.p()) {
                }
                if (obj.c() == q.IDLE) {
                }
            }
            tRANSIENT_FAILURE = i != 0 ? q.CONNECTING : q.TRANSIENT_FAILURE;
            rEADY = new a.b(nextInt);
            q(tRANSIENT_FAILURE, rEADY);
        } else {
            cVar = new a.c(tRANSIENT_FAILURE, this.d.nextInt(tRANSIENT_FAILURE.size()));
            q(q.READY, cVar);
        }
    }

    private void q(q q, io.grpc.n1.a.e a$e2) {
        boolean qVar;
        if (q == this.e) {
            if (!e2.c(this.f)) {
                this.b.e(q, e2);
                this.e = q;
                this.f = e2;
            }
        } else {
        }
    }

    @Override // io.grpc.o0
    public void b(d1 d1) {
        q tRANSIENT_FAILURE;
        Object rEADY;
        if (this.e != q.READY) {
            rEADY = new a.b(d1);
            q(q.TRANSIENT_FAILURE, rEADY);
        }
    }

    @Override // io.grpc.o0
    public void c(o0.g o0$g) {
        Iterator iterator;
        Set singletonList;
        boolean remove;
        Object key;
        Object obj;
        o0.d dVar;
        o0.b.a aVar;
        r rVar;
        Map obj8 = a.o(g.a());
        obj8 = obj8.entrySet().iterator();
        while (obj8.hasNext()) {
            Object next2 = obj8.next();
            key = (Map.Entry)next2.getKey();
            Object value = next2.getValue();
            obj = this.c.get((y)key);
            if ((o0.h)obj != null) {
            } else {
            }
            a.b bVar2 = a.c();
            a.d dVar2 = new a.d(r.a(q.IDLE));
            bVar2.d(a.g, dVar2);
            aVar = o0.b.c();
            aVar.d((y)value);
            aVar.f(bVar2.a());
            singletonList = this.b.a(aVar.b());
            n.p(singletonList, "subchannel");
            a.a aVar3 = new a.a(this, (o0.h)singletonList);
            singletonList.g(aVar3);
            this.c.put(key, singletonList);
            singletonList.e();
            (o0.h)obj.h(Collections.singletonList(value));
        }
        obj8 = new ArrayList();
        iterator = a.l(this.c.keySet(), obj8.keySet()).iterator();
        for (y next4 : iterator) {
            obj8.add(this.c.remove(next4));
        }
        p();
        obj8 = obj8.iterator();
        for (o0.h iterator : obj8) {
            m(iterator);
        }
    }

    @Override // io.grpc.o0
    public void e() {
        Object next;
        Iterator iterator = i().iterator();
        for (o0.h next : iterator) {
            m(next);
        }
        this.c.clear();
    }

    Collection<o0.h> i() {
        return this.c.values();
    }
}
