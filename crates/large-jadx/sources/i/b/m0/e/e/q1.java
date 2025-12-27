package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.j.k;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableJoin.java */
/* loaded from: classes3.dex */
public final class q1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends a<TLeft, R> {

    final w<? extends TRight> b;
    final n<? super TLeft, ? extends w<TLeftEnd>> c;
    final n<? super TRight, ? extends w<TRightEnd>> v;
    final i.b.l0.c<? super TLeft, ? super TRight, ? extends R> w;

    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements i.b.j0.b, j1.b {

        static final Integer a;
        static final Integer b;
        static final Integer c;
        private static final long serialVersionUID = -6071216598687999801L;
        static final Integer v;
        final AtomicInteger active = new AtomicInteger(2);
        volatile boolean cancelled;
        final i.b.j0.a disposables = new a();
        final y<? super R> downstream;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final n<? super TLeft, ? extends w<TLeftEnd>> leftEnd;
        int leftIndex;
        final Map<Integer, TLeft> lefts = new LinkedHashMap<>();
        final i.b.m0.f.c<Object> queue = new c<>();
        final i.b.l0.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final n<? super TRight, ? extends w<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights = new LinkedHashMap<>();
        static {
            q1.a.a = 1;
            q1.a.b = 2;
            q1.a.c = 3;
            q1.a.v = 4;
        }

        a(y<? super R> yVar, n<? super TLeft, ? extends w<TLeftEnd>> nVar, n<? super TRight, ? extends w<TRightEnd>> nVar2, i.b.l0.c<? super TLeft, ? super TRight, ? extends R> cVar) {
            super();
            this.downstream = yVar;
            i.b.j0.a aVar = new a();
            cVar = new c(r.bufferSize());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            AtomicReference atomicReference = new AtomicReference();
            this.leftEnd = nVar;
            this.rightEnd = nVar2;
            this.resultSelector = cVar;
            AtomicInteger atomicInteger = new AtomicInteger(2);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void a(Throwable th) {
            if (k.a(this.error, th)) {
                this.active.decrementAndGet();
                g();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void b(boolean z, j1.c cVar) {
            Integer num;
            synchronized (this) {
                try {
                    z = z != null ? q1.a.c : q1.a.v;
                    this.queue.l((z != null ? q1.a.c : q1.a.v), cVar);
                } catch (Throwable th) {
                }
            }
            g();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void c(Throwable th) {
            if (k.a(this.error, th)) {
                g();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void d(j1.d dVar) {
            this.disposables.c(dVar);
            this.active.decrementAndGet();
            g();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                f();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void e(boolean z, Object object) {
            Integer num;
            synchronized (this) {
                try {
                    z = z != null ? q1.a.a : q1.a.b;
                    this.queue.l((z != null ? q1.a.a : q1.a.b), object);
                } catch (Throwable th) {
                }
            }
            g();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f() {
            this.disposables.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void g() {
            int andGet;
            int i;
            int i2;
            Integer num;
            String str;
            i.b.m0.e.e.j1.c cVar;
            if (getAndIncrement() != 0) {
                return;
            }
            final boolean z = true;
            andGet = z;
            while (this.cancelled) {
                boolean z2 = false;
                boolean r4 = this.active.get() == 0 ? z : z2;
                Object poll2 = this.queue.poll();
                boolean r7 = poll2 == null ? z : z2;
                if (addAndGet(-andGet) == 0) {
                    return;
                }
                Object poll = this.queue.poll();
                str = "The resultSelector returned a null value";
                this.leftIndex++;
                this.lefts.put(Integer.valueOf(this.leftIndex), poll);
                try {
                    Object apply = this.leftEnd.apply(poll);
                    b.e(apply, "The leftEnd returned a null ObservableSource");
                } catch (Throwable th) {
                    i(th, yVar, cVar2);
                    return;
                }
                i.b.m0.e.e.j1.c cVar3 = new j1.c(this, z, leftIndex2);
                this.disposables.b(cVar3);
                apply.subscribe(cVar3);
                if ((Throwable)this.error.get() != null) {
                    this.queue.clear();
                    f();
                    h(this.downstream);
                    return;
                }
                if (poll2 == q1.a.b) {
                    this.rightIndex++;
                    this.rights.put(Integer.valueOf(this.rightIndex), poll);
                }
            }
            this.queue.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void h(y<?> yVar) {
            this.lefts.clear();
            this.rights.clear();
            yVar.onError(k.b(this.error));
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void i(Throwable th, y<?> yVar, i.b.m0.f.c<?> cVar) {
            a.b(th);
            k.a(this.error, th);
            cVar.clear();
            f();
            h(yVar);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }
    }
    public q1(w<TLeft> wVar, w<? extends TRight> wVar2, n<? super TLeft, ? extends w<TLeftEnd>> nVar, n<? super TRight, ? extends w<TRightEnd>> nVar2, i.b.l0.c<? super TLeft, ? super TRight, ? extends R> cVar) {
        super(wVar);
        this.b = wVar2;
        this.c = nVar;
        this.v = nVar2;
        this.w = cVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super R> yVar) {
        i.b.m0.e.e.q1.a aVar = new q1.a(yVar, this.c, this.v, this.w);
        yVar.onSubscribe(aVar);
        i.b.m0.e.e.j1.d dVar2 = new j1.d(aVar, true);
        aVar.disposables.b(dVar2);
        i.b.m0.e.e.j1.d dVar = new j1.d(aVar, false);
        aVar.disposables.b(dVar);
        this.a.subscribe(dVar2);
        this.b.subscribe(dVar);
    }
}
