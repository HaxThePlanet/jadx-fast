package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import java.util.Locale;

/* loaded from: classes2.dex */
class CrashlyticsAnalyticsListener implements AnalyticsConnector.AnalyticsConnectorListener {

    static final String CRASHLYTICS_ORIGIN = "clx";
    static final String EVENT_NAME_KEY = "name";
    static final String EVENT_ORIGIN_KEY = "_o";
    static final String EVENT_PARAMS_KEY = "params";
    private AnalyticsEventReceiver breadcrumbEventReceiver;
    private AnalyticsEventReceiver crashlyticsOriginEventReceiver;
    private static void notifyEventReceiver(AnalyticsEventReceiver analyticsEventReceiver, String string2, Bundle bundle3) {
        if (analyticsEventReceiver == null) {
        }
        analyticsEventReceiver.onEvent(string2, bundle3);
    }

    private void notifyEventReceivers(String string, Bundle bundle2) {
        AnalyticsEventReceiver crashlyticsOriginEventReceiver;
        crashlyticsOriginEventReceiver = "clx".equals(bundle2.getString("_o")) ? this.crashlyticsOriginEventReceiver : this.breadcrumbEventReceiver;
        CrashlyticsAnalyticsListener.notifyEventReceiver(crashlyticsOriginEventReceiver, string, bundle2);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorListener
    public void onMessageTriggered(int i, Bundle bundle2) {
        Object logger;
        Bundle obj6;
        Object[] arr = new Object[2];
        Logger.getLogger().v(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i), bundle2));
        if (bundle2 == null) {
        }
        String obj5 = bundle2.getString("name");
        if (obj5 != null && bundle2.getBundle("params") == null) {
            if (bundle2.getBundle("params") == null) {
                obj6 = new Bundle();
            }
            notifyEventReceivers(obj5, obj6);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorListener
    public void setBreadcrumbEventReceiver(AnalyticsEventReceiver analyticsEventReceiver) {
        this.breadcrumbEventReceiver = analyticsEventReceiver;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorListener
    public void setCrashlyticsOriginEventReceiver(AnalyticsEventReceiver analyticsEventReceiver) {
        this.crashlyticsOriginEventReceiver = analyticsEventReceiver;
    }
}
