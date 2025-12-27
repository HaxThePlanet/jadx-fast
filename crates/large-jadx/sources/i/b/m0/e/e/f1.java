package i.b.m0.e.e;

import i.b.j0.b;
import i.b.k;
import i.b.m0.i.g;
import i.b.r;
import i.b.y;
import m.c.a;
import m.c.c;

/* compiled from: ObservableFromPublisher.java */
/* loaded from: classes3.dex */
public final class f1<T> extends r<T> {

    final a<? extends T> a;

    static final class a<T> implements k<T>, b {

        final y<? super T> a;
        c b;
        a(y<? super T> yVar) {
            super();
            this.a = yVar;
        }

        public void dispose() {
            this.b.cancel();
            this.b = g.CANCELLED;
        }

        public boolean isDisposed() {
            boolean z = true;
            int r0 = this.b == g.CANCELLED ? 1 : 0;
            return (this.b == g.CANCELLED ? 1 : 0);
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        public void onSubscribe(c cVar) {
            if (g.validate(this.b, cVar)) {
                this.b = cVar;
                this.a.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }
    public f1(a<? extends T> aVar) {
        super();
        this.a = aVar;
    }

    @Override // i.b.r
    protected void subscribeActual(y<? super T> yVar) {
        this.a.a(new f1.a(yVar));
    }
}
