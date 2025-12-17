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
public final class j0<T>  extends i.b.m0.e.b.a<T, T> {

    final T c;
    final boolean v;

    static final class a extends c<T> implements k<T> {

        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;
        final boolean failOnEmpty;
        c upstream;
        a(b<? super T> b, T t2, boolean z3) {
            super(b);
            this.defaultValue = t2;
            this.failOnEmpty = z3;
        }

        @Override // i.b.m0.i.c
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // i.b.m0.i.c
        public void onComplete() {
            Object defaultValue;
            int noSuchElementException;
            if (this.done) {
            }
            this.done = true;
            this.value = 0;
            if (this.value == null) {
                defaultValue = this.defaultValue;
            }
            if (defaultValue == null) {
                if (this.failOnEmpty) {
                    noSuchElementException = new NoSuchElementException();
                    this.downstream.onError(noSuchElementException);
                } else {
                    this.downstream.onComplete();
                }
            } else {
                a(defaultValue);
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
            if (this.value != null) {
                this.done = true;
                this.upstream.cancel();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Sequence contains more than one element!");
                this.downstream.onError(illegalArgumentException);
            }
            this.value = t;
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
    public j0(h<T> h, T t2, boolean z3) {
        super(h);
        this.c = t2;
        this.v = z3;
    }

    protected void c0(b<? super T> b) {
        j0.a aVar = new j0.a(b, this.c, this.v);
        this.b.b0(aVar);
    }
}
