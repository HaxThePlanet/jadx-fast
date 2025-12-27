package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.w;
import i.b.y;
import java.util.ArrayDeque;

/* compiled from: ObservableSkipLast.java */
/* loaded from: classes3.dex */
public final class h3<T> extends a<T, T> {

    final int b;

    static final class a<T> extends ArrayDeque<T> implements y<T>, b {

        private static final long serialVersionUID = -3807491841935125653L;
        final y<? super T> downstream;
        final int skip;
        b upstream;
        a(y<? super T> yVar, int i) {
            super(i);
            this.downstream = yVar;
            this.skip = i;
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
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // java.util.ArrayDeque
        public void onNext(T t) {
            if (this.skip == size()) {
                this.downstream.onNext(poll());
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
    public h3(w<T> wVar, int i) {
        super(wVar);
        this.b = i;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        this.a.subscribe(new h3.a(yVar, this.b));
    }
}
