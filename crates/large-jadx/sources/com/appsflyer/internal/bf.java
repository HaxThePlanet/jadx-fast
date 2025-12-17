package com.appsflyer.internal;

import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class bf<ResponseBody>  {

    public final ExecutorService AFInAppEventParameterName;
    final com.appsflyer.internal.bk AFInAppEventType;
    public final AtomicBoolean AFKeystoreWrapper;
    final com.appsflyer.internal.bq<ResponseBody> valueOf;
    final com.appsflyer.internal.x values;
    public bf(com.appsflyer.internal.x x, ExecutorService executorService2, com.appsflyer.internal.bk bk3, com.appsflyer.internal.bq<ResponseBody> bq4) {
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.AFKeystoreWrapper = atomicBoolean;
        this.values = x;
        this.AFInAppEventParameterName = executorService2;
        this.AFInAppEventType = bk3;
        this.valueOf = bq4;
    }

    public final com.appsflyer.internal.br<ResponseBody> AFKeystoreWrapper() {
        if (this.AFKeystoreWrapper.getAndSet(true)) {
        } else {
            com.appsflyer.internal.br values = this.AFInAppEventType.values(this.values);
            super(this.valueOf.valueOf((String)values.AFInAppEventParameterName), values.AFInAppEventType, values.valueOf, values.values, values.AFKeystoreWrapper);
            return brVar;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Http call is already executed");
        throw illegalStateException;
    }
}
