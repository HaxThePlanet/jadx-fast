package com.bumptech.glide.o;

import android.content.Context;
import android.util.Log;
import androidx.core.content.a;

/* loaded from: classes.dex */
public class f implements com.bumptech.glide.o.d {
    @Override // com.bumptech.glide.o.d
    public com.bumptech.glide.o.c a(Context context, com.bumptech.glide.o.c.a c$a2) {
        int i;
        Object nVar;
        boolean loggable;
        i = a.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : 0;
        final String str2 = "ConnectivityMonitor";
        if (Log.isLoggable(str2, 3)) {
            loggable = i != 0 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            Log.d(str2, loggable);
        }
        if (i != 0) {
            nVar = new e(context, a2);
        } else {
            nVar = new n();
        }
        return nVar;
    }
}
