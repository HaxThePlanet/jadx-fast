package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.d;
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

/* compiled from: ObservableGroupBy.java */
/* loaded from: classes3.dex */
public final class i1<T, K, V> extends a<T, i.b.n0.b<K, V>> {

    final n<? super T, ? extends K> b;
    final n<? super T, ? extends V> c;
    final int v;
    final boolean w;

    public static final class a<T, K, V> extends AtomicInteger implements y<T>, i.b.j0.b {

        static final Object a = null;
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        final y<? super i.b.n0.b<K, V>> downstream;
        final Map<Object, i1.b<K, V>> groups = new ConcurrentHashMap<>();
        final n<? super T, ? extends K> keySelector;
        i.b.j0.b upstream;
        final n<? super T, ? extends V> valueSelector;
        static {
            i1.a.a = new Object();
        }

        public a(y<? super i.b.n0.b<K, V>> yVar, n<? super T, ? extends K> nVar, n<? super T, ? extends V> nVar2, int i, boolean z) {
            super();
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.downstream = yVar;
            this.keySelector = nVar;
            this.valueSelector = nVar2;
            this.bufferSize = i;
            this.delayError = z;
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            lazySet(1);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void a(K k) {
            Object obj;
            if (k == 0) {
                obj = i1.a.a;
            }
            this.groups.remove(obj);
            if (decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && this.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.groups.clear();
            Iterator it = new ArrayList(this.groups.values()).iterator();
            while (it.hasNext()) {
                (i1.b)it.next().onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            this.groups.clear();
            Iterator it = new ArrayList(this.groups.values()).iterator();
            while (it.hasNext()) {
                (i1.b)it.next().onError(th);
            }
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            Object apply;
            Object value;
            try {
                apply = this.keySelector.apply(t);
            } catch (Throwable th) {
                a.b(th);
                this.upstream.dispose();
                onError(th);
                return;
            }
            Object r1 = this.keySelector != null ? apply : i1.a.a;
            if ((i1.b)this.groups.get(r1) == null) {
                if (this.cancelled.get()) {
                    return;
                }
                i.b.m0.e.e.i1.b bVar = i1.b.c(apply, this.bufferSize, this, this.delayError);
                this.groups.put(r1, bVar);
                getAndIncrement();
                this.downstream.onNext(bVar);
            }
            try {
                final Object apply2 = this.valueSelector.apply(th);
                b.e(apply2, "The value supplied is null");
            } catch (Throwable th) {
                a.b(th);
                this.upstream.dispose();
                onError(th);
                return;
            }
            value.onNext(apply2);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(i.b.j0.b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    static final class c<T, K> extends AtomicInteger implements i.b.j0.b, w<T> {

        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<y<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicBoolean once = new AtomicBoolean();
        final i1.a<?, K, T> parent;
        final i.b.m0.f.c<T> queue = new c<>();
        c(int i, i1.a<?, K, T> aVar, K k, boolean z) {
            super();
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            AtomicBoolean atomicBoolean2 = new AtomicBoolean();
            AtomicReference atomicReference = new AtomicReference();
            i.b.m0.f.c cVar = new c(i);
            this.parent = aVar;
            this.key = k;
            this.delayError = z;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean a(boolean z, boolean z2, y<? super T> yVar, boolean z3) {
            final boolean z5 = true;
            final Object obj = null;
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.a(this.key);
                this.actual.lazySet(obj);
                return true;
            }
            if (this.queue && z3 && this.key) {
                this.actual.lazySet(obj);
                if (this.error != null) {
                    yVar.onError(this.error);
                } else {
                    yVar.onComplete();
                }
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            y yVar;
            int andGet;
            boolean z;
            Object poll;
            boolean z2;
            if (getAndIncrement() != 0) {
                return;
            }
            Object obj = this.actual.get();
            andGet = 1;
            while (this.actual != null) {
                poll = this.queue.poll();
                while (poll == null) {
                    int i2 = 0;
                }
                i2 = 0;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void c() {
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void d(Throwable th) {
            this.error = th;
            this.done = true;
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean z = false;
            if (this.cancelled.compareAndSet(z, true) && this.getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.a(this.key);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void e(T t) {
            this.queue.offer(t);
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void subscribe(y<? super T> yVar) {
            boolean z = false;
            if (!this.once.compareAndSet(z, true)) {
                d.error(new IllegalStateException("Only one Observer allowed!"), yVar);
            } else {
                yVar.onSubscribe(this);
                this.actual.lazySet(yVar);
                if (this.cancelled.get()) {
                    this.actual.lazySet(null);
                } else {
                    b();
                }
            }
        }
    }

    static final class b<K, T> extends i.b.n0.b<K, T> {

        final i1.c<T, K> b;
        protected b(K k, i1.c<T, K> cVar) {
            super(k);
            this.b = cVar;
        }

        public static <T, K> i1.b<K, T> c(K k, int i, i1.a<?, K, T> aVar, boolean z) {
            return new i1.b(k, new i1.c(i, aVar, k, z));
        }

        @Override // i.b.n0.b
        public void onComplete() {
            this.b.c();
        }

        @Override // i.b.n0.b
        public void onError(Throwable th) {
            this.b.d(th);
        }

        @Override // i.b.n0.b
        public void onNext(T t) {
            this.b.e(t);
        }

        @Override // i.b.n0.b
        protected void subscribeActual(y<? super T> yVar) {
            this.b.subscribe(yVar);
        }
    }
    public i1(w<T> wVar, n<? super T, ? extends K> nVar, n<? super T, ? extends V> nVar2, int i, boolean z) {
        super(wVar);
        this.b = nVar;
        this.c = nVar2;
        this.v = i;
        this.w = z;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super i.b.n0.b<K, V>> yVar) {
        i1.a aVar = new i1.a(yVar, this.b, this.c, this.v, this.w);
        this.a.subscribe(aVar);
    }
}
