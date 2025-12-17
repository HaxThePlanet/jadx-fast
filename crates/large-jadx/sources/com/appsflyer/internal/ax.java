package com.appsflyer.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.Purchase.a;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.c;
import com.android.billingclient.api.c.b;
import com.android.billingclient.api.g;
import com.android.billingclient.api.m;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ax implements Runnable {

    final com.appsflyer.internal.bp AFInAppEventParameterName;
    public final com.appsflyer.internal.bg AFInAppEventType;
    public final ExecutorService AFKeystoreWrapper;
    private final com.appsflyer.internal.bh getLevel;
    private com.appsflyer.internal.az valueOf;
    c values;
    public ax(com.appsflyer.internal.bg bg, com.appsflyer.internal.az az2, com.appsflyer.internal.bp bp3, ExecutorService executorService4, com.appsflyer.internal.bh bh5) {
        super();
        this.AFInAppEventType = bg;
        this.valueOf = az2;
        this.AFInAppEventParameterName = bp3;
        this.AFKeystoreWrapper = executorService4;
        this.getLevel = bh5;
    }

    static void AFKeystoreWrapper(com.appsflyer.internal.ax ax, boolean z2, List list3) {
        String str3;
        String str5;
        String valueOf;
        String str4;
        Object hashMap;
        String hashMap2;
        String str;
        String str2;
        int i = 0;
        final int i2 = 0;
        ab abVar = new ab(i, z2, list3, i2);
        com.appsflyer.internal.bh obj13 = ax.getLevel;
        Object[] arr = new Object[2];
        arr[i] = AppsFlyerLib.getInstance().getHostPrefix();
        int i4 = 1;
        arr[i4] = ah.AFKeystoreWrapper().getHostName();
        HashMap hashMap3 = new HashMap();
        hashMap3.put("app_id", aFInAppEventParameterName2.AFKeystoreWrapper.getPackageName());
        String string2 = AppsFlyerProperties.getInstance().getString("AppUserId");
        if (string2 != null) {
            hashMap3.put("cuid", string2);
        }
        Context aFKeystoreWrapper2 = aFInAppEventParameterName3.AFKeystoreWrapper;
        hashMap3.put("app_version_name", ab.values(aFKeystoreWrapper2, aFKeystoreWrapper2.getPackageName()));
        HashMap hashMap4 = new HashMap();
        hashMap = new HashMap();
        com.appsflyer.internal.a.d.a valueOf4 = ac.valueOf(aFInAppEventParameterName4.AFKeystoreWrapper, hashMap);
        valueOf = valueOf4 != null ? valueOf4.valueOf : i2;
        if (valueOf != null) {
            hashMap4.put("advertising_id", valueOf);
        }
        WeakReference weakReference = new WeakReference(aFInAppEventParameterName5.AFKeystoreWrapper);
        hashMap4.put("appsflyer_id", al.AFInAppEventType(weakReference));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.VERSION.SDK_INT);
        hashMap4.put("os_version", stringBuilder.toString());
        hashMap4.put("sdk_version", ah.values);
        hashMap3.put("device_data", hashMap4);
        hashMap3.put("is_cached", Boolean.valueOf(abVar.AFInAppEventType()));
        str3 = abVar.valueOf() ? "SANDBOX" : "PRODUCTION";
        hashMap3.put("environment", str3);
        hashMap3.put("additional_parameters", abVar.AFKeystoreWrapper);
        ArrayList arrayList = new ArrayList();
        Iterator iterator = abVar.AFInAppEventParameterName.iterator();
        for (Purchase next2 : iterator) {
            hashMap2 = new HashMap();
            hashMap2.put("token", next2.e());
            hashMap2.put("subscription_id", next2.getSku());
            arrayList.add(hashMap2);
        }
        hashMap3.put("subscriptions", arrayList);
        JSONObject jSONObject = new JSONObject(hashMap3);
        super(String.format("https://%sars.%s/api/v1/android/validate_subscription", arr), jSONObject.toString().getBytes(), "POST", Collections.emptyMap(), 0);
        obj13 = obj13.AFInAppEventType;
        bm bmVar = new bm();
        bf bfVar = new bf(xVar, obj13.valueOf, obj13.AFInAppEventType, bmVar);
        obj13 = new ax.5(ax, z2, i2);
        if (bfVar.AFKeystoreWrapper.getAndSet(i4)) {
        } else {
            bf.1 obj12 = new bf.1(bfVar, obj13);
            bfVar.AFInAppEventParameterName.submit(obj12);
        }
        IllegalStateException obj11 = new IllegalStateException("Http call is already executed");
        throw obj11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c values;
        boolean auVar;
        try {
            if (this.values == null) {
            }
            at atVar = new at(this);
            c.b bVar = c.g(valueOf.values);
            bVar.c(atVar);
            bVar.b();
            values = bVar.a();
            this.values = values;
            auVar = new au(this);
            values.k(auVar);
            auVar = th instanceof NoSuchMethodError;
            if (!auVar) {
            } else {
            }
            auVar = th instanceof NoClassDefFoundError;
            if (auVar) {
            }
            auVar = "It seems your app uses different Play Billing library version than the SDK. Please use v.3.0.3";
            AFLogger.init(auVar);
            auVar = "Failed to setup Play billing";
            AFLogger.AFInAppEventType(auVar, th);
        }
    }
}
