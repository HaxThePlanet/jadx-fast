package com.google.firebase.storage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class StorageTaskScheduler {

    private static final ThreadPoolExecutor CALLBACK_QUEUE_EXECUTOR;
    private static final ThreadPoolExecutor COMMAND_POOL_EXECUTOR;
    private static final ThreadPoolExecutor DOWNLOAD_QUEUE_EXECUTOR;
    private static final ThreadPoolExecutor UPLOAD_QUEUE_EXECUTOR;
    private static BlockingQueue<Runnable> mCallbackQueue;
    private static BlockingQueue<Runnable> mCommandQueue;
    private static BlockingQueue<Runnable> mDownloadQueue;
    private static BlockingQueue<Runnable> mUploadQueue;
    public static com.google.firebase.storage.StorageTaskScheduler sInstance;

    static class StorageThreadFactory implements ThreadFactory {

        private final String mNameSuffix;
        private final AtomicInteger threadNumber;
        StorageThreadFactory(String string) {
            super();
            AtomicInteger atomicInteger = new AtomicInteger(1);
            this.threadNumber = atomicInteger;
            this.mNameSuffix = string;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FirebaseStorage-");
            stringBuilder.append(this.mNameSuffix);
            stringBuilder.append(this.threadNumber.getAndIncrement());
            Thread thread = new Thread(runnable, stringBuilder.toString());
            thread.setDaemon(false);
            thread.setPriority(9);
            return thread;
        }
    }
    static {
        StorageTaskScheduler storageTaskScheduler = new StorageTaskScheduler();
        StorageTaskScheduler.sInstance = storageTaskScheduler;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        StorageTaskScheduler.mCommandQueue = linkedBlockingQueue;
        StorageTaskScheduler.StorageThreadFactory storageThreadFactory = new StorageTaskScheduler.StorageThreadFactory("Command-");
        final int i10 = 5;
        final TimeUnit time = sECONDS;
        super(5, 5, i10, obj5, time, StorageTaskScheduler.mCommandQueue, storageThreadFactory);
        StorageTaskScheduler.COMMAND_POOL_EXECUTOR = threadPoolExecutor;
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        StorageTaskScheduler.mUploadQueue = linkedBlockingQueue2;
        StorageTaskScheduler.StorageThreadFactory storageThreadFactory2 = new StorageTaskScheduler.StorageThreadFactory("Upload-");
        super(2, 2, i10, obj5, time, StorageTaskScheduler.mUploadQueue, storageThreadFactory2);
        StorageTaskScheduler.UPLOAD_QUEUE_EXECUTOR = threadPoolExecutor6;
        LinkedBlockingQueue linkedBlockingQueue3 = new LinkedBlockingQueue();
        StorageTaskScheduler.mDownloadQueue = linkedBlockingQueue3;
        StorageTaskScheduler.StorageThreadFactory storageThreadFactory3 = new StorageTaskScheduler.StorageThreadFactory("Download-");
        super(3, 3, i10, obj5, time, StorageTaskScheduler.mDownloadQueue, storageThreadFactory3);
        StorageTaskScheduler.DOWNLOAD_QUEUE_EXECUTOR = threadPoolExecutor7;
        LinkedBlockingQueue linkedBlockingQueue4 = new LinkedBlockingQueue();
        StorageTaskScheduler.mCallbackQueue = linkedBlockingQueue4;
        StorageTaskScheduler.StorageThreadFactory storageThreadFactory4 = new StorageTaskScheduler.StorageThreadFactory("Callbacks-");
        super(1, 1, i10, obj5, time, StorageTaskScheduler.mCallbackQueue, storageThreadFactory4);
        StorageTaskScheduler.CALLBACK_QUEUE_EXECUTOR = threadPoolExecutor8;
        int i = 1;
        threadPoolExecutor.allowCoreThreadTimeOut(i);
        threadPoolExecutor6.allowCoreThreadTimeOut(i);
        threadPoolExecutor7.allowCoreThreadTimeOut(i);
        threadPoolExecutor8.allowCoreThreadTimeOut(i);
    }

    public static com.google.firebase.storage.StorageTaskScheduler getInstance() {
        return StorageTaskScheduler.sInstance;
    }

    public Executor getCommandPoolExecutor() {
        return StorageTaskScheduler.COMMAND_POOL_EXECUTOR;
    }

    public void scheduleCallback(Runnable runnable) {
        StorageTaskScheduler.CALLBACK_QUEUE_EXECUTOR.execute(runnable);
    }

    public void scheduleCommand(Runnable runnable) {
        StorageTaskScheduler.COMMAND_POOL_EXECUTOR.execute(runnable);
    }

    public void scheduleDownload(Runnable runnable) {
        StorageTaskScheduler.DOWNLOAD_QUEUE_EXECUTOR.execute(runnable);
    }

    public void scheduleUpload(Runnable runnable) {
        StorageTaskScheduler.UPLOAD_QUEUE_EXECUTOR.execute(runnable);
    }
}
