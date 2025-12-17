package androidx.arch.core.executor;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class DefaultTaskExecutor extends androidx.arch.core.executor.TaskExecutor {

    private final ExecutorService mDiskIO;
    private final Object mLock;
    private volatile Handler mMainHandler;

    private static class Api28Impl {
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }
    public DefaultTaskExecutor() {
        super();
        Object object = new Object();
        this.mLock = object;
        DefaultTaskExecutor.1 anon = new DefaultTaskExecutor.1(this);
        this.mDiskIO = Executors.newFixedThreadPool(4, anon);
    }

    private static Handler createAsync(Looper looper) {
        return DefaultTaskExecutor.Api28Impl.createAsync(looper);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable runnable) {
        this.mDiskIO.execute(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        int i;
        i = Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : 0;
        return i;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable runnable) {
        Object mMainHandler;
        Handler mMainHandler2;
        mMainHandler = this.mLock;
        if (this.mMainHandler == null && this.mMainHandler == null) {
            mMainHandler = this.mLock;
            synchronized (mMainHandler) {
                this.mMainHandler = DefaultTaskExecutor.createAsync(Looper.getMainLooper());
            }
        }
        this.mMainHandler.post(runnable);
    }
}
