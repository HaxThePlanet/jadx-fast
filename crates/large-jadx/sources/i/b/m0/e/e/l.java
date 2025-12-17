package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class l<T, U extends Collection<? super T>>  extends i.b.m0.e.e.a<T, U> {

    final int b;
    final int c;
    final Callable<U> v;

    static final class a implements y<T>, b {

        final y<? super U> a;
        final int b;
        final Callable<U> c;
        U v;
        int w;
        b x;
        a(y<? super U> y, int i2, Callable<U> callable3) {
            super();
            this.a = y;
            this.b = i2;
            this.c = callable3;
        }

        @Override // i.b.y
        boolean a() {
            int i;
            try {
                Object call = this.c.call();
                b.e(call, "Empty buffer supplied");
                this.v = (Collection)call;
                return 1;
                a.b(th);
                i = 0;
                this.v = i;
                i = this.x;
                if (i == 0) {
                } else {
                }
                i = this.a;
                d.error(th, i);
                i.dispose();
                i = this.a;
                i.onError(th);
                Throwable th = null;
                return th;
            }
        }

        @Override // i.b.y
        public void dispose() {
            this.x.dispose();
        }

        @Override // i.b.y
        public boolean isDisposed() {
            return this.x.isDisposed();
        }

        @Override // i.b.y
        public void onComplete() {
            Object collection;
            boolean empty;
            collection = this.v;
            this.v = 0;
            if (collection != null && !collection.isEmpty()) {
                this.v = 0;
                if (!collection.isEmpty()) {
                    this.a.onNext(collection);
                }
                this.a.onComplete();
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.v = 0;
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            int i;
            Object obj3;
            final Collection collection = this.v;
            collection.add(t);
            obj3++;
            this.w = obj3;
            if (collection != null && obj3 >= this.b) {
                collection.add(t);
                obj3++;
                this.w = obj3;
                if (obj3 >= this.b) {
                    this.a.onNext(collection);
                    this.w = 0;
                    a();
                }
            }
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.x, b)) {
                this.x = b;
                this.a.onSubscribe(this);
            }
        }
    }

    static final class b extends AtomicBoolean implements y<T>, b {

        private static final long serialVersionUID = -8223395059921494546L;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers;
        final int count;
        final y<? super U> downstream;
        long index;
        final int skip;
        b upstream;
        b(y<? super U> y, int i2, int i3, Callable<U> callable4) {
            super();
            this.downstream = y;
            this.count = i2;
            this.skip = i3;
            this.bufferSupplier = callable4;
            ArrayDeque obj1 = new ArrayDeque();
            this.buffers = obj1;
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
        public void onError(Throwable throwable) {
            this.buffers.clear();
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            int call;
            ArrayDeque buffers;
            int downstream;
            int size;
            long index = this.index;
            this.index = i2 += index;
            if (Long.compare(i, downstream) == 0) {
                call = this.bufferSupplier.call();
                b.e(call, "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                this.buffers.offer((Collection)call);
            }
            Iterator iterator = this.buffers.iterator();
            while (iterator.hasNext()) {
                buffers = iterator.next();
                (Collection)buffers.add(t);
                if (this.count <= buffers.size()) {
                }
                iterator.remove();
                this.downstream.onNext(buffers);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public l(w<T> w, int i2, int i3, Callable<U> callable4) {
        super(w);
        this.b = i2;
        this.c = i3;
        this.v = callable4;
    }

    protected void subscribeActual(y<? super U> y) {
        Object aVar;
        i.b.m0.e.e.l.b bVar;
        int i2;
        int i;
        Callable callable;
        y obj6;
        bVar = this.b;
        if (this.c == bVar) {
            aVar = new l.a(y, bVar, this.v);
            if (aVar.a()) {
                this.a.subscribe(aVar);
            }
        } else {
            bVar = new l.b(y, this.b, this.c, this.v);
            this.a.subscribe(bVar);
        }
    }
}
