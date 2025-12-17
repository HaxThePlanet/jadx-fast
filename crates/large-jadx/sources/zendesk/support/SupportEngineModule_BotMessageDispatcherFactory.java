package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.Update;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.Timer.Factory;
import zendesk.messaging.components.bot.BotMessageDispatcher;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;
import zendesk.messaging.components.bot.BotMessageDispatcher.MessageIdentifier;

/* loaded from: classes3.dex */
public final class SupportEngineModule_BotMessageDispatcherFactory implements b<BotMessageDispatcher<MessagingItem>> {

    private final a<BotMessageDispatcher.MessageIdentifier<MessagingItem>> messageIdentifierProvider;
    private final zendesk.support.SupportEngineModule module;
    private final a<ActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> stateActionListenerProvider;
    private final a<Timer.Factory> timerFactoryProvider;
    private final a<ActionListener<Update>> updateActionListenerProvider;
    public SupportEngineModule_BotMessageDispatcherFactory(zendesk.support.SupportEngineModule supportEngineModule, a<BotMessageDispatcher.MessageIdentifier<MessagingItem>> a2, a<ActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> a3, a<ActionListener<Update>> a4, a<Timer.Factory> a5) {
        super();
        this.module = supportEngineModule;
        this.messageIdentifierProvider = a2;
        this.stateActionListenerProvider = a3;
        this.updateActionListenerProvider = a4;
        this.timerFactoryProvider = a5;
    }

    public static BotMessageDispatcher<MessagingItem> botMessageDispatcher(zendesk.support.SupportEngineModule supportEngineModule, BotMessageDispatcher.MessageIdentifier<MessagingItem> botMessageDispatcher$MessageIdentifier2, ActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> actionListener3, ActionListener<Update> actionListener4, Timer.Factory timer$Factory5) {
        final BotMessageDispatcher obj0 = supportEngineModule.botMessageDispatcher(messageIdentifier2, actionListener3, actionListener4, factory5);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (BotMessageDispatcher)obj0;
    }

    public static zendesk.support.SupportEngineModule_BotMessageDispatcherFactory create(zendesk.support.SupportEngineModule supportEngineModule, a<BotMessageDispatcher.MessageIdentifier<MessagingItem>> a2, a<ActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> a3, a<ActionListener<Update>> a4, a<Timer.Factory> a5) {
        super(supportEngineModule, a2, a3, a4, a5);
        return supportEngineModule_BotMessageDispatcherFactory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public BotMessageDispatcher<MessagingItem> get() {
        return SupportEngineModule_BotMessageDispatcherFactory.botMessageDispatcher(this.module, (BotMessageDispatcher.MessageIdentifier)this.messageIdentifierProvider.get(), (ActionListener)this.stateActionListenerProvider.get(), (ActionListener)this.updateActionListenerProvider.get(), (Timer.Factory)this.timerFactoryProvider.get());
    }
}
