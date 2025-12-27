package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.c.j;
import i.b.w;
import i.b.y;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableDistinct.java */
/* loaded from: classes3.dex */
public final class j0<T, K> extends a<T, T> {

    final n<? super T, K> b;
    final Callable<? extends Collection<? super K>> c;

    static final class a<T, K> extends i.b.m0.d.a<T, T> {

        final Collection<? super K> x;
        final n<? super T, K> y;
        a(y<? super T> yVar, n<? super T, K> nVar, Collection<? super K> collection) {
            super(yVar);
            this.y = nVar;
            this.x = collection;
        }

        @Override // i.b.m0.d.a
        public void clear() {
            this.x.clear();
            super.clear();
        }

        @Override // i.b.m0.d.a
        public void onComplete() {
            if (!this.v) {
                this.v = true;
                this.x.clear();
                this.a.onComplete();
            }
        }

        @Override // i.b.m0.d.a
        public void onError(Throwable th) {
            if (this.v) {
                a.t(th);
            } else {
                this.v = true;
                this.x.clear();
                this.a.onError(th);
            }
        }

        @Override // i.b.m0.d.a
        public void onNext(T t) {
            if (this.v) {
                return;
            }
            if (this.w == 0) {
                try {
                    Object apply = this.y.apply(t);
                    b.e(apply, "The keySelector returned a null key");
                } catch (Throwable th) {
                    c(th);
                    return;
                }
                if (this.x.add(apply)) {
                    this.a.onNext(th);
                }
            } else {
                Object obj = null;
                this.a.onNext(obj);
            }
        }

        @Override // i.b.m0.d.a
        public T poll() {
            Object poll = this.c.poll();
            while (poll != null) {
                Object apply = this.y.apply(poll);
                str = "The keySelector returned a null key";
                b.e(apply, str);
                if (this.x.add(apply)) {
                    return poll;
                }
                poll = this.c.poll();
            }
            return poll;
        }

        @Override // i.b.m0.d.a
        public int requestFusion(int i) {
            return d(i);
        }
    }
    public j0(w<T> wVar, n<? super T, K> nVar, Callable<? extends Collection<? super K>> callable) {
        super(wVar);
        this.b = nVar;
        this.c = callable;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        try {
            Object call = this.c.call();
            b.e(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            a.b(th);
            d.error(th, yVar);
            return;
        }
        this.a.subscribe(new j0.a(yVar, this.b, call));
    }
}
