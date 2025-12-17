package com.appsflyer.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class bs {

    public com.appsflyer.internal.aj AFInAppEventParameterName;
    private final com.appsflyer.internal.bw AFInAppEventType;
    final com.appsflyer.internal.bt AFKeystoreWrapper;
    private final com.appsflyer.internal.bh AFVersionDeclaration;
    final com.appsflyer.internal.n valueOf;
    public final Executor values;
    public bs(com.appsflyer.internal.bn bn, com.appsflyer.internal.n n2, com.appsflyer.internal.bw bw3, com.appsflyer.internal.bh bh4, com.appsflyer.internal.bt bt5, Executor executor6) {
        super();
        this.valueOf = n2;
        this.AFInAppEventType = bw3;
        this.AFVersionDeclaration = bh4;
        this.AFKeystoreWrapper = bt5;
        this.values = executor6;
    }

    final void AFInAppEventParameterName(String string, long l2, com.appsflyer.internal.br<?> br3, com.appsflyer.internal.ag ag4, Throwable throwable5) {
        int aFInAppEventType;
        boolean cause;
        String values;
        Object values2;
        int values3;
        int i;
        Object obj;
        Object obj2 = ag4;
        Object obj3 = throwable5;
        values2 = obj20;
        if (obj2 != null) {
            values3 = aFKeystoreWrapper.values;
            aFInAppEventType = obj2.AFInAppEventType;
        } else {
            values3 = 0;
            aFInAppEventType = 0;
        }
        if (values2 instanceof HttpException != null) {
            obj = cause;
            i = values2;
        } else {
            obj = values2;
            i = values3;
        }
        values = obj3 != null ? obj3.values : 0;
        super(values, string, i, obj9, currentTimeMillis - l2, obj11, aFInAppEventType, obj);
        obj4.AFInAppEventParameterName = ajVar;
    }

    final com.appsflyer.internal.bo valueOf(boolean z, String string2, long l3) {
        Throwable th;
        String obj12;
        try {
            if (z != null) {
            } else {
            }
            obj12 = bh.valueOf;
            obj12 = bh.AFKeystoreWrapper;
            Object[] arr = new Object[1];
            x xVar = new x(String.format(obj12, string2), "GET");
            xVar.getLevel = 500;
            obj12 = aFVersionDeclaration.AFInAppEventType;
            bl blVar = new bl();
            bf bfVar = new bf(xVar, obj12.valueOf, obj12.AFInAppEventType, blVar);
            obj12 = bfVar.AFKeystoreWrapper();
            if (obj12.valueOf()) {
            }
            long valueOf2 = this.AFKeystoreWrapper.valueOf();
            StringBuilder stringBuilder = new StringBuilder("CFG: using max-age fallback: ");
            stringBuilder.append(valueOf2);
            String str4 = " seconds";
            stringBuilder.append(str4);
            AFLogger.AFKeystoreWrapper(stringBuilder.toString());
            long currentTimeMillis = System.currentTimeMillis();
            com.appsflyer.internal.bw aFInAppEventType = this.AFInAppEventType;
            Object aFInAppEventParameterName3 = obj12.AFInAppEventParameterName;
            aFInAppEventType.values.AFInAppEventType("af_remote_config", Base64.encodeToString(aFInAppEventParameterName3.AFKeystoreWrapper.getBytes(bw.AFInAppEventParameterName), 2));
            aFInAppEventType.values.AFKeystoreWrapper("af_rc_timestamp", currentTimeMillis);
            com.appsflyer.internal.bp values2 = aFInAppEventType.values;
            values2.AFKeystoreWrapper("af_rc_max_age", valueOf2);
            aFInAppEventType.AFKeystoreWrapper = (ag)aFInAppEventParameterName3;
            aFInAppEventType.AFInAppEventType = currentTimeMillis;
            aFInAppEventType.valueOf = valueOf2;
            StringBuilder stringBuilder2 = new StringBuilder("CFG: Config successfully updated, timeToLive: ");
            stringBuilder2.append(valueOf2);
            stringBuilder2.append(str4);
            AFLogger.values(stringBuilder2.toString());
            this.AFInAppEventParameterName(string2, l3, values2, obj12, (ag)obj12.AFInAppEventParameterName);
            return bo.AFInAppEventParameterName;
            this.AFInAppEventParameterName(string2, l3, obj7, obj12, (ag)obj12.AFInAppEventParameterName);
            StringBuilder obj13 = new StringBuilder("CFG: failed to fetch remote config from CDN with status code: ");
            obj13.append(obj12.AFInAppEventType);
            AFLogger.init(obj13.toString());
            return bo.AFInAppEventType;
            th = z;
            String str = "CFG: failed to fetch remote config: ";
            z = new StringBuilder(str);
            str = th.getMessage();
            z.append(str);
            z = z.toString();
            AFLogger.AFKeystoreWrapper(z, th);
            z = null;
            str = th instanceof ParsingException;
            if (str != null) {
            }
            z = th;
            z = (ParsingException)z.getRawResponse();
            int i3 = 0;
            str = this;
            str.AFInAppEventParameterName(string2, l3, obj3, z, i3);
            z = bo.AFInAppEventType;
            return z;
        }
    }
}
