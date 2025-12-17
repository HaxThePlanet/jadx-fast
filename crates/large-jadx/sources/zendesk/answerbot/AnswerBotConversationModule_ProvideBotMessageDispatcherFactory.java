package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.messaging.Update;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.Timer.Factory;
import zendesk.messaging.components.bot.BotMessageDispatcher;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;
import zendesk.messaging.components.bot.BotMessageDispatcher.MessageIdentifier;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_ProvideBotMessageDispatcherFactory implements b<BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction>> {

    private final a<BotMessageDispatcher.MessageIdentifier<zendesk.answerbot.AnswerBotInteraction>> messageIdentifierProvider;
    private final zendesk.answerbot.AnswerBotConversationModule module;
    private final a<ActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> stateActionListenerProvider;
    private final a<Timer.Factory> timerFactoryProvider;
    private final a<ActionListener<Update>> updateActionListenerProvider;
    public AnswerBotConversationModule_ProvideBotMessageDispatcherFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<BotMessageDispatcher.MessageIdentifier<zendesk.answerbot.AnswerBotInteraction>> a2, a<ActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> a3, a<ActionListener<Update>> a4, a<Timer.Factory> a5) {
        super();
        this.module = answerBotConversationModule;
        this.messageIdentifierProvider = a2;
        this.stateActionListenerProvider = a3;
        this.updateActionListenerProvider = a4;
        this.timerFactoryProvider = a5;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_ProvideBotMessageDispatcherFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<BotMessageDispatcher.MessageIdentifier<zendesk.answerbot.AnswerBotInteraction>> a2, a<ActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> a3, a<ActionListener<Update>> a4, a<Timer.Factory> a5) {
        super(answerBotConversationModule, a2, a3, a4, a5);
        return answerBotConversationModule_ProvideBotMessageDispatcherFactory;
    }

    public static BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction> provideBotMessageDispatcher(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, BotMessageDispatcher.MessageIdentifier<zendesk.answerbot.AnswerBotInteraction> botMessageDispatcher$MessageIdentifier2, ActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> actionListener3, ActionListener<Update> actionListener4, Timer.Factory timer$Factory5) {
        final BotMessageDispatcher obj0 = answerBotConversationModule.provideBotMessageDispatcher(messageIdentifier2, actionListener3, actionListener4, factory5);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (BotMessageDispatcher)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction> get() {
        return AnswerBotConversationModule_ProvideBotMessageDispatcherFactory.provideBotMessageDispatcher(this.module, (BotMessageDispatcher.MessageIdentifier)this.messageIdentifierProvider.get(), (ActionListener)this.stateActionListenerProvider.get(), (ActionListener)this.updateActionListenerProvider.get(), (Timer.Factory)this.timerFactoryProvider.get());
    }
}
