package zendesk.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import f.g.c.a;

/* loaded from: classes3.dex */
class NetworkUtils {

    private static final String LOG_TAG = "NetworkUtils";
    static NetworkInfo getActiveNetworkInfo(Context context) {
        Object connectivityManager;
        int str;
        String str2;
        Context obj3;
        connectivityManager = NetworkUtils.getConnectivityManager(context);
        if (connectivityManager != null && context != null) {
            if (context != null) {
                str = 0;
                str2 = "NetworkUtils";
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                    a.g(str2, "Getting active network information", new Object[str]);
                    obj3 = connectivityManager.getActiveNetworkInfo();
                } else {
                    a.k(str2, "Will not return if network is available because we do not have the permission to do so: ACCESS_NETWORK_STATE", new Object[str]);
                    obj3 = 0;
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    static ConnectivityManager getConnectivityManager(Context context) {
        int arr;
        String str;
        arr = 0;
        final String str3 = "NetworkUtils";
        if (context == null) {
            a.k(str3, "Context is null. Cannot get ConnectivityManager", new Object[arr]);
            return null;
        }
        Object obj3 = context.getSystemService("connectivity");
        if ((ConnectivityManager)obj3 == null) {
            a.k(str3, "Connectivity manager is null", new Object[arr]);
        }
        return (ConnectivityManager)obj3;
    }

    static boolean isConnected(Context context) {
        boolean obj0;
        obj0 = NetworkUtils.getActiveNetworkInfo(context);
        if (obj0 != null) {
            obj0 = obj0.isConnected();
        } else {
            obj0 = 0;
        }
        return obj0;
    }

    static boolean isMobile(Context context) {
        int i;
        NetworkInfo obj1;
        obj1 = NetworkUtils.getActiveNetworkInfo(context);
        i = 0;
        if (obj1 != null && obj1.getType() == 0) {
            if (obj1.getType() == 0) {
                i = obj1;
            }
        }
        return i;
    }
}
