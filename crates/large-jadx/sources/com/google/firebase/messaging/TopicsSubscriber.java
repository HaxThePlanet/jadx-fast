package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import d.e.a;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class TopicsSubscriber {

    private static final long MAX_DELAY_SEC;
    private final Context context;
    private final com.google.firebase.messaging.FirebaseMessaging firebaseMessaging;
    private final com.google.firebase.messaging.Metadata metadata;
    private final Map<String, ArrayDeque<k<Void>>> pendingOperations;
    private final com.google.firebase.messaging.GmsRpc rpc;
    private final com.google.firebase.messaging.TopicsStore store;
    private final ScheduledExecutorService syncExecutor;
    private boolean syncScheduledOrRunning = false;
    static {
        TopicsSubscriber.MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    }

    private TopicsSubscriber(com.google.firebase.messaging.FirebaseMessaging firebaseMessaging, com.google.firebase.messaging.Metadata metadata2, com.google.firebase.messaging.TopicsStore topicsStore3, com.google.firebase.messaging.GmsRpc gmsRpc4, Context context5, ScheduledExecutorService scheduledExecutorService6) {
        super();
        a aVar = new a();
        this.pendingOperations = aVar;
        int i = 0;
        this.firebaseMessaging = firebaseMessaging;
        this.metadata = metadata2;
        this.store = topicsStore3;
        this.rpc = gmsRpc4;
        this.context = context5;
        this.syncExecutor = scheduledExecutorService6;
    }

    private void addToPendingOperations(com.google.firebase.messaging.TopicOperation topicOperation, k<Void> k2) {
        Object pendingOperations;
        Map pendingOperations2;
        Object obj4;
        final Map pendingOperations3 = this.pendingOperations;
        obj4 = topicOperation.serialize();
        synchronized (pendingOperations3) {
            obj4 = this.pendingOperations.get(obj4);
            try {
                obj4.add(k2);
                throw topicOperation;
            }
        }
    }

    private static <T> void awaitTask(j<T> j) {
        m.b(j, 30, z);
    }

    private void blockingSubscribeToTopic(String string) {
        TopicsSubscriber.awaitTask(this.rpc.subscribeToTopic(this.firebaseMessaging.blockingGetToken(), string));
    }

    private void blockingUnsubscribeFromTopic(String string) {
        TopicsSubscriber.awaitTask(this.rpc.unsubscribeFromTopic(this.firebaseMessaging.blockingGetToken(), string));
    }

    static j<com.google.firebase.messaging.TopicsSubscriber> createInstance(com.google.firebase.messaging.FirebaseMessaging firebaseMessaging, com.google.firebase.messaging.Metadata metadata2, com.google.firebase.messaging.GmsRpc gmsRpc3, Context context4, ScheduledExecutorService scheduledExecutorService5) {
        super(context4, scheduledExecutorService5, firebaseMessaging, metadata2, gmsRpc3);
        return m.c(scheduledExecutorService5, externalSyntheticLambda02);
    }

    static boolean isDebugLogEnabled() {
        String loggable;
        boolean sDK_INT;
        int i2;
        int i;
        loggable = "FirebaseMessaging";
        final int i3 = 3;
        if (!Log.isLoggable(loggable, i3)) {
            if (Build.VERSION.SDK_INT == 23 && Log.isLoggable(loggable, i3)) {
                if (Log.isLoggable(loggable, i3)) {
                    i2 = i4;
                }
                return 0;
            }
        } else {
        }
        return i2;
    }

    static com.google.firebase.messaging.TopicsSubscriber lambda$createInstance$0(Context context, ScheduledExecutorService scheduledExecutorService2, com.google.firebase.messaging.FirebaseMessaging firebaseMessaging3, com.google.firebase.messaging.Metadata metadata4, com.google.firebase.messaging.GmsRpc gmsRpc5) {
        super(firebaseMessaging3, metadata4, TopicsStore.getInstance(context, scheduledExecutorService2), gmsRpc5, context, scheduledExecutorService2);
        return topicsSubscriber2;
    }

    private void markCompletePendingOperation(com.google.firebase.messaging.TopicOperation topicOperation) {
        boolean pendingOperations;
        int i;
        final Map pendingOperations2 = this.pendingOperations;
        final String obj5 = topicOperation.serialize();
        synchronized (pendingOperations2) {
        }
    }

    private void startSync() {
        boolean syncScheduledOrRunning;
        if (!isSyncScheduledOrRunning()) {
            syncWithDelaySecondsInternal(0);
        }
    }

    boolean hasPendingOperation() {
        if (this.store.getNextTopicOperation() != null) {
            return 1;
        }
        return 0;
    }

    boolean isSyncScheduledOrRunning() {
        return this.syncScheduledOrRunning;
        synchronized (this) {
            return this.syncScheduledOrRunning;
        }
    }

    boolean performTopicOperation(com.google.firebase.messaging.TopicOperation topicOperation) {
        String str;
        boolean operation;
        int i;
        boolean debugLogEnabled;
        String stringBuilder2;
        String str2;
        Object stringBuilder3;
        int stringBuilder;
        String obj7;
        final String str3 = "FirebaseMessaging";
        operation = topicOperation.getOperation();
        str2 = operation.hashCode();
        final int i6 = 1;
        if (str2 != 83) {
            if (str2 != 85) {
                i = -1;
            } else {
                try {
                    if (operation.equals("U")) {
                    } else {
                    }
                    i = i6;
                    if (operation.equals("S")) {
                    } else {
                    }
                    i = i2;
                    i = -1;
                    stringBuilder3 = " succeeded.";
                }
                blockingSubscribeToTopic(topicOperation.getTopic());
                if (TopicsSubscriber.isDebugLogEnabled()) {
                    obj7 = topicOperation.getTopic();
                    stringBuilder = new StringBuilder(length += 31);
                    stringBuilder.append("Subscribe to topic: ");
                    stringBuilder.append(obj7);
                    stringBuilder.append(stringBuilder3);
                    Log.d(str3, stringBuilder.toString());
                }
                return i6;
            }
        } else {
        }
    }

    void scheduleSyncTaskWithDelaySeconds(Runnable runnable, long l2) {
        this.syncExecutor.schedule(runnable, l2, obj5);
    }

    j<Void> scheduleTopicOperation(com.google.firebase.messaging.TopicOperation topicOperation) {
        this.store.addTopicOperation(topicOperation);
        k kVar = new k();
        addToPendingOperations(topicOperation, kVar);
        return kVar.a();
    }

    void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
        return;
        synchronized (this) {
            this.syncScheduledOrRunning = z;
        }
    }

    void startTopicsSyncIfNecessary() {
        if (hasPendingOperation()) {
            startSync();
        }
    }

    j<Void> subscribeToTopic(String string) {
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation(TopicOperation.subscribe(string));
    }

    boolean syncTopics() {
        boolean debugLogEnabled;
        String str;
        com.google.firebase.messaging.TopicOperation nextTopicOperation = this.store.getNextTopicOperation();
        synchronized (this) {
            try {
                if (TopicsSubscriber.isDebugLogEnabled()) {
                }
                Log.d("FirebaseMessaging", "topic sync succeeded");
                return 1;
                return 0;
                this.store.removeTopicOperation(nextTopicOperation);
                markCompletePendingOperation(nextTopicOperation);
                throw th;
            }
        }
    }

    void syncWithDelaySecondsInternal(long l) {
        super(this, this.context, this.metadata, Math.min(Math.max(30, obj3), obj1), obj9);
        scheduleSyncTaskWithDelaySeconds(topicsSyncTask, l);
        setSyncScheduledOrRunning(true);
    }

    j<Void> unsubscribeFromTopic(String string) {
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation(TopicOperation.unsubscribe(string));
    }
}
