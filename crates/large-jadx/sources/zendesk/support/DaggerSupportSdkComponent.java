package zendesk.support;

import android.content.Context;
import com.google.gson.Gson;
import com.squareup.picasso.s;
import com.squareup.picasso.t;
import f.e.a.a;
import g.b.a;
import g.b.d;
import g.b.e;
import j.a.a;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import o.a.b;
import o.b.f;
import o.b.n;
import o.b.q;
import okhttp3.OkHttpClient;
import zendesk.belvedere.a;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.AuthenticationProvider;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_ActionHandlerRegistryFactory;
import zendesk.core.CoreModule_GetApplicationContextFactory;
import zendesk.core.CoreModule_GetAuthenticationProviderFactory;
import zendesk.core.CoreModule_GetExecutorServiceFactory;
import zendesk.core.CoreModule_GetMemoryCacheFactory;
import zendesk.core.CoreModule_GetSessionStorageFactory;
import zendesk.core.MemoryCache;
import zendesk.core.SessionStorage;
import zendesk.support.request.RequestActivity;
import zendesk.support.request.RequestActivity_MembersInjector;
import zendesk.support.request.RequestComponent;
import zendesk.support.request.RequestModule;
import zendesk.support.request.RequestModule_ProvidesActionFactoryFactory;
import zendesk.support.request.RequestModule_ProvidesAsyncMiddlewareFactory;
import zendesk.support.request.RequestModule_ProvidesAttachmentDownloaderComponentFactory;
import zendesk.support.request.RequestModule_ProvidesAttachmentDownloaderFactory;
import zendesk.support.request.RequestModule_ProvidesAttachmentToDiskServiceFactory;
import zendesk.support.request.RequestModule_ProvidesBelvedereFactory;
import zendesk.support.request.RequestModule_ProvidesComponentListenerFactory;
import zendesk.support.request.RequestModule_ProvidesConUpdatesComponentFactory;
import zendesk.support.request.RequestModule_ProvidesDiskQueueFactory;
import zendesk.support.request.RequestModule_ProvidesDispatcherFactory;
import zendesk.support.request.RequestModule_ProvidesMessageFactoryFactory;
import zendesk.support.request.RequestModule_ProvidesPersistenceComponentFactory;
import zendesk.support.request.RequestModule_ProvidesReducerFactory;
import zendesk.support.request.RequestModule_ProvidesStoreFactory;
import zendesk.support.request.RequestViewConversationsDisabled;
import zendesk.support.request.RequestViewConversationsDisabled_MembersInjector;
import zendesk.support.request.RequestViewConversationsEnabled;
import zendesk.support.request.RequestViewConversationsEnabled_MembersInjector;
import zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource;
import zendesk.support.requestlist.RequestInfoDataSource.Repository;
import zendesk.support.requestlist.RequestListActivity;
import zendesk.support.requestlist.RequestListActivity_MembersInjector;
import zendesk.support.requestlist.RequestListComponent;
import zendesk.support.requestlist.RequestListModule;
import zendesk.support.requestlist.RequestListModule_ModelFactory;
import zendesk.support.requestlist.RequestListModule_PresenterFactory;
import zendesk.support.requestlist.RequestListModule_RefreshHandlerFactory;
import zendesk.support.requestlist.RequestListModule_RepositoryFactory;
import zendesk.support.requestlist.RequestListViewModule;
import zendesk.support.requestlist.RequestListViewModule_ViewFactory;

/* loaded from: classes3.dex */
public final class DaggerSupportSdkComponent implements zendesk.support.SupportSdkComponent {

