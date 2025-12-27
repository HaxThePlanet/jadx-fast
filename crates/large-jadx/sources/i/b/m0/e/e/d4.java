package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableUnsubscribeOn.java */
/* loaded from: classes3.dex */
public final class d4<T> extends a<T, T> {

    final z b;

    static final class a<T> extends AtomicBoolean implements y<T>, b {

        private static final long serialVersionUID = 1015244841293359600L;
        final y<? super T> downstream;
        final z scheduler;
        b upstream;
        a(y<? super T> yVar, z zVar) {
            super();
            this.downstream = yVar;
            this.scheduler = zVar;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            boolean z = true;
            if (compareAndSet(false, z)) {
                this.scheduler.c(new d4.a.a(this));
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public boolean isDisposed() {
            return get();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onComplete() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onError(Throwable th) {
            if (get()) {
                a.t(th);
                return;
            }
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onNext(T t) {
            if (!get()) {
                this.downstream.onNext(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public d4(w<T> wVar, z zVar) {
        super(wVar);
        this.b = zVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new d4.a(yVar, this.b));
    }
}
