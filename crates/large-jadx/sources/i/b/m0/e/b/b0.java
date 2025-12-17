package i.b.m0.e.b;

import i.b.h;
import i.b.j0.b;
import i.b.k;
import i.b.k0.a;
import i.b.l0.f;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.f.b;
import i.b.m0.i.g;
import i.b.m0.j.d;
import i.b.m0.j.k;
import i.b.m0.j.n;
import i.b.p0.a;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.a;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class b0<T>  extends a<T> {

    final h<T> b;
    final AtomicReference<i.b.m0.e.b.b0.c<T>> c;
    final int v;
    final a<T> w;

    static final class a implements a<T> {

        private final AtomicReference<i.b.m0.e.b.b0.c<T>> a;
        private final int b;
        a(AtomicReference<i.b.m0.e.b.b0.c<T>> atomicReference, int i2) {
            super();
            this.a = atomicReference;
            this.b = i2;
        }

        public void a(b<? super T> b) {
            i.b.m0.e.b.b0.c cVar;
            AtomicReference atomicReference;
            int i;
            b obj6;
            b0.b bVar = new b0.b(b);
            b.onSubscribe(bVar);
            obj6 = this.a.get();
            do {
                obj6 = this.a.get();
                cVar = new b0.c(this.a, this.b);
                if (this.a.compareAndSet((b0.c)(b0.c)obj6, cVar) == null) {
                } else {
                }
                obj6 = cVar;
                if (!obj6.a(bVar)) {
                }
                if (obj6.isDisposed()) {
                }
            } while ((b0.c)obj6 != null);
            if (Long.compare(l, l2) == 0) {
                obj6.e(bVar);
            } else {
                bVar.parent = obj6;
            }
            obj6.d();
        }
    }

    static final class b extends AtomicLong implements c {

        private static final long serialVersionUID = -4453897557930727610L;
        final b<? super T> child;
        long emitted;
        volatile i.b.m0.e.b.b0.c<T> parent;
        b(b<? super T> b) {
            super();
            this.child = b;
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void cancel() {
            int parent;
            final long l2 = Long.MIN_VALUE;
            parent = this.parent;
            if (Long.compare(l, l2) != 0 && Long.compare(andSet, l2) != 0 && parent != null) {
                if (Long.compare(andSet, l2) != 0) {
                    parent = this.parent;
                    if (parent != null) {
                        parent.e(this);
                        parent.d();
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public void request(long l) {
            Object obj2;
            d.b(this, l);
            obj2 = this.parent;
            if (g.validate(l) && obj2 != null) {
                d.b(this, l);
                obj2 = this.parent;
                if (obj2 != null) {
                    obj2.d();
                }
            }
        }
    }

    static final class c extends AtomicInteger implements k<T>, b {

        static final i.b.m0.e.b.b0.b[] a = null;
        static final i.b.m0.e.b.b0.b[] b = null;
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<i.b.m0.e.b.b0.c<T>> current;
        volatile j<T> queue;
        final AtomicBoolean shouldConnect;
        int sourceMode;
        final AtomicReference<i.b.m0.e.b.b0.b<T>[]> subscribers;
        volatile Object terminalEvent;
        final AtomicReference<c> upstream;
        static {
            int i = 0;
            b0.c.a = new b0.b[i];
            b0.c.b = new b0.b[i];
        }

        c(AtomicReference<i.b.m0.e.b.b0.c<T>> atomicReference, int i2) {
            super();
            AtomicReference atomicReference2 = new AtomicReference();
            this.upstream = atomicReference2;
            AtomicReference atomicReference3 = new AtomicReference(b0.c.a);
            this.subscribers = atomicReference3;
            this.current = atomicReference;
            AtomicBoolean obj3 = new AtomicBoolean();
            this.shouldConnect = obj3;
            this.bufferSize = i2;
        }

        boolean a(i.b.m0.e.b.b0.b<T> b0$b) {
            Object obj = this.subscribers.get();
            final int i = 0;
            while ((b0.b[])obj == b0.c.b) {
                int length = obj.length;
                i.b.m0.e.b.b0.b[] arr = new b0.b[length + 1];
                System.arraycopy((b0.b[])obj, i, arr, i, length);
                arr[length] = b;
                obj = this.subscribers.get();
                i = 0;
            }
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean b(Object object, boolean z2) {
            int i;
            boolean complete;
            int length;
            int child;
            int i2;
            if (object != null) {
                child = 0;
                i2 = 1;
                if (n.isComplete(object)) {
                    if (z2) {
                        this.current.compareAndSet(this, child);
                        Object obj5 = this.subscribers.getAndSet(b0.c.b);
                        while (i < obj5.length) {
                            obj.child.onComplete();
                            i++;
                        }
                        return i2;
                    }
                } else {
                    obj5 = n.getError(object);
                    this.current.compareAndSet(this, child);
                    Object obj6 = this.subscribers.getAndSet(b0.c.b);
                    if (obj6.length != 0) {
                        while (i < obj6.length) {
                            obj2.child.onError(obj5);
                            i++;
                        }
                    } else {
                        a.t(obj5);
                    }
                }
                return i2;
            }
            return 0;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            Object sourceMode2;
            Object terminalEvent;
            int sourceMode;
            Object terminalEvent2;
            int sourceMode3;
            Object child;
            Object obj;
            int andGet;
            Throwable queue;
            int i4;
            Object poll2;
            Throwable length;
            Object poll;
            int i3;
            int i6;
            int i;
            long l;
            int i2;
            long l2;
            long cmp;
            long l4;
            long l3;
            j jVar;
            int i5;
            int cmp2;
            final Object obj2 = this;
            if (getAndIncrement() != 0) {
            }
            final AtomicReference subscribers = obj2.subscribers;
            obj = sourceMode2;
            andGet = sourceMode3;
            queue = obj2.queue;
            while (queue != null) {
                if (queue.isEmpty()) {
                } else {
                }
                length = 0;
                obj = sourceMode2;
                queue = obj2.queue;
                length = sourceMode3;
                l = 0;
                i2 = 0;
                l2 = Long.MAX_VALUE;
                cmp = Long.MIN_VALUE;
                while (l < obj.length) {
                    i4 = obj[l];
                    l4 = i4.get();
                    if (Long.compare(l4, cmp) != 0) {
                    } else {
                    }
                    i2++;
                    l++;
                    cmp = Long.MIN_VALUE;
                    l2 = Math.min(l2, obj15);
                }
                i3 = 1;
                i = 0;
                l = (long)i;
                while (Long.compare(l, l2) < 0) {
                    terminalEvent2 = obj2.terminalEvent;
                    poll = queue.poll();
                    if (poll == null) {
                    } else {
                    }
                    i4 = 0;
                    l = 0;
                    i2 = 0;
                    while (l < obj.length) {
                        child = obj[l];
                        long l5 = child.get();
                        if (Long.compare(l5, cmp) != 0) {
                        } else {
                        }
                        jVar = queue;
                        i5 = i4;
                        l3 = Long.MAX_VALUE;
                        i2 = 1;
                        l++;
                        queue = jVar;
                        i4 = i5;
                        sourceMode3 = 1;
                        if (Long.compare(l5, l3) != 0) {
                        } else {
                        }
                        jVar = queue;
                        i5 = i4;
                        child.child.onNext(n.getValue(poll));
                        jVar = queue;
                        i5 = i4;
                        child.emitted = emitted += i3;
                    }
                    l3 = Long.MAX_VALUE;
                    i++;
                    sourceMode2 = subscribers.get();
                    queue = jVar;
                    length = i5;
                    sourceMode3 = 1;
                    l = (long)i;
                    child = obj[l];
                    l5 = child.get();
                    if (Long.compare(l5, cmp) != 0) {
                    } else {
                    }
                    jVar = queue;
                    i5 = i4;
                    l3 = Long.MAX_VALUE;
                    i2 = 1;
                    l++;
                    queue = jVar;
                    i4 = i5;
                    sourceMode3 = 1;
                    if (Long.compare(l5, l3) != 0) {
                    } else {
                    }
                    jVar = queue;
                    i5 = i4;
                    child.child.onNext(value);
                    jVar = queue;
                    i5 = i4;
                    child.emitted = emitted += i3;
                    i4 = sourceMode3;
                    length = error;
                    a.b(length);
                    Throwable error = obj1.upstream;
                    error = error.get();
                    (c)error.cancel();
                    error = n.error(length);
                    obj1.terminalEvent = error;
                    length = null;
                }
                if (i != 0) {
                } else {
                }
                sourceMode3 = 1;
                if (obj2.sourceMode != 1) {
                }
                (c)obj2.upstream.get().request(l);
                terminalEvent2 = obj2.terminalEvent;
                poll = queue.poll();
                if (poll == null) {
                } else {
                }
                i4 = 0;
                l = 0;
                i2 = 0;
                while (l < obj.length) {
                    child = obj[l];
                    l5 = child.get();
                    if (Long.compare(l5, cmp) != 0) {
                    } else {
                    }
                    jVar = queue;
                    i5 = i4;
                    l3 = Long.MAX_VALUE;
                    i2 = 1;
                    l++;
                    queue = jVar;
                    i4 = i5;
                    sourceMode3 = 1;
                    if (Long.compare(l5, l3) != 0) {
                    } else {
                    }
                    jVar = queue;
                    i5 = i4;
                    child.child.onNext(n.getValue(poll));
                    jVar = queue;
                    i5 = i4;
                    child.emitted = emitted += i3;
                }
                l3 = Long.MAX_VALUE;
                i++;
                sourceMode2 = subscribers.get();
                if (i != 0 && obj2.sourceMode != 1) {
                }
                obj = sourceMode2;
                sourceMode3 = 1;
                if (obj2.sourceMode != 1) {
                }
                (c)obj2.upstream.get().request((long)i);
                queue = jVar;
                length = i5;
                sourceMode3 = 1;
                child = obj[l];
                l5 = child.get();
                if (Long.compare(l5, cmp) != 0) {
                } else {
                }
                jVar = queue;
                i5 = i4;
                l3 = Long.MAX_VALUE;
                i2 = 1;
                l++;
                queue = jVar;
                i4 = i5;
                sourceMode3 = 1;
                if (Long.compare(l5, l3) != 0) {
                } else {
                }
                jVar = queue;
                i5 = i4;
                child.child.onNext(value);
                jVar = queue;
                i5 = i4;
                child.emitted = emitted += i3;
                length = i4;
                i4 = sourceMode3;
                terminalEvent = obj2.terminalEvent;
                poll2 = queue.poll();
                if (poll2 == null) {
                } else {
                }
                i4 = 0;
                if (obj2.sourceMode != sourceMode3) {
                }
                (c)obj2.upstream.get().request(i3);
                i4 = sourceMode3;
                i4 = obj[l];
                l4 = i4.get();
                if (Long.compare(l4, cmp) != 0) {
                } else {
                }
                i2++;
                l++;
                l2 = Math.min(l2, obj15);
                queue = error;
                a.b(queue);
                error = obj1.upstream;
                error = error.get();
                (c)error.cancel();
                error = n.error(queue);
                obj1.terminalEvent = error;
                i4 = 0;
                length = error;
                a.b(length);
                error = obj1.upstream;
                error = error.get();
                (c)error.cancel();
                error = n.error(length);
                obj1.terminalEvent = error;
                length = null;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            Object andSet;
            i.b.m0.e.b.b0.b[] objArr;
            objArr = b0.c.b;
            if (this.subscribers.get() != objArr && (b0.b[])this.subscribers.getAndSet(objArr) != objArr) {
                if ((b0.b[])this.subscribers.getAndSet(objArr) != objArr) {
                    this.current.compareAndSet(this, 0);
                    g.cancel(this.upstream);
                }
            }
        }

        void e(i.b.m0.e.b.b0.b<T> b0$b) {
            boolean compareAndSet;
            i.b.m0.e.b.b0.b[] length;
            int i;
            AtomicReference subscribers;
            int i2;
            int i4;
            int i3;
            i.b.m0.e.b.b0.b[] equals;
            compareAndSet = this.subscribers.get();
            length = compareAndSet.length;
            while (length == 0) {
                i = -1;
                i2 = 0;
                i4 = i2;
                while (i4 < length) {
                    if ((b0.b[])compareAndSet[i4].equals(b)) {
                        break loop_3;
                    } else {
                    }
                    i4++;
                }
                i3 = 1;
                if (length == i3) {
                } else {
                }
                equals = new b0.b[length + -1];
                System.arraycopy(compareAndSet, i2, equals, i2, i);
                System.arraycopy(compareAndSet, i + 1, equals, i, i5 -= i3);
                length = equals;
                compareAndSet = this.subscribers.get();
                length = compareAndSet.length;
                length = b0.c.a;
                if ((b0.b[])compareAndSet[i4].equals(b)) {
                } else {
                }
                i4++;
                i = i4;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            int i;
            i = this.subscribers.get() == b0.c.b ? 1 : 0;
            return i;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            Object terminalEvent;
            if (this.terminalEvent == null) {
                this.terminalEvent = n.complete();
                d();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            Object obj2;
            if (this.terminalEvent == null) {
                this.terminalEvent = n.error(throwable);
                d();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            int sourceMode;
            Object obj2;
            if (this.sourceMode == 0 && !this.queue.offer(t)) {
                if (!this.queue.offer(t)) {
                    obj2 = new MissingBackpressureException("Prefetch queue is full?!");
                    onError(obj2);
                }
            }
            d();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(c c) {
            boolean once;
            boolean z;
            int requestFusion;
            int i;
            z = c;
            requestFusion = (g)z.requestFusion(7);
            if (g.setOnce(this.upstream, c) && c instanceof g && requestFusion == 1) {
                if (c instanceof g) {
                    z = c;
                    requestFusion = (g)z.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = z;
                        this.terminalEvent = n.complete();
                        d();
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = z;
                        c.request((long)bufferSize2);
                    }
                }
                requestFusion = this.bufferSize;
                b bVar = new b(requestFusion);
                this.queue = bVar;
                c.request((long)bufferSize);
            }
        }
    }
    private b0(a<T> a, h<T> h2, AtomicReference<i.b.m0.e.b.b0.c<T>> atomicReference3, int i4) {
        super();
        this.w = a;
        this.b = h2;
        this.c = atomicReference3;
        this.v = i4;
    }

    public static <T> a<T> i0(h<T> h, int i2) {
        AtomicReference atomicReference = new AtomicReference();
        b0.a aVar = new b0.a(atomicReference, i2);
        b0 b0Var = new b0(aVar, h, atomicReference, i2);
        return a.p(b0Var);
    }

    protected void c0(b<? super T> b) {
        this.w.a(b);
    }

    public void h0(f<? super b> f) {
        Object obj;
        boolean cVar;
        boolean compareAndSet;
        AtomicReference atomicReference;
        int i2;
        int i;
        Object obj5;
        obj = this.c.get();
        while ((b0.c)obj != null) {
            if ((b0.c)obj.isDisposed()) {
                break;
            }
            cVar = new b0.c(this.c, this.v);
            if (this.c.compareAndSet(obj, cVar)) {
                break;
            } else {
            }
            obj = this.c.get();
        }
        int i3 = 0;
        if (!obj.shouldConnect.get() && obj.shouldConnect.compareAndSet(i3, true)) {
            if (obj.shouldConnect.compareAndSet(i3, i2)) {
            } else {
                i2 = i3;
            }
        } else {
        }
        f.accept(obj);
        if (i2 != 0) {
            this.b.b0(obj);
        }
    }
}
