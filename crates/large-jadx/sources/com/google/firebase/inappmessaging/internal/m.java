package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public final class m implements Runnable {

    public final com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ErrorsExecutorAndListener a;
    public final InAppMessage b;
    public final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason c;
    public m(com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ErrorsExecutorAndListener developerListenerManager$ErrorsExecutorAndListener, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason3) {
        super();
        this.a = errorsExecutorAndListener;
        this.b = inAppMessage2;
        this.c = inAppMessagingErrorReason3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeveloperListenerManager.a(this.a, this.b, this.c);
    }
}
