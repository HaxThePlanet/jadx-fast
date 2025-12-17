package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.m0.i.f;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class c0<T>  extends i.b.m0.e.b.a<T, T> {

    final long c;

    static final class a extends AtomicInteger implements k<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final b<? super T> downstream;
        long produced;
        long remaining;
        final f sa;
        final a<? extends T> source;
        a(b<? super T> b, long l2, f f3, a<? extends T> a4) {
            super();
            this.downstream = b;
            this.sa = a4;
            this.source = obj5;
            this.remaining = l2;
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
            int downstream;
            int cmp;
            long remaining = this.remaining;
            if (Long.compare(remaining, l) != 0) {
                this.remaining = remaining - i;
            }
            if (Long.compare(remaining, i2) != 0) {
                a();
            } else {
                this.downstream.onComplete();
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
    public c0(h<T> h, long l2) {
        super(h);
        this.c = l2;
    }

    public void c0(b<? super T> b) {
        long l;
        long l2;
        f fVar = new f(0);
        b.onSubscribe(fVar);
        l = this.c;
        if (Long.compare(l, l2) != 0) {
            l2 = l;
        }
        super(b, l2, obj3, fVar, this.b);
        aVar2.a();
    }
}
