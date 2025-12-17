package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

/* loaded from: classes.dex */
public final class aj {

    private static String AFVersionDeclaration;
    private static String getLevel;
    String AFInAppEventParameterName;
    long AFInAppEventType;
    int AFKeystoreWrapper;
    Throwable AFLogger$LogLevel;
    String valueOf;
    long values;
    public aj(String string, String string2, long l3, long l4, int i5, Throwable throwable6) {
        super();
        this.AFInAppEventParameterName = string;
        this.valueOf = string2;
        this.AFInAppEventType = l3;
        this.values = i5;
        this.AFKeystoreWrapper = obj7;
        this.AFLogger$LogLevel = obj8;
    }

    static void AFInAppEventParameterName(String string) {
        int i;
        String charAt;
        int length;
        aj.AFVersionDeclaration = string;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < string.length()) {
            if (i != 0) {
            } else {
            }
            stringBuilder.append(string.charAt(i));
            i++;
            if (i == length2--) {
            } else {
            }
            stringBuilder.append("*");
        }
        aj.getLevel = stringBuilder.toString();
    }

    public static void valueOf(String string) {
        String aFVersionDeclaration;
        String getLevel;
        String obj2;
        if (aj.AFVersionDeclaration == null) {
            aj.AFInAppEventParameterName(AppsFlyerProperties.getInstance().getDevKey());
        }
        String aFVersionDeclaration2 = aj.AFVersionDeclaration;
        if (aFVersionDeclaration2 != null) {
            AFLogger.AFInAppEventType(string.replace(aFVersionDeclaration2, aj.getLevel));
        }
    }
}
