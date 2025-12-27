package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableDelay.java */
/* loaded from: classes3.dex */
public final class f0<T> extends a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;
    final boolean w;

    static final class a<T> implements y<T>, b {

        final y<? super T> a;
        final long b;
        final TimeUnit c;
        final z.c v;
        final boolean w;
        b x;
        a(y<? super T> yVar, long j, TimeUnit timeUnit, z.c cVar, boolean z) {
            super();
            this.a = yVar;
            this.b = j;
            this.c = timeUnit;
            this.v = cVar;
            this.w = z;
        }

        public void dispose() {
            this.x.dispose();
            this.v.dispose();
        }

        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        public void onComplete() {
            this.v.c(new f0.a.a(this), this.b, this.c);
        }

        public void onError(Throwable th) {
            long l = 0;
            long r2 = this.w ? this.b : 0;
            this.v.c(new f0.a.b(this, th), (this.w ? this.b : 0), this.c);
        }

        public void onNext(T t) {
            this.v.c(new f0.a.c(this, t), this.b, this.c);
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.x, bVar)) {
                this.x = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public f0(w<T> wVar, long j, TimeUnit timeUnit, z zVar, boolean z) {
        super(wVar);
        this.b = j;
        this.c = timeUnit;
        this.v = zVar;
        this.w = z;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        y yVar2;
        y r2 = this.w ? yVar : new e(yVar);
        f0.a aVar = new f0.a((this.w ? yVar : new e(yVar)), this.b, timeUnit, this.c, this.v.a(), this.w);
        this.a.subscribe(aVar);
    }
}
