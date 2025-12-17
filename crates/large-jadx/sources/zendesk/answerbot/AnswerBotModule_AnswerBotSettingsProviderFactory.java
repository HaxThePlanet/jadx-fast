package zendesk.answerbot;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class AnswerBotModule_AnswerBotSettingsProviderFactory implements b<zendesk.answerbot.AnswerBotSettingsProvider> {

    private final zendesk.answerbot.AnswerBotModule module;
    public AnswerBotModule_AnswerBotSettingsProviderFactory(zendesk.answerbot.AnswerBotModule answerBotModule) {
        super();
        this.module = answerBotModule;
    }

    public static zendesk.answerbot.AnswerBotSettingsProvider answerBotSettingsProvider(zendesk.answerbot.AnswerBotModule answerBotModule) {
        final zendesk.answerbot.AnswerBotSettingsProvider obj1 = answerBotModule.answerBotSettingsProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (AnswerBotSettingsProvider)obj1;
    }

    public static zendesk.answerbot.AnswerBotModule_AnswerBotSettingsProviderFactory create(zendesk.answerbot.AnswerBotModule answerBotModule) {
        AnswerBotModule_AnswerBotSettingsProviderFactory answerBotModule_AnswerBotSettingsProviderFactory = new AnswerBotModule_AnswerBotSettingsProviderFactory(answerBotModule);
        return answerBotModule_AnswerBotSettingsProviderFactory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.AnswerBotSettingsProvider get() {
        return AnswerBotModule_AnswerBotSettingsProviderFactory.answerBotSettingsProvider(this.module);
    }
}
