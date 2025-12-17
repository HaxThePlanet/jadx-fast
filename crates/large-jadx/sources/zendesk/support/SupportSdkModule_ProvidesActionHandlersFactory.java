package zendesk.support;

import g.b.b;
import g.b.d;
import java.util.List;
import zendesk.core.ActionHandler;

/* loaded from: classes3.dex */
public final class SupportSdkModule_ProvidesActionHandlersFactory implements b<List<ActionHandler>> {

    private final zendesk.support.SupportSdkModule module;
    public SupportSdkModule_ProvidesActionHandlersFactory(zendesk.support.SupportSdkModule supportSdkModule) {
        super();
        this.module = supportSdkModule;
    }

    public static zendesk.support.SupportSdkModule_ProvidesActionHandlersFactory create(zendesk.support.SupportSdkModule supportSdkModule) {
        SupportSdkModule_ProvidesActionHandlersFactory supportSdkModule_ProvidesActionHandlersFactory = new SupportSdkModule_ProvidesActionHandlersFactory(supportSdkModule);
        return supportSdkModule_ProvidesActionHandlersFactory;
    }

    public static List<ActionHandler> providesActionHandlers(zendesk.support.SupportSdkModule supportSdkModule) {
        final List obj1 = supportSdkModule.providesActionHandlers();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (List)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public List<ActionHandler> get() {
        return SupportSdkModule_ProvidesActionHandlersFactory.providesActionHandlers(this.module);
    }
}
