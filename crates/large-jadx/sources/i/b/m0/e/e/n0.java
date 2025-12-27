package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;

/* compiled from: ObservableDoOnEach.java */
/* loaded from: classes3.dex */
public final class n0<T> extends a<T, T> {

    final f<? super T> b;
    final f<? super Throwable> c;
    final i.b.l0.a v;
    final i.b.l0.a w;

    static final class a<T> implements y<T>, b {

        final y<? super T> a;
        final f<? super T> b;
        final f<? super Throwable> c;
        final i.b.l0.a v;
        final i.b.l0.a w;
        b x;
        boolean y;
        a(y<? super T> yVar, f<? super T> fVar, f<? super Throwable> fVar2, i.b.l0.a aVar, i.b.l0.a aVar2) {
            super();
            this.a = yVar;
            this.b = fVar;
            this.c = fVar2;
            this.v = aVar;
            this.w = aVar2;
        }

        public void dispose() {
            this.x.dispose();
        }

        public boolean isDisposed() {
            return this.x.isDisposed();
        }

        public void onComplete() {
            if (this.y) {
                return;
            }
            try {
                this.v.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
            this.y = true;
            this.a.onComplete();
            try {
                this.w.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
        }

        public void onError(Throwable th) {
            Throwable th3;
            if (this.y) {
                a.t(th);
                return;
            }
            this.y = true;
            try {
                this.c.accept(th);
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
            this.a.onError(th3);
            try {
                this.w.run();
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
        }

        public void onNext(T t) {
            if (this.y) {
                return;
            }
            try {
                this.b.accept(t);
            } catch (Throwable th) {
                a.b(th);
                this.x.dispose();
                onError(th);
                return;
            }
            this.a.onNext(th);
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.x, bVar)) {
                this.x = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public n0(w<T> wVar, f<? super T> fVar, f<? super Throwable> fVar2, i.b.l0.a aVar, i.b.l0.a aVar2) {
        super(wVar);
        this.b = fVar;
        this.c = fVar2;
        this.v = aVar;
        this.w = aVar2;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        n0.a aVar = new n0.a(yVar, this.b, this.c, this.v, this.w);
        this.a.subscribe(aVar);
    }
}
