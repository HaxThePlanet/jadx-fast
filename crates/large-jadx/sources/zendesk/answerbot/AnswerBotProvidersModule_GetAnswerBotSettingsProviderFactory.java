package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.SettingsProvider;

/* loaded from: classes3.dex */
public final class AnswerBotProvidersModule_GetAnswerBotSettingsProviderFactory implements b<zendesk.answerbot.AnswerBotSettingsProvider> {

    private final zendesk.answerbot.AnswerBotProvidersModule module;
    private final a<SettingsProvider> settingsProvider;
    public AnswerBotProvidersModule_GetAnswerBotSettingsProviderFactory(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, a<SettingsProvider> a2) {
        super();
        this.module = answerBotProvidersModule;
        this.settingsProvider = a2;
    }

    public static zendesk.answerbot.AnswerBotProvidersModule_GetAnswerBotSettingsProviderFactory create(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, a<SettingsProvider> a2) {
        AnswerBotProvidersModule_GetAnswerBotSettingsProviderFactory answerBotProvidersModule_GetAnswerBotSettingsProviderFactory = new AnswerBotProvidersModule_GetAnswerBotSettingsProviderFactory(answerBotProvidersModule, a2);
        return answerBotProvidersModule_GetAnswerBotSettingsProviderFactory;
    }

    public static zendesk.answerbot.AnswerBotSettingsProvider getAnswerBotSettingsProvider(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, SettingsProvider settingsProvider2) {
        final zendesk.answerbot.AnswerBotSettingsProvider obj0 = answerBotProvidersModule.getAnswerBotSettingsProvider(settingsProvider2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (AnswerBotSettingsProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.AnswerBotSettingsProvider get() {
        return AnswerBotProvidersModule_GetAnswerBotSettingsProviderFactory.getAnswerBotSettingsProvider(this.module, (SettingsProvider)this.settingsProvider.get());
    }
}
