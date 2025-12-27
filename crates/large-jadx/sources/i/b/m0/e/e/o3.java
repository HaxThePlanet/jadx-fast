package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.p0.a;
import i.b.w;
import i.b.y;

/* compiled from: ObservableTake.java */
/* loaded from: classes3.dex */
public final class o3<T> extends a<T, T> {

    final long b;

    static final class a<T> implements y<T>, b {

        final y<? super T> a;
        boolean b;
        b c;
        long v;
        a(y<? super T> yVar, long j) {
            super();
            this.a = yVar;
            this.v = j;
        }

        public void dispose() {
            this.c.dispose();
        }

        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        public void onComplete() {
            if (!this.b) {
                this.b = true;
                this.c.dispose();
                this.a.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.b) {
                a.t(th);
                return;
            }
            this.b = true;
            this.c.dispose();
            this.a.onError(th);
        }

        public void onNext(T t) {
            int i = 1;
            if (!this.b) {
                this.v--;
                long l2 = 0L;
                if (this.v > l2) {
                    int r0 = l == l2 ? 1 : 0;
                    this.a.onNext(t);
                    if (this.b != 0) {
                        onComplete();
                    }
                }
            }
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                long l = 0L;
                if (this.v == l) {
                    boolean validate = true;
                    this.b = validate;
                    bVar.dispose();
                    d.complete(this.a);
                } else {
                    this.a.onSubscribe(this);
                }
            }
        }
    }
    public o3(w<T> wVar, long j) {
        super(wVar);
        this.b = j;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new o3.a(yVar, this.b, r3));
    }
}
