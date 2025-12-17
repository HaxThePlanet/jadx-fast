package zendesk.answerbot;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_GetAnswerBotCellFactoryFactory implements b<zendesk.answerbot.AnswerBotCellFactory> {

    private final zendesk.answerbot.AnswerBotConversationModule module;
    public AnswerBotConversationModule_GetAnswerBotCellFactoryFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        super();
        this.module = answerBotConversationModule;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_GetAnswerBotCellFactoryFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        AnswerBotConversationModule_GetAnswerBotCellFactoryFactory answerBotConversationModule_GetAnswerBotCellFactoryFactory = new AnswerBotConversationModule_GetAnswerBotCellFactoryFactory(answerBotConversationModule);
        return answerBotConversationModule_GetAnswerBotCellFactoryFactory;
    }

    public static zendesk.answerbot.AnswerBotCellFactory getAnswerBotCellFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        final zendesk.answerbot.AnswerBotCellFactory obj1 = answerBotConversationModule.getAnswerBotCellFactory();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (AnswerBotCellFactory)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.AnswerBotCellFactory get() {
        return AnswerBotConversationModule_GetAnswerBotCellFactoryFactory.getAnswerBotCellFactory(this.module);
    }
}
