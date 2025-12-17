package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.messaging.Update;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.CompositeActionListener;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_ProvideUpdateActionListenerFactory implements b<ActionListener<Update>> {

    private final zendesk.answerbot.AnswerBotConversationModule module;
    private final a<CompositeActionListener<Update>> observerProvider;
    public AnswerBotConversationModule_ProvideUpdateActionListenerFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<CompositeActionListener<Update>> a2) {
        super();
        this.module = answerBotConversationModule;
        this.observerProvider = a2;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_ProvideUpdateActionListenerFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<CompositeActionListener<Update>> a2) {
        AnswerBotConversationModule_ProvideUpdateActionListenerFactory answerBotConversationModule_ProvideUpdateActionListenerFactory = new AnswerBotConversationModule_ProvideUpdateActionListenerFactory(answerBotConversationModule, a2);
        return answerBotConversationModule_ProvideUpdateActionListenerFactory;
    }

    public static ActionListener<Update> provideUpdateActionListener(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, CompositeActionListener<Update> compositeActionListener2) {
        final ActionListener obj0 = answerBotConversationModule.provideUpdateActionListener(compositeActionListener2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ActionListener)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public ActionListener<Update> get() {
        return AnswerBotConversationModule_ProvideUpdateActionListenerFactory.provideUpdateActionListener(this.module, (CompositeActionListener)this.observerProvider.get());
    }
}
