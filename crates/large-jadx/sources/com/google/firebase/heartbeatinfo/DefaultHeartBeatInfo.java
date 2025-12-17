package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DefaultHeartBeatInfo implements com.google.firebase.heartbeatinfo.HeartBeatInfo {

    private static final ThreadFactory THREAD_FACTORY;
    private final Executor backgroundExecutor;
    private final Set<com.google.firebase.heartbeatinfo.HeartBeatConsumer> consumers;
    private Provider<com.google.firebase.heartbeatinfo.HeartBeatInfoStorage> storageProvider;
    static {
        DefaultHeartBeatInfo.THREAD_FACTORY = a.a;
    }

    private DefaultHeartBeatInfo(Context context, Set<com.google.firebase.heartbeatinfo.HeartBeatConsumer> set2) {
        c cVar = new c(context);
        Lazy lazy = new Lazy(cVar);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        super(0, 1, 30, obj6, TimeUnit.SECONDS, linkedBlockingQueue, DefaultHeartBeatInfo.THREAD_FACTORY);
        super(lazy, set2, obj11);
    }

    DefaultHeartBeatInfo(Provider<com.google.firebase.heartbeatinfo.HeartBeatInfoStorage> provider, Set<com.google.firebase.heartbeatinfo.HeartBeatConsumer> set2, Executor executor3) {
        super();
        this.storageProvider = provider;
        this.consumers = set2;
        this.backgroundExecutor = executor3;
    }

    static com.google.firebase.heartbeatinfo.HeartBeatInfo a(ComponentContainer componentContainer) {
        DefaultHeartBeatInfo defaultHeartBeatInfo = new DefaultHeartBeatInfo((Context)componentContainer.get(Context.class), componentContainer.setOf(HeartBeatConsumer.class));
        return defaultHeartBeatInfo;
    }

    private List b() {
        long lastGlobalHeartBeat;
        com.google.firebase.heartbeatinfo.HeartBeatResult create;
        String sdkName;
        com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat cOMBINED;
        long millis;
        ArrayList arrayList = new ArrayList();
        Object obj = this.storageProvider.get();
        lastGlobalHeartBeat = obj.getLastGlobalHeartBeat();
        Iterator iterator = (HeartBeatInfoStorage)obj.getStoredHeartBeats(true).iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            boolean sameDateUtc = HeartBeatInfoStorage.isSameDateUtc(lastGlobalHeartBeat, obj4);
            if (sameDateUtc) {
            } else {
            }
            cOMBINED = HeartBeatInfo.HeartBeat.SDK;
            if (sameDateUtc) {
            }
            arrayList.add(HeartBeatResult.create(next2.getSdkName(), next2.getMillis(), obj9));
            lastGlobalHeartBeat = next2.getMillis();
            cOMBINED = HeartBeatInfo.HeartBeat.COMBINED;
        }
        if (Long.compare(lastGlobalHeartBeat, i2) > 0) {
            obj.updateGlobalHeartBeat(lastGlobalHeartBeat);
        }
        return arrayList;
    }

    public static Component<com.google.firebase.heartbeatinfo.HeartBeatInfo> component() {
        return Component.builder(HeartBeatInfo.class).add(Dependency.required(Context.class)).add(Dependency.setOf(HeartBeatConsumer.class)).factory(e.a).build();
    }

    static com.google.firebase.heartbeatinfo.HeartBeatInfoStorage d(Context context) {
        return HeartBeatInfoStorage.getInstance(context);
    }

    static Thread e(Runnable runnable) {
        Thread thread = new Thread(runnable, "heartbeat-information-executor");
        return thread;
    }

    private Void f(String string) {
        boolean sendSdkHeartBeat;
        final long currentTimeMillis = System.currentTimeMillis();
        if ((HeartBeatInfoStorage)this.storageProvider.get().shouldSendSdkHeartBeat(string, currentTimeMillis) != null) {
            (HeartBeatInfoStorage)this.storageProvider.get().storeHeartBeatInformation(string, currentTimeMillis);
        }
        return null;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public List c() {
        return b();
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public Void g(String string) {
        return f(string);
    }

    public j<List<com.google.firebase.heartbeatinfo.HeartBeatResult>> getAndClearStoredHeartBeatInfo() {
        b bVar = new b(this);
        return m.c(this.backgroundExecutor, bVar);
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat getHeartBeatCode(String string) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean obj4 = (HeartBeatInfoStorage)this.storageProvider.get().shouldSendSdkHeartBeat(string, currentTimeMillis);
        boolean sendGlobalHeartBeat = (HeartBeatInfoStorage)this.storageProvider.get().shouldSendGlobalHeartBeat(currentTimeMillis);
        if (obj4 != null && sendGlobalHeartBeat) {
            if (sendGlobalHeartBeat) {
                return HeartBeatInfo.HeartBeat.COMBINED;
            }
        }
        if (sendGlobalHeartBeat) {
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        if (obj4 != null) {
            return HeartBeatInfo.HeartBeat.SDK;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    public j<Void> storeHeartBeatInfo(String string) {
        if (this.consumers.size() <= 0) {
            return m.e(0);
        }
        d dVar = new d(this, string);
        return m.c(this.backgroundExecutor, dVar);
    }
}
