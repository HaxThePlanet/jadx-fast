package zendesk.support;

import android.content.Context;
import com.squareup.picasso.s;
import com.squareup.picasso.t;
import g.b.b;
import g.b.d;
import j.a.a;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class SupportSdkModule_ProvidesPicassoFactory implements b<t> {

    private final a<Context> contextProvider;
    private final a<ExecutorService> executorServiceProvider;
    private final zendesk.support.SupportSdkModule module;
    private final a<s> okHttp3DownloaderProvider;
    public SupportSdkModule_ProvidesPicassoFactory(zendesk.support.SupportSdkModule supportSdkModule, a<Context> a2, a<s> a3, a<ExecutorService> a4) {
        super();
        this.module = supportSdkModule;
        this.contextProvider = a2;
        this.okHttp3DownloaderProvider = a3;
        this.executorServiceProvider = a4;
    }

    public static zendesk.support.SupportSdkModule_ProvidesPicassoFactory create(zendesk.support.SupportSdkModule supportSdkModule, a<Context> a2, a<s> a3, a<ExecutorService> a4) {
        SupportSdkModule_ProvidesPicassoFactory supportSdkModule_ProvidesPicassoFactory = new SupportSdkModule_ProvidesPicassoFactory(supportSdkModule, a2, a3, a4);
        return supportSdkModule_ProvidesPicassoFactory;
    }

    public static t providesPicasso(zendesk.support.SupportSdkModule supportSdkModule, Context context2, s s3, ExecutorService executorService4) {
        final t obj0 = supportSdkModule.providesPicasso(context2, s3, executorService4);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (t)obj0;
    }

    @Override // g.b.b
    public t get() {
        return SupportSdkModule_ProvidesPicassoFactory.providesPicasso(this.module, (Context)this.contextProvider.get(), (s)this.okHttp3DownloaderProvider.get(), (ExecutorService)this.executorServiceProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
