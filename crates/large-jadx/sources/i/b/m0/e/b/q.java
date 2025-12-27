package i.b.m0.e.b;

import i.b.h;
import i.b.m0.i.g;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableFromIterable.java */
/* loaded from: classes3.dex */
public final class q<T> extends h<T> {

    final Iterable<? extends T> b;

    static abstract class a<T> extends i.b.m0.i.b<T> {

        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;
        a(Iterator<? extends T> iterator) {
            super();
            this.it = iterator;
        }

        @Override // i.b.m0.i.b
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // i.b.m0.i.b
        public final void clear() {
            this.it = null;
        }

        @Override // i.b.m0.i.b
        public final boolean isEmpty() {
            boolean z = false;
            if (this.it == null || !this.it.hasNext()) {
                int i2 = 1;
            }
            return z;
        }

        @Override // i.b.m0.i.b
        public final T poll() {
            int i = 0;
            if (this.it == null) {
                return null;
            }
            if (this.once) {
                if (!this.it.hasNext()) {
                    return i;
                }
            } else {
                boolean hasNext = true;
                this.once = hasNext;
            }
            Object item = this.it.next();
            b.e(item, "Iterator.next() returned a null value");
            return item;
        }

        @Override // i.b.m0.i.b
        public final void request(long j) {
            if (g.validate(j)) {
                long l2 = d.a(this, j);
                long l = 0L;
                if (l2 == l) {
                    if (j == 9223372036854775807L) {
                        a();
                    } else {
                        b(j);
                    }
                }
            }
        }

        @Override // i.b.m0.i.b
        abstract void a();

        @Override // i.b.m0.i.b
        abstract void b(long j);

        @Override // i.b.m0.i.b
        public final int requestFusion(int i) {
            return i & 1;
        }
    }

    static final class b<T> extends q.a<T> {

        private static final long serialVersionUID = -6022804456014692607L;
        final i.b.m0.c.a<? super T> downstream;
        b(i.b.m0.c.a<? super T> aVar, Iterator<? extends T> iterator) {
            super(iterator);
            this.downstream = aVar;
        }

        @Override // i.b.m0.e.b.q$a
        void a() {
            while (this.cancelled) {
                try {
                    Object item = this.it.next();
                } catch (Throwable th) {
                    a.b(th);
                    obj.onError(th);
                    return;
                }
                this.downstream.c(item);
                try {
                } catch (Throwable th) {
                    a.b(th);
                    obj.onError(th);
                    return;
                }
                if (!this.it.hasNext() && !this.cancelled) {
                }
            }
        }

        @Override // i.b.m0.e.b.q$a
        void b(long j) {
            int i;
            boolean cmp2;
            boolean hasNext;
            long andGet;
            final long l = 0L;
            while (/* condition */) {
                while (i != andGet) {
                    try {
                        Object item = this.it.next();
                    } catch (Throwable th) {
                        a.b(th);
                        obj.onError(th);
                        return;
                    }
                    try {
                    } catch (Throwable th) {
                        a.b(th);
                        obj.onError(th);
                        return;
                    }
                    if (!this.it.hasNext()) {
                    }
                    andGet = get();
                    if (i == andGet) {
                        andGet = addAndGet(-i);
                    }
                }
                andGet = get();
                if (i == andGet) {
                    andGet = addAndGet(-i);
                }
                try {
                    item = this.it.next();
                } catch (Throwable th) {
                    a.b(th);
                    obj.onError(th);
                    return;
                }
                try {
                } catch (Throwable th) {
                    a.b(th);
                    obj.onError(th);
                    return;
                }
                if (!this.it.hasNext()) {
                }
            }
        }
    }

    static final class c<T> extends q.a<T> {

        private static final long serialVersionUID = -6022804456014692607L;
        final m.c.b<? super T> downstream;
        c(m.c.b<? super T> bVar, Iterator<? extends T> iterator) {
            super(iterator);
            this.downstream = bVar;
        }

        @Override // i.b.m0.e.b.q$a
        void a() {
            while (this.cancelled) {
                try {
                    Object item = this.it.next();
                } catch (Throwable th) {
                    a.b(th);
                    obj.onError(th);
                    return;
                }
                this.downstream.onNext(item);
                try {
                } catch (Throwable th) {
                    a.b(th);
                    obj.onError(th);
                    return;
                }
                if (!this.it.hasNext() && !this.cancelled) {
                }
            }
        }

        @Override // i.b.m0.e.b.q$a
        void b(long j) {
            int i;
            int cmp2;
            boolean cancelled2;
            long andGet;
            final long l = 0L;
            while (/* condition */) {
                while (i != andGet) {
                    try {
                        Object item = this.it.next();
                    } catch (Throwable th) {
                        a.b(th);
                        obj.onError(th);
                        return;
                    }
                    this.downstream.onNext(item);
                    try {
                    } catch (Throwable th) {
                        a.b(th);
                        obj.onError(th);
                        return;
                    }
                    if (!this.it.hasNext()) {
                    }
                    andGet = get();
                    if (i == andGet) {
                        andGet = addAndGet(-i);
                    }
                }
                andGet = get();
                if (i == andGet) {
                    andGet = addAndGet(-i);
                }
                try {
                    item = this.it.next();
                } catch (Throwable th) {
                    a.b(th);
                    obj.onError(th);
                    return;
                }
                this.downstream.onNext(item);
                try {
                } catch (Throwable th) {
                    a.b(th);
                    obj.onError(th);
                    return;
                }
                if (!this.it.hasNext()) {
                }
            }
        }
    }
    public q(Iterable<? extends T> iterable) {
        super();
        this.b = iterable;
    }

    public static <T> void g0(m.c.b<? super T> bVar, Iterator<? extends T> iterator) {
        try {
        } catch (Throwable th) {
            a.b(th);
            d.error(th, bVar);
            return;
        }
        if (!iterator.hasNext()) {
            d.complete(bVar);
            return;
        }
        if (bVar instanceof a) {
            bVar.onSubscribe(new q.b((a)bVar, th));
        } else {
            bVar.onSubscribe(new q.c(bVar, th));
        }
    }

    @Override // i.b.h
    public void c0(m.c.b<? super T> bVar) {
        try {
        } catch (Throwable th) {
            a.b(th);
            d.error(th, bVar);
            return;
        }
        q.g0(bVar, this.b.iterator());
    }
}
