package zendesk.core;

import g.b.b;
import g.b.d;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class CoreModule_GetExecutorFactory implements b<Executor> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetExecutorFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetExecutorFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetExecutorFactory coreModule_GetExecutorFactory = new CoreModule_GetExecutorFactory(coreModule);
        return coreModule_GetExecutorFactory;
    }

    public static Executor getExecutor(zendesk.core.CoreModule coreModule) {
        final Executor obj1 = coreModule.getExecutor();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Executor)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public Executor get() {
        return CoreModule_GetExecutorFactory.getExecutor(this.module);
    }
}
