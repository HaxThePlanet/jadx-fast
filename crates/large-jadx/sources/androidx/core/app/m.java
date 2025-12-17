package androidx.core.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings.Secure;
import android.support.v4.app.a;
import android.support.v4.app.a.a;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
public final class m {

    private static final Object c;
    private static String d;
    private static Set<String> e;
    private static final Object f;
    private static androidx.core.app.m.d g;
    private final Context a;
    private final NotificationManager b;

    private static class c {

        final ComponentName a;
        final IBinder b;
        c(ComponentName componentName, IBinder iBinder2) {
            super();
            this.a = componentName;
            this.b = iBinder2;
        }
    }

    private static class d implements Handler.Callback, ServiceConnection {

        private final Context a;
        private final HandlerThread b;
        private final Handler c;
        private final Map<ComponentName, androidx.core.app.m.d.a> v;
        private Set<String> w;
        d(Context context) {
            super();
            HashMap hashMap = new HashMap();
            this.v = hashMap;
            HashSet hashSet = new HashSet();
            this.w = hashSet;
            this.a = context;
            HandlerThread obj2 = new HandlerThread("NotificationManagerCompat");
            this.b = obj2;
            obj2.start();
            Handler handler = new Handler(obj2.getLooper(), this);
            this.c = handler;
        }

        private boolean a(androidx.core.app.m.d.a m$d$a) {
            int i;
            Object str;
            if (a.b) {
                return 1;
            }
            Intent intent = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL");
            boolean bindService = this.a.bindService(intent.setComponent(a.a), this, 33);
            a.b = bindService;
            if (bindService != null) {
                a.e = 0;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to bind to listener ");
                stringBuilder.append(a.a);
                Log.w("NotifManCompat", stringBuilder.toString());
                this.a.unbindService(this);
            }
            return a.b;
        }

        private void b(androidx.core.app.m.d.a m$d$a) {
            boolean z;
            if (a.b) {
                this.a.unbindService(this);
                a.b = false;
            }
            a.c = 0;
        }

        private void c(androidx.core.app.m.e m$e) {
            Object next;
            ArrayDeque queue;
            j();
            Iterator iterator = this.v.values().iterator();
            for (m.d.a next : iterator) {
                next.d.add(e);
                g(next);
            }
        }

        private void d(ComponentName componentName) {
            final Object obj2 = this.v.get(componentName);
            if ((m.d.a)obj2 != null) {
                g((m.d.a)obj2);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder2) {
            IBinder obj3;
            final Object obj2 = this.v.get(componentName);
            if ((m.d.a)obj2 != null) {
                obj2.c = a.a.j(iBinder2);
                obj2.e = 0;
                g((m.d.a)obj2);
            }
        }

        private void f(ComponentName componentName) {
            final Object obj2 = this.v.get(componentName);
            if ((m.d.a)obj2 != null) {
                b((m.d.a)obj2);
            }
        }

        private void g(androidx.core.app.m.d.a m$d$a) {
            int i;
            boolean loggable2;
            boolean z;
            Object peek;
            String str;
            boolean loggable;
            String str2;
            String str3 = "NotifManCompat";
            i = 3;
            if (Log.isLoggable(str3, i)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Processing component ");
                stringBuilder.append(a.a);
                stringBuilder.append(", ");
                stringBuilder.append(a.d.size());
                stringBuilder.append(" queued tasks");
                Log.d(str3, stringBuilder.toString());
            }
            if (a.d.isEmpty()) {
            }
            if (a(a) && a.c == null) {
                if (a.c == null) {
                }
            }
            i(a);
        }

        private void i(androidx.core.app.m.d.a m$d$a) {
            boolean loggable;
            int str;
            int i8 = 3;
            if (this.c.hasMessages(i8, a.a)) {
            }
            int i6 = 1;
            i += i6;
            a.e = i2;
            final String str7 = "NotifManCompat";
            if (i2 > 6) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Giving up on delivering ");
                stringBuilder.append(a.d.size());
                stringBuilder.append(" tasks to ");
                stringBuilder.append(a.a);
                stringBuilder.append(" after ");
                stringBuilder.append(a.e);
                stringBuilder.append(" retries");
                Log.w(str7, stringBuilder.toString());
                a.d.clear();
            }
            i4 *= 1000;
            if (Log.isLoggable(str7, i8)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Scheduling retry for ");
                stringBuilder2.append(i5);
                stringBuilder2.append(" ms");
                Log.d(str7, stringBuilder2.toString());
            }
            this.c.sendMessageDelayed(this.c.obtainMessage(i8, a.a), (long)i5);
        }

