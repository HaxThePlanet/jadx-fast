package i.b.m0.i;

import i.b.m0.b.b;
import i.b.m0.j.d;
import i.b.p0.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.c;

/* compiled from: SubscriptionHelper.java */
/* loaded from: classes3.dex */
public enum g implements c {

    CANCELLED;
    public static boolean cancel(AtomicReference<c> atomicReference) {
        final i.b.m0.i.g cANCELLED2 = g.CANCELLED;
        if ((c)atomicReference.get() != g.CANCELLED) {
            Object andSet = atomicReference.getAndSet(g.CANCELLED);
            if (andSet != g.CANCELLED && andSet != null) {
                andSet.cancel();
                return true;
            }
        }
        return false;
    }

    public static void deferredRequest(AtomicReference<c> atomicReference, AtomicLong atomicLong, long j) {
        Object obj = atomicReference.get();
        if (obj != null) {
            obj.request(j);
        } else {
            if (g.validate(j)) {
                d.a(atomicLong, j);
                Object obj2 = atomicReference.get();
                if (obj2 != null) {
                    long l = 0L;
                    long andSet = atomicLong.getAndSet(l);
                    if (andSet != l) {
                        obj2.request(andSet);
                    }
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<c> atomicReference, AtomicLong atomicLong, c cVar) {
        if (g.setOnce(atomicReference, cVar)) {
            long l = 0L;
            long andSet = atomicLong.getAndSet(l);
            if (andSet != l) {
                cVar.request(andSet);
            }
            return true;
        }
        return false;
    }

    public static boolean replace(AtomicReference<c> atomicReference, c cVar) {
        Object obj = atomicReference.get();
        while (obj == g.CANCELLED) {
            if (atomicReference.compareAndSet(obj, cVar)) {
                return true;
            }
            obj = atomicReference.get();
        }
        if (cVar != null) {
            cVar.cancel();
        }
        return false;
    }

    public static void reportMoreProduced(long j) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "More produced than requested: ";
        j = str + j;
        a.t(new ProtocolViolationException(j));
    }

    public static void reportSubscriptionSet() {
        a.t(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<c> atomicReference, c cVar) {
        final Object obj = atomicReference.get();
        while (obj == g.CANCELLED) {
            if (atomicReference.compareAndSet(obj, cVar)) {
            }
            obj = atomicReference.get();
        }
        if (cVar != null) {
            cVar.cancel();
        }
        return false;
    }

    public static boolean setOnce(AtomicReference<c> atomicReference, c cVar) {
        b.e(cVar, "s is null");
        if (!atomicReference.compareAndSet(null, cVar)) {
            cVar.cancel();
            if (atomicReference.get() != g.CANCELLED) {
                g.reportSubscriptionSet();
            }
            return false;
        }
        return true;
    }

    public static boolean validate(c cVar, c cVar2) {
        final boolean z = false;
        if (cVar2 == null) {
            a.t(new NullPointerException("next is null"));
            return false;
        }
        if (cVar != null) {
            cVar2.cancel();
            g.reportSubscriptionSet();
            return false;
        }
        return true;
    }

    public static boolean validate(long j) {
        if (j <= 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "n > 0 required but it was ";
            j = str + j;
            a.t(new IllegalArgumentException(j));
            return false;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<c> atomicReference, c cVar, long j) {
        if (g.setOnce(atomicReference, cVar)) {
            cVar.request(j);
            return true;
        }
        return false;
    }

    @Override // java.lang.Enum
    public void cancel() {
    }

    @Override // java.lang.Enum
    public void request(long j) {
    }
}
