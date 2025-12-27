package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.j.k;
import i.b.r;
import i.b.t0.e;
import i.b.w;
import i.b.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableGroupJoin.java */
/* loaded from: classes3.dex */
public final class j1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends a<TLeft, R> {

    final w<? extends TRight> b;
    final n<? super TLeft, ? extends w<TLeftEnd>> c;
    final n<? super TRight, ? extends w<TRightEnd>> v;
    final i.b.l0.c<? super TLeft, ? super r<TRight>, ? extends R> w;

    interface b {
        void a(Throwable th);

        void b(boolean z, j1.c cVar);

        void c(Throwable th);

        void d(j1.d dVar);

        void e(boolean z, Object object);
    }

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
        final Map<Integer, e<TRight>> lefts = new LinkedHashMap<>();
        final i.b.m0.f.c<Object> queue = new c<>();
        final i.b.l0.c<? super TLeft, ? super r<TRight>, ? extends R> resultSelector;
        final n<? super TRight, ? extends w<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights = new LinkedHashMap<>();
        static {
            j1.a.a = 1;
            j1.a.b = 2;
            j1.a.c = 3;
            j1.a.v = 4;
        }

        a(y<? super R> yVar, n<? super TLeft, ? extends w<TLeftEnd>> nVar, n<? super TRight, ? extends w<TRightEnd>> nVar2, i.b.l0.c<? super TLeft, ? super r<TRight>, ? extends R> cVar) {
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
                    z = z != null ? j1.a.c : j1.a.v;
                    this.queue.l((z != null ? j1.a.c : j1.a.v), cVar);
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
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            f();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void e(boolean z, Object object) {
            Integer num;
            synchronized (this) {
                try {
                    z = z != null ? j1.a.a : j1.a.b;
                    this.queue.l((z != null ? j1.a.a : j1.a.b), object);
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
            Object poll;
            Object apply;
            i.b.m0.e.e.j1.c cVar;
            if (getAndIncrement() != 0) {
                return;
            }
            boolean z = true;
            andGet = z;
            while (this.cancelled) {
                Iterator remove = null;
                boolean r4 = this.active.get() == 0 ? z : remove;
                Object poll2 = this.queue.poll();
                boolean r7 = poll2 == null ? z : remove;
                if (addAndGet(-andGet) == 0) {
                    return;
                }
                poll = this.queue.poll();
                Object obj4 = e.d();
                this.leftIndex++;
                this.lefts.put(Integer.valueOf(this.leftIndex), obj4);
                try {
                    apply = this.leftEnd.apply(poll);
                    b.e(apply, "The leftEnd returned a null ObservableSource");
                } catch (Throwable th) {
                    i(th, yVar, cVar2);
                    return;
                }
                cVar = new j1.c(this, z, leftIndex2);
                this.disposables.b(cVar);
                apply.subscribe(cVar);
                if ((Throwable)this.error.get() != null) {
                    this.queue.clear();
                    f();
                    h(this.downstream);
                    return;
                }
                if (poll2 == j1.a.b) {
                    this.rightIndex++;
                    this.rights.put(Integer.valueOf(this.rightIndex), poll);
                }
            }
            this.queue.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void h(y<?> yVar) {
            Throwable th = k.b(this.error);
            Iterator it = this.lefts.values().iterator();
            while (it.hasNext()) {
                (e)it.next().onError(th);
            }
            this.lefts.clear();
            this.rights.clear();
            yVar.onError(th);
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

    static final class c extends AtomicReference<i.b.j0.b> implements y<Object>, i.b.j0.b {

        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final j1.b parent;
        c(j1.b bVar, boolean z, int i) {
            super();
            this.parent = bVar;
            this.isLeft = z;
            this.index = i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.parent.b(this.isLeft, this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.parent.c(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(Object object) {
            if (c.dispose(this)) {
                this.parent.b(this.isLeft, this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this, bVar);
        }
    }

    static final class d extends AtomicReference<i.b.j0.b> implements y<Object>, i.b.j0.b {

        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final j1.b parent;
        d(j1.b bVar, boolean z) {
            super();
            this.parent = bVar;
            this.isLeft = z;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.parent.d(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.parent.a(th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(Object object) {
            this.parent.e(this.isLeft, object);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this, bVar);
        }
    }
    public j1(w<TLeft> wVar, w<? extends TRight> wVar2, n<? super TLeft, ? extends w<TLeftEnd>> nVar, n<? super TRight, ? extends w<TRightEnd>> nVar2, i.b.l0.c<? super TLeft, ? super r<TRight>, ? extends R> cVar) {
        super(wVar);
        this.b = wVar2;
        this.c = nVar;
        this.v = nVar2;
        this.w = cVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super R> yVar) {
        i.b.m0.e.e.j1.a aVar = new j1.a(yVar, this.c, this.v, this.w);
        yVar.onSubscribe(aVar);
        i.b.m0.e.e.j1.d dVar2 = new j1.d(aVar, true);
        aVar.disposables.b(dVar2);
        i.b.m0.e.e.j1.d dVar = new j1.d(aVar, false);
        aVar.disposables.b(dVar);
        this.a.subscribe(dVar2);
        this.b.subscribe(dVar);
    }
}
