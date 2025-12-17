package com.google.firebase.perf.util;

import android.content.Context;
import android.content.res.Resources;
import com.google.firebase.perf.logging.AndroidLogger;
import java.net.URI;

/* loaded from: classes2.dex */
public class URLAllowlist {

    private static String[] allowlistedDomains;
    public static boolean isURLAllowlisted(URI uRI, Context context2) {
        int i;
        boolean contains;
        int obj6;
        Resources resources = context2.getResources();
        obj6 = resources.getIdentifier("firebase_performance_whitelisted_domains", "array", context2.getPackageName());
        int i2 = 1;
        if (obj6 == null) {
            return i2;
        }
        AndroidLogger.getInstance().debug("Detected domain allowlist, only allowlisted domains will be measured.");
        if (URLAllowlist.allowlistedDomains == null) {
            URLAllowlist.allowlistedDomains = resources.getStringArray(obj6);
        }
        final String obj5 = uRI.getHost();
        if (obj5 == null) {
            return i2;
        }
        obj6 = URLAllowlist.allowlistedDomains;
        int i3 = 0;
        i = i3;
        while (i < obj6.length) {
            i++;
        }
        return i3;
    }
}
