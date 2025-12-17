package zendesk.support;

import com.squareup.picasso.s;
import g.b.b;
import g.b.d;
import j.a.a;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class SupportSdkModule_OkHttp3DownloaderFactory implements b<s> {

    private final zendesk.support.SupportSdkModule module;
    private final a<OkHttpClient> okHttpClientProvider;
    public SupportSdkModule_OkHttp3DownloaderFactory(zendesk.support.SupportSdkModule supportSdkModule, a<OkHttpClient> a2) {
        super();
        this.module = supportSdkModule;
        this.okHttpClientProvider = a2;
    }

    public static zendesk.support.SupportSdkModule_OkHttp3DownloaderFactory create(zendesk.support.SupportSdkModule supportSdkModule, a<OkHttpClient> a2) {
        SupportSdkModule_OkHttp3DownloaderFactory supportSdkModule_OkHttp3DownloaderFactory = new SupportSdkModule_OkHttp3DownloaderFactory(supportSdkModule, a2);
        return supportSdkModule_OkHttp3DownloaderFactory;
    }

    public static s okHttp3Downloader(zendesk.support.SupportSdkModule supportSdkModule, OkHttpClient okHttpClient2) {
        final s obj0 = supportSdkModule.okHttp3Downloader(okHttpClient2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (s)obj0;
    }

    @Override // g.b.b
    public s get() {
        return SupportSdkModule_OkHttp3DownloaderFactory.okHttp3Downloader(this.module, (OkHttpClient)this.okHttpClientProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
