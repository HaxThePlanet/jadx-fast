package i.b.m0.e.e;

import i.b.l0.o;
import i.b.m0.c.j;
import i.b.m0.d.a;
import i.b.w;
import i.b.y;

/* compiled from: ObservableFilter.java */
/* loaded from: classes3.dex */
public final class u0<T> extends a<T, T> {

    final o<? super T> b;

    static final class a<T> extends a<T, T> {

        final o<? super T> x;
        a(y<? super T> yVar, o<? super T> oVar) {
            super(yVar);
            this.x = oVar;
        }

        @Override // i.b.m0.d.a
        public void onNext(T t) {
            if (this.w == 0) {
                try {
                } catch (Throwable th) {
                    c(th);
                    return;
                }
                if (this.x.test(t)) {
                    this.a.onNext(th);
                }
            } else {
                Object obj = null;
                this.a.onNext(obj);
            }
        }

        @Override // i.b.m0.d.a
        public T poll() {
            Object poll = this.c.poll();
            while (poll != null) {
                if (this.x.test(poll)) {
                    return poll;
                }
                poll = this.c.poll();
            }
            return poll;
        }

        @Override // i.b.m0.d.a
        public int requestFusion(int i) {
            return d(i);
        }
    }
    public u0(w<T> wVar, o<? super T> oVar) {
        super(wVar);
        this.b = oVar;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new u0.a(yVar, this.b));
    }
}
