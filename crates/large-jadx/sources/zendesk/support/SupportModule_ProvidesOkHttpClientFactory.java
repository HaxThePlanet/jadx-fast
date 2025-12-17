package zendesk.support;

import g.b.b;
import g.b.d;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class SupportModule_ProvidesOkHttpClientFactory implements b<OkHttpClient> {

    private final zendesk.support.SupportModule module;
    public SupportModule_ProvidesOkHttpClientFactory(zendesk.support.SupportModule supportModule) {
        super();
        this.module = supportModule;
    }

    public static zendesk.support.SupportModule_ProvidesOkHttpClientFactory create(zendesk.support.SupportModule supportModule) {
        SupportModule_ProvidesOkHttpClientFactory supportModule_ProvidesOkHttpClientFactory = new SupportModule_ProvidesOkHttpClientFactory(supportModule);
        return supportModule_ProvidesOkHttpClientFactory;
    }

    public static OkHttpClient providesOkHttpClient(zendesk.support.SupportModule supportModule) {
        final OkHttpClient obj1 = supportModule.providesOkHttpClient();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (OkHttpClient)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public OkHttpClient get() {
        return SupportModule_ProvidesOkHttpClientFactory.providesOkHttpClient(this.module);
    }
}
