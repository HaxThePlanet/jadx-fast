package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.cloudmessaging.a;
import com.google.android.gms.cloudmessaging.b;
import com.google.android.gms.tasks.m;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.MessagingAnalytics;

/* loaded from: classes2.dex */
public final class FirebaseInstanceIdReceiver extends b {
    @Override // com.google.android.gms.cloudmessaging.b
    protected final int onMessageReceive(Context context, a a2) {
        try {
            FcmBroadcastProcessor fcmBroadcastProcessor = new FcmBroadcastProcessor(context);
            return (Integer)m.a(fcmBroadcastProcessor.process(a2.j2())).intValue();
            a2 = "FirebaseMessaging";
            Log.e(a2, "Failed to send message to service.", context);
            context = 500;
            return context;
        }
    }

    @Override // com.google.android.gms.cloudmessaging.b
    protected final void onNotificationDismissed(Context context, Bundle bundle2) {
        Intent obj2 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
        obj2 = obj2.putExtras(bundle2);
        if (MessagingAnalytics.shouldUploadScionMetrics(obj2)) {
            MessagingAnalytics.logNotificationDismiss(obj2);
        }
    }
}
