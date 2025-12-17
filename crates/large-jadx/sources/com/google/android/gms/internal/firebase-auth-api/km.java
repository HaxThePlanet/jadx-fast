package com.google.android.gms.internal.firebase-auth-api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public final class km {
    static {
    }

    public static Object a(String string, Type type2) {
        String obj4;
        final String str3 = "Json conversion failed! ";
        wn obj5 = new wn();
        obj5.a(string);
        if (type2 == String.class && !obj5.c()) {
            obj5 = new wn();
            obj5.a(string);
            if (!obj5.c()) {
                String str = "No error message: ";
                obj4 = String.valueOf(string);
                if (obj4.length() != 0) {
                    obj4 = str.concat(obj4);
                } else {
                    obj4 = new String(str);
                }
                obj5 = new zzpz(obj4);
                throw obj5;
            }
            try {
                return obj5.b();
                String zzpz = string.getMessage();
                zzpz = String.valueOf(zzpz);
                int stringBuilder = zzpz.length();
                if (stringBuilder != null) {
                } else {
                }
                zzpz = str2.concat(zzpz);
                zzpz = new String(str2);
                type2 = new zzpz(zzpz, string);
                throw type2;
                if (type2 != Void.class) {
                }
                int i = 0;
                Object instance = (Class)type2.getConstructor(new Class[i]).newInstance(new Object[i]);
                (mm)instance.zza(string);
                return instance;
                zzpz = string.getMessage();
                zzpz = String.valueOf(zzpz);
                stringBuilder = zzpz.length();
                if (stringBuilder != null) {
                } else {
                }
                zzpz = str2.concat(zzpz);
                zzpz = new String(str2);
                type2 = new zzpz(zzpz, string);
                throw type2;
                type2 = String.valueOf(type2);
                String str2 = String.valueOf(type2);
                str2 = str2.length();
                str2 += 38;
                stringBuilder = new StringBuilder(str2);
                str2 = "Instantiation of JsonResponse failed! ";
                stringBuilder.append(str2);
                stringBuilder.append(type2);
                type2 = stringBuilder.toString();
                zzpz = new zzpz(type2, string);
                throw zzpz;
                return null;
            } catch (Exception e) {
            }
        }
    }
}
