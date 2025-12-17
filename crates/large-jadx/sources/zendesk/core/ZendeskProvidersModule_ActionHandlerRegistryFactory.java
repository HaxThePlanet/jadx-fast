package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ActionHandlerRegistryFactory implements b<zendesk.core.ActionHandlerRegistry> {

    private static final zendesk.core.ZendeskProvidersModule_ActionHandlerRegistryFactory INSTANCE;
    static {
        ZendeskProvidersModule_ActionHandlerRegistryFactory zendeskProvidersModule_ActionHandlerRegistryFactory = new ZendeskProvidersModule_ActionHandlerRegistryFactory();
        ZendeskProvidersModule_ActionHandlerRegistryFactory.INSTANCE = zendeskProvidersModule_ActionHandlerRegistryFactory;
    }

    public static zendesk.core.ActionHandlerRegistry actionHandlerRegistry() {
        final zendesk.core.ActionHandlerRegistry actionHandlerRegistry = ZendeskProvidersModule.actionHandlerRegistry();
        d.c(actionHandlerRegistry, "Cannot return null from a non-@Nullable @Provides method");
        return (ActionHandlerRegistry)actionHandlerRegistry;
    }

    public static zendesk.core.ZendeskProvidersModule_ActionHandlerRegistryFactory create() {
        return ZendeskProvidersModule_ActionHandlerRegistryFactory.INSTANCE;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ActionHandlerRegistry get() {
        return ZendeskProvidersModule_ActionHandlerRegistryFactory.actionHandlerRegistry();
    }
}
