package zendesk.support.guide;

import g.b.a;
import g.b.d;
import j.a.a;
import zendesk.core.ActionHandler;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_ActionHandlerRegistryFactory;
import zendesk.core.CoreModule_GetApplicationConfigurationFactory;
import zendesk.core.CoreModule_GetNetworkInfoProviderFactory;
import zendesk.support.GuideModule;
import zendesk.support.GuideModule_ProvidesArticleVoteStorageFactory;
import zendesk.support.GuideModule_ProvidesHelpCenterProviderFactory;
import zendesk.support.GuideModule_ProvidesOkHttpClientFactory;
import zendesk.support.GuideModule_ProvidesSettingsProviderFactory;

/* loaded from: classes3.dex */
final class DaggerGuideSdkComponent implements zendesk.support.guide.GuideSdkComponent {

    private final CoreModule coreModule;
    private final GuideModule guideModule;
    private final zendesk.support.guide.GuideSdkModule guideSdkModule;
    private a<ActionHandler> viewArticleActionHandlerProvider;

    static final class Builder {

        private CoreModule coreModule;
        private GuideModule guideModule;
        private zendesk.support.guide.GuideSdkModule guideSdkModule;
        Builder(zendesk.support.guide.DaggerGuideSdkComponent.1 daggerGuideSdkComponent$1) {
            super();
        }

        public zendesk.support.guide.GuideSdkComponent build() {
            zendesk.support.guide.GuideSdkModule guideSdkModule;
            d.a(this.coreModule, CoreModule.class);
            d.a(this.guideModule, GuideModule.class);
            if (this.guideSdkModule == null) {
                guideSdkModule = new GuideSdkModule();
                this.guideSdkModule = guideSdkModule;
            }
            DaggerGuideSdkComponent daggerGuideSdkComponent = new DaggerGuideSdkComponent(this.coreModule, this.guideModule, this.guideSdkModule, 0);
            return daggerGuideSdkComponent;
        }

        public zendesk.support.guide.DaggerGuideSdkComponent.Builder coreModule(CoreModule coreModule) {
            d.b(coreModule);
            this.coreModule = (CoreModule)coreModule;
            return this;
        }

        public zendesk.support.guide.DaggerGuideSdkComponent.Builder guideModule(GuideModule guideModule) {
            d.b(guideModule);
            this.guideModule = (GuideModule)guideModule;
            return this;
        }

        public zendesk.support.guide.DaggerGuideSdkComponent.Builder guideSdkModule(zendesk.support.guide.GuideSdkModule guideSdkModule) {
            d.b(guideSdkModule);
            this.guideSdkModule = (GuideSdkModule)guideSdkModule;
            return this;
        }
    }
    private DaggerGuideSdkComponent(CoreModule coreModule, GuideModule guideModule2, zendesk.support.guide.GuideSdkModule guideSdkModule3) {
        super();
        this.coreModule = coreModule;
        this.guideModule = guideModule2;
        this.guideSdkModule = guideSdkModule3;
        initialize(coreModule, guideModule2, guideSdkModule3);
    }

    DaggerGuideSdkComponent(CoreModule coreModule, GuideModule guideModule2, zendesk.support.guide.GuideSdkModule guideSdkModule3, zendesk.support.guide.DaggerGuideSdkComponent.1 daggerGuideSdkComponent$14) {
        super(coreModule, guideModule2, guideSdkModule3);
    }

    public static zendesk.support.guide.DaggerGuideSdkComponent.Builder builder() {
        DaggerGuideSdkComponent.Builder builder = new DaggerGuideSdkComponent.Builder(0);
        return builder;
    }

    private void initialize(CoreModule coreModule, GuideModule guideModule2, zendesk.support.guide.GuideSdkModule guideSdkModule3) {
        this.viewArticleActionHandlerProvider = a.a(GuideSdkModule_ViewArticleActionHandlerFactory.create());
    }

