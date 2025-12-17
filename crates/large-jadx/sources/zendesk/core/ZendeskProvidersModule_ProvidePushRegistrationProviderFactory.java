package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvidePushRegistrationProviderFactory implements b<zendesk.core.PushRegistrationProvider> {

    private final a<zendesk.core.BlipsCoreProvider> blipsProvider;
    private final a<Context> contextProvider;
    private final a<zendesk.core.IdentityManager> identityManagerProvider;
    private final a<zendesk.core.PushDeviceIdStorage> pushDeviceIdStorageProvider;
    private final a<zendesk.core.PushRegistrationService> pushRegistrationServiceProvider;
    private final a<zendesk.core.SettingsProvider> settingsProvider;
    public ZendeskProvidersModule_ProvidePushRegistrationProviderFactory(a<zendesk.core.PushRegistrationService> a, a<zendesk.core.IdentityManager> a2, a<zendesk.core.SettingsProvider> a3, a<zendesk.core.BlipsCoreProvider> a4, a<zendesk.core.PushDeviceIdStorage> a5, a<Context> a6) {
        super();
        this.pushRegistrationServiceProvider = a;
        this.identityManagerProvider = a2;
        this.settingsProvider = a3;
        this.blipsProvider = a4;
        this.pushDeviceIdStorageProvider = a5;
        this.contextProvider = a6;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvidePushRegistrationProviderFactory create(a<zendesk.core.PushRegistrationService> a, a<zendesk.core.IdentityManager> a2, a<zendesk.core.SettingsProvider> a3, a<zendesk.core.BlipsCoreProvider> a4, a<zendesk.core.PushDeviceIdStorage> a5, a<Context> a6) {
        super(a, a2, a3, a4, a5, a6);
        return zendeskProvidersModule_ProvidePushRegistrationProviderFactory;
    }

    public static zendesk.core.PushRegistrationProvider providePushRegistrationProvider(Object object, Object object2, zendesk.core.SettingsProvider settingsProvider3, Object object4, Object object5, Context context6) {
        final zendesk.core.PushRegistrationProvider obj6 = ZendeskProvidersModule.providePushRegistrationProvider((PushRegistrationService)object, (IdentityManager)object2, settingsProvider3, (BlipsCoreProvider)object4, (PushDeviceIdStorage)object5, context6);
        d.c(obj6, "Cannot return null from a non-@Nullable @Provides method");
        return (PushRegistrationProvider)obj6;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.PushRegistrationProvider get() {
        return ZendeskProvidersModule_ProvidePushRegistrationProviderFactory.providePushRegistrationProvider(this.pushRegistrationServiceProvider.get(), this.identityManagerProvider.get(), (SettingsProvider)this.settingsProvider.get(), this.blipsProvider.get(), this.pushDeviceIdStorageProvider.get(), (Context)this.contextProvider.get());
    }
}
