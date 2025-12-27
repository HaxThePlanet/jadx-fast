package i.b.m0.e.e;

import i.b.l0.d;
import i.b.l0.n;
import i.b.m0.c.j;
import i.b.m0.d.a;
import i.b.w;
import i.b.y;

/* compiled from: ObservableDistinctUntilChanged.java */
/* loaded from: classes3.dex */
public final class k0<T, K> extends a<T, T> {

    final n<? super T, K> b;
    final d<? super K, ? super K> c;

    static final class a<T, K> extends a<T, T> {

        boolean A;
        final n<? super T, K> x;
        final d<? super K, ? super K> y;
        K z;
        a(y<? super T> yVar, n<? super T, K> nVar, d<? super K, ? super K> dVar) {
            super(yVar);
            this.x = nVar;
            this.y = dVar;
        }

        @Override // i.b.m0.d.a
        public void onNext(T t) {
            if (this.v) {
                return;
            }
            if (this.w != 0) {
                this.a.onNext(t);
                return;
            }
            try {
                Object apply = this.x.apply(t);
                if (this.A) {
                    this.z = apply;
                    if (this.y.a(this.z, apply)) {
                        return;
                    }
                } else {
                    boolean z = true;
                    this.A = z;
                    this.z = apply;
                }
            } catch (Throwable th) {
                c(th);
                return;
            }
            this.a.onNext(th);
        }

        @Override // i.b.m0.d.a
        public T poll() {
            Object poll = this.c.poll();
            while (poll == null) {
                Object apply = this.x.apply(poll);
                if (!this.y.a(this.z, apply)) {
                    this.z = apply;
                    return poll;
                }
            }
            return null;
        }

        @Override // i.b.m0.d.a
        public int requestFusion(int i) {
            return d(i);
        }
    }
    public k0(w<T> wVar, n<? super T, K> nVar, d<? super K, ? super K> dVar) {
        super(wVar);
        this.b = nVar;
        this.c = dVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new k0.a(yVar, this.b, this.c));
    }
}
