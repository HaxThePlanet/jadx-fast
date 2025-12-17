package i.b.m0.j;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.p0.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class i {
    public static String a(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("It is not allowed to subscribe with a(n) ");
        stringBuilder.append(string);
        stringBuilder.append(" multiple times. Please create a fresh instance of ");
        stringBuilder.append(string);
        stringBuilder.append(" and subscribe that to the target source instead.");
        return stringBuilder.toString();
    }

    public static void b(Class<?> class) {
        ProtocolViolationException protocolViolationException = new ProtocolViolationException(i.a(class.getName()));
        a.t(protocolViolationException);
    }

    public static boolean c(AtomicReference<b> atomicReference, b b2, Class<?> class3) {
        b.e(b2, "next is null");
        b2.dispose();
        if (!atomicReference.compareAndSet(0, b2) && atomicReference.get() != c.DISPOSED) {
            b2.dispose();
            if (atomicReference.get() != c.DISPOSED) {
                i.b(class3);
            }
            return 0;
        }
        return 1;
    }

    public static boolean d(b b, b b2, Class<?> class3) {
        b.e(b2, "next is null");
        b2.dispose();
        if (b != null && b != c.DISPOSED) {
            b2.dispose();
            if (b != c.DISPOSED) {
                i.b(class3);
            }
            return 0;
        }
        return 1;
    }
}
