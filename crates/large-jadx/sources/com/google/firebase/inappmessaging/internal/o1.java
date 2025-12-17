package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.g;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public final class o1 implements g {

    public final com.google.firebase.inappmessaging.internal.MetricsLoggerClient a;
    public final InAppMessage b;
    public final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason c;
    public o1(com.google.firebase.inappmessaging.internal.MetricsLoggerClient metricsLoggerClient, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason3) {
        super();
        this.a = metricsLoggerClient;
        this.b = inAppMessage2;
        this.c = inAppMessagingErrorReason3;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.a.h(this.b, this.c, (String)object);
    }
}
