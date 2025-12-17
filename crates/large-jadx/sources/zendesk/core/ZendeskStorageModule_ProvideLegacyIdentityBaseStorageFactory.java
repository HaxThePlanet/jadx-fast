package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory implements b<zendesk.core.SharedPreferencesStorage> {

    private final a<Context> contextProvider;
    private final a<zendesk.core.Serializer> serializerProvider;
    public ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory(a<Context> a, a<zendesk.core.Serializer> a2) {
        super();
        this.contextProvider = a;
        this.serializerProvider = a2;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory create(a<Context> a, a<zendesk.core.Serializer> a2) {
        ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory zendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory = new ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory(a, a2);
        return zendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory;
    }

    public static zendesk.core.SharedPreferencesStorage provideLegacyIdentityBaseStorage(Context context, Object object2) {
        final zendesk.core.SharedPreferencesStorage obj0 = ZendeskStorageModule.provideLegacyIdentityBaseStorage(context, (Serializer)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (SharedPreferencesStorage)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.SharedPreferencesStorage get() {
        return ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory.provideLegacyIdentityBaseStorage((Context)this.contextProvider.get(), this.serializerProvider.get());
    }
}
