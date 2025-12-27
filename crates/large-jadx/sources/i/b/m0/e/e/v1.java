package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.b.b;
import i.b.m0.c.j;
import i.b.m0.d.a;
import i.b.w;
import i.b.y;

/* compiled from: ObservableMap.java */
/* loaded from: classes3.dex */
public final class v1<T, U> extends a<T, U> {

    final n<? super T, ? extends U> b;

    static final class a<T, U> extends a<T, U> {

        final n<? super T, ? extends U> x;
        a(y<? super U> yVar, n<? super T, ? extends U> nVar) {
            super(yVar);
            this.x = nVar;
        }

        @Override // i.b.m0.d.a
        public void onNext(T t) {
            if (this.v) {
                return;
            }
            if (this.w != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                Object apply = this.x.apply(t);
                b.e(apply, "The mapper function returned a null value.");
            } catch (Throwable th) {
                c(th);
                return;
            }
            this.a.onNext(apply);
        }

        @Override // i.b.m0.d.a
        public U poll() {
            Object apply = null;
            Object poll = this.c.poll();
            if (poll != null) {
                str = "The mapper function returned a null value.";
                b.e(this.x.apply(poll), str);
            } else {
                int i = 0;
            }
            return apply;
        }

        @Override // i.b.m0.d.a
        public int requestFusion(int i) {
            return d(i);
        }
    }
    public v1(w<T> wVar, n<? super T, ? extends U> nVar) {
        super(wVar);
        this.b = nVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super U> yVar) {
        this.a.subscribe(new v1.a(yVar, this.b));
    }
}
