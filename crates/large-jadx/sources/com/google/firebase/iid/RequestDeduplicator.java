package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.j;
import d.e.a;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
class RequestDeduplicator {

    private final Executor executor;
    private final Map<Pair<String, String>, j<com.google.firebase.iid.InstanceIdResult>> getTokenRequests;

    interface GetTokenRequest {
        public abstract j<com.google.firebase.iid.InstanceIdResult> start();
    }
    RequestDeduplicator(Executor executor) {
        super();
        a aVar = new a();
        this.getTokenRequests = aVar;
        this.executor = executor;
    }

    j<com.google.firebase.iid.InstanceIdResult> getOrStartGetTokenRequest(String string, String string2, com.google.firebase.iid.RequestDeduplicator.GetTokenRequest requestDeduplicator$GetTokenRequest3) {
        Object stringBuilder2;
        StringBuilder stringBuilder;
        boolean obj3;
        boolean obj4;
        String obj5;
        stringBuilder2 = new Pair(string, string2);
        obj3 = this.getTokenRequests.get(stringBuilder2);
        obj4 = 3;
        synchronized (this) {
            try {
                if (Log.isLoggable("FirebaseInstanceId", obj4)) {
                }
                obj4 = String.valueOf(stringBuilder2);
                stringBuilder2 = new StringBuilder(obj5 += 29);
                stringBuilder2.append("Joining ongoing request for: ");
                stringBuilder2.append(obj4);
                Log.d("FirebaseInstanceId", stringBuilder2.toString());
                return (j)obj3;
                if (Log.isLoggable("FirebaseInstanceId", obj4)) {
                }
                obj3 = String.valueOf(stringBuilder2);
                stringBuilder = new StringBuilder(obj4 += 24);
                stringBuilder.append("Making new request for: ");
                stringBuilder.append(obj3);
                Log.d("FirebaseInstanceId", stringBuilder.toString());
                obj5 = new RequestDeduplicator$$Lambda.0(this, stringBuilder2);
                obj3 = getTokenRequest3.start().continueWithTask(this.executor, obj5);
                this.getTokenRequests.put(stringBuilder2, obj3);
                return obj3;
                throw string;
            }
        }
    }

    final j lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(Pair pair, j j2) {
        this.getTokenRequests.remove(pair);
        return j2;
        synchronized (this) {
            this.getTokenRequests.remove(pair);
            return j2;
        }
    }
}
