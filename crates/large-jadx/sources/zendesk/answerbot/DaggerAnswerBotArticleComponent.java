package zendesk.answerbot;

import android.os.Handler;
import g.b.a;
import g.b.d;
import j.a.a;
import zendesk.core.ApplicationConfiguration;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_GetApplicationConfigurationFactory;
import zendesk.core.CoreModule_GetRestServiceProviderFactory;
import zendesk.core.RestServiceProvider;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
final class DaggerAnswerBotArticleComponent implements zendesk.answerbot.AnswerBotArticleComponent {

    private a<zendesk.answerbot.AnswerBotProvider> answerBotProvider;
    private a<zendesk.answerbot.ArticleViewModel> articleViewModelProvider;
    private a<ApplicationConfiguration> getApplicationConfigurationProvider;
    private a<zendesk.answerbot.ArticleUrlIdentifier> getArticleUrlIdentifierProvider;
    private a<RestServiceProvider> getRestServiceProvider;
    private a<zendesk.answerbot.AnswerBotArticleViewModel> getViewModelProvider;
    private a<zendesk.answerbot.ZendeskWebViewClient> getWebViewClientProvider;
    private a<Handler> provideHandlerProvider;
    private a<Timer.Factory> timerFactoryProvider;
    private final zendesk.answerbot.TimerModule timerModule;

    static final class Builder {

        private zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule;
        private zendesk.answerbot.AnswerBotModule answerBotModule;
        private CoreModule coreModule;
        private zendesk.answerbot.TimerModule timerModule;
        Builder(zendesk.answerbot.DaggerAnswerBotArticleComponent.1 daggerAnswerBotArticleComponent$1) {
            super();
        }

        public zendesk.answerbot.DaggerAnswerBotArticleComponent.Builder answerBotArticleModule(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule) {
            d.b(answerBotArticleModule);
            this.answerBotArticleModule = (AnswerBotArticleModule)answerBotArticleModule;
            return this;
        }

        public zendesk.answerbot.DaggerAnswerBotArticleComponent.Builder answerBotModule(zendesk.answerbot.AnswerBotModule answerBotModule) {
            d.b(answerBotModule);
            this.answerBotModule = (AnswerBotModule)answerBotModule;
            return this;
        }

        public zendesk.answerbot.AnswerBotArticleComponent build() {
            zendesk.answerbot.TimerModule timerModule;
            d.a(this.coreModule, CoreModule.class);
            d.a(this.answerBotModule, AnswerBotModule.class);
            d.a(this.answerBotArticleModule, AnswerBotArticleModule.class);
            if (this.timerModule == null) {
                timerModule = new TimerModule();
                this.timerModule = timerModule;
            }
            super(this.coreModule, this.answerBotModule, this.answerBotArticleModule, this.timerModule, 0);
            return daggerAnswerBotArticleComponent;
        }

        public zendesk.answerbot.DaggerAnswerBotArticleComponent.Builder coreModule(CoreModule coreModule) {
            d.b(coreModule);
            this.coreModule = (CoreModule)coreModule;
            return this;
        }

        public zendesk.answerbot.DaggerAnswerBotArticleComponent.Builder timerModule(zendesk.answerbot.TimerModule timerModule) {
            d.b(timerModule);
            this.timerModule = (TimerModule)timerModule;
            return this;
        }
    }
    private DaggerAnswerBotArticleComponent(CoreModule coreModule, zendesk.answerbot.AnswerBotModule answerBotModule2, zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule3, zendesk.answerbot.TimerModule timerModule4) {
        super();
        this.timerModule = timerModule4;
        initialize(coreModule, answerBotModule2, answerBotArticleModule3, timerModule4);
    }

    DaggerAnswerBotArticleComponent(CoreModule coreModule, zendesk.answerbot.AnswerBotModule answerBotModule2, zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule3, zendesk.answerbot.TimerModule timerModule4, zendesk.answerbot.DaggerAnswerBotArticleComponent.1 daggerAnswerBotArticleComponent$15) {
        super(coreModule, answerBotModule2, answerBotArticleModule3, timerModule4);
    }

    public static zendesk.answerbot.DaggerAnswerBotArticleComponent.Builder builder() {
        DaggerAnswerBotArticleComponent.Builder builder = new DaggerAnswerBotArticleComponent.Builder(0);
        return builder;
    }

    private Timer.Factory getTimerFactory() {
        zendesk.answerbot.TimerModule timerModule = this.timerModule;
        return TimerModule_TimerFactoryFactory.timerFactory(timerModule, TimerModule_ProvideHandlerFactory.provideHandler(timerModule));
    }

    private void initialize(CoreModule coreModule, zendesk.answerbot.AnswerBotModule answerBotModule2, zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule3, zendesk.answerbot.TimerModule timerModule4) {
        this.answerBotProvider = AnswerBotModule_AnswerBotProviderFactory.create(answerBotModule2);
        this.articleViewModelProvider = a.a(AnswerBotArticleModule_ArticleViewModelFactory.create(answerBotArticleModule3));
        zendesk.answerbot.TimerModule_ProvideHandlerFactory obj4 = TimerModule_ProvideHandlerFactory.create(timerModule4);
        this.provideHandlerProvider = obj4;
        this.timerFactoryProvider = TimerModule_TimerFactoryFactory.create(timerModule4, obj4);
        obj4 = CoreModule_GetApplicationConfigurationFactory.create(coreModule);
        this.getApplicationConfigurationProvider = obj4;
        obj4 = a.a(AnswerBotArticleModule_GetArticleUrlIdentifierFactory.create(answerBotArticleModule3, obj4));
        this.getArticleUrlIdentifierProvider = obj4;
        this.getViewModelProvider = a.a(AnswerBotArticleModule_GetViewModelFactory.create(answerBotArticleModule3, this.answerBotProvider, this.articleViewModelProvider, this.timerFactoryProvider, obj4));
        CoreModule_GetRestServiceProviderFactory obj3 = CoreModule_GetRestServiceProviderFactory.create(coreModule);
        this.getRestServiceProvider = obj3;
        this.getWebViewClientProvider = a.a(AnswerBotArticleModule_GetWebViewClientFactory.create(answerBotArticleModule3, this.getApplicationConfigurationProvider, obj3));
    }

    private zendesk.answerbot.AnswerBotArticleActivity injectAnswerBotArticleActivity(zendesk.answerbot.AnswerBotArticleActivity answerBotArticleActivity) {
        AnswerBotArticleActivity_MembersInjector.injectViewModel(answerBotArticleActivity, this.getViewModelProvider.get());
        AnswerBotArticleActivity_MembersInjector.injectZendeskWebViewClient(answerBotArticleActivity, this.getWebViewClientProvider.get());
        AnswerBotArticleActivity_MembersInjector.injectTimerFactory(answerBotArticleActivity, getTimerFactory());
        return answerBotArticleActivity;
    }

    @Override // zendesk.answerbot.AnswerBotArticleComponent
    public void inject(zendesk.answerbot.AnswerBotArticleActivity answerBotArticleActivity) {
        injectAnswerBotArticleActivity(answerBotArticleActivity);
    }
}
