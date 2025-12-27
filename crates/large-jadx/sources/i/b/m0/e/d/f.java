package i.b.m0.e.d;

import i.b.d;
import i.b.f;
import i.b.l0.n;
import i.b.m0.j.k;
import i.b.r;
import i.b.y;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSwitchMapCompletable.java */
/* loaded from: classes3.dex */
public final class f<T> extends i.b.b {

    final r<T> a;
    final n<? super T, ? extends f> b;
    final boolean c;

    static final class a<T> implements y<T>, i.b.j0.b {

        static final f.a.a z = new f$a$a(0);
        final d a;
        final n<? super T, ? extends f> b;
        final boolean c;
        final i.b.m0.j.c v = new c();
        final AtomicReference<f.a.a> w = new AtomicReference<>();
        volatile boolean x;
        i.b.j0.b y;

        a(d dVar, n<? super T, ? extends f> nVar, boolean z) {
            super();
            this.a = dVar;
            this.b = nVar;
            this.c = z;
            i.b.m0.j.c cVar = new c();
            AtomicReference atomicReference = new AtomicReference();
        }

        void a() {
            final i.b.m0.e.d.f.a.a aVar = f.a.z;
            Object andSet = this.w.getAndSet(aVar);
            if (andSet != null && andSet != f.a.z) {
                andSet.a();
            }
        }

        void b(f.a.a aVar) {
            if (this.w.compareAndSet(aVar, null) && this.x) {
                Throwable th = this.v.b();
                if (th == null) {
                    this.a.onComplete();
                } else {
                    this.a.onError(th);
                }
            }
        }

        void c(f.a.a aVar, Throwable th) {
            if (this.w.compareAndSet(aVar, null)) {
                if (this.v.a(th) && this.c) {
                    if (this.x) {
                        this.a.onError(this.v.b());
                    }
                    return;
                }
            }
            a.t(th);
        }

        public void dispose() {
            this.y.dispose();
            a();
        }

        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.w.get() == f.a.z ? 1 : 0;
            return (this.w.get() == f.a.z ? 1 : 0);
        }

        public void onComplete() {
            this.x = true;
            if (this.w.get() == null) {
                Throwable th = this.v.b();
                if (th == null) {
                    this.a.onComplete();
                } else {
                    this.a.onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (!this.v.a(th)) {
                a.t(th);
            } else {
                if (this.c) {
                    onComplete();
                } else {
                    a();
                    Throwable th2 = this.v.b();
                    if (th2 != k.a) {
                        this.a.onError(th2);
                    }
                }
            }
        }

        public void onNext(T t) {
            try {
                final Object apply = this.b.apply(t);
                b.e(apply, "The mapper returned a null CompletableSource");
            } catch (Throwable th) {
                a.b(th);
                this.y.dispose();
                onError(th);
                return;
            }
            i.b.m0.e.d.f.a.a aVar2 = new f.a.a(this);
            Object obj = this.w.get();
            while (obj == f.a.z) {
                if (this.w.compareAndSet(obj, aVar2) && obj != null) {
                }
                obj = this.w.get();
            }
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.y, bVar)) {
                this.y = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public f(r<T> rVar, n<? super T, ? extends f> nVar, boolean z) {
        super();
        this.a = rVar;
        this.b = nVar;
        this.c = z;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        if (!i.a(this.a, this.b, dVar)) {
            this.a.subscribe(new f.a(dVar, this.b, this.c));
        }
    }
}
