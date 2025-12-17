package zendesk.support;

import f.e.a.a;
import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.SessionStorage;

/* loaded from: classes3.dex */
public final class SupportSdkModule_ProvidesRequestDiskLruCacheFactory implements b<a> {

    private final zendesk.support.SupportSdkModule module;
    private final a<SessionStorage> sessionStorageProvider;
    public SupportSdkModule_ProvidesRequestDiskLruCacheFactory(zendesk.support.SupportSdkModule supportSdkModule, a<SessionStorage> a2) {
        super();
        this.module = supportSdkModule;
        this.sessionStorageProvider = a2;
    }

    public static zendesk.support.SupportSdkModule_ProvidesRequestDiskLruCacheFactory create(zendesk.support.SupportSdkModule supportSdkModule, a<SessionStorage> a2) {
        SupportSdkModule_ProvidesRequestDiskLruCacheFactory supportSdkModule_ProvidesRequestDiskLruCacheFactory = new SupportSdkModule_ProvidesRequestDiskLruCacheFactory(supportSdkModule, a2);
        return supportSdkModule_ProvidesRequestDiskLruCacheFactory;
    }

    public static a providesRequestDiskLruCache(zendesk.support.SupportSdkModule supportSdkModule, SessionStorage sessionStorage2) {
        final a obj0 = supportSdkModule.providesRequestDiskLruCache(sessionStorage2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (a)obj0;
    }

    @Override // g.b.b
    public a get() {
        return SupportSdkModule_ProvidesRequestDiskLruCacheFactory.providesRequestDiskLruCache(this.module, (SessionStorage)this.sessionStorageProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
