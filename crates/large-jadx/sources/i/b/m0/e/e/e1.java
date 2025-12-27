package i.b.m0.e.e;

import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.d.c;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Iterator;

/* compiled from: ObservableFromIterable.java */
/* loaded from: classes3.dex */
public final class e1<T> extends r<T> {

    final Iterable<? extends T> a;

    static final class a<T> extends c<T> {

        final y<? super T> a;
        final Iterator<? extends T> b;
        volatile boolean c;
        boolean v;
        boolean w;
        boolean x;
        a(y<? super T> yVar, Iterator<? extends T> iterator) {
            super();
            this.a = yVar;
            this.b = iterator;
        }

        @Override // i.b.m0.d.c
        void a() {
            while (isDisposed()) {
                try {
                    Object item = this.b.next();
                    b.e(item, "The iterator returned a null value");
                } catch (Throwable th) {
                    a.b(th);
                    this.a.onError(th);
                    return;
                }
                this.a.onNext(item);
                try {
                } catch (Throwable th) {
                    a.b(th);
                    this.a.onError(th);
                    return;
                }
                if (!this.b.hasNext() && !this.isDisposed()) {
                }
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

        @Override // i.b.m0.d.c
        public T poll() {
            int i = 0;
            if (this.w) {
                return null;
            }
            final boolean z2 = true;
            if (this.x) {
                if (!this.b.hasNext()) {
                    this.w = z2;
                    return i;
                }
            } else {
                this.x = z2;
            }
            Object item = this.b.next();
            b.e(item, "The iterator returned a null value");
            return item;
        }

        @Override // i.b.m0.d.c
        public int requestFusion(int i) {
            final boolean z = true;
            if (i & z != 0) {
                this.v = z;
                return z;
            }
            return 0;
        }
    }
    public e1(Iterable<? extends T> iterable) {
        super();
        this.a = iterable;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super T> yVar) {
        try {
            Iterator it = this.a.iterator();
        } catch (Throwable th) {
            a.b(th);
            d.error(th, yVar);
            return;
        }
        try {
        } catch (Throwable th) {
            a.b(th);
            d.error(th, yVar);
            return;
        }
        if (!it.hasNext()) {
            d.complete(yVar);
            return;
        }
        i.b.m0.e.e.e1.a aVar = new e1.a(yVar, it);
        yVar.onSubscribe(aVar);
        if (!aVar.v) {
            aVar.a();
        }
    }
}
