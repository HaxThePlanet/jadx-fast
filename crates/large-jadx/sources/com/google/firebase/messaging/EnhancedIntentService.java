package com.google.firebase.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public abstract class EnhancedIntentService extends Service {

    private Binder binder;
    final ExecutorService executor;
    private int lastStartId;
    private final Object lock;
    private int runningTasks = 0;
    static j -$$Nest$mprocessIntent(com.google.firebase.messaging.EnhancedIntentService enhancedIntentService, Intent intent2) {
        return enhancedIntentService.processIntent(intent2);
    }

    public EnhancedIntentService() {
        super();
        this.executor = FcmExecutors.newIntentHandleExecutor();
        Object object = new Object();
        this.lock = object;
        int i = 0;
    }

    private void finishTask(Intent intent) {
        int lastStartId;
        if (intent != null) {
            WakeLockHolder.completeWakefulIntent(intent);
        }
        final Object obj2 = this.lock;
        runningTasks--;
        this.runningTasks = lastStartId;
        synchronized (obj2) {
            stopSelfResultHook(this.lastStartId);
        }
    }

    private j<Void> processIntent(Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return m.e(0);
        }
        k kVar = new k();
        EnhancedIntentService$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new EnhancedIntentService$$ExternalSyntheticLambda1(this, intent, kVar);
        this.executor.execute(externalSyntheticLambda1);
        return kVar.a();
    }

    @Override // android.app.Service
    protected Intent getStartCommandIntent(Intent intent) {
        return intent;
    }

    @Override // android.app.Service
    public abstract void handleIntent(Intent intent);

    @Override // android.app.Service
    public boolean handleIntentOnMainThread(Intent intent) {
        return 0;
    }

    @Override // android.app.Service
    void lambda$onStartCommand$1$com-google-firebase-messaging-EnhancedIntentService(Intent intent, j j2) {
        finishTask(intent);
    }

    @Override // android.app.Service
    void lambda$processIntent$0$com-google-firebase-messaging-EnhancedIntentService(Intent intent, k k2) {
        handleIntent(intent);
        k2.c(0);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        int anon;
        boolean obj2;
        synchronized (this) {
            try {
                Log.d("EnhancedIntentService", "Service received bind request");
                if (this.binder == null) {
                }
                anon = new EnhancedIntentService.1(this);
                obj2 = new WithinAppServiceBinder(anon);
                this.binder = obj2;
                return this.binder;
                throw intent;
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        Object obj3 = this.lock;
        this.lastStartId = i3;
        this.runningTasks = obj4++;
        obj3 = getStartCommandIntent(intent);
        int obj4 = 2;
        synchronized (obj3) {
            obj3 = this.lock;
            this.lastStartId = i3;
            this.runningTasks = obj4++;
            obj3 = getStartCommandIntent(intent);
            obj4 = 2;
        }
        finishTask(intent);
        return obj4;
    }

    @Override // android.app.Service
    boolean stopSelfResultHook(int i) {
        return stopSelfResult(i);
    }
}
