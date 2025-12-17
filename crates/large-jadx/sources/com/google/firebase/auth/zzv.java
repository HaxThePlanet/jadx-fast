package com.google.firebase.auth;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class zzv implements ComponentFactory {

    public static final com.google.firebase.auth.zzv zza;
    static {
        zzv zzv = new zzv();
        zzv.zza = zzv;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return FirebaseAuthRegistrar.lambda$getComponents$0(componentContainer);
    }
}
