package zendesk.support;

import g.b.a;
import g.b.d;
import j.a.a;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_GetApplicationContextFactory;
import zendesk.core.CoreModule_GetAuthenticationProviderFactory;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.Update;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.Timer.Factory;
import zendesk.messaging.components.bot.BotMessageDispatcher;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;
import zendesk.messaging.components.bot.BotMessageDispatcher.MessageIdentifier;

/* loaded from: classes3.dex */
final class DaggerSupportEngineComponent implements zendesk.support.SupportEngineComponent {

    private final CoreModule coreModule;
    private a<BotMessageDispatcher.MessageIdentifier<MessagingItem>> interactionIdentifierProvider;
    private a<CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> stateCompositeActionListenerProvider;
    private final zendesk.support.SupportEngineModule supportEngineModule;
    private final zendesk.support.SupportModule supportModule;
    private a<CompositeActionListener<Update>> updateViewObserverProvider;

    static final class Builder {

        private CoreModule coreModule;
        private zendesk.support.SupportEngineModule supportEngineModule;
        private zendesk.support.SupportModule supportModule;
        Builder(zendesk.support.DaggerSupportEngineComponent.1 daggerSupportEngineComponent$1) {
            super();
        }

        public zendesk.support.SupportEngineComponent build() {
            zendesk.support.SupportEngineModule supportEngineModule;
            d.a(this.coreModule, CoreModule.class);
            d.a(this.supportModule, SupportModule.class);
            if (this.supportEngineModule == null) {
                supportEngineModule = new SupportEngineModule();
                this.supportEngineModule = supportEngineModule;
            }
            DaggerSupportEngineComponent daggerSupportEngineComponent = new DaggerSupportEngineComponent(this.coreModule, this.supportModule, this.supportEngineModule, 0);
            return daggerSupportEngineComponent;
        }

        public zendesk.support.DaggerSupportEngineComponent.Builder coreModule(CoreModule coreModule) {
            d.b(coreModule);
            this.coreModule = (CoreModule)coreModule;
            return this;
        }

        public zendesk.support.DaggerSupportEngineComponent.Builder supportEngineModule(zendesk.support.SupportEngineModule supportEngineModule) {
            d.b(supportEngineModule);
            this.supportEngineModule = (SupportEngineModule)supportEngineModule;
            return this;
        }

        public zendesk.support.DaggerSupportEngineComponent.Builder supportModule(zendesk.support.SupportModule supportModule) {
            d.b(supportModule);
            this.supportModule = (SupportModule)supportModule;
            return this;
        }
    }
    private DaggerSupportEngineComponent(CoreModule coreModule, zendesk.support.SupportModule supportModule2, zendesk.support.SupportEngineModule supportEngineModule3) {
        super();
        this.coreModule = coreModule;
        this.supportModule = supportModule2;
        this.supportEngineModule = supportEngineModule3;
        initialize(coreModule, supportModule2, supportEngineModule3);
    }

    DaggerSupportEngineComponent(CoreModule coreModule, zendesk.support.SupportModule supportModule2, zendesk.support.SupportEngineModule supportEngineModule3, zendesk.support.DaggerSupportEngineComponent.1 daggerSupportEngineComponent$14) {
        super(coreModule, supportModule2, supportEngineModule3);
    }

    public static zendesk.support.DaggerSupportEngineComponent.Builder builder() {
        DaggerSupportEngineComponent.Builder builder = new DaggerSupportEngineComponent.Builder(0);
        return builder;
    }

    private ActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> getActionListenerOfConversationStateOfMessagingItem() {
        return SupportEngineModule_StateActionListenerFactory.stateActionListener(this.supportEngineModule, (CompositeActionListener)this.stateCompositeActionListenerProvider.get());
    }

    private ActionListener<Update> getActionListenerOfUpdate() {
        return SupportEngineModule_UpdateActionListenerFactory.updateActionListener(this.supportEngineModule, (CompositeActionListener)this.updateViewObserverProvider.get());
    }

    private BotMessageDispatcher<MessagingItem> getBotMessageDispatcherOfMessagingItem() {
        return SupportEngineModule_BotMessageDispatcherFactory.botMessageDispatcher(this.supportEngineModule, (BotMessageDispatcher.MessageIdentifier)this.interactionIdentifierProvider.get(), getActionListenerOfConversationStateOfMessagingItem(), getActionListenerOfUpdate(), getTimerFactory());
    }

    private zendesk.support.RequestCreator getRequestCreator() {
        return SupportEngineModule_RequestCreatorFactory.requestCreator(this.supportEngineModule, SupportModule_ProvidesRequestProviderFactory.providesRequestProvider(this.supportModule), SupportModule_ProvidesUploadProviderFactory.providesUploadProvider(this.supportModule));
    }

    private zendesk.support.SupportEngineModel getSupportEngineModel() {
        return SupportEngineModule_SupportEngineModelFactory.supportEngineModel(this.supportEngineModule, SupportModule_ProvidesSettingsProviderFactory.providesSettingsProvider(this.supportModule), getRequestCreator(), CoreModule_GetAuthenticationProviderFactory.getAuthenticationProvider(this.coreModule), SupportEngineModule_ConfigurationHelperFactory.configurationHelper(this.supportEngineModule), SupportEngineModule_EmailValidatorFactory.emailValidator(this.supportEngineModule), getBotMessageDispatcherOfMessagingItem());
    }

    private Timer.Factory getTimerFactory() {
        zendesk.support.SupportEngineModule supportEngineModule = this.supportEngineModule;
        return SupportEngineModule_TimerFactoryFactory.timerFactory(supportEngineModule, SupportEngineModule_ProvideHandlerFactory.provideHandler(supportEngineModule));
    }

    private void initialize(CoreModule coreModule, zendesk.support.SupportModule supportModule2, zendesk.support.SupportEngineModule supportEngineModule3) {
        this.interactionIdentifierProvider = a.a(SupportEngineModule_InteractionIdentifierFactory.create(supportEngineModule3));
        this.stateCompositeActionListenerProvider = a.a(SupportEngineModule_StateCompositeActionListenerFactory.create(supportEngineModule3));
        this.updateViewObserverProvider = a.a(SupportEngineModule_UpdateViewObserverFactory.create(supportEngineModule3));
    }

    @Override // zendesk.support.SupportEngineComponent
    public zendesk.support.SupportEngine supportEngine() {
        return SupportEngineModule_SupportEngineFactory.supportEngine(this.supportEngineModule, CoreModule_GetApplicationContextFactory.getApplicationContext(this.coreModule), getSupportEngineModel(), (CompositeActionListener)this.stateCompositeActionListenerProvider.get(), (CompositeActionListener)this.updateViewObserverProvider.get());
    }
}
