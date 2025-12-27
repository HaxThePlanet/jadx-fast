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

/* compiled from: RoundRobinLoadBalancer.java */
/* loaded from: classes3.dex */
final class a extends o0 {

    static final a.c<a.d<r>> g;
    private static final d1 h;
    private final o0.d b;
    private final Map<y, o0.h> c = new HashMap<>();
    private final Random d = new Random();
    private q e;
    private a.e f = new a$b();

    static final class d<T> {

        T a;
        d(T t) {
            super();
            this.a = t;
        }
    }

    class a implements o0.j {

        final /* synthetic */ o0.h a;
        final /* synthetic */ a b;
        a(o0.h hVar) {
            this.b = aVar;
            this.a = hVar;
            super();
        }

        public void a(r rVar) {
            this.b.k(this.a, rVar);
        }
    }

    private static abstract class e extends o0.i {
        private e() {
            super();
        }

        /* synthetic */ e(a.a aVar) {
            this();
        }

        @Override // io.grpc.o0$i
        abstract boolean c(a.e eVar);
    }

    static final class b extends a.e {

        private final d1 a;
        b(d1 d1Var) {
            super(null);
            n.p(d1Var, "status");
            this.a = d1Var;
        }

        @Override // io.grpc.n1.a$e
        public o0.e a(o0.f fVar) {
            o0.e eVar;
            if (this.a.p()) {
                eVar = o0.e.g();
            } else {
                eVar = o0.e.f(this.a);
            }
            return eVar;
        }

        @Override // io.grpc.n1.a$e
        boolean c(a.e eVar) {
            boolean z;
            d1 d1Var;
            boolean z3 = true;
            z = eVar instanceof a.b;
            if (eVar instanceof a.b) {
                if (!k.a(this.a, eVar.a)) {
                    if (this.a.p()) {
                        eVar = eVar.a.p() ? 1 : 0;
                    }
                }
            }
            return (eVar.a.p() ? 1 : 0);
        }

        @Override // io.grpc.n1.a$e
        public String toString() {
            j.b bVar = j.b(a.b.class);
            bVar.d("status", this.a);
            return bVar.toString();
        }
    }

    static final class c extends a.e {

        private static final AtomicIntegerFieldUpdater<a.c> c;
        private final List<o0.h> a;
        private volatile int b;
        static {
            a.c.c = AtomicIntegerFieldUpdater.newUpdater(a.c.class, "b");
        }

        c(List<o0.h> list, int i) {
            super(null);
            n.e(!list.isEmpty(), "empty list");
            this.a = list;
            this.b = i - 1;
        }

        private o0.h d() {
            int incrementAndGet;
            incrementAndGet = this.a.size();
            final AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a.c.c;
            incrementAndGet = atomicIntegerFieldUpdater.incrementAndGet(this);
            if (incrementAndGet >= incrementAndGet) {
                incrementAndGet = incrementAndGet % incrementAndGet;
                a.c.c.compareAndSet(this, incrementAndGet, incrementAndGet);
            }
            return (o0.h)this.a.get(incrementAndGet);
        }

        @Override // io.grpc.n1.a$e
        public o0.e a(o0.f fVar) {
            return o0.e.h(d());
        }

