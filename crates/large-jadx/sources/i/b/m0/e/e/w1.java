package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* compiled from: ObservableMapNotification.java */
/* loaded from: classes3.dex */
public final class w1<T, R> extends a<T, w<? extends R>> {

    final n<? super T, ? extends w<? extends R>> b;
    final n<? super Throwable, ? extends w<? extends R>> c;
    final Callable<? extends w<? extends R>> v;

    static final class a<T, R> implements y<T>, i.b.j0.b {

        final y<? super w<? extends R>> a;
        final n<? super T, ? extends w<? extends R>> b;
        final n<? super Throwable, ? extends w<? extends R>> c;
        final Callable<? extends w<? extends R>> v;
        i.b.j0.b w;
        a(y<? super w<? extends R>> yVar, n<? super T, ? extends w<? extends R>> nVar, n<? super Throwable, ? extends w<? extends R>> nVar2, Callable<? extends w<? extends R>> callable) {
            super();
            this.a = yVar;
            this.b = nVar;
            this.c = nVar2;
            this.v = callable;
        }

        public void dispose() {
            this.w.dispose();
        }

        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        public void onComplete() {
            try {
                Object call = this.v.call();
                b.e(call, "The onComplete ObservableSource returned is null");
            } catch (Throwable th) {
                a.b(th);
                this.a.onError(th);
                return;
            }
            this.a.onNext(call);
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.c.apply(th);
                b.e(apply, "The onError ObservableSource returned is null");
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
            this.a.onNext(apply);
            this.a.onComplete();
        }

        public void onNext(T t) {
            try {
                final Object apply = this.b.apply(t);
                b.e(apply, "The onNext ObservableSource returned is null");
            } catch (Throwable th) {
                a.b(th);
                this.a.onError(th);
                return;
            }
            this.a.onNext(apply);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.w, bVar)) {
                this.w = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public w1(w<T> wVar, n<? super T, ? extends w<? extends R>> nVar, n<? super Throwable, ? extends w<? extends R>> nVar2, Callable<? extends w<? extends R>> callable) {
        super(wVar);
        this.b = nVar;
        this.c = nVar2;
        this.v = callable;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super w<? extends R>> yVar) {
        this.a.subscribe(new w1.a(yVar, this.b, this.c, this.v));
    }
}
