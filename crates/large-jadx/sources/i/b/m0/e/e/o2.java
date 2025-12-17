package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.m0.a.f;
import i.b.m0.a.g;
import i.b.n0.a;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class o2<T>  extends r<T> {

    final a<T> a;
    final int b;
    final long c;
    final TimeUnit v;
    final z w;
    i.b.m0.e.e.o2.a x;

    static final class a extends AtomicReference<b> implements Runnable, f<b> {

        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final i.b.m0.e.e.o2<?> parent;
        long subscriberCount;
        b timer;
        a(i.b.m0.e.e.o2<?> o2) {
            super();
            this.parent = o2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a(b b) {
            boolean disconnectedEarly;
            c.replace(this, b);
            final i.b.m0.e.e.o2 parent = this.parent;
            synchronized (parent) {
                (f)parent2.a.a(b);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void accept(Object object) {
            a((b)object);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.parent.g(this);
        }
    }

    static final class b extends AtomicBoolean implements y<T>, b {

        private static final long serialVersionUID = -7419642935409022375L;
        final i.b.m0.e.e.o2.a connection;
        final y<? super T> downstream;
        final i.b.m0.e.e.o2<T> parent;
        b upstream;
        b(y<? super T> y, i.b.m0.e.e.o2<T> o22, i.b.m0.e.e.o2.a o2$a3) {
            super();
            this.downstream = y;
            this.parent = o22;
            this.connection = a3;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            boolean compareAndSet;
            int connection;
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.c(this.connection);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onComplete() {
            boolean compareAndSet;
            int connection;
            if (compareAndSet(false, true)) {
                this.parent.f(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onError(Throwable throwable) {
            y compareAndSet;
            i.b.m0.e.e.o2.a connection;
            if (compareAndSet(false, true)) {
                this.parent.f(this.connection);
                this.downstream.onError(throwable);
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public o2(a<T> a) {
        super(a, 1, 0, obj4, TimeUnit.NANOSECONDS, 0);
    }

    public o2(a<T> a, int i2, long l3, TimeUnit timeUnit4, z z5) {
        super();
        this.a = a;
        this.b = i2;
        this.c = l3;
        this.v = z5;
        this.w = obj6;
    }

    @Override // i.b.r
    void c(i.b.m0.e.e.o2.a o2$a) {
        int connected;
        i.b.m0.e.e.o2.a aVar = this.x;
        synchronized (this) {
            try {
                if (aVar != a) {
                } else {
                }
                subscriberCount -= i2;
                a.subscriberCount = i;
                int i3 = 0;
                if (Long.compare(i, i3) == 0) {
                }
                if (!a.connected) {
                } else {
                }
                if (Long.compare(l, i3) == 0) {
                }
                g(a);
                g gVar = new g();
                a.timer = gVar;
                gVar.a(this.w.d(a, this.c, obj3));
                throw a;
            }
        }
    }

    @Override // i.b.r
    void d(i.b.m0.e.e.o2.a o2$a) {
        b timer;
        timer = a.timer;
        if (timer != null) {
            timer.dispose();
            a.timer = 0;
        }
    }

    @Override // i.b.r
    void e(i.b.m0.e.e.o2.a o2$a) {
        boolean z;
        Object obj3;
        final a aVar = this.a;
        if (aVar instanceof b) {
            (b)aVar.dispose();
        } else {
            if (aVar instanceof f) {
                (f)aVar.a((b)a.get());
            }
        }
    }

    @Override // i.b.r
    void f(i.b.m0.e.e.o2.a o2$a) {
        i.b.m0.e.e.o2.a cmp;
        int i;
        final int i3 = 0;
        final int i4 = 0;
        final int i5 = 1;
        synchronized (this) {
            try {
                i.b.m0.e.e.o2.a aVar2 = this.x;
                if (aVar2 != null && aVar2 == a) {
                }
                if (aVar2 == a) {
                }
                this.x = i3;
                d(a);
                subscriberCount -= i5;
                a.subscriberCount = i2;
                if (Long.compare(i2, i4) == 0) {
                }
                e(a);
                cmp = this.x;
                d(a);
                subscriberCount2 -= i5;
                a.subscriberCount = i;
                if (cmp != null && cmp == a && Long.compare(i, i4) == 0) {
                }
                if (cmp == a) {
                }
                d(a);
                subscriberCount2 -= i5;
                a.subscriberCount = i;
                if (Long.compare(i, i4) == 0) {
                }
                this.x = i3;
                e(a);
                throw a;
            }
        }
    }

    @Override // i.b.r
    void g(i.b.m0.e.e.o2.a o2$a) {
        int cmp;
        a aVar;
        int i;
        synchronized (this) {
            try {
                if (a == this.x) {
                }
                this.x = 0;
                cmp = a.get();
                c.dispose(a);
                aVar = this.a;
                if (aVar instanceof b) {
                } else {
                }
                (b)aVar.dispose();
                if (aVar instanceof f) {
                }
                if ((b)cmp == null) {
                } else {
                }
                a.disconnectedEarly = true;
                (f)aVar.a((b)cmp);
                throw a;
            }
        }
    }

    protected void subscribeActual(y<? super T> y) {
        i.b.m0.e.e.o2.a aVar;
        int cmp;
        int timer;
        int connected;
        int i;
        long l;
        Object obj8;
        synchronized (this) {
            try {
                aVar = new o2.a(this);
                this.x = aVar;
                long subscriberCount = aVar.subscriberCount;
                timer = aVar.timer;
                if (Long.compare(subscriberCount, i2) == 0 && timer != null) {
                }
                timer = aVar.timer;
                if (timer != null) {
                }
                timer.dispose();
                subscriberCount += i3;
                aVar.subscriberCount = cmp;
                if (!aVar.connected && Long.compare(cmp, l) == 0) {
                } else {
                }
                if (Long.compare(cmp, l) == 0) {
                } else {
                }
                aVar.connected = true;
                i = 0;
                o2.b bVar = new o2.b(y, this, aVar);
                this.a.subscribe(bVar);
                if (i != 0) {
                }
                this.a.c(aVar);
                throw y;
            }
        }
    }
}
