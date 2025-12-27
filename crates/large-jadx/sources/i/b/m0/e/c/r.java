package i.b.m0.e.c;

import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.n;
import i.b.p;
import io.reactivex.exceptions.CompositeException;

/* compiled from: MaybePeek.java */
/* loaded from: classes3.dex */
public final class r<T> extends a<T, T> {

    final f<? super b> b;
    final f<? super T> c;
    final f<? super Throwable> v;
    final i.b.l0.a w;
    final i.b.l0.a x;
    final i.b.l0.a y;

    static final class a<T> implements n<T>, b {

        final n<? super T> a;
        final r<T> b;
        b c;
        a(n<? super T> nVar, r<T> rVar) {
            super();
            this.a = nVar;
            this.b = rVar;
        }

        void a() {
            try {
                this.b.x.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
        }

        void b(Throwable th) {
            Throwable th3;
            try {
                this.b.v.accept(th);
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                th = 1;
                arr[th] = th;
                th = new CompositeException(arr);
            }
            this.c = c.DISPOSED;
            this.a.onError(th3);
            a();
        }

        public void dispose() {
            try {
                this.b.y.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
            this.c.dispose();
            this.c = c.DISPOSED;
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            final c dISPOSED2 = c.DISPOSED;
            if (this.c == c.DISPOSED) {
                return;
            }
            try {
                this.b.w.run();
            } catch (Throwable th) {
                a.b(th);
                b(th);
                return;
            }
            this.c = c.DISPOSED;
            this.a.onComplete();
            a();
        }

        public void onError(Throwable th) {
            if (this.c == c.DISPOSED) {
                a.t(th);
                return;
            }
            b(th);
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                try {
                    this.b.b.accept(bVar);
                } catch (Throwable th) {
                    a.b(th);
                    bVar.dispose();
                    bVar = c.DISPOSED;
                    this.c = bVar;
                    d.error(th, this.a);
                }
                this.c = this.a;
                this.a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            final c dISPOSED2 = c.DISPOSED;
            if (this.c == c.DISPOSED) {
                return;
            }
            try {
                this.b.c.accept(t);
            } catch (Throwable th) {
                a.b(th);
                b(th);
                return;
            }
            this.c = c.DISPOSED;
            this.a.onSuccess(th);
            a();
        }
    }
    public r(p<T> pVar, f<? super b> fVar, f<? super T> fVar2, f<? super Throwable> fVar3, i.b.l0.a aVar, i.b.l0.a aVar2, i.b.l0.a aVar3) {
        super(pVar);
        this.b = fVar;
        this.c = fVar2;
        this.v = fVar3;
        this.w = aVar;
        this.x = aVar2;
        this.y = aVar3;
    }

    @Override // i.b.m0.e.c.a
    protected void w(n<? super T> nVar) {
        this.a.b(new r.a(nVar, this));
    }
}
