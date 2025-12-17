package androidx.core.provider;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes5.dex */
@Deprecated
public class SelfDestructiveThread {

    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private Handler.Callback mCallback;
    private final int mDestructAfterMillisec;
    private int mGeneration = 0;
    private Handler mHandler;
    private final Object mLock;
    private final int mPriority;
    private HandlerThread mThread;
    private final String mThreadName;

    public interface ReplyCallback {
        public abstract void onReply(T t);
    }
    public SelfDestructiveThread(String threadName, int priority, int destructAfterMillisec) {
        super();
        Object object = new Object();
        this.mLock = object;
        SelfDestructiveThread.1 anon = new SelfDestructiveThread.1(this);
        this.mCallback = anon;
        this.mThreadName = threadName;
        this.mPriority = priority;
        this.mDestructAfterMillisec = destructAfterMillisec;
        int i = 0;
    }

    private void post(Runnable runnable) {
        HandlerThread mThread;
        android.os.Looper looper;
        Handler.Callback mCallback;
        final Object mLock = this.mLock;
        int i = 1;
        synchronized (mLock) {
            HandlerThread handlerThread = new HandlerThread(this.mThreadName, this.mPriority);
            this.mThread = handlerThread;
            this.mThread.start();
            Handler handler = new Handler(this.mThread.getLooper(), this.mCallback);
            this.mHandler = handler;
            this.mGeneration = mGeneration += i;
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(i, runnable));
        }
    }

    public int getGeneration() {
        final Object mLock = this.mLock;
        return this.mGeneration;
        synchronized (mLock) {
            mLock = this.mLock;
            return this.mGeneration;
        }
    }

    public boolean isRunning() {
        int i;
        final Object mLock = this.mLock;
        synchronized (mLock) {
            i = 1;
            try {
                return i;
                throw th;
            }
        }
    }

    void onDestruction() {
        final Object mLock = this.mLock;
        synchronized (mLock) {
        }
    }

    void onInvokeRunnable(Runnable runnable) {
        runnable.run();
        final Object mLock = this.mLock;
        int i = 0;
        this.mHandler.removeMessages(i);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(i), (long)mDestructAfterMillisec);
        return;
        synchronized (mLock) {
            runnable.run();
            mLock = this.mLock;
            i = 0;
            this.mHandler.removeMessages(i);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(i), (long)mDestructAfterMillisec);
        }
    }

    public <T> void postAndReply(Callable<T> callable, androidx.core.provider.SelfDestructiveThread.ReplyCallback<T> selfDestructiveThread$ReplyCallback2) {
        SelfDestructiveThread.2 anon = new SelfDestructiveThread.2(this, callable, CalleeHandler.create(), replyCallback2);
        post(anon);
    }

    public <T> T postAndWait(Callable<T> callable, int timeoutMillis) throws java.lang.InterruptedException {
        long nanos;
        long awaitNanos;
        long remaining;
        TimeUnit obj11;
        ReentrantLock reentrantLock = new ReentrantLock();
        final ReentrantLock reentrantLock2 = reentrantLock;
        final Condition condition = reentrantLock2.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(1);
        SelfDestructiveThread.3 anon = new SelfDestructiveThread.3(this, atomicReference, callable, reentrantLock2, atomicBoolean, condition);
        post(anon);
        reentrantLock2.lock();
        if (!atomicBoolean.get()) {
            reentrantLock2.unlock();
            return atomicReference.get();
        }
        remaining = nanos;
        while (/* condition */) {
        }
        reentrantLock2.unlock();
        return atomicReference.get();
    }
}
