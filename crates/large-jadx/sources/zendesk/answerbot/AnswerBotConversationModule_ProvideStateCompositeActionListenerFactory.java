package zendesk.answerbot;

import g.b.b;
import g.b.d;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_ProvideStateCompositeActionListenerFactory implements b<CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> {

    private final zendesk.answerbot.AnswerBotConversationModule module;
    public AnswerBotConversationModule_ProvideStateCompositeActionListenerFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        super();
        this.module = answerBotConversationModule;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_ProvideStateCompositeActionListenerFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        AnswerBotConversationModule_ProvideStateCompositeActionListenerFactory answerBotConversationModule_ProvideStateCompositeActionListenerFactory = new AnswerBotConversationModule_ProvideStateCompositeActionListenerFactory(answerBotConversationModule);
        return answerBotConversationModule_ProvideStateCompositeActionListenerFactory;
    }

    public static CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> provideStateCompositeActionListener(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        final CompositeActionListener obj1 = answerBotConversationModule.provideStateCompositeActionListener();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (CompositeActionListener)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> get() {
        return AnswerBotConversationModule_ProvideStateCompositeActionListenerFactory.provideStateCompositeActionListener(this.module);
    }
}
