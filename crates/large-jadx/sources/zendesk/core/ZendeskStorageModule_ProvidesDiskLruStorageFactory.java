package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import java.io.File;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvidesDiskLruStorageFactory implements b<zendesk.core.BaseStorage> {

    private final a<File> fileProvider;
    private final a<zendesk.core.Serializer> serializerProvider;
    public ZendeskStorageModule_ProvidesDiskLruStorageFactory(a<File> a, a<zendesk.core.Serializer> a2) {
        super();
        this.fileProvider = a;
        this.serializerProvider = a2;
    }

    public static zendesk.core.ZendeskStorageModule_ProvidesDiskLruStorageFactory create(a<File> a, a<zendesk.core.Serializer> a2) {
        ZendeskStorageModule_ProvidesDiskLruStorageFactory zendeskStorageModule_ProvidesDiskLruStorageFactory = new ZendeskStorageModule_ProvidesDiskLruStorageFactory(a, a2);
        return zendeskStorageModule_ProvidesDiskLruStorageFactory;
    }

    public static zendesk.core.BaseStorage providesDiskLruStorage(File file, Object object2) {
        final zendesk.core.BaseStorage obj0 = ZendeskStorageModule.providesDiskLruStorage(file, (Serializer)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (BaseStorage)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.BaseStorage get() {
        return ZendeskStorageModule_ProvidesDiskLruStorageFactory.providesDiskLruStorage((File)this.fileProvider.get(), this.serializerProvider.get());
    }
}
