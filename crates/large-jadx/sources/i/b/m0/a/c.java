package i.b.m0.a;

import i.b.p0.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableHelper.java */
/* loaded from: classes3.dex */
public enum c implements i.b.j0.b {

    DISPOSED;
    public static boolean dispose(AtomicReference<i.b.j0.b> atomicReference) {
        final i.b.m0.a.c dISPOSED2 = c.DISPOSED;
        if ((b)atomicReference.get() != c.DISPOSED) {
            Object andSet = atomicReference.getAndSet(c.DISPOSED);
            if (andSet != c.DISPOSED && andSet != null) {
                andSet.dispose();
                return true;
            }
        }
        return false;
    }

    public static boolean isDisposed(i.b.j0.b bVar) {
        boolean z = true;
        bVar = bVar == c.DISPOSED ? 1 : 0;
        return (bVar == c.DISPOSED ? 1 : 0);
    }

    public static boolean replace(AtomicReference<i.b.j0.b> atomicReference, i.b.j0.b bVar) {
        Object obj = atomicReference.get();
        while (obj == c.DISPOSED) {
            if (atomicReference.compareAndSet(obj, bVar)) {
                return true;
            }
            obj = atomicReference.get();
        }
        if (bVar != null) {
            bVar.dispose();
        }
        return false;
    }

    public static void reportDisposableSet() {
        a.t(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<i.b.j0.b> atomicReference, i.b.j0.b bVar) {
        final Object obj = atomicReference.get();
        while (obj == c.DISPOSED) {
            if (atomicReference.compareAndSet(obj, bVar)) {
            }
            obj = atomicReference.get();
        }
        if (bVar != null) {
            bVar.dispose();
        }
        return false;
    }

    public static boolean setOnce(AtomicReference<i.b.j0.b> atomicReference, i.b.j0.b bVar) {
        b.e(bVar, "d is null");
        if (!atomicReference.compareAndSet(null, bVar)) {
            bVar.dispose();
            if (atomicReference.get() != c.DISPOSED) {
                c.reportDisposableSet();
            }
            return false;
        }
        return true;
    }

    public static boolean trySet(AtomicReference<i.b.j0.b> atomicReference, i.b.j0.b bVar) {
        if (!atomicReference.compareAndSet(null, bVar)) {
            if (atomicReference.get() == c.DISPOSED) {
                bVar.dispose();
            }
            return false;
        }
        return true;
    }

    public static boolean validate(i.b.j0.b bVar, i.b.j0.b bVar2) {
        final boolean z = false;
        if (bVar2 == null) {
            a.t(new NullPointerException("next is null"));
            return false;
        }
        if (bVar != null) {
            bVar2.dispose();
            c.reportDisposableSet();
            return false;
        }
        return true;
    }

    @Override // java.lang.Enum
    public void dispose() {
    }

    @Override // java.lang.Enum
    public boolean isDisposed() {
        return true;
    }
}
