package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class w5 {

    public static final Uri a;
    public static final Uri b;
    public static final Pattern c;
    public static final Pattern d;
    private static final AtomicBoolean e;
    static HashMap<String, String> f;
    static final HashMap<String, Boolean> g;
    static final HashMap<String, Integer> h;
    static final HashMap<String, Long> i;
    static final HashMap<String, Float> j;
    private static Object k;
    private static boolean l;
    static final String[] m;
    static {
        w5.a = Uri.parse("content://com.google.android.gsf.gservices");
        w5.b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
        final int i2 = 2;
        w5.c = Pattern.compile("^(1|true|t|on|yes|y)$", i2);
        w5.d = Pattern.compile("^(0|false|f|off|no|n)$", i2);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        w5.e = atomicBoolean;
        HashMap hashMap = new HashMap();
        w5.g = hashMap;
        HashMap hashMap2 = new HashMap();
        w5.h = hashMap2;
        HashMap hashMap3 = new HashMap();
        w5.i = hashMap3;
        HashMap hashMap4 = new HashMap();
        w5.j = hashMap4;
        w5.m = new String[0];
    }

    public static String a(ContentResolver contentResolver, String string2, String string3) {
        Uri andSet;
        int equals;
        int i;
        com.google.android.gms.internal.measurement.v5 v5Var;
        String obj13;
        obj13 = w5.class;
        equals = 1;
        final int i2 = 0;
        i = 0;
        synchronized (obj13) {
            w5.e.set(i2);
            HashMap hashMap = new HashMap();
            w5.f = hashMap;
            Object object = new Object();
            w5.k = object;
            w5.l = i2;
            v5Var = new v5(i);
            contentResolver.registerContentObserver(w5.a, equals, v5Var);
            Object obj = w5.k;
            if (w5.f.containsKey(string2)) {
                Object obj11 = w5.f.get(string2);
                if ((String)obj11 == null) {
                } else {
                    i = obj11;
                }
                return i;
            }
            int length = strArr.length;
            final String[] strArr2 = new String[equals];
            strArr2[i2] = string2;
            obj11 = contentResolver.query(w5.a, 0, 0, strArr2, 0);
            if (obj11 == null) {
            }
            if (!obj11.moveToFirst()) {
                w5.c(obj, string2, i);
                obj11.close();
                return i;
            }
            obj13 = obj11.getString(equals);
            if (obj13 != null && obj13.equals(i)) {
                if (obj13.equals(i)) {
                    obj13 = i;
                }
            }
            w5.c(obj, string2, obj13);
            if (obj13 == null) {
            } else {
                i = obj13;
            }
            obj11.close();
            return i;
        }
        return i;
    }

    static AtomicBoolean b() {
        return w5.e;
    }

    private static void c(Object object, String string2, String string3) {
        Object obj2;
        final Class<com.google.android.gms.internal.measurement.w5> obj = w5.class;
        synchronized (obj) {
            w5.f.put(string2, string3);
        }
    }
}
