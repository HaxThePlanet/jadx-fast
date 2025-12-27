package f.c.a.b.i;

import f.c.a.b.i.y.a;
import java.util.concurrent.Executor;

/* compiled from: SafeLoggingExecutor.java */
/* loaded from: classes.dex */
class n implements Executor {

    private final Executor a;

    static class a implements Runnable {

        private final Runnable a;
        a(Runnable runnable) {
            super();
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Exception e) {
                a.c("Executor", "Background execution failure.", e);
            }
        }
    }
    n(Executor executor) {
        super();
        this.a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.execute(new n.a(runnable));
    }
}
