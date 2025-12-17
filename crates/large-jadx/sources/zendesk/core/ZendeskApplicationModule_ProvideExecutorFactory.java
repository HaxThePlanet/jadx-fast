package zendesk.core;

import g.b.b;
import g.b.d;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public final class ZendeskApplicationModule_ProvideExecutorFactory implements b<ScheduledExecutorService> {

    private static final zendesk.core.ZendeskApplicationModule_ProvideExecutorFactory INSTANCE;
    static {
        ZendeskApplicationModule_ProvideExecutorFactory zendeskApplicationModule_ProvideExecutorFactory = new ZendeskApplicationModule_ProvideExecutorFactory();
        ZendeskApplicationModule_ProvideExecutorFactory.INSTANCE = zendeskApplicationModule_ProvideExecutorFactory;
    }

    public static zendesk.core.ZendeskApplicationModule_ProvideExecutorFactory create() {
        return ZendeskApplicationModule_ProvideExecutorFactory.INSTANCE;
    }

    public static ScheduledExecutorService provideExecutor() {
        final ScheduledExecutorService provideExecutor = ZendeskApplicationModule.provideExecutor();
        d.c(provideExecutor, "Cannot return null from a non-@Nullable @Provides method");
        return (ScheduledExecutorService)provideExecutor;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public ScheduledExecutorService get() {
        return ZendeskApplicationModule_ProvideExecutorFactory.provideExecutor();
    }
}
