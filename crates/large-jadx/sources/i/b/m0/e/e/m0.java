package i.b.m0.e.e;

import i.b.m0.a.c;
import i.b.m0.c.e;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableDoFinally.java */
/* loaded from: classes3.dex */
public final class m0<T> extends a<T, T> {

    final i.b.l0.a b;

    static final class a<T> extends i.b.m0.d.b<T> implements y<T> {

        private static final long serialVersionUID = 4109457741734051389L;
        final y<? super T> downstream;
        final i.b.l0.a onFinally;
        e<T> qd;
        boolean syncFused;
        i.b.j0.b upstream;
        a(y<? super T> yVar, i.b.l0.a aVar) {
            super();
            this.downstream = yVar;
            this.onFinally = aVar;
        }

        @Override // i.b.m0.d.b
        void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    a.b(th);
                    a.t(th);
                }
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
        public void onError(Throwable th) {
            this.downstream.onError(th);
            a();
        }

        @Override // i.b.m0.d.b
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // i.b.m0.d.b
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                validate = bVar instanceof e;
                if (bVar instanceof e) {
                    this.qd = bVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // i.b.m0.d.b
        public T poll() {
            Object poll = this.qd.poll();
            if (poll == null && this.syncFused) {
                a();
            }
            return poll;
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            int i2 = 0;
            i2 = 0;
            if (this.qd != null) {
                i3 = i & 4;
                if (i & 4 == 0 && requestFusion != 0) {
                    i2 = 1;
                    if (requestFusion == i2) {
                    }
                    this.syncFused = i2;
                    return requestFusion;
                }
            }
            return 0;
        }
    }
    public m0(w<T> wVar, i.b.l0.a aVar) {
        super(wVar);
        this.b = aVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new m0.a(yVar, this.b));
    }
}
