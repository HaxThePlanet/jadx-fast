package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class SharedPreferencesQueue {

    private boolean bulkOperation = false;
    private final ArrayDeque<String> internalQueue;
    private final String itemSeparator;
    private final String queueName;
    private final SharedPreferences sharedPreferences;
    private final Executor syncExecutor;
    public static void $r8$lambda$_dijO1NT18aM7vHHk9LEtlzE6xQ(com.google.firebase.messaging.SharedPreferencesQueue sharedPreferencesQueue) {
        sharedPreferencesQueue.syncState();
    }

    private SharedPreferencesQueue(SharedPreferences sharedPreferences, String string2, String string3, Executor executor4) {
        super();
        ArrayDeque obj2 = new ArrayDeque();
        this.internalQueue = obj2;
        obj2 = 0;
        this.sharedPreferences = sharedPreferences;
        this.queueName = "topic_operation_queue";
        this.itemSeparator = ",";
        this.syncExecutor = executor4;
    }

    private boolean checkAndSyncState(boolean z) {
        boolean bulkOperation;
        int obj2;
        if (z != 0 && !this.bulkOperation) {
            if (!this.bulkOperation) {
                syncStateAsync();
                obj2 = 1;
            }
        }
        return obj2;
    }

    static com.google.firebase.messaging.SharedPreferencesQueue createInstance(SharedPreferences sharedPreferences, String string2, String string3, Executor executor4) {
        SharedPreferencesQueue obj2 = new SharedPreferencesQueue(sharedPreferences, "topic_operation_queue", ",", executor4);
        obj2.initQueue();
        return obj2;
    }

    private void initQueue() {
        boolean contains;
        int i;
        String str;
        String internalQueue;
        final ArrayDeque internalQueue2 = this.internalQueue;
        this.internalQueue.clear();
        String string = this.sharedPreferences.getString(this.queueName, "");
        synchronized (internalQueue2) {
            if (!string.contains(this.itemSeparator)) {
            } else {
                try {
                    String[] split = string.split(this.itemSeparator, -1);
                    int length = split.length;
                    i = 0;
                    if (length == 0) {
                    }
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    while (i < length) {
                        str = split[i];
                        if (!TextUtils.isEmpty(str)) {
                        }
                        i++;
                        this.internalQueue.add(str);
                    }
                    str = split[i];
                    if (!TextUtils.isEmpty(str)) {
                    }
                    this.internalQueue.add(str);
                    i++;
                    throw th;
                }
            }
        }
    }

    private void syncState() {
        final ArrayDeque internalQueue = this.internalQueue;
        this.sharedPreferences.edit().putString(this.queueName, serialize()).commit();
        return;
        synchronized (internalQueue) {
            internalQueue = this.internalQueue;
            this.sharedPreferences.edit().putString(this.queueName, serialize()).commit();
        }
    }

    private void syncStateAsync() {
        SharedPreferencesQueue$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SharedPreferencesQueue$$ExternalSyntheticLambda0(this);
        this.syncExecutor.execute(externalSyntheticLambda0);
    }

    public boolean add(String string) {
        boolean contains;
        if (!TextUtils.isEmpty(string) && string.contains(this.itemSeparator)) {
            if (string.contains(this.itemSeparator)) {
            }
            ArrayDeque internalQueue = this.internalQueue;
            boolean obj3 = this.internalQueue.add(string);
            checkAndSyncState(obj3);
            return obj3;
            synchronized (internalQueue) {
                internalQueue = this.internalQueue;
                obj3 = this.internalQueue.add(string);
                checkAndSyncState(obj3);
                return obj3;
            }
        }
        return 0;
    }

    public String peek() {
        final ArrayDeque internalQueue = this.internalQueue;
        return (String)this.internalQueue.peek();
        synchronized (internalQueue) {
            internalQueue = this.internalQueue;
            return (String)this.internalQueue.peek();
        }
    }

    public boolean remove(Object object) {
        final ArrayDeque internalQueue = this.internalQueue;
        final boolean obj3 = this.internalQueue.remove(object);
        checkAndSyncState(obj3);
        return obj3;
        synchronized (internalQueue) {
            internalQueue = this.internalQueue;
            obj3 = this.internalQueue.remove(object);
            checkAndSyncState(obj3);
            return obj3;
        }
    }

    public String serialize() {
        String itemSeparator;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.internalQueue.iterator();
        for (String next2 : iterator) {
            stringBuilder.append(next2);
            stringBuilder.append(this.itemSeparator);
        }
        return stringBuilder.toString();
    }
}
