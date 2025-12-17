package com.google.firebase.database.connection.util;

import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class RetryHelper {

    private long currentRetryDelay;
    private final ScheduledExecutorService executorService;
    private final double jitterFactor;
    private boolean lastWasSuccess;
    private final LogWrapper logger;
    private final long maxRetryDelay;
    private final long minRetryDelayAfterFailure;
    private final Random random;
    private final double retryExponent;
    private ScheduledFuture<?> scheduledRetry;

    public static class Builder {

        private double jitterFactor = 0.5d;
        private final LogWrapper logger;
        private long minRetryDelayAfterFailure = 1000;
        private double retryExponent = 1.3d;
        private long retryMaxDelay = 30000;
        private final ScheduledExecutorService service;
        public Builder(ScheduledExecutorService scheduledExecutorService, Logger logger2, String string3) {
            super();
            int i = 1000;
            long l = 4602678819172646912L;
            int i2 = 30000;
            long l2 = 4608533498688228557L;
            this.service = scheduledExecutorService;
            LogWrapper obj3 = new LogWrapper(logger2, string3);
            this.logger = obj3;
        }

        public com.google.firebase.database.connection.util.RetryHelper build() {
            super(this.service, this.logger, this.minRetryDelayAfterFailure, obj4, this.retryMaxDelay, obj6, this.retryExponent, obj8, this.jitterFactor, obj10, 0);
            return retryHelper2;
        }

        public com.google.firebase.database.connection.util.RetryHelper.Builder withJitterFactor(double d) {
            int cmp;
            if (Double.compare(d, i) < 0) {
            } else {
                if (Double.compare(d, l) > 0) {
                } else {
                    this.jitterFactor = d;
                    return this;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Argument out of range: ");
            stringBuilder.append(d);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        public com.google.firebase.database.connection.util.RetryHelper.Builder withMaxDelay(long l) {
            this.retryMaxDelay = l;
            return this;
        }

        public com.google.firebase.database.connection.util.RetryHelper.Builder withMinDelayAfterFailure(long l) {
            this.minRetryDelayAfterFailure = l;
            return this;
        }

        public com.google.firebase.database.connection.util.RetryHelper.Builder withRetryExponent(double d) {
            this.retryExponent = d;
            return this;
        }
    }
    private RetryHelper(ScheduledExecutorService scheduledExecutorService, LogWrapper logWrapper2, long l3, long l4, double d5, double d6) {
        super();
        Random random = new Random();
        this.random = random;
        this.lastWasSuccess = true;
        this.executorService = scheduledExecutorService;
        this.logger = logWrapper2;
        this.minRetryDelayAfterFailure = l3;
        this.maxRetryDelay = d5;
        this.retryExponent = obj8;
        this.jitterFactor = obj10;
    }

    RetryHelper(ScheduledExecutorService scheduledExecutorService, LogWrapper logWrapper2, long l3, long l4, double d5, double d6, com.google.firebase.database.connection.util.RetryHelper.1 retryHelper$17) {
        super(scheduledExecutorService, logWrapper2, l3, l4, d5, d6, 17, obj8, obj9, obj10);
    }

    static ScheduledFuture access$002(com.google.firebase.database.connection.util.RetryHelper retryHelper, ScheduledFuture scheduledFuture2) {
        retryHelper.scheduledRetry = scheduledFuture2;
        return scheduledFuture2;
    }

    public void cancel() {
        int logger;
        int arr;
        Object[] arr2;
        String str;
        arr = 0;
        if (this.scheduledRetry != null) {
            this.logger.debug("Cancelling existing retry attempt", new Object[arr]);
            this.scheduledRetry.cancel(arr);
            this.scheduledRetry = 0;
        } else {
            this.logger.debug("No existing retry attempt to cancel", new Object[arr]);
        }
        this.currentRetryDelay = 0;
    }

    public void retry(Runnable runnable) {
        Object[] arr;
        int i2;
        long minRetryDelayAfterFailure;
        String str;
        int i;
        long currentRetryDelay;
        double nextDouble;
        double d;
        ScheduledFuture obj11;
        RetryHelper.1 anon = new RetryHelper.1(this, runnable);
        int i3 = 0;
        if (this.scheduledRetry != null) {
            this.logger.debug("Cancelling previous scheduled retry", new Object[i3]);
            this.scheduledRetry.cancel(i3);
            this.scheduledRetry = 0;
        }
        if (this.lastWasSuccess) {
        } else {
            currentRetryDelay = this.currentRetryDelay;
            if (Long.compare(currentRetryDelay, i2) == 0) {
                this.currentRetryDelay = this.minRetryDelayAfterFailure;
            } else {
                this.currentRetryDelay = Math.min((long)i7, str);
            }
            double jitterFactor = this.jitterFactor;
            long currentRetryDelay2 = this.currentRetryDelay;
            i2 = (long)i6;
        }
        this.lastWasSuccess = i3;
        Object[] arr2 = new Object[1];
        arr2[i3] = Long.valueOf(i2);
        this.logger.debug("Scheduling retry in %dms", arr2);
        this.scheduledRetry = this.executorService.schedule(anon, i2, str);
    }

    public void setMaxDelay() {
        this.currentRetryDelay = this.maxRetryDelay;
    }

    public void signalSuccess() {
        this.lastWasSuccess = true;
        this.currentRetryDelay = 0;
    }
}
