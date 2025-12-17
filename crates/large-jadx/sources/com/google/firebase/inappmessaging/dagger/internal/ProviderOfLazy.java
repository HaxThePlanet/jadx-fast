package com.google.firebase.inappmessaging.dagger.internal;

import com.google.firebase.inappmessaging.dagger.Lazy;
import j.a.a;

/* loaded from: classes2.dex */
public final class ProviderOfLazy<T>  implements a<Lazy<T>> {

    static final boolean $assertionsDisabled;
    private final a<T> provider;
    static {
    }

    private ProviderOfLazy(a<T> a) {
        super();
        this.provider = a;
    }

    public static <T> a<Lazy<T>> create(a<T> a) {
        ProviderOfLazy providerOfLazy = new ProviderOfLazy((a)Preconditions.checkNotNull(a));
        return providerOfLazy;
    }

    public Lazy<T> get() {
        return DoubleCheck.lazy(this.provider);
    }

    @Override // j.a.a
    public Object get() {
        return get();
    }
}
