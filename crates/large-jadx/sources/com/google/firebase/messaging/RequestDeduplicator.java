package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.j;
import d.e.a;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
class RequestDeduplicator {

    private final Executor executor;
    private final Map<String, j<String>> getTokenRequests;

    interface GetTokenRequest {
        public abstract j<String> start();
    }
    RequestDeduplicator(Executor executor) {
        super();
        a aVar = new a();
        this.getTokenRequests = aVar;
        this.executor = executor;
    }

    j<String> getOrStartGetTokenRequest(String string, com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest requestDeduplicator$GetTokenRequest2) {
        boolean loggable;
        int length2;
        int length;
        Object obj4;
        boolean obj5;
        Object obj = this.getTokenRequests.get(string);
        length2 = 3;
        synchronized (this) {
            try {
                if (Log.isLoggable("FirebaseMessaging", length2)) {
                }
                obj4 = String.valueOf(string);
                obj5 = "Joining ongoing request for: ";
                if (obj4.length() != 0) {
                } else {
                }
                obj4 = obj5.concat(obj4);
                obj4 = new String(obj5);
                Log.d("FirebaseMessaging", obj4);
                return (j)obj;
                if (Log.isLoggable("FirebaseMessaging", length2)) {
                }
                String valueOf = String.valueOf(string);
                String str2 = "Making new request for: ";
                if (valueOf.length() != 0) {
                } else {
                }
                loggable = str2.concat(valueOf);
                loggable = new String(str2);
                Log.d("FirebaseMessaging", loggable);
                RequestDeduplicator$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new RequestDeduplicator$$ExternalSyntheticLambda0(this, string);
                obj5 = getTokenRequest2.start().continueWithTask(this.executor, externalSyntheticLambda0);
                this.getTokenRequests.put(string, obj5);
                return obj5;
                throw string;
            }
        }
    }

    j lambda$getOrStartGetTokenRequest$0$com-google-firebase-messaging-RequestDeduplicator(String string, j j2) {
        this.getTokenRequests.remove(string);
        return j2;
        synchronized (this) {
            this.getTokenRequests.remove(string);
            return j2;
        }
    }
}
