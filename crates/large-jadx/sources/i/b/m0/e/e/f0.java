package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class f0<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;
    final boolean w;

    static final class a implements y<T>, b {

        final y<? super T> a;
        final long b;
        final TimeUnit c;
        final z.c v;
        final boolean w;
        b x;
        a(y<? super T> y, long l2, TimeUnit timeUnit3, z.c z$c4, boolean z5) {
            super();
            this.a = y;
            this.b = l2;
            this.c = c4;
            this.v = z5;
            this.w = obj6;
        }

        @Override // i.b.y
        public void dispose() {
            this.x.dispose();
            this.v.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            f0.a.a aVar = new f0.a.a(this);
            this.v.c(aVar, this.b, obj3);
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            long l;
            f0.a.b bVar = new f0.a.b(this, throwable);
            l = this.w ? this.b : 0;
            this.v.c(bVar, l, obj3);
        }

        public void onNext(T t) {
            f0.a.c cVar2 = new f0.a.c(this, t);
            this.v.c(cVar2, this.b, obj3);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.x, b)) {
                this.x = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public f0(w<T> w, long l2, TimeUnit timeUnit3, z z4, boolean z5) {
        super(w);
        this.b = l2;
        this.c = z4;
        this.v = z5;
        this.w = obj6;
    }

    public void subscribeActual(y<? super T> y) {
        boolean eVar;
        y yVar;
        if (this.w) {
            yVar = y;
        } else {
            eVar = new e(y);
            yVar = eVar;
        }
        super(yVar, this.b, obj4, this.c, this.v.a(), this.w);
        this.a.subscribe(aVar);
    }
}
