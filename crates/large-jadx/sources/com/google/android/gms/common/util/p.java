package com.google.android.gms.common.util;

import android.content.Context;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class p {

    private static final Method a = null;
    private static final Method b = null;
    private static final Method c = null;
    private static final Method d;
    static {
        String str2;
        String str;
        boolean arr;
        int tYPE;
        Class arr2;
        final Class<String> obj2 = String.class;
        Process.myUid();
        final int i2 = 0;
        Class[] arr3 = new Class[1];
        Method method = WorkSource.class.getMethod("add", Integer.TYPE);
    }

    public static WorkSource a(Context context, String string2) {
        int packageManager;
        Context obj3;
        String obj4;
        final int i = 0;
        obj3 = c.a(context).c(string2, 0);
        if (context != null && context.getPackageManager() != null && string2 != null && obj3 == null) {
            if (context.getPackageManager() != null) {
                if (string2 != null) {
                    obj3 = c.a(context).c(string2, 0);
                    if (obj3 == null) {
                        obj3 = "Could not get applicationInfo from package: ";
                        if (string2.length() != 0) {
                            obj3 = obj3.concat(string2);
                        } else {
                            obj4 = new String(obj3);
                            obj3 = obj4;
                        }
                        Log.e("WorkSourceUtil", obj3);
                        return i;
                    }
                    WorkSource workSource = new WorkSource();
                    p.d(workSource, obj3.uid, string2);
                    return workSource;
                }
            }
        }
        try {
            return i;
        }
    }

    public static List<String> b(WorkSource workSource) {
        int intValue;
        Object th2;
        Object[] arr;
        Throwable th;
        Object invoke;
        int i;
        Object[] arr2;
        Integer valueOf;
        ArrayList arrayList = new ArrayList();
        final String str = "Unable to assign blame through WorkSource";
        final String str2 = "WorkSourceUtil";
        final int i2 = 0;
        if (workSource == null) {
            intValue = i2;
        } else {
        }
        if (intValue != 0) {
            arr = i2;
            while (arr < intValue) {
                invoke = p.d;
                i = 0;
                if (invoke != null) {
                }
                if (!n.b(i)) {
                }
                arr++;
                r.j(i);
                arrayList.add(i);
                arr2 = new Object[1];
                arr2[i2] = Integer.valueOf(arr);
                i = invoke;
                Log.wtf(obj2, obj1, th);
            }
        }
        return arrayList;
    }

    public static boolean c(Context context) {
        final int i = 0;
        if (context == null) {
            return i;
        }
        if (context.getPackageManager() == null) {
            return i;
        }
        if (c.a(context).b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0) {
            return 1;
        }
        return i;
    }

    public static void d(WorkSource workSource, int i2, String string3) {
        Object obj6;
        Method method = p.b;
        final int i = 0;
        final String str = "Unable to assign blame through WorkSource";
        final String str2 = "WorkSourceUtil";
        final int i3 = 1;
        if (method != null) {
            Object[] arr2 = new Object[2];
            arr2[i] = Integer.valueOf(i2);
            arr2[i3] = string3;
            method.invoke(workSource, arr2);
        }
        final Method obj8 = p.a;
        if (obj8 != null) {
            Object[] arr = new Object[i3];
            arr[i] = Integer.valueOf(i2);
            obj8.invoke(workSource, arr);
        }
    }
}
