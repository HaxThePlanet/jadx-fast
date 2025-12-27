package i.b.m0.e.b;

import i.b.h;
import i.b.i;
import i.b.j;
import i.b.m0.j.d;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.b;

/* compiled from: FlowableCreate.java */
/* loaded from: classes3.dex */
public final class e<T> extends h<T> {

    final j<T> b;
    final i.b.a c;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[a.values().length];
            e.a.a = iArr;
            try {
                iArr[a.MISSING.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                e.a.a[a.ERROR.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                e.a.a[a.DROP.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                e.a.a[a.LATEST.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    static abstract class b<T> extends AtomicLong implements i<T>, m.c.c {

        private static final long serialVersionUID = 7326289992464377023L;
        final b<? super T> downstream;
        final i.b.m0.a.g serial = new g();
        b(b<? super T> bVar) {
            super();
            this.downstream = bVar;
            final i.b.m0.a.g gVar = new g();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        protected void a() {
            if (c()) {
                return;
            }
            try {
                this.downstream.onComplete();
            } finally {
                this.serial.dispose();
                throw th;
            }
            this.serial.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        protected boolean b(Throwable th) {
            Object obj;
            if (th == null) {
                str = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
                java.lang.NullPointerException nullPointerException = new NullPointerException(str);
            }
            if (c()) {
                return false;
            }
            try {
                this.downstream.onError(obj);
            } finally {
                this.serial.dispose();
                throw th;
            }
            this.serial.dispose();
            return true;
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
        public final void d(Throwable th) {
            if (!g(th)) {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public boolean g(Throwable th) {
            return b(th);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public final void request(long j) {
            if (g.validate(j)) {
                d.a(this, j);
                e();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            Object[] arr = new Object[2];
            return String.format("%s{%s}", new Object[] { getClass().getSimpleName(), super.toString() });
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        void e() {
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        void f() {
        }
    }

    static final class c<T> extends e.b<T> {

        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final i.b.m0.f.c<T> queue = new c<>();
        final AtomicInteger wip = new AtomicInteger();
        c(b<? super T> bVar, int i) {
            super(bVar);
            i.b.m0.f.c cVar = new c(i);
            AtomicInteger atomicInteger = new AtomicInteger();
        }

        @Override // i.b.m0.e.b.e$b
        void e() {
            h();
        }

        @Override // i.b.m0.e.b.e$b
        void f() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // i.b.m0.e.b.e$b
        public boolean g(Throwable th) {
            java.lang.NullPointerException nullPointerException;
            return false;
        }

        @Override // i.b.m0.e.b.e$b
        void h() {
            int andGet;
            boolean empty;
            long l3;
            int cmp;
            boolean done2;
            Object poll;
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while (/* condition */) {
                while (l3 != l) {
                    poll = this.queue.poll();
                    int r13 = poll == null ? andGet : 0;
                }
                if (this.wip.addAndGet(-andGet) == 0) {
                    return;
                }
                long l = get();
                long l2 = 0L;
                int i2 = l2;
                poll = this.queue.poll();
                r13 = poll == null ? andGet : 0;
            }
            this.queue.clear();
        }

        @Override // i.b.m0.e.b.e$b
        public void onNext(T t) {
        }
    }

    static final class f<T> extends e.b<T> {

        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();
        f(b<? super T> bVar) {
            super(bVar);
            AtomicReference atomicReference = new AtomicReference();
            AtomicInteger atomicInteger = new AtomicInteger();
        }

        @Override // i.b.m0.e.b.e$b
        void e() {
            h();
        }

        @Override // i.b.m0.e.b.e$b
        void f() {
            if (this.wip.getAndIncrement() == 0) {
                Object obj = null;
                this.queue.lazySet(obj);
            }
        }

        @Override // i.b.m0.e.b.e$b
        public boolean g(Throwable th) {
            return false;
        }

        @Override // i.b.m0.e.b.e$b
        void h() {
            int andGet;
            Object obj;
            long l3;
            int cmp;
            Object obj2 = null;
            boolean done2;
            Object andSet;
            final Object obj3 = this;
            if (obj3.wip.getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while (/* condition */) {
                andGet = 0;
                obj2 = null;
                while (l3 != l) {
                    andSet = obj3.queue.getAndSet(obj2);
                    int r16 = andSet == null ? andGet : 0;
                }
                if (obj3.wip.addAndGet(-andGet) == 0) {
                    return;
                }
                long l = get();
                long l2 = 0L;
                int i2 = l2;
                andSet = obj3.queue.getAndSet(obj2);
                r16 = andGet;
            }
            obj3.queue.lazySet(obj2);
        }

        @Override // i.b.m0.e.b.e$b
        public void onNext(T t) {
        }
    }

    static final class g<T> extends e.b<T> {

        private static final long serialVersionUID = 3776720187248809713L;
        g(b<? super T> bVar) {
            super(bVar);
        }

        @Override // i.b.m0.e.b.e$b
        public void onNext(T t) {
            if (c()) {
                return;
            }
            if (t != null) {
                this.downstream.onNext(t);
                long l2 = get();
                long l = 0L;
                while (l2 != l) {
                    l = l2 - 1L;
                    if (compareAndSet(l2, l)) {
                        return;
                    }
                    l2 = get();
                    l = 0L;
                }
                return;
            }
            d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        }
    }

    static abstract class h<T> extends e.b<T> {

        private static final long serialVersionUID = 4127754106204442833L;
        h(b<? super T> bVar) {
            super(bVar);
        }

        @Override // i.b.m0.e.b.e$b
        public final void onNext(T t) {
            if (c()) {
                return;
            }
            if (t == null) {
                d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            long l = get();
            if (l != 0) {
                this.downstream.onNext(t);
                d.d(this, 1);
            } else {
                h();
            }
        }

        @Override // i.b.m0.e.b.e$b
        abstract void h();
    }

    static final class d<T> extends e.h<T> {

        private static final long serialVersionUID = 8360058422307496563L;
        d(b<? super T> bVar) {
            super(bVar);
        }

        @Override // i.b.m0.e.b.e$h
        void h() {
        }
    }

    static final class e<T> extends e.h<T> {

        private static final long serialVersionUID = 338953216916120960L;
        e(b<? super T> bVar) {
            super(bVar);
        }

        @Override // i.b.m0.e.b.e$h
        void h() {
            d(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }
    public e(j<T> jVar, i.b.a aVar) {
        super();
        this.b = jVar;
        this.c = aVar;
    }

    @Override // i.b.h
    public void c0(b<? super T> bVar) {
        i.b.m0.e.b.e.e eVar;
        int i2 = e.a.a[this.c.ordinal()];
        int i = 1;
        if (e.a.a == 1) {
            i.b.m0.e.b.e.g gVar = new e.g(bVar);
        } else {
            i = 2;
            if (e.a.a == 2) {
                eVar = new e.e(bVar);
            } else {
                i = 3;
                if (e.a.a == 3) {
                    i.b.m0.e.b.e.d dVar = new e.d(bVar);
                } else {
                    i = 4;
                    if (e.a.a != 4) {
                        i.b.m0.e.b.e.c cVar = new e.c(bVar, h.b());
                    } else {
                        i.b.m0.e.b.e.f fVar = new e.f(bVar);
                    }
                }
            }
        }
        bVar.onSubscribe(eVar);
        try {
            this.b.subscribe(eVar);
        } catch (Throwable th) {
            a.b(th);
            obj.d(th);
        }
    }
}
