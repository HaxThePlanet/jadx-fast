package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.messaging.Update;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.CompositeActionListener;

/* loaded from: classes3.dex */
public final class SupportEngineModule_UpdateActionListenerFactory implements b<ActionListener<Update>> {

    private final zendesk.support.SupportEngineModule module;
    private final a<CompositeActionListener<Update>> observerProvider;
    public SupportEngineModule_UpdateActionListenerFactory(zendesk.support.SupportEngineModule supportEngineModule, a<CompositeActionListener<Update>> a2) {
        super();
        this.module = supportEngineModule;
        this.observerProvider = a2;
    }

    public static zendesk.support.SupportEngineModule_UpdateActionListenerFactory create(zendesk.support.SupportEngineModule supportEngineModule, a<CompositeActionListener<Update>> a2) {
        SupportEngineModule_UpdateActionListenerFactory supportEngineModule_UpdateActionListenerFactory = new SupportEngineModule_UpdateActionListenerFactory(supportEngineModule, a2);
        return supportEngineModule_UpdateActionListenerFactory;
    }

    public static ActionListener<Update> updateActionListener(zendesk.support.SupportEngineModule supportEngineModule, CompositeActionListener<Update> compositeActionListener2) {
        final ActionListener obj0 = supportEngineModule.updateActionListener(compositeActionListener2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ActionListener)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public ActionListener<Update> get() {
        return SupportEngineModule_UpdateActionListenerFactory.updateActionListener(this.module, (CompositeActionListener)this.observerProvider.get());
    }
}
