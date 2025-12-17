package zendesk.support;

import g.a;
import j.a.a;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.AuthenticationProvider;

/* loaded from: classes3.dex */
public final class Support_MembersInjector implements a<zendesk.support.Support> {

    private final a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final a<AuthenticationProvider> authenticationProvider;
    private final a<zendesk.support.SupportBlipsProvider> blipsProvider;
    private final a<zendesk.support.ProviderStore> providerStoreProvider;
    private final a<zendesk.support.RequestMigrator> requestMigratorProvider;
    private final a<zendesk.support.RequestProvider> requestProvider;
    private final a<zendesk.support.SupportModule> supportModuleProvider;
    public Support_MembersInjector(a<zendesk.support.ProviderStore> a, a<zendesk.support.SupportModule> a2, a<zendesk.support.RequestMigrator> a3, a<zendesk.support.SupportBlipsProvider> a4, a<ActionHandlerRegistry> a5, a<zendesk.support.RequestProvider> a6, a<AuthenticationProvider> a7) {
        super();
        this.providerStoreProvider = a;
        this.supportModuleProvider = a2;
        this.requestMigratorProvider = a3;
        this.blipsProvider = a4;
        this.actionHandlerRegistryProvider = a5;
        this.requestProvider = a6;
        this.authenticationProvider = a7;
    }

    public static a<zendesk.support.Support> create(a<zendesk.support.ProviderStore> a, a<zendesk.support.SupportModule> a2, a<zendesk.support.RequestMigrator> a3, a<zendesk.support.SupportBlipsProvider> a4, a<ActionHandlerRegistry> a5, a<zendesk.support.RequestProvider> a6, a<AuthenticationProvider> a7) {
        super(a, a2, a3, a4, a5, a6, a7);
        return support_MembersInjector2;
    }

    public static void injectActionHandlerRegistry(zendesk.support.Support support, ActionHandlerRegistry actionHandlerRegistry2) {
        support.actionHandlerRegistry = actionHandlerRegistry2;
    }

    public static void injectAuthenticationProvider(zendesk.support.Support support, AuthenticationProvider authenticationProvider2) {
        support.authenticationProvider = authenticationProvider2;
    }

    public static void injectBlipsProvider(zendesk.support.Support support, zendesk.support.SupportBlipsProvider supportBlipsProvider2) {
        support.blipsProvider = supportBlipsProvider2;
    }

    public static void injectProviderStore(zendesk.support.Support support, zendesk.support.ProviderStore providerStore2) {
        support.providerStore = providerStore2;
    }

    public static void injectRequestMigrator(zendesk.support.Support support, Object object2) {
        support.requestMigrator = (RequestMigrator)object2;
    }

    public static void injectRequestProvider(zendesk.support.Support support, zendesk.support.RequestProvider requestProvider2) {
        support.requestProvider = requestProvider2;
    }

    public static void injectSupportModule(zendesk.support.Support support, zendesk.support.SupportModule supportModule2) {
        support.supportModule = supportModule2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((Support)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.Support support) {
        Support_MembersInjector.injectProviderStore(support, (ProviderStore)this.providerStoreProvider.get());
        Support_MembersInjector.injectSupportModule(support, (SupportModule)this.supportModuleProvider.get());
        Support_MembersInjector.injectRequestMigrator(support, this.requestMigratorProvider.get());
        Support_MembersInjector.injectBlipsProvider(support, (SupportBlipsProvider)this.blipsProvider.get());
        Support_MembersInjector.injectActionHandlerRegistry(support, (ActionHandlerRegistry)this.actionHandlerRegistryProvider.get());
        Support_MembersInjector.injectRequestProvider(support, (RequestProvider)this.requestProvider.get());
        Support_MembersInjector.injectAuthenticationProvider(support, (AuthenticationProvider)this.authenticationProvider.get());
    }
}
