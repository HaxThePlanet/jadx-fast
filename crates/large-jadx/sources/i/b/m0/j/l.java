package i.b.m0.j;

import i.b.p0.a;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;
import m.c.b;

/* compiled from: HalfSerializer.java */
/* loaded from: classes3.dex */
public final class l {
    public static void a(y<?> yVar, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.getAndIncrement() == 0 && th != null) {
            yVar.onError(th);
        }
    }

    public static void b(b<?> bVar, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.getAndIncrement() == 0 && th != null) {
            bVar.onError(th);
        }
    }

    public static void c(y<?> yVar, Throwable th, AtomicInteger atomicInteger, c cVar) {
        if (!cVar.a(th)) {
            a.t(th);
        } else {
            if (atomicInteger.getAndIncrement() == 0) {
                yVar.onError(cVar.b());
            }
        }
    }

    public static void d(b<?> bVar, Throwable th, AtomicInteger atomicInteger, c cVar) {
        if (!cVar.a(th)) {
            a.t(th);
        } else {
            if (atomicInteger.getAndIncrement() == 0) {
                bVar.onError(cVar.b());
            }
        }
    }

    public static <T> void e(y<? super T> yVar, T t, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.get() == 0) {
            int i2 = 1;
            if (atomicInteger.compareAndSet(0, i2)) {
                yVar.onNext(t);
                if (atomicInteger.decrementAndGet() != 0 && th != null) {
                    yVar.onError(th);
                }
            }
        }
    }

    public static <T> void f(b<? super T> bVar, T t, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.get() == 0) {
            int i2 = 1;
            if (atomicInteger.compareAndSet(0, i2)) {
                bVar.onNext(t);
                if (atomicInteger.decrementAndGet() != 0 && th != null) {
                    bVar.onError(th);
                }
            }
        }
    }
}
