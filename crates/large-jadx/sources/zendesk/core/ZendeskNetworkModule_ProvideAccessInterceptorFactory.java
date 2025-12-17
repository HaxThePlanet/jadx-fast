package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideAccessInterceptorFactory implements b<zendesk.core.ZendeskAccessInterceptor> {

    private final a<zendesk.core.AccessProvider> accessProvider;
    private final a<zendesk.core.CoreSettingsStorage> coreSettingsStorageProvider;
    private final a<zendesk.core.IdentityManager> identityManagerProvider;
    private final a<zendesk.core.Storage> storageProvider;
    public ZendeskNetworkModule_ProvideAccessInterceptorFactory(a<zendesk.core.IdentityManager> a, a<zendesk.core.AccessProvider> a2, a<zendesk.core.Storage> a3, a<zendesk.core.CoreSettingsStorage> a4) {
        super();
        this.identityManagerProvider = a;
        this.accessProvider = a2;
        this.storageProvider = a3;
        this.coreSettingsStorageProvider = a4;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideAccessInterceptorFactory create(a<zendesk.core.IdentityManager> a, a<zendesk.core.AccessProvider> a2, a<zendesk.core.Storage> a3, a<zendesk.core.CoreSettingsStorage> a4) {
        ZendeskNetworkModule_ProvideAccessInterceptorFactory zendeskNetworkModule_ProvideAccessInterceptorFactory = new ZendeskNetworkModule_ProvideAccessInterceptorFactory(a, a2, a3, a4);
        return zendeskNetworkModule_ProvideAccessInterceptorFactory;
    }

    public static zendesk.core.ZendeskAccessInterceptor provideAccessInterceptor(Object object, Object object2, Object object3, Object object4) {
        final zendesk.core.ZendeskAccessInterceptor obj0 = ZendeskNetworkModule.provideAccessInterceptor((IdentityManager)object, (AccessProvider)object2, (Storage)object3, (CoreSettingsStorage)object4);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskAccessInterceptor)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ZendeskAccessInterceptor get() {
        return ZendeskNetworkModule_ProvideAccessInterceptorFactory.provideAccessInterceptor(this.identityManagerProvider.get(), this.accessProvider.get(), this.storageProvider.get(), this.coreSettingsStorageProvider.get());
    }
}
