package zendesk.messaging.components;

import android.os.Handler;

/* loaded from: classes3.dex */
public class Timer {

    private final Handler handler;
    private boolean isCompleted = false;
    private boolean isEnabled = true;
    private final Runnable runnable;
    private final int timeout;

    public static class Factory {

        private final Handler handler;
        public Factory(Handler handler) {
            super();
            this.handler = handler;
        }

        public zendesk.messaging.components.Timer create(Runnable runnable, int i2) {
            Timer timer = new Timer(this.handler, runnable, i2);
            return timer;
        }
    }
    public Timer(Handler handler, Runnable runnable2, int i3) {
        super();
        int i = 1;
        int i2 = 0;
        this.handler = handler;
        Timer.1 obj2 = new Timer.1(this, runnable2);
        this.runnable = obj2;
        this.timeout = i3;
    }

    static boolean access$002(zendesk.messaging.components.Timer timer, boolean z2) {
        timer.isCompleted = z2;
        return z2;
    }

    public void disable() {
        this.handler.removeCallbacks(this.runnable);
        this.isEnabled = false;
    }

    public boolean start() {
        boolean isCompleted;
        if (this.isEnabled && !this.isCompleted) {
            if (!this.isCompleted) {
                this.handler.removeCallbacks(this.runnable);
                this.handler.postDelayed(this.runnable, (long)timeout);
                return 1;
            }
        }
        return 0;
    }
}
