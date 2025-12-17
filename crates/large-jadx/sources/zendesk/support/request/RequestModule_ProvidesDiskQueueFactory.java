package zendesk.support.request;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesDiskQueueFactory implements b<zendesk.support.request.ComponentPersistence.PersistenceQueue> {

    private final a<ExecutorService> executorServiceProvider;
    public RequestModule_ProvidesDiskQueueFactory(a<ExecutorService> a) {
        super();
        this.executorServiceProvider = a;
    }

    public static zendesk.support.request.RequestModule_ProvidesDiskQueueFactory create(a<ExecutorService> a) {
        RequestModule_ProvidesDiskQueueFactory requestModule_ProvidesDiskQueueFactory = new RequestModule_ProvidesDiskQueueFactory(a);
        return requestModule_ProvidesDiskQueueFactory;
    }

    public static zendesk.support.request.ComponentPersistence.PersistenceQueue providesDiskQueue(ExecutorService executorService) {
        final zendesk.support.request.ComponentPersistence.PersistenceQueue obj1 = RequestModule.providesDiskQueue(executorService);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ComponentPersistence.PersistenceQueue)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.request.ComponentPersistence.PersistenceQueue get() {
        return RequestModule_ProvidesDiskQueueFactory.providesDiskQueue((ExecutorService)this.executorServiceProvider.get());
    }
}
