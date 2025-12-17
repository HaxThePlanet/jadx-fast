package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers.Listener;
import i.b.i;

/* loaded from: classes2.dex */
public final class b implements ProgramaticContextualTriggers.Listener {

    public final i a;
    public b(i i) {
        super();
        this.a = i;
    }

    @Override // com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers$Listener
    public final void onEventTrigger(String string) {
        ProgrammaticContextualTriggerFlowableModule.a(this.a, string);
    }
}
