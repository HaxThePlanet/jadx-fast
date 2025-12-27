package i.b.m0.e.e;

import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableTimeInterval.java */
/* loaded from: classes3.dex */
public final class x3<T> extends a<T, i.b.s0.b<T>> {

    final z b;
    final TimeUnit c;

    static final class a<T> implements y<T>, i.b.j0.b {

        final y<? super i.b.s0.b<T>> a;
        final TimeUnit b;
        final z c;
        long v;
        i.b.j0.b w;
        a(y<? super i.b.s0.b<T>> yVar, TimeUnit timeUnit, z zVar) {
            super();
            this.a = yVar;
            this.c = zVar;
            this.b = timeUnit;
        }

        public void dispose() {
            this.w.dispose();
        }

        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onNext(T t) {
            long l = this.c.b(this.b);
            this.v = l;
            this.a.onNext(new b(t, l - this.v, timeUnit, this.b));
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.w, bVar)) {
                this.w = bVar;
                this.v = this.c.b(this.b);
                this.a.onSubscribe(this);
            }
        }
    }
    public x3(w<T> wVar, TimeUnit timeUnit, z zVar) {
        super(wVar);
        this.b = zVar;
        this.c = timeUnit;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super i.b.s0.b<T>> yVar) {
        this.a.subscribe(new x3.a(yVar, this.c, this.b));
    }
}
