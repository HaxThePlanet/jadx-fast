package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes2.dex */
public final class h1 extends com.google.android.gms.common.internal.v0 {

    private com.google.android.gms.common.internal.c a;
    private final int b;
    public h1(com.google.android.gms.common.internal.c c, int i2) {
        super();
        this.a = c;
        this.b = i2;
    }

    @Override // com.google.android.gms.common.internal.v0
    public final void L0(int i, IBinder iBinder2, Bundle bundle3) {
        r.k(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.a.onPostInitHandler(i, iBinder2, bundle3, this.b);
        this.a = 0;
    }

    @Override // com.google.android.gms.common.internal.v0
    public final void g(int i, Bundle bundle2) {
        Exception obj2 = new Exception();
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", obj2);
    }

    @Override // com.google.android.gms.common.internal.v0
    public final void s1(int i, IBinder iBinder2, com.google.android.gms.common.internal.l1 l13) {
        final com.google.android.gms.common.internal.c cVar = this.a;
        r.k(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        r.j(l13);
        c.zzo(cVar, l13);
        L0(i, iBinder2, l13.a);
    }
}
