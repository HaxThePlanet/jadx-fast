package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class d implements ComponentFactory {

    public final com.google.firebase.crashlytics.CrashlyticsRegistrar a;
    public d(com.google.firebase.crashlytics.CrashlyticsRegistrar crashlyticsRegistrar) {
        super();
        this.a = crashlyticsRegistrar;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return CrashlyticsRegistrar.a(this.a, componentContainer);
    }
}
