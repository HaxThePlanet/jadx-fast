package i.b.m0.e.e;

import i.b.j0.a;
import i.b.j0.b;
import i.b.l0.c;
import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.f.c;
import i.b.m0.j.k;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class q1<TLeft, TRight, TLeftEnd, TRightEnd, R>  extends i.b.m0.e.e.a<TLeft, R> {

    final w<? extends TRight> b;
    final n<? super TLeft, ? extends w<TLeftEnd>> c;
    final n<? super TRight, ? extends w<TRightEnd>> v;
    final c<? super TLeft, ? super TRight, ? extends R> w;

    static final class a extends AtomicInteger implements b, i.b.m0.e.e.j1.b {

        static final Integer a = null;
        static final Integer b = null;
        static final Integer c = null;
        private static final long serialVersionUID = -6071216598687999801L;
        static final Integer v;
        final AtomicInteger active;
        volatile boolean cancelled;
        final a disposables;
        final y<? super R> downstream;
        final AtomicReference<Throwable> error;
        final n<? super TLeft, ? extends w<TLeftEnd>> leftEnd;
        int leftIndex;
        final Map<Integer, TLeft> lefts;
        final c<Object> queue;
        final c<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final n<? super TRight, ? extends w<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights;
        static {
            q1.a.a = 1;
            q1.a.b = 2;
            q1.a.c = 3;
            q1.a.v = 4;
        }

        a(y<? super R> y, n<? super TLeft, ? extends w<TLeftEnd>> n2, n<? super TRight, ? extends w<TRightEnd>> n3, c<? super TLeft, ? super TRight, ? extends R> c4) {
            super();
            this.downstream = y;
            a obj2 = new a();
            this.disposables = obj2;
            obj2 = new c(r.bufferSize());
            this.queue = obj2;
            obj2 = new LinkedHashMap();
            this.lefts = obj2;
            obj2 = new LinkedHashMap();
            this.rights = obj2;
            obj2 = new AtomicReference();
            this.error = obj2;
            this.leftEnd = n2;
            this.rightEnd = n3;
            this.resultSelector = c4;
            obj2 = new AtomicInteger(2);
            this.active = obj2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void a(Throwable throwable) {
            Object obj2;
            if (k.a(this.error, throwable)) {
                this.active.decrementAndGet();
                g();
            } else {
                a.t(throwable);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void b(boolean z, i.b.m0.e.e.j1.c j1$c2) {
            Integer obj2;
            synchronized (this) {
                try {
                    obj2 = q1.a.c;
                    obj2 = q1.a.v;
                    this.queue.l(obj2, c2);
                    g();
                    throw z;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void c(Throwable throwable) {
            if (k.a(this.error, throwable)) {
                g();
            } else {
                a.t(throwable);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void d(i.b.m0.e.e.j1.d j1$d) {
            this.disposables.c(d);
            this.active.decrementAndGet();
            g();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean andIncrement;
            this.cancelled = true;
            f();
            if (!this.cancelled && getAndIncrement() == 0) {
                this.cancelled = true;
                f();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void e(boolean z, Object object2) {
            Integer obj2;
            synchronized (this) {
                try {
                    obj2 = q1.a.a;
                    obj2 = q1.a.b;
                    this.queue.l(obj2, object2);
                    g();
                    throw z;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f() {
            this.disposables.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void g() {
            int andGet;
            int poll;
            int disposables;
            Object valueOf;
            int rightIndex;
            Object apply;
            int resultSelector;
            String str;
            i.b.m0.e.e.j1.c cVar;
            if (getAndIncrement() != 0) {
            }
            c queue = this.queue;
            final y downstream = this.downstream;
            final int i = 1;
            andGet = i;
            while (this.cancelled) {
                disposables = 0;
                if (this.active.get() == 0) {
                } else {
                }
                poll = disposables;
                valueOf = queue.poll();
                if ((Integer)valueOf == null) {
                } else {
                }
                resultSelector = disposables;
                poll = queue.poll();
                str = "The resultSelector returned a null value";
                if ((Integer)valueOf == q1.a.c) {
                } else {
                }
                this.rights.remove(Integer.valueOf(poll.index));
                this.disposables.a((j1.c)poll);
                this.lefts.remove(Integer.valueOf(poll.index));
                this.disposables.a((j1.c)poll);
                rightIndex = this.rightIndex;
                this.rightIndex = rightIndex + 1;
                this.rights.put(Integer.valueOf(rightIndex), poll);
                resultSelector = this.rightEnd.apply(poll);
                b.e(resultSelector, "The rightEnd returned a null ObservableSource");
                cVar = new j1.c(this, disposables, rightIndex);
                this.disposables.b(cVar);
                (w)resultSelector.subscribe(cVar);
                disposables = this.lefts.values().iterator();
                for (Object next : disposables) {
                    rightIndex = this.resultSelector.apply(next, poll);
                    b.e(rightIndex, str);
                    downstream.onNext(rightIndex);
                }
                rightIndex = this.resultSelector.apply(disposables.next(), poll);
                b.e(rightIndex, str);
                downstream.onNext(rightIndex);
                int leftIndex = this.leftIndex;
                this.leftIndex = leftIndex + 1;
                this.lefts.put(Integer.valueOf(leftIndex), poll);
                apply = this.leftEnd.apply(poll);
                b.e(apply, "The leftEnd returned a null ObservableSource");
                resultSelector = new j1.c(this, i, leftIndex);
                this.disposables.b(resultSelector);
                (w)apply.subscribe(resultSelector);
                disposables = this.rights.values().iterator();
                for (Object next2 : disposables) {
                    apply = this.resultSelector.apply(poll, next2);
                    b.e(apply, str);
                    downstream.onNext(apply);
                }
                apply = this.resultSelector.apply(poll, disposables.next());
                b.e(apply, str);
                downstream.onNext(apply);
                resultSelector = i;
                poll = i;
            }
            queue.clear();
        }

        void h(y<?> y) {
            this.lefts.clear();
            this.rights.clear();
            y.onError(k.b(this.error));
        }

        void i(Throwable throwable, y<?> y2, c<?> c3) {
            a.b(throwable);
            k.a(this.error, throwable);
            c3.clear();
            f();
            h(y2);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }
    }
    public q1(w<TLeft> w, w<? extends TRight> w2, n<? super TLeft, ? extends w<TLeftEnd>> n3, n<? super TRight, ? extends w<TRightEnd>> n4, c<? super TLeft, ? super TRight, ? extends R> c5) {
        super(w);
        this.b = w2;
        this.c = n3;
        this.v = n4;
        this.w = c5;
    }

    protected void subscribeActual(y<? super R> y) {
        q1.a aVar = new q1.a(y, this.c, this.v, this.w);
        y.onSubscribe(aVar);
        j1.d obj5 = new j1.d(aVar, 1);
        aVar.disposables.b(obj5);
        j1.d dVar = new j1.d(aVar, 0);
        aVar.disposables.b(dVar);
        this.a.subscribe(obj5);
        this.b.subscribe(dVar);
    }
}
