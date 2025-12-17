package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.appsflyer.internal.ah;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MultipleInstallBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent2) {
        String string;
        Intent intent;
        String stringExtra;
        Object th;
        int instance;
        StringBuilder stringBuilder;
        String packageName;
        final String str = "error in BroadcastReceiver ";
        string = "referrer";
        if (intent2 == null) {
        }
        stringExtra = intent2.getStringExtra(string);
        if (stringExtra != null && ah.AFKeystoreWrapper(context).getString(string, 0) != null) {
            if (ah.AFKeystoreWrapper(context).getString(string, i) != null) {
                ah.AFKeystoreWrapper().AFKeystoreWrapper(context, stringExtra);
            }
        }
        AFLogger.AFInAppEventType("MultipleInstallBroadcastReceiver called");
        ah.AFKeystoreWrapper().valueOf(context, intent2);
        String str3 = "com.android.vending.INSTALL_REFERRER";
        intent = new Intent(str3);
        Iterator iterator = context.getPackageManager().queryBroadcastReceivers(intent, 0).iterator();
        try {
            intent = iterator.next();
        } catch (Throwable th) {
        }
    }
}
