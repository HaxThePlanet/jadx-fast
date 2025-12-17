package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import java.util.ArrayDeque;

/* loaded from: classes3.dex */
public final class h3<T>  extends i.b.m0.e.e.a<T, T> {

    final int b;

    static final class a extends ArrayDeque<T> implements y<T>, b {

        private static final long serialVersionUID = -3807491841935125653L;
        final y<? super T> downstream;
        final int skip;
        b upstream;
        a(y<? super T> y, int i2) {
            super(i2);
            this.downstream = y;
            this.skip = i2;
        }

        @Override // java.util.ArrayDeque
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // java.util.ArrayDeque
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // java.util.ArrayDeque
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // java.util.ArrayDeque
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            int downstream;
            int size;
            if (this.skip == size()) {
                this.downstream.onNext(poll());
            }
            offer(t);
        }

        @Override // java.util.ArrayDeque
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public h3(w<T> w, int i2) {
        super(w);
        this.b = i2;
    }

    public void subscribeActual(y<? super T> y) {
        h3.a aVar = new h3.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
