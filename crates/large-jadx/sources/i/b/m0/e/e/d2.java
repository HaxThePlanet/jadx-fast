package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.g;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;

/* compiled from: ObservableOnErrorNext.java */
/* loaded from: classes3.dex */
public final class d2<T> extends a<T, T> {

    final n<? super Throwable, ? extends w<? extends T>> b;
    final boolean c;

    static final class a<T> implements y<T> {

        final y<? super T> a;
        final n<? super Throwable, ? extends w<? extends T>> b;
        final boolean c;
        final g v = new g();
        boolean w;
        boolean x;
        a(y<? super T> yVar, n<? super Throwable, ? extends w<? extends T>> nVar, boolean z) {
            super();
            this.a = yVar;
            this.b = nVar;
            this.c = z;
            final g gVar = new g();
        }

        public void onComplete() {
            if (this.x) {
                return;
            }
            boolean z2 = true;
            this.x = z2;
            this.w = z2;
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            if (this.w && this.x) {
                a.t(th);
                return;
            }
            this.w = true;
            if (this.c && !(th instanceof Exception)) {
                this.a.onError(th);
                return;
            }
            try {
                Object apply = this.b.apply(th);
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                arr[i] = th;
                this.a.onError(new CompositeException(arr));
                return;
            }
            if (apply == null) {
                java.lang.NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                this.a.onError(nullPointerException);
                return;
            }
            apply.subscribe(this);
        }

        public void onNext(T t) {
            if (this.x) {
                return;
            }
            this.a.onNext(t);
        }

        public void onSubscribe(b bVar) {
            this.v.a(bVar);
        }
    }
    public d2(w<T> wVar, n<? super Throwable, ? extends w<? extends T>> nVar, boolean z) {
        super(wVar);
        this.b = nVar;
        this.c = z;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        final i.b.m0.e.e.d2.a aVar = new d2.a(yVar, this.b, this.c);
        yVar.onSubscribe(aVar.v);
        this.a.subscribe(aVar);
    }
}
