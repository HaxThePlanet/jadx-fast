package zendesk.core;

import com.google.gson.Gson;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideSerializerFactory implements b<zendesk.core.Serializer> {

    private final a<Gson> gsonProvider;
    public ZendeskStorageModule_ProvideSerializerFactory(a<Gson> a) {
        super();
        this.gsonProvider = a;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideSerializerFactory create(a<Gson> a) {
        ZendeskStorageModule_ProvideSerializerFactory zendeskStorageModule_ProvideSerializerFactory = new ZendeskStorageModule_ProvideSerializerFactory(a);
        return zendeskStorageModule_ProvideSerializerFactory;
    }

    public static zendesk.core.Serializer provideSerializer(Gson gson) {
        final zendesk.core.Serializer obj1 = ZendeskStorageModule.provideSerializer(gson);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Serializer)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.Serializer get() {
        return ZendeskStorageModule_ProvideSerializerFactory.provideSerializer((Gson)this.gsonProvider.get());
    }
}
