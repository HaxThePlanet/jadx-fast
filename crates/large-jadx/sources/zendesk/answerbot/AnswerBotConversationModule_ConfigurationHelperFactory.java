package zendesk.answerbot;

import g.b.b;
import g.b.d;
import o.a.b;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_ConfigurationHelperFactory implements b<b> {

    private final zendesk.answerbot.AnswerBotConversationModule module;
    public AnswerBotConversationModule_ConfigurationHelperFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        super();
        this.module = answerBotConversationModule;
    }

    public static b configurationHelper(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        final b obj1 = answerBotConversationModule.configurationHelper();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (b)obj1;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_ConfigurationHelperFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        AnswerBotConversationModule_ConfigurationHelperFactory answerBotConversationModule_ConfigurationHelperFactory = new AnswerBotConversationModule_ConfigurationHelperFactory(answerBotConversationModule);
        return answerBotConversationModule_ConfigurationHelperFactory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public b get() {
        return AnswerBotConversationModule_ConfigurationHelperFactory.configurationHelper(this.module);
    }
}
