package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.i.g;
import i.b.p0.a;
import java.util.NoSuchElementException;
import m.c.b;

/* compiled from: FlowableElementAt.java */
/* loaded from: classes3.dex */
public final class g<T> extends a<T, T> {

    final long c;
    final T v;
    final boolean w;

    static final class a<T> extends i.b.m0.i.c<T> implements k<T> {

        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;
        m.c.c upstream;
        a(b<? super T> bVar, long j, T t, boolean z) {
            super(bVar);
            this.index = j;
            this.defaultValue = t;
            this.errorOnFewer = z;
        }

        @Override // i.b.m0.i.c
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // i.b.m0.i.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                if (this.defaultValue != null) {
                    a(this.defaultValue);
                } else {
                    if (this.errorOnFewer) {
                        this.downstream.onError(new NoSuchElementException());
                    } else {
                        this.downstream.onComplete();
                    }
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
            if (this.count == this.index) {
                this.done = true;
                this.upstream.cancel();
                a(t);
                return;
            }
            this.count++;
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
    public g(h<T> hVar, long j, T t, boolean z) {
        super(hVar);
        this.c = j;
        this.v = t;
        this.w = z;
    }

    @Override // i.b.m0.e.b.a
    protected void c0(b<? super T> bVar) {
        g.a aVar = new g.a(bVar, this.c, obj, this.v, this.w);
        this.b.b0(aVar);
    }
}
