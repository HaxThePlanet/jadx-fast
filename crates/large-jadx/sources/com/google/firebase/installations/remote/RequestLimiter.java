package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class RequestLimiter {

    private static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS;
    private int attemptCount;
    private long nextRequestTime;
    private final Utils utils;
    static {
        RequestLimiter.MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
        RequestLimiter.MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    }

    RequestLimiter() {
        super();
        this.utils = Utils.getInstance();
    }

    RequestLimiter(Utils utils) {
        super();
        this.utils = utils;
    }

    private long getBackoffDuration(int i) {
        synchronized (this) {
            try {
                return RequestLimiter.MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
                return (long)d2;
                throw i;
            }
        }
    }

    private static boolean isRetryableError(int i) {
        int i2;
        int obj1;
        if (i != 429) {
            if (i >= 500 && i < 600) {
                if (i < 600) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static boolean isSuccessfulOrRequiresNewFidCreation(int i) {
        int i2;
        int obj1;
        if (i >= 200) {
            if (i >= 300 && i != 401) {
                if (i != 401) {
                    if (i == 404) {
                        obj1 = 1;
                    } else {
                        obj1 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private void resetBackoffStrategy() {
        this.attemptCount = 0;
        return;
        synchronized (this) {
            this.attemptCount = 0;
        }
    }

    public boolean isRequestAllowed() {
        int i;
        int attemptCount;
        long nextRequestTime;
        synchronized (this) {
            try {
                if (Long.compare(currentTimeInMillis, nextRequestTime) > 0) {
                } else {
                }
                i = 0;
                i = 1;
                return i;
                throw th;
            }
        }
    }

    public void setNextRequestTime(int i) {
        synchronized (this) {
            try {
                resetBackoffStrategy();
                this.attemptCount = attemptCount++;
                this.nextRequestTime = currentTimeInMillis += backoffDuration;
                throw i;
            }
        }
    }
}
