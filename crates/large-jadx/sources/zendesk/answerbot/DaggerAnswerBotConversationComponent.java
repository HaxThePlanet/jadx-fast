package zendesk.answerbot;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.squareup.picasso.t;
import g.b.a;
import g.b.d;
import j.a.a;
import o.a.b;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_GetApplicationContextFactory;
import zendesk.messaging.Update;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.DateProvider;
import zendesk.messaging.components.Timer.Factory;
import zendesk.messaging.components.bot.BotMessageDispatcher;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;
import zendesk.messaging.components.bot.BotMessageDispatcher.MessageIdentifier;

/* loaded from: classes3.dex */
final class DaggerAnswerBotConversationComponent implements zendesk.answerbot.AnswerBotConversationComponent {

    private a<zendesk.answerbot.AnswerBotEngine> answerBotEngineProvider;
    private a<zendesk.answerbot.AnswerBotProvider> answerBotProvider;
    private a<zendesk.answerbot.AnswerBotSettingsProvider> answerBotSettingsProvider;
    private a<b> configurationHelperProvider;
    private a<zendesk.answerbot.AnswerBotCellFactory> getAnswerBotCellFactoryProvider;
    private a<zendesk.answerbot.AnswerBotModel> getAnswerBotModelProvider;
    private a<Context> getApplicationContextProvider;
    private a<t> getPicassoProvider;
    private a<Resources> getResourcesProvider;
    private a<BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction>> provideBotMessageDispatcherProvider;
    private a<zendesk.answerbot.AnswerBotConversationManager> provideConversationManagerProvider;
    private a<DateProvider> provideDateProvider;
    private a<Handler> provideHandlerProvider;
    private a<BotMessageDispatcher.MessageIdentifier<zendesk.answerbot.AnswerBotInteraction>> provideInteractionIdentifierProvider;
    private a<ActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> provideStateActionListenerProvider;
    private a<CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> provideStateCompositeActionListenerProvider;
    private a<ActionListener<Update>> provideUpdateActionListenerProvider;
    private a<CompositeActionListener<Update>> provideUpdateCompositeActionListenerProvider;
    private a<Timer.Factory> timerFactoryProvider;

    static final class Builder {

        private zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule;
        private zendesk.answerbot.AnswerBotModule answerBotModule;
        private CoreModule coreModule;
        private zendesk.answerbot.TimerModule timerModule;
        Builder(zendesk.answerbot.DaggerAnswerBotConversationComponent.1 daggerAnswerBotConversationComponent$1) {
            super();
        }

        public zendesk.answerbot.DaggerAnswerBotConversationComponent.Builder answerBotModule(zendesk.answerbot.AnswerBotModule answerBotModule) {
            d.b(answerBotModule);
            this.answerBotModule = (AnswerBotModule)answerBotModule;
            return this;
        }

        public zendesk.answerbot.AnswerBotConversationComponent build() {
            zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule;
            zendesk.answerbot.TimerModule timerModule;
            d.a(this.coreModule, CoreModule.class);
            d.a(this.answerBotModule, AnswerBotModule.class);
            if (this.answerBotConversationModule == null) {
                answerBotConversationModule = new AnswerBotConversationModule();
                this.answerBotConversationModule = answerBotConversationModule;
            }
            if (this.timerModule == null) {
                timerModule = new TimerModule();
                this.timerModule = timerModule;
            }
            super(this.coreModule, this.answerBotModule, this.answerBotConversationModule, this.timerModule, 0);
            return daggerAnswerBotConversationComponent;
        }

        public zendesk.answerbot.DaggerAnswerBotConversationComponent.Builder coreModule(CoreModule coreModule) {
            d.b(coreModule);
            this.coreModule = (CoreModule)coreModule;
            return this;
        }

        public zendesk.answerbot.DaggerAnswerBotConversationComponent.Builder timerModule(zendesk.answerbot.TimerModule timerModule) {
            d.b(timerModule);
            this.timerModule = (TimerModule)timerModule;
            return this;
        }
    }
    private DaggerAnswerBotConversationComponent(CoreModule coreModule, zendesk.answerbot.AnswerBotModule answerBotModule2, zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule3, zendesk.answerbot.TimerModule timerModule4) {
        super();
        initialize(coreModule, answerBotModule2, answerBotConversationModule3, timerModule4);
    }

