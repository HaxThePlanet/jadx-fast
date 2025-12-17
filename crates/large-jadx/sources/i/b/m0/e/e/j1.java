package i.b.m0.e.e;

import i.b.j0.a;
import i.b.j0.b;
import i.b.l0.c;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.f.c;
import i.b.m0.j.k;
import i.b.p0.a;
import i.b.r;
import i.b.t0.e;
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
public final class j1<TLeft, TRight, TLeftEnd, TRightEnd, R>  extends i.b.m0.e.e.a<TLeft, R> {

    final w<? extends TRight> b;
    final n<? super TLeft, ? extends w<TLeftEnd>> c;
    final n<? super TRight, ? extends w<TRightEnd>> v;
    final c<? super TLeft, ? super r<TRight>, ? extends R> w;

    interface b {
        public abstract void a(Throwable throwable);

        public abstract void b(boolean z, i.b.m0.e.e.j1.c j1$c2);

        public abstract void c(Throwable throwable);

        public abstract void d(i.b.m0.e.e.j1.d j1$d);

        public abstract void e(boolean z, Object object2);
    }

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
        final Map<Integer, e<TRight>> lefts;
        final c<Object> queue;
        final c<? super TLeft, ? super r<TRight>, ? extends R> resultSelector;
        final n<? super TRight, ? extends w<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights;
        static {
            j1.a.a = 1;
            j1.a.b = 2;
            j1.a.c = 3;
            j1.a.v = 4;
        }

        a(y<? super R> y, n<? super TLeft, ? extends w<TLeftEnd>> n2, n<? super TRight, ? extends w<TRightEnd>> n3, c<? super TLeft, ? super r<TRight>, ? extends R> c4) {
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
                    obj2 = j1.a.c;
                    obj2 = j1.a.v;
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
            int andIncrement;
            if (this.cancelled) {
            }
            this.cancelled = true;
            f();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void e(boolean z, Object object2) {
            Integer obj2;
            synchronized (this) {
                try {
                    obj2 = j1.a.a;
                    obj2 = j1.a.b;
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
            int next;
            int andGet;
            Object iterator;
            Iterator disposables;
            boolean valueOf;
            int rightIndex;
            String next2;
            Object apply;
            i.b.m0.e.e.j1.c cVar;
            if (getAndIncrement() != 0) {
            }
            c queue = this.queue;
            final y downstream = this.downstream;
            next = 1;
            andGet = next;
            while (this.cancelled) {
                disposables = 0;
                if (this.active.get() == 0) {
                } else {
                }
                iterator = disposables;
                valueOf = queue.poll();
                if ((Integer)valueOf == null) {
                } else {
                }
                apply = disposables;
                iterator = queue.poll();
                if ((Integer)valueOf == j1.a.c) {
                } else {
                }
                if ((Integer)valueOf == j1.a.v) {
                }
                this.rights.remove(Integer.valueOf(iterator.index));
                this.disposables.a((j1.c)iterator);
                disposables = this.lefts.remove(Integer.valueOf(iterator.index));
                this.disposables.a((j1.c)iterator);
                if ((e)disposables != null) {
                }
                (e)disposables.onComplete();
                rightIndex = this.rightIndex;
                this.rightIndex = rightIndex + 1;
                this.rights.put(Integer.valueOf(rightIndex), iterator);
                apply = this.rightEnd.apply(iterator);
                b.e(apply, "The rightEnd returned a null ObservableSource");
                cVar = new j1.c(this, disposables, rightIndex);
                this.disposables.b(cVar);
                (w)apply.subscribe(cVar);
                disposables = this.lefts.values().iterator();
                for (e rightIndex : disposables) {
                    rightIndex.onNext(iterator);
                }
                (e)disposables.next().onNext(iterator);
                disposables = e.d();
                int leftIndex = this.leftIndex;
                this.leftIndex = leftIndex + 1;
                this.lefts.put(Integer.valueOf(leftIndex), disposables);
                apply = this.leftEnd.apply(iterator);
                b.e(apply, "The leftEnd returned a null ObservableSource");
                cVar = new j1.c(this, next, leftIndex);
                this.disposables.b(cVar);
                (w)apply.subscribe(cVar);
                Object apply2 = this.resultSelector.apply(iterator, disposables);
                b.e(apply2, "The resultSelector returned a null value");
                downstream.onNext(apply2);
                iterator = this.rights.values().iterator();
                for (Object next2 : iterator) {
                    disposables.onNext(next2);
                }
                disposables.onNext(iterator.next());
                apply = next;
                iterator = next;
            }
            queue.clear();
        }

        void h(y<?> y) {
            Object next;
            Throwable th = k.b(this.error);
            Iterator iterator = this.lefts.values().iterator();
            for (e next : iterator) {
                next.onError(th);
            }
            this.lefts.clear();
            this.rights.clear();
            y.onError(th);
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

    static final class c extends AtomicReference<b> implements y<Object>, b {

        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final i.b.m0.e.e.j1.b parent;
        c(i.b.m0.e.e.j1.b j1$b, boolean z2, int i3) {
            super();
            this.parent = b;
            this.isLeft = z2;
            this.index = i3;
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
        public void onError(Throwable throwable) {
            this.parent.c(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(Object object) {
            boolean isLeft;
            boolean obj2;
            if (c.dispose(this)) {
                this.parent.b(this.isLeft, this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }
    }

    static final class d extends AtomicReference<b> implements y<Object>, b {

        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final i.b.m0.e.e.j1.b parent;
        d(i.b.m0.e.e.j1.b j1$b, boolean z2) {
            super();
            this.parent = b;
            this.isLeft = z2;
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
        public void onError(Throwable throwable) {
            this.parent.a(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(Object object) {
            this.parent.e(this.isLeft, object);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }
    }
    public j1(w<TLeft> w, w<? extends TRight> w2, n<? super TLeft, ? extends w<TLeftEnd>> n3, n<? super TRight, ? extends w<TRightEnd>> n4, c<? super TLeft, ? super r<TRight>, ? extends R> c5) {
        super(w);
        this.b = w2;
        this.c = n3;
        this.v = n4;
        this.w = c5;
    }

    protected void subscribeActual(y<? super R> y) {
        j1.a aVar = new j1.a(y, this.c, this.v, this.w);
        y.onSubscribe(aVar);
        j1.d obj5 = new j1.d(aVar, 1);
        aVar.disposables.b(obj5);
        j1.d dVar = new j1.d(aVar, 0);
        aVar.disposables.b(dVar);
        this.a.subscribe(obj5);
        this.b.subscribe(dVar);
    }
}
