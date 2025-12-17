package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
class ConcurrencyHelpers {

    private static final int FONT_LOAD_TIMEOUT_SECONDS = 15;

    static class Handler28Impl {
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }
    public static boolean $r8$lambda$mCEi04OcFi8gu0FD463twzV2nG8(Handler handler, Runnable runnable2) {
        return handler.post(runnable2);
    }

    @Deprecated
    static Executor convertHandlerToExecutor(Handler handler) {
        Objects.requireNonNull(handler);
        ConcurrencyHelpers$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ConcurrencyHelpers$$ExternalSyntheticLambda0(handler);
        return externalSyntheticLambda0;
    }

    static ThreadPoolExecutor createBackgroundPriorityExecutor(String name) {
        ConcurrencyHelpers$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ConcurrencyHelpers$$ExternalSyntheticLambda1(name);
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15, obj5, TimeUnit.SECONDS, linkedBlockingDeque, externalSyntheticLambda1);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static Thread lambda$createBackgroundPriorityExecutor$0(String name, Runnable runnable) {
        Thread thread = new Thread(runnable, name);
        thread.setPriority(10);
        return thread;
    }

    static Handler mainHandlerAsync() {
        return ConcurrencyHelpers.Handler28Impl.createAsync(Looper.getMainLooper());
    }
}
