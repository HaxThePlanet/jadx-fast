package i.b.m0.i;

import i.b.m0.b.b;
import i.b.m0.j.d;
import i.b.p0.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.c;

/* loaded from: classes3.dex */
public enum g implements c {

    CANCELLED;
    public static boolean cancel(AtomicReference<c> atomicReference) {
        Object obj2;
        final i.b.m0.i.g cANCELLED = g.CANCELLED;
        obj2 = atomicReference.getAndSet(cANCELLED);
        if ((c)atomicReference.get() != cANCELLED && (c)obj2 != cANCELLED && (c)obj2 != null) {
            obj2 = atomicReference.getAndSet(cANCELLED);
            if ((c)(c)obj2 != cANCELLED) {
                if ((c)(c)obj2 != null) {
                    (c)(c)obj2.cancel();
                }
                return 1;
            }
        }
        return 0;
    }

    public static void deferredRequest(AtomicReference<c> atomicReference, AtomicLong atomicLong2, long l3) {
        Object andSet;
        Object obj2;
        int obj3;
        long obj4;
        andSet = atomicReference.get();
        if ((c)andSet != null) {
            (c)andSet.request(l3);
        } else {
            d.a(atomicLong2, l3);
            obj2 = atomicReference.get();
            obj4 = 0;
            andSet = atomicLong2.getAndSet(obj4);
            if (g.validate(l3) && (c)obj2 != null && Long.compare(andSet, obj4) != 0) {
                d.a(atomicLong2, l3);
                obj2 = atomicReference.get();
                if ((c)(c)obj2 != null) {
                    obj4 = 0;
                    andSet = atomicLong2.getAndSet(obj4);
                    if (Long.compare(andSet, obj4) != 0) {
                        (c)(c)obj2.request(andSet);
                    }
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<c> atomicReference, AtomicLong atomicLong2, c c3) {
        int i = 0;
        long obj2 = atomicLong2.getAndSet(i);
        if (g.setOnce(atomicReference, c3) && Long.compare(obj2, i) != 0) {
            i = 0;
            obj2 = atomicLong2.getAndSet(i);
            if (Long.compare(obj2, i) != 0) {
                c3.request(obj2);
            }
            return 1;
        }
        return 0;
    }

    public static boolean replace(AtomicReference<c> atomicReference, c c2) {
        Object obj = atomicReference.get();
        while ((c)obj == g.CANCELLED) {
            obj = atomicReference.get();
        }
        if (c2 != null) {
            c2.cancel();
        }
        return 0;
    }

    public static void reportMoreProduced(long l) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("More produced than requested: ");
        stringBuilder.append(l);
        ProtocolViolationException protocolViolationException = new ProtocolViolationException(stringBuilder.toString());
        a.t(protocolViolationException);
    }

    public static void reportSubscriptionSet() {
        ProtocolViolationException protocolViolationException = new ProtocolViolationException("Subscription already set!");
        a.t(protocolViolationException);
    }

    public static boolean set(AtomicReference<c> atomicReference, c c2) {
        final Object obj = atomicReference.get();
        while ((c)obj == g.CANCELLED) {
            obj = atomicReference.get();
        }
        if (c2 != null) {
            c2.cancel();
        }
        return 0;
    }

    public static boolean setOnce(AtomicReference<c> atomicReference, c c2) {
        b.e(c2, "s is null");
        c2.cancel();
        if (!atomicReference.compareAndSet(0, c2) && atomicReference.get() != g.CANCELLED) {
            c2.cancel();
            if (atomicReference.get() != g.CANCELLED) {
                g.reportSubscriptionSet();
            }
            return 0;
        }
        return 1;
    }

    public static boolean setOnce(AtomicReference<c> atomicReference, c c2, long l3) {
        if (g.setOnce(atomicReference, c2)) {
            c2.request(l3);
            return 1;
        }
        return 0;
    }

    public static boolean validate(long l) {
        if (Long.compare(l, i) <= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("n > 0 required but it was ");
            stringBuilder.append(l);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            a.t(illegalArgumentException);
            return 0;
        }
        return 1;
    }

    public static boolean validate(c c, c c2) {
        final int i = 0;
        if (c2 == null) {
            NullPointerException obj1 = new NullPointerException("next is null");
            a.t(obj1);
            return i;
        }
        if (c != null) {
            c2.cancel();
            g.reportSubscriptionSet();
            return i;
        }
        return 1;
    }

    @Override // java.lang.Enum
    public void cancel() {
    }

    @Override // java.lang.Enum
    public void request(long l) {
    }
}
