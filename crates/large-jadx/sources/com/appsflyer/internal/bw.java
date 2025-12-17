package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class bw {

    static final Charset AFInAppEventParameterName;
    long AFInAppEventType;
    com.appsflyer.internal.ag AFKeystoreWrapper;
    long valueOf;
    final com.appsflyer.internal.bp values;
    static {
        bw.AFInAppEventParameterName = Charset.forName("UTF-8");
    }

    public bw(com.appsflyer.internal.bp bp) {
        super();
        this.values = bp;
        this.AFKeystoreWrapper = values();
        this.AFInAppEventType = bp.valueOf("af_rc_timestamp");
        this.valueOf = bp.valueOf("af_rc_max_age");
    }

    private com.appsflyer.internal.ag values() {
        String str = this.values.AFKeystoreWrapper("af_remote_config");
        if (str == null) {
            AFLogger.values("CFG: No configuration found in cache");
            return null;
        }
        String string = new String(Base64.decode(str, 2), bw.AFInAppEventParameterName);
        ag agVar = new ag(string);
        return agVar;
    }
}
