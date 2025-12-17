package com.google.firebase.storage.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.network.NetworkRequest;
import java.util.Random;

/* loaded from: classes2.dex */
public class ExponentialBackoffSender {

    private static final int MAXIMUM_WAIT_TIME_MILLI = 30000;
    private static final int NETWORK_STATUS_POLL_INTERVAL = 1000;
    public static final int RND_MAX = 250;
    private static final String TAG = "ExponenentialBackoff";
    static e clock;
    private static final Random random;
    static com.google.firebase.storage.internal.Sleeper sleeper;
    private final InternalAppCheckTokenProvider appCheckProvider;
    private final InternalAuthProvider authProvider;
    private volatile boolean canceled;
    private final Context context;
    private long retryTime;
    static {
        Random random = new Random();
        ExponentialBackoffSender.random = random;
        SleeperImpl sleeperImpl = new SleeperImpl();
        ExponentialBackoffSender.sleeper = sleeperImpl;
        ExponentialBackoffSender.clock = h.b();
    }

    public ExponentialBackoffSender(Context context, InternalAuthProvider internalAuthProvider2, InternalAppCheckTokenProvider internalAppCheckTokenProvider3, long l4) {
        super();
        this.context = context;
        this.authProvider = internalAuthProvider2;
        this.appCheckProvider = internalAppCheckTokenProvider3;
        this.retryTime = l4;
    }

    public void cancel() {
        this.canceled = true;
    }

    public boolean isRetryableError(int i) {
        int i2;
        int obj2;
        if (i >= 500) {
            if (i >= 600 && i != -2 && i != 429) {
                if (i != -2) {
                    if (i != 429) {
                        if (i == 408) {
                            obj2 = 1;
                        } else {
                            obj2 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    public void reset() {
        this.canceled = false;
    }

    public void sendWithExponentialBackoff(NetworkRequest networkRequest) {
        sendWithExponentialBackoff(networkRequest, true);
    }

    public void sendWithExponentialBackoff(NetworkRequest networkRequest, boolean z2) {
        String currentAuthToken2;
        String currentAppCheckToken;
        int i;
        Context currentAuthToken;
        int retryableError;
        int resultCode;
        String currentAppCheckToken2;
        int i2;
        Context context;
        Object obj10;
        final String str = "ExponenentialBackoff";
        r.j(networkRequest);
        if (z2) {
            networkRequest.performRequest(Util.getCurrentAuthToken(this.authProvider), Util.getCurrentAppCheckToken(this.appCheckProvider), this.context);
        } else {
            networkRequest.performRequestStart(Util.getCurrentAuthToken(this.authProvider), Util.getCurrentAppCheckToken(this.appCheckProvider));
        }
        int i4 = 1000;
        i = i4;
        while (Long.compare(i5, i3) <= 0) {
            ExponentialBackoffSender.sleeper.sleep(nextInt += i);
            if (i < 30000) {
            }
            networkRequest.reset();
            if (z2) {
            } else {
            }
            networkRequest.performRequestStart(Util.getCurrentAuthToken(this.authProvider), Util.getCurrentAppCheckToken(this.appCheckProvider));
            networkRequest.performRequest(Util.getCurrentAuthToken(this.authProvider), Util.getCurrentAppCheckToken(this.appCheckProvider), this.context);
            if (networkRequest.getResultCode() != -2) {
            } else {
            }
            Log.w(str, "network unavailable, sleeping.");
            i = i4;
            i *= 2;
            Log.w(str, "network error occurred, backing off/sleeping.");
        }
    }
}
