package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BreadcrumbAnalyticsEventReceiver implements com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, BreadcrumbSource {

    private static final String BREADCRUMB_NAME_KEY = "name";
    private static final String BREADCRUMB_PARAMS_KEY = "parameters";
    private static final String BREADCRUMB_PREFIX = "$A$:";
    private BreadcrumbHandler breadcrumbHandler;
    private static String serializeEvent(String string, Bundle bundle2) {
        Object next;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Iterator iterator = bundle2.keySet().iterator();
        for (String next : iterator) {
            jSONObject2.put(next, bundle2.get(next));
        }
        jSONObject.put("name", string);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void onEvent(String string, Bundle bundle2) {
        StringBuilder stringBuilder;
        String str;
        String obj4;
        Bundle obj5;
        final BreadcrumbHandler breadcrumbHandler = this.breadcrumbHandler;
        if (breadcrumbHandler != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("$A$:");
            stringBuilder.append(BreadcrumbAnalyticsEventReceiver.serializeEvent(string, bundle2));
            breadcrumbHandler.handleBreadcrumb(stringBuilder.toString());
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        this.breadcrumbHandler = breadcrumbHandler;
        Logger.getLogger().d("Registered Firebase Analytics event receiver for breadcrumbs");
    }
}