    private zendesk.support.guide.GuideSdkDependencyProvider injectGuideSdkDependencyProvider(zendesk.support.guide.GuideSdkDependencyProvider guideSdkDependencyProvider) {
        GuideSdkDependencyProvider_MembersInjector.injectRegistry(guideSdkDependencyProvider, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
        GuideSdkDependencyProvider_MembersInjector.injectActionHandler(guideSdkDependencyProvider, (ActionHandler)this.viewArticleActionHandlerProvider.get());
        return guideSdkDependencyProvider;
    }

    private zendesk.support.guide.HelpCenterActivity injectHelpCenterActivity(zendesk.support.guide.HelpCenterActivity helpCenterActivity) {
        HelpCenterActivity_MembersInjector.injectHelpCenterProvider(helpCenterActivity, GuideModule_ProvidesHelpCenterProviderFactory.providesHelpCenterProvider(this.guideModule));
        HelpCenterActivity_MembersInjector.injectSettingsProvider(helpCenterActivity, GuideModule_ProvidesSettingsProviderFactory.providesSettingsProvider(this.guideModule));
        HelpCenterActivity_MembersInjector.injectNetworkInfoProvider(helpCenterActivity, CoreModule_GetNetworkInfoProviderFactory.getNetworkInfoProvider(this.coreModule));
        HelpCenterActivity_MembersInjector.injectActionHandlerRegistry(helpCenterActivity, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
        HelpCenterActivity_MembersInjector.injectConfigurationHelper(helpCenterActivity, GuideSdkModule_ConfigurationHelperFactory.configurationHelper(this.guideSdkModule));
        return helpCenterActivity;
    }

    private zendesk.support.guide.HelpCenterFragment injectHelpCenterFragment(zendesk.support.guide.HelpCenterFragment helpCenterFragment) {
        HelpCenterFragment_MembersInjector.injectHelpCenterProvider(helpCenterFragment, GuideModule_ProvidesHelpCenterProviderFactory.providesHelpCenterProvider(this.guideModule));
        HelpCenterFragment_MembersInjector.injectNetworkInfoProvider(helpCenterFragment, CoreModule_GetNetworkInfoProviderFactory.getNetworkInfoProvider(this.coreModule));
        return helpCenterFragment;
    }

    private zendesk.support.guide.ViewArticleActivity injectViewArticleActivity(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        ViewArticleActivity_MembersInjector.injectOkHttpClient(viewArticleActivity, GuideModule_ProvidesOkHttpClientFactory.providesOkHttpClient(this.guideModule));
        ViewArticleActivity_MembersInjector.injectApplicationConfiguration(viewArticleActivity, CoreModule_GetApplicationConfigurationFactory.getApplicationConfiguration(this.coreModule));
        ViewArticleActivity_MembersInjector.injectHelpCenterProvider(viewArticleActivity, GuideModule_ProvidesHelpCenterProviderFactory.providesHelpCenterProvider(this.guideModule));
        ViewArticleActivity_MembersInjector.injectArticleVoteStorage(viewArticleActivity, GuideModule_ProvidesArticleVoteStorageFactory.providesArticleVoteStorage(this.guideModule));
        ViewArticleActivity_MembersInjector.injectNetworkInfoProvider(viewArticleActivity, CoreModule_GetNetworkInfoProviderFactory.getNetworkInfoProvider(this.coreModule));
        ViewArticleActivity_MembersInjector.injectSettingsProvider(viewArticleActivity, GuideModule_ProvidesSettingsProviderFactory.providesSettingsProvider(this.guideModule));
        ViewArticleActivity_MembersInjector.injectActionHandlerRegistry(viewArticleActivity, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
        ViewArticleActivity_MembersInjector.injectConfigurationHelper(viewArticleActivity, GuideSdkModule_ConfigurationHelperFactory.configurationHelper(this.guideSdkModule));
        return viewArticleActivity;
    }

    @Override // zendesk.support.guide.GuideSdkComponent
    public void inject(zendesk.support.guide.GuideSdkDependencyProvider guideSdkDependencyProvider) {
        injectGuideSdkDependencyProvider(guideSdkDependencyProvider);
    }

    @Override // zendesk.support.guide.GuideSdkComponent
    public void inject(zendesk.support.guide.HelpCenterActivity helpCenterActivity) {
        injectHelpCenterActivity(helpCenterActivity);
    }

    @Override // zendesk.support.guide.GuideSdkComponent
    public void inject(zendesk.support.guide.HelpCenterFragment helpCenterFragment) {
        injectHelpCenterFragment(helpCenterFragment);
    }

    @Override // zendesk.support.guide.GuideSdkComponent
    public void inject(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        injectViewArticleActivity(viewArticleActivity);
    }
}
