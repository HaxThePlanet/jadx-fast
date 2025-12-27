package o.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: Executors.java */
/* loaded from: classes3.dex */
class g {

    public static class a implements Executor {

        private final Handler a = new Handler();
        public a() {
            super();
            final Handler handler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
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
        return new g.a();
    }

    static Executor b() {
        return new g.b();
    }
}
