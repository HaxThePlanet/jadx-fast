package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideSdkBaseStorageFactory implements b<zendesk.core.BaseStorage> {

    private final a<Context> contextProvider;
    private final a<zendesk.core.Serializer> serializerProvider;
    public ZendeskStorageModule_ProvideSdkBaseStorageFactory(a<Context> a, a<zendesk.core.Serializer> a2) {
        super();
        this.contextProvider = a;
        this.serializerProvider = a2;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideSdkBaseStorageFactory create(a<Context> a, a<zendesk.core.Serializer> a2) {
        ZendeskStorageModule_ProvideSdkBaseStorageFactory zendeskStorageModule_ProvideSdkBaseStorageFactory = new ZendeskStorageModule_ProvideSdkBaseStorageFactory(a, a2);
        return zendeskStorageModule_ProvideSdkBaseStorageFactory;
    }

    public static zendesk.core.BaseStorage provideSdkBaseStorage(Context context, Object object2) {
        final zendesk.core.BaseStorage obj0 = ZendeskStorageModule.provideSdkBaseStorage(context, (Serializer)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (BaseStorage)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.BaseStorage get() {
        return ZendeskStorageModule_ProvideSdkBaseStorageFactory.provideSdkBaseStorage((Context)this.contextProvider.get(), this.serializerProvider.get());
    }
}
