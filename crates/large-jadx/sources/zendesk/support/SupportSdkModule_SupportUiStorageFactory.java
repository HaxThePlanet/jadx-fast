package zendesk.support;

import com.google.gson.Gson;
import f.e.a.a;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class SupportSdkModule_SupportUiStorageFactory implements b<zendesk.support.SupportUiStorage> {

    private final a<a> diskLruCacheProvider;
    private final a<Gson> gsonProvider;
    private final zendesk.support.SupportSdkModule module;
    public SupportSdkModule_SupportUiStorageFactory(zendesk.support.SupportSdkModule supportSdkModule, a<a> a2, a<Gson> a3) {
        super();
        this.module = supportSdkModule;
        this.diskLruCacheProvider = a2;
        this.gsonProvider = a3;
    }

    public static zendesk.support.SupportSdkModule_SupportUiStorageFactory create(zendesk.support.SupportSdkModule supportSdkModule, a<a> a2, a<Gson> a3) {
        SupportSdkModule_SupportUiStorageFactory supportSdkModule_SupportUiStorageFactory = new SupportSdkModule_SupportUiStorageFactory(supportSdkModule, a2, a3);
        return supportSdkModule_SupportUiStorageFactory;
    }

    public static zendesk.support.SupportUiStorage supportUiStorage(zendesk.support.SupportSdkModule supportSdkModule, a a2, Gson gson3) {
        final zendesk.support.SupportUiStorage obj0 = supportSdkModule.supportUiStorage(a2, gson3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (SupportUiStorage)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.SupportUiStorage get() {
        return SupportSdkModule_SupportUiStorageFactory.supportUiStorage(this.module, (a)this.diskLruCacheProvider.get(), (Gson)this.gsonProvider.get());
    }
}
