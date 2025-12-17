package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory implements b<zendesk.core.SharedPreferencesStorage> {

    private final a<Context> contextProvider;
    private final a<zendesk.core.Serializer> serializerProvider;
    public ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory(a<Context> a, a<zendesk.core.Serializer> a2) {
        super();
        this.contextProvider = a;
        this.serializerProvider = a2;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory create(a<Context> a, a<zendesk.core.Serializer> a2) {
        ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory zendeskStorageModule_ProvideLegacyPushBaseStorageFactory = new ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory(a, a2);
        return zendeskStorageModule_ProvideLegacyPushBaseStorageFactory;
    }

    public static zendesk.core.SharedPreferencesStorage provideLegacyPushBaseStorage(Context context, Object object2) {
        final zendesk.core.SharedPreferencesStorage obj0 = ZendeskStorageModule.provideLegacyPushBaseStorage(context, (Serializer)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (SharedPreferencesStorage)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.SharedPreferencesStorage get() {
        return ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory.provideLegacyPushBaseStorage((Context)this.contextProvider.get(), this.serializerProvider.get());
    }
}
