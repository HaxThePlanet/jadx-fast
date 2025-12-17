package com.google.firebase.inappmessaging.dagger.internal;

import j.a.a;

/* loaded from: classes2.dex */
public final class SingleCheck<T>  implements a<T> {

    static final boolean $assertionsDisabled;
    private static final Object UNINITIALIZED;
    private volatile Object instance;
    private volatile a<T> provider;
    static {
        Object object = new Object();
        SingleCheck.UNINITIALIZED = object;
    }

    private SingleCheck(a<T> a) {
        super();
        this.instance = SingleCheck.UNINITIALIZED;
        this.provider = a;
    }

    public static <P extends a<T>, T> a<T> provider(P p) {
        boolean z;
        if (!p instanceof SingleCheck && p instanceof DoubleCheck) {
            if (p instanceof DoubleCheck) {
            }
            SingleCheck singleCheck = new SingleCheck((a)Preconditions.checkNotNull(p));
            return singleCheck;
        }
        return p;
    }

    public T get() {
        Object instance;
        Object uNINITIALIZED;
        if (this.instance == SingleCheck.UNINITIALIZED) {
            a provider = this.provider;
            if (provider == null) {
                instance = this.instance;
            } else {
                this.instance = provider.get();
                this.provider = 0;
            }
        }
        return instance;
    }
}
