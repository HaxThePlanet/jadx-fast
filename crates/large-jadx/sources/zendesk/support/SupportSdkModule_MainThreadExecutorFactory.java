package zendesk.support;

import g.b.b;
import g.b.d;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class SupportSdkModule_MainThreadExecutorFactory implements b<Executor> {

    private final zendesk.support.SupportSdkModule module;
    public SupportSdkModule_MainThreadExecutorFactory(zendesk.support.SupportSdkModule supportSdkModule) {
        super();
        this.module = supportSdkModule;
    }

    public static zendesk.support.SupportSdkModule_MainThreadExecutorFactory create(zendesk.support.SupportSdkModule supportSdkModule) {
        SupportSdkModule_MainThreadExecutorFactory supportSdkModule_MainThreadExecutorFactory = new SupportSdkModule_MainThreadExecutorFactory(supportSdkModule);
        return supportSdkModule_MainThreadExecutorFactory;
    }

    public static Executor mainThreadExecutor(zendesk.support.SupportSdkModule supportSdkModule) {
        final Executor obj1 = supportSdkModule.mainThreadExecutor();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Executor)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public Executor get() {
        return SupportSdkModule_MainThreadExecutorFactory.mainThreadExecutor(this.module);
    }
}
