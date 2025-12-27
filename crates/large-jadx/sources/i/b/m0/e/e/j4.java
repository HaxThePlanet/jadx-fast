package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.d.u;
import i.b.m0.f.a;
import i.b.m0.j.n;
import i.b.r;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableWindowTimed.java */
/* loaded from: classes3.dex */
public final class j4<T> extends a<T, r<T>> {

    final long b;
    final long c;
    final TimeUnit v;
    final z w;
    final long x;
    final int y;
    final boolean z;

    static final class a<T> extends u<T, Object, r<T>> implements b {

        final z A;
        final int B;
        final boolean C;
        final long D;
        final z.c E = null;
        long F;
        long G;
        b H;
        i.b.t0.e<T> I;
        volatile boolean J;
        final g K = new g();
        final long y;
        final TimeUnit z;
        a(y<? super r<T>> yVar, long j, TimeUnit timeUnit, z zVar, int i, long j2, boolean z) {
            super(yVar, new a());
            g gVar = new g();
            this.y = j;
            this.z = timeUnit;
            this.A = zVar;
            this.B = i;
            this.D = j2;
            this.C = z;
            if (z) {
                this.E = zVar.a();
            } else {
                i = 0;
            }
        }

        static /* synthetic */ boolean h(j4.a aVar) {
            return aVar.v;
        }

        static /* synthetic */ i i(j4.a aVar) {
            return aVar.c;
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            this.v = true;
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
        }

        @Override // i.b.m0.d.u
        void j() {
            c.dispose(this.K);
            if (this.E != null) {
                this.E.dispose();
            }
        }

        @Override // i.b.m0.d.u
        void k() {
            i.b.t0.e eVar;
            int i;
            boolean compareAndSet;
            long l;
            i.b.m0.e.e.j4.a aVar = null;
            long l2;
            int cmp;
            TimeUnit timeUnit;
            i = 1;
            while (this.J) {
                Object poll = iVar.poll();
                int r7 = poll == null ? i : 0;
                l2 = poll instanceof j4.a.a;
                if (i != 0) {
                }
            }
            this.H.dispose();
            iVar.clear();
            j();
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            this.w = true;
            if (d()) {
                k();
            }
            this.b.onComplete();
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable th) {
            this.x = th;
            this.w = true;
            if (d()) {
                k();
            }
            this.b.onError(th);
        }

