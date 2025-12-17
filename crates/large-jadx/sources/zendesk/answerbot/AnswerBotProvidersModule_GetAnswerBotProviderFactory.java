package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.support.HelpCenterProvider;

/* loaded from: classes3.dex */
public final class AnswerBotProvidersModule_GetAnswerBotProviderFactory implements b<zendesk.answerbot.AnswerBotProvider> {

    private final a<zendesk.answerbot.AnswerBotService> answerBotServiceProvider;
    private final a<HelpCenterProvider> helpCenterProvider;
    private final a<zendesk.answerbot.LocaleProvider> localeProvider;
    private final zendesk.answerbot.AnswerBotProvidersModule module;
    private final a<zendesk.answerbot.AnswerBotSettingsProvider> settingsProvider;
    public AnswerBotProvidersModule_GetAnswerBotProviderFactory(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, a<zendesk.answerbot.AnswerBotService> a2, a<zendesk.answerbot.LocaleProvider> a3, a<HelpCenterProvider> a4, a<zendesk.answerbot.AnswerBotSettingsProvider> a5) {
        super();
        this.module = answerBotProvidersModule;
        this.answerBotServiceProvider = a2;
        this.localeProvider = a3;
        this.helpCenterProvider = a4;
        this.settingsProvider = a5;
    }

    public static zendesk.answerbot.AnswerBotProvidersModule_GetAnswerBotProviderFactory create(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, a<zendesk.answerbot.AnswerBotService> a2, a<zendesk.answerbot.LocaleProvider> a3, a<HelpCenterProvider> a4, a<zendesk.answerbot.AnswerBotSettingsProvider> a5) {
        super(answerBotProvidersModule, a2, a3, a4, a5);
        return answerBotProvidersModule_GetAnswerBotProviderFactory;
    }

    public static zendesk.answerbot.AnswerBotProvider getAnswerBotProvider(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, Object object2, Object object3, HelpCenterProvider helpCenterProvider4, Object object5) {
        final zendesk.answerbot.AnswerBotProvider obj0 = answerBotProvidersModule.getAnswerBotProvider((AnswerBotService)object2, (LocaleProvider)object3, helpCenterProvider4, (AnswerBotSettingsProvider)object5);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (AnswerBotProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.AnswerBotProvider get() {
        return AnswerBotProvidersModule_GetAnswerBotProviderFactory.getAnswerBotProvider(this.module, this.answerBotServiceProvider.get(), this.localeProvider.get(), (HelpCenterProvider)this.helpCenterProvider.get(), this.settingsProvider.get());
    }
}
