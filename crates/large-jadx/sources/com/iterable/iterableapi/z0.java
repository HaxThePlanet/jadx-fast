package com.iterable.iterableapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.iterable.iterableapi.k1.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterableUtil.java */
/* loaded from: classes2.dex */
class z0 {

    static z0.a a;

    static class a {
        a() {
            super();
        }

        public long a() {
            return System.currentTimeMillis();
        }

        String b(Context context) throws java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            Object context2 = null;
            context2 = null;
            try {
                Class cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                int i = 1;
                Class[] arr2 = new Class[i];
                obj = Context.class;
                int i2 = 0;
                arr2[i2] = obj;
                Object[] arr = new Object[i];
                arr[i2] = context;
                context2 = cls.getMethod("getAdvertisingIdInfo", arr2).invoke(context2, arr);
            } catch (Exception e) {
                String str3 = "Error while fetching advertising ID";
                j0.j(str, str3, e);
            } catch (java.lang.ClassNotFoundException classNotFound1) {
                str3 = "ClassNotFoundException: Can't track ADID. Check that play-services-ads is added to the dependencies.";
                j0.b(str, str3, classNotFound1);
            }
            return context2;
        }

        String c(Context context) {
            try {
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
                j0.d("IterableUtil", "Error while retrieving app version", nameNotFound);
                nameNotFound = null;
                return nameNotFound;
            }
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }

        String d(Context context) {
            try {
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
                j0.d("IterableUtil", "Error while retrieving app version code", nameNotFound);
                nameNotFound = null;
                return nameNotFound;
            }
            return Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        }

        File e(File file, String str) {
            final File file2 = new File(file, str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            return file2;
        }

        File f(Context context) throws java.io.IOException {
            final File file = new File(context.getFilesDir(), "com.iterable.sdk");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        File g(Context context) throws java.io.IOException {
            final File file = new File(context.getCacheDir(), "com.iterable.sdk");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        String i(File file) {
            java.io.Closeable closeable;
            Throwable th;
            try {
                final FileInputStream fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
            } catch (Exception e1) {
            }
            try {
                final InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            } catch (Throwable th) {
            } catch (Exception e1) {
            }
            try {
                final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            } catch (Throwable th) {
            } catch (Exception e1) {
            }
            try {
                final StringBuilder stringBuilder = new StringBuilder();
                String line = bufferedReader.readLine();
                while (line != null) {
                    stringBuilder.append(line);
                    line = bufferedReader.readLine();
                }
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
            b.a(fileInputStream);
            b.a(inputStreamReader);
            b.a(bufferedReader);
            return stringBuilder.toString();
        }

        Long j(JSONObject jSONObject, String str) {
            try {
                long _long = jSONObject.getLong(str);
            } catch (org.json.JSONException unused) {
                return null;
            }
            return Long.valueOf(_long);
        }

        void k(SharedPreferences sharedPreferences, String str, JSONObject jSONObject, long j) throws JSONException {
            this.l(sharedPreferences, str, jSONObject.toString(), j);
        }

        void l(SharedPreferences sharedPreferences, String str, String str2, long j) {
            final SharedPreferences.Editor edit = sharedPreferences.edit();
            StringBuilder stringBuilder = new StringBuilder();
            final String str4 = "_object";
            str = str + str4;
            edit.putString(str, str2);
            final StringBuilder stringBuilder2 = new StringBuilder();
            String str5 = "_expiration";
            str6 = str + str5;
            edit.putLong(str6, a() + j);
            edit.apply();
        }

        boolean m(File file, String str) throws java.io.IOException, java.io.FileNotFoundException, java.io.UnsupportedEncodingException {
            try {
                final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
                outputStreamWriter.write(str);
                outputStreamWriter.close();
            } catch (Exception e) {
                str = new StringBuilder();
                String str3 = "Error while writing to file: ";
                file = file.toString();
                file = str3 + file;
                StringBuilder str2 = "IterableUtil";
                j0.d(str2, file, e);
                file = null;
                return file;
            }
            return true;
        }

        boolean h(long j) {
            boolean z = true;
            j = j >= 0 ? 1 : 0;
            return (j >= 0 ? 1 : 0);
        }
    }
    static {
        z0.a = new z0.a();
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

    static File e(File file, String str) {
        return z0.a.e(file, str);
    }

    static File f(Context context) {
        return z0.a.f(context);
    }

    static File g(Context context) {
        return z0.a.g(context);
    }

    static boolean h(String str) {
        int i;
        i = 0;
        String str6 = str.split("://")[i];
        final boolean z = true;
        if (str6.equals("https")) {
            return true;
        }
        for (String str5 : strArr) {
            if (str6.equals(str5)) {
                return true;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str7 = " is not in the allowed protocols";
        str8 = str6 + str7;
        j0.a("IterableUtil", str8);
        return false;
    }

    static boolean i(long j) {
        return z0.a.h(j);
    }

    static String j(File file) {
        return z0.a.i(file);
    }

    static Long k(JSONObject jSONObject, String str) {
        return z0.a.j(jSONObject, str);
    }

    static void l(SharedPreferences sharedPreferences, String str, JSONObject jSONObject, long j) {
        z0.a.k(sharedPreferences, str, jSONObject, j);
    }

    static boolean m(File file, String str) {
        return z0.a.m(file, str);
    }
}
