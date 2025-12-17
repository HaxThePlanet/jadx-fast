package zendesk.support;

import g.b.b;
import g.b.d;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class GuideModule_ProvidesOkHttpClientFactory implements b<OkHttpClient> {

    private final zendesk.support.GuideModule module;
    public GuideModule_ProvidesOkHttpClientFactory(zendesk.support.GuideModule guideModule) {
        super();
        this.module = guideModule;
    }

    public static zendesk.support.GuideModule_ProvidesOkHttpClientFactory create(zendesk.support.GuideModule guideModule) {
        GuideModule_ProvidesOkHttpClientFactory guideModule_ProvidesOkHttpClientFactory = new GuideModule_ProvidesOkHttpClientFactory(guideModule);
        return guideModule_ProvidesOkHttpClientFactory;
    }

    public static OkHttpClient providesOkHttpClient(zendesk.support.GuideModule guideModule) {
        final OkHttpClient obj1 = guideModule.providesOkHttpClient();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (OkHttpClient)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public OkHttpClient get() {
        return GuideModule_ProvidesOkHttpClientFactory.providesOkHttpClient(this.module);
    }
}
