package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_ProvideStateActionListenerFactory implements b<ActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> {

    private final zendesk.answerbot.AnswerBotConversationModule module;
    private final a<CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> observerProvider;
    public AnswerBotConversationModule_ProvideStateActionListenerFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> a2) {
        super();
        this.module = answerBotConversationModule;
        this.observerProvider = a2;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_ProvideStateActionListenerFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> a2) {
        AnswerBotConversationModule_ProvideStateActionListenerFactory answerBotConversationModule_ProvideStateActionListenerFactory = new AnswerBotConversationModule_ProvideStateActionListenerFactory(answerBotConversationModule, a2);
        return answerBotConversationModule_ProvideStateActionListenerFactory;
    }

    public static ActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> provideStateActionListener(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> compositeActionListener2) {
        final ActionListener obj0 = answerBotConversationModule.provideStateActionListener(compositeActionListener2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ActionListener)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public ActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> get() {
        return AnswerBotConversationModule_ProvideStateActionListenerFactory.provideStateActionListener(this.module, (CompositeActionListener)this.observerProvider.get());
    }
}
