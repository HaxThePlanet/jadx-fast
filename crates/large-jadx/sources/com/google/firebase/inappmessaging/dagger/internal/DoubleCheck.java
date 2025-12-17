package com.google.firebase.inappmessaging.dagger.internal;

import com.google.firebase.inappmessaging.dagger.Lazy;
import j.a.a;

/* loaded from: classes2.dex */
public final class DoubleCheck<T>  implements a<T>, Lazy<T> {

    static final boolean $assertionsDisabled;
    private static final Object UNINITIALIZED;
    private volatile Object instance;
    private volatile a<T> provider;
    static {
        Object object = new Object();
        DoubleCheck.UNINITIALIZED = object;
    }

    private DoubleCheck(a<T> a) {
        super();
        this.instance = DoubleCheck.UNINITIALIZED;
        this.provider = a;
    }

    public static <P extends a<T>, T> Lazy<T> lazy(P p) {
        if (p instanceof Lazy) {
            return (Lazy)p;
        }
        DoubleCheck doubleCheck = new DoubleCheck((a)Preconditions.checkNotNull(p));
        return doubleCheck;
    }

    public static <P extends a<T>, T> a<T> provider(P p) {
        Preconditions.checkNotNull(p);
        if (p instanceof DoubleCheck) {
            return p;
        }
        DoubleCheck doubleCheck = new DoubleCheck(p);
        return doubleCheck;
    }

    public static Object reentrantCheck(Object object, Object object2) {
        Object uNINITIALIZED;
        int i;
        if (object != DoubleCheck.UNINITIALIZED && !object instanceof MemoizedSentinel) {
            i = !object instanceof MemoizedSentinel ? 1 : 0;
        } else {
        }
        if (i != 0) {
            if (object != object2) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scoped provider was invoked recursively returning different results: ");
            stringBuilder.append(object);
            stringBuilder.append(" & ");
            stringBuilder.append(object2);
            stringBuilder.append(". This is likely due to a circular dependency.");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        return object2;
    }

    public T get() {
        Object instance;
        Object uNINITIALIZED;
        uNINITIALIZED = DoubleCheck.UNINITIALIZED;
        if (this.instance == uNINITIALIZED && this.instance == uNINITIALIZED) {
            synchronized (this) {
                this.instance = DoubleCheck.reentrantCheck(this.instance, this.provider.get());
                this.provider = 0;
            }
        }
        return instance;
    }
}
