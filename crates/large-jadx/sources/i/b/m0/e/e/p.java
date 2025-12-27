package i.b.m0.e.e;

import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.c.j;
import i.b.m0.d.u;
import i.b.m0.j.r;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableBufferTimed.java */
/* loaded from: classes3.dex */
public final class p<T, U extends Collection<? super T>> extends a<T, U> {

    final long b;
    final long c;
    final TimeUnit v;
    final z w;
    final Callable<U> x;
    final int y;
    final boolean z;

    static final class a<T, U extends Collection<? super T>> extends u<T, U, U> implements Runnable, i.b.j0.b {

        final TimeUnit A;
        final int B;
        final boolean C;
        final z.c D;
        U E;
        i.b.j0.b F;
        i.b.j0.b G;
        long H;
        long I;
        final Callable<U> y;
        final long z;
        a(y<? super U> yVar, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, z.c cVar) {
            super(yVar, new a());
            this.y = callable;
            this.z = j;
            this.A = timeUnit;
            this.B = i;
            this.C = z;
            this.D = cVar;
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            if (!this.v) {
                this.v = true;
                this.G.dispose();
                this.D.dispose();
                synchronized (this) {
                    try {
                        this.E = null;
                    } catch (Throwable th) {
                    }
                }
            }
        }

        @Override // i.b.m0.d.u
        public void h(y<? super U> yVar, U u) {
            yVar.onNext(u);
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            this.D.dispose();
            synchronized (this) {
                try {
                    Collection collection2 = null;
                    this.E = collection2;
                } catch (Throwable th) {
                }
            }
            if (this.E != null) {
                this.c.offer(this.E);
                this.w = true;
                if (d()) {
                    boolean z = false;
                    r.c(this.c, this.b, z, this, this);
                }
            }
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable th) {
            synchronized (this) {
                try {
                    this.E = null;
                } catch (Throwable th) {
                }
            }
            this.b.onError(th);
            this.D.dispose();
        }

