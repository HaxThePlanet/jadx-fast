package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class p0<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;
    final T c;
    final boolean v;

    static final class a implements y<T>, b {

        final y<? super T> a;
        final long b;
        final T c;
        final boolean v;
        b w;
        long x;
        boolean y;
        a(y<? super T> y, long l2, T t3, boolean z4) {
            super();
            this.a = y;
            this.b = l2;
            this.c = z4;
            this.v = obj5;
        }

        @Override // i.b.y
        public void dispose() {
            this.w.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            boolean z;
            NoSuchElementException noSuchElementException;
            if (!this.y) {
                this.y = true;
                Object obj = this.c;
                if (obj == null && this.v) {
                    if (this.v) {
                        noSuchElementException = new NoSuchElementException();
                        this.a.onError(noSuchElementException);
                    } else {
                        if (obj != null) {
                            this.a.onNext(obj);
                        }
                        this.a.onComplete();
                    }
                } else {
                }
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            if (this.y) {
                a.t(throwable);
            }
            this.y = true;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            if (this.y) {
            }
            long l = this.x;
            if (Long.compare(l, l2) == 0) {
                this.y = true;
                this.w.dispose();
                this.a.onNext(t);
                this.a.onComplete();
            }
            this.x = l += i3;
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.w, b)) {
                this.w = b;
                this.a.onSubscribe(this);
            }
        }
    }
    public p0(w<T> w, long l2, T t3, boolean z4) {
        super(w);
        this.b = l2;
        this.c = z4;
        this.v = obj5;
    }

    public void subscribeActual(y<? super T> y) {
        super(y, this.b, obj4, this.c, this.v);
        this.a.subscribe(aVar2);
    }
}