    private a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private a<b> configurationHelperProvider;
    private final CoreModule coreModule;
    private a<Context> getApplicationContextProvider;
    private a<AuthenticationProvider> getAuthenticationProvider;
    private a<ExecutorService> getExecutorServiceProvider;
    private a<MemoryCache> getMemoryCacheProvider;
    private a<SessionStorage> getSessionStorageProvider;
    private a<Executor> mainThreadExecutorProvider;
    private a<s> okHttp3DownloaderProvider;
    private a<List<ActionHandler>> providesActionHandlersProvider;
    private a<zendesk.support.SupportBlipsProvider> providesBlipsProvider;
    private a<OkHttpClient> providesOkHttpClientProvider;
    private a<t> providesPicassoProvider;
    private a<Gson> providesProvider;
    private a<a> providesRequestDiskLruCacheProvider;
    private a<zendesk.support.RequestProvider> providesRequestProvider;
    private a<zendesk.support.SupportSettingsProvider> providesSettingsProvider;
    private a<zendesk.support.UploadProvider> providesUploadProvider;
    private a<RequestInfoDataSource.LocalDataSource> requestInfoDataSourceProvider;
    private a<zendesk.support.SupportUiStorage> supportUiStorageProvider;

    public static final class Builder {

        private CoreModule coreModule;
        private zendesk.support.SupportModule supportModule;
        private zendesk.support.SupportSdkModule supportSdkModule;
        Builder(zendesk.support.DaggerSupportSdkComponent.1 daggerSupportSdkComponent$1) {
            super();
        }

        public zendesk.support.SupportSdkComponent build() {
            zendesk.support.SupportSdkModule supportSdkModule;
            d.a(this.coreModule, CoreModule.class);
            d.a(this.supportModule, SupportModule.class);
            if (this.supportSdkModule == null) {
                supportSdkModule = new SupportSdkModule();
                this.supportSdkModule = supportSdkModule;
            }
            DaggerSupportSdkComponent daggerSupportSdkComponent = new DaggerSupportSdkComponent(this.coreModule, this.supportModule, this.supportSdkModule, 0);
            return daggerSupportSdkComponent;
        }

        public zendesk.support.DaggerSupportSdkComponent.Builder coreModule(CoreModule coreModule) {
            d.b(coreModule);
            this.coreModule = (CoreModule)coreModule;
            return this;
        }

        public zendesk.support.DaggerSupportSdkComponent.Builder supportModule(zendesk.support.SupportModule supportModule) {
            d.b(supportModule);
            this.supportModule = (SupportModule)supportModule;
            return this;
        }

        public zendesk.support.DaggerSupportSdkComponent.Builder supportSdkModule(zendesk.support.SupportSdkModule supportSdkModule) {
            d.b(supportSdkModule);
            this.supportSdkModule = (SupportSdkModule)supportSdkModule;
            return this;
        }
    }

    private final class RequestComponentImpl implements RequestComponent {

        private a providesActionFactoryProvider;
        private a providesAsyncMiddlewareProvider;
        private a providesAttachmentDownloaderComponentProvider;
        private a providesAttachmentDownloaderProvider;
        private a providesAttachmentToDiskServiceProvider;
        private a<a> providesBelvedereProvider;
        private a providesComponentListenerProvider;
        private a providesConUpdatesComponentProvider;
        private a providesDiskQueueProvider;
        private a<f> providesDispatcherProvider;
        private a providesMessageFactoryProvider;
        private a providesPersistenceComponentProvider;
        private a<List<n>> providesReducerProvider;
        private a<q> providesStoreProvider;
        final zendesk.support.DaggerSupportSdkComponent this$0;
        private RequestComponentImpl(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent, RequestModule requestModule2) {
            this.this$0 = daggerSupportSdkComponent;
            super();
            initialize(requestModule2);
        }

        RequestComponentImpl(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent, RequestModule requestModule2, zendesk.support.DaggerSupportSdkComponent.1 daggerSupportSdkComponent$13) {
            super(daggerSupportSdkComponent, requestModule2);
        }

