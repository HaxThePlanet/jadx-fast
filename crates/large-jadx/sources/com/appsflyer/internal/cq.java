package com.appsflyer.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes.dex */
public abstract class cq extends Observable {

    final Runnable AFInAppEventParameterName;
    private long AFInAppEventType;
    public final Map<String, Object> AFKeystoreWrapper;
    public com.appsflyer.internal.cq.b valueOf;
    public final String values;

    public static enum b {

        NOT_STARTED,
        STARTED,
        FINISHED;
    }
    public cq(String string, Runnable runnable2) {
        super();
        HashMap hashMap = new HashMap();
        this.AFKeystoreWrapper = hashMap;
        this.valueOf = cq.b.AFKeystoreWrapper;
        this.AFInAppEventParameterName = runnable2;
        this.values = string;
    }

    @Override // java.util.Observable
    public final void AFInAppEventParameterName() {
        String str = "source";
        this.AFKeystoreWrapper.put(str, this.values);
        co coVar = new co();
        this.AFKeystoreWrapper.putAll(coVar);
        this.AFKeystoreWrapper.put("latency", Long.valueOf(currentTimeMillis -= aFInAppEventType));
        this.valueOf = cq.b.AFInAppEventParameterName;
        setChanged();
        notifyObservers();
    }

    @Override // java.util.Observable
    public final void valueOf() {
        this.AFInAppEventType = System.currentTimeMillis();
        this.valueOf = cq.b.values;
        cq.2 anon = new cq.2(this);
        addObserver(anon);
    }

    @Override // java.util.Observable
    public abstract void values(Context context);
}