        @Override // i.b.m0.d.u
        public void onNext(T t) {
            synchronized (this) {
                try {
                    if (this.E == null) {
                        return;
                    }
                    this.E.add(t);
                    if (this.E.size() < this.B) {
                        return;
                    }
                } catch (Throwable th) {
                    a.b(th);
                    this.b.onError(th);
                    dispose();
                    return;
                }
            }
            if (this.C) {
                this.F.dispose();
            }
            g(this.E, false, this);
            try {
                Object call = this.y.call();
                b.e(call, "The buffer supplied is null");
            } catch (Throwable th) {
                a.b(th);
                this.b.onError(th);
                dispose();
                return;
            }
            synchronized (this) {
                try {
                    this.E = call;
                    this.I += l6;
                } catch (Throwable th) {
                }
            }
            if (this.C) {
                this.F = this.D.d(this, l3, this.z, this.A);
            }
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.G, bVar)) {
                this.G = bVar;
                try {
                    Object call = this.y.call();
                    b.e(call, "The buffer supplied is null");
                } catch (Throwable th) {
                    a.b(th);
                    bVar.dispose();
                    d.error(th, this.b);
                    this.b.dispose();
                }
                this.E = call;
                this.b.onSubscribe(this);
                this.F = this.D.d(this, l, this.z, this.A);
            }
        }

        @Override // i.b.m0.d.u
        public void run() {
            try {
                Object call = this.y.call();
                b.e(call, "The bufferSupplier returned a null buffer");
            } catch (Throwable unused) {
            }
            synchronized (this) {
                try {
                    this.E = call;
                } catch (Throwable unused) {
                }
                try {
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
            g(this.E, false, this);
        }
    }

    static final class b<T, U extends Collection<? super T>> extends u<T, U, U> implements Runnable, i.b.j0.b {

        final TimeUnit A;
        final z B;
        i.b.j0.b C;
        U D;
        final AtomicReference<i.b.j0.b> E = new AtomicReference<>();
        final Callable<U> y;
        final long z;
        b(y<? super U> yVar, Callable<U> callable, long j, TimeUnit timeUnit, z zVar) {
            super(yVar, new a());
            final AtomicReference atomicReference = new AtomicReference();
            this.y = callable;
            this.z = j;
            this.A = timeUnit;
            this.B = zVar;
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            c.dispose(this.E);
            this.C.dispose();
        }

        @Override // i.b.m0.d.u
        public void h(y<? super U> yVar, U u) {
            this.b.onNext(u);
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.E.get() == c.DISPOSED ? 1 : 0;
            return (this.E.get() == c.DISPOSED ? 1 : 0);
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            synchronized (this) {
                try {
                    final Collection collection2 = null;
                    this.D = collection2;
                } catch (Throwable th) {
                }
            }
            if (this.D != null) {
                this.c.offer(this.D);
                this.w = true;
                if (d()) {
                    boolean z = false;
                    r.c(this.c, this.b, z, collection2, this);
                }
            }
            c.dispose(this.E);
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable th) {
            synchronized (this) {
                try {
                    this.D = null;
                } catch (Throwable th) {
                }
            }
            this.b.onError(th);
            c.dispose(this.E);
        }

        @Override // i.b.m0.d.u
        public void onNext(T t) {
            synchronized (this) {
                try {
                    if (this.D == null) {
                        return;
                    }
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.C, bVar)) {
                this.C = bVar;
                try {
                    Object call = this.y.call();
                    b.e(call, "The buffer supplied is null");
                } catch (Throwable th) {
                    a.b(th);
                    dispose();
                    d.error(th, this.b);
                }
                this.D = call;
                this.b.onSubscribe(this);
                if (!this.v) {
                    i.b.j0.b bVar4 = this.B.e(this, l, this.z, this.A);
                    Object obj = null;
                    if (!this.E.compareAndSet(obj, bVar4)) {
                        bVar4.dispose();
                    }
                }
            }
        }

        @Override // i.b.m0.d.u
        public void run() {
            try {
                Object call = this.y.call();
                b.e(call, "The bufferSupplier returned a null buffer");
            } catch (Throwable th) {
            }
            synchronized (this) {
                try {
                    if (this.D != null) {
                        this.D = call;
                    }
                } catch (Throwable th) {
                }
            }
            if (this.D == null) {
                c.dispose(this.E);
                return;
            }
            f(this.D, false, this);
        }
    }

    static final class c<T, U extends Collection<? super T>> extends u<T, U, U> implements Runnable, i.b.j0.b {

        final long A;
        final TimeUnit B;
        final z.c C;
        final List<U> D = new LinkedList<>();
        i.b.j0.b E;
        final Callable<U> y;
        final long z;
        c(y<? super U> yVar, Callable<U> callable, long j, long j2, TimeUnit timeUnit, z.c cVar) {
            super(yVar, new a());
            this.y = callable;
            this.z = j;
            this.A = j2;
            this.B = timeUnit;
            this.C = cVar;
            final LinkedList linkedList = new LinkedList();
        }

        static /* synthetic */ void i(p.c cVar, Object object, boolean z, i.b.j0.b bVar) {
            cVar.g(object, z, bVar);
        }

        static /* synthetic */ void j(p.c cVar, Object object, boolean z, i.b.j0.b bVar) {
            cVar.g(object, z, bVar);
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            if (!this.v) {
                this.v = true;
                k();
                this.E.dispose();
                this.C.dispose();
            }
        }

        @Override // i.b.m0.d.u
        public void h(y<? super U> yVar, U u) {
            yVar.onNext(u);
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
        }

        @Override // i.b.m0.d.u
        void k() {
            synchronized (this) {
                try {
                    this.D.clear();
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            i.b.m0.c.i iVar;
            synchronized (this) {
                try {
                    this.D.clear();
                } catch (Throwable th) {
                }
            }
            Iterator it = new ArrayList(this.D).iterator();
            while (it.hasNext()) {
                this.c.offer((Collection)it.next());
            }
            this.w = true;
            if (d()) {
                r.c(this.c, this.b, false, this.C, this);
            }
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable th) {
            this.w = true;
            k();
            this.b.onError(th);
            this.C.dispose();
        }

        @Override // i.b.m0.d.u
        public void onNext(T t) {
            synchronized (this) {
                try {
                    Iterator it = this.D.iterator();
                    while (it.hasNext()) {
                        (Collection)it.next().add(t);
                    }
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.E, bVar)) {
                this.E = bVar;
                try {
                    Object call = this.y.call();
                    b.e(call, "The buffer supplied is null");
                } catch (Throwable th) {
                    a.b(th);
                    bVar.dispose();
                    d.error(th, this.b);
                    this.b.dispose();
                }
                this.D.add(call);
                this.b.onSubscribe(this);
                this.C.d(this, l2, this.A, this.B);
                this.C.c(new p.c.b(this, call), this.z, this.B);
            }
        }

        @Override // i.b.m0.d.u
        public void run() {
            if (this.v) {
                return;
            }
            try {
                Object call = this.y.call();
                b.e(call, "The bufferSupplier returned a null buffer");
            } catch (Throwable th) {
            }
            synchronized (this) {
                try {
                    if (this.v) {
                        return;
                    }
                    this.D.add(call);
                } catch (Throwable th) {
                }
            }
            this.C.c(new p.c.a(this, call), this.z, this.B);
        }
    }
    public p(w<T> wVar, long j, long j2, TimeUnit timeUnit, z zVar, Callable<U> callable, int i, boolean z) {
        super(wVar);
        this.b = j;
        this.c = j2;
        this.v = timeUnit;
        this.w = zVar;
        this.x = callable;
        this.y = i;
        this.z = z;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super U> yVar) {
        if (this.b == this.c && this.y == Integer.MAX_VALUE) {
            p.b bVar = new p.b(new e(yVar), this.x, l2, timeUnit, this.v, this.w);
            this.a.subscribe(bVar);
            return;
        }
        final z.c cVar3 = this.w.a();
        if (this.b == this.c) {
            p.a aVar = new p.a(new e(yVar), this.x, l3, timeUnit2, this.v, this.y, this.z, cVar3);
            this.a.subscribe(aVar);
            return;
        }
        p.c cVar = new p.c(new e(yVar), this.x, l3, timeUnit2, l4, cVar2, this.v, cVar3);
        this.a.subscribe(cVar);
    }
}
