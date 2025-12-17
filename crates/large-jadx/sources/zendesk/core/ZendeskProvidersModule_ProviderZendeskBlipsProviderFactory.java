package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProviderZendeskBlipsProviderFactory implements b<zendesk.core.ZendeskBlipsProvider> {

    private final a<zendesk.core.ApplicationConfiguration> applicationConfigurationProvider;
    private final a<zendesk.core.BlipsService> blipsServiceProvider;
    private final a<zendesk.core.CoreSettingsStorage> coreSettingsStorageProvider;
    private final a<zendesk.core.DeviceInfo> deviceInfoProvider;
    private final a<ExecutorService> executorProvider;
    private final a<zendesk.core.IdentityManager> identityManagerProvider;
    private final a<zendesk.core.Serializer> serializerProvider;
    public ZendeskProvidersModule_ProviderZendeskBlipsProviderFactory(a<zendesk.core.BlipsService> a, a<zendesk.core.DeviceInfo> a2, a<zendesk.core.Serializer> a3, a<zendesk.core.IdentityManager> a4, a<zendesk.core.ApplicationConfiguration> a5, a<zendesk.core.CoreSettingsStorage> a6, a<ExecutorService> a7) {
        super();
        this.blipsServiceProvider = a;
        this.deviceInfoProvider = a2;
        this.serializerProvider = a3;
        this.identityManagerProvider = a4;
        this.applicationConfigurationProvider = a5;
        this.coreSettingsStorageProvider = a6;
        this.executorProvider = a7;
    }

    public static zendesk.core.ZendeskProvidersModule_ProviderZendeskBlipsProviderFactory create(a<zendesk.core.BlipsService> a, a<zendesk.core.DeviceInfo> a2, a<zendesk.core.Serializer> a3, a<zendesk.core.IdentityManager> a4, a<zendesk.core.ApplicationConfiguration> a5, a<zendesk.core.CoreSettingsStorage> a6, a<ExecutorService> a7) {
        super(a, a2, a3, a4, a5, a6, a7);
        return zendeskProvidersModule_ProviderZendeskBlipsProviderFactory;
    }

    public static zendesk.core.ZendeskBlipsProvider providerZendeskBlipsProvider(Object object, Object object2, Object object3, Object object4, zendesk.core.ApplicationConfiguration applicationConfiguration5, Object object6, ExecutorService executorService7) {
        final zendesk.core.ZendeskBlipsProvider obj7 = ZendeskProvidersModule.providerZendeskBlipsProvider((BlipsService)object, (DeviceInfo)object2, (Serializer)object3, (IdentityManager)object4, applicationConfiguration5, (CoreSettingsStorage)object6, executorService7);
        d.c(obj7, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskBlipsProvider)obj7;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ZendeskBlipsProvider get() {
        return ZendeskProvidersModule_ProviderZendeskBlipsProviderFactory.providerZendeskBlipsProvider(this.blipsServiceProvider.get(), this.deviceInfoProvider.get(), this.serializerProvider.get(), this.identityManagerProvider.get(), (ApplicationConfiguration)this.applicationConfigurationProvider.get(), this.coreSettingsStorageProvider.get(), (ExecutorService)this.executorProvider.get());
    }
}
