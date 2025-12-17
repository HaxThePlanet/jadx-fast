package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.internal.u;

/* loaded from: classes2.dex */
public final class RevocationBoundService extends Service {
    public IBinder onBind(Intent intent) {
        boolean equals;
        boolean loggable;
        String length;
        String obj4;
        String str3 = "RevocationService";
        if (!"com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction())) {
            if ("com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(intent.getAction())) {
            } else {
                obj4 = String.valueOf(intent.getAction());
                String str = "Unknown action sent to RevocationBoundService: ";
                if (obj4.length() != 0) {
                    obj4 = str.concat(obj4);
                } else {
                    obj4 = new String(str);
                }
            }
            Log.w(str3, obj4);
            return null;
        }
        if (Log.isLoggable(str3, 2)) {
            obj4 = String.valueOf(intent.getAction());
            loggable = "RevocationBoundService handling ";
            if (obj4.length() != 0) {
                obj4 = loggable.concat(obj4);
            } else {
                obj4 = new String(loggable);
            }
            Log.v(str3, obj4);
        }
        obj4 = new u(this);
        return obj4;
    }
}
