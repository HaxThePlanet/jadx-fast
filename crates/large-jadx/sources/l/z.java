package l;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class z {

    private static final int a = 65536;
    private static final l.y b;
    private static final int c;
    private static final AtomicReference<l.y>[] d;
    public static final l.z e;
    static {
        byte[] atomicReference;
        int i;
        z zVar = new z();
        z.e = zVar;
        super(new byte[0], 0, 0, 0, 0);
        z.b = yVar;
        int highestOneBit = Integer.highestOneBit(i2--);
        z.c = highestOneBit;
        AtomicReference[] arr = new AtomicReference[highestOneBit];
        while (i < highestOneBit) {
            atomicReference = new AtomicReference();
            arr[i] = atomicReference;
            i++;
        }
        z.d = arr;
    }

    private final AtomicReference<l.y> a() {
        Thread currentThread = Thread.currentThread();
        n.e(currentThread, "Thread.currentThread()");
        return z.d[(int)i];
    }

    public static final void b(l.y y) {
        l.y yVar;
        int i2;
        boolean compareAndSet;
        int i;
        n.f(y, "segment");
        final int i3 = 0;
        if (y.f == null && y.g == null) {
            i2 = y.g == null ? 1 : i3;
        } else {
        }
        if (i2 == 0) {
        } else {
            if (y.d) {
            }
            AtomicReference atomicReference = z.e.a();
            final Object obj = atomicReference.get();
            if ((y)obj == z.b) {
            }
            i = (y)obj != null ? obj.c : i3;
            if (i >= z.a) {
            }
            y.f = (y)obj;
            y.b = i3;
            y.c = i += 8192;
            if (!atomicReference.compareAndSet(obj, y)) {
                y.f = 0;
            }
        }
        IllegalArgumentException obj5 = new IllegalArgumentException("Failed requirement.".toString());
        throw obj5;
    }

    public static final l.y c() {
        AtomicReference atomicReference = z.e.a();
        l.y yVar3 = z.b;
        final Object andSet = atomicReference.getAndSet(yVar3);
        if ((y)andSet == yVar3) {
            y yVar = new y();
            return yVar;
        }
        int i2 = 0;
        if ((y)andSet == null) {
            atomicReference.set(i2);
            y yVar2 = new y();
            return yVar2;
        }
        atomicReference.set(andSet.f);
        andSet.f = i2;
        andSet.c = 0;
        return (y)andSet;
    }
}
