package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.r;
import i.b.y;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableRefCount.java */
/* loaded from: classes3.dex */
public final class o2<T> extends r<T> {

    final i.b.n0.a<T> a;
    final int b;
    final long c;
    final TimeUnit v;
    final z w;
    o2.a x;

    static final class a extends AtomicReference<b> implements Runnable, i.b.l0.f<b> {

        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final o2<?> parent;
        long subscriberCount;
        b timer;
        a(o2<?> o2Var) {
            super();
            this.parent = o2Var;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(b bVar) {
            c.replace(this, bVar);
            synchronized (parent2) {
                try {
                    if (this.disconnectedEarly) {
                        (f)this.parent.a.a(bVar);
                    }
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.parent.g(this);
        }
    }

    static final class b<T> extends AtomicBoolean implements y<T>, b {

        private static final long serialVersionUID = -7419642935409022375L;
        final o2.a connection;
        final y<? super T> downstream;
        final o2<T> parent;
        b upstream;
        b(y<? super T> yVar, o2<T> o2Var, o2.a aVar) {
            super();
            this.downstream = yVar;
            this.parent = o2Var;
            this.connection = aVar;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            this.upstream.dispose();
            boolean z = true;
            if (compareAndSet(false, z)) {
                this.parent.c(this.connection);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onComplete() {
            boolean z = true;
            if (compareAndSet(false, z)) {
                this.parent.f(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.f(this.connection);
                this.downstream.onError(th);
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public o2(i.b.n0.a<T> aVar) {
        this(aVar, 1, 0L, timeUnit, TimeUnit.NANOSECONDS, 0);
    }

    @Override // i.b.r
    void c(o2.a aVar) {
        synchronized (this) {
            try {
                aVar.subscriberCount--;
                long l3 = 0L;
                if (this.c == l3) {
                    g(aVar);
                    return;
                }
                g gVar = new g();
                aVar.timer = gVar;
            } catch (Throwable unused) {
            }
            return;
        }
        gVar.a(this.w.d(aVar, this.c, this.v));
    }

    @Override // i.b.r
    void d(o2.a aVar) {
        if (aVar.timer != null) {
            aVar.timer.dispose();
            b timer2 = null;
            aVar.timer = timer2;
        }
    }

    @Override // i.b.r
    void e(o2.a aVar) {
        z = aVar2 instanceof b;
        if (aVar2 instanceof b) {
            aVar2.dispose();
        } else {
            z = aVar2 instanceof f;
            if (aVar2 instanceof f) {
                aVar2.a((b)aVar.get());
            }
        }
    }

    @Override // i.b.r
    void f(o2.a aVar) {
        synchronized (this) {
            try {
                final i.b.m0.e.e.o2.a aVar5 = null;
                final long l3 = 0L;
                final long l4 = 1L;
                if (this.a instanceof h2) {
                    if (this.x != null && this.x == aVar) {
                        this.x = aVar5;
                        d(aVar);
                    }
                    aVar.subscriberCount -= l4;
                    if (this.a == l3) {
                        e(aVar);
                    }
                } else {
                    if (this.x != null && this.x == aVar) {
                        d(aVar);
                        aVar.subscriberCount -= l4;
                        if (aVar.subscriberCount == l3) {
                            this.x = aVar5;
                            e(aVar);
                        }
                    }
                }
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    @Override // i.b.r
    void g(o2.a aVar) {
        synchronized (this) {
            try {
                long l = 0L;
                if (aVar.subscriberCount == l && aVar == this.x) {
                    this.x = null;
                    Object obj = aVar.get();
                    c.dispose(aVar);
                    if (aVar2 instanceof b) {
                        aVar2.dispose();
                    } else {
                        if (aVar2 instanceof f && obj == null) {
                            aVar.disconnectedEarly = true;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    @Override // i.b.r
    protected void subscribeActual(y<? super T> yVar) {
        i.b.m0.e.e.o2.a aVar;
        long l;
        boolean connected2;
        boolean z = true;
        long l2;
        synchronized (this) {
            try {
                if (this.x == null) {
                    this.x = new o2.a(this);
                }
                if (aVar.timer != null) {
                    aVar.timer.dispose();
                }
                l2 = (long)this.b;
                if (l == l2) {
                    aVar.connected = z;
                } else {
                    int i4 = 0;
                }
            } catch (Throwable th) {
            }
        }
        this.a.subscribe(new o2.b(th, this, aVar));
        if (z) {
            this.a.c(aVar);
        }
    }

    public o2(i.b.n0.a<T> aVar, int i, long j, TimeUnit timeUnit, z zVar) {
        super();
        this.a = aVar;
        this.b = i;
        this.c = j;
        this.v = timeUnit;
        this.w = zVar;
    }
}
