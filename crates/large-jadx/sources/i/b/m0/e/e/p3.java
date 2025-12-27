package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import java.util.ArrayDeque;

/* compiled from: ObservableTakeLast.java */
/* loaded from: classes3.dex */
public final class p3<T> extends a<T, T> {

    final int b;

    static final class a<T> extends ArrayDeque<T> implements y<T>, b {

        private static final long serialVersionUID = 7240042530241604978L;
        volatile boolean cancelled;
        final int count;
        final y<? super T> downstream;
        b upstream;
        a(y<? super T> yVar, int i) {
            super();
            this.downstream = yVar;
            this.count = i;
        }

        @Override // java.util.ArrayDeque
        public void dispose() {
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
            while (this.cancelled) {
                Object poll = poll();
                if (poll == null) {
                }
            }
        }

        @Override // java.util.ArrayDeque
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.ArrayDeque
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
            }
            offer(t);
        }

        @Override // java.util.ArrayDeque
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public p3(w<T> wVar, int i) {
        super(wVar);
        this.b = i;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new p3.a(yVar, this.b));
    }
}
