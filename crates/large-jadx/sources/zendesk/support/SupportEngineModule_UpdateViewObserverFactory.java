package zendesk.support;

import g.b.b;
import g.b.d;
import zendesk.messaging.Update;
import zendesk.messaging.components.CompositeActionListener;

/* loaded from: classes3.dex */
public final class SupportEngineModule_UpdateViewObserverFactory implements b<CompositeActionListener<Update>> {

    private final zendesk.support.SupportEngineModule module;
    public SupportEngineModule_UpdateViewObserverFactory(zendesk.support.SupportEngineModule supportEngineModule) {
        super();
        this.module = supportEngineModule;
    }

    public static zendesk.support.SupportEngineModule_UpdateViewObserverFactory create(zendesk.support.SupportEngineModule supportEngineModule) {
        SupportEngineModule_UpdateViewObserverFactory supportEngineModule_UpdateViewObserverFactory = new SupportEngineModule_UpdateViewObserverFactory(supportEngineModule);
        return supportEngineModule_UpdateViewObserverFactory;
    }

    public static CompositeActionListener<Update> updateViewObserver(zendesk.support.SupportEngineModule supportEngineModule) {
        final CompositeActionListener obj1 = supportEngineModule.updateViewObserver();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (CompositeActionListener)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public CompositeActionListener<Update> get() {
        return SupportEngineModule_UpdateViewObserverFactory.updateViewObserver(this.module);
    }
}
