package zendesk.answerbot;

import g.b.b;
import g.b.d;
import zendesk.messaging.components.DateProvider;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_ProvideDateProviderFactory implements b<DateProvider> {

    private final zendesk.answerbot.AnswerBotConversationModule module;
    public AnswerBotConversationModule_ProvideDateProviderFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        super();
        this.module = answerBotConversationModule;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_ProvideDateProviderFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        AnswerBotConversationModule_ProvideDateProviderFactory answerBotConversationModule_ProvideDateProviderFactory = new AnswerBotConversationModule_ProvideDateProviderFactory(answerBotConversationModule);
        return answerBotConversationModule_ProvideDateProviderFactory;
    }

    public static DateProvider provideDateProvider(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        final DateProvider obj1 = answerBotConversationModule.provideDateProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (DateProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public DateProvider get() {
        return AnswerBotConversationModule_ProvideDateProviderFactory.provideDateProvider(this.module);
    }
}