        @Override // i.b.m0.d.u
        public void onNext(T t) {
            i.b.t0.e eVar;
            long l = 0;
            long l2;
            TimeUnit timeUnit;
            if (this.J) {
                return;
            }
            if (e()) {
                this.I.onNext(t);
                long l3 = 1L;
                if (this.F < this.D) {
                    this.F += l3;
                } else {
                    this.G += l3;
                    l = 0L;
                    this.F = l;
                    this.I.onComplete();
                    i.b.t0.e eVar2 = e.e(this.B);
                    this.I = eVar2;
                    this.b.onNext(eVar2);
                    if (this.C) {
                        (b)this.K.get().dispose();
                        c.replace(this.K, this.E.d(new j4.a.a(this.G, l3, this), l2, this.y, this.z));
                    }
                }
                if (c(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(n.next(t));
                if (!d()) {
                    return;
                }
            }
            k();
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(b bVar) {
            z zVar;
            long l;
            TimeUnit timeUnit;
            b bVar2;
            if (c.validate(this.H, bVar)) {
                this.H = bVar;
                this.b.onSubscribe(this);
                if (this.v) {
                    return;
                }
                i.b.t0.e eVar = e.e(this.B);
                this.I = eVar;
                this.b.onNext(eVar);
                i.b.m0.e.e.j4.a.a aVar = new j4.a.a(this.G, r1, this);
                if (this.C) {
                    bVar2 = this.E.d(aVar, l, this.y, this.z);
                } else {
                    bVar2 = this.A.e(aVar, l, this.y, this.z);
                }
                this.K.a(bVar2);
            }
        }
    }

    static final class b<T> extends u<T, Object, r<T>> implements y<T>, b, Runnable {

        static final Object G = new Object();
        final z A;
        final int B;
        b C;
        i.b.t0.e<T> D;
        final g E = new g();
        volatile boolean F;
        final long y;
        final TimeUnit z;

        b(y<? super r<T>> yVar, long j, TimeUnit timeUnit, z zVar, int i) {
            super(yVar, new a());
            final g gVar = new g();
            this.y = j;
            this.z = timeUnit;
            this.A = zVar;
            this.B = i;
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            this.v = true;
        }

        @Override // i.b.m0.d.u
        void h() {
            i.b.t0.e eVar;
            int i = 1;
            Object obj;
            i = 1;
            Object poll = iVar.poll();
            while (this.w) {
                if (poll == null) {
                }
            }
            this.D = null;
            iVar.clear();
            if (this.x != null) {
                eVar.onError(this.x);
            } else {
                eVar.onComplete();
            }
            this.E.dispose();
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            this.w = true;
            if (d()) {
                h();
            }
            this.b.onComplete();
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable th) {
            this.x = th;
            this.w = true;
            if (d()) {
                h();
            }
            this.b.onError(th);
        }

        @Override // i.b.m0.d.u
        public void onNext(T t) {
            if (this.F) {
                return;
            }
            if (e()) {
                this.D.onNext(t);
                if (c(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(n.next(t));
                if (!d()) {
                    return;
                }
            }
            h();
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(b bVar) {
            if (c.validate(this.C, bVar)) {
                this.C = bVar;
                this.D = e.e(this.B);
                this.b.onSubscribe(this);
                this.b.onNext(this.D);
                if (!this.v) {
                    this.E.a(this.A.e(this, l, this.y, this.z));
                }
            }
        }

        @Override // i.b.m0.d.u
        public void run() {
            if (this.v) {
                boolean z = true;
                this.F = z;
            }
            this.c.offer(j4.b.G);
            if (d()) {
                h();
            }
        }
    }

    static final class c<T> extends u<T, Object, r<T>> implements b, Runnable {

        final TimeUnit A;
        final z.c B;
        final int C;
        final List<i.b.t0.e<T>> D = new LinkedList<>();
        b E;
        volatile boolean F;
        final long y;
        final long z;
        c(y<? super r<T>> yVar, long j, long j2, TimeUnit timeUnit, z.c cVar, int i) {
            super(yVar, new a());
            this.y = j;
            this.z = j2;
            this.A = timeUnit;
            this.B = cVar;
            this.C = i;
            final LinkedList linkedList = new LinkedList();
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            this.v = true;
        }

        @Override // i.b.m0.d.u
        void h(i.b.t0.e<T> eVar) {
            this.c.offer(new j4.c.b(eVar, false));
            if (d()) {
                i();
            }
        }

        @Override // i.b.m0.d.u
        void i() {
            int i;
            boolean hasNext2 = false;
            boolean hasNext = true;
            i = hasNext;
            while (this.F) {
                Object poll = iVar.poll();
                boolean r7 = poll == null ? hasNext : 0;
                l = poll instanceof j4.c.b;
                if (hasNext2) {
                }
            }
            this.E.dispose();
            iVar.clear();
            this.D.clear();
            this.B.dispose();
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            this.w = true;
            if (d()) {
                i();
            }
            this.b.onComplete();
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable th) {
            this.x = th;
            this.w = true;
            if (d()) {
                i();
            }
            this.b.onError(th);
        }

        @Override // i.b.m0.d.u
        public void onNext(T t) {
            if (e()) {
                Iterator it = this.D.iterator();
                while (it.hasNext()) {
                    (e)it.next().onNext(t);
                }
                if (c(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(t);
                if (!d()) {
                    return;
                }
            }
            i();
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(b bVar) {
            if (c.validate(this.E, bVar)) {
                this.E = bVar;
                this.b.onSubscribe(this);
                if (this.v) {
                    return;
                }
                i.b.t0.e eVar = e.e(this.C);
                this.D.add(eVar);
                this.b.onNext(eVar);
                this.B.c(new j4.c.a(this, eVar), this.y, this.A);
                this.B.d(this, l2, this.z, this.A);
            }
        }

        @Override // i.b.m0.d.u
        public void run() {
            if (!this.v) {
                this.c.offer(new j4.c.b(e.e(this.C), true));
            }
            if (d()) {
                i();
            }
        }
    }
    public j4(w<T> wVar, long j, long j2, TimeUnit timeUnit, z zVar, long j3, int i, boolean z) {
        super(wVar);
        this.b = j;
        this.c = j2;
        this.v = timeUnit;
        this.w = zVar;
        this.x = j3;
        this.y = i;
        this.z = z;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super r<T>> yVar) {
        final i.b.o0.e eVar = new e(yVar);
        if (this.b == this.c) {
            if (this.x == 9223372036854775807L) {
                j4.b bVar = new j4.b(eVar, this.b, timeUnit, this.v, this.w, this.y);
                this.a.subscribe(bVar);
                return;
            }
            j4.a aVar = new j4.a(eVar, l, timeUnit, this.v, this.w, this.y, l5, obj, this.z);
            this.a.subscribe(aVar);
            return;
        }
        j4.c cVar = new j4.c(eVar, l, timeUnit, l3, cVar2, this.v, this.w.a(), this.y);
        this.a.subscribe(cVar);
    }
}
