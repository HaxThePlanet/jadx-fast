package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import i.b.a;
import i.b.g;
import i.b.h;
import i.b.i;
import i.b.k0.a;

/* loaded from: classes2.dex */
@Module
public class ProgrammaticContextualTriggerFlowableModule {

    private ProgramaticContextualTriggers triggers;
    public ProgrammaticContextualTriggerFlowableModule(ProgramaticContextualTriggers programaticContextualTriggers) {
        super();
        this.triggers = programaticContextualTriggers;
    }

    static void a(i i, String string2) {
        i.onNext(string2);
    }

    private void b(i i) {
        b bVar = new b(i);
        this.triggers.setListener(bVar);
    }

    public void c(i i) {
        b(i);
    }

    @Provides
    @ProgrammaticTrigger
    public a<String> providesProgramaticContextualTriggerStream() {
        a aVar = new a(this);
        a aVar2 = h.h(aVar, a.BUFFER).L();
        aVar2.g0();
        return aVar2;
    }

    @Provides
    @ProgrammaticTrigger
    public ProgramaticContextualTriggers providesProgramaticContextualTriggers() {
        return this.triggers;
    }
}
