package zendesk.support;

import g.b.b;
import g.b.d;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;

/* loaded from: classes3.dex */
public final class SupportEngineModule_StateCompositeActionListenerFactory implements b<CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> {

    private final zendesk.support.SupportEngineModule module;
    public SupportEngineModule_StateCompositeActionListenerFactory(zendesk.support.SupportEngineModule supportEngineModule) {
        super();
        this.module = supportEngineModule;
    }

    public static zendesk.support.SupportEngineModule_StateCompositeActionListenerFactory create(zendesk.support.SupportEngineModule supportEngineModule) {
        SupportEngineModule_StateCompositeActionListenerFactory supportEngineModule_StateCompositeActionListenerFactory = new SupportEngineModule_StateCompositeActionListenerFactory(supportEngineModule);
        return supportEngineModule_StateCompositeActionListenerFactory;
    }

    public static CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> stateCompositeActionListener(zendesk.support.SupportEngineModule supportEngineModule) {
        final CompositeActionListener obj1 = supportEngineModule.stateCompositeActionListener();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (CompositeActionListener)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> get() {
        return SupportEngineModule_StateCompositeActionListenerFactory.stateCompositeActionListener(this.module);
    }
}
