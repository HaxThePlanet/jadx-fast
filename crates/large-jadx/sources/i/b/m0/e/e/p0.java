package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import java.util.NoSuchElementException;

/* compiled from: ObservableElementAt.java */
/* loaded from: classes3.dex */
public final class p0<T> extends a<T, T> {

    final long b;
    final T c;
    final boolean v;

    static final class a<T> implements y<T>, b {

        final y<? super T> a;
        final long b;
        final T c;
        final boolean v;
        b w;
        long x;
        boolean y;
        a(y<? super T> yVar, long j, T t, boolean z) {
            super();
            this.a = yVar;
            this.b = j;
            this.c = t;
            this.v = z;
        }

        public void dispose() {
            this.w.dispose();
        }

        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        public void onComplete() {
            boolean z2;
            if (!this.y) {
                this.y = true;
                if (this.c != null || !this.v) {
                    if (this.c != null) {
                        this.a.onNext(this.c);
                    }
                    this.a.onComplete();
                } else {
                    this.a.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th) {
            if (this.y) {
                a.t(th);
                return;
            }
            this.y = true;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.y) {
                return;
            }
            if (this.x == this.b) {
                this.y = true;
                this.w.dispose();
                this.a.onNext(t);
                this.a.onComplete();
                return;
            }
            this.x++;
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.w, bVar)) {
                this.w = bVar;
                this.a.onSubscribe(this);
            }
        }
    }
    public p0(w<T> wVar, long j, T t, boolean z) {
        super(wVar);
        this.b = j;
        this.c = t;
        this.v = z;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        p0.a aVar = new p0.a(yVar, this.b, obj, this.c, this.v);
        this.a.subscribe(aVar);
    }
}