        private void j() {
            Iterator iterator;
            boolean value;
            int permission;
            boolean next;
            boolean loggable;
            String str;
            String componentName;
            String name;
            String packageName;
            Set set = m.d(this.a);
            if (set.equals(this.w)) {
            }
            this.w = set;
            Intent intent = new Intent();
            HashSet hashSet = new HashSet();
            iterator = this.a.getPackageManager().queryIntentServices(intent.setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0).iterator();
            str = "NotifManCompat";
            while (iterator.hasNext()) {
                permission = iterator.next();
                if (!set.contains(serviceInfo2.packageName)) {
                } else {
                }
                android.content.pm.ServiceInfo serviceInfo3 = permission.serviceInfo;
                componentName = new ComponentName(serviceInfo3.packageName, serviceInfo3.name);
                if (serviceInfo.permission != 0) {
                } else {
                }
                hashSet.add(componentName);
                str = "NotifManCompat";
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Permission present on component ");
                stringBuilder2.append(componentName);
                stringBuilder2.append(", not adding listener record.");
                Log.w(str, stringBuilder2.toString());
            }
            Iterator iterator2 = hashSet.iterator();
            next = true;
            while (iterator2.hasNext()) {
                iterator = iterator2.next();
                if (!this.v.containsKey((ComponentName)iterator) && Log.isLoggable(str, next)) {
                }
                next = true;
                if (Log.isLoggable(str, next)) {
                }
                componentName = new m.d.a(iterator);
                this.v.put(iterator, componentName);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Adding listener record for ");
                stringBuilder.append(iterator);
                Log.d(str, stringBuilder.toString());
            }
            Iterator iterator3 = this.v.entrySet().iterator();
            while (iterator3.hasNext()) {
                value = iterator3.next();
                if (!hashSet.contains((Map.Entry)value.getKey()) && Log.isLoggable(str, next)) {
                }
                if (Log.isLoggable(str, next)) {
                }
                b((m.d.a)value.getValue());
                iterator3.remove();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Removing listener record for ");
                stringBuilder3.append(value.getKey());
                Log.d(str, stringBuilder3.toString());
            }
        }

        @Override // android.os.Handler$Callback
        public void h(androidx.core.app.m.e m$e) {
            this.c.obtainMessage(0, e).sendToTarget();
        }

        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message message) {
            int what = message.what;
            final int i = 1;
            if (what != 0 && what != i && what != 2 && what != 3) {
                if (what != i) {
                    if (what != 2) {
                        if (what != 3) {
                            return 0;
                        }
                        d((ComponentName)message.obj);
                        return i;
                    }
                    f((ComponentName)message.obj);
                    return i;
                }
                Object obj4 = message.obj;
                e(obj4.a, obj4.b);
                return i;
            }
            c((m.e)message.obj);
            return i;
        }

        @Override // android.os.Handler$Callback
        public void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
            boolean loggable;
            String str;
            String str2 = "NotifManCompat";
            if (Log.isLoggable(str2, 3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Connected to service ");
                stringBuilder.append(componentName);
                Log.d(str2, stringBuilder.toString());
            }
            m.c cVar = new m.c(componentName, iBinder2);
            this.c.obtainMessage(1, cVar).sendToTarget();
        }

