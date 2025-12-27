package i.b.m0.j;

import i.b.m0.a.c;
import i.b.p0.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EndConsumerHelper.java */
/* loaded from: classes3.dex */
public final class i {
    public static String a(String str) {
        final StringBuilder stringBuilder = new StringBuilder();
        String str2 = "It is not allowed to subscribe with a(n) ";
        String str3 = " multiple times. Please create a fresh instance of ";
        String str4 = " and subscribe that to the target source instead.";
        str5 = str2 + str + str3 + str + str4;
        return str5;
    }

    public static void b(Class<?> cls) {
        a.t(new ProtocolViolationException(i.a(cls.getName())));
    }

    public static boolean c(AtomicReference<i.b.j0.b> atomicReference, i.b.j0.b bVar, Class<?> cls) {
        b.e(bVar, "next is null");
        if (!atomicReference.compareAndSet(null, bVar)) {
            bVar.dispose();
            if (atomicReference.get() != c.DISPOSED) {
                i.b(cls);
            }
            return false;
        }
        return true;
    }

    public static boolean d(i.b.j0.b bVar, i.b.j0.b bVar2, Class<?> cls) {
        b.e(bVar2, "next is null");
        if (bVar != null) {
            bVar2.dispose();
            if (bVar != c.DISPOSED) {
                i.b(cls);
            }
            return false;
        }
        return true;
    }
}
