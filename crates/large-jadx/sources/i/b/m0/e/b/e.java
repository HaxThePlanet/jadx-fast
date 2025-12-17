package i.b.m0.e.b;

import i.b.a;
import i.b.h;
import i.b.i;
import i.b.j;
import i.b.m0.a.g;
import i.b.m0.f.c;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.p0.a;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class e<T>  extends h<T> {

    final j<T> b;
    final a c;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            e.a.a = iArr;
            iArr[a.MISSING.ordinal()] = 1;
            e.a.a[a.ERROR.ordinal()] = 2;
            e.a.a[a.DROP.ordinal()] = 3;
            e.a.a[a.LATEST.ordinal()] = 4;
        }
    }

    static abstract class b extends AtomicLong implements i<T>, c {

        private static final long serialVersionUID = 7326289992464377023L;
        final b<? super T> downstream;
        final g serial;
        b(b<? super T> b) {
            super();
            this.downstream = b;
            g obj1 = new g();
            this.serial = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        protected void a() {
            if (c()) {
            }
            this.downstream.onComplete();
            this.serial.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        protected boolean b(Throwable throwable) {
            Object serial;
            Object obj2;
            if (throwable == null) {
                obj2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (c()) {
                return 0;
            }
            this.downstream.onError(obj2);
            this.serial.dispose();
            return 1;
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public final boolean c() {
            return this.serial.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public final void cancel() {
            this.serial.dispose();
            f();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public final void d(Throwable throwable) {
            if (!g(throwable)) {
                a.t(throwable);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        void e() {
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        void f() {
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public boolean g(Throwable throwable) {
            return b(throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public final void request(long l) {
            if (g.validate(l)) {
                d.a(this, l);
                e();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            Object[] arr = new Object[2];
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }

    static final class c extends i.b.m0.e.b.e.b<T> {

        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final c<T> queue;
        final AtomicInteger wip;
        c(b<? super T> b, int i2) {
            super(b);
            c obj1 = new c(i2);
            this.queue = obj1;
            obj1 = new AtomicInteger();
            this.wip = obj1;
        }

        @Override // i.b.m0.e.b.e$b
        void e() {
            h();
        }

        @Override // i.b.m0.e.b.e$b
        void f() {
            int andIncrement;
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // i.b.m0.e.b.e$b
        public boolean g(Throwable throwable) {
            boolean done;
            java.lang.NullPointerException obj2;
            if (!this.done) {
                if (c()) {
                } else {
                    if (throwable == null) {
                        obj2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                    }
                }
                this.error = obj2;
                obj2 = 1;
                this.done = obj2;
                h();
                return obj2;
            }
            return 0;
        }

        @Override // i.b.m0.e.b.e$b
        void h() {
            int andGet;
            AtomicInteger wip;
            long done2;
            boolean empty;
            int i2;
            int i3;
            int cmp;
            boolean done;
            Object poll;
            int i;
            if (this.wip.getAndIncrement() != 0) {
            }
            final c queue = this.queue;
            final int i4 = 1;
            andGet = i4;
            while (/* condition */) {
                cmp = Long.compare(i3, done2);
                while (cmp != 0) {
                    poll = queue.poll();
                    if (poll == null) {
                    } else {
                    }
                    i = 0;
                    this.downstream.onNext(poll);
                    i3 += cmp;
                    cmp = Long.compare(i3, done2);
                    i = i4;
                }
                if (Long.compare(i3, i2) != 0) {
                }
                i2 = 0;
                i3 = i2;
                d.d(this, i3);
                poll = queue.poll();
                if (poll == null) {
                } else {
                }
                i = 0;
                downstream.onNext(poll);
                i3 += cmp;
                i = i4;
            }
            queue.clear();
        }

        public void onNext(T t) {
            boolean queue;
            if (!this.done) {
                if (c()) {
                } else {
                    if (t == null) {
                        NullPointerException obj2 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                        d(obj2);
                    }
                    this.queue.offer(t);
                    h();
                }
            }
        }
    }

    static final class f extends i.b.m0.e.b.e.b<T> {

        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        final AtomicInteger wip;
        f(b<? super T> b) {
            super(b);
            AtomicReference obj1 = new AtomicReference();
            this.queue = obj1;
            obj1 = new AtomicInteger();
            this.wip = obj1;
        }

        @Override // i.b.m0.e.b.e$b
        void e() {
            h();
        }

        @Override // i.b.m0.e.b.e$b
        void f() {
            int andIncrement;
            int i;
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(0);
            }
        }

        @Override // i.b.m0.e.b.e$b
        public boolean g(Throwable throwable) {
            boolean nullPointerException;
            String str;
            if (!this.done) {
                if (c()) {
                } else {
                    if (throwable == null) {
                        nullPointerException = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                        d(nullPointerException);
                    }
                }
                this.error = throwable;
                int obj3 = 1;
                this.done = obj3;
                h();
                return obj3;
            }
            return 0;
        }

        @Override // i.b.m0.e.b.e$b
        void h() {
            int andGet;
            AtomicInteger wip;
            long done2;
            Object obj;
            int i2;
            int i;
            int cmp;
            int i4;
            int i5;
            boolean done;
            Object andSet;
            int i3;
            final Object obj2 = this;
            if (obj2.wip.getAndIncrement() != 0) {
            }
            final AtomicReference queue = obj2.queue;
            final int i6 = 1;
            andGet = i6;
            while (/* condition */) {
                cmp = Long.compare(i, done2);
                i5 = 0;
                while (cmp != 0) {
                    andSet = queue.getAndSet(i5);
                    if (andSet == null) {
                    } else {
                    }
                    i3 = i4;
                    obj2.downstream.onNext(andSet);
                    i += cmp;
                    cmp = Long.compare(i, done2);
                    i5 = 0;
                    i3 = i6;
                }
                if (Long.compare(i, i2) != 0) {
                }
                i2 = 0;
                i = i2;
                d.d(obj2, i);
                if (queue.get() == null) {
                }
                i4 = i6;
                andSet = queue.getAndSet(i5);
                if (andSet == null) {
                } else {
                }
                i3 = i4;
                downstream.onNext(andSet);
                i += cmp;
                i3 = i6;
            }
            queue.lazySet(i5);
        }

        public void onNext(T t) {
            boolean queue;
            if (!this.done) {
                if (c()) {
                } else {
                    if (t == null) {
                        NullPointerException obj2 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                        d(obj2);
                    }
                    this.queue.set(t);
                    h();
                }
            }
        }
    }

    static final class g extends i.b.m0.e.b.e.b<T> {

        private static final long serialVersionUID = 3776720187248809713L;
        g(b<? super T> b) {
            super(b);
        }

        public void onNext(T t) {
            b downstream;
            int i;
            Object obj5;
            if (c()) {
            }
            if (t != null) {
                this.downstream.onNext(t);
                downstream = get();
                while (Long.compare(downstream, i) != 0) {
                    if (compareAndSet(downstream, obj1) == null) {
                    }
                    downstream = get();
                }
            }
            obj5 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            d(obj5);
        }
    }

    static abstract class h extends i.b.m0.e.b.e.b<T> {

        private static final long serialVersionUID = 4127754106204442833L;
        h(b<? super T> b) {
            super(b);
        }

        @Override // i.b.m0.e.b.e$b
        abstract void h();

        public final void onNext(T t) {
            int cmp;
            if (c()) {
            }
            if (t == null) {
                NullPointerException obj5 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                d(obj5);
            }
            if (Long.compare(l, i) != 0) {
                this.downstream.onNext(t);
                d.d(this, 1);
            } else {
                h();
            }
        }
    }

    static final class d extends i.b.m0.e.b.e.h<T> {

        private static final long serialVersionUID = 8360058422307496563L;
        d(b<? super T> b) {
            super(b);
        }

        @Override // i.b.m0.e.b.e$h
        void h() {
        }
    }

    static final class e extends i.b.m0.e.b.e.h<T> {

        private static final long serialVersionUID = 338953216916120960L;
        e(b<? super T> b) {
            super(b);
        }

        @Override // i.b.m0.e.b.e$h
        void h() {
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("create: could not emit value due to lack of requests");
            d(missingBackpressureException);
        }
    }
    public e(j<T> j, a a2) {
        super();
        this.b = j;
        this.c = a2;
    }

    public void c0(b<? super T> b) {
        i.b.m0.e.b.e.b eVar;
        int i;
        j obj3;
        int i2 = e.a.a[this.c.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        eVar = new e.c(b, h.b());
                    } else {
                        eVar = new e.f(b);
                    }
                } else {
                    eVar = new e.d(b);
                }
            } else {
                eVar = new e.e(b);
            }
        } else {
            eVar = new e.g(b);
        }
        b.onSubscribe(eVar);
        this.b.subscribe(eVar);
    }
}
