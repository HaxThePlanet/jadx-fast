package com.google.firebase.database.connection;

import com.google.android.gms.tasks.j;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface PersistentConnection {

    public interface Delegate {
        public abstract void onConnect();

        public abstract void onConnectionStatus(boolean z);

        public abstract void onDataUpdate(List<String> list, Object object2, boolean z3, Long long4);

        public abstract void onDisconnect();

        public abstract void onRangeMergeUpdate(List<String> list, List<com.google.firebase.database.connection.RangeMerge> list2, Long long3);

        public abstract void onServerInfoUpdate(Map<String, Object> map);
    }
    public abstract void compareAndPut(List<String> list, Object object2, String string3, com.google.firebase.database.connection.RequestResultCallback requestResultCallback4);

    public abstract j<Object> get(List<String> list, Map<String, Object> map2);

    public abstract void initialize();

    public abstract void interrupt(String string);

    public abstract boolean isInterrupted(String string);

    public abstract void listen(List<String> list, Map<String, Object> map2, com.google.firebase.database.connection.ListenHashProvider listenHashProvider3, Long long4, com.google.firebase.database.connection.RequestResultCallback requestResultCallback5);

    public abstract void merge(List<String> list, Map<String, Object> map2, com.google.firebase.database.connection.RequestResultCallback requestResultCallback3);

    public abstract void onDisconnectCancel(List<String> list, com.google.firebase.database.connection.RequestResultCallback requestResultCallback2);

    public abstract void onDisconnectMerge(List<String> list, Map<String, Object> map2, com.google.firebase.database.connection.RequestResultCallback requestResultCallback3);

    public abstract void onDisconnectPut(List<String> list, Object object2, com.google.firebase.database.connection.RequestResultCallback requestResultCallback3);

    public abstract void purgeOutstandingWrites();

    public abstract void put(List<String> list, Object object2, com.google.firebase.database.connection.RequestResultCallback requestResultCallback3);

    public abstract void refreshAppCheckToken();

    public abstract void refreshAppCheckToken(String string);

    public abstract void refreshAuthToken();

    public abstract void refreshAuthToken(String string);

    public abstract void resume(String string);

    public abstract void shutdown();

    public abstract void unlisten(List<String> list, Map<String, Object> map2);
}
