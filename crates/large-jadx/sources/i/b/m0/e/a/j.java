package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.f;
import i.b.j0.a;
import i.b.j0.b;
import i.b.p0.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class j extends b {

    final f[] a;

    static final class a extends AtomicInteger implements d {

        private static final long serialVersionUID = -8360547806504310570L;
        final d downstream;
        final AtomicBoolean once;
        final a set;
        a(d d, AtomicBoolean atomicBoolean2, a a3, int i4) {
            super();
            this.downstream = d;
            this.once = atomicBoolean2;
            this.set = a3;
            lazySet(i4);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            int decrementAndGet;
            int i2;
            int i;
            if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
                if (this.once.compareAndSet(false, true)) {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            d compareAndSet;
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.downstream.onError(throwable);
            } else {
                a.t(throwable);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            this.set.b(b);
        }
    }
    public j(f[] fArr) {
        super();
        this.a = fArr;
    }

    @Override // i.b.b
    public void x(d d) {
        int i;
        f fVar;
        boolean disposed;
        a aVar = new a();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        j.a aVar2 = new j.a(d, atomicBoolean, aVar, length2++);
        d.onSubscribe(aVar);
        f[] obj7 = this.a;
        i = 0;
        while (i < obj7.length) {
            fVar = obj7[i];
            fVar.b(aVar2);
            i++;
        }
        aVar2.onComplete();
    }
}
