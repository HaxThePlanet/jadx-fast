package zendesk.support.requestlist;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import zendesk.support.RequestProvider;
import zendesk.support.SupportUiStorage;

/* loaded from: classes3.dex */
public final class RequestListModule_RepositoryFactory implements b<zendesk.support.requestlist.RequestInfoDataSource.Repository> {

    private final a<ExecutorService> backgroundThreadExecutorProvider;
    private final a<zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource> localDataSourceProvider;
    private final a<Executor> mainThreadExecutorProvider;
    private final a<RequestProvider> requestProvider;
    private final a<SupportUiStorage> supportUiStorageProvider;
    public RequestListModule_RepositoryFactory(a<zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource> a, a<SupportUiStorage> a2, a<RequestProvider> a3, a<Executor> a4, a<ExecutorService> a5) {
        super();
        this.localDataSourceProvider = a;
        this.supportUiStorageProvider = a2;
        this.requestProvider = a3;
        this.mainThreadExecutorProvider = a4;
        this.backgroundThreadExecutorProvider = a5;
    }

    public static zendesk.support.requestlist.RequestListModule_RepositoryFactory create(a<zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource> a, a<SupportUiStorage> a2, a<RequestProvider> a3, a<Executor> a4, a<ExecutorService> a5) {
        super(a, a2, a3, a4, a5);
        return requestListModule_RepositoryFactory;
    }

    public static zendesk.support.requestlist.RequestInfoDataSource.Repository repository(zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource requestInfoDataSource$LocalDataSource, SupportUiStorage supportUiStorage2, RequestProvider requestProvider3, Executor executor4, ExecutorService executorService5) {
        final zendesk.support.requestlist.RequestInfoDataSource.Repository obj0 = RequestListModule.repository(localDataSource, supportUiStorage2, requestProvider3, executor4, executorService5);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestInfoDataSource.Repository)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.requestlist.RequestInfoDataSource.Repository get() {
        return RequestListModule_RepositoryFactory.repository((RequestInfoDataSource.LocalDataSource)this.localDataSourceProvider.get(), (SupportUiStorage)this.supportUiStorageProvider.get(), (RequestProvider)this.requestProvider.get(), (Executor)this.mainThreadExecutorProvider.get(), (ExecutorService)this.backgroundThreadExecutorProvider.get());
    }
}
