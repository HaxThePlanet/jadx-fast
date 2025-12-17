package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason;
import i.b.l0.a;

/* loaded from: classes2.dex */
public final class s implements a {

    public final com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl a;
    public final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason b;
    public s(com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason2) {
        super();
        this.a = displayCallbacksImpl;
        this.b = inAppMessagingErrorReason2;
    }

    @Override // i.b.l0.a
    public final void run() {
        this.a.b(this.b);
    }
}
