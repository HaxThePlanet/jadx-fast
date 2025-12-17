package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final ConnectionTokenProvider.GetTokenCallback a;
    public final String b;
    public b(ConnectionTokenProvider.GetTokenCallback connectionTokenProvider$GetTokenCallback, String string2) {
        super();
        this.a = getTokenCallback;
        this.b = string2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context.1.a(this.a, this.b);
    }
}
