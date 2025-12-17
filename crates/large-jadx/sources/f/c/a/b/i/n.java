package f.c.a.b.i;

import f.c.a.b.i.y.a;
import java.util.concurrent.Executor;

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
            Runnable runnable;
            String str;
            String str2;
            try {
                this.a.run();
                a.c("Executor", "Background execution failure.", th);
            }
        }
    }
    n(Executor executor) {
        super();
        this.a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        n.a aVar = new n.a(runnable);
        this.a.execute(aVar);
    }
}
