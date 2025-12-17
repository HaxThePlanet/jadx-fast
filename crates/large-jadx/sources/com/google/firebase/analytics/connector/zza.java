package com.google.firebase.analytics.connector;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

/* loaded from: classes2.dex */
public final class zza implements EventHandler {

    public static final com.google.firebase.analytics.connector.zza zza;
    static {
        zza zza = new zza();
        zza.zza = zza;
    }

    @Override // com.google.firebase.events.EventHandler
    public final void handle(Event event) {
        AnalyticsConnectorImpl.zza(event);
    }
}
