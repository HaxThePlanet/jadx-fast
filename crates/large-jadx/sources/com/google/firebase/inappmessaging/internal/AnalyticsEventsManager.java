package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle;
import com.google.firebase.inappmessaging.CommonTypesProto.Event;
import com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition;
import f.c.f.a.a.a.c;
import f.c.f.a.a.a.e.e;
import i.b.a;
import i.b.h;
import i.b.i;
import i.b.j;
import i.b.k0.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class AnalyticsEventsManager {

    static final String TOO_MANY_CONTEXTUAL_TRIGGERS_ERROR = "Too many contextual triggers defined - limiting to 50";
    private final AnalyticsConnector analyticsConnector;
    private final a<String> flowable;
    private AnalyticsConnector.AnalyticsConnectorHandle handle;

    private class AnalyticsFlowableSubscriber implements j<String> {

        final com.google.firebase.inappmessaging.internal.AnalyticsEventsManager this$0;
        AnalyticsFlowableSubscriber(com.google.firebase.inappmessaging.internal.AnalyticsEventsManager analyticsEventsManager) {
            this.this$0 = analyticsEventsManager;
            super();
        }

        public void subscribe(i<String> i) {
            Logging.logd("Subscribing to analytics events.");
            com.google.firebase.inappmessaging.internal.AnalyticsEventsManager this$0 = this.this$0;
            FiamAnalyticsConnectorListener fiamAnalyticsConnectorListener = new FiamAnalyticsConnectorListener(i);
            AnalyticsEventsManager.access$002(this$0, AnalyticsEventsManager.access$100(this$0).registerAnalyticsConnectorListener("fiam", fiamAnalyticsConnectorListener));
        }
    }
    public AnalyticsEventsManager(AnalyticsConnector analyticsConnector) {
        super();
        this.analyticsConnector = analyticsConnector;
        AnalyticsEventsManager.AnalyticsFlowableSubscriber obj2 = new AnalyticsEventsManager.AnalyticsFlowableSubscriber(this);
        obj2 = h.h(obj2, a.BUFFER).L();
        this.flowable = obj2;
        obj2.g0();
    }

    static AnalyticsConnector.AnalyticsConnectorHandle access$002(com.google.firebase.inappmessaging.internal.AnalyticsEventsManager analyticsEventsManager, AnalyticsConnector.AnalyticsConnectorHandle analyticsConnector$AnalyticsConnectorHandle2) {
        analyticsEventsManager.handle = analyticsConnectorHandle2;
        return analyticsConnectorHandle2;
    }

    static AnalyticsConnector access$100(com.google.firebase.inappmessaging.internal.AnalyticsEventsManager analyticsEventsManager) {
        return analyticsEventsManager.analyticsConnector;
    }

    static Set<String> extractAnalyticsEventNames(e e) {
        Iterator iterator;
        boolean next;
        boolean empty;
        int obj4;
        HashSet hashSet = new HashSet();
        obj4 = e.f().iterator();
        for (c next3 : obj4) {
            iterator = next3.h().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (!TextUtils.isEmpty((CommonTypesProto.TriggeringCondition)next.getEvent().getName())) {
                }
                hashSet.add(next.getEvent().getName());
            }
            next = iterator.next();
            if (!TextUtils.isEmpty((CommonTypesProto.TriggeringCondition)next.getEvent().getName())) {
            }
            hashSet.add(next.getEvent().getName());
        }
        if (hashSet.size() > 50) {
            Logging.logi("Too many contextual triggers defined - limiting to 50");
        }
        return hashSet;
    }

    public a<String> getAnalyticsEventsFlowable() {
        return this.flowable;
    }

    public AnalyticsConnector.AnalyticsConnectorHandle getHandle() {
        return this.handle;
    }

    public void updateContextualTriggers(e e) {
        final Set obj3 = AnalyticsEventsManager.extractAnalyticsEventNames(e);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Updating contextual triggers for the following analytics events: ");
        stringBuilder.append(obj3);
        Logging.logd(stringBuilder.toString());
        this.handle.registerEventNames(obj3);
    }
}
