package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;

/* loaded from: classes3.dex */
public final class SupportEngineModule_StateActionListenerFactory implements b<ActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> {

    private final zendesk.support.SupportEngineModule module;
    private final a<CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> observerProvider;
    public SupportEngineModule_StateActionListenerFactory(zendesk.support.SupportEngineModule supportEngineModule, a<CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> a2) {
        super();
        this.module = supportEngineModule;
        this.observerProvider = a2;
    }

    public static zendesk.support.SupportEngineModule_StateActionListenerFactory create(zendesk.support.SupportEngineModule supportEngineModule, a<CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> a2) {
        SupportEngineModule_StateActionListenerFactory supportEngineModule_StateActionListenerFactory = new SupportEngineModule_StateActionListenerFactory(supportEngineModule, a2);
        return supportEngineModule_StateActionListenerFactory;
    }

    public static ActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> stateActionListener(zendesk.support.SupportEngineModule supportEngineModule, CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> compositeActionListener2) {
        final ActionListener obj0 = supportEngineModule.stateActionListener(compositeActionListener2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ActionListener)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public ActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> get() {
        return SupportEngineModule_StateActionListenerFactory.stateActionListener(this.module, (CompositeActionListener)this.observerProvider.get());
    }
}
