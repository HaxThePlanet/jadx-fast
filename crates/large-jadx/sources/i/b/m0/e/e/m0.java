package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.a;
import i.b.m0.a.c;
import i.b.m0.c.e;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.d.b;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class m0<T>  extends i.b.m0.e.e.a<T, T> {

    final a b;

    static final class a extends b<T> implements y<T> {

        private static final long serialVersionUID = 4109457741734051389L;
        final y<? super T> downstream;
        final a onFinally;
        e<T> qd;
        boolean syncFused;
        b upstream;
        a(y<? super T> y, a a2) {
            super();
            this.downstream = y;
            this.onFinally = a2;
        }

        @Override // i.b.m0.d.b
        void a() {
            boolean compareAndSet;
            if (compareAndSet(0, 1)) {
                this.onFinally.run();
            }
        }

        @Override // i.b.m0.d.b
        public void clear() {
            this.qd.clear();
        }

        @Override // i.b.m0.d.b
        public void dispose() {
            this.upstream.dispose();
            a();
        }

        @Override // i.b.m0.d.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // i.b.m0.d.b
        public boolean isEmpty() {
            return this.qd.isEmpty();
        }

        @Override // i.b.m0.d.b
        public void onComplete() {
            this.downstream.onComplete();
            a();
        }

        @Override // i.b.m0.d.b
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
            a();
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // i.b.m0.d.b
        public void onSubscribe(b b) {
            boolean validate;
            Object obj2;
            this.upstream = b;
            if (c.validate(this.upstream, b) && b instanceof e) {
                this.upstream = b;
                if (b instanceof e) {
                    this.qd = (e)b;
                }
                this.downstream.onSubscribe(this);
            }
        }

        public T poll() {
            boolean syncFused;
            Object poll = this.qd.poll();
            if (poll == null && this.syncFused) {
                if (this.syncFused) {
                    a();
                }
            }
            return poll;
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            e eVar;
            int i3;
            int i2;
            eVar = this.qd;
            final int obj4 = eVar.requestFusion(i);
            eVar = 1;
            if (eVar != null && i & 4 == 0 && obj4 != null && obj4 == eVar) {
                if (i & 4 == 0) {
                    obj4 = eVar.requestFusion(i);
                    if (obj4 != null) {
                        eVar = 1;
                        if (obj4 == eVar) {
                            i3 = eVar;
                        }
                        this.syncFused = i3;
                    }
                    return obj4;
                }
            }
            return 0;
        }
    }
    public m0(w<T> w, a a2) {
        super(w);
        this.b = a2;
    }

    protected void subscribeActual(y<? super T> y) {
        m0.a aVar = new m0.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
