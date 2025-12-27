package i.b.m0.e.a;

import i.b.m0.a.c;
import io.reactivex.exceptions.CompositeException;

/* compiled from: CompletablePeek.java */
/* loaded from: classes3.dex */
public final class m extends i.b.b {

    final i.b.f a;
    final i.b.l0.f<? super i.b.j0.b> b;
    final i.b.l0.f<? super Throwable> c;
    final i.b.l0.a v;
    final i.b.l0.a w;
    final i.b.l0.a x;
    final i.b.l0.a y;

    final class a implements i.b.d, i.b.j0.b {

        final i.b.d a;
        i.b.j0.b b;
        final /* synthetic */ m c;
        a(i.b.d dVar) {
            this.c = mVar;
            super();
            this.a = dVar;
        }

        void a() {
            try {
                this.c.x.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
        }

        public void dispose() {
            try {
                this.c.y.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
            this.b.dispose();
        }

        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        public void onComplete() {
            if (this.b == c.DISPOSED) {
                return;
            }
            try {
                this.c.v.run();
                this.c.w.run();
            } catch (Throwable th) {
                a.b(th);
                this.a.onError(th);
                return;
            }
            this.a.onComplete();
            a();
        }

        public void onError(Throwable th) {
            Throwable th3;
            if (this.b == c.DISPOSED) {
                a.t(th);
                return;
            }
            try {
                this.c.c.accept(th);
                this.c.w.run();
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                th = 1;
                arr[th] = th;
                th = new CompositeException(arr);
            }
            this.a.onError(th3);
            a();
        }

        public void onSubscribe(i.b.j0.b bVar) {
            try {
                this.c.b.accept(bVar);
            } catch (Throwable th) {
                a.b(th);
                bVar.dispose();
                bVar = c.DISPOSED;
                this.b = bVar;
                d.error(th, this.a);
                return;
            }
            if (c.validate(this.b, this.a)) {
                this.b = this.a;
                this.a.onSubscribe(this);
            }
        }
    }
    public m(i.b.f fVar, i.b.l0.f<? super i.b.j0.b> fVar2, i.b.l0.f<? super Throwable> fVar3, i.b.l0.a aVar, i.b.l0.a aVar2, i.b.l0.a aVar3, i.b.l0.a aVar4) {
        super();
        this.a = fVar;
        this.b = fVar2;
        this.c = fVar3;
        this.v = aVar;
        this.w = aVar2;
        this.x = aVar3;
        this.y = aVar4;
    }

    @Override // i.b.b
    protected void x(i.b.d dVar) {
        this.a.b(new m.a(this, dVar));
    }
}
