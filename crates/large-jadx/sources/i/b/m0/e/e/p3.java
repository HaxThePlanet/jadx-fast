package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import java.util.ArrayDeque;

/* loaded from: classes3.dex */
public final class p3<T>  extends i.b.m0.e.e.a<T, T> {

    final int b;

    static final class a extends ArrayDeque<T> implements y<T>, b {

        private static final long serialVersionUID = 7240042530241604978L;
        volatile boolean cancelled;
        final int count;
        final y<? super T> downstream;
        b upstream;
        a(y<? super T> y, int i2) {
            super();
            this.downstream = y;
            this.count = i2;
        }

        @Override // java.util.ArrayDeque
        public void dispose() {
            boolean cancelled;
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
            }
        }

        @Override // java.util.ArrayDeque
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.ArrayDeque
        public void onComplete() {
            Object poll;
            final y downstream = this.downstream;
            while (this.cancelled) {
                poll = poll();
                downstream.onNext(poll);
            }
        }

        @Override // java.util.ArrayDeque
        public void onError(Throwable throwable) {
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            if (this.count == size()) {
                poll();
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
    public p3(w<T> w, int i2) {
        super(w);
        this.b = i2;
    }

    public void subscribeActual(y<? super T> y) {
        p3.a aVar = new p3.a(y, this.b);
        this.a.subscribe(aVar);
    }
}
