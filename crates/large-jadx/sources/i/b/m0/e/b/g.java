package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.i.c;
import i.b.m0.i.g;
import i.b.p0.a;
import java.util.NoSuchElementException;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class g<T>  extends i.b.m0.e.b.a<T, T> {

    final long c;
    final T v;
    final boolean w;

    static final class a extends c<T> implements k<T> {

        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;
        c upstream;
        a(b<? super T> b, long l2, T t3, boolean z4) {
            super(b);
            this.index = l2;
            this.defaultValue = z4;
            this.errorOnFewer = obj5;
        }

        @Override // i.b.m0.i.c
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // i.b.m0.i.c
        public void onComplete() {
            boolean defaultValue;
            NoSuchElementException noSuchElementException;
            if (!this.done) {
                this.done = true;
                defaultValue = this.defaultValue;
                if (defaultValue == null) {
                    if (this.errorOnFewer) {
                        noSuchElementException = new NoSuchElementException();
                        this.downstream.onError(noSuchElementException);
                    } else {
                        this.downstream.onComplete();
                    }
                } else {
                    a(defaultValue);
                }
            }
        }

        @Override // i.b.m0.i.c
        public void onError(Throwable throwable) {
            if (this.done) {
                a.t(throwable);
            }
            this.done = true;
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            if (this.done) {
            }
            long count = this.count;
            if (Long.compare(count, index) == 0) {
                this.done = true;
                this.upstream.cancel();
                a(t);
            }
            this.count = count += i3;
        }

        @Override // i.b.m0.i.c
        public void onSubscribe(c c) {
            boolean validate;
            if (g.validate(this.upstream, c)) {
                this.upstream = c;
                this.downstream.onSubscribe(this);
                c.request(Long.MAX_VALUE);
            }
        }
    }
    public g(h<T> h, long l2, T t3, boolean z4) {
        super(h);
        this.c = l2;
        this.v = z4;
        this.w = obj5;
    }

    protected void c0(b<? super T> b) {
        super(b, this.c, obj4, this.v, this.w);
        this.b.b0(aVar2);
    }
}
