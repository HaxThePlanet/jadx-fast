package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import java.io.File;
import okhttp3.Cache;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvideSessionStorageFactory implements b<zendesk.core.SessionStorage> {

    private final a<zendesk.core.BaseStorage> additionalSdkStorageProvider;
    private final a<File> belvedereDirProvider;
    private final a<File> cacheDirProvider;
    private final a<Cache> cacheProvider;
    private final a<File> dataDirProvider;
    private final a<zendesk.core.IdentityStorage> identityStorageProvider;
    private final a<zendesk.core.BaseStorage> mediaCacheProvider;
    public ZendeskStorageModule_ProvideSessionStorageFactory(a<zendesk.core.IdentityStorage> a, a<zendesk.core.BaseStorage> a2, a<zendesk.core.BaseStorage> a3, a<Cache> a4, a<File> a5, a<File> a6, a<File> a7) {
        super();
        this.identityStorageProvider = a;
        this.additionalSdkStorageProvider = a2;
        this.mediaCacheProvider = a3;
        this.cacheProvider = a4;
        this.cacheDirProvider = a5;
        this.dataDirProvider = a6;
        this.belvedereDirProvider = a7;
    }

    public static zendesk.core.ZendeskStorageModule_ProvideSessionStorageFactory create(a<zendesk.core.IdentityStorage> a, a<zendesk.core.BaseStorage> a2, a<zendesk.core.BaseStorage> a3, a<Cache> a4, a<File> a5, a<File> a6, a<File> a7) {
        super(a, a2, a3, a4, a5, a6, a7);
        return zendeskStorageModule_ProvideSessionStorageFactory;
    }

    public static zendesk.core.SessionStorage provideSessionStorage(Object object, zendesk.core.BaseStorage baseStorage2, zendesk.core.BaseStorage baseStorage3, Cache cache4, File file5, File file6, File file7) {
        final zendesk.core.SessionStorage obj7 = ZendeskStorageModule.provideSessionStorage((IdentityStorage)object, baseStorage2, baseStorage3, cache4, file5, file6, file7);
        d.c(obj7, "Cannot return null from a non-@Nullable @Provides method");
        return (SessionStorage)obj7;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.SessionStorage get() {
        return ZendeskStorageModule_ProvideSessionStorageFactory.provideSessionStorage(this.identityStorageProvider.get(), (BaseStorage)this.additionalSdkStorageProvider.get(), (BaseStorage)this.mediaCacheProvider.get(), (Cache)this.cacheProvider.get(), (File)this.cacheDirProvider.get(), (File)this.dataDirProvider.get(), (File)this.belvedereDirProvider.get());
    }
}
