package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.e;
import i.b.m0.i.f;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class d0<T>  extends i.b.m0.e.b.a<T, T> {

    final e c;

    static final class a extends AtomicInteger implements k<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final b<? super T> downstream;
        long produced;
        final f sa;
        final a<? extends T> source;
        final e stop;
        a(b<? super T> b, e e2, f f3, a<? extends T> a4) {
            super();
            this.downstream = b;
            this.sa = f3;
            this.source = a4;
            this.stop = e2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andIncrement;
            a source;
            int i;
            int cmp;
            if (getAndIncrement() == 0) {
                andIncrement = 1;
                while (this.sa.d()) {
                    long produced = this.produced;
                    i = 0;
                    if (Long.compare(produced, i) != 0) {
                    }
                    this.source.a(this);
                    this.produced = i;
                    this.sa.f(produced);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            b downstream;
            try {
                if (this.stop.a()) {
                } else {
                }
                this.downstream.onComplete();
                a();
                a.b(th);
                this.downstream.onError(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            this.produced = produced += i2;
            this.downstream.onNext(t);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c c) {
            this.sa.g(c);
        }
    }
    public d0(h<T> h, e e2) {
        super(h);
        this.c = e2;
    }

    public void c0(b<? super T> b) {
        f fVar = new f(0);
        b.onSubscribe(fVar);
        d0.a aVar = new d0.a(b, this.c, fVar, this.b);
        aVar.a();
    }
}