        @Override // io.grpc.n1.a$e
        boolean c(a.e eVar) {
            boolean z;
            boolean z2 = false;
            List list;
            boolean all;
            z = eVar instanceof a.c;
            z2 = false;
            if (!(eVar instanceof a.c)) {
                return false;
            }
            if (eVar != this) {
                if (this.a.size() == eVar.a.size()) {
                    if (new HashSet(this.a).containsAll(eVar.a)) {
                        int i = 1;
                    }
                }
            }
            return z2;
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

    a(o0.d dVar) {
        super();
        HashMap hashMap = new HashMap();
        io.grpc.n1.a.b bVar = new a.b(a.h);
        n.p(dVar, "helper");
        this.b = dVar;
        final Random random = new Random();
    }

    static /* synthetic */ void f(a aVar, o0.h hVar, r rVar) {
        aVar.k(hVar, rVar);
    }

    private static List<o0.h> g(Collection<o0.h> collection) {
        final ArrayList arrayList = new ArrayList(collection.size());
        final Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return arrayList;
    }

    private static a.d<r> h(o0.h hVar) {
        Object obj = hVar.c().b(a.g);
        n.p(obj, "STATE_INFO");
        return obj;
    }

    static boolean j(o0.h hVar) {
        boolean z = true;
        hVar = (r)a.h(hVar).a.c() == q.READY ? 1 : 0;
        return ((r)a.h(hVar).a.c() == q.READY ? 1 : 0);
    }

    private void k(o0.h hVar, r rVar) {
        q iDLE2;
        if (this.c.get(a.n(hVar.a())) != hVar) {
            return;
        }
        tRANSIENT_FAILURE2 = q.TRANSIENT_FAILURE;
        if (rVar.c() != q.TRANSIENT_FAILURE) {
            if (rVar.c() == q.IDLE) {
                this.b.d();
            }
        }
        q iDLE22 = q.IDLE;
        if (rVar.c() == q.IDLE) {
            hVar.e();
        }
        final io.grpc.n1.a.d dVar2 = a.h(hVar);
        if ((r)dVar2.a.c().equals(q.TRANSIENT_FAILURE)) {
            return;
        }
        dVar2.a = rVar;
        p();
    }

    private static <T> Set<T> l(Set<T> set, Set<T> set2) {
        final HashSet hashSet = new HashSet(set);
        hashSet.removeAll(set2);
        return hashSet;
    }

    private void m(o0.h hVar) {
        hVar.f();
        a.h(hVar).a = r.a(q.SHUTDOWN);
    }

    private static y n(y yVar) {
        return new y(yVar.a());
    }

    private static Map<y, y> o(List<y> list) {
        i = list.size() * 2;
        final HashMap hashMap = new HashMap(i);
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            hashMap.put(a.n(item), item);
        }
        return hashMap;
    }

    private void p() {
        int i = 0;
        q tRANSIENT_FAILURE2;
        d1 d1Var;
        boolean z;
        q qVar;
        q cONNECTING2;
        List list = a.g(i());
        if (list.isEmpty()) {
            i = 0;
            d1Var = a.h;
            Iterator it = i().iterator();
            while (it.hasNext()) {
            }
            q r0 = i != 0 ? q.CONNECTING : q.TRANSIENT_FAILURE;
            q((i != 0 ? q.CONNECTING : q.TRANSIENT_FAILURE), new a.b(d1Var));
        } else {
            q(q.READY, new a.c(list, this.d.nextInt(list.size())));
        }
    }

    private void q(q qVar, a.e eVar) {
        if (qVar == this.e) {
            if (!eVar.c(this.f)) {
                this.b.e(qVar, eVar);
                this.e = qVar;
                this.f = eVar;
            }
        }
    }

    @Override // io.grpc.o0
    public void b(d1 d1Var) {
        if (this.e != q.READY) {
            q(q.TRANSIENT_FAILURE, new a.b(d1Var));
        }
    }

    @Override // io.grpc.o0
    public void c(o0.g gVar) {
        Object key;
        o0.d dVar;
        o0.b.a aVar;
        r rVar;
        Map map5 = a.o(gVar.a());
        Iterator it = map5.entrySet().iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
            key = item2.getKey();
            Object value2 = item2.getValue();
            Object value = this.c.get(key);
        }
        ArrayList arrayList = new ArrayList();
        Iterator item = a.l(this.c.keySet(), map5.keySet()).iterator();
        while (item.hasNext()) {
            arrayList.add(this.c.remove((y)item.next()));
        }
        p();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            m((o0.h)it2.next());
        }
    }

    @Override // io.grpc.o0
    public void e() {
        Iterator it = i().iterator();
        while (it.hasNext()) {
            m((o0.h)it.next());
        }
        this.c.clear();
    }

    @Override // io.grpc.o0
    Collection<o0.h> i() {
        return this.c.values();
    }
}
