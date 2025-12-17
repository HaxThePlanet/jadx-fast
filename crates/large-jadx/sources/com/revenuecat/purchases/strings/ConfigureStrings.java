package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000c\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0004¨\u0006\u000e", d2 = {"Lcom/revenuecat/purchases/strings/ConfigureStrings;", "", "", "NO_SINGLETON_INSTANCE", "Ljava/lang/String;", "CONFIGURING_PURCHASES_PROXY_URL_SET", "APP_BACKGROUNDED", "DEBUG_ENABLED", "APP_FOREGROUNDED", "LISTENER_SET", "INITIAL_APP_USER_ID", "SDK_VERSION", "<init>", "()V", "strings_release"}, k = 1, mv = {1, 4, 0})
public final class ConfigureStrings {

    public static final String APP_BACKGROUNDED = "App backgrounded";
    public static final String APP_FOREGROUNDED = "App foregrounded";
    public static final String CONFIGURING_PURCHASES_PROXY_URL_SET = "Purchases is being configured using a proxy for RevenueCat";
    public static final String DEBUG_ENABLED = "Debug logging enabled";
    public static final String INITIAL_APP_USER_ID = "Initial App User ID - %s";
    public static final com.revenuecat.purchases.strings.ConfigureStrings INSTANCE = null;
    public static final String LISTENER_SET = "Listener set";
    public static final String NO_SINGLETON_INSTANCE = "There is no singleton instance. Make sure you configure Purchases before trying to get the default instance. More info here: https://errors.rev.cat/configuring-sdk";
    public static final String SDK_VERSION = "SDK Version - %s";
    static {
        ConfigureStrings configureStrings = new ConfigureStrings();
        ConfigureStrings.INSTANCE = configureStrings;
    }
}
