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

/* compiled from: SuasStore.java */
/* loaded from: classes3.dex */
class s implements q {

    private o a;
    private final c b;
    private final b c;
    private final h d;
    private final Executor e;
    private final Map<k, l.c> f = new ConcurrentHashMap<>();
    private final Set<k<a<?>>> g;
    private final AtomicBoolean h = new AtomicBoolean(0);

    class a implements Runnable {

        final /* synthetic */ a a;
        final /* synthetic */ s b;
        a(a aVar) {
            this.b = sVar;
            this.a = aVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.n(this.a);
            this.b.c.onAction(this.a, this.b, this.b, new s.a.a(this));
        }
    }

    private class b implements t {

        private final k<a<?>> a;
        final /* synthetic */ s b;
        /* synthetic */ b(k kVar, s.a aVar) {
            this(sVar, kVar);
        }

        public void b() {
            this.b.g.add(this.a);
        }

        public void c() {
            this.b.q(this.a);
        }

        private b(k kVar) {
            this.b = sVar;
            super();
            this.a = kVar;
        }

        public void a() {
        }
    }

    private class c implements t {

        private final l.c a;
        private final k b;
        final /* synthetic */ s c;
        c(l.c cVar, k kVar) {
            this.c = sVar;
            super();
            this.a = cVar;
            this.b = kVar;
        }

        public void a() {
            this.a.b(null, this.c.getState(), true);
        }

        public void b() {
            this.c.f.put(this.b, this.a);
        }

        public void c() {
            this.c.q(this.b);
        }
    }
    s(o oVar, c cVar, b bVar, h<Object> hVar, Executor executor) {
        super();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.a = oVar;
        this.b = cVar;
        this.c = bVar;
        this.d = hVar;
        this.e = executor;
        this.g = Collections.synchronizedSet(new HashSet());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }

    static /* synthetic */ void f(s sVar, a aVar) {
        sVar.n(aVar);
    }

    static /* synthetic */ AtomicBoolean g(s sVar) {
        return sVar.h;
    }

    static /* synthetic */ c h(s sVar) {
        return sVar.b;
    }

    static /* synthetic */ o i(s sVar, o oVar) {
        sVar.a = oVar;
        return oVar;
    }

    static /* synthetic */ void j(s sVar, o oVar, o oVar2, Collection list) {
        sVar.o(oVar, oVar2, list);
    }

    static /* synthetic */ b k(s sVar) {
        return sVar.c;
    }

    static /* synthetic */ Set l(s sVar) {
        return sVar.g;
    }

    static /* synthetic */ Map m(s sVar) {
        return sVar.f;
    }

    private void n(a<?> aVar) {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            (k)it.next().update(aVar);
        }
    }

    private void o(o oVar, o oVar2, Collection<String> collection) {
        Iterator it = this.f.values().iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
    }

    private t p(k kVar, l.c cVar) {
        cVar = new s.c(this, cVar, kVar);
        cVar.b();
        return cVar;
    }

    public <E> t a(Class<E> cls, k<E> kVar) {
        return p(kVar, l.b(cls, this.d, kVar));
    }

    public void b(o oVar) {
        final o.b.o oVar3 = o.f(this.b.c(), oVar);
        this.a = oVar3;
        o(getState(), oVar3, this.b.b());
    }

    public synchronized void c(a aVar) {
        this.e.execute(new s.a(this, aVar));
    }

    public t d(k<a<?>> kVar) {
        final o.b.s.b bVar = new s.b(this, kVar, null);
        bVar.b();
        return bVar;
    }

    public <E> t e(p<E> pVar, k<E> kVar) {
        return p(kVar, l.c(pVar, this.d, kVar));
    }

    public o getState() {
        return this.a.a();
    }

    public void q(k kVar) {
        this.f.remove(kVar);
        this.g.remove(kVar);
    }
}
