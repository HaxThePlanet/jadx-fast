package zendesk.core;

import g.b.b;
import g.b.d;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public final class CoreModule_GetScheduledExecutorServiceFactory implements b<ScheduledExecutorService> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetScheduledExecutorServiceFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetScheduledExecutorServiceFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetScheduledExecutorServiceFactory coreModule_GetScheduledExecutorServiceFactory = new CoreModule_GetScheduledExecutorServiceFactory(coreModule);
        return coreModule_GetScheduledExecutorServiceFactory;
    }

    public static ScheduledExecutorService getScheduledExecutorService(zendesk.core.CoreModule coreModule) {
        final ScheduledExecutorService obj1 = coreModule.getScheduledExecutorService();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ScheduledExecutorService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public ScheduledExecutorService get() {
        return CoreModule_GetScheduledExecutorServiceFactory.getScheduledExecutorService(this.module);
    }
}
