package com.facebook.e0.x;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.facebook.e0.c;
import com.facebook.e0.v.b;
import com.facebook.g0.a.a;
import com.facebook.g0.a.a.a;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.j;
import com.facebook.o;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0008\u0010\u0008\u001a\u00020\tH\u0007J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0013H\u0007J&\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00042\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001c", d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper;", "", "()V", "RECEIVER_SERVICE_ACTION", "", "RECEIVER_SERVICE_PACKAGE", "RECEIVER_SERVICE_PACKAGE_WAKIZASHI", "TAG", "isServiceAvailable", "", "Ljava/lang/Boolean;", "getVerifiedServiceIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "sendCustomEvents", "Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$ServiceResult;", "applicationId", "appEvents", "", "Lcom/facebook/appevents/AppEvent;", "sendEvents", "eventType", "Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$EventType;", "sendInstallEvent", "EventType", "RemoteServiceConnection", "ServiceResult", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c {

    private static final String a;
    private static Boolean b;
    public static final com.facebook.e0.x.c c;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\u0008\u0006j\u0002\u0008\u0007¨\u0006\u0008", d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$EventType;", "", "eventType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "MOBILE_APP_INSTALL", "CUSTOM_APP_EVENTS", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum a {

        MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
        CUSTOM_APP_EVENTS("MOBILE_APP_INSTALL");

        private final String eventType;
        @Override // java.lang.Enum
        public String toString() {
            return this.eventType;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$RemoteServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "binder", "Landroid/os/IBinder;", "latch", "Ljava/util/concurrent/CountDownLatch;", "getBinder", "onNullBinding", "", "name", "Landroid/content/ComponentName;", "onServiceConnected", "serviceBinder", "onServiceDisconnected", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements ServiceConnection {

        private final CountDownLatch a;
        private IBinder b;
        public b() {
            super();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.a = countDownLatch;
        }

        @Override // android.content.ServiceConnection
        public final IBinder a() {
            this.a.await(5, obj3);
            return this.b;
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            n.f(componentName, "name");
            this.a.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
            n.f(componentName, "name");
            n.f(iBinder2, "serviceBinder");
            this.b = iBinder2;
            this.a.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            n.f(componentName, "name");
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$ServiceResult;", "", "(Ljava/lang/String;I)V", "OPERATION_SUCCESS", "SERVICE_NOT_AVAILABLE", "SERVICE_ERROR", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum c {

        OPERATION_SUCCESS,
        SERVICE_NOT_AVAILABLE,
        SERVICE_ERROR;
    }
    static {
        c cVar = new c();
        c.c = cVar;
        String simpleName = c.class.getSimpleName();
        n.e(simpleName, "RemoteServiceWrapper::class.java.simpleName");
        c.a = simpleName;
    }

    private final Intent a(Context context) {
        String intent;
        Object resolveService;
        Intent intent2;
        int i;
        android.content.pm.ResolveInfo resolveService2;
        Context obj9;
        final String str = "com.facebook.wakizashi";
        intent = "com.facebook.katana";
        resolveService = "ReceiverService";
        final int i2 = 0;
        if (a.d(this)) {
            return i2;
        }
        PackageManager packageManager = context.getPackageManager();
        intent2 = new Intent(resolveService);
        intent2.setPackage(intent);
        i = 0;
        if (packageManager != null && packageManager.resolveService(intent2, i) != null && j.a(context, intent)) {
            intent2 = new Intent(resolveService);
            intent2.setPackage(intent);
            i = 0;
            if (packageManager.resolveService(intent2, i) != null) {
                if (j.a(context, intent)) {
                    return intent2;
                }
            }
            intent = new Intent(resolveService);
            intent.setPackage(str);
            if (packageManager.resolveService(intent, i) != null && j.a(context, str)) {
                if (j.a(context, str)) {
                    return intent;
                }
            }
        }
        return i2;
    }

    public static final boolean b() {
        Boolean valueOf;
        int i;
        int booleanValue;
        com.facebook.e0.x.c cVar;
        booleanValue = 0;
        if (a.d(c.class)) {
            return booleanValue;
        }
        if (c.b == null) {
            i = c.c.a(o.f()) != null ? 1 : booleanValue;
            c.b = Boolean.valueOf(i);
        }
        Boolean bool = c.b;
        if (bool != null) {
            booleanValue = bool.booleanValue();
        }
        return booleanValue;
    }

    public static final com.facebook.e0.x.c.c c(String string, List<c> list2) {
        if (a.d(c.class)) {
            return null;
        }
        n.f(string, "applicationId");
        n.f(list2, "appEvents");
        return c.c.d(c.a.CUSTOM_APP_EVENTS, string, list2);
    }

    private final com.facebook.e0.x.c.c d(com.facebook.e0.x.c.a c$a, String string2, List<c> list3) {
        com.facebook.e0.x.c.c sERVICE_ERROR;
        Object str;
        com.facebook.e0.x.c.c sERVICE_NOT_AVAILABLE;
        Intent bindService;
        ServiceConnection bVar;
        int i;
        Object obj8;
        String obj9;
        Object obj10;
        if (a.d(this)) {
            return null;
        }
        sERVICE_NOT_AVAILABLE = c.c.SERVICE_NOT_AVAILABLE;
        b.b();
        final Context context = o.f();
        bindService = a(context);
        if (bindService != null) {
            bVar = new c.b();
            if (context.bindService(bindService, bVar, 1)) {
                bindService = bVar.a();
                obj8 = b.a(a, string2, list3);
                if (bindService != null && obj8 != null) {
                    obj8 = b.a(a, string2, list3);
                    if (obj8 != null) {
                        a.a.j(bindService).I(obj8);
                        obj10 = new StringBuilder();
                        obj10.append("Successfully sent events to the remote service: ");
                        obj10.append(obj8);
                        b0.d0(c.a, obj10.toString());
                    }
                    sERVICE_NOT_AVAILABLE = obj8;
                }
                context.unbindService(bVar);
                b0.d0(c.a, "Unbound from the remote service");
            } else {
                sERVICE_NOT_AVAILABLE = c.c.SERVICE_ERROR;
            }
        }
        return sERVICE_NOT_AVAILABLE;
    }

    public static final com.facebook.e0.x.c.c e(String string) {
        if (a.d(c.class)) {
            return null;
        }
        n.f(string, "applicationId");
        return c.c.d(c.a.MOBILE_APP_INSTALL, string, p.g());
    }
}
