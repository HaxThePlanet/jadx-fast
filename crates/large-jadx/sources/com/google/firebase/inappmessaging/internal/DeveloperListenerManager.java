package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDismissListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayErrorListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class DeveloperListenerManager {

    private static final ThreadPoolExecutor CALLBACK_QUEUE_EXECUTOR = null;
    private static final int KEEP_ALIVE_TIME_SECONDS = 15;
    private static final int POOL_SIZE = 1;
    public static com.google.firebase.inappmessaging.internal.DeveloperListenerManager instance;
    private static BlockingQueue<Runnable> mCallbackQueue;
    private Map<FirebaseInAppMessagingClickListener, com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ClicksExecutorAndListener> registeredClickListeners;
    private Map<FirebaseInAppMessagingDismissListener, com.google.firebase.inappmessaging.internal.DeveloperListenerManager.DismissExecutorAndListener> registeredDismissListeners;
    private Map<FirebaseInAppMessagingDisplayErrorListener, com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ErrorsExecutorAndListener> registeredErrorListeners;
    private Map<FirebaseInAppMessagingImpressionListener, com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ImpressionExecutorAndListener> registeredImpressionListeners;

    private static abstract class ExecutorAndListener {

        private final Executor executor;
        public ExecutorAndListener(Executor executor) {
            super();
            this.executor = executor;
        }

        public abstract T getListener();

        public Executor withExecutor(Executor executor) {
            final Executor executor2 = this.executor;
            if (executor2 == null) {
                return executor;
            }
            return executor2;
        }
    }

    static class FIAMThreadFactory implements ThreadFactory {

        private final String mNameSuffix;
        private final AtomicInteger threadNumber;
        FIAMThreadFactory(String string) {
            super();
            AtomicInteger atomicInteger = new AtomicInteger(1);
            this.threadNumber = atomicInteger;
            this.mNameSuffix = string;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FIAM-");
            stringBuilder.append(this.mNameSuffix);
            stringBuilder.append(this.threadNumber.getAndIncrement());
            Thread thread = new Thread(runnable, stringBuilder.toString());
            thread.setDaemon(false);
            thread.setPriority(9);
            return thread;
        }
    }

    private static class ClicksExecutorAndListener extends com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener<FirebaseInAppMessagingClickListener> {

        FirebaseInAppMessagingClickListener listener;
        public ClicksExecutorAndListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
            super(0);
            this.listener = firebaseInAppMessagingClickListener;
        }

        public ClicksExecutorAndListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, Executor executor2) {
            super(executor2);
            this.listener = firebaseInAppMessagingClickListener;
        }

        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager$ExecutorAndListener
        public FirebaseInAppMessagingClickListener getListener() {
            return this.listener;
        }

        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager$ExecutorAndListener
        public Object getListener() {
            return getListener();
        }
    }

    private static class DismissExecutorAndListener extends com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener<FirebaseInAppMessagingDismissListener> {

        FirebaseInAppMessagingDismissListener listener;
        public DismissExecutorAndListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
            super(0);
            this.listener = firebaseInAppMessagingDismissListener;
        }

        public DismissExecutorAndListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener, Executor executor2) {
            super(executor2);
            this.listener = firebaseInAppMessagingDismissListener;
        }

        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager$ExecutorAndListener
        public FirebaseInAppMessagingDismissListener getListener() {
            return this.listener;
        }

        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager$ExecutorAndListener
        public Object getListener() {
            return getListener();
        }
    }

    private static class ErrorsExecutorAndListener extends com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener<FirebaseInAppMessagingDisplayErrorListener> {

        FirebaseInAppMessagingDisplayErrorListener listener;
        public ErrorsExecutorAndListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
            super(0);
            this.listener = firebaseInAppMessagingDisplayErrorListener;
        }

        public ErrorsExecutorAndListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, Executor executor2) {
            super(executor2);
            this.listener = firebaseInAppMessagingDisplayErrorListener;
        }

        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager$ExecutorAndListener
        public FirebaseInAppMessagingDisplayErrorListener getListener() {
            return this.listener;
        }

        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager$ExecutorAndListener
        public Object getListener() {
            return getListener();
        }
    }

    private static class ImpressionExecutorAndListener extends com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener<FirebaseInAppMessagingImpressionListener> {

        FirebaseInAppMessagingImpressionListener listener;
        public ImpressionExecutorAndListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
            super(0);
            this.listener = firebaseInAppMessagingImpressionListener;
        }

        public ImpressionExecutorAndListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, Executor executor2) {
            super(executor2);
            this.listener = firebaseInAppMessagingImpressionListener;
        }

        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager$ExecutorAndListener
        public FirebaseInAppMessagingImpressionListener getListener() {
            return this.listener;
        }

        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager$ExecutorAndListener
        public Object getListener() {
            return getListener();
        }
    }
    static {
        DeveloperListenerManager developerListenerManager = new DeveloperListenerManager();
        DeveloperListenerManager.instance = developerListenerManager;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        DeveloperListenerManager.mCallbackQueue = linkedBlockingQueue;
        DeveloperListenerManager.FIAMThreadFactory fIAMThreadFactory = new DeveloperListenerManager.FIAMThreadFactory("EventListeners-");
        super(1, 1, 15, obj5, TimeUnit.SECONDS, DeveloperListenerManager.mCallbackQueue, fIAMThreadFactory);
        DeveloperListenerManager.CALLBACK_QUEUE_EXECUTOR = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public DeveloperListenerManager() {
        super();
        HashMap hashMap = new HashMap();
        this.registeredClickListeners = hashMap;
        HashMap hashMap2 = new HashMap();
        this.registeredDismissListeners = hashMap2;
        HashMap hashMap3 = new HashMap();
        this.registeredErrorListeners = hashMap3;
        HashMap hashMap4 = new HashMap();
        this.registeredImpressionListeners = hashMap4;
    }

    static void a(com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ErrorsExecutorAndListener developerListenerManager$ErrorsExecutorAndListener, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason3) {
        errorsExecutorAndListener.getListener().displayErrorEncountered(inAppMessage2, inAppMessagingErrorReason3);
    }

    static void b(com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ImpressionExecutorAndListener developerListenerManager$ImpressionExecutorAndListener, InAppMessage inAppMessage2) {
        impressionExecutorAndListener.getListener().impressionDetected(inAppMessage2);
    }

    static void c(com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ClicksExecutorAndListener developerListenerManager$ClicksExecutorAndListener, InAppMessage inAppMessage2, Action action3) {
        clicksExecutorAndListener.getListener().messageClicked(inAppMessage2, action3);
    }

    static void d(com.google.firebase.inappmessaging.internal.DeveloperListenerManager.DismissExecutorAndListener developerListenerManager$DismissExecutorAndListener, InAppMessage inAppMessage2) {
        dismissExecutorAndListener.getListener().messageDismissed(inAppMessage2);
    }

    public void addClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        DeveloperListenerManager.ClicksExecutorAndListener clicksExecutorAndListener = new DeveloperListenerManager.ClicksExecutorAndListener(firebaseInAppMessagingClickListener);
        this.registeredClickListeners.put(firebaseInAppMessagingClickListener, clicksExecutorAndListener);
    }

    public void addClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, Executor executor2) {
        DeveloperListenerManager.ClicksExecutorAndListener clicksExecutorAndListener = new DeveloperListenerManager.ClicksExecutorAndListener(firebaseInAppMessagingClickListener, executor2);
        this.registeredClickListeners.put(firebaseInAppMessagingClickListener, clicksExecutorAndListener);
    }

    public void addDismissListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
        DeveloperListenerManager.DismissExecutorAndListener dismissExecutorAndListener = new DeveloperListenerManager.DismissExecutorAndListener(firebaseInAppMessagingDismissListener);
        this.registeredDismissListeners.put(firebaseInAppMessagingDismissListener, dismissExecutorAndListener);
    }

    public void addDismissListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener, Executor executor2) {
        DeveloperListenerManager.DismissExecutorAndListener dismissExecutorAndListener = new DeveloperListenerManager.DismissExecutorAndListener(firebaseInAppMessagingDismissListener, executor2);
        this.registeredDismissListeners.put(firebaseInAppMessagingDismissListener, dismissExecutorAndListener);
    }

    public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        DeveloperListenerManager.ErrorsExecutorAndListener errorsExecutorAndListener = new DeveloperListenerManager.ErrorsExecutorAndListener(firebaseInAppMessagingDisplayErrorListener);
        this.registeredErrorListeners.put(firebaseInAppMessagingDisplayErrorListener, errorsExecutorAndListener);
    }

    public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, Executor executor2) {
        DeveloperListenerManager.ErrorsExecutorAndListener errorsExecutorAndListener = new DeveloperListenerManager.ErrorsExecutorAndListener(firebaseInAppMessagingDisplayErrorListener, executor2);
        this.registeredErrorListeners.put(firebaseInAppMessagingDisplayErrorListener, errorsExecutorAndListener);
    }

    public void addImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        DeveloperListenerManager.ImpressionExecutorAndListener impressionExecutorAndListener = new DeveloperListenerManager.ImpressionExecutorAndListener(firebaseInAppMessagingImpressionListener);
        this.registeredImpressionListeners.put(firebaseInAppMessagingImpressionListener, impressionExecutorAndListener);
    }

    public void addImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, Executor executor2) {
        DeveloperListenerManager.ImpressionExecutorAndListener impressionExecutorAndListener = new DeveloperListenerManager.ImpressionExecutorAndListener(firebaseInAppMessagingImpressionListener, executor2);
        this.registeredImpressionListeners.put(firebaseInAppMessagingImpressionListener, impressionExecutorAndListener);
    }

    public void displayErrorEncountered(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason2) {
        Object next;
        Executor executor;
        com.google.firebase.inappmessaging.internal.m mVar;
        Iterator iterator = this.registeredErrorListeners.values().iterator();
        for (DeveloperListenerManager.ErrorsExecutorAndListener next : iterator) {
            mVar = new m(next, inAppMessage, inAppMessagingErrorReason2);
            next.withExecutor(DeveloperListenerManager.CALLBACK_QUEUE_EXECUTOR).execute(mVar);
        }
    }

    public void impressionDetected(InAppMessage inAppMessage) {
        Object next;
        Executor executor;
        com.google.firebase.inappmessaging.internal.l lVar;
        Iterator iterator = this.registeredImpressionListeners.values().iterator();
        for (DeveloperListenerManager.ImpressionExecutorAndListener next : iterator) {
            lVar = new l(next, inAppMessage);
            next.withExecutor(DeveloperListenerManager.CALLBACK_QUEUE_EXECUTOR).execute(lVar);
        }
    }

    public void messageClicked(InAppMessage inAppMessage, Action action2) {
        Object next;
        Executor executor;
        com.google.firebase.inappmessaging.internal.k kVar;
        Iterator iterator = this.registeredClickListeners.values().iterator();
        for (DeveloperListenerManager.ClicksExecutorAndListener next : iterator) {
            kVar = new k(next, inAppMessage, action2);
            next.withExecutor(DeveloperListenerManager.CALLBACK_QUEUE_EXECUTOR).execute(kVar);
        }
    }

    public void messageDismissed(InAppMessage inAppMessage) {
        Object next;
        Executor executor;
        com.google.firebase.inappmessaging.internal.j jVar;
        Iterator iterator = this.registeredDismissListeners.values().iterator();
        for (DeveloperListenerManager.DismissExecutorAndListener next : iterator) {
            jVar = new j(next, inAppMessage);
            next.withExecutor(DeveloperListenerManager.CALLBACK_QUEUE_EXECUTOR).execute(jVar);
        }
    }

    public void removeAllListeners() {
        this.registeredClickListeners.clear();
        this.registeredImpressionListeners.clear();
        this.registeredErrorListeners.clear();
    }

    public void removeClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.registeredClickListeners.remove(firebaseInAppMessagingClickListener);
    }

    public void removeDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.registeredErrorListeners.remove(firebaseInAppMessagingDisplayErrorListener);
    }

    public void removeImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.registeredImpressionListeners.remove(firebaseInAppMessagingImpressionListener);
    }
}
