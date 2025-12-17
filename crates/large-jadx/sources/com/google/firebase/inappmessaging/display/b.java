package com.google.firebase.inappmessaging.display;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class b implements ComponentFactory {

    public final com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplayRegistrar a;
    public b(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplayRegistrar firebaseInAppMessagingDisplayRegistrar) {
        super();
        this.a = firebaseInAppMessagingDisplayRegistrar;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return FirebaseInAppMessagingDisplayRegistrar.a(this.a, componentContainer);
    }
}