        private void initialize(RequestModule requestModule) {
            this.providesReducerProvider = a.a(RequestModule_ProvidesReducerFactory.create());
            a aVar2 = a.a(RequestModule_ProvidesAsyncMiddlewareFactory.create());
            this.providesAsyncMiddlewareProvider = aVar2;
            this.providesStoreProvider = a.a(RequestModule_ProvidesStoreFactory.create(this.providesReducerProvider, aVar2));
            this.providesBelvedereProvider = a.a(RequestModule_ProvidesBelvedereFactory.create(DaggerSupportSdkComponent.access$400(this.this$0)));
            this.providesActionFactoryProvider = a.a(RequestModule_ProvidesActionFactoryFactory.create(DaggerSupportSdkComponent.access$500(this.this$0), DaggerSupportSdkComponent.access$600(this.this$0), DaggerSupportSdkComponent.access$700(this.this$0), this.providesBelvedereProvider, DaggerSupportSdkComponent.access$800(this.this$0), DaggerSupportSdkComponent.access$900(this.this$0), DaggerSupportSdkComponent.access$1000(this.this$0), DaggerSupportSdkComponent.access$1100(this.this$0), DaggerSupportSdkComponent.access$1200(this.this$0)));
            this.providesDiskQueueProvider = a.a(RequestModule_ProvidesDiskQueueFactory.create(DaggerSupportSdkComponent.access$900(this.this$0)));
            this.providesPersistenceComponentProvider = a.a(RequestModule_ProvidesPersistenceComponentFactory.create(DaggerSupportSdkComponent.access$800(this.this$0), this.providesDiskQueueProvider, DaggerSupportSdkComponent.access$900(this.this$0)));
            this.providesDispatcherProvider = a.a(RequestModule_ProvidesDispatcherFactory.create(this.providesStoreProvider));
            a aVar13 = a.a(RequestModule_ProvidesAttachmentToDiskServiceFactory.create(DaggerSupportSdkComponent.access$1300(this.this$0), DaggerSupportSdkComponent.access$900(this.this$0)));
            this.providesAttachmentToDiskServiceProvider = aVar13;
            a aVar14 = a.a(RequestModule_ProvidesAttachmentDownloaderFactory.create(this.providesBelvedereProvider, aVar13));
            this.providesAttachmentDownloaderProvider = aVar14;
            this.providesAttachmentDownloaderComponentProvider = a.a(RequestModule_ProvidesAttachmentDownloaderComponentFactory.create(this.providesDispatcherProvider, this.providesActionFactoryProvider, aVar14));
            a aVar17 = e.a(RequestModule_ProvidesConUpdatesComponentFactory.create(DaggerSupportSdkComponent.access$400(this.this$0), DaggerSupportSdkComponent.access$1400(this.this$0), DaggerSupportSdkComponent.access$1500(this.this$0)));
            this.providesConUpdatesComponentProvider = aVar17;
            this.providesComponentListenerProvider = a.a(RequestModule_ProvidesComponentListenerFactory.create(this.providesPersistenceComponentProvider, this.providesAttachmentDownloaderComponentProvider, aVar17));
            this.providesMessageFactoryProvider = a.a(RequestModule_ProvidesMessageFactoryFactory.create(requestModule, DaggerSupportSdkComponent.access$400(this.this$0), DaggerSupportSdkComponent.access$1600(this.this$0), this.providesActionFactoryProvider, this.providesDispatcherProvider, DaggerSupportSdkComponent.access$1400(this.this$0), DaggerSupportSdkComponent.access$1700(this.this$0)));
        }

        private RequestActivity injectRequestActivity(RequestActivity requestActivity) {
            RequestActivity_MembersInjector.injectStore(requestActivity, (q)this.providesStoreProvider.get());
            RequestActivity_MembersInjector.injectAf(requestActivity, this.providesActionFactoryProvider.get());
            RequestActivity_MembersInjector.injectHeadlessComponentListener(requestActivity, this.providesComponentListenerProvider.get());
            RequestActivity_MembersInjector.injectPicasso(requestActivity, (t)DaggerSupportSdkComponent.access$1600(this.this$0).get());
            RequestActivity_MembersInjector.injectActionHandlerRegistry(requestActivity, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(DaggerSupportSdkComponent.access$1800(this.this$0)));
            return requestActivity;
        }

