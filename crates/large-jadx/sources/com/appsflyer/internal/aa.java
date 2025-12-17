package com.appsflyer.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class aa {

    private static final BitSet AFVersionDeclaration;
    private static final Handler AppsFlyer2dXConversionCallback;
    private static volatile com.appsflyer.internal.aa init;
    final Object AFInAppEventParameterName;
    final Handler AFInAppEventType;
    final Runnable AFKeystoreWrapper;
    final Runnable AFLogger$LogLevel;
    final Executor getLevel;
    private boolean onAppOpenAttributionNative;
    private int onAttributionFailureNative = 1;
    private long onConversionDataFail = 0;
    private final Map<com.appsflyer.internal.v, com.appsflyer.internal.v> onDeepLinkingNative;
    private final Map<com.appsflyer.internal.v, Map<String, Object>> onInstallConversionDataLoadedNative;
    private final SensorManager onInstallConversionFailureNative;
    private final Runnable onResponseNative;
    final Runnable valueOf;
    boolean values;
    static {
        BitSet bitSet = new BitSet(6);
        aa.AFVersionDeclaration = bitSet;
        Handler handler = new Handler(Looper.getMainLooper());
        aa.AppsFlyer2dXConversionCallback = handler;
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);
    }

    private aa(SensorManager sensorManager, Handler handler2) {
        super();
        Object object = new Object();
        this.AFInAppEventParameterName = object;
        BitSet aFVersionDeclaration = aa.AFVersionDeclaration;
        HashMap hashMap = new HashMap(aFVersionDeclaration.size());
        this.onDeepLinkingNative = hashMap;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(aFVersionDeclaration.size());
        this.onInstallConversionDataLoadedNative = concurrentHashMap;
        aa.1 anon = new aa.1(this);
        this.valueOf = anon;
        aa.2 anon2 = new aa.2(this);
        this.AFKeystoreWrapper = anon2;
        aa.5 anon3 = new aa.5(this);
        this.AFLogger$LogLevel = anon3;
        int i = 1;
        int i2 = 0;
        aa.4 anon4 = new aa.4(this);
        this.onResponseNative = anon4;
        this.getLevel = Executors.newSingleThreadExecutor();
        this.onInstallConversionFailureNative = sensorManager;
        this.AFInAppEventType = handler2;
    }

    static int AFInAppEventParameterName(com.appsflyer.internal.aa aa) {
        return aa.onAttributionFailureNative;
    }

    static int AFInAppEventParameterName(com.appsflyer.internal.aa aa, int i2) {
        aa.onAttributionFailureNative = i2;
        return i2;
    }

    static SensorManager AFInAppEventType(com.appsflyer.internal.aa aa) {
        return aa.onInstallConversionFailureNative;
    }

    static com.appsflyer.internal.aa AFInAppEventType(Context context) {
        if (aa.init != null) {
            return aa.init;
        }
        return aa.AFKeystoreWrapper((SensorManager)context.getApplicationContext().getSystemService("sensor"), aa.AppsFlyer2dXConversionCallback);
    }

    private static com.appsflyer.internal.aa AFKeystoreWrapper(SensorManager sensorManager, Handler handler2) {
        com.appsflyer.internal.aa init;
        com.appsflyer.internal.aa aaVar;
        init = aa.class;
        if (aa.init == null && aa.init == null) {
            init = aa.class;
            synchronized (init) {
                aaVar = new aa(sensorManager, handler2);
                aa.init = aaVar;
            }
        }
        return aa.init;
    }

    static Runnable AFKeystoreWrapper(com.appsflyer.internal.aa aa) {
        return aa.onResponseNative;
    }

    static Map AFVersionDeclaration(com.appsflyer.internal.aa aa) {
        return aa.onInstallConversionDataLoadedNative;
    }

    static Map valueOf(com.appsflyer.internal.aa aa) {
        return aa.onDeepLinkingNative;
    }

    private static boolean valueOf(int i) {
        BitSet aFVersionDeclaration;
        int obj1;
        if (i >= 0 && aa.AFVersionDeclaration.get(i)) {
            if (aa.AFVersionDeclaration.get(i)) {
                return 1;
            }
        }
        return 0;
    }

    static Executor values(com.appsflyer.internal.aa aa) {
        return aa.getLevel;
    }

    static boolean values(int i) {
        return aa.valueOf(i);
    }

    static boolean values(com.appsflyer.internal.aa aa, boolean z2) {
        aa.onAppOpenAttributionNative = z2;
        return z2;
    }

    final List<Map<String, Object>> AFInAppEventParameterName() {
        Map onInstallConversionDataLoadedNative2;
        Object next;
        Map onInstallConversionDataLoadedNative;
        int i;
        Iterator iterator = this.onDeepLinkingNative.values().iterator();
        for (v next : iterator) {
            next.valueOf(this.onInstallConversionDataLoadedNative, true);
        }
        onInstallConversionDataLoadedNative2 = this.onInstallConversionDataLoadedNative;
        if (onInstallConversionDataLoadedNative2 != null && onInstallConversionDataLoadedNative2.isEmpty()) {
            if (onInstallConversionDataLoadedNative2.isEmpty()) {
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.onInstallConversionDataLoadedNative.values());
            return copyOnWriteArrayList2;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
        return copyOnWriteArrayList;
    }

    final List<Map<String, Object>> AFInAppEventType() {
        boolean onAppOpenAttributionNative;
        boolean next;
        Map onInstallConversionDataLoadedNative;
        int i;
        final Object aFInAppEventParameterName = this.AFInAppEventParameterName;
        synchronized (aFInAppEventParameterName) {
            if (this.onAppOpenAttributionNative) {
                onAppOpenAttributionNative = this.onDeepLinkingNative.values().iterator();
                try {
                    for (v next : onAppOpenAttributionNative) {
                        next.valueOf(this.onInstallConversionDataLoadedNative, false);
                    }
                    (v)onAppOpenAttributionNative.next().valueOf(this.onInstallConversionDataLoadedNative, false);
                    if (this.onInstallConversionDataLoadedNative.isEmpty()) {
                    }
                    CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(Collections.emptyList());
                    return copyOnWriteArrayList2;
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.onInstallConversionDataLoadedNative.values());
                    return copyOnWriteArrayList;
                    throw th;
                }
            }
        }
    }

    final void valueOf() {
        Handler aFInAppEventType;
        Runnable valueOf;
        int cmp;
        final long currentTimeMillis = System.currentTimeMillis();
        long onConversionDataFail = this.onConversionDataFail;
        if (Long.compare(onConversionDataFail, i2) != 0) {
            this.onAttributionFailureNative = onAttributionFailureNative++;
            if (Long.compare(i, cmp) < 0) {
                this.AFInAppEventType.removeCallbacks(this.AFKeystoreWrapper);
                this.AFInAppEventType.post(this.valueOf);
            }
        } else {
            this.AFInAppEventType.post(this.AFLogger$LogLevel);
            this.AFInAppEventType.post(this.valueOf);
        }
        this.onConversionDataFail = currentTimeMillis;
    }
}
