package com.google.firebase.inappmessaging;

import i.b.l0.f;

/* loaded from: classes2.dex */
public final class a implements f {

    public final com.google.firebase.inappmessaging.FirebaseInAppMessaging a;
    public a(com.google.firebase.inappmessaging.FirebaseInAppMessaging firebaseInAppMessaging) {
        super();
        this.a = firebaseInAppMessaging;
    }

    @Override // i.b.l0.f
    public final void accept(Object object) {
        FirebaseInAppMessaging.a(this.a, (TriggeredInAppMessage)object);
    }
}
