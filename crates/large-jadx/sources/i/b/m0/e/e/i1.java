package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.f.c;
import i.b.n0.b;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class i1<T, K, V>  extends i.b.m0.e.e.a<T, b<K, V>> {

    final n<? super T, ? extends K> b;
    final n<? super T, ? extends V> c;
    final int v;
    final boolean w;

    public static final class a extends AtomicInteger implements y<T>, b {

        static final Object a = null;
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final AtomicBoolean cancelled;
        final boolean delayError;
        final y<? super b<K, V>> downstream;
        final Map<Object, i.b.m0.e.e.i1.b<K, V>> groups;
        final n<? super T, ? extends K> keySelector;
        b upstream;
        final n<? super T, ? extends V> valueSelector;
        static {
            Object object = new Object();
            i1.a.a = object;
        }

        public a(y<? super b<K, V>> y, n<? super T, ? extends K> n2, n<? super T, ? extends V> n3, int i4, boolean z5) {
            super();
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.cancelled = atomicBoolean;
            this.downstream = y;
            this.keySelector = n2;
            this.valueSelector = n3;
            this.bufferSize = i4;
            this.delayError = z5;
            ConcurrentHashMap obj2 = new ConcurrentHashMap();
            this.groups = obj2;
            lazySet(1);
        }

        public void a(K k) {
            Object obj2;
            if (k != null) {
            } else {
                obj2 = i1.a.a;
            }
            this.groups.remove(obj2);
            if (decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean decrementAndGet;
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                if (decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            Map groups;
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator iterator = arrayList.iterator();
            for (i1.b groups : iterator) {
                groups.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            Map groups;
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator iterator = arrayList.iterator();
            for (i1.b groups : iterator) {
                groups.onError(throwable);
            }
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            Object downstream;
            Object obj2;
            Object obj;
            boolean delayError;
            try {
                downstream = this.keySelector.apply(t);
                if (downstream != null) {
                } else {
                }
                obj2 = downstream;
                obj2 = i1.a.a;
                if (this.cancelled.get()) {
                }
            } catch (Throwable th) {
            }
            final Object obj5 = this.valueSelector.apply(t);
            b.e(obj5, "The value supplied is null");
            obj.onNext(obj5);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }

    static final class c extends AtomicInteger implements b, w<T> {

        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<y<? super T>> actual;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once;
        final i.b.m0.e.e.i1.a<?, K, T> parent;
        final c<T> queue;
        c(int i, i.b.m0.e.e.i1.a<?, K, T> i1$a2, K k3, boolean z4) {
            super();
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.cancelled = atomicBoolean;
            AtomicBoolean atomicBoolean2 = new AtomicBoolean();
            this.once = atomicBoolean2;
            AtomicReference atomicReference = new AtomicReference();
            this.actual = atomicReference;
            c cVar = new c(i);
            this.queue = cVar;
            this.parent = a2;
            this.key = k3;
            this.delayError = z4;
        }

        boolean a(boolean z, boolean z2, y<? super T> y3, boolean z4) {
            Throwable obj4;
            final int i = 1;
            final int i2 = 0;
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.a(this.key);
                this.actual.lazySet(i2);
                return i;
            }
            if (z != null) {
                if (z4) {
                    if (z2) {
                        obj4 = this.error;
                        this.actual.lazySet(i2);
                        if (obj4 != null) {
                            y3.onError(obj4);
                        } else {
                            y3.onComplete();
                        }
                        return i;
                    }
                } else {
                    obj4 = this.error;
                    if (obj4 != null) {
                        this.queue.clear();
                        this.actual.lazySet(i2);
                        y3.onError(obj4);
                        return i;
                    }
                    if (z2) {
                        this.actual.lazySet(i2);
                        y3.onComplete();
                        return i;
                    }
                }
            }
            return 0;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            Object obj;
            int andGet;
            boolean z;
            Object poll;
            int i;
            if (getAndIncrement() != 0) {
            }
            obj = this.actual.get();
            final int i2 = 1;
            andGet = i2;
            while (obj != null) {
                poll = this.queue.poll();
                while (poll == null) {
                    i = i2;
                    obj.onNext(poll);
                    poll = queue.poll();
                    i = 0;
                }
                i = 0;
                obj.onNext(poll);
                if (obj == null) {
                }
                obj = this.actual.get();
                i = i2;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void c() {
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void d(Throwable throwable) {
            this.error = throwable;
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean compareAndSet;
            int key;
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                if (getAndIncrement() == 0) {
                    this.actual.lazySet(0);
                    this.parent.a(this.key);
                }
            }
        }

        public void e(T t) {
            this.queue.offer(t);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void subscribe(y<? super T> y) {
            AtomicReference illegalStateException;
            int str;
            boolean obj4;
            if (this.once.compareAndSet(false, true)) {
                y.onSubscribe(this);
                this.actual.lazySet(y);
                if (this.cancelled.get()) {
                    this.actual.lazySet(0);
                } else {
                    b();
                }
            } else {
                illegalStateException = new IllegalStateException("Only one Observer allowed!");
                d.error(illegalStateException, y);
            }
        }
    }

    static final class b extends b<K, T> {

        final i.b.m0.e.e.i1.c<T, K> b;
        protected b(K k, i.b.m0.e.e.i1.c<T, K> i1$c2) {
            super(k);
            this.b = c2;
        }

        public static <T, K> i.b.m0.e.e.i1.b<K, T> c(K k, int i2, i.b.m0.e.e.i1.a<?, K, T> i1$a3, boolean z4) {
            i1.c cVar = new i1.c(i2, a3, k, z4);
            i1.b obj2 = new i1.b(k, cVar);
            return obj2;
        }

        @Override // i.b.n0.b
        public void onComplete() {
            this.b.c();
        }

        @Override // i.b.n0.b
        public void onError(Throwable throwable) {
            this.b.d(throwable);
        }

        public void onNext(T t) {
            this.b.e(t);
        }

        protected void subscribeActual(y<? super T> y) {
            this.b.subscribe(y);
        }
    }
    public i1(w<T> w, n<? super T, ? extends K> n2, n<? super T, ? extends V> n3, int i4, boolean z5) {
        super(w);
        this.b = n2;
        this.c = n3;
        this.v = i4;
        this.w = z5;
    }

    public void subscribeActual(y<? super b<K, V>> y) {
        super(y, this.b, this.c, this.v, this.w);
        this.a.subscribe(aVar2);
    }
}
