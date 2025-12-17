package zendesk.messaging;

import android.os.Handler;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TypingEventDispatcher {

    static final long TYPING_WINDOW;
    private final zendesk.messaging.EventFactory eventFactory;
    private final zendesk.messaging.EventListener eventListener;
    private final Handler handler;
    boolean isTyping = false;
    final Runnable typingStopRunnable;
    static {
        TypingEventDispatcher.TYPING_WINDOW = TimeUnit.SECONDS.toMillis(3);
    }

    public TypingEventDispatcher(zendesk.messaging.EventListener eventListener, Handler handler2, zendesk.messaging.EventFactory eventFactory3) {
        super();
        this.eventListener = eventListener;
        this.handler = handler2;
        this.eventFactory = eventFactory3;
        TypingEventDispatcher.1 obj2 = new TypingEventDispatcher.1(this, eventListener, eventFactory3);
        this.typingStopRunnable = obj2;
        final int obj1 = 0;
    }

    public void onTyping() {
        Handler handler;
        Runnable typingStopRunnable;
        long tYPING_WINDOW;
        if (this.isTyping) {
            this.handler.removeCallbacks(this.typingStopRunnable);
            this.handler.postDelayed(this.typingStopRunnable, TypingEventDispatcher.TYPING_WINDOW);
        } else {
            this.isTyping = true;
            this.eventListener.onEvent(this.eventFactory.typingStart());
            this.handler.postDelayed(this.typingStopRunnable, TypingEventDispatcher.TYPING_WINDOW);
        }
    }
}
