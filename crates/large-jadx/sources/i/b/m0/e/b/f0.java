package i.b.m0.e.b;

import i.b.h;
import i.b.k;
import i.b.l0.d;
import i.b.m0.i.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class f0<T>  extends i.b.m0.e.b.a<T, T> {

    final d<? super Integer, ? super Throwable> c;

    static final class a extends AtomicInteger implements k<T> {

        private static final long serialVersionUID = -7098360935104053232L;
        final b<? super T> downstream;
        final d<? super Integer, ? super Throwable> predicate;
        long produced;
        int retries;
        final f sa;
        final a<? extends T> source;
        a(b<? super T> b, d<? super Integer, ? super Throwable> d2, f f3, a<? extends T> a4) {
            super();
            this.downstream = b;
            this.sa = f3;
            this.source = a4;
            this.predicate = d2;
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
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            retries += i;
            this.retries = i2;
            if (!this.predicate.a(Integer.valueOf(i2), throwable)) {
                try {
                    this.downstream.onError(throwable);
                    a();
                    a.b(th);
                    int arr = 2;
                    arr = new Throwable[arr];
                    arr[0] = throwable;
                    arr[obj0] = th;
                    CompositeException compositeException = new CompositeException(arr);
                    this.downstream.onError(compositeException);
                }
            }
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
    public f0(h<T> h, d<? super Integer, ? super Throwable> d2) {
        super(h);
        this.c = d2;
    }

    public void c0(b<? super T> b) {
        f fVar = new f(0);
        b.onSubscribe(fVar);
        f0.a aVar = new f0.a(b, this.c, fVar, this.b);
        aVar.a();
    }
}
