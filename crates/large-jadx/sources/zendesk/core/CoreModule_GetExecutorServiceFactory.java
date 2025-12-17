package zendesk.core;

import g.b.b;
import g.b.d;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class CoreModule_GetExecutorServiceFactory implements b<ExecutorService> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetExecutorServiceFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetExecutorServiceFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetExecutorServiceFactory coreModule_GetExecutorServiceFactory = new CoreModule_GetExecutorServiceFactory(coreModule);
        return coreModule_GetExecutorServiceFactory;
    }

    public static ExecutorService getExecutorService(zendesk.core.CoreModule coreModule) {
        final ExecutorService obj1 = coreModule.getExecutorService();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ExecutorService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public ExecutorService get() {
        return CoreModule_GetExecutorServiceFactory.getExecutorService(this.module);
    }
}
