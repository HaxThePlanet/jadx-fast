package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build.VERSION;
import android.util.Base64;
import com.google.android.gms.auth.a.d.a;
import com.google.android.gms.auth.a.d.b;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.l.a;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import com.google.android.gms.tasks.j;
import com.google.firebase.auth.PhoneAuthCredential;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class qn {

    private static final a d;
    private final Context a;
    private final ScheduledExecutorService b;
    private final HashMap<String, com.google.android.gms.internal.firebase-auth-api.pn> c;
    static {
        a aVar = new a("FirebaseAuth", /* result */);
        qn.d = aVar;
    }

    qn(Context context) {
        super();
        HashMap hashMap = new HashMap();
        this.c = hashMap;
        r.j(context);
        this.a = (Context)context;
        u8.a();
        this.b = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }

    static a a() {
        return qn.d;
    }

    static String b(String string) {
        Matcher obj1 = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(string);
        if (obj1.find()) {
            return obj1.group();
        }
        return null;
    }

    static HashMap d(com.google.android.gms.internal.firebase-auth-api.qn qn) {
        return qn.c;
    }

    static void e(com.google.android.gms.internal.firebase-auth-api.qn qn, String string2) {
        boolean next;
        PhoneAuthCredential phoneAuthCredential;
        String str;
        Object obj4;
        Object obj3 = qn.c.get(string2);
        if ((pn)obj3 != null && !t1.d(obj3.d) && !t1.d(obj3.e)) {
            if (!t1.d(obj3.d)) {
                if (!t1.d(obj3.e)) {
                    if (obj3.b.isEmpty()) {
                    } else {
                        obj4 = obj3.b.iterator();
                        for (nl next : obj4) {
                            next.o(PhoneAuthCredential.zzc(obj3.d, obj3.e));
                        }
                        obj3.h = true;
                    }
                }
            }
        }
    }

    static void f(com.google.android.gms.internal.firebase-auth-api.qn qn, String string2) {
        qn.o(string2);
    }

    static void g(com.google.android.gms.internal.firebase-auth-api.qn qn, String string2) {
        qn.n(string2);
    }

    private static String m(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        int i3 = 0;
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(stringBuilder.toString().getBytes(yh.a));
        String obj5 = Base64.encodeToString(Arrays.copyOf(instance.digest(), 9), 3).substring(i3, 11);
        StringBuilder stringBuilder2 = new StringBuilder(i7 += length5);
        stringBuilder2.append("Package: ");
        stringBuilder2.append(string);
        stringBuilder2.append(" -- Hash: ");
        stringBuilder2.append(obj5);
        qn.d.a(stringBuilder2.toString(), new Object[i3]);
        return obj5;
    }

    private final void n(String string) {
        boolean z;
        Object[] next;
        boolean next2;
        String str;
        final Object obj4 = this.c.get(string);
        if ((pn)obj4 == null) {
        }
        if (!obj4.h && !t1.d(obj4.d)) {
            if (!t1.d(obj4.d)) {
                qn.d.h("Timed out waiting for SMS.", new Object[0]);
                Iterator iterator = obj4.b.iterator();
                for (nl next : iterator) {
                    next.a(obj4.d);
                }
                obj4.i = true;
            }
        }
    }

    private final void o(String string) {
        Object obj = this.c.get(string);
        if ((pn)obj == null) {
        }
        if (!obj.i) {
            n(string);
        }
        j(string);
    }

    final String c() {
        int i2;
        a aVar;
        Signature[] apkContentsSigners;
        String str;
        int i;
        i2 = 0;
        String packageName = this.a.getPackageName();
        if (Build.VERSION.SDK_INT < 28) {
            try {
                apkContentsSigners = packageInfo.signatures;
                apkContentsSigners = packageInfo2.signingInfo.getApkContentsSigners();
                String str2 = qn.m(packageName, apkContentsSigners[i2].toCharsString());
                if (str2 != null) {
                }
                return str2;
                qn.d.c("Hash generation failed.", new Object[i2]);
                int arr = new Object[arr];
                qn.d.c("Unable to find package to obtain hash.", arr);
                return null;
            }
        } else {
        }
    }

    public final void h(String string) {
        o(string);
    }

    final void i(com.google.android.gms.internal.firebase-auth-api.nl nl, String string2) {
        boolean z;
        boolean z2;
        String str;
        Object obj4;
        obj4 = this.c.get(string2);
        if ((pn)obj4 == null) {
        }
        obj4.b.add(nl);
        if (obj4.g) {
            nl.b(obj4.d);
        }
        if (obj4.h) {
            nl.o(PhoneAuthCredential.zzc(obj4.d, obj4.e));
        }
        if (obj4.i) {
            nl.a(obj4.d);
        }
    }

    final void j(String string) {
        ScheduledFuture done;
        int i;
        Object obj = this.c.get(string);
        if ((pn)obj == null) {
        }
        done = obj.f;
        if (done != null && !done.isDone()) {
            if (!done.isDone()) {
                obj.f.cancel(false);
            }
        }
        obj.b.clear();
        this.c.remove(string);
    }

    final void k(String string, com.google.android.gms.internal.firebase-auth-api.nl nl2, long l3, boolean z4) {
        pn pnVar = new pn(l3, z4, obj8);
        this.c.put(string, pnVar);
        i(nl2, string);
        Object obj5 = this.c.get(string);
        long obj6 = obj5.a;
        int i2 = 0;
        if (Long.compare(obj6, i) <= 0) {
            qn.d.h("Timeout of 0 specified; SmsRetriever will not start.", new Object[i2]);
        }
        ln lnVar = new ln(this, string);
        obj5.f = this.b.schedule(lnVar, obj6, z4);
        if (!obj5.c) {
            qn.d.h("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[i2]);
        }
        obj5 = new on(this, string);
        IntentFilter obj4 = new IntentFilter();
        obj4.addAction("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
        this.a.getApplicationContext().registerReceiver(obj5, obj4);
        obj5 = new mn(this);
        a.a(this.a).b().addOnFailureListener(obj5);
    }

    final boolean l(String string) {
        if (this.c.get(string) != null) {
            return 1;
        }
        return 0;
    }
}
