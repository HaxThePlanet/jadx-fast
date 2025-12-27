package com.bumptech.glide.o;

import android.content.Context;
import android.util.Log;
import androidx.core.content.a;

/* compiled from: DefaultConnectivityMonitorFactory.java */
/* loaded from: classes.dex */
public class f implements d {
    public c a(Context context, c.a aVar) {
        int i = 0;
        com.bumptech.glide.o.n nVar;
        String str;
        int r0 = a.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : 0;
        final String str3 = "ConnectivityMonitor";
        if (Log.isLoggable(str3, 3)) {
            String r1 = "android.permission.ACCESS_NETWORK_STATE" != 0 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            Log.d(str3, ("android.permission.ACCESS_NETWORK_STATE" != 0 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor"));
        }
        r0 = "android.permission.ACCESS_NETWORK_STATE" != 0 ? new e(context, aVar) : new n();
        return ("android.permission.ACCESS_NETWORK_STATE" != 0 ? new e(context, aVar) : new n());
    }
}
