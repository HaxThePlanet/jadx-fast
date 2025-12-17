package androidx.arch.core.executor;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ArchTaskExecutor extends androidx.arch.core.executor.TaskExecutor {

    private static final Executor sIOThreadExecutor;
    private static volatile androidx.arch.core.executor.ArchTaskExecutor sInstance;
    private static final Executor sMainThreadExecutor;
    private final androidx.arch.core.executor.TaskExecutor mDefaultTaskExecutor;
    private androidx.arch.core.executor.TaskExecutor mDelegate;
    static {
        ArchTaskExecutor$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ArchTaskExecutor$$ExternalSyntheticLambda0();
        ArchTaskExecutor.sMainThreadExecutor = externalSyntheticLambda0;
        ArchTaskExecutor$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ArchTaskExecutor$$ExternalSyntheticLambda1();
        ArchTaskExecutor.sIOThreadExecutor = externalSyntheticLambda1;
    }

    private ArchTaskExecutor() {
        super();
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = defaultTaskExecutor;
        this.mDelegate = this.mDefaultTaskExecutor;
    }

    public static Executor getIOThreadExecutor() {
        return ArchTaskExecutor.sIOThreadExecutor;
    }

    public static androidx.arch.core.executor.ArchTaskExecutor getInstance() {
        androidx.arch.core.executor.ArchTaskExecutor archTaskExecutor;
        if (ArchTaskExecutor.sInstance != null) {
            return ArchTaskExecutor.sInstance;
        }
        Class<androidx.arch.core.executor.ArchTaskExecutor> obj = ArchTaskExecutor.class;
        synchronized (obj) {
            archTaskExecutor = new ArchTaskExecutor();
            ArchTaskExecutor.sInstance = archTaskExecutor;
            return ArchTaskExecutor.sInstance;
        }
    }

    public static Executor getMainThreadExecutor() {
        return ArchTaskExecutor.sMainThreadExecutor;
    }

    static void lambda$static$0(Runnable command) {
        ArchTaskExecutor.getInstance().postToMainThread(command);
    }

    static void lambda$static$1(Runnable command) {
        ArchTaskExecutor.getInstance().executeOnDiskIO(command);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable runnable) {
        this.mDelegate.executeOnDiskIO(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable runnable) {
        this.mDelegate.postToMainThread(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void setDelegate(androidx.arch.core.executor.TaskExecutor taskExecutor) {
        androidx.arch.core.executor.TaskExecutor mDefaultTaskExecutor;
        mDefaultTaskExecutor = taskExecutor == null ? this.mDefaultTaskExecutor : taskExecutor;
        this.mDelegate = mDefaultTaskExecutor;
    }
}
