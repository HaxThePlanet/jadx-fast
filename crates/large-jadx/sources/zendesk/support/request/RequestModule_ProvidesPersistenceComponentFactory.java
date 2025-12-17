package zendesk.support.request;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.concurrent.ExecutorService;
import zendesk.support.SupportUiStorage;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesPersistenceComponentFactory implements b<zendesk.support.request.ComponentPersistence> {

    private final a<ExecutorService> executorServiceProvider;
    private final a<zendesk.support.request.ComponentPersistence.PersistenceQueue> queueProvider;
    private final a<SupportUiStorage> supportUiStorageProvider;
    public RequestModule_ProvidesPersistenceComponentFactory(a<SupportUiStorage> a, a<zendesk.support.request.ComponentPersistence.PersistenceQueue> a2, a<ExecutorService> a3) {
        super();
        this.supportUiStorageProvider = a;
        this.queueProvider = a2;
        this.executorServiceProvider = a3;
    }

    public static zendesk.support.request.RequestModule_ProvidesPersistenceComponentFactory create(a<SupportUiStorage> a, a<zendesk.support.request.ComponentPersistence.PersistenceQueue> a2, a<ExecutorService> a3) {
        RequestModule_ProvidesPersistenceComponentFactory requestModule_ProvidesPersistenceComponentFactory = new RequestModule_ProvidesPersistenceComponentFactory(a, a2, a3);
        return requestModule_ProvidesPersistenceComponentFactory;
    }

    public static zendesk.support.request.ComponentPersistence providesPersistenceComponent(SupportUiStorage supportUiStorage, Object object2, ExecutorService executorService3) {
        final zendesk.support.request.ComponentPersistence obj0 = RequestModule.providesPersistenceComponent(supportUiStorage, (ComponentPersistence.PersistenceQueue)object2, executorService3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ComponentPersistence)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.request.ComponentPersistence get() {
        return RequestModule_ProvidesPersistenceComponentFactory.providesPersistenceComponent((SupportUiStorage)this.supportUiStorageProvider.get(), this.queueProvider.get(), (ExecutorService)this.executorServiceProvider.get());
    }
}
