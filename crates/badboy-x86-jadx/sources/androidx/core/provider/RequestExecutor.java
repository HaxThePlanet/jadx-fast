package androidx.core.provider;

import android.os.Handler;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
class RequestExecutor {

    private static class DefaultThreadFactory implements ThreadFactory {

        private int mPriority;
        private String mThreadName;
        DefaultThreadFactory(String threadName, int priority) {
            super();
            this.mThreadName = threadName;
            this.mPriority = priority;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            RequestExecutor.DefaultThreadFactory.ProcessPriorityThread processPriorityThread = new RequestExecutor.DefaultThreadFactory.ProcessPriorityThread(runnable, this.mThreadName, this.mPriority);
            return processPriorityThread;
        }
    }

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

    private static class ReplyRunnable implements Runnable {

        private Callable<T> mCallable;
        private Consumer<T> mConsumer;
        private Handler mHandler;
        ReplyRunnable(Handler handler, Callable<T> callable2, Consumer<T> consumer3) {
            super();
            this.mCallable = callable2;
            this.mConsumer = consumer3;
            this.mHandler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object call;
            int i;
            try {
                call = this.mCallable.call();
                Throwable e = i;
                RequestExecutor.ReplyRunnable.1 anon = new RequestExecutor.ReplyRunnable.1(this, this.mConsumer, call);
                this.mHandler.post(anon);
            }
        }
    }
    static ThreadPoolExecutor createDefaultExecutor(String threadName, int threadPriority, int keepAliveTimeInMillis) {
        RequestExecutor.DefaultThreadFactory defaultThreadFactory = new RequestExecutor.DefaultThreadFactory(threadName, threadPriority);
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long)keepAliveTimeInMillis, obj5, TimeUnit.MILLISECONDS, linkedBlockingDeque, defaultThreadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static Executor createHandlerExecutor(Handler handler) {
        RequestExecutor.HandlerExecutor handlerExecutor = new RequestExecutor.HandlerExecutor(handler);
        return handlerExecutor;
    }

    static <T> void execute(Executor executor, Callable<T> callable2, Consumer<T> consumer3) {
        RequestExecutor.ReplyRunnable replyRunnable = new RequestExecutor.ReplyRunnable(CalleeHandler.create(), callable2, consumer3);
        executor.execute(replyRunnable);
    }

    static <T> T submit(ExecutorService executor, Callable<T> callable2, int timeoutMillis) throws java.lang.InterruptedException {
        return executor.submit(callable2).get((long)timeoutMillis, runtimeException);
    }
}
