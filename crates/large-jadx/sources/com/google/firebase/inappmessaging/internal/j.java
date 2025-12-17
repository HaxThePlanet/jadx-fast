package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public final class j implements Runnable {

    public final com.google.firebase.inappmessaging.internal.DeveloperListenerManager.DismissExecutorAndListener a;
    public final InAppMessage b;
    public j(com.google.firebase.inappmessaging.internal.DeveloperListenerManager.DismissExecutorAndListener developerListenerManager$DismissExecutorAndListener, InAppMessage inAppMessage2) {
        super();
        this.a = dismissExecutorAndListener;
        this.b = inAppMessage2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeveloperListenerManager.d(this.a, this.b);
    }
}
