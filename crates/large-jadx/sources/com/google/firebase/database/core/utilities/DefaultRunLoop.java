package com.google.firebase.database.core.utilities;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.RunLoop;
import com.google.firebase.database.core.ThreadInitializer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class DefaultRunLoop implements RunLoop {

    private ScheduledThreadPoolExecutor executor;

    private class FirebaseThreadFactory implements ThreadFactory {

        final com.google.firebase.database.core.utilities.DefaultRunLoop this$0;
        private FirebaseThreadFactory(com.google.firebase.database.core.utilities.DefaultRunLoop defaultRunLoop) {
            this.this$0 = defaultRunLoop;
            super();
        }

        FirebaseThreadFactory(com.google.firebase.database.core.utilities.DefaultRunLoop defaultRunLoop, com.google.firebase.database.core.utilities.DefaultRunLoop.1 defaultRunLoop$12) {
            super(defaultRunLoop);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            final Thread obj3 = this.this$0.getThreadFactory().newThread(runnable);
            ThreadInitializer threadInitializer = this.this$0.getThreadInitializer();
            threadInitializer.setName(obj3, "FirebaseDatabaseWorker");
            threadInitializer.setDaemon(obj3, true);
            DefaultRunLoop.FirebaseThreadFactory.1 anon = new DefaultRunLoop.FirebaseThreadFactory.1(this);
            threadInitializer.setUncaughtExceptionHandler(obj3, anon);
            return obj3;
        }
    }
    public DefaultRunLoop() {
        super();
        DefaultRunLoop.FirebaseThreadFactory firebaseThreadFactory = new DefaultRunLoop.FirebaseThreadFactory(this, 0);
        DefaultRunLoop.1 anon = new DefaultRunLoop.1(this, 1, firebaseThreadFactory);
        this.executor = anon;
        anon.setKeepAliveTime(3, obj3);
    }

    public static String messageForException(Throwable throwable) {
        if (throwable instanceof OutOfMemoryError != null) {
            return "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        }
        if (throwable instanceof NoClassDefFoundError != null) {
            return "A symbol that the Firebase Database SDK depends on failed to load. This usually indicates that your project includes an incompatible version of another Firebase dependency. If updating your dependencies to the latest version does not resolve this issue, please file a report at https://github.com/firebase/firebase-android-sdk";
        }
        if (throwable instanceof DatabaseException != null) {
            return "";
        }
        StringBuilder obj1 = new StringBuilder();
        obj1.append("Uncaught exception in Firebase Database runloop (");
        obj1.append(FirebaseDatabase.getSdkVersion());
        obj1.append("). If you are not already on the latest version of the Firebase SDKs, try updating your dependencies. Should this problem persist, please file a report at https://github.com/firebase/firebase-android-sdk");
        return obj1.toString();
    }

    @Override // com.google.firebase.database.core.RunLoop
    public ScheduledExecutorService getExecutorService() {
        return this.executor;
    }

    @Override // com.google.firebase.database.core.RunLoop
    protected ThreadFactory getThreadFactory() {
        return Executors.defaultThreadFactory();
    }

    @Override // com.google.firebase.database.core.RunLoop
    protected ThreadInitializer getThreadInitializer() {
        return ThreadInitializer.defaultInstance;
    }

    @Override // com.google.firebase.database.core.RunLoop
    public abstract void handleException(Throwable throwable);

    @Override // com.google.firebase.database.core.RunLoop
    public void restart() {
        this.executor.setCorePoolSize(1);
    }

    @Override // com.google.firebase.database.core.RunLoop
    public ScheduledFuture schedule(Runnable runnable, long l2) {
        return this.executor.schedule(runnable, l2, obj5);
    }

    @Override // com.google.firebase.database.core.RunLoop
    public void scheduleNow(Runnable runnable) {
        this.executor.execute(runnable);
    }

    @Override // com.google.firebase.database.core.RunLoop
    public void shutdown() {
        this.executor.setCorePoolSize(0);
    }
}
