package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import i.b.z;
import j.a.a;

/* loaded from: classes2.dex */
public final class Schedulers_Factory implements Factory<com.google.firebase.inappmessaging.internal.Schedulers> {

    private final a<z> computeSchedulerProvider;
    private final a<z> ioSchedulerProvider;
    private final a<z> mainThreadSchedulerProvider;
    public Schedulers_Factory(a<z> a, a<z> a2, a<z> a3) {
        super();
        this.ioSchedulerProvider = a;
        this.computeSchedulerProvider = a2;
        this.mainThreadSchedulerProvider = a3;
    }

    public static com.google.firebase.inappmessaging.internal.Schedulers_Factory create(a<z> a, a<z> a2, a<z> a3) {
        Schedulers_Factory schedulers_Factory = new Schedulers_Factory(a, a2, a3);
        return schedulers_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.Schedulers newInstance(z z, z z2, z z3) {
        Schedulers schedulers = new Schedulers(z, z2, z3);
        return schedulers;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.Schedulers get() {
        return Schedulers_Factory.newInstance((z)this.ioSchedulerProvider.get(), (z)this.computeSchedulerProvider.get(), (z)this.mainThreadSchedulerProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
