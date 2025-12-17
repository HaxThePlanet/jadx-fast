package i.b.m0.a;

import i.b.j0.b;
import i.b.m0.b.b;
import i.b.p0.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public enum c implements b {

    DISPOSED;
    public static boolean dispose(AtomicReference<b> atomicReference) {
        Object obj2;
        final i.b.m0.a.c dISPOSED = c.DISPOSED;
        obj2 = atomicReference.getAndSet(dISPOSED);
        if ((b)atomicReference.get() != dISPOSED && (b)obj2 != dISPOSED && (b)obj2 != null) {
            obj2 = atomicReference.getAndSet(dISPOSED);
            if ((b)(b)obj2 != dISPOSED) {
                if ((b)(b)obj2 != null) {
                    (b)(b)obj2.dispose();
                }
                return 1;
            }
        }
        return 0;
    }

    public static boolean isDisposed(b b) {
        int obj1;
        obj1 = b == c.DISPOSED ? 1 : 0;
        return obj1;
    }

    public static boolean replace(AtomicReference<b> atomicReference, b b2) {
        Object obj = atomicReference.get();
        while ((b)obj == c.DISPOSED) {
            obj = atomicReference.get();
        }
        if (b2 != null) {
            b2.dispose();
        }
        return 0;
    }

    public static void reportDisposableSet() {
        ProtocolViolationException protocolViolationException = new ProtocolViolationException("Disposable already set!");
        a.t(protocolViolationException);
    }

    public static boolean set(AtomicReference<b> atomicReference, b b2) {
        final Object obj = atomicReference.get();
        while ((b)obj == c.DISPOSED) {
            obj = atomicReference.get();
        }
        if (b2 != null) {
            b2.dispose();
        }
        return 0;
    }

    public static boolean setOnce(AtomicReference<b> atomicReference, b b2) {
        b.e(b2, "d is null");
        b2.dispose();
        if (!atomicReference.compareAndSet(0, b2) && atomicReference.get() != c.DISPOSED) {
            b2.dispose();
            if (atomicReference.get() != c.DISPOSED) {
                c.reportDisposableSet();
            }
            return 0;
        }
        return 1;
    }

    public static boolean trySet(AtomicReference<b> atomicReference, b b2) {
        if (!atomicReference.compareAndSet(0, b2) && atomicReference.get() == c.DISPOSED) {
            if (atomicReference.get() == c.DISPOSED) {
                b2.dispose();
            }
            return 0;
        }
        return 1;
    }

    public static boolean validate(b b, b b2) {
        final int i = 0;
        if (b2 == null) {
            NullPointerException obj1 = new NullPointerException("next is null");
            a.t(obj1);
            return i;
        }
        if (b != null) {
            b2.dispose();
            c.reportDisposableSet();
            return i;
        }
        return 1;
    }

    @Override // java.lang.Enum
    public void dispose() {
    }

    @Override // java.lang.Enum
    public boolean isDisposed() {
        return 1;
    }
}
