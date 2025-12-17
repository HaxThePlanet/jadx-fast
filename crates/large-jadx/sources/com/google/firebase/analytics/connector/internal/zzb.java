package com.google.firebase.analytics.connector.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class zzb implements ComponentFactory {

    public static final com.google.firebase.analytics.connector.internal.zzb zza;
    static {
        zzb zzb = new zzb();
        zzb.zza = zzb;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return AnalyticsConnectorRegistrar.lambda$getComponents$0(componentContainer);
    }
}
