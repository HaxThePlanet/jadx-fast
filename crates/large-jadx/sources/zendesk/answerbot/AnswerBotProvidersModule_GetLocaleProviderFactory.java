package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.SettingsProvider;

/* loaded from: classes3.dex */
public final class AnswerBotProvidersModule_GetLocaleProviderFactory implements b<zendesk.answerbot.LocaleProvider> {

    private final zendesk.answerbot.AnswerBotProvidersModule module;
    private final a<SettingsProvider> settingsProvider;
    public AnswerBotProvidersModule_GetLocaleProviderFactory(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, a<SettingsProvider> a2) {
        super();
        this.module = answerBotProvidersModule;
        this.settingsProvider = a2;
    }

    public static zendesk.answerbot.AnswerBotProvidersModule_GetLocaleProviderFactory create(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, a<SettingsProvider> a2) {
        AnswerBotProvidersModule_GetLocaleProviderFactory answerBotProvidersModule_GetLocaleProviderFactory = new AnswerBotProvidersModule_GetLocaleProviderFactory(answerBotProvidersModule, a2);
        return answerBotProvidersModule_GetLocaleProviderFactory;
    }

    public static zendesk.answerbot.LocaleProvider getLocaleProvider(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, SettingsProvider settingsProvider2) {
        final zendesk.answerbot.LocaleProvider obj0 = answerBotProvidersModule.getLocaleProvider(settingsProvider2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (LocaleProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.LocaleProvider get() {
        return AnswerBotProvidersModule_GetLocaleProviderFactory.getLocaleProvider(this.module, (SettingsProvider)this.settingsProvider.get());
    }
}
