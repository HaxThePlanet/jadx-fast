package zendesk.support;

import android.os.Handler;
import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class SupportEngineModule_ProvideHandlerFactory implements b<Handler> {

    private final zendesk.support.SupportEngineModule module;
    public SupportEngineModule_ProvideHandlerFactory(zendesk.support.SupportEngineModule supportEngineModule) {
        super();
        this.module = supportEngineModule;
    }

    public static zendesk.support.SupportEngineModule_ProvideHandlerFactory create(zendesk.support.SupportEngineModule supportEngineModule) {
        SupportEngineModule_ProvideHandlerFactory supportEngineModule_ProvideHandlerFactory = new SupportEngineModule_ProvideHandlerFactory(supportEngineModule);
        return supportEngineModule_ProvideHandlerFactory;
    }

    public static Handler provideHandler(zendesk.support.SupportEngineModule supportEngineModule) {
        final Handler obj1 = supportEngineModule.provideHandler();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Handler)obj1;
    }

    @Override // g.b.b
    public Handler get() {
        return SupportEngineModule_ProvideHandlerFactory.provideHandler(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