        private RequestViewConversationsDisabled injectRequestViewConversationsDisabled(RequestViewConversationsDisabled requestViewConversationsDisabled) {
            RequestViewConversationsDisabled_MembersInjector.injectStore(requestViewConversationsDisabled, (q)this.providesStoreProvider.get());
            RequestViewConversationsDisabled_MembersInjector.injectAf(requestViewConversationsDisabled, this.providesActionFactoryProvider.get());
            RequestViewConversationsDisabled_MembersInjector.injectPicasso(requestViewConversationsDisabled, (t)DaggerSupportSdkComponent.access$1600(this.this$0).get());
            return requestViewConversationsDisabled;
        }

        private RequestViewConversationsEnabled injectRequestViewConversationsEnabled(RequestViewConversationsEnabled requestViewConversationsEnabled) {
            RequestViewConversationsEnabled_MembersInjector.injectStore(requestViewConversationsEnabled, (q)this.providesStoreProvider.get());
            RequestViewConversationsEnabled_MembersInjector.injectAf(requestViewConversationsEnabled, this.providesActionFactoryProvider.get());
            RequestViewConversationsEnabled_MembersInjector.injectCellFactory(requestViewConversationsEnabled, this.providesMessageFactoryProvider.get());
            RequestViewConversationsEnabled_MembersInjector.injectPicasso(requestViewConversationsEnabled, (t)DaggerSupportSdkComponent.access$1600(this.this$0).get());
            return requestViewConversationsEnabled;
        }

        @Override // zendesk.support.request.RequestComponent
        public void inject(RequestActivity requestActivity) {
            injectRequestActivity(requestActivity);
        }

        @Override // zendesk.support.request.RequestComponent
        public void inject(RequestViewConversationsDisabled requestViewConversationsDisabled) {
            injectRequestViewConversationsDisabled(requestViewConversationsDisabled);
        }

        @Override // zendesk.support.request.RequestComponent
        public void inject(RequestViewConversationsEnabled requestViewConversationsEnabled) {
            injectRequestViewConversationsEnabled(requestViewConversationsEnabled);
        }
    }

    private final class RequestListComponentImpl implements RequestListComponent {

        private a modelProvider;
        private a presenterProvider;
        private a refreshHandlerProvider;
        private a<RequestInfoDataSource.Repository> repositoryProvider;
        final zendesk.support.DaggerSupportSdkComponent this$0;
        private a viewProvider;
        private RequestListComponentImpl(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent, RequestListModule requestListModule2, RequestListViewModule requestListViewModule3) {
            this.this$0 = daggerSupportSdkComponent;
            super();
            initialize(requestListModule2, requestListViewModule3);
        }

        RequestListComponentImpl(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent, RequestListModule requestListModule2, RequestListViewModule requestListViewModule3, zendesk.support.DaggerSupportSdkComponent.1 daggerSupportSdkComponent$14) {
            super(daggerSupportSdkComponent, requestListModule2, requestListViewModule3);
        }

        private void initialize(RequestListModule requestListModule, RequestListViewModule requestListViewModule2) {
            a aVar2 = a.a(RequestListModule_RepositoryFactory.create(DaggerSupportSdkComponent.access$1500(this.this$0), DaggerSupportSdkComponent.access$800(this.this$0), DaggerSupportSdkComponent.access$500(this.this$0), DaggerSupportSdkComponent.access$1000(this.this$0), DaggerSupportSdkComponent.access$900(this.this$0)));
            this.repositoryProvider = aVar2;
            a aVar3 = a.a(RequestListModule_ModelFactory.create(requestListModule, aVar2, DaggerSupportSdkComponent.access$1900(this.this$0), DaggerSupportSdkComponent.access$1200(this.this$0), DaggerSupportSdkComponent.access$600(this.this$0)));
            this.modelProvider = aVar3;
            this.presenterProvider = a.a(RequestListModule_PresenterFactory.create(requestListModule, aVar3));
            this.viewProvider = a.a(RequestListViewModule_ViewFactory.create(requestListViewModule2, DaggerSupportSdkComponent.access$1600(this.this$0)));
            this.refreshHandlerProvider = a.a(RequestListModule_RefreshHandlerFactory.create(this.presenterProvider));
        }

