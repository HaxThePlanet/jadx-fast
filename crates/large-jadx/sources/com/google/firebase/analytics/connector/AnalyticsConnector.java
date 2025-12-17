package com.google.firebase.analytics.connector;

import android.os.Bundle;
import com.google.firebase.annotations.DeferredApi;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public interface AnalyticsConnector {

    public interface AnalyticsConnectorHandle {
        public abstract void registerEventNames(Set<String> set);

        public abstract void unregister();

        public abstract void unregisterEventNames();
    }

    public interface AnalyticsConnectorListener {
        public abstract void onMessageTriggered(int i, Bundle bundle2);
    }

    public static class ConditionalUserProperty {

        public boolean active;
        public long creationTimestamp;
        public String expiredEventName;
        public Bundle expiredEventParams;
        public String name;
        public String origin;
        public long timeToLive;
        public String timedOutEventName;
        public Bundle timedOutEventParams;
        public String triggerEventName;
        public long triggerTimeout;
        public String triggeredEventName;
        public Bundle triggeredEventParams;
        public long triggeredTimestamp;
        public Object value;
    }
    public abstract void clearConditionalUserProperty(String string, String string2, Bundle bundle3);

    public abstract List<com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String string, String string2);

    public abstract int getMaxUserProperties(String string);

    public abstract Map<String, Object> getUserProperties(boolean z);

    public abstract void logEvent(String string, String string2, Bundle bundle3);

    public abstract com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(String string, com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener analyticsConnector$AnalyticsConnectorListener2);

    public abstract void setConditionalUserProperty(com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty analyticsConnector$ConditionalUserProperty);

    public abstract void setUserProperty(String string, String string2, Object object3);
}
