package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import java.io.File;
import okhttp3.Cache;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideCacheFactory implements b<Cache> {

    private final a<File> fileProvider;
    public ZendeskStorageModule_ProvideCacheFactory(a<File> a) {
        super();
        this.fileProvider = a;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideCacheFactory create(a<File> a) {
        ZendeskStorageModule_ProvideCacheFactory zendeskStorageModule_ProvideCacheFactory = new ZendeskStorageModule_ProvideCacheFactory(a);
        return zendeskStorageModule_ProvideCacheFactory;
    }

    public static Cache provideCache(File file) {
        final Cache obj1 = ZendeskStorageModule.provideCache(file);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Cache)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public Cache get() {
        return ZendeskStorageModule_ProvideCacheFactory.provideCache((File)this.fileProvider.get());
    }
}
