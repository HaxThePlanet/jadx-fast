package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* compiled from: ObservableOnErrorReturn.java */
/* loaded from: classes3.dex */
public final class e2<T> extends a<T, T> {

    final n<? super Throwable, ? extends T> b;

    static final class a<T> implements y<T>, b {

        final y<? super T> a;
        final n<? super Throwable, ? extends T> b;
        b c;
        a(y<? super T> yVar, n<? super Throwable, ? extends T> nVar) {
            super();
            this.a = yVar;
            this.b = nVar;
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.b.apply(th);
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                th = 1;
                arr[th] = th;
                this.a.onError(new CompositeException(arr));
                return;
            }
            if (this.b == null) {
                java.lang.NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                nullPointerException.initCause(th);
                this.a.onError(nullPointerException);
                return;
            }
            this.a.onNext(apply);
            this.a.onComplete();
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public e2(w<T> wVar, n<? super Throwable, ? extends T> nVar) {
        super(wVar);
        this.b = nVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new e2.a(yVar, this.b));
    }
}
