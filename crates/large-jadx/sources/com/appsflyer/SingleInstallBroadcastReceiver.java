package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.appsflyer.internal.ah;

/* loaded from: classes.dex */
public class SingleInstallBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent2) {
        String string;
        String string2;
        String stringExtra;
        long currentTimeMillis;
        String str;
        int i;
        string = "referrer";
        if (intent2 == null) {
        }
        stringExtra = intent2.getStringExtra(string);
        if (stringExtra != null && ah.AFKeystoreWrapper(context).getString(string, 0) != null) {
            if (ah.AFKeystoreWrapper(context).getString(string, i2) != null) {
                try {
                    ah.AFKeystoreWrapper().AFKeystoreWrapper(context, stringExtra);
                    String str3 = "referrer_timestamp";
                    string2 = AppsFlyerProperties.getInstance().getString(str3);
                    if (string2 != null && Long.compare(currentTimeMillis, i) < 0) {
                    }
                    if (Long.compare(currentTimeMillis, i) < 0) {
                    }
                }
                AFLogger.AFInAppEventType("SingleInstallBroadcastReceiver called");
                ah.AFKeystoreWrapper().valueOf(context, intent2);
                AppsFlyerProperties.getInstance().set(str3, String.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
