package zendesk.answerbot;

import g.b.b;
import g.b.d;
import zendesk.messaging.Update;
import zendesk.messaging.components.CompositeActionListener;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_ProvideUpdateCompositeActionListenerFactory implements b<CompositeActionListener<Update>> {

    private final zendesk.answerbot.AnswerBotConversationModule module;
    public AnswerBotConversationModule_ProvideUpdateCompositeActionListenerFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        super();
        this.module = answerBotConversationModule;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_ProvideUpdateCompositeActionListenerFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        AnswerBotConversationModule_ProvideUpdateCompositeActionListenerFactory answerBotConversationModule_ProvideUpdateCompositeActionListenerFactory = new AnswerBotConversationModule_ProvideUpdateCompositeActionListenerFactory(answerBotConversationModule);
        return answerBotConversationModule_ProvideUpdateCompositeActionListenerFactory;
    }

    public static CompositeActionListener<Update> provideUpdateCompositeActionListener(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule) {
        final CompositeActionListener obj1 = answerBotConversationModule.provideUpdateCompositeActionListener();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (CompositeActionListener)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public CompositeActionListener<Update> get() {
        return AnswerBotConversationModule_ProvideUpdateCompositeActionListenerFactory.provideUpdateCompositeActionListener(this.module);
    }
}
