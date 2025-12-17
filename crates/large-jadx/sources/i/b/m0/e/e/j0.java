package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.c.j;
import i.b.m0.d.a;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class j0<T, K>  extends i.b.m0.e.e.a<T, T> {

    final n<? super T, K> b;
    final Callable<? extends Collection<? super K>> c;

    static final class a extends a<T, T> {

        final Collection<? super K> x;
        final n<? super T, K> y;
        a(y<? super T> y, n<? super T, K> n2, Collection<? super K> collection3) {
            super(y);
            this.y = n2;
            this.x = collection3;
        }

        @Override // i.b.m0.d.a
        public void clear() {
            this.x.clear();
            super.clear();
        }

        @Override // i.b.m0.d.a
        public void onComplete() {
            boolean z;
            if (!this.v) {
                this.v = true;
                this.x.clear();
                this.a.onComplete();
            }
        }

        @Override // i.b.m0.d.a
        public void onError(Throwable throwable) {
            boolean z;
            if (this.v) {
                a.t(throwable);
            } else {
                this.v = true;
                this.x.clear();
                this.a.onError(throwable);
            }
        }

        public void onNext(T t) {
            boolean z;
            Collection collection;
            Object obj3;
            if (this.v) {
            }
            if (this.w == 0) {
                Object apply = this.y.apply(t);
                b.e(apply, "The keySelector returned a null key");
                if (this.x.add(apply)) {
                    this.a.onNext(t);
                }
            } else {
                this.a.onNext(0);
            }
        }

        public T poll() {
            boolean z;
            Object apply;
            String str;
            Object poll = this.c.poll();
            while (poll != null) {
                apply = this.y.apply(poll);
                b.e(apply, "The keySelector returned a null key");
                if (!this.x.add(apply)) {
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
    public j0(w<T> w, n<? super T, K> n2, Callable<? extends Collection<? super K>> callable3) {
        super(w);
        this.b = n2;
        this.c = callable3;
    }

    protected void subscribeActual(y<? super T> y) {
        try {
            Object call = this.c.call();
            b.e(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            j0.a aVar = new j0.a(y, this.b, (Collection)call);
            this.a.subscribe(aVar);
            a.b(th);
            d.error(th, y);
        }
    }
}
