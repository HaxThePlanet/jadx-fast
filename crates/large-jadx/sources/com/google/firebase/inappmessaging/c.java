package com.google.firebase.inappmessaging;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class c implements ComponentFactory {

    public final com.google.firebase.inappmessaging.FirebaseInAppMessagingRegistrar a;
    public c(com.google.firebase.inappmessaging.FirebaseInAppMessagingRegistrar firebaseInAppMessagingRegistrar) {
        super();
        this.a = firebaseInAppMessagingRegistrar;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return FirebaseInAppMessagingRegistrar.a(this.a, componentContainer);
    }
}
