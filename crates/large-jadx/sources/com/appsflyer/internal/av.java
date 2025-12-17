package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.appsflyer.AFLogger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class av<T>  {

    public final Context AFInAppEventParameterName;
    public final FutureTask<T> AFInAppEventType;
    public final String valueOf;
    private final String[] values;
    public av(Context context, String string2, String... string3Arr3) {
        super();
        av.3 anon = new av.3(this);
        FutureTask futureTask = new FutureTask(anon);
        this.AFInAppEventType = futureTask;
        this.AFInAppEventParameterName = context;
        this.valueOf = string2;
        this.values = string3Arr3;
    }

    protected abstract T AFInAppEventType();

    public T valueOf() {
        try {
            return this.AFInAppEventType.get(500, obj2);
            AFLogger.AFKeystoreWrapper(th.getMessage(), th);
            Throwable th = null;
            return th;
        }
    }

    public final boolean values() {
        int i;
        Throwable th;
        android.content.pm.ProviderInfo resolveContentProvider;
        Object valueOf;
        int packageManager;
        i = 0;
        resolveContentProvider = this.AFInAppEventParameterName.getPackageManager().resolveContentProvider(this.valueOf, 128);
        if (resolveContentProvider != null && Arrays.asList(this.values).contains(ab.AFInAppEventParameterName(this.AFInAppEventParameterName.getPackageManager(), resolveContentProvider.packageName))) {
            try {
                if (Arrays.asList(this.values).contains(ab.AFInAppEventParameterName(this.AFInAppEventParameterName.getPackageManager(), resolveContentProvider.packageName))) {
                }
                i = 1;
                return i;
                AFLogger.AFKeystoreWrapper(th.getMessage(), th);
                return obj0;
            }
        }
    }
}
