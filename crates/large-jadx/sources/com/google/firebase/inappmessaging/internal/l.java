package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public final class l implements Runnable {

    public final com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ImpressionExecutorAndListener a;
    public final InAppMessage b;
    public l(com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ImpressionExecutorAndListener developerListenerManager$ImpressionExecutorAndListener, InAppMessage inAppMessage2) {
        super();
        this.a = impressionExecutorAndListener;
        this.b = inAppMessage2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeveloperListenerManager.b(this.a, this.b);
    }
}
