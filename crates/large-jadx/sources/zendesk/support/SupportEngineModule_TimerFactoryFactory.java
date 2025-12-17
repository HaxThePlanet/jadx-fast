package zendesk.support;

import android.os.Handler;
import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
public final class SupportEngineModule_TimerFactoryFactory implements b<Timer.Factory> {

    private final a<Handler> handlerProvider;
    private final zendesk.support.SupportEngineModule module;
    public SupportEngineModule_TimerFactoryFactory(zendesk.support.SupportEngineModule supportEngineModule, a<Handler> a2) {
        super();
        this.module = supportEngineModule;
        this.handlerProvider = a2;
    }

    public static zendesk.support.SupportEngineModule_TimerFactoryFactory create(zendesk.support.SupportEngineModule supportEngineModule, a<Handler> a2) {
        SupportEngineModule_TimerFactoryFactory supportEngineModule_TimerFactoryFactory = new SupportEngineModule_TimerFactoryFactory(supportEngineModule, a2);
        return supportEngineModule_TimerFactoryFactory;
    }

    public static Timer.Factory timerFactory(zendesk.support.SupportEngineModule supportEngineModule, Handler handler2) {
        final Timer.Factory obj0 = supportEngineModule.timerFactory(handler2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (Timer.Factory)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public Timer.Factory get() {
        return SupportEngineModule_TimerFactoryFactory.timerFactory(this.module, (Handler)this.handlerProvider.get());
    }
}
