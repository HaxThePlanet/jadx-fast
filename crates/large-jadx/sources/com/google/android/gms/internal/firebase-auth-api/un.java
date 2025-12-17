package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import d.e.a;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes2.dex */
public final class un {

    private static final Map<String, com.google.android.gms.internal.firebase-auth-api.sn> a;
    private static final Map<String, WeakReference<com.google.android.gms.internal.firebase-auth-api.tn>> b;
    static {
        a aVar = new a();
        un.a = aVar;
        a aVar2 = new a();
        un.b = aVar2;
    }

    public static String a(String string) {
        Map map = un.a;
        Object obj3 = map.get(string);
        synchronized (map) {
            map = un.a;
            obj3 = map.get(string);
        }
        return String.valueOf(un.h((sn)(sn)obj3.b(), obj3.a(), obj3.b().contains(":"))).concat("emulator/auth/handler");
    }

    public static String b(String string) {
        Object str2;
        int length;
        String str;
        String obj3;
        str2 = un.a;
        obj3 = str2.get(string);
        synchronized (str2) {
            str2 = un.a;
            obj3 = str2.get(string);
        }
        obj3 = String.valueOf(un.h((sn)(sn)obj3.b(), obj3.a(), obj3.b().contains(":")));
        str2 = "";
        if (obj3.length() != 0) {
            obj3 = str2.concat(obj3);
        } else {
            try {
                obj3 = new String(str2);
                obj3 = "https://";
                return String.valueOf(obj3).concat("www.googleapis.com/identitytoolkit/v3/relyingparty");
                throw string;
            }
        }
    }

    public static String c(String string) {
        Object str2;
        int length;
        String str;
        String obj3;
        str2 = un.a;
        obj3 = str2.get(string);
        synchronized (str2) {
            str2 = un.a;
            obj3 = str2.get(string);
        }
        obj3 = String.valueOf(un.h((sn)(sn)obj3.b(), obj3.a(), obj3.b().contains(":")));
        str2 = "";
        if (obj3.length() != 0) {
            obj3 = str2.concat(obj3);
        } else {
            try {
                obj3 = new String(str2);
                obj3 = "https://";
                return String.valueOf(obj3).concat("identitytoolkit.googleapis.com/v2/accounts");
                throw string;
            }
        }
    }

    public static String d(String string) {
        Object str2;
        int length;
        String str;
        String obj3;
        str2 = un.a;
        obj3 = str2.get(string);
        synchronized (str2) {
            str2 = un.a;
            obj3 = str2.get(string);
        }
        obj3 = String.valueOf(un.h((sn)(sn)obj3.b(), obj3.a(), obj3.b().contains(":")));
        str2 = "";
        if (obj3.length() != 0) {
            obj3 = str2.concat(obj3);
        } else {
            try {
                obj3 = new String(str2);
                obj3 = "https://";
                return String.valueOf(obj3).concat("securetoken.googleapis.com/v1");
                throw string;
            }
        }
    }

    public static void e(String string, com.google.android.gms.internal.firebase-auth-api.tn tn2) {
        final Map map = un.b;
        WeakReference weakReference = new WeakReference(tn2);
        map.put(string, weakReference);
        return;
        synchronized (map) {
            map = un.b;
            weakReference = new WeakReference(tn2);
            map.put(string, weakReference);
        }
    }

    public static void f(FirebaseApp firebaseApp, String string2, int i3) {
        boolean obj4;
        String obj2 = firebaseApp.getOptions().getApiKey();
        final Map map = un.a;
        sn snVar = new sn(string2, i3);
        map.put(obj2, snVar);
        final Map obj3 = un.b;
        synchronized (map) {
            obj2 = firebaseApp.getOptions().getApiKey();
            map = un.a;
            snVar = new sn(string2, i3);
            map.put(obj2, snVar);
            obj3 = un.b;
        }
        obj4 = (WeakReference)obj3.get(obj2).get();
        if ((tn)obj4 != null) {
            (tn)obj4.zzi();
        } else {
            map.remove(obj2);
        }
    }

    public static boolean g(FirebaseApp firebaseApp) {
        return un.a.containsKey(firebaseApp.getOptions().getApiKey());
    }

    private static String h(String string, int i2, boolean z3) {
        final String str = "/";
        if (z3) {
            StringBuilder stringBuilder = new StringBuilder(obj4 += 22);
            stringBuilder.append("http://[");
            stringBuilder.append(string);
            stringBuilder.append("]:");
            stringBuilder.append(i2);
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder(obj4 += 20);
        stringBuilder2.append("http://");
        stringBuilder2.append(string);
        stringBuilder2.append(":");
        stringBuilder2.append(i2);
        stringBuilder2.append(str);
        return stringBuilder2.toString();
    }
}
