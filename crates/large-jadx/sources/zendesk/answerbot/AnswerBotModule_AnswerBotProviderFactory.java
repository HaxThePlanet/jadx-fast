package zendesk.answerbot;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class AnswerBotModule_AnswerBotProviderFactory implements b<zendesk.answerbot.AnswerBotProvider> {

    private final zendesk.answerbot.AnswerBotModule module;
    public AnswerBotModule_AnswerBotProviderFactory(zendesk.answerbot.AnswerBotModule answerBotModule) {
        super();
        this.module = answerBotModule;
    }

    public static zendesk.answerbot.AnswerBotProvider answerBotProvider(zendesk.answerbot.AnswerBotModule answerBotModule) {
        final zendesk.answerbot.AnswerBotProvider obj1 = answerBotModule.answerBotProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (AnswerBotProvider)obj1;
    }

    public static zendesk.answerbot.AnswerBotModule_AnswerBotProviderFactory create(zendesk.answerbot.AnswerBotModule answerBotModule) {
        AnswerBotModule_AnswerBotProviderFactory answerBotModule_AnswerBotProviderFactory = new AnswerBotModule_AnswerBotProviderFactory(answerBotModule);
        return answerBotModule_AnswerBotProviderFactory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.AnswerBotProvider get() {
        return AnswerBotModule_AnswerBotProviderFactory.answerBotProvider(this.module);
    }
}
