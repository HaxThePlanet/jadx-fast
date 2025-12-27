package i.b.m0.j;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ExceptionHelper.java */
/* loaded from: classes3.dex */
public final class k {

    public static final Throwable a = new k$a();

    static final class a extends Throwable {

        private static final long serialVersionUID = -4649703670690200604L;
        a() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        CompositeException compositeException;
        Object obj = atomicReference.get();
        final int i2 = 0;
        while (obj == k.a) {
            int i = 1;
            if (atomicReference.compareAndSet(obj, compositeException)) {
                return true;
            }
        }
        return false;
    }

    public static <T> Throwable b(AtomicReference<Throwable> atomicReference) {
        Object atomicReference2;
        final Throwable th = k.a;
        if ((Throwable)atomicReference.get() != k.a) {
        }
        return atomicReference2;
    }

    public static <E extends Throwable> Exception c(Throwable th) {
        if (!(th instanceof Exception)) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        } else {
            return th;
        }
    }

    public static String d(long j, TimeUnit timeUnit) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "The source did not signal an event for ";
        String str2 = " ";
        String str3 = timeUnit.toString().toLowerCase();
        String str4 = " and has been terminated.";
        str5 = str + j + str2 + str3 + str4;
        return str5;
    }

    public static RuntimeException e(Throwable th) {
        if (th instanceof Error) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        } else {
            if (th instanceof RuntimeException) {
                return th;
            }
            return new RuntimeException(th);
        }
    }
}
