package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.g;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public final class n1 implements g {

    public final com.google.firebase.inappmessaging.internal.MetricsLoggerClient a;
    public final InAppMessage b;
    public n1(com.google.firebase.inappmessaging.internal.MetricsLoggerClient metricsLoggerClient, InAppMessage inAppMessage2) {
        super();
        this.a = metricsLoggerClient;
        this.b = inAppMessage2;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.a.f(this.b, (String)object);
    }
}
