package com.google.firebase.functions;

import com.google.android.gms.tasks.j;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class HttpsCallableReference {

    private final com.google.firebase.functions.FirebaseFunctions functionsClient;
    private final String name;
    com.google.firebase.functions.HttpsCallOptions options;
    HttpsCallableReference(com.google.firebase.functions.FirebaseFunctions firebaseFunctions, String string2) {
        super();
        HttpsCallOptions httpsCallOptions = new HttpsCallOptions();
        this.options = httpsCallOptions;
        this.functionsClient = firebaseFunctions;
        this.name = string2;
    }

    public j<com.google.firebase.functions.HttpsCallableResult> call() {
        return this.functionsClient.call(this.name, 0, this.options);
    }

    public j<com.google.firebase.functions.HttpsCallableResult> call(Object object) {
        return this.functionsClient.call(this.name, object, this.options);
    }

    public long getTimeout() {
        return this.options.getTimeout();
    }

    public void setTimeout(long l, TimeUnit timeUnit2) {
        this.options.setTimeout(l, timeUnit2);
    }

    public com.google.firebase.functions.HttpsCallableReference withTimeout(long l, TimeUnit timeUnit2) {
        HttpsCallableReference httpsCallableReference = new HttpsCallableReference(this.functionsClient, this.name);
        httpsCallableReference.setTimeout(l, timeUnit2);
        return httpsCallableReference;
    }
}
