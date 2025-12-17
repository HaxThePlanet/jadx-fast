package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;

/* loaded from: classes2.dex */
public final class ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory implements Factory<ProgramaticContextualTriggers> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule module;
    public ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory(com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        super();
        this.module = programmaticContextualTriggerFlowableModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory programmaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory = new ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory(programmaticContextualTriggerFlowableModule);
        return programmaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory;
    }

    public static ProgramaticContextualTriggers providesProgramaticContextualTriggers(com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return (ProgramaticContextualTriggers)Preconditions.checkNotNull(programmaticContextualTriggerFlowableModule.providesProgramaticContextualTriggers(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public ProgramaticContextualTriggers get() {
        return ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory.providesProgramaticContextualTriggers(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