        @Override // android.os.Handler$Callback
        public void onServiceDisconnected(ComponentName componentName) {
            boolean loggable;
            String str;
            String str2 = "NotifManCompat";
            if (Log.isLoggable(str2, 3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Disconnected from service ");
                stringBuilder.append(componentName);
                Log.d(str2, stringBuilder.toString());
            }
            this.c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    private interface e {
        public abstract void a(a a);
    }

    private static class a implements androidx.core.app.m.e {

        final String a;
        final int b;
        final String c;
        final boolean d = false;
        a(String string, int i2, String string3) {
            super();
            this.a = string;
            this.b = i2;
            this.c = string3;
            final int obj1 = 0;
        }

        @Override // androidx.core.app.m$e
        public void a(a a) {
            String str;
            int i;
            String str2;
            if (this.d) {
                a.c0(this.a);
            } else {
                a.c1(this.a, this.b, this.c);
            }
        }

        @Override // androidx.core.app.m$e
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.a);
            stringBuilder.append(", id:");
            stringBuilder.append(this.b);
            stringBuilder.append(", tag:");
            stringBuilder.append(this.c);
            stringBuilder.append(", all:");
            stringBuilder.append(this.d);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private static class b implements androidx.core.app.m.e {

        final String a;
        final int b;
        final String c;
        final Notification d;
        b(String string, int i2, String string3, Notification notification4) {
            super();
            this.a = string;
            this.b = i2;
            this.c = string3;
            this.d = notification4;
        }

        @Override // androidx.core.app.m$e
        public void a(a a) {
            a.a2(this.a, this.b, this.c, this.d);
        }

        @Override // androidx.core.app.m$e
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:");
            stringBuilder.append(this.a);
            stringBuilder.append(", id:");
            stringBuilder.append(this.b);
            stringBuilder.append(", tag:");
            stringBuilder.append(this.c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }
    static {
        Object object = new Object();
        m.c = object;
        HashSet hashSet = new HashSet();
        m.e = hashSet;
        Object object2 = new Object();
        m.f = object2;
    }

    private m(Context context) {
        super();
        this.a = context;
        this.b = (NotificationManager)context.getSystemService("notification");
    }

    public static androidx.core.app.m c(Context context) {
        m mVar = new m(context);
        return mVar;
    }

    public static Set<String> d(Context context) {
        boolean equals;
        HashSet hashSet;
        int length;
        int i;
        ComponentName unflattenFromString;
        String obj6 = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        Object obj = m.c;
        synchronized (obj) {
            if (!obj6.equals(m.d)) {
                equals = obj6.split(":", -1);
                hashSet = new HashSet(equals.length);
                i = 0;
                while (i < equals.length) {
                    unflattenFromString = ComponentName.unflattenFromString(equals[i]);
                    if (unflattenFromString != null) {
                    }
                    i++;
                    hashSet.add(unflattenFromString.getPackageName());
                }
                m.e = hashSet;
                m.d = obj6;
            }
            return m.e;
        }
    }

    private void f(androidx.core.app.m.e m$e) {
        androidx.core.app.m.d dVar;
        Context applicationContext;
        final Object obj = m.f;
        synchronized (obj) {
            dVar = new m.d(this.a.getApplicationContext());
            m.g = dVar;
            m.g.h(e);
        }
    }

    private static boolean g(Notification notification) {
        String str;
        Bundle obj1;
        obj1 = j.a(notification);
        if (obj1 != null && obj1.getBoolean("android.support.useSideChannel")) {
            obj1 = obj1.getBoolean("android.support.useSideChannel") ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public boolean a() {
        int intValue;
        int valueOf2;
        int i;
        String packageName;
        Integer valueOf;
        Method method;
        Object[] arr;
        Class<Integer> obj2;
        Class<String> obj;
        int i2;
        int i3;
        intValue = Build.VERSION.SDK_INT;
        if (intValue >= 24) {
            return this.b.areNotificationsEnabled();
        }
        i = 1;
        if (intValue >= 19) {
            Class forName = Class.forName(AppOpsManager.class.getName());
            int i5 = 3;
            Class[] arr2 = new Class[i5];
            Class tYPE = Integer.TYPE;
            i2 = 0;
            arr2[i2] = tYPE;
            arr2[i] = tYPE;
            i3 = 2;
            arr2[i3] = String.class;
            arr = new Object[i5];
            arr[i2] = Integer.valueOf((Integer)forName.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class).intValue());
            arr[i] = Integer.valueOf(applicationInfo.uid);
            arr[i3] = this.a.getApplicationContext().getPackageName();
            if ((Integer)forName.getMethod("checkOpNoThrow", arr2).invoke((AppOpsManager)this.a.getSystemService("appops"), arr).intValue() == 0) {
            } else {
                i = i2;
            }
        }
        return i;
    }

    public void b(String string, int i2) {
        int sDK_INT;
        int packageName;
        this.b.cancel(string, i2);
        if (Build.VERSION.SDK_INT <= 19) {
            sDK_INT = new m.a(this.a.getPackageName(), i2, string);
            f(sDK_INT);
        }
    }

    public void e(String string, int i2, Notification notification3) {
        Object bVar;
        String packageName;
        Object obj5;
        if (m.g(notification3)) {
            bVar = new m.b(this.a.getPackageName(), i2, string, notification3);
            f(bVar);
            this.b.cancel(string, i2);
        } else {
            this.b.notify(string, i2, notification3);
        }
    }
}
