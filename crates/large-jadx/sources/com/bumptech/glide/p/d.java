package com.bumptech.glide.p;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
@Deprecated
public final class d {

    private final Context a;
    public d(Context context) {
        super();
        this.a = context;
    }

    private static com.bumptech.glide.p.b b(String string) {
        try {
            int i = 0;
            int i2 = 0;
            Object obj3 = Class.forName(string).getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
            if (!obj3 instanceof b) {
            } else {
            }
            return (b)obj3;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected instanceof GlideModule, but found: ");
            stringBuilder.append(obj3);
            RuntimeException runtimeException = new RuntimeException(stringBuilder.toString());
            throw runtimeException;
            d.c(string, illegalArgumentException);
            throw str;
        } catch (java.lang.InstantiationException instantiation) {
        } catch (java.lang.IllegalAccessException illegalAccess1) {
        } catch (java.lang.NoSuchMethodException noSuchMethod2) {
        } catch (java.lang.reflect.InvocationTargetException invocationTarget3) {
        }
    }

    private static void c(Class<?> class, Exception exception2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to instantiate GlideModule implementation for ");
        stringBuilder.append(class);
        RuntimeException runtimeException = new RuntimeException(stringBuilder.toString(), exception2);
        throw runtimeException;
    }

    public List<com.bumptech.glide.p.b> a() {
        boolean loggable2;
        boolean loggable3;
        boolean loggable4;
        boolean loggable;
        int metaData;
        boolean stringBuilder;
        Object str;
        final String str2 = "ManifestParser";
        int i = 3;
        if (Log.isLoggable(str2, i)) {
            Log.d(str2, "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        android.content.pm.ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
        if (applicationInfo.metaData == null && Log.isLoggable(str2, i)) {
            if (Log.isLoggable(str2, i)) {
                Log.d(str2, "Got null app info metadata");
            }
            return arrayList;
        }
        if (Log.isLoggable(str2, 2)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Got app info metadata: ");
            stringBuilder2.append(applicationInfo.metaData);
            Log.v(str2, stringBuilder2.toString());
        }
        Iterator iterator = applicationInfo.metaData.keySet().iterator();
        while (iterator.hasNext()) {
            metaData = iterator.next();
            arrayList.add(d.b(metaData));
            if ("GlideModule".equals(applicationInfo.metaData.get((String)metaData)) && Log.isLoggable(str2, i)) {
            }
            arrayList.add(d.b(metaData));
            if (Log.isLoggable(str2, i)) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Loaded Glide module: ");
            stringBuilder.append(metaData);
            Log.d(str2, stringBuilder.toString());
        }
        if (Log.isLoggable(str2, i)) {
            Log.d(str2, "Finished loading Glide modules");
        }
        return arrayList;
    }
}
