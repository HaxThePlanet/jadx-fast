package i.b.m0.e.e;

import i.b.l0.f;
import i.b.m0.c.j;
import i.b.m0.d.a;
import i.b.w;
import i.b.y;

/* compiled from: ObservableDoAfterNext.java */
/* loaded from: classes3.dex */
public final class l0<T> extends a<T, T> {

    final f<? super T> b;

    static final class a<T> extends a<T, T> {

        final f<? super T> x;
        a(y<? super T> yVar, f<? super T> fVar) {
            super(yVar);
            this.x = fVar;
        }

        @Override // i.b.m0.d.a
        public void onNext(T t) {
            this.a.onNext(t);
            if (this.w == 0) {
                try {
                    this.x.accept(t);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        @Override // i.b.m0.d.a
        public T poll() {
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
    public l0(w<T> wVar, f<? super T> fVar) {
        super(wVar);
        this.b = fVar;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new l0.a(yVar, this.b));
    }
}
