package com.revenuecat.purchases.common.caching;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\"\u0016\u0010\u0001\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0001\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0005¨\u0006\u0008", d2 = {"", "SHARED_PREFERENCES_PREFIX", "Ljava/lang/String;", "", "PURCHASER_INFO_SCHEMA_VERSION", "I", "CACHE_REFRESH_PERIOD_IN_BACKGROUND", "CACHE_REFRESH_PERIOD_IN_FOREGROUND", "common_release"}, k = 2, mv = {1, 4, 0})
public final class DeviceCacheKt {

    private static final int CACHE_REFRESH_PERIOD_IN_BACKGROUND = 90000000;
    private static final int CACHE_REFRESH_PERIOD_IN_FOREGROUND = 300000;
    public static final int PURCHASER_INFO_SCHEMA_VERSION = 3;
    private static final String SHARED_PREFERENCES_PREFIX = "com.revenuecat.purchases.";
}
