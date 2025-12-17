package zendesk.answerbot;

import g.b.b;
import g.b.d;
import zendesk.messaging.components.bot.BotMessageDispatcher.MessageIdentifier;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_ProvideInteractionIdentifierFactory implements b<BotMessageDispatcher.MessageIdentifier<zendesk.answerbot.AnswerBotInteraction>> {

    private final zendesk.answerbot.AnswerBotConversationModule module;
    public AnswerBotConversationModule_ProvideInteractionIdentifierFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        super();
        this.module = answerBotConversationModule;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_ProvideInteractionIdentifierFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        AnswerBotConversationModule_ProvideInteractionIdentifierFactory answerBotConversationModule_ProvideInteractionIdentifierFactory = new AnswerBotConversationModule_ProvideInteractionIdentifierFactory(answerBotConversationModule);
        return answerBotConversationModule_ProvideInteractionIdentifierFactory;
    }

    public static BotMessageDispatcher.MessageIdentifier<zendesk.answerbot.AnswerBotInteraction> provideInteractionIdentifier(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        final BotMessageDispatcher.MessageIdentifier obj1 = answerBotConversationModule.provideInteractionIdentifier();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (BotMessageDispatcher.MessageIdentifier)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public BotMessageDispatcher.MessageIdentifier<zendesk.answerbot.AnswerBotInteraction> get() {
        return AnswerBotConversationModule_ProvideInteractionIdentifierFactory.provideInteractionIdentifier(this.module);
    }
}
