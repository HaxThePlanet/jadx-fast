package i.b.m0.e.e;

import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableBuffer.java */
/* loaded from: classes3.dex */
public final class l<T, U extends Collection<? super T>> extends a<T, U> {

    final int b;
    final int c;
    final Callable<U> v;

    static final class a<T, U extends Collection<? super T>> implements y<T>, i.b.j0.b {

        final y<? super U> a;
        final int b;
        final Callable<U> c;
        U v;
        int w;
        i.b.j0.b x;
        a(y<? super U> yVar, int i, Callable<U> callable) {
            super();
            this.a = yVar;
            this.b = i;
            this.c = callable;
        }

        boolean a() {
            Collection collection;
            try {
                Object call = this.c.call();
                b.e(call, "Empty buffer supplied");
            } catch (Throwable th) {
                a.b(th);
                collection = null;
                this.v = collection;
            }
            this.v = call;
            return true;
        }

        public void dispose() {
            this.x.dispose();
        }

        public boolean isDisposed() {
            return this.x.isDisposed();
        }

        public void onComplete() {
            boolean empty;
            if (this.v != null) {
                this.v = null;
                if (!this.v.isEmpty()) {
                    this.a.onNext(this.v);
                }
                this.a.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.v = null;
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.v != null) {
                this.v.add(t);
                this.w++;
                if (this.w >= this.b) {
                    this.a.onNext(this.v);
                    int i2 = 0;
                    this.w = i2;
                    a();
                }
            }
        }

        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.x, bVar)) {
                this.x = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    static final class b<T, U extends Collection<? super T>> extends AtomicBoolean implements y<T>, i.b.j0.b {

        private static final long serialVersionUID = -8223395059921494546L;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        final y<? super U> downstream;
        long index;
        final int skip;
        i.b.j0.b upstream;
        b(y<? super U> yVar, int i, int i2, Callable<U> callable) {
            super();
            this.downstream = yVar;
            this.count = i;
            this.skip = i2;
            this.bufferSupplier = callable;
            final ArrayDeque arrayDeque = new ArrayDeque();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onError(Throwable th) {
            this.buffers.clear();
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onNext(T t) {
            ArrayDeque item;
            this.index = 1L + index2;
            long l2 = index2 % (long)this.skip;
            long l = 0L;
            if (this.index == l) {
                try {
                    Object call = this.bufferSupplier.call();
                    b.e(call, "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.buffers.dispose();
                    this.buffers.onError(th);
                    return;
                }
                this.buffers.offer(call);
            }
            Iterator it = this.buffers.iterator();
            while (it.hasNext()) {
                item = it.next();
                item.add(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public l(w<T> wVar, int i, int i2, Callable<U> callable) {
        super(wVar);
        this.b = i;
        this.c = i2;
        this.v = callable;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super U> yVar) {
        if (this.c != this.b) {
            this.a.subscribe(new l.b(yVar, this.b, this.c, this.v));
        } else {
            i.b.m0.e.e.l.a aVar = new l.a(yVar, i4, this.v);
            if (aVar.a()) {
                this.a.subscribe(aVar);
            }
        }
    }
}
