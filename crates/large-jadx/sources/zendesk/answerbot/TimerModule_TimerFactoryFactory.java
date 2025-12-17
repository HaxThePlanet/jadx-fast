package zendesk.answerbot;

import android.os.Handler;
import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
public final class TimerModule_TimerFactoryFactory implements b<Timer.Factory> {

    private final a<Handler> handlerProvider;
    private final zendesk.answerbot.TimerModule module;
    public TimerModule_TimerFactoryFactory(zendesk.answerbot.TimerModule timerModule, a<Handler> a2) {
        super();
        this.module = timerModule;
        this.handlerProvider = a2;
    }

    public static zendesk.answerbot.TimerModule_TimerFactoryFactory create(zendesk.answerbot.TimerModule timerModule, a<Handler> a2) {
        TimerModule_TimerFactoryFactory timerModule_TimerFactoryFactory = new TimerModule_TimerFactoryFactory(timerModule, a2);
        return timerModule_TimerFactoryFactory;
    }

    public static Timer.Factory timerFactory(zendesk.answerbot.TimerModule timerModule, Handler handler2) {
        final Timer.Factory obj0 = timerModule.timerFactory(handler2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (Timer.Factory)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public Timer.Factory get() {
        return TimerModule_TimerFactoryFactory.timerFactory(this.module, (Handler)this.handlerProvider.get());
    }
}
