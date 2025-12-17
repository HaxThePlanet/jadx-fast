package i.b.m0.e.e;

import i.b.l0.f;
import i.b.m0.c.j;
import i.b.m0.d.a;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class l0<T>  extends i.b.m0.e.e.a<T, T> {

    final f<? super T> b;

    static final class a extends a<T, T> {

        final f<? super T> x;
        a(y<? super T> y, f<? super T> f2) {
            super(y);
            this.x = f2;
        }

        public void onNext(T t) {
            int i;
            Object obj2;
            this.a.onNext(t);
            if (this.w == 0) {
                this.x.accept(t);
            }
        }

        public T poll() {
            f fVar;
            Object poll = this.c.poll();
            if (poll != null) {
                this.x.accept(poll);
            }
            return poll;
        }

        @Override // i.b.m0.d.a
        public int requestFusion(int i) {
            return d(i);
        }
    }
    public l0(w<T> w, f<? super T> f2) {
        super(w);
        this.b = f2;
    }

    protected void subscribeActual(y<? super T> y) {
        l0.a aVar = new l0.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
