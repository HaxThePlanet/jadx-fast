package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import i.b.g;
import i.b.i;

/* loaded from: classes2.dex */
final class FiamAnalyticsConnectorListener implements AnalyticsConnector.AnalyticsConnectorListener {

    private i<String> emitter;
    FiamAnalyticsConnectorListener(i<String> i) {
        super();
        this.emitter = i;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorListener
    public void onMessageTriggered(int i, Bundle bundle2) {
        int str;
        int obj2;
        String obj3;
        if (i == 2) {
            this.emitter.onNext(bundle2.getString("events"));
        }
    }
}
