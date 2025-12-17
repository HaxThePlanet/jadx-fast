package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class w {

    public final com.appsflyer.internal.bk AFInAppEventType;
    public final ExecutorService valueOf;

    interface d {
        public abstract void valueOf(String string, Exception exception2);

        public abstract void values(String string, String string2);
    }
    public w(com.appsflyer.internal.bk bk, ExecutorService executorService2) {
        super();
        this.AFInAppEventType = bk;
        this.valueOf = executorService2;
    }
}
