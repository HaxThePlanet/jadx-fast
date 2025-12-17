package zendesk.answerbot;

import g.b.a;
import g.b.d;
import j.a.a;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_GetRestServiceProviderFactory;
import zendesk.core.CoreModule_GetSettingsProviderFactory;
import zendesk.core.RestServiceProvider;
import zendesk.core.SettingsProvider;
import zendesk.support.HelpCenterProvider;

/* loaded from: classes3.dex */
final class DaggerAnswerBotProvidersComponent implements zendesk.answerbot.AnswerBotProvidersComponent {

    private a<zendesk.answerbot.AnswerBotProvider> getAnswerBotProvider;
    private a<zendesk.answerbot.AnswerBotService> getAnswerBotServiceProvider;
    private a<zendesk.answerbot.AnswerBotSettingsProvider> getAnswerBotSettingsProvider;
    private a<zendesk.answerbot.AnswerBotModule> getAnswerBotShadowProvider;
    private a<HelpCenterProvider> getHelpCenterProvider;
    private a<zendesk.answerbot.LocaleProvider> getLocaleProvider;
    private a<RestServiceProvider> getRestServiceProvider;
    private a<SettingsProvider> getSettingsProvider;

    static final class Builder {

        private zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule;
        private CoreModule coreModule;
        Builder(zendesk.answerbot.DaggerAnswerBotProvidersComponent.1 daggerAnswerBotProvidersComponent$1) {
            super();
        }

        public zendesk.answerbot.AnswerBotProvidersComponent build() {
            zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule;
            if (this.answerBotProvidersModule == null) {
                answerBotProvidersModule = new AnswerBotProvidersModule();
                this.answerBotProvidersModule = answerBotProvidersModule;
            }
            d.a(this.coreModule, CoreModule.class);
            DaggerAnswerBotProvidersComponent daggerAnswerBotProvidersComponent = new DaggerAnswerBotProvidersComponent(this.answerBotProvidersModule, this.coreModule, 0);
            return daggerAnswerBotProvidersComponent;
        }

        public zendesk.answerbot.DaggerAnswerBotProvidersComponent.Builder coreModule(CoreModule coreModule) {
            d.b(coreModule);
            this.coreModule = (CoreModule)coreModule;
            return this;
        }
    }
    private DaggerAnswerBotProvidersComponent(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, CoreModule coreModule2) {
        super();
        initialize(answerBotProvidersModule, coreModule2);
    }

    DaggerAnswerBotProvidersComponent(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, CoreModule coreModule2, zendesk.answerbot.DaggerAnswerBotProvidersComponent.1 daggerAnswerBotProvidersComponent$13) {
        super(answerBotProvidersModule, coreModule2);
    }

    public static zendesk.answerbot.DaggerAnswerBotProvidersComponent.Builder builder() {
        DaggerAnswerBotProvidersComponent.Builder builder = new DaggerAnswerBotProvidersComponent.Builder(0);
        return builder;
    }

    private void initialize(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, CoreModule coreModule2) {
        CoreModule_GetRestServiceProviderFactory create = CoreModule_GetRestServiceProviderFactory.create(coreModule2);
        this.getRestServiceProvider = create;
        this.getAnswerBotServiceProvider = a.a(AnswerBotProvidersModule_GetAnswerBotServiceFactory.create(answerBotProvidersModule, create));
        CoreModule_GetSettingsProviderFactory obj5 = CoreModule_GetSettingsProviderFactory.create(coreModule2);
        this.getSettingsProvider = obj5;
        this.getLocaleProvider = a.a(AnswerBotProvidersModule_GetLocaleProviderFactory.create(answerBotProvidersModule, obj5));
        this.getHelpCenterProvider = a.a(AnswerBotProvidersModule_GetHelpCenterProviderFactory.create(answerBotProvidersModule));
        obj5 = a.a(AnswerBotProvidersModule_GetAnswerBotSettingsProviderFactory.create(answerBotProvidersModule, this.getSettingsProvider));
        this.getAnswerBotSettingsProvider = obj5;
        obj5 = a.a(AnswerBotProvidersModule_GetAnswerBotProviderFactory.create(answerBotProvidersModule, this.getAnswerBotServiceProvider, this.getLocaleProvider, this.getHelpCenterProvider, obj5));
        this.getAnswerBotProvider = obj5;
        this.getAnswerBotShadowProvider = a.a(AnswerBotProvidersModule_GetAnswerBotShadowFactory.create(answerBotProvidersModule, obj5, this.getAnswerBotSettingsProvider));
    }

    private zendesk.answerbot.AnswerBot injectAnswerBot(zendesk.answerbot.AnswerBot answerBot) {
        AnswerBot_MembersInjector.injectAnswerBotModule(answerBot, this.getAnswerBotShadowProvider.get());
        return answerBot;
    }

    @Override // zendesk.answerbot.AnswerBotProvidersComponent
    public zendesk.answerbot.AnswerBot inject(zendesk.answerbot.AnswerBot answerBot) {
        injectAnswerBot(answerBot);
        return answerBot;
    }
}
