package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource;

/* loaded from: classes3.dex */
public final class SupportSdkModule_RequestInfoDataSourceFactory implements b<RequestInfoDataSource.LocalDataSource> {

    private final a<ExecutorService> backgroundThreadExecutorProvider;
    private final a<Executor> mainThreadExecutorProvider;
    private final zendesk.support.SupportSdkModule module;
    private final a<zendesk.support.SupportUiStorage> supportUiStorageProvider;
    public SupportSdkModule_RequestInfoDataSourceFactory(zendesk.support.SupportSdkModule supportSdkModule, a<zendesk.support.SupportUiStorage> a2, a<Executor> a3, a<ExecutorService> a4) {
        super();
        this.module = supportSdkModule;
        this.supportUiStorageProvider = a2;
        this.mainThreadExecutorProvider = a3;
        this.backgroundThreadExecutorProvider = a4;
    }

    public static zendesk.support.SupportSdkModule_RequestInfoDataSourceFactory create(zendesk.support.SupportSdkModule supportSdkModule, a<zendesk.support.SupportUiStorage> a2, a<Executor> a3, a<ExecutorService> a4) {
        SupportSdkModule_RequestInfoDataSourceFactory supportSdkModule_RequestInfoDataSourceFactory = new SupportSdkModule_RequestInfoDataSourceFactory(supportSdkModule, a2, a3, a4);
        return supportSdkModule_RequestInfoDataSourceFactory;
    }

    public static RequestInfoDataSource.LocalDataSource requestInfoDataSource(zendesk.support.SupportSdkModule supportSdkModule, zendesk.support.SupportUiStorage supportUiStorage2, Executor executor3, ExecutorService executorService4) {
        final RequestInfoDataSource.LocalDataSource obj0 = supportSdkModule.requestInfoDataSource(supportUiStorage2, executor3, executorService4);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestInfoDataSource.LocalDataSource)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public RequestInfoDataSource.LocalDataSource get() {
        return SupportSdkModule_RequestInfoDataSourceFactory.requestInfoDataSource(this.module, (SupportUiStorage)this.supportUiStorageProvider.get(), (Executor)this.mainThreadExecutorProvider.get(), (ExecutorService)this.backgroundThreadExecutorProvider.get());
    }
}
