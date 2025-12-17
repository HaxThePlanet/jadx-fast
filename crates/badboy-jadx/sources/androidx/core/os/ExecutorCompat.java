package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes5.dex */
public final class ExecutorCompat {

    private static class HandlerExecutor implements Executor {

        private final Handler mHandler;
        HandlerExecutor(Handler handler) {
            super();
            this.mHandler = (Handler)Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            if (!this.mHandler.post((Runnable)Preconditions.checkNotNull(command))) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException(stringBuilder.append(this.mHandler).append(" is shutting down").toString());
            throw rejectedExecutionException;
        }
    }
    public static Executor create(Handler handler) {
        ExecutorCompat.HandlerExecutor handlerExecutor = new ExecutorCompat.HandlerExecutor(handler);
        return handlerExecutor;
    }
}
