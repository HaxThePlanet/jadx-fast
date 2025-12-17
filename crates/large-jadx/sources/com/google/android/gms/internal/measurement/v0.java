package com.google.android.gms.internal.measurement;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class v0 {

    private static final Method a = null;
    private static final Method b;
    static {
        Class<String> obj;
        int sDK_INT;
        int sDK_INT2;
        int arr;
        int declaredMethod;
        obj = String.class;
        final int i3 = 6;
        arr = 0;
        final int i4 = 24;
        final String str2 = "JobSchedulerCompat";
        if (Build.VERSION.SDK_INT >= i4) {
            Class[] arr2 = new Class[4];
            arr2[arr] = JobInfo.class;
            arr2[1] = obj;
            arr2[2] = Integer.TYPE;
            arr2[3] = obj;
            Method declaredMethod2 = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", arr2);
        }
        int i = declaredMethod;
        if (Build.VERSION.SDK_INT >= i4) {
            declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[arr]);
        }
        v0.b = declaredMethod;
    }

    public static int a(Context context, JobInfo jobInfo2, String string3, String string4) {
        int str3;
        String str;
        String str2;
        Object[] arr;
        int i;
        int obj5;
        int obj8;
        Object obj7 = context.getSystemService("jobscheduler");
        Objects.requireNonNull((JobScheduler)obj7);
        if (v0.a != null) {
            if (context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            } else {
                obj5 = v0.b;
                obj8 = 0;
                obj5 = obj5.invoke(UserHandle.class, new Object[obj8]);
                if (obj5 != null && (Integer)obj5 != null) {
                    obj5 = obj5.invoke(UserHandle.class, new Object[obj8]);
                    if ((Integer)(Integer)obj5 != null) {
                        obj5 = (Integer)(Integer)obj5.intValue();
                    } else {
                        obj5 = obj8;
                    }
                } else {
                }
                final Method method = v0.a;
                if (method != null) {
                    arr = new Object[4];
                    arr[obj8] = jobInfo2;
                    arr[1] = "com.google.android.gms";
                    arr[2] = Integer.valueOf(obj5);
                    arr[3] = "UploadAlarm";
                    obj5 = method.invoke(obj7, arr);
                    if ((Integer)obj5 != null) {
                        obj8 = (Integer)obj5.intValue();
                    }
                } else {
                    obj8 = obj7.schedule(jobInfo2);
                }
            }
            return obj8;
        }
        return obj7.schedule(jobInfo2);
    }
}
