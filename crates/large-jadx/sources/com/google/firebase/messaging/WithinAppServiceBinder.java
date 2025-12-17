package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
class WithinAppServiceBinder extends Binder {

    private final com.google.firebase.messaging.WithinAppServiceBinder.IntentHandler intentHandler;

    interface IntentHandler {
        public abstract j<Void> handle(Intent intent);
    }
    WithinAppServiceBinder(com.google.firebase.messaging.WithinAppServiceBinder.IntentHandler withinAppServiceBinder$IntentHandler) {
        super();
        this.intentHandler = intentHandler;
    }

    static void lambda$send$0(com.google.firebase.messaging.WithinAppServiceConnection.BindRequest withinAppServiceConnection$BindRequest, j j2) {
        bindRequest.finish();
    }

    @Override // android.os.Binder
    void send(com.google.firebase.messaging.WithinAppServiceConnection.BindRequest withinAppServiceConnection$BindRequest) {
        boolean loggable;
        if (Binder.getCallingUid() != Process.myUid()) {
        } else {
            String str2 = "FirebaseMessaging";
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "service received new intent via bind strategy");
            }
            WithinAppServiceBinder$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new WithinAppServiceBinder$$ExternalSyntheticLambda0(bindRequest);
            this.intentHandler.handle(bindRequest.intent).addOnCompleteListener(WithinAppServiceBinder$$ExternalSyntheticLambda1.INSTANCE, externalSyntheticLambda0);
        }
        SecurityException obj4 = new SecurityException("Binding only allowed within app");
        throw obj4;
    }
}
