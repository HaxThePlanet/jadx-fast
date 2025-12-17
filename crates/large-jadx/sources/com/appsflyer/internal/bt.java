package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class bt {

    private static final long AFInAppEventParameterName;
    private final com.appsflyer.internal.n AFInAppEventType;
    private final com.appsflyer.internal.bw values;
    static {
        bt.AFInAppEventParameterName = TimeUnit.HOURS.toSeconds(24);
    }

    public bt(com.appsflyer.internal.n n, com.appsflyer.internal.bw bw2) {
        super();
        this.AFInAppEventType = n;
        this.values = bw2;
    }

    public final boolean AFInAppEventParameterName() {
        return Boolean.parseBoolean(this.AFInAppEventType.AFKeystoreWrapper("com.appsflyer.rc.sandbox"));
    }

    public final boolean AFKeystoreWrapper() {
        final int i2 = 1;
        if (values.AFKeystoreWrapper == null) {
            AFLogger.AFInAppEventType("CFG: active config is missing - fetching from CDN");
            return i2;
        }
        com.appsflyer.internal.bw values2 = this.values;
        if (Long.compare(i3, millis) > 0) {
            return i2;
        }
        return 0;
    }

    public final long valueOf() {
        String str = this.AFInAppEventType.AFKeystoreWrapper("com.appsflyer.rc.cache.max-age-fallback");
        if (str != null) {
            return Long.parseLong(str);
        }
        return bt.AFInAppEventParameterName;
    }
}
