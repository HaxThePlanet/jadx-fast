package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public final class k implements Runnable {

    public final com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ClicksExecutorAndListener a;
    public final InAppMessage b;
    public final Action c;
    public k(com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ClicksExecutorAndListener developerListenerManager$ClicksExecutorAndListener, InAppMessage inAppMessage2, Action action3) {
        super();
        this.a = clicksExecutorAndListener;
        this.b = inAppMessage2;
        this.c = action3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeveloperListenerManager.c(this.a, this.b, this.c);
    }
}
