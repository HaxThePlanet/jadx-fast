package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public final class ZendeskApplicationModule_ProvideExecutorServiceFactory implements b<ExecutorService> {

    private final a<ScheduledExecutorService> scheduledExecutorServiceProvider;
    public ZendeskApplicationModule_ProvideExecutorServiceFactory(a<ScheduledExecutorService> a) {
        super();
        this.scheduledExecutorServiceProvider = a;
    }

    public static zendesk.core.ZendeskApplicationModule_ProvideExecutorServiceFactory create(a<ScheduledExecutorService> a) {
        ZendeskApplicationModule_ProvideExecutorServiceFactory zendeskApplicationModule_ProvideExecutorServiceFactory = new ZendeskApplicationModule_ProvideExecutorServiceFactory(a);
        return zendeskApplicationModule_ProvideExecutorServiceFactory;
    }

    public static ExecutorService provideExecutorService(ScheduledExecutorService scheduledExecutorService) {
        final ExecutorService obj1 = ZendeskApplicationModule.provideExecutorService(scheduledExecutorService);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ExecutorService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public ExecutorService get() {
        return ZendeskApplicationModule_ProvideExecutorServiceFactory.provideExecutorService((ScheduledExecutorService)this.scheduledExecutorServiceProvider.get());
    }
}
