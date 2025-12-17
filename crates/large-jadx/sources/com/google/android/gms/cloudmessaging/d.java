package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import d.e.g;
import f.c.a.d.b.f.a;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class d {

    private static int h;
    private static PendingIntent i;
    private static final Executor j;
    private static final Pattern k;
    private final g<String, k<Bundle>> a;
    private final Context b;
    private final com.google.android.gms.cloudmessaging.x c;
    private final ScheduledExecutorService d;
    private Messenger e;
    private Messenger f;
    private com.google.android.gms.cloudmessaging.i g;
    static {
        d.j = d0.a;
        d.k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
    }

    public d(Context context) {
        super();
        g gVar = new g();
        this.a = gVar;
        this.b = context;
        x xVar = new x(context);
        this.c = xVar;
        f fVar = new f(this, Looper.getMainLooper());
        Messenger obj5 = new Messenger(fVar);
        this.e = obj5;
        int i = 1;
        obj5 = new ScheduledThreadPoolExecutor(i);
        obj5.setKeepAliveTime(60, obj3);
        obj5.allowCoreThreadTimeOut(i);
        this.d = obj5;
    }

    static j b(Bundle bundle) {
        if (d.j(bundle)) {
            return m.e(0);
        }
        return m.e(bundle);
    }

    static void d(com.google.android.gms.cloudmessaging.d d, Message message2) {
        Object parcelableExtra;
        String stringExtra;
        int i;
        boolean z2;
        boolean extra;
        boolean equals;
        String substring;
        boolean z;
        int extras;
        int i2;
        Matcher matcher;
        boolean loggable;
        boolean matches;
        int length;
        String length2;
        String str;
        boolean obj7;
        Object obj8;
        parcelableExtra = message2.obj;
        h hVar = new h();
        (Intent)parcelableExtra.setExtrasClassLoader(hVar);
        parcelableExtra = parcelableExtra.getParcelableExtra("google.messenger");
        if (message2 != null && parcelableExtra instanceof Intent != null && parcelableExtra.hasExtra("google.messenger") && parcelableExtra instanceof i) {
            parcelableExtra = message2.obj;
            if (parcelableExtra instanceof Intent != null) {
                hVar = new h();
                (Intent)parcelableExtra.setExtrasClassLoader(hVar);
                if (parcelableExtra.hasExtra("google.messenger")) {
                    parcelableExtra = parcelableExtra.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof i) {
                        d.g = (i)parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        d.f = (Messenger)parcelableExtra;
                    }
                }
                obj8 = message2.obj;
                stringExtra = (Intent)obj8.getAction();
                extras = 3;
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(stringExtra)) {
                    if (Log.isLoggable("Rpc", extras)) {
                        obj7 = String.valueOf(stringExtra);
                        obj8 = "Unexpected response action: ";
                        if (obj7.length() != 0) {
                            obj7 = obj8.concat(obj7);
                        } else {
                            obj7 = new String(obj8);
                        }
                        Log.d("Rpc", obj7);
                    }
                } else {
                    if (obj8.getStringExtra("registration_id") == null) {
                        stringExtra = obj8.getStringExtra("unregistered");
                    }
                    equals = 2;
                    i2 = 1;
                    String stringExtra2 = obj8.getStringExtra("error");
                    if (stringExtra == null && stringExtra2 == null) {
                        stringExtra2 = obj8.getStringExtra("error");
                        if (stringExtra2 == null) {
                            obj7 = String.valueOf(obj8.getExtras());
                            StringBuilder stringBuilder = new StringBuilder(obj8 += 49);
                            stringBuilder.append("Unexpected response, no error or registration id ");
                            stringBuilder.append(obj7);
                            Log.w("Rpc", stringBuilder.toString());
                        }
                        if (Log.isLoggable("Rpc", extras)) {
                            String str14 = "Received InstanceID error ";
                            if (stringExtra2.length() != 0) {
                                loggable = str14.concat(stringExtra2);
                            } else {
                                length2 = new String(str14);
                                loggable = length2;
                            }
                            Log.d("Rpc", loggable);
                        }
                        String[] split = stringExtra2.split("\\|");
                        if (stringExtra2.startsWith("|") && split.length > equals) {
                            split = stringExtra2.split("\\|");
                            if (split.length > equals) {
                                if (!"ID".equals(split[i2])) {
                                } else {
                                    substring = split[extras];
                                    if (substring.startsWith(":")) {
                                        substring = substring.substring(i2);
                                    }
                                }
                                d.i(split[equals], obj8.putExtra("error", substring).getExtras());
                            }
                            obj7 = "Unexpected structured response ";
                            if (stringExtra2.length() != 0) {
                                obj7 = obj7.concat(stringExtra2);
                            } else {
                                obj8 = new String(obj7);
                                obj7 = obj8;
                            }
                            Log.w("Rpc", obj7);
                        }
                        g gVar3 = d.a;
                        i = 0;
                        synchronized (gVar3) {
                            while (i < d.a.size()) {
                                d.i((String)d.a.j(i), obj8.getExtras());
                                i++;
                            }
                        }
                    }
                    matcher = d.k.matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("Rpc", extras)) {
                            obj7 = "Unexpected response string: ";
                            if (stringExtra.length() != 0) {
                                obj7 = obj7.concat(stringExtra);
                            } else {
                                obj8 = new String(obj7);
                                obj7 = obj8;
                            }
                            Log.d("Rpc", obj7);
                        }
                    } else {
                        stringExtra = matcher.group(i2);
                        if (stringExtra != null) {
                            obj8 = obj8.getExtras();
                            obj8.putString("registration_id", matcher.group(equals));
                            d.i(stringExtra, obj8);
                        }
                    }
                }
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    private final j<Bundle> f(Bundle bundle) {
        String str;
        int i;
        String string;
        Object messenger;
        StringBuilder stringBuilder;
        boolean obj8;
        final String str2 = d.g();
        k kVar = new k();
        g gVar = this.a;
        this.a.put(str2, kVar);
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        int i3 = 2;
        synchronized (gVar) {
            str2 = d.g();
            kVar = new k();
            gVar = this.a;
            this.a.put(str2, kVar);
            intent = new Intent();
            intent.setPackage("com.google.android.gms");
            i3 = 2;
        }
        intent.setAction("com.google.iid.TOKEN_REQUEST");
        intent.putExtras(bundle);
        d.h(this.b, intent);
        StringBuilder stringBuilder2 = new StringBuilder(obj8 += 5);
        stringBuilder2.append("|ID|");
        stringBuilder2.append(str2);
        stringBuilder2.append("|");
        intent.putExtra("kid", stringBuilder2.toString());
        if (Log.isLoggable("Rpc", 3)) {
            obj8 = String.valueOf(intent.getExtras());
            stringBuilder = new StringBuilder(length += 8);
            stringBuilder.append("Sending ");
            stringBuilder.append(obj8);
            Log.d("Rpc", stringBuilder.toString());
        }
        intent.putExtra("google.messenger", this.e);
        if (this.f == null) {
            if (this.g != null) {
                obj8 = Message.obtain();
                obj8.obj = intent;
                messenger = this.f;
                if (messenger != null) {
                    messenger.send(obj8);
                } else {
                    this.g.b(obj8);
                }
            } else {
                try {
                    if (this.c.b() == i3) {
                    } else {
                    }
                    this.b.sendBroadcast(intent);
                    this.b.startService(intent);
                    c0 c0Var = new c0(kVar);
                    a0 a0Var = new a0(this, str2, this.d.schedule(c0Var, 30, messenger));
                    kVar.a().addOnCompleteListener(d.j, a0Var);
                    return kVar.a();
                    throw bundle;
                } catch (android.os.RemoteException remote) {
                }
            }
        } else {
        }
    }

    private static String g() {
        final Class<com.google.android.gms.cloudmessaging.d> obj = d.class;
        int i = d.h;
        d.h = i + 1;
        return Integer.toString(i);
        synchronized (obj) {
            obj = d.class;
            i = d.h;
            d.h = i + 1;
            return Integer.toString(i);
        }
    }

    private static void h(Context context, Intent intent2) {
        Object intent;
        int i;
        int i2;
        Object obj4;
        final Class<com.google.android.gms.cloudmessaging.d> obj = d.class;
        synchronized (obj) {
            intent = new Intent();
            intent.setPackage("com.google.example.invalidpackage");
            d.i = a.a(context, 0, intent, a.a);
            intent2.putExtra("app", d.i);
        }
    }

    private final void i(String string, Bundle bundle2) {
        String obj4;
        final g gVar = this.a;
        Object remove = this.a.remove(string);
        synchronized (gVar) {
            String str = "Missing callback for ";
            obj4 = String.valueOf(string);
            if (obj4.length() != 0) {
                obj4 = str.concat(obj4);
            } else {
                try {
                    obj4 = new String(str);
                    Log.w("Rpc", obj4);
                    (k)remove.c(bundle2);
                    throw string;
                }
            }
        }
    }

    private static boolean j(Bundle bundle) {
        String str;
        boolean obj1;
        if (bundle != null && bundle.containsKey("google.messenger")) {
            if (bundle.containsKey("google.messenger")) {
                return 1;
            }
        }
        return 0;
    }

    public j<Bundle> a(Bundle bundle) {
        Object str;
        int i;
        com.google.android.gms.cloudmessaging.y yVar;
        j obj4;
        if (this.c.a() < 12000000) {
            if (this.c.b() != 0) {
                yVar = new y(this, bundle);
                obj4 = f(bundle).continueWithTask(d.j, yVar);
            } else {
                obj4 = new IOException("MISSING_INSTANCEID_SERVICE");
                obj4 = m.d(obj4);
            }
            return obj4;
        }
        return w.b(this.b).d(1, bundle).continueWith(d.j, z.a);
    }

    public final j c(Bundle bundle, j j2) {
        if (!j2.isSuccessful()) {
            return j2;
        }
        if (!d.j((Bundle)j2.getResult())) {
            return j2;
        }
        return f(bundle).onSuccessTask(d.j, b0.a);
    }

    public final void e(String string, ScheduledFuture scheduledFuture2, j j3) {
        final g obj4 = this.a;
        this.a.remove(string);
        scheduledFuture2.cancel(false);
        return;
        synchronized (obj4) {
            obj4 = this.a;
            this.a.remove(string);
            scheduledFuture2.cancel(false);
        }
    }
}
