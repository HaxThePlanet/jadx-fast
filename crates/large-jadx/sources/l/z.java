package l;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.d0.d.n;

/* compiled from: SegmentPool.kt */
/* loaded from: classes3.dex */
public final class z {

    private static final int a = 65536;
    private static final y b;
    private static final int c = 0;
    private static final AtomicReference<y>[] d;
    public static final z e = new z();
    static {
        int i = 0;
        i = 0;
        y yVar = new y(new byte[i], 0, 0, false, false);
        z.b = yVar;
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        z.c = highestOneBit;
        AtomicReference[] arr = new AtomicReference[highestOneBit];
        while (i < highestOneBit) {
            arr[i] = new AtomicReference();
            i = i + 1;
        }
        z.d = arr;
    }

    private z() {
        super();
    }

    private final AtomicReference<y> a() {
        Thread currentThread = Thread.currentThread();
        n.e(currentThread, "Thread.currentThread()");
        return z.d[(int)(currentThread.getId() & (long)z.c - 1L)];
    }

    public static final void b(y yVar) {
        int i = 1;
        n.f(yVar, "segment");
        i = 0;
        int r0 = yVar.f == null && yVar.g == null ? 1 : i;
        if (yVar.f == 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else {
            if (yVar.d) {
                return;
            }
            AtomicReference atomicReference = z.e.a();
            final Object obj = atomicReference.get();
            if (obj == z.b) {
                return;
            }
            int r3 = obj != null ? obj.c : i;
            if (z.b >= z.a) {
                return;
            }
            yVar.f = obj;
            yVar.b = i;
            yVar.c = i + 8192;
            if (!atomicReference.compareAndSet(obj, yVar)) {
                yVar.f = null;
            }
            return;
        }
    }

    public static final y c() {
        AtomicReference atomicReference = z.e.a();
        l.y yVar3 = z.b;
        final Object andSet = atomicReference.getAndSet(yVar3);
        if (andSet == z.b) {
            return new y();
        }
        Object obj = null;
        if (andSet == null) {
            atomicReference.set(obj);
            return new y();
        }
        atomicReference.set(andSet.f);
        andSet.f = obj;
        andSet.c = 0;
        return andSet;
    }
}
