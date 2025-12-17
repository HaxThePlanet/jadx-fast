package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class TopicsStore {

    private static WeakReference<com.google.firebase.messaging.TopicsStore> topicsStoreWeakReference;
    private final SharedPreferences sharedPreferences;
    private final Executor syncExecutor;
    private com.google.firebase.messaging.SharedPreferencesQueue topicOperationsQueue;
    private TopicsStore(SharedPreferences sharedPreferences, Executor executor2) {
        super();
        this.syncExecutor = executor2;
        this.sharedPreferences = sharedPreferences;
    }

    public static com.google.firebase.messaging.TopicsStore getInstance(Context context, Executor executor2) {
        Object obj;
        final Class<com.google.firebase.messaging.TopicsStore> obj2 = TopicsStore.class;
        WeakReference topicsStoreWeakReference = TopicsStore.topicsStoreWeakReference;
        synchronized (obj2) {
            obj = topicsStoreWeakReference.get();
            try {
                if (obj == null) {
                }
                TopicsStore topicsStore = new TopicsStore(context.getSharedPreferences("com.google.android.gms.appid", 0), executor2);
                topicsStore.initStore();
                WeakReference obj3 = new WeakReference(topicsStore);
                TopicsStore.topicsStoreWeakReference = obj3;
                return topicsStore;
                return obj;
                throw context;
            }
        }
    }

    private void initStore() {
        this.topicOperationsQueue = SharedPreferencesQueue.createInstance(this.sharedPreferences, "topic_operation_queue", ",", this.syncExecutor);
        return;
        synchronized (this) {
            this.topicOperationsQueue = SharedPreferencesQueue.createInstance(this.sharedPreferences, "topic_operation_queue", ",", this.syncExecutor);
        }
    }

    boolean addTopicOperation(com.google.firebase.messaging.TopicOperation topicOperation) {
        return this.topicOperationsQueue.add(topicOperation.serialize());
        synchronized (this) {
            return this.topicOperationsQueue.add(topicOperation.serialize());
        }
    }

    com.google.firebase.messaging.TopicOperation getNextTopicOperation() {
        return TopicOperation.from(this.topicOperationsQueue.peek());
        synchronized (this) {
            return TopicOperation.from(this.topicOperationsQueue.peek());
        }
    }

    boolean removeTopicOperation(com.google.firebase.messaging.TopicOperation topicOperation) {
        return this.topicOperationsQueue.remove(topicOperation.serialize());
        synchronized (this) {
            return this.topicOperationsQueue.remove(topicOperation.serialize());
        }
    }
}
