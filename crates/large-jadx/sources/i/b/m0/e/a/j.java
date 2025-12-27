package i.b.m0.e.a;

import i.b.d;
import i.b.f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CompletableMergeArray.java */
/* loaded from: classes3.dex */
public final class j extends i.b.b {

    final f[] a;

    static final class a extends AtomicInteger implements d {

        private static final long serialVersionUID = -8360547806504310570L;
        final d downstream;
        final AtomicBoolean once;
        final i.b.j0.a set;
        a(d dVar, AtomicBoolean atomicBoolean, i.b.j0.a aVar, int i) {
            super();
            this.downstream = dVar;
            this.once = atomicBoolean;
            this.set = aVar;
            lazySet(i);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            if (decrementAndGet() == 0) {
                boolean z = false;
                boolean z2 = true;
                if (this.once.compareAndSet(z, z2)) {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.downstream.onError(th);
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            this.set.b(bVar);
        }
    }
    public j(f[] fVarArr) {
        super();
        this.a = fVarArr;
    }

    @Override // i.b.b
    public void x(d dVar) {
        int i = 0;
        i.b.j0.a aVar = new a();
        final i.b.m0.e.a.j.a aVar2 = new j.a(dVar, new AtomicBoolean(), aVar, this.a.length + 1);
        dVar.onSubscribe(aVar);
        i = 0;
        for (f fVar : objArr2) {
            if (fVar == null) {
                aVar.dispose();
                aVar2.onError(new NullPointerException("A completable source is null"));
                return;
            }
        }
        aVar2.onComplete();
    }
}
