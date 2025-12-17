package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzj {

    private static final com.google.firebase.auth.internal.zzj zza;
    static {
        zzj zzj = new zzj();
        zzj.zza = zzj;
    }

    public static com.google.firebase.auth.internal.zzj zzb() {
        return zzj.zza;
    }

    private static void zzf(SharedPreferences sharedPreferences) {
        Object next;
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        Iterator obj2 = sharedPreferences.getAll().keySet().iterator();
        for (String next : obj2) {
            edit.remove(next);
        }
        edit.apply();
    }

    private static final SharedPreferences zzg(Context context, String string2) {
        Object[] arr = new Object[1];
        final int i2 = 0;
        arr[i2] = string2;
        return context.getSharedPreferences(String.format("com.google.firebase.auth.internal.browserSignInSessionStore.%s", arr), i2);
    }

    public final com.google.firebase.auth.internal.zzi zza(Context context, String string2, String string3) {
        r.f(string2);
        r.f(string3);
        SharedPreferences obj11 = zzj.zzg(context, string2);
        int obj12 = 1;
        Object[] arr = new Object[obj12];
        int i = 0;
        arr[i] = string3;
        String format = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.SESSION_ID", arr);
        Object[] arr2 = new Object[obj12];
        arr2[i] = string3;
        String format2 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", arr2);
        Object[] arr3 = new Object[obj12];
        arr3[i] = string3;
        String format3 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.PROVIDER_ID", arr3);
        obj12 = new Object[obj12];
        obj12[i] = string3;
        obj12 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", obj12);
        int obj13 = 0;
        final String string = obj11.getString(format, obj13);
        final String string4 = obj11.getString(format2, obj13);
        final String string5 = obj11.getString(format3, obj13);
        obj11 = obj11.edit();
        obj11.remove(format);
        obj11.remove(format2);
        obj11.remove(format3);
        obj11.remove(obj12);
        obj11.apply();
        synchronized (this) {
            try {
                if (string4 != null) {
                }
                if (string5 != null) {
                }
                super(string, string4, string5, obj11.getString("com.google.firebase.auth.api.gms.config.tenant.id", obj13), obj11.getString(obj12, obj13));
                return obj11;
                return obj13;
                throw context;
            }
        }
    }

    public final String zzc(Context context, String string2, String string3) {
        r.f(string2);
        r.f(string3);
        SharedPreferences obj5 = zzj.zzg(context, string2);
        int obj6 = 1;
        Object[] arr = new Object[obj6];
        final int i = 0;
        arr[i] = string3;
        String format = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", arr);
        int i2 = 0;
        obj6 = new Object[obj6];
        obj6[i] = string3;
        obj6 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", obj6);
        obj5 = obj5.edit();
        obj5.remove(format);
        obj5.remove(obj6);
        obj5.apply();
        synchronized (this) {
            r.f(string2);
            r.f(string3);
            obj5 = zzj.zzg(context, string2);
            obj6 = 1;
            arr = new Object[obj6];
            i = 0;
            arr[i] = string3;
            format = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", arr);
            i2 = 0;
            obj6 = new Object[obj6];
            obj6[i] = string3;
            obj6 = String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", obj6);
            obj5 = obj5.edit();
            obj5.remove(format);
            obj5.remove(obj6);
            obj5.apply();
        }
        try {
            return i2;
            return obj5.getString(obj6, i2);
            throw context;
        }
    }

    public final void zzd(Context context, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        r.f(string2);
        r.f(string3);
        r.f(string4);
        r.f(string8);
        SharedPreferences obj4 = zzj.zzg(context, string2);
        zzj.zzf(obj4);
        obj4 = obj4.edit();
        int obj5 = 1;
        Object[] arr = new Object[obj5];
        final int i = 0;
        arr[i] = string3;
        obj4.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.SESSION_ID", arr), string4);
        Object[] obj7 = new Object[obj5];
        obj7[i] = string3;
        obj4.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", obj7), string5);
        obj7 = new Object[obj5];
        obj7[i] = string3;
        obj4.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.PROVIDER_ID", obj7), string6);
        obj5 = new Object[obj5];
        obj5[i] = string3;
        obj4.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", obj5), string8);
        obj4.putString("com.google.firebase.auth.api.gms.config.tenant.id", string7);
        obj4.apply();
        return;
        synchronized (this) {
            r.f(string2);
            r.f(string3);
            r.f(string4);
            r.f(string8);
            obj4 = zzj.zzg(context, string2);
            zzj.zzf(obj4);
            obj4 = obj4.edit();
            obj5 = 1;
            arr = new Object[obj5];
            i = 0;
            arr[i] = string3;
            obj4.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.SESSION_ID", arr), string4);
            obj7 = new Object[obj5];
            obj7[i] = string3;
            obj4.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", obj7), string5);
            obj7 = new Object[obj5];
            obj7[i] = string3;
            obj4.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.PROVIDER_ID", obj7), string6);
            obj5 = new Object[obj5];
            obj5[i] = string3;
            obj4.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", obj5), string8);
            obj4.putString("com.google.firebase.auth.api.gms.config.tenant.id", string7);
            obj4.apply();
        }
    }

    public final void zze(Context context, String string2, String string3, String string4, String string5) {
        r.f(string2);
        r.f(string3);
        SharedPreferences obj3 = zzj.zzg(context, string2);
        zzj.zzf(obj3);
        obj3 = obj3.edit();
        int obj4 = 1;
        Object[] obj6 = new Object[obj4];
        final int i = 0;
        obj6[i] = string3;
        obj3.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", obj6), "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        obj4 = new Object[obj4];
        obj4[i] = string3;
        obj3.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", obj4), string5);
        obj3.apply();
        return;
        synchronized (this) {
            r.f(string2);
            r.f(string3);
            obj3 = zzj.zzg(context, string2);
            zzj.zzf(obj3);
            obj3 = obj3.edit();
            obj4 = 1;
            obj6 = new Object[obj4];
            i = 0;
            obj6[i] = string3;
            obj3.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.OPERATION", obj6), "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            obj4 = new Object[obj4];
            obj4[i] = string3;
            obj3.putString(String.format("com.google.firebase.auth.internal.EVENT_ID.%s.FIREBASE_APP_NAME", obj4), string5);
            obj3.apply();
        }
    }
}
