package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class CoreModule_ActionHandlerRegistryFactory implements b<zendesk.core.ActionHandlerRegistry> {

    private final zendesk.core.CoreModule module;
    public CoreModule_ActionHandlerRegistryFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.ActionHandlerRegistry actionHandlerRegistry(zendesk.core.CoreModule coreModule) {
        final zendesk.core.ActionHandlerRegistry obj1 = coreModule.actionHandlerRegistry();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ActionHandlerRegistry)obj1;
    }

    public static zendesk.core.CoreModule_ActionHandlerRegistryFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_ActionHandlerRegistryFactory coreModule_ActionHandlerRegistryFactory = new CoreModule_ActionHandlerRegistryFactory(coreModule);
        return coreModule_ActionHandlerRegistryFactory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ActionHandlerRegistry get() {
        return CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.module);
    }
}