    DaggerAnswerBotConversationComponent(CoreModule coreModule, zendesk.answerbot.AnswerBotModule answerBotModule2, zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule3, zendesk.answerbot.TimerModule timerModule4, zendesk.answerbot.DaggerAnswerBotConversationComponent.1 daggerAnswerBotConversationComponent$15) {
        super(coreModule, answerBotModule2, answerBotConversationModule3, timerModule4);
    }

    public static zendesk.answerbot.DaggerAnswerBotConversationComponent.Builder builder() {
        DaggerAnswerBotConversationComponent.Builder builder = new DaggerAnswerBotConversationComponent.Builder(0);
        return builder;
    }

    private void initialize(CoreModule coreModule, zendesk.answerbot.AnswerBotModule answerBotModule2, zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule3, zendesk.answerbot.TimerModule timerModule4) {
        this.getApplicationContextProvider = CoreModule_GetApplicationContextFactory.create(coreModule);
        this.answerBotProvider = AnswerBotModule_AnswerBotProviderFactory.create(answerBotModule2);
        this.answerBotSettingsProvider = AnswerBotModule_AnswerBotSettingsProviderFactory.create(answerBotModule2);
        zendesk.answerbot.TimerModule_ProvideHandlerFactory obj8 = TimerModule_ProvideHandlerFactory.create(timerModule4);
        this.provideHandlerProvider = obj8;
        this.timerFactoryProvider = TimerModule_TimerFactoryFactory.create(timerModule4, obj8);
        this.getResourcesProvider = a.a(AnswerBotConversationModule_GetResourcesFactory.create(this.getApplicationContextProvider));
        this.provideInteractionIdentifierProvider = a.a(AnswerBotConversationModule_ProvideInteractionIdentifierFactory.create(answerBotConversationModule3));
        obj8 = a.a(AnswerBotConversationModule_ProvideStateCompositeActionListenerFactory.create(answerBotConversationModule3));
        this.provideStateCompositeActionListenerProvider = obj8;
        this.provideStateActionListenerProvider = a.a(AnswerBotConversationModule_ProvideStateActionListenerFactory.create(answerBotConversationModule3, obj8));
        obj8 = a.a(AnswerBotConversationModule_ProvideUpdateCompositeActionListenerFactory.create(answerBotConversationModule3));
        this.provideUpdateCompositeActionListenerProvider = obj8;
        obj8 = a.a(AnswerBotConversationModule_ProvideUpdateActionListenerFactory.create(answerBotConversationModule3, obj8));
        this.provideUpdateActionListenerProvider = obj8;
        this.provideBotMessageDispatcherProvider = a.a(AnswerBotConversationModule_ProvideBotMessageDispatcherFactory.create(answerBotConversationModule3, this.provideInteractionIdentifierProvider, this.provideStateActionListenerProvider, obj8, this.timerFactoryProvider));
        obj8 = a.a(AnswerBotConversationModule_ProvideDateProviderFactory.create(answerBotConversationModule3));
        this.provideDateProvider = obj8;
        this.provideConversationManagerProvider = a.a(AnswerBotConversationModule_ProvideConversationManagerFactory.create(answerBotConversationModule3, this.provideBotMessageDispatcherProvider, obj8));
        final zendesk.answerbot.AnswerBotConversationModule_ConfigurationHelperFactory create = AnswerBotConversationModule_ConfigurationHelperFactory.create(answerBotConversationModule3);
        this.configurationHelperProvider = create;
        this.getAnswerBotModelProvider = a.a(AnswerBotConversationModule_GetAnswerBotModelFactory.create(answerBotConversationModule3, this.answerBotProvider, this.answerBotSettingsProvider, this.timerFactoryProvider, this.getResourcesProvider, this.provideConversationManagerProvider, create));
        a aVar = a.a(AnswerBotConversationModule_GetAnswerBotCellFactoryFactory.create(answerBotConversationModule3));
        this.getAnswerBotCellFactoryProvider = aVar;
        this.answerBotEngineProvider = a.a(AnswerBotEngine_Factory.create(this.getApplicationContextProvider, this.getAnswerBotModelProvider, aVar, this.provideUpdateCompositeActionListenerProvider, this.provideStateCompositeActionListenerProvider, this.configurationHelperProvider));
        this.getPicassoProvider = a.a(AnswerBotConversationModule_GetPicassoFactory.create(answerBotConversationModule3, this.getApplicationContextProvider));
    }

    @Override // zendesk.answerbot.AnswerBotConversationComponent
    public zendesk.answerbot.AnswerBotEngine answerBot() {
        return (AnswerBotEngine)this.answerBotEngineProvider.get();
    }
}
