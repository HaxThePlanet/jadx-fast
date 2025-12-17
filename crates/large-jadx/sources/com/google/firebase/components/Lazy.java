package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public class Lazy<T>  implements Provider<T> {

    private static final Object UNINITIALIZED;
    private volatile Object instance;
    private volatile Provider<T> provider;
    static {
        Object object = new Object();
        Lazy.UNINITIALIZED = object;
    }

    public Lazy(Provider<T> provider) {
        super();
        this.instance = Lazy.UNINITIALIZED;
        this.provider = provider;
    }

    Lazy(T t) {
        super();
        this.instance = Lazy.UNINITIALIZED;
        this.instance = t;
    }

    public T get() {
        Object instance;
        Object uNINITIALIZED;
        uNINITIALIZED = Lazy.UNINITIALIZED;
        if (this.instance == uNINITIALIZED && this.instance == uNINITIALIZED) {
            synchronized (this) {
                this.instance = this.provider.get();
                this.provider = 0;
            }
        }
        return instance;
    }

    @Override // com.google.firebase.inject.Provider
    boolean isInitialized() {
        int i;
        i = this.instance != Lazy.UNINITIALIZED ? 1 : 0;
        return i;
    }
}
