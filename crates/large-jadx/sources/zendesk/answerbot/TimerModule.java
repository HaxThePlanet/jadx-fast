package zendesk.answerbot;

import android.os.Handler;
import android.os.Looper;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
class TimerModule {
    Handler provideHandler() {
        Handler handler = new Handler(Looper.getMainLooper());
        return handler;
    }

    Timer.Factory timerFactory(Handler handler) {
        Timer.Factory factory = new Timer.Factory(handler);
        return factory;
    }
}
