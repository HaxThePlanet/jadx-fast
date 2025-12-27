package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Iterator;

/* compiled from: SingleFlatMapIterableObservable.java */
/* loaded from: classes3.dex */
public final class a0<T, R> extends r<R> {

    final g0<T> a;
    final n<? super T, ? extends Iterable<? extends R>> b;

    static final class a<T, R> extends i.b.m0.d.b<R> implements d0<T> {

        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final y<? super R> downstream;
        volatile Iterator<? extends R> it;
        final n<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        i.b.j0.b upstream;
        a(y<? super R> yVar, n<? super T, ? extends Iterable<? extends R>> nVar) {
            super();
            this.downstream = yVar;
            this.mapper = nVar;
        }

        @Override // i.b.m0.d.b
        public void clear() {
            this.it = null;
        }

        @Override // i.b.m0.d.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = c.DISPOSED;
        }

        @Override // i.b.m0.d.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // i.b.m0.d.b
        public boolean isEmpty() {
            boolean z = true;
            int r0 = this.it == null ? 1 : 0;
            return (this.it == null ? 1 : 0);
        }

        @Override // i.b.m0.d.b
        public void onError(Throwable th) {
            this.upstream = c.DISPOSED;
            this.downstream.onError(th);
        }

        @Override // i.b.m0.d.b
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // i.b.m0.d.b
        public void onSuccess(T t) {
            try {
                Iterator it = (Iterable)this.mapper.apply(t).iterator();
            } catch (Throwable th) {
                a.b(th);
                downstream2.onError(th);
                return;
            }
            if (!it.hasNext()) {
                this.downstream.onComplete();
                return;
            }
            if (this.outputFused) {
                this.it = it;
                this.downstream.onNext(null);
                this.downstream.onComplete();
                return;
            }
            while (this.cancelled) {
                try {
                } catch (Throwable th) {
                    a.b(th);
                    downstream2.onError(th);
                    return;
                }
                this.downstream.onNext(it.next());
                try {
                } catch (Throwable th) {
                    a.b(th);
                    downstream2.onError(th);
                    return;
                }
                if (!it.hasNext()) {
                    this.downstream.onComplete();
                    return;
                }
            }
        }

        @Override // i.b.m0.d.b
        public R poll() {
            final Iterator it2 = null;
            if (this.it != null) {
                final Object item = this.it.next();
                b.e(item, "The iterator returned a null value");
                if (!this.it.hasNext()) {
                    this.it = it2;
                }
                return item;
            }
            return it2;
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i & i2 != 0) {
                this.outputFused = true;
                return i2;
            }
            return 0;
        }
    }
    public a0(g0<T> g0Var, n<? super T, ? extends Iterable<? extends R>> nVar) {
        super();
        this.a = g0Var;
        this.b = nVar;
    }

    @Override // i.b.r
    protected void subscribeActual(y<? super R> yVar) {
        this.a.subscribe(new a0.a(yVar, this.b));
    }
}
