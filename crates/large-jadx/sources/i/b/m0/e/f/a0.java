package i.b.m0.e.f;

import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.d.b;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class a0<T, R>  extends r<R> {

    final g0<T> a;
    final n<? super T, ? extends Iterable<? extends R>> b;

    static final class a extends b<R> implements d0<T> {

        private static final long serialVersionUID = -8938804753851907758L;
        volatile boolean cancelled;
        final y<? super R> downstream;
        volatile Iterator<? extends R> it;
        final n<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        b upstream;
        a(y<? super R> y, n<? super T, ? extends Iterable<? extends R>> n2) {
            super();
            this.downstream = y;
            this.mapper = n2;
        }

        @Override // i.b.m0.d.b
        public void clear() {
            this.it = 0;
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
            int i;
            i = this.it == null ? 1 : 0;
            return i;
        }

        @Override // i.b.m0.d.b
        public void onError(Throwable throwable) {
            this.upstream = c.DISPOSED;
            this.downstream.onError(throwable);
        }

        @Override // i.b.m0.d.b
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            boolean outputFused;
            final y downstream2 = this.downstream;
            Iterator obj3 = (Iterable)this.mapper.apply(t).iterator();
            if (!obj3.hasNext()) {
                downstream2.onComplete();
            }
            try {
                if (this.outputFused) {
                }
                this.it = obj3;
                downstream2.onNext(0);
                downstream2.onComplete();
                while (this.cancelled) {
                    downstream2.onNext(obj3.next());
                }
                downstream2.onNext(obj3.next());
                if (this.cancelled) {
                } else {
                }
                if (!obj3.hasNext()) {
                } else {
                }
                downstream2.onComplete();
                a.b(t);
                downstream.onError(t);
                a.b(t);
                downstream.onError(t);
                a.b(t);
                y downstream = this.downstream;
                downstream.onError(t);
            } catch (Throwable th) {
            }
        }

        public R poll() {
            Iterator it = this.it;
            final int i = 0;
            final Object next2 = it.next();
            b.e(next2, "The iterator returned a null value");
            if (it != null && !it.hasNext()) {
                next2 = it.next();
                b.e(next2, "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.it = i;
                }
                return next2;
            }
            return i;
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i &= i2 != 0) {
                this.outputFused = true;
                return i2;
            }
            return 0;
        }
    }
    public a0(g0<T> g0, n<? super T, ? extends Iterable<? extends R>> n2) {
        super();
        this.a = g0;
        this.b = n2;
    }

    protected void subscribeActual(y<? super R> y) {
        a0.a aVar = new a0.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
