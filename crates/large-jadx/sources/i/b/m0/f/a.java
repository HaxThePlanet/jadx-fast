package i.b.m0.f;

import i.b.m0.c.i;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class a<T>  implements i<T> {

    private final AtomicReference<i.b.m0.f.a.a<T>> a;
    private final AtomicReference<i.b.m0.f.a.a<T>> b;

    static final class a extends AtomicReference<i.b.m0.f.a.a<E>> {

        private static final long serialVersionUID = 2404266111789071508L;
        private E value;
        a(E e) {
            super();
            e(e);
        }

        public E a() {
            e(0);
            return b();
        }

        public E b() {
            return this.value;
        }

        public i.b.m0.f.a.a<E> c() {
            return (a.a)get();
        }

        public void d(i.b.m0.f.a.a<E> a$a) {
            lazySet(a);
        }

        public void e(E e) {
            this.value = e;
        }
    }
    public a() {
        super();
        AtomicReference atomicReference = new AtomicReference();
        this.a = atomicReference;
        AtomicReference atomicReference2 = new AtomicReference();
        this.b = atomicReference2;
        a.a aVar = new a.a();
        d(aVar);
        e(aVar);
    }

    i.b.m0.f.a.a<T> a() {
        return (a.a)this.b.get();
    }

    i.b.m0.f.a.a<T> b() {
        return (a.a)this.b.get();
    }

    i.b.m0.f.a.a<T> c() {
        return (a.a)this.a.get();
    }

    @Override // i.b.m0.c.i
    public void clear() {
        Object empty;
        while (poll() != null) {
            if (!isEmpty()) {
            }
        }
    }

    void d(i.b.m0.f.a.a<T> a$a) {
        this.b.lazySet(a);
    }

    i.b.m0.f.a.a<T> e(i.b.m0.f.a.a<T> a$a) {
        return (a.a)this.a.getAndSet(a);
    }

    @Override // i.b.m0.c.i
    public boolean isEmpty() {
        int i;
        i = b() == c() ? 1 : 0;
        return i;
    }

    public boolean offer(T t) {
        Objects.requireNonNull(t, "Null is not a valid element");
        a.a aVar = new a.a(t);
        e(aVar).d(aVar);
        return 1;
    }

    public T poll() {
        i.b.m0.f.a.a aVar;
        i.b.m0.f.a.a aVar2 = a();
        i.b.m0.f.a.a aVar3 = aVar2.c();
        if (aVar3 != null) {
            d(aVar3);
            return aVar3.a();
        }
        if (aVar2 != c()) {
        }
        return 0;
    }
}
