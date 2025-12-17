package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideIdentityBaseStorageFactory implements b<zendesk.core.BaseStorage> {

    private final a<Context> contextProvider;
    private final a<zendesk.core.Serializer> serializerProvider;
    public ZendeskStorageModule_ProvideIdentityBaseStorageFactory(a<Context> a, a<zendesk.core.Serializer> a2) {
        super();
        this.contextProvider = a;
        this.serializerProvider = a2;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideIdentityBaseStorageFactory create(a<Context> a, a<zendesk.core.Serializer> a2) {
        ZendeskStorageModule_ProvideIdentityBaseStorageFactory zendeskStorageModule_ProvideIdentityBaseStorageFactory = new ZendeskStorageModule_ProvideIdentityBaseStorageFactory(a, a2);
        return zendeskStorageModule_ProvideIdentityBaseStorageFactory;
    }

    public static zendesk.core.BaseStorage provideIdentityBaseStorage(Context context, Object object2) {
        final zendesk.core.BaseStorage obj0 = ZendeskStorageModule.provideIdentityBaseStorage(context, (Serializer)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (BaseStorage)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.BaseStorage get() {
        return ZendeskStorageModule_ProvideIdentityBaseStorageFactory.provideIdentityBaseStorage((Context)this.contextProvider.get(), this.serializerProvider.get());
    }
}
