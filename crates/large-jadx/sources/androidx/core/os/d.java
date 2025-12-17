package androidx.core.os;

import android.os.Handler;
import d.h.k.i;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class d {

    private static class a implements Executor {

        private final Handler a;
        a(Handler handler) {
            super();
            i.c(handler);
            this.a = (Handler)handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            i.c(runnable);
            if (!this.a.post((Runnable)runnable)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(" is shutting down");
            RejectedExecutionException obj3 = new RejectedExecutionException(stringBuilder.toString());
            throw obj3;
        }
    }
    public static Executor a(Handler handler) {
        d.a aVar = new d.a(handler);
        return aVar;
    }
}