        private RequestListActivity injectRequestListActivity(RequestListActivity requestListActivity) {
            RequestListActivity_MembersInjector.injectPresenter(requestListActivity, this.presenterProvider.get());
            RequestListActivity_MembersInjector.injectView(requestListActivity, this.viewProvider.get());
            RequestListActivity_MembersInjector.injectModel(requestListActivity, this.modelProvider.get());
            RequestListActivity_MembersInjector.injectActionHandlerRegistry(requestListActivity, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(DaggerSupportSdkComponent.access$1800(this.this$0)));
            RequestListActivity_MembersInjector.injectSyncHandler(requestListActivity, this.refreshHandlerProvider.get());
            return requestListActivity;
        }

        @Override // zendesk.support.requestlist.RequestListComponent
        public void inject(RequestListActivity requestListActivity) {
            injectRequestListActivity(requestListActivity);
        }
    }
    private DaggerSupportSdkComponent(CoreModule coreModule, zendesk.support.SupportModule supportModule2, zendesk.support.SupportSdkModule supportSdkModule3) {
        super();
        this.coreModule = coreModule;
        initialize(coreModule, supportModule2, supportSdkModule3);
    }

    DaggerSupportSdkComponent(CoreModule coreModule, zendesk.support.SupportModule supportModule2, zendesk.support.SupportSdkModule supportSdkModule3, zendesk.support.DaggerSupportSdkComponent.1 daggerSupportSdkComponent$14) {
        super(coreModule, supportModule2, supportSdkModule3);
    }

    static a access$1000(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.mainThreadExecutorProvider;
    }

    static a access$1100(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.getAuthenticationProvider;
    }

    static a access$1200(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.providesBlipsProvider;
    }

    static a access$1300(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.providesOkHttpClientProvider;
    }

    static a access$1400(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.actionHandlerRegistryProvider;
    }

    static a access$1500(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.requestInfoDataSourceProvider;
    }

    static a access$1600(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.providesPicassoProvider;
    }

    static a access$1700(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.configurationHelperProvider;
    }

    static CoreModule access$1800(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.coreModule;
    }

    static a access$1900(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.getMemoryCacheProvider;
    }

    static a access$400(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.getApplicationContextProvider;
    }

    static a access$500(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.providesRequestProvider;
    }

    static a access$600(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.providesSettingsProvider;
    }

    static a access$700(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.providesUploadProvider;
    }

    static a access$800(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.supportUiStorageProvider;
    }

    static a access$900(zendesk.support.DaggerSupportSdkComponent daggerSupportSdkComponent) {
        return daggerSupportSdkComponent.getExecutorServiceProvider;
    }

    public static zendesk.support.DaggerSupportSdkComponent.Builder builder() {
        DaggerSupportSdkComponent.Builder builder = new DaggerSupportSdkComponent.Builder(0);
        return builder;
    }

