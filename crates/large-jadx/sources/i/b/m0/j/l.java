package i.b.m0.j;

import i.b.p0.a;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.b;

/* loaded from: classes3.dex */
public final class l {
    public static void a(y<?> y, AtomicInteger atomicInteger2, i.b.m0.j.c c3) {
        int obj1;
        if (atomicInteger2.getAndIncrement() == 0) {
            obj1 = c3.b();
            if (obj1 != null) {
                y.onError(obj1);
            } else {
                y.onComplete();
            }
        }
    }

    public static void b(b<?> b, AtomicInteger atomicInteger2, i.b.m0.j.c c3) {
        int obj1;
        if (atomicInteger2.getAndIncrement() == 0) {
            obj1 = c3.b();
            if (obj1 != null) {
                b.onError(obj1);
            } else {
                b.onComplete();
            }
        }
    }

    public static void c(y<?> y, Throwable throwable2, AtomicInteger atomicInteger3, i.b.m0.j.c c4) {
        Throwable obj2;
        if (c4.a(throwable2)) {
            if (atomicInteger3.getAndIncrement() == 0) {
                y.onError(c4.b());
            }
        } else {
            a.t(throwable2);
        }
    }

    public static void d(b<?> b, Throwable throwable2, AtomicInteger atomicInteger3, i.b.m0.j.c c4) {
        Throwable obj2;
        if (c4.a(throwable2)) {
            if (atomicInteger3.getAndIncrement() == 0) {
                b.onError(c4.b());
            }
        } else {
            a.t(throwable2);
        }
    }

    public static <T> void e(y<? super T> y, T t2, AtomicInteger atomicInteger3, i.b.m0.j.c c4) {
        int compareAndSet;
        int i;
        Object obj3;
        y.onNext(t2);
        if (atomicInteger3.get() == 0 && atomicInteger3.compareAndSet(0, 1) && atomicInteger3.decrementAndGet() != 0) {
            if (atomicInteger3.compareAndSet(0, 1)) {
                y.onNext(t2);
                if (atomicInteger3.decrementAndGet() != 0) {
                    obj3 = c4.b();
                    if (obj3 != null) {
                        y.onError(obj3);
                    } else {
                        y.onComplete();
                    }
                }
            }
        }
    }

    public static <T> void f(b<? super T> b, T t2, AtomicInteger atomicInteger3, i.b.m0.j.c c4) {
        int compareAndSet;
        int i;
        Object obj3;
        b.onNext(t2);
        if (atomicInteger3.get() == 0 && atomicInteger3.compareAndSet(0, 1) && atomicInteger3.decrementAndGet() != 0) {
            if (atomicInteger3.compareAndSet(0, 1)) {
                b.onNext(t2);
                if (atomicInteger3.decrementAndGet() != 0) {
                    obj3 = c4.b();
                    if (obj3 != null) {
                        b.onError(obj3);
                    } else {
                        b.onComplete();
                    }
                }
            }
        }
    }
}
