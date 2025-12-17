package i.b.m0.e.e;

import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.d.c;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class e1<T>  extends r<T> {

    final Iterable<? extends T> a;

    static final class a extends c<T> {

        final y<? super T> a;
        final Iterator<? extends T> b;
        volatile boolean c;
        boolean v;
        boolean w;
        boolean x;
        a(y<? super T> y, Iterator<? extends T> iterator2) {
            super();
            this.a = y;
            this.b = iterator2;
        }

        @Override // i.b.m0.d.c
        void a() {
            boolean disposed;
            while (isDisposed()) {
                Object next = this.b.next();
                b.e(next, "The iterator returned a null value");
                this.a.onNext(next);
            }
        }

        @Override // i.b.m0.d.c
        public void clear() {
            this.w = true;
        }

        @Override // i.b.m0.d.c
        public void dispose() {
            this.c = true;
        }

        @Override // i.b.m0.d.c
        public boolean isDisposed() {
            return this.c;
        }

        @Override // i.b.m0.d.c
        public boolean isEmpty() {
            return this.w;
        }

        public T poll() {
            boolean next;
            int i = 0;
            if (this.w) {
                return i;
            }
            final int i2 = 1;
            if (this.x) {
                if (!this.b.hasNext()) {
                    this.w = i2;
                    return i;
                }
            } else {
                this.x = i2;
            }
            Object next2 = this.b.next();
            b.e(next2, "The iterator returned a null value");
            return next2;
        }

        @Override // i.b.m0.d.c
        public int requestFusion(int i) {
            final int i2 = 1;
            if (i &= i2 != 0) {
                this.v = i2;
                return i2;
            }
            return 0;
        }
    }
    public e1(Iterable<? extends T> iterable) {
        super();
        this.a = iterable;
    }

    public void subscribeActual(y<? super T> y) {
        try {
            Iterator iterator = this.a.iterator();
            if (!iterator.hasNext()) {
            }
            d.complete(y);
            e1.a aVar = new e1.a(y, iterator);
            y.onSubscribe(aVar);
            if (!aVar.v) {
            }
            aVar.a();
            a.b(th);
            d.error(th, y);
        } catch (Throwable th) {
        }
    }
}
