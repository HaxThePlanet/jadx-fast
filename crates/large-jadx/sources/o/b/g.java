package o.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
class g {

    public static class a implements Executor {

        private final Handler a;
        public a() {
            super();
            Handler handler = new Handler(Looper.getMainLooper());
            this.a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Object myLooper;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.a.post(runnable);
            }
        }
    }

    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }
    static Executor a() {
        g.a aVar = new g.a();
        return aVar;
    }

    static Executor b() {
        g.b bVar = new g.b();
        return bVar;
    }
}
