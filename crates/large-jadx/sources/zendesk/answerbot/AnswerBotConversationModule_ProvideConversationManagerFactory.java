package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.messaging.components.DateProvider;
import zendesk.messaging.components.bot.BotMessageDispatcher;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_ProvideConversationManagerFactory implements b<zendesk.answerbot.AnswerBotConversationManager> {

    private final a<BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction>> botMessageDispatcherProvider;
    private final a<DateProvider> dateProvider;
    private final zendesk.answerbot.AnswerBotConversationModule module;
    public AnswerBotConversationModule_ProvideConversationManagerFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction>> a2, a<DateProvider> a3) {
        super();
        this.module = answerBotConversationModule;
        this.botMessageDispatcherProvider = a2;
        this.dateProvider = a3;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_ProvideConversationManagerFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction>> a2, a<DateProvider> a3) {
        AnswerBotConversationModule_ProvideConversationManagerFactory answerBotConversationModule_ProvideConversationManagerFactory = new AnswerBotConversationModule_ProvideConversationManagerFactory(answerBotConversationModule, a2, a3);
        return answerBotConversationModule_ProvideConversationManagerFactory;
    }

    public static zendesk.answerbot.AnswerBotConversationManager provideConversationManager(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction> botMessageDispatcher2, DateProvider dateProvider3) {
        final zendesk.answerbot.AnswerBotConversationManager obj0 = answerBotConversationModule.provideConversationManager(botMessageDispatcher2, dateProvider3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (AnswerBotConversationManager)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.AnswerBotConversationManager get() {
        return AnswerBotConversationModule_ProvideConversationManagerFactory.provideConversationManager(this.module, (BotMessageDispatcher)this.botMessageDispatcherProvider.get(), (DateProvider)this.dateProvider.get());
    }
}
