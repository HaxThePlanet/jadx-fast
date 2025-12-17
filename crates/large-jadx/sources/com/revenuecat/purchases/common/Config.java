package com.revenuecat.purchases.common;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000c\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\n\u0010\u000b¨\u0006\u000e", d2 = {"Lcom/revenuecat/purchases/common/Config;", "", "", "debugLogsEnabled", "Z", "getDebugLogsEnabled", "()Z", "setDebugLogsEnabled", "(Z)V", "", "frameworkVersion", "Ljava/lang/String;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class Config {

    public static final com.revenuecat.purchases.common.Config INSTANCE = null;
    private static boolean debugLogsEnabled = false;
    public static final String frameworkVersion = "4.3.1";
    static {
        Config config = new Config();
        Config.INSTANCE = config;
    }

    public final boolean getDebugLogsEnabled() {
        return Config.debugLogsEnabled;
    }

    public final void setDebugLogsEnabled(boolean z) {
        Config.debugLogsEnabled = z;
    }
}
