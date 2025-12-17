package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.g;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public final class q1 implements g {

    public final com.google.firebase.inappmessaging.internal.MetricsLoggerClient a;
    public final InAppMessage b;
    public final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType c;
    public q1(com.google.firebase.inappmessaging.internal.MetricsLoggerClient metricsLoggerClient, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType firebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType3) {
        super();
        this.a = metricsLoggerClient;
        this.b = inAppMessage2;
        this.c = inAppMessagingDismissType3;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.a.b(this.b, this.c, (String)object);
    }
}
