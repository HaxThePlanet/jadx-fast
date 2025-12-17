package com.google.firebase.inappmessaging.internal.injection.modules;

import i.b.i;
import i.b.j;

/* loaded from: classes2.dex */
public final class a implements j {

    public final com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule a;
    public a(com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        super();
        this.a = programmaticContextualTriggerFlowableModule;
    }

    @Override // i.b.j
    public final void subscribe(i i) {
        this.a.c(i);
    }
}
