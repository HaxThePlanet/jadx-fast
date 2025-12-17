package o.b;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
class s implements o.b.q {

    private o.b.o a;
    private final o.b.c b;
    private final o.b.b c;
    private final o.b.h d;
    private final Executor e;
    private final Map<o.b.k, o.b.l.c> f;
    private final Set<o.b.k<o.b.a<?>>> g;
    private final AtomicBoolean h;

    class a implements Runnable {

        final o.b.a a;
        final o.b.s b;
        a(o.b.s s, o.b.a a2) {
            this.b = s;
            this.a = a2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            s.f(this.b, this.a);
            final o.b.s sVar3 = this.b;
            s.a.a aVar3 = new s.a.a(this);
            s.k(this.b).onAction(this.a, sVar3, sVar3, aVar3);
        }
    }

    private class b implements o.b.t {

        private final o.b.k<o.b.a<?>> a;
        final o.b.s b;
        private b(o.b.s s, o.b.k k2) {
            this.b = s;
            super();
            this.a = k2;
        }

        b(o.b.s s, o.b.k k2, o.b.s.a s$a3) {
            super(s, k2);
        }

        @Override // o.b.t
        public void a() {
        }

        @Override // o.b.t
        public void b() {
            s.l(this.b).add(this.a);
        }

        @Override // o.b.t
        public void c() {
            this.b.q(this.a);
        }
    }

    private class c implements o.b.t {

        private final o.b.l.c a;
        private final o.b.k b;
        final o.b.s c;
        c(o.b.s s, o.b.l.c l$c2, o.b.k k3) {
            this.c = s;
            super();
            this.a = c2;
            this.b = k3;
        }

        @Override // o.b.t
        public void a() {
            this.a.b(0, this.c.getState(), true);
        }

        @Override // o.b.t
        public void b() {
            s.m(this.c).put(this.b, this.a);
        }

        @Override // o.b.t
        public void c() {
            this.c.q(this.b);
        }
    }
    s(o.b.o o, o.b.c c2, o.b.b b3, o.b.h<Object> h4, Executor executor5) {
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.h = atomicBoolean;
        this.a = o;
        this.b = c2;
        this.c = b3;
        this.d = h4;
        this.e = executor5;
        HashSet obj3 = new HashSet();
        this.g = Collections.synchronizedSet(obj3);
        obj3 = new ConcurrentHashMap();
        this.f = obj3;
    }

    static void f(o.b.s s, o.b.a a2) {
        s.n(a2);
    }

    static AtomicBoolean g(o.b.s s) {
        return s.h;
    }

    static o.b.c h(o.b.s s) {
        return s.b;
    }

    static o.b.o i(o.b.s s, o.b.o o2) {
        s.a = o2;
        return o2;
    }

    static void j(o.b.s s, o.b.o o2, o.b.o o3, Collection collection4) {
        s.o(o2, o3, collection4);
    }

    static o.b.b k(o.b.s s) {
        return s.c;
    }

    static Set l(o.b.s s) {
        return s.g;
    }

    static Map m(o.b.s s) {
        return s.f;
    }

    private void n(o.b.a<?> a) {
        Object next;
        Iterator iterator = this.g.iterator();
        for (k next : iterator) {
            next.update(a);
        }
    }

    private void o(o.b.o o, o.b.o o2, Collection<String> collection3) {
        Object next;
        boolean contains;
        Iterator iterator = this.f.values().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((l.c)next.a() != null) {
            } else {
            }
            next.b(o, o2, false);
            if (collection3.contains(next.a())) {
            }
        }
    }

    private o.b.t p(o.b.k k, o.b.l.c l$c2) {
        s.c cVar = new s.c(this, c2, k);
        cVar.b();
        return cVar;
    }

    public <E> o.b.t a(Class<E> class, o.b.k<E> k2) {
        return p(k2, l.b(class, this.d, k2));
    }

    @Override // o.b.q
    public void b(o.b.o o) {
        final o.b.o obj3 = o.f(this.b.c(), o);
        this.a = obj3;
        o(getState(), obj3, this.b.b());
    }

    @Override // o.b.q
    public void c(o.b.a a) {
        s.a aVar = new s.a(this, a);
        this.e.execute(aVar);
        return;
        synchronized (this) {
            aVar = new s.a(this, a);
            this.e.execute(aVar);
        }
    }

    public o.b.t d(o.b.k<o.b.a<?>> k) {
        s.b bVar = new s.b(this, k, 0);
        bVar.b();
        return bVar;
    }

    public <E> o.b.t e(o.b.p<E> p, o.b.k<E> k2) {
        return p(k2, l.c(p, this.d, k2));
    }

    @Override // o.b.q
    public o.b.o getState() {
        return this.a.a();
    }

    @Override // o.b.q
    public void q(o.b.k k) {
        this.f.remove(k);
        this.g.remove(k);
    }
}
