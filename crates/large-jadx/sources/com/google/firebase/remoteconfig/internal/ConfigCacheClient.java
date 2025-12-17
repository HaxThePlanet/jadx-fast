package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.tasks.d;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class ConfigCacheClient {

    private static final Executor DIRECT_EXECUTOR = null;
    static final long DISK_READ_TIMEOUT_IN_SECONDS = 5L;
    private static final Map<String, com.google.firebase.remoteconfig.internal.ConfigCacheClient> clientInstances;
    private j<com.google.firebase.remoteconfig.internal.ConfigContainer> cachedContainerTask = null;
    private final ExecutorService executorService;
    private final com.google.firebase.remoteconfig.internal.ConfigStorageClient storageClient;

    private static class AwaitListener implements g<TResult>, f, d {

        private final CountDownLatch latch;
        private AwaitListener() {
            super();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.latch = countDownLatch;
        }

        AwaitListener(com.google.firebase.remoteconfig.internal.ConfigCacheClient.1 configCacheClient$1) {
            super();
        }

        @Override // com.google.android.gms.tasks.g
        public void await() {
            this.latch.await();
        }

        @Override // com.google.android.gms.tasks.g
        public boolean await(long l, TimeUnit timeUnit2) {
            return this.latch.await(l, timeUnit2);
        }

        @Override // com.google.android.gms.tasks.g
        public void onCanceled() {
            this.latch.countDown();
        }

        @Override // com.google.android.gms.tasks.g
        public void onFailure(Exception exception) {
            this.latch.countDown();
        }

        public void onSuccess(TResult tresult) {
            this.latch.countDown();
        }
    }
    static {
        HashMap hashMap = new HashMap();
        ConfigCacheClient.clientInstances = hashMap;
        ConfigCacheClient.DIRECT_EXECUTOR = i.a;
    }

    private ConfigCacheClient(ExecutorService executorService, com.google.firebase.remoteconfig.internal.ConfigStorageClient configStorageClient2) {
        super();
        this.executorService = executorService;
        this.storageClient = configStorageClient2;
        final int obj1 = 0;
    }

    private Void a(com.google.firebase.remoteconfig.internal.ConfigContainer configContainer) {
        return this.storageClient.write(configContainer);
    }

    private static <TResult> TResult await(j<TResult> j, long l2, TimeUnit timeUnit3) {
        ConfigCacheClient.AwaitListener awaitListener = new ConfigCacheClient.AwaitListener(0);
        Executor dIRECT_EXECUTOR = ConfigCacheClient.DIRECT_EXECUTOR;
        j.addOnSuccessListener(dIRECT_EXECUTOR, awaitListener);
        j.addOnFailureListener(dIRECT_EXECUTOR, awaitListener);
        j.addOnCanceledListener(dIRECT_EXECUTOR, awaitListener);
        if (!awaitListener.await(l2, timeUnit3)) {
        } else {
            if (!j.isSuccessful()) {
            } else {
                return j.getResult();
            }
            ExecutionException obj3 = new ExecutionException(j.getException());
            throw obj3;
        }
        TimeoutException obj2 = new TimeoutException("Task await timed out.");
        throw obj2;
    }

    private j c(boolean z, com.google.firebase.remoteconfig.internal.ConfigContainer configContainer2, Void void3) {
        if (z) {
            updateInMemoryConfigContainer(configContainer2);
        }
        return m.e(configContainer2);
    }

    public static void clearInstancesForTest() {
        final Class<com.google.firebase.remoteconfig.internal.ConfigCacheClient> obj = ConfigCacheClient.class;
        ConfigCacheClient.clientInstances.clear();
        return;
        synchronized (obj) {
            obj = ConfigCacheClient.class;
            ConfigCacheClient.clientInstances.clear();
        }
    }

    public static com.google.firebase.remoteconfig.internal.ConfigCacheClient getInstance(ExecutorService executorService, com.google.firebase.remoteconfig.internal.ConfigStorageClient configStorageClient2) {
        boolean configCacheClient;
        final Class<com.google.firebase.remoteconfig.internal.ConfigCacheClient> obj = ConfigCacheClient.class;
        final String fileName = configStorageClient2.getFileName();
        final Map clientInstances = ConfigCacheClient.clientInstances;
        synchronized (obj) {
            configCacheClient = new ConfigCacheClient(executorService, configStorageClient2);
            clientInstances.put(fileName, configCacheClient);
            return (ConfigCacheClient)clientInstances.get(fileName);
        }
    }

    private void updateInMemoryConfigContainer(com.google.firebase.remoteconfig.internal.ConfigContainer configContainer) {
        this.cachedContainerTask = m.e(configContainer);
        return;
        synchronized (this) {
            this.cachedContainerTask = m.e(configContainer);
        }
    }

    public Void b(com.google.firebase.remoteconfig.internal.ConfigContainer configContainer) {
        return a(configContainer);
    }

    public void clear() {
        this.cachedContainerTask = m.e(0);
        this.storageClient.clear();
        return;
        synchronized (this) {
            this.cachedContainerTask = m.e(0);
            this.storageClient.clear();
        }
    }

    public j d(boolean z, com.google.firebase.remoteconfig.internal.ConfigContainer configContainer2, Void void3) {
        return c(z, configContainer2, void3);
    }

    public j<com.google.firebase.remoteconfig.internal.ConfigContainer> get() {
        j cachedContainerTask;
        com.google.firebase.remoteconfig.internal.ConfigStorageClient storageClient;
        com.google.firebase.remoteconfig.internal.h hVar;
        cachedContainerTask = this.cachedContainerTask;
        synchronized (this) {
            try {
                if (cachedContainerTask.isComplete() && !this.cachedContainerTask.isSuccessful()) {
                }
                if (!this.cachedContainerTask.isSuccessful()) {
                }
                storageClient = this.storageClient;
                Objects.requireNonNull(storageClient);
                hVar = new h(storageClient);
                this.cachedContainerTask = m.c(this.executorService, hVar);
                return this.cachedContainerTask;
                throw th;
            }
        }
    }

    public com.google.firebase.remoteconfig.internal.ConfigContainer getBlocking() {
        return getBlocking(5);
    }

    com.google.firebase.remoteconfig.internal.ConfigContainer getBlocking(long l) {
        j cachedContainerTask;
        cachedContainerTask = this.cachedContainerTask;
        synchronized (this) {
            try {
                if (cachedContainerTask.isSuccessful()) {
                }
                return (ConfigContainer)this.cachedContainerTask.getResult();
                return (ConfigContainer)ConfigCacheClient.await(get(), l, obj4);
                obj4 = "FirebaseRemoteConfig";
                Log.d(obj4, "Reading from storage file failed.", l);
                l = null;
                return l;
                throw l;
            } catch (java.lang.InterruptedException interrupted) {
            } catch (java.util.concurrent.ExecutionException execution1) {
            } catch (java.util.concurrent.TimeoutException timeout2) {
            }
        }
    }

    j<com.google.firebase.remoteconfig.internal.ConfigContainer> getCachedContainerTask() {
        return this.cachedContainerTask;
        synchronized (this) {
            return this.cachedContainerTask;
        }
    }

    public j<com.google.firebase.remoteconfig.internal.ConfigContainer> put(com.google.firebase.remoteconfig.internal.ConfigContainer configContainer) {
        return put(configContainer, true);
    }

    public j<com.google.firebase.remoteconfig.internal.ConfigContainer> put(com.google.firebase.remoteconfig.internal.ConfigContainer configContainer, boolean z2) {
        a aVar = new a(this, configContainer);
        b bVar = new b(this, z2, configContainer);
        return m.c(this.executorService, aVar).onSuccessTask(this.executorService, bVar);
    }
}
