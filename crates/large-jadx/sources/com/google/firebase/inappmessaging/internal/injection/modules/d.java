package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.MetricsLoggerClient.EngagementMetricsLoggerInterface;
import f.c.a.b.f;

/* loaded from: classes2.dex */
public final class d implements MetricsLoggerClient.EngagementMetricsLoggerInterface {

    public final f a;
    public d(f f) {
        super();
        this.a = f;
    }

    @Override // com.google.firebase.inappmessaging.internal.MetricsLoggerClient$EngagementMetricsLoggerInterface
    public final void logEvent(byte[] bArr) {
        TransportClientModule.b(this.a, bArr);
    }
}
