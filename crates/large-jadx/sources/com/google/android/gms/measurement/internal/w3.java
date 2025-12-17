package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes2.dex */
public final class w3 extends com.google.android.gms.measurement.internal.r9 {
    public w3(com.google.android.gms.measurement.internal.ba ba) {
        super(ba);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final boolean l() {
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final boolean m() {
        Object systemService;
        int activeNetworkInfo;
        i();
        systemService = this.a.f().getSystemService("connectivity");
        activeNetworkInfo = 0;
        if ((ConnectivityManager)systemService != null) {
            activeNetworkInfo = (ConnectivityManager)systemService.getActiveNetworkInfo();
        }
        if (activeNetworkInfo != 0 && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.isConnected()) {
                return 1;
            }
        }
        return 0;
    }
}
