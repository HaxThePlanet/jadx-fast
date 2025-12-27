package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.i.g;
import i.b.p0.a;
import java.util.NoSuchElementException;
import m.c.b;

/* compiled from: FlowableSingle.java */
/* loaded from: classes3.dex */
public final class j0<T> extends a<T, T> {

    final T c;
    final boolean v;

    static final class a<T> extends i.b.m0.i.c<T> implements k<T> {

        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;
        final boolean failOnEmpty;
        m.c.c upstream;
        a(b<? super T> bVar, T t, boolean z) {
            super(bVar);
            this.defaultValue = t;
            this.failOnEmpty = z;
        }

        @Override // i.b.m0.i.c
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // i.b.m0.i.c
        public void onComplete() {
            Object value2;
            if (this.done) {
                return;
            }
            this.done = true;
            Object obj = null;
            this.value = obj;
            if (this.value == null) {
            }
            if (this.value != null) {
                a(value2);
            } else {
                if (this.failOnEmpty) {
                    this.downstream.onError(new NoSuchElementException());
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // i.b.m0.i.c
        public void onError(Throwable th) {
            if (this.done) {
                a.t(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        @Override // i.b.m0.i.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.value != null) {
                this.done = true;
                this.upstream.cancel();
                this.downstream.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.value = t;
        }

        @Override // i.b.m0.i.c
        public void onSubscribe(m.c.c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }
    public j0(h<T> hVar, T t, boolean z) {
        super(hVar);
        this.c = t;
        this.v = z;
    }

    @Override // i.b.m0.e.b.a
    protected void c0(b<? super T> bVar) {
        this.b.b0(new j0.a(bVar, this.c, this.v));
    }
}
