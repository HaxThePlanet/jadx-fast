package zendesk.answerbot;

import android.os.Handler;
import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class TimerModule_ProvideHandlerFactory implements b<Handler> {

    private final zendesk.answerbot.TimerModule module;
    public TimerModule_ProvideHandlerFactory(zendesk.answerbot.TimerModule timerModule) {
        super();
        this.module = timerModule;
    }

    public static zendesk.answerbot.TimerModule_ProvideHandlerFactory create(zendesk.answerbot.TimerModule timerModule) {
        TimerModule_ProvideHandlerFactory timerModule_ProvideHandlerFactory = new TimerModule_ProvideHandlerFactory(timerModule);
        return timerModule_ProvideHandlerFactory;
    }

    public static Handler provideHandler(zendesk.answerbot.TimerModule timerModule) {
        final Handler obj1 = timerModule.provideHandler();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Handler)obj1;
    }

    @Override // g.b.b
    public Handler get() {
        return TimerModule_ProvideHandlerFactory.provideHandler(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
