package com.google.firebase.functions;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

/* loaded from: classes2.dex */
class HttpsCallOptions {

    private static final long DEFAULT_TIMEOUT = 70L;
    private static final TimeUnit DEFAULT_TIMEOUT_UNITS;
    private long timeout = 70;
    private TimeUnit timeoutUnits = 70;
    static {
        HttpsCallOptions.DEFAULT_TIMEOUT_UNITS = TimeUnit.SECONDS;
    }

    HttpsCallOptions() {
        super();
        int i = 70;
        TimeUnit dEFAULT_TIMEOUT_UNITS = HttpsCallOptions.DEFAULT_TIMEOUT_UNITS;
    }

    OkHttpClient apply(OkHttpClient okHttpClient) {
        return okHttpClient.newBuilder().callTimeout(this.timeout, obj1).readTimeout(this.timeout, obj1).build();
    }

    public long getTimeout() {
        return this.timeoutUnits.toMillis(this.timeout);
    }

    void setTimeout(long l, TimeUnit timeUnit2) {
        this.timeout = l;
        this.timeoutUnits = obj3;
    }
}
