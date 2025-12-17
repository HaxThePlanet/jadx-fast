package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.n.a;
import com.google.android.gms.common.util.q.a;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class WithinAppServiceConnection implements ServiceConnection {

    private com.google.firebase.messaging.WithinAppServiceBinder binder;
    private boolean connectionInProgress;
    private final Intent connectionIntent;
    private final Context context;
    private final Queue<com.google.firebase.messaging.WithinAppServiceConnection.BindRequest> intentQueue;
    private final ScheduledExecutorService scheduledExecutorService;

    static class BindRequest {

        final Intent intent;
        private final k<Void> taskCompletionSource;
        BindRequest(Intent intent) {
            super();
            k kVar = new k();
            this.taskCompletionSource = kVar;
            this.intent = intent;
        }

        static void lambda$arrangeTimeout$1(ScheduledFuture scheduledFuture, j j2) {
            scheduledFuture.cancel(false);
        }

        void arrangeTimeout(ScheduledExecutorService scheduledExecutorService) {
            WithinAppServiceConnection.BindRequest$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new WithinAppServiceConnection.BindRequest$$ExternalSyntheticLambda1(this);
            WithinAppServiceConnection.BindRequest$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new WithinAppServiceConnection.BindRequest$$ExternalSyntheticLambda0(scheduledExecutorService.schedule(externalSyntheticLambda1, 9000, obj3));
            getTask().addOnCompleteListener(scheduledExecutorService, externalSyntheticLambda0);
        }

        void finish() {
            this.taskCompletionSource.e(0);
        }

        j<Void> getTask() {
            return this.taskCompletionSource.a();
        }

        void lambda$arrangeTimeout$0$com-google-firebase-messaging-WithinAppServiceConnection$BindRequest() {
            String action = this.intent.getAction();
            StringBuilder stringBuilder = new StringBuilder(length += 61);
            stringBuilder.append("Service took too long to process intent: ");
            stringBuilder.append(action);
            stringBuilder.append(" App may get closed.");
            Log.w("FirebaseMessaging", stringBuilder.toString());
            finish();
        }
    }
    WithinAppServiceConnection(Context context, String string2) {
        a aVar = new a("Firebase-FirebaseInstanceIdServiceConnection");
        ScheduledThreadPoolExecutor obj4 = new ScheduledThreadPoolExecutor(0, aVar);
        super(context, "com.google.firebase.MESSAGING_EVENT", obj4);
    }

    WithinAppServiceConnection(Context context, String string2, ScheduledExecutorService scheduledExecutorService3) {
        super();
        ArrayDeque obj3 = new ArrayDeque();
        this.intentQueue = obj3;
        this.connectionInProgress = false;
        Context obj2 = context.getApplicationContext();
        this.context = obj2;
        obj3 = new Intent("com.google.firebase.MESSAGING_EVENT");
        this.connectionIntent = obj3.setPackage(obj2.getPackageName());
        this.scheduledExecutorService = scheduledExecutorService3;
    }

    private void finishAllInQueue() {
        while (!this.intentQueue.isEmpty()) {
            (WithinAppServiceConnection.BindRequest)this.intentQueue.poll().finish();
        }
    }

    private void flushQueue() {
        String loggable3;
        boolean loggable2;
        boolean loggable;
        com.google.firebase.messaging.WithinAppServiceBinder binderAlive;
        Object binder;
        final int i = 3;
        synchronized (this) {
            try {
                Log.d("FirebaseMessaging", "flush queue called");
                while (!this.intentQueue.isEmpty()) {
                    if (Log.isLoggable("FirebaseMessaging", i)) {
                    }
                    binderAlive = this.binder;
                    if (Log.isLoggable("FirebaseMessaging", i)) {
                    }
                    this.binder.send((WithinAppServiceConnection.BindRequest)this.intentQueue.poll());
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                if (Log.isLoggable("FirebaseMessaging", i)) {
                }
                Log.d("FirebaseMessaging", "found intent to be delivered");
                binderAlive = this.binder;
                if (binderAlive != null) {
                }
                if (binderAlive.isBinderAlive()) {
                }
                if (Log.isLoggable("FirebaseMessaging", i)) {
                }
                Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                this.binder.send((WithinAppServiceConnection.BindRequest)this.intentQueue.poll());
                startConnectionIfNeeded();
                throw th;
            }
        }
    }

    private void startConnectionIfNeeded() {
        boolean loggable;
        String str2;
        Context context;
        StringBuilder stringBuilder;
        String str;
        String str3 = "FirebaseMessaging";
        int i4 = 1;
        if (Log.isLoggable(str3, 3)) {
            stringBuilder = new StringBuilder(39);
            stringBuilder.append("binder is dead. start connection? ");
            stringBuilder.append(connectionInProgress2 ^= i4);
            Log.d(str3, stringBuilder.toString());
        }
        if (this.connectionInProgress) {
        }
        this.connectionInProgress = i4;
        if (a.b().a(this.context, this.connectionIntent, this, 65)) {
        }
        Log.e(str3, "binding to the service failed");
        this.connectionInProgress = false;
        finishAllInQueue();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        boolean loggable;
        int str;
        Object obj3;
        synchronized (this) {
            try {
                obj3 = String.valueOf(componentName);
                String.valueOf(obj3).length();
                Log.d("FirebaseMessaging", "onServiceConnected: ".concat(String.valueOf(obj3)));
                this.connectionInProgress = false;
                if (!iBinder2 instanceof WithinAppServiceBinder) {
                }
                obj3 = String.valueOf(iBinder2);
                String.valueOf(obj3).length();
                Log.e("FirebaseMessaging", "Invalid service connection: ".concat(String.valueOf(obj3)));
                finishAllInQueue();
                this.binder = (WithinAppServiceBinder)iBinder2;
                flushQueue();
                throw componentName;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        boolean loggable;
        Object obj3;
        final String str = "FirebaseMessaging";
        if (Log.isLoggable(str, 3)) {
            obj3 = String.valueOf(componentName);
            String.valueOf(obj3).length();
            Log.d(str, "onServiceDisconnected: ".concat(String.valueOf(obj3)));
        }
        flushQueue();
    }

    j<Void> sendIntent(Intent intent) {
        boolean loggable;
        int str;
        synchronized (this) {
            try {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
                WithinAppServiceConnection.BindRequest bindRequest = new WithinAppServiceConnection.BindRequest(intent);
                bindRequest.arrangeTimeout(this.scheduledExecutorService);
                this.intentQueue.add(bindRequest);
                flushQueue();
                return bindRequest.getTask();
                throw intent;
            }
        }
    }
}
