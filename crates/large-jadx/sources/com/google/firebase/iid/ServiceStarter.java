package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;

/* loaded from: classes2.dex */
public class ServiceStarter {

    public static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    public static final int ERROR_UNKNOWN = 500;
    private static com.google.firebase.iid.ServiceStarter instance;
    private Boolean hasAccessNetworkStatePermission = null;
    private Boolean hasWakeLockPermission = null;
    private ServiceStarter() {
        super();
        final int i = 0;
    }

    public static com.google.firebase.iid.ServiceStarter getInstance() {
        com.google.firebase.iid.ServiceStarter serviceStarter;
        final Class<com.google.firebase.iid.ServiceStarter> obj = ServiceStarter.class;
        synchronized (obj) {
            serviceStarter = new ServiceStarter();
            ServiceStarter.instance = serviceStarter;
            return ServiceStarter.instance;
        }
    }

    public static void setForTesting(com.google.firebase.iid.ServiceStarter serviceStarter) {
        ServiceStarter.instance = serviceStarter;
    }

    boolean hasAccessNetworkStatePermission(Context context) {
        Object hasAccessNetworkStatePermission;
        Boolean obj2;
        if (this.hasAccessNetworkStatePermission == null) {
            obj2 = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : 0;
            this.hasAccessNetworkStatePermission = Boolean.valueOf(obj2);
        }
        hasAccessNetworkStatePermission = "FirebaseInstanceId";
        if (!this.hasWakeLockPermission.booleanValue() && Log.isLoggable(hasAccessNetworkStatePermission, 3)) {
            hasAccessNetworkStatePermission = "FirebaseInstanceId";
            if (Log.isLoggable(hasAccessNetworkStatePermission, 3)) {
                Log.d(hasAccessNetworkStatePermission, "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            }
        }
        return this.hasAccessNetworkStatePermission.booleanValue();
    }

    boolean hasWakeLockPermission(Context context) {
        Object hasWakeLockPermission;
        Boolean obj2;
        if (this.hasWakeLockPermission == null) {
            obj2 = context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0 ? 1 : 0;
            this.hasWakeLockPermission = Boolean.valueOf(obj2);
        }
        hasWakeLockPermission = "FirebaseInstanceId";
        if (!this.hasWakeLockPermission.booleanValue() && Log.isLoggable(hasWakeLockPermission, 3)) {
            hasWakeLockPermission = "FirebaseInstanceId";
            if (Log.isLoggable(hasWakeLockPermission, 3)) {
                Log.d(hasWakeLockPermission, "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            }
        }
        return this.hasWakeLockPermission.booleanValue();
    }
}
