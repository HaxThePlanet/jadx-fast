package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import i.b.k0.a;

/* loaded from: classes2.dex */
public final class ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory implements Factory<a<String>> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule module;
    public ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory(com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        super();
        this.module = programmaticContextualTriggerFlowableModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory create(com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory programmaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory = new ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory(programmaticContextualTriggerFlowableModule);
        return programmaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory;
    }

    public static a<String> providesProgramaticContextualTriggerStream(com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return (a)Preconditions.checkNotNull(programmaticContextualTriggerFlowableModule.providesProgramaticContextualTriggerStream(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public a<String> get() {
        return ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory.providesProgramaticContextualTriggerStream(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
