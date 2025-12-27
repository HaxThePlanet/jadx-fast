package com.bumptech.glide.p;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: ManifestParser.java */
@Deprecated
/* loaded from: classes.dex */
public final class d {

    private final Context a;
    public d(Context context) {
        super();
        this.a = context;
    }

    private static b b(String str) throws StringBuilder, java.lang.ClassNotFoundException {
        try {
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
            d.c(str, invocationTarget);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str2;
        } catch (java.lang.NoSuchMethodException noSuchMethod1) {
            d.c(str, noSuchMethod1);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str2;
        } catch (java.lang.IllegalAccessException illegalAccess2) {
            d.c(str, illegalAccess2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str2;
        } catch (java.lang.InstantiationException instantiation3) {
            d.c(str, instantiation3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str2;
        }
        int i = 0;
        try {
            Object constructor = Class.forName(str).getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
            d.c(str, invocationTarget);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str2;
        } catch (java.lang.NoSuchMethodException noSuchMethod1) {
            d.c(str, noSuchMethod1);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str2;
        } catch (java.lang.IllegalAccessException illegalAccess2) {
            d.c(str, illegalAccess2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str2;
        } catch (java.lang.InstantiationException instantiation3) {
            d.c(str, instantiation3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) str2;
        }
        if (!(constructor instanceof b)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Expected instanceof GlideModule, but found: ";
            str = str3 + constructor;
            throw new RuntimeException(str);
        } else {
            return constructor;
        }
    }

    private static void c(Class<?> cls, Exception exc) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "Unable to instantiate GlideModule implementation for ";
        cls = str + cls;
        throw new RuntimeException(cls, exc);
    }

    public List<b> a() {
        int i = 128;
        final String str = "ManifestParser";
        int i2 = 3;
        if (Log.isLoggable(str, i2)) {
            Log.d(str, "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            i = 128;
            ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), i);
            if (applicationInfo.metaData == null && Log.isLoggable(str, i2)) {
                Log.d(str, "Got null app info metadata");
                return arrayList;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str8 = "Got app info metadata: ";
            str6 = str8 + applicationInfo.metaData;
            Log.v(str, str6);
            Iterator it = applicationInfo.metaData.keySet().iterator();
            Object item = it.next();
            arrayList.add(d.b(item));
            StringBuilder stringBuilder2 = new StringBuilder();
            String str10 = "Loaded Glide module: ";
            str7 = str10 + item;
            Log.d(str, str7);
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", nameNotFound);
        }
        if (Log.isLoggable(str, i2)) {
            Log.d(str, "Finished loading Glide modules");
        }
        return arrayList;
    }
}
