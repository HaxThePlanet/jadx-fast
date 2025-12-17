package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType;
import i.b.l0.a;

/* loaded from: classes2.dex */
public final class v implements a {

    public final com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl a;
    public final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType b;
    public v(com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl displayCallbacksImpl, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType firebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType2) {
        super();
        this.a = displayCallbacksImpl;
        this.b = inAppMessagingDismissType2;
    }

    @Override // i.b.l0.a
    public final void run() {
        this.a.n(this.b);
    }
}
