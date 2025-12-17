package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.p0.a;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class o3<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;

    static final class a implements y<T>, b {

        final y<? super T> a;
        boolean b;
        b c;
        long v;
        a(y<? super T> y, long l2) {
            super();
            this.a = y;
            this.v = l2;
        }

        @Override // i.b.y
        public void dispose() {
            this.c.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            boolean z;
            if (!this.b) {
                this.b = true;
                this.c.dispose();
                this.a.onComplete();
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.b) {
                a.t(throwable);
            }
            this.b = true;
            this.c.dispose();
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            boolean cmp;
            y yVar;
            int i;
            int i2;
            long l = this.v;
            i = l - i3;
            this.v = i;
            i2 = 0;
            if (!this.b && Long.compare(l, i2) > 0) {
                l = this.v;
                i = l - i3;
                this.v = i;
                i2 = 0;
                if (Long.compare(l, i2) > 0) {
                    cmp = Long.compare(i, i2) == 0 ? 1 : 0;
                    this.a.onNext(t);
                    if (cmp != 0) {
                        onComplete();
                    }
                }
            }
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            boolean validate;
            int i;
            Object obj5;
            if (c.validate(this.c, b)) {
                this.c = b;
                if (Long.compare(l, i) == 0) {
                    this.b = true;
                    b.dispose();
                    d.complete(this.a);
                } else {
                    this.a.onSubscribe(this);
                }
            }
        }
    }
    public o3(w<T> w, long l2) {
        super(w);
        this.b = l2;
    }

    protected void subscribeActual(y<? super T> y) {
        o3.a aVar = new o3.a(y, this.b, obj3);
        this.a.subscribe(aVar);
    }
}
