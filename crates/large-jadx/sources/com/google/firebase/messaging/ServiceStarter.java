package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public class ServiceStarter {

    public static final int ERROR_UNKNOWN = 500;
    public static final int SUCCESS = -1;
    private static com.google.firebase.messaging.ServiceStarter instance;
    private String firebaseMessagingServiceClassName = null;
    private Boolean hasAccessNetworkStatePermission = null;
    private Boolean hasWakeLockPermission = null;
    private final Queue<Intent> messagingEvents;
    private ServiceStarter() {
        super();
        int i = 0;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.messagingEvents = arrayDeque;
    }

    private int doStartService(Context context, Intent intent2) {
        String packageName;
        boolean loggable;
        int length;
        android.content.ComponentName obj5;
        Object obj6;
        String resolveServiceClassName = resolveServiceClassName(context, intent2);
        final String str = "FirebaseMessaging";
        if (resolveServiceClassName != null && Log.isLoggable(str, 3)) {
            if (Log.isLoggable(str, 3)) {
                String str2 = "Restricting intent to a specific service: ";
                if (resolveServiceClassName.length() != 0) {
                    loggable = str2.concat(resolveServiceClassName);
                } else {
                    length = new String(str2);
                    loggable = length;
                }
                Log.d(str, loggable);
            }
            intent2.setClassName(context.getPackageName(), resolveServiceClassName);
        }
        if (hasWakeLockPermission(context)) {
            obj5 = WakeLockHolder.startWakefulService(context, intent2);
        } else {
            obj5 = context.startService(intent2);
            Log.d(str, "Missing wake lock permission, service start may be delayed");
        }
        if (obj5 == null) {
            Log.e(str, "Error while delivering the message: ServiceIntent not found.");
            return 404;
        }
        return -1;
    }

    static com.google.firebase.messaging.ServiceStarter getInstance() {
        com.google.firebase.messaging.ServiceStarter serviceStarter;
        final Class<com.google.firebase.messaging.ServiceStarter> obj = ServiceStarter.class;
        synchronized (obj) {
            serviceStarter = new ServiceStarter();
            ServiceStarter.instance = serviceStarter;
            return ServiceStarter.instance;
        }
    }

    private String resolveServiceClassName(Context context, Intent intent2) {
        int startsWith;
        boolean equals;
        String obj5;
        Object obj6;
        String firebaseMessagingServiceClassName = this.firebaseMessagingServiceClassName;
        synchronized (this) {
            try {
                return firebaseMessagingServiceClassName;
                obj6 = context.getPackageManager().resolveService(intent2, 0);
                int i = 0;
            }
            obj6 = obj6.serviceInfo;
            if (obj6 == null) {
                Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
                return i;
            } else {
                if (context.getPackageName().equals(obj6.packageName)) {
                    equals = obj6.name;
                    if (equals == null) {
                        try {
                            if (equals.startsWith(".")) {
                            } else {
                            }
                            obj5 = String.valueOf(context.getPackageName());
                            obj6 = String.valueOf(obj6.name);
                            if (obj6.length() != 0) {
                            } else {
                            }
                            obj5 = obj5.concat(obj6);
                            obj6 = new String(obj5);
                            obj5 = obj6;
                            this.firebaseMessagingServiceClassName = obj5;
                            this.firebaseMessagingServiceClassName = obj6.name;
                            return this.firebaseMessagingServiceClassName;
                            obj5 = obj6.packageName;
                            obj6 = obj6.name;
                            StringBuilder stringBuilder = new StringBuilder(i3 += length2);
                            stringBuilder.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                            stringBuilder.append(obj5);
                            stringBuilder.append("/");
                            stringBuilder.append(obj6);
                            Log.e("FirebaseMessaging", stringBuilder.toString());
                            return i;
                            Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
                            return i;
                            throw context;
                        }
                    } else {
                    }
                }
            }
        }
    }

    public static void setForTesting(com.google.firebase.messaging.ServiceStarter serviceStarter) {
        ServiceStarter.instance = serviceStarter;
    }

    Intent getMessagingEvent() {
        return (Intent)this.messagingEvents.poll();
    }

    boolean hasAccessNetworkStatePermission(Context context) {
        Object hasAccessNetworkStatePermission;
        Boolean obj2;
        if (this.hasAccessNetworkStatePermission == null) {
            obj2 = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : 0;
            this.hasAccessNetworkStatePermission = Boolean.valueOf(obj2);
        }
        hasAccessNetworkStatePermission = "FirebaseMessaging";
        if (!this.hasWakeLockPermission.booleanValue() && Log.isLoggable(hasAccessNetworkStatePermission, 3)) {
            hasAccessNetworkStatePermission = "FirebaseMessaging";
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
        hasWakeLockPermission = "FirebaseMessaging";
        if (!this.hasWakeLockPermission.booleanValue() && Log.isLoggable(hasWakeLockPermission, 3)) {
            hasWakeLockPermission = "FirebaseMessaging";
            if (Log.isLoggable(hasWakeLockPermission, 3)) {
                Log.d(hasWakeLockPermission, "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            }
        }
        return this.hasWakeLockPermission.booleanValue();
    }

    public int startMessagingService(Context context, Intent intent2) {
        boolean loggable;
        String str = "FirebaseMessaging";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Starting service");
        }
        this.messagingEvents.offer(intent2);
        Intent obj4 = new Intent("com.google.firebase.MESSAGING_EVENT");
        obj4.setPackage(context.getPackageName());
        return doStartService(context, obj4);
    }
}
