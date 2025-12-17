package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    public final com.google.firebase.inappmessaging.internal.AbtIntegrationHelper a;
    public final ExperimentPayloadProto.ExperimentPayload b;
    public c(com.google.firebase.inappmessaging.internal.AbtIntegrationHelper abtIntegrationHelper, ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload2) {
        super();
        this.a = abtIntegrationHelper;
        this.b = experimentPayload2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
