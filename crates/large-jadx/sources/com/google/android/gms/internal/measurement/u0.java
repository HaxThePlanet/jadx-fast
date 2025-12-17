package com.google.android.gms.internal.measurement;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

/* loaded from: classes2.dex */
public final class u0 {

    public static final int a = 0;
    static {
        int cODENAME;
        int charAt;
        int i;
        cODENAME = Build.VERSION.SDK_INT;
        int i2 = 33554432;
        final int i4 = 0;
        if (cODENAME >= 31) {
        }
        cODENAME = Build.VERSION.CODENAME;
        if (cODENAME >= 30 && cODENAME.length() == 1 && cODENAME.charAt(i4) >= 83 && cODENAME.charAt(i4) <= 90) {
            cODENAME = Build.VERSION.CODENAME;
            if (cODENAME.length() == 1) {
                if (cODENAME.charAt(i4) >= 83) {
                    if (cODENAME.charAt(i4) <= 90) {
                    }
                }
            }
        }
        int i3 = i4;
    }

    public static PendingIntent a(Context context, int i2, Intent intent3, int i4) {
        return PendingIntent.getBroadcast(context, 0, intent3, i4);
    }
}
