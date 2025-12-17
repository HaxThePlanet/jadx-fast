package zendesk.support;

import g.b.b;
import g.b.d;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.components.bot.BotMessageDispatcher.MessageIdentifier;

/* loaded from: classes3.dex */
public final class SupportEngineModule_InteractionIdentifierFactory implements b<BotMessageDispatcher.MessageIdentifier<MessagingItem>> {

    private final zendesk.support.SupportEngineModule module;
    public SupportEngineModule_InteractionIdentifierFactory(zendesk.support.SupportEngineModule supportEngineModule) {
        super();
        this.module = supportEngineModule;
    }

    public static zendesk.support.SupportEngineModule_InteractionIdentifierFactory create(zendesk.support.SupportEngineModule supportEngineModule) {
        SupportEngineModule_InteractionIdentifierFactory supportEngineModule_InteractionIdentifierFactory = new SupportEngineModule_InteractionIdentifierFactory(supportEngineModule);
        return supportEngineModule_InteractionIdentifierFactory;
    }

    public static BotMessageDispatcher.MessageIdentifier<MessagingItem> interactionIdentifier(zendesk.support.SupportEngineModule supportEngineModule) {
        final BotMessageDispatcher.MessageIdentifier obj1 = supportEngineModule.interactionIdentifier();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (BotMessageDispatcher.MessageIdentifier)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public BotMessageDispatcher.MessageIdentifier<MessagingItem> get() {
        return SupportEngineModule_InteractionIdentifierFactory.interactionIdentifier(this.module);
    }
}
