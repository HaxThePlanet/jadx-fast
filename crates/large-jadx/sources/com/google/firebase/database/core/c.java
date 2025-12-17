package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionTokenProvider;
import com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class c implements ConnectionTokenProvider {

    public final com.google.firebase.database.core.TokenProvider a;
    public final ScheduledExecutorService b;
    public c(com.google.firebase.database.core.TokenProvider tokenProvider, ScheduledExecutorService scheduledExecutorService2) {
        super();
        this.a = tokenProvider;
        this.b = scheduledExecutorService2;
    }

    @Override // com.google.firebase.database.connection.ConnectionTokenProvider
    public final void getToken(boolean z, ConnectionTokenProvider.GetTokenCallback connectionTokenProvider$GetTokenCallback2) {
        Context.a(this.a, this.b, z, getTokenCallback2);
    }
}