    private void initialize(CoreModule coreModule, zendesk.support.SupportModule supportModule2, zendesk.support.SupportSdkModule supportSdkModule3) {
        this.providesActionHandlersProvider = a.a(SupportSdkModule_ProvidesActionHandlersFactory.create(supportSdkModule3));
        this.providesRequestProvider = SupportModule_ProvidesRequestProviderFactory.create(supportModule2);
        this.providesSettingsProvider = SupportModule_ProvidesSettingsProviderFactory.create(supportModule2);
        this.providesUploadProvider = SupportModule_ProvidesUploadProviderFactory.create(supportModule2);
        this.getApplicationContextProvider = CoreModule_GetApplicationContextFactory.create(coreModule);
        CoreModule_GetSessionStorageFactory create6 = CoreModule_GetSessionStorageFactory.create(coreModule);
        this.getSessionStorageProvider = create6;
        this.providesRequestDiskLruCacheProvider = a.a(SupportSdkModule_ProvidesRequestDiskLruCacheFactory.create(supportSdkModule3, create6));
        a aVar3 = a.a(SupportSdkModule_ProvidesFactory.create(supportSdkModule3));
        this.providesProvider = aVar3;
        this.supportUiStorageProvider = a.a(SupportSdkModule_SupportUiStorageFactory.create(supportSdkModule3, this.providesRequestDiskLruCacheProvider, aVar3));
        this.getExecutorServiceProvider = CoreModule_GetExecutorServiceFactory.create(coreModule);
        this.mainThreadExecutorProvider = a.a(SupportSdkModule_MainThreadExecutorFactory.create(supportSdkModule3));
        this.getAuthenticationProvider = CoreModule_GetAuthenticationProviderFactory.create(coreModule);
        this.providesBlipsProvider = SupportModule_ProvidesBlipsProviderFactory.create(supportModule2);
        this.providesOkHttpClientProvider = SupportModule_ProvidesOkHttpClientFactory.create(supportModule2);
        this.actionHandlerRegistryProvider = CoreModule_ActionHandlerRegistryFactory.create(coreModule);
        this.requestInfoDataSourceProvider = SupportSdkModule_RequestInfoDataSourceFactory.create(supportSdkModule3, this.supportUiStorageProvider, this.mainThreadExecutorProvider, this.getExecutorServiceProvider);
        a obj4 = a.a(SupportSdkModule_OkHttp3DownloaderFactory.create(supportSdkModule3, this.providesOkHttpClientProvider));
        this.okHttp3DownloaderProvider = obj4;
        this.providesPicassoProvider = a.a(SupportSdkModule_ProvidesPicassoFactory.create(supportSdkModule3, this.getApplicationContextProvider, obj4, this.getExecutorServiceProvider));
        this.configurationHelperProvider = SupportSdkModule_ConfigurationHelperFactory.create(supportSdkModule3);
        this.getMemoryCacheProvider = CoreModule_GetMemoryCacheFactory.create(coreModule);
    }

    private zendesk.support.DeepLinkingBroadcastReceiver injectDeepLinkingBroadcastReceiver(zendesk.support.DeepLinkingBroadcastReceiver deepLinkingBroadcastReceiver) {
        DeepLinkingBroadcastReceiver_MembersInjector.injectRegistry(deepLinkingBroadcastReceiver, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
        return deepLinkingBroadcastReceiver;
    }

    private zendesk.support.SdkDependencyProvider injectSdkDependencyProvider(zendesk.support.SdkDependencyProvider sdkDependencyProvider) {
        SdkDependencyProvider_MembersInjector.injectRegistry(sdkDependencyProvider, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
        SdkDependencyProvider_MembersInjector.injectActionHandlers(sdkDependencyProvider, (List)this.providesActionHandlersProvider.get());
        return sdkDependencyProvider;
    }

    @Override // zendesk.support.SupportSdkComponent
    public void inject(zendesk.support.DeepLinkingBroadcastReceiver deepLinkingBroadcastReceiver) {
        injectDeepLinkingBroadcastReceiver(deepLinkingBroadcastReceiver);
    }

    @Override // zendesk.support.SupportSdkComponent
    public void inject(zendesk.support.SdkDependencyProvider sdkDependencyProvider) {
        injectSdkDependencyProvider(sdkDependencyProvider);
    }

    @Override // zendesk.support.SupportSdkComponent
    public RequestComponent plus(RequestModule requestModule) {
        d.b(requestModule);
        DaggerSupportSdkComponent.RequestComponentImpl requestComponentImpl = new DaggerSupportSdkComponent.RequestComponentImpl(this, requestModule, 0);
        return requestComponentImpl;
    }

    @Override // zendesk.support.SupportSdkComponent
    public RequestListComponent plus(RequestListModule requestListModule, RequestListViewModule requestListViewModule2) {
        d.b(requestListModule);
        d.b(requestListViewModule2);
        DaggerSupportSdkComponent.RequestListComponentImpl requestListComponentImpl = new DaggerSupportSdkComponent.RequestListComponentImpl(this, requestListModule, requestListViewModule2, 0);
        return requestListComponentImpl;
    }
}
