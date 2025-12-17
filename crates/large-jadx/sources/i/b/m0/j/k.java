package i.b.m0.j;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class k {

    public static final Throwable a;

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
    static {
        k.a aVar = new k.a();
        k.a = aVar;
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable throwable2) {
        Throwable compositeException;
        Throwable[] arr;
        Object obj = atomicReference.get();
        final int i2 = 0;
        while ((Throwable)obj == k.a) {
            int i = 1;
            if ((Throwable)obj == null) {
            } else {
            }
            arr = new Throwable[2];
            arr[i2] = (Throwable)obj;
            arr[i] = throwable2;
            compositeException = new CompositeException(arr);
            obj = atomicReference.get();
            i2 = 0;
            compositeException = throwable2;
        }
        return i2;
    }

    public static <T> Throwable b(AtomicReference<Throwable> atomicReference) {
        Object obj;
        Object obj2;
        final Throwable th = k.a;
        if ((Throwable)atomicReference.get() != th) {
            obj = obj2;
        }
        return obj;
    }

    public static <E extends Throwable> Exception c(Throwable throwable) {
        if (throwable instanceof Exception == null) {
        } else {
            return (Exception)throwable;
        }
        throw throwable;
    }

    public static String d(long l, TimeUnit timeUnit2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The source did not signal an event for ");
        stringBuilder.append(l);
        stringBuilder.append(" ");
        stringBuilder.append(obj4.toString().toLowerCase());
        stringBuilder.append(" and has been terminated.");
        return stringBuilder.toString();
    }

    public static RuntimeException e(Throwable throwable) {
        if (throwable instanceof Error != null) {
        } else {
            if (throwable instanceof RuntimeException != null) {
                return (RuntimeException)throwable;
            }
            RuntimeException runtimeException = new RuntimeException(throwable);
            return runtimeException;
        }
        throw (Error)throwable;
    }
}
