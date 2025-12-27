package i.b.m0.f;

import i.b.m0.c.i;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MpscLinkedQueue.java */
/* loaded from: classes3.dex */
public final class a<T> implements i<T> {

    private final AtomicReference<a.a<T>> a = new AtomicReference<>();
    private final AtomicReference<a.a<T>> b = new AtomicReference<>();

    static final class a<E> extends AtomicReference<a.a<E>> {

        private static final long serialVersionUID = 2404266111789071508L;
        private E value;
        a() {
            super();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public E a() {
            e(null);
            return b();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public E b() {
            return this.value;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public a.a<E> c() {
            return (a.a)get();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void d(a.a<E> aVar) {
            lazySet(aVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void e(E e) {
            this.value = e;
        }

        a(E e) {
            super();
            e(e);
        }
    }
    public a() {
        super();
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        i.b.m0.f.a.a aVar = new a.a();
        d(aVar);
        e(aVar);
    }

    a.a<T> a() {
        return (a.a)this.b.get();
    }

    a.a<T> b() {
        return (a.a)this.b.get();
    }

    a.a<T> c() {
        return (a.a)this.a.get();
    }

    public void clear() {
        while (poll() != null) {
        }
    }

    void d(a.a<T> aVar) {
        this.b.lazySet(aVar);
    }

    a.a<T> e(a.a<T> aVar) {
        return (a.a)this.a.getAndSet(aVar);
    }

    public boolean isEmpty() {
        boolean z = true;
        int r0 = b() == c() ? 1 : 0;
        return (b() == c() ? 1 : 0);
    }

    public boolean offer(T t) {
        Objects.requireNonNull(t, "Null is not a valid element");
        i.b.m0.f.a.a aVar = new a.a(t);
        e(aVar).d(aVar);
        return true;
    }

    public T poll() {
        i.b.m0.f.a.a aVar2 = a();
        i.b.m0.f.a.a aVar3 = aVar2.c();
        if (aVar3 != null) {
            d(aVar3);
            return aVar3.a();
        }
        if (aVar2 != c()) {
            i.b.m0.f.a.a aVar = aVar2.c();
            while (aVar == null) {
                aVar = aVar2.c();
            }
            d(aVar);
            return aVar.a();
        }
        return null;
    }
}
