package com.iterable.iterableapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import com.iterable.iterableapi.k1.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class z0 {

    static com.iterable.iterableapi.z0.a a;

    static class a {
        public long a() {
            return System.currentTimeMillis();
        }

        String b(Context context) {
            int i2;
            Object forName;
            Object[] arr2;
            int arr3;
            Class[] arr;
            Class<Context> obj;
            int i;
            Object obj9;
            final String str = "IterableUtil";
            forName = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            arr3 = 1;
            arr = new Class[arr3];
            i = 0;
            arr[i] = Context.class;
            arr2 = new Object[arr3];
            arr2[i] = context;
            obj9 = forName.getMethod("getAdvertisingIdInfo", arr).invoke(0, arr2);
            if (forName != null && obj9 != null) {
                arr3 = 1;
                arr = new Class[arr3];
                i = 0;
                arr[i] = Context.class;
                arr2 = new Object[arr3];
                arr2[i] = context;
                obj9 = forName.getMethod("getAdvertisingIdInfo", arr).invoke(i2, arr2);
                if (obj9 != null) {
                    i2 = obj9;
                }
            }
            return i2;
        }

        String c(Context context) {
            try {
                return obj3.versionName;
                j0.d("IterableUtil", "Error while retrieving app version", context);
                context = null;
                return context;
            }
        }

        String d(Context context) {
            try {
                return Integer.toString(obj3.versionCode);
                j0.d("IterableUtil", "Error while retrieving app version code", context);
                context = null;
                return context;
            }
        }

        File e(File file, String string2) {
            File file2 = new File(file, string2);
            if (file2.exists() == null) {
                file2.mkdirs();
            }
            return file2;
        }

        File f(Context context) {
            File file = new File(context.getFilesDir(), "com.iterable.sdk");
            if (file.exists() == null) {
                file.mkdirs();
            }
            return file;
        }

        File g(Context context) {
            File file = new File(context.getCacheDir(), "com.iterable.sdk");
            if (file.exists() == null) {
                file.mkdirs();
            }
            return file;
        }

        boolean h(long l) {
            int obj3;
            obj3 = Long.compare(l, i) >= 0 ? 1 : 0;
            return obj3;
        }

        String i(File file) {
            java.io.Closeable closeable4;
            java.io.Closeable closeable;
            java.io.Closeable closeable2;
            Throwable th;
            String line;
            final int i = 0;
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            try {
                line = bufferedReader.readLine();
                while (line != null) {
                    stringBuilder.append(line);
                    line = bufferedReader.readLine();
                }
                stringBuilder.append(line);
                b.a(fileInputStream);
                b.a(inputStreamReader);
                b.a(bufferedReader);
                return stringBuilder.toString();
                closeable2 = closeable3;
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Error while reading file: ");
            file = file.toString();
            stringBuilder2.append(file);
            file = stringBuilder2.toString();
            j0.d("IterableUtil", file, th);
            b.a(closeable4);
            b.a(closeable);
            b.a(closeable2);
            return closeable3;
        }

        Long j(JSONObject jSONObject, String string2) {
            long obj3 = jSONObject.getLong(string2);
            if (h(obj3)) {
                try {
                    return Long.valueOf(obj3);
                    return null;
                }
            }
        }

        void k(SharedPreferences sharedPreferences, String string2, JSONObject jSONObject3, long l4) {
            this.l(sharedPreferences, string2, jSONObject3.toString(), l4);
        }

        void l(SharedPreferences sharedPreferences, String string2, String string3, long l4) {
            final SharedPreferences.Editor obj3 = sharedPreferences.edit();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            final String str = "_object";
            stringBuilder.append(str);
            obj3.putString(stringBuilder.toString(), string3);
            StringBuilder obj5 = new StringBuilder();
            obj5.append(string2);
            obj5.append("_expiration");
            obj3.putLong(obj5.toString(), l += l4);
            obj3.apply();
        }

        boolean m(File file, String string2) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.write(string2);
                outputStreamWriter.close();
                return 1;
                StringBuilder str = new StringBuilder();
                str.append("Error while writing to file: ");
                file = file.toString();
                str.append(file);
                file = str.toString();
                str = "IterableUtil";
                j0.d(str, file, string2);
                file = null;
                return file;
            }
        }
    }
    static {
        z0.a aVar = new z0.a();
        z0.a = aVar;
    }

    static long a() {
        return z0.a.a();
    }

    static String b(Context context) {
        return z0.a.b(context);
    }

    static String c(Context context) {
        return z0.a.c(context);
    }

    static String d(Context context) {
        return z0.a.d(context);
    }

    static File e(File file, String string2) {
        return z0.a.e(file, string2);
    }

    static File f(Context context) {
        return z0.a.f(context);
    }

    static File g(Context context) {
        return z0.a.g(context);
    }

    static boolean h(String string) {
        int i;
        boolean equals;
        int i2 = 0;
        String obj6 = string.split("://")[i2];
        final int i3 = 1;
        if (obj6.equals("https")) {
            return i3;
        }
        String[] strArr = qVar.j;
        i = i2;
        while (i < strArr.length) {
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj6);
        stringBuilder.append(" is not in the allowed protocols");
        j0.a("IterableUtil", stringBuilder.toString());
        return i2;
    }

    static boolean i(long l) {
        return z0.a.h(l);
    }

    static String j(File file) {
        return z0.a.i(file);
    }

    static Long k(JSONObject jSONObject, String string2) {
        return z0.a.j(jSONObject, string2);
    }

    static void l(SharedPreferences sharedPreferences, String string2, JSONObject jSONObject3, long l4) {
        z0.a.k(sharedPreferences, string2, jSONObject3, l4);
    }

    static boolean m(File file, String string2) {
        return z0.a.m(file, string2);
    }
}
