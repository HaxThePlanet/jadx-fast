package com.google.firebase.database.connection;

import java.util.Map;

/* loaded from: classes2.dex */
public final class c implements com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback {

    public final com.google.firebase.database.connection.PersistentConnectionImpl a;
    public final boolean b;
    public c(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, boolean z2) {
        super();
        this.a = persistentConnectionImpl;
        this.b = z2;
    }

    @Override // com.google.firebase.database.connection.PersistentConnectionImpl$ConnectionRequestCallback
    public final void onResponse(Map map) {
        this.a.f(this.b, map);
    }
}
