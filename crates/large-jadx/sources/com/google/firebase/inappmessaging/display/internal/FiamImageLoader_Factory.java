package com.google.firebase.inappmessaging.display.internal;

import com.bumptech.glide.k;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import j.a.a;

/* loaded from: classes2.dex */
public final class FiamImageLoader_Factory implements Factory<com.google.firebase.inappmessaging.display.internal.FiamImageLoader> {

    private final a<k> requestManagerProvider;
    public FiamImageLoader_Factory(a<k> a) {
        super();
        this.requestManagerProvider = a;
    }

    public static com.google.firebase.inappmessaging.display.internal.FiamImageLoader_Factory create(a<k> a) {
        FiamImageLoader_Factory fiamImageLoader_Factory = new FiamImageLoader_Factory(a);
        return fiamImageLoader_Factory;
    }

    public static com.google.firebase.inappmessaging.display.internal.FiamImageLoader newInstance(k k) {
        FiamImageLoader fiamImageLoader = new FiamImageLoader(k);
        return fiamImageLoader;
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public com.google.firebase.inappmessaging.display.internal.FiamImageLoader get() {
        return FiamImageLoader_Factory.newInstance((k)this.requestManagerProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
