package i.b.m0.e.d;

import i.b.b;
import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.j.c;
import i.b.m0.j.k;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class f<T>  extends b {

    final r<T> a;
    final n<? super T, ? extends f> b;
    final boolean c;

    static final class a implements y<T>, b {

        static final i.b.m0.e.d.f.a.a z;
        final d a;
        final n<? super T, ? extends f> b;
        final boolean c;
        final c v;
        final AtomicReference<i.b.m0.e.d.f.a.a> w;
        volatile boolean x;
        b y;
        static {
            f.a.a aVar = new f.a.a(0);
            f.a.z = aVar;
        }

        a(d d, n<? super T, ? extends f> n2, boolean z3) {
            super();
            this.a = d;
            this.b = n2;
            this.c = z3;
            c obj1 = new c();
            this.v = obj1;
            obj1 = new AtomicReference();
            this.w = obj1;
        }

        @Override // i.b.y
        void a() {
            final i.b.m0.e.d.f.a.a aVar = f.a.z;
            Object andSet = this.w.getAndSet(aVar);
            if ((f.a.a)andSet != null && (f.a.a)andSet != aVar) {
                if ((f.a.a)andSet != aVar) {
                    (f.a.a)andSet.a();
                }
            }
        }

        @Override // i.b.y
        void b(i.b.m0.e.d.f.a.a f$a$a) {
            Object atomicReference;
            boolean obj3;
            if (this.w.compareAndSet(a, 0) && this.x) {
                if (this.x) {
                    obj3 = this.v.b();
                    if (obj3 == null) {
                        this.a.onComplete();
                    } else {
                        this.a.onError(obj3);
                    }
                }
            }
        }

        @Override // i.b.y
        void c(i.b.m0.e.d.f.a.a f$a$a, Throwable throwable2) {
            boolean obj3;
            Object obj4;
            if (this.w.compareAndSet(a, 0) && this.v.a(throwable2)) {
                if (this.v.a(throwable2)) {
                    if (this.c) {
                        if (this.x) {
                            this.a.onError(this.v.b());
                        }
                    } else {
                        dispose();
                        obj3 = this.v.b();
                        if (obj3 != k.a) {
                            this.a.onError(obj3);
                        }
                    }
                }
            }
            a.t(throwable2);
        }

        @Override // i.b.y
        public void dispose() {
            this.y.dispose();
            a();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            int i;
            i = this.w.get() == f.a.z ? 1 : 0;
            return i;
        }

        @Override // i.b.y
        public void onComplete() {
            Object obj;
            d dVar;
            this.x = true;
            if (this.w.get() == null) {
                obj = this.v.b();
                if (obj == null) {
                    this.a.onComplete();
                } else {
                    this.a.onError(obj);
                }
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            boolean z;
            Throwable obj2;
            if (this.v.a(throwable)) {
                if (this.c) {
                    onComplete();
                } else {
                    a();
                    obj2 = this.v.b();
                    if (obj2 != k.a) {
                        this.a.onError(obj2);
                    }
                }
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            Object obj;
            boolean compareAndSet;
            try {
                final Object obj4 = this.b.apply(t);
                b.e(obj4, "The mapper returned a null CompletableSource");
                f.a.a aVar = new f.a.a(this);
                obj = this.w.get();
                while ((f.a.a)obj == f.a.z) {
                    obj = this.w.get();
                }
                if (this.w.compareAndSet((f.a.a)obj, aVar)) {
                } else {
                }
                if (obj != null) {
                }
                obj.a();
                (f)obj4.b(aVar);
                a.b(t);
                this.y.dispose();
                onError(t);
            }
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.y, b)) {
                this.y = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public f(r<T> r, n<? super T, ? extends f> n2, boolean z3) {
        super();
        this.a = r;
        this.b = n2;
        this.c = z3;
    }

    @Override // i.b.b
    protected void x(d d) {
        boolean z;
        Object aVar;
        n nVar;
        boolean z2;
        if (!i.a(this.a, this.b, d)) {
            aVar = new f.a(d, this.b, this.c);
            this.a.subscribe(aVar);
        }
    }
}
