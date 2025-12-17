package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.appsflyer.AFLogger;

/* loaded from: classes.dex */
final class y {

    static final class a {

        final String AFInAppEventType;
        final String AFKeystoreWrapper;
        final String values;
        a(String string, String string2, String string3) {
            super();
            this.values = string;
            this.AFInAppEventType = string2;
            this.AFKeystoreWrapper = string3;
        }
    }

    static final class e {

        static final com.appsflyer.internal.y values;
        static {
            y yVar = new y();
            y.e.values = yVar;
        }
    }
    static com.appsflyer.internal.y.a AFKeystoreWrapper(Context context) {
        String str;
        Object obj;
        String networkOperatorName;
        Object obj2;
        Object activeNetworkInfo;
        String simOperatorName;
        boolean empty;
        boolean allNetworks;
        int sDK_INT;
        int i;
        int i2;
        NetworkInfo networkInfo;
        boolean z;
        Object obj3;
        Object obj12;
        str = "unknown";
        int i3 = 0;
        activeNetworkInfo = context.getSystemService("connectivity");
        if ((ConnectivityManager)activeNetworkInfo != null) {
            i2 = 1;
            if (21 <= Build.VERSION.SDK_INT) {
                allNetworks = (ConnectivityManager)activeNetworkInfo.getAllNetworks();
                try {
                    while (i < allNetworks.length) {
                        networkInfo = activeNetworkInfo.getNetworkInfo(allNetworks[i]);
                        if (y.AFKeystoreWrapper(networkInfo)) {
                            break;
                        } else {
                        }
                        i++;
                    }
                    networkInfo = activeNetworkInfo.getNetworkInfo(allNetworks[i]);
                    i++;
                } catch (Throwable th) {
                }
            } else {
            }
        }
        try {
            obj12 = context.getSystemService("phone");
            simOperatorName = (TelephonyManager)obj12.getSimOperatorName();
            networkOperatorName = obj12.getNetworkOperatorName();
            if (networkOperatorName != null) {
            } else {
            }
            if (networkOperatorName.isEmpty() && 2 == obj12.getPhoneType()) {
            }
            if (2 == obj12.getPhoneType()) {
            }
            networkOperatorName = "CDMA";
            obj3 = obj2;
            obj2 = obj;
            obj = obj3;
            obj2 = obj;
            AFLogger.AFKeystoreWrapper("Exception while collecting network info. ", context);
            obj3 = obj2;
            obj2 = obj;
            obj = obj3;
            obj12 = new y.a(str, networkOperatorName, simOperatorName);
            return obj12;
        } catch (Throwable th) {
        }
    }

    private static boolean AFKeystoreWrapper(NetworkInfo networkInfo) {
        boolean obj0;
        if (networkInfo && networkInfo.isConnectedOrConnecting()) {
            if (networkInfo.isConnectedOrConnecting()) {
                return 1;
            }
        }
        return 0;
    }
}
