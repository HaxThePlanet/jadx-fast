package com.google.firebase.perf.transport;

import android.content.Context;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants.TraceNames;
import com.google.firebase.perf.util.Rate;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class RateLimiter {

    private final ConfigResolver configResolver;
    private boolean isLogcatEnabled;
    private com.google.firebase.perf.transport.RateLimiter.RateLimiterImpl networkLimiter;
    private final float samplingBucketId;
    private com.google.firebase.perf.transport.RateLimiter.RateLimiterImpl traceLimiter;

    static class RateLimiterImpl {

        private static final long MICROS_IN_A_SECOND;
        private static final AndroidLogger logger;
        private long backgroundCapacity;
        private Rate backgroundRate;
        private long capacity;
        private final Clock clock;
        private long foregroundCapacity;
        private Rate foregroundRate;
        private final boolean isLogcatEnabled;
        private Timer lastTimeTokenReplenished;
        private Rate rate;
        private long tokenCount;
        static {
            RateLimiter.RateLimiterImpl.logger = AndroidLogger.getInstance();
            RateLimiter.RateLimiterImpl.MICROS_IN_A_SECOND = TimeUnit.SECONDS.toMicros(1);
        }

        RateLimiterImpl(Rate rate, long l2, Clock clock3, ConfigResolver configResolver4, String string5, boolean z6) {
            super();
            this.clock = configResolver4;
            this.capacity = l2;
            this.rate = rate;
            this.tokenCount = l2;
            this.lastTimeTokenReplenished = configResolver4.getTime();
            setRateByReadingRemoteConfigValues(string5, z6, obj7);
            this.isLogcatEnabled = obj7;
        }

        private static long getBlimitEvents(ConfigResolver configResolver, String string2) {
            if (string2 == "Trace") {
                return configResolver.getTraceEventCountBackground();
            }
            return configResolver.getNetworkEventCountBackground();
        }

        private static long getBlimitSec(ConfigResolver configResolver, String string2) {
            if (string2 == "Trace") {
                return configResolver.getRateLimitSec();
            }
            return configResolver.getRateLimitSec();
        }

        private static long getFlimitEvents(ConfigResolver configResolver, String string2) {
            if (string2 == "Trace") {
                return configResolver.getTraceEventCountForeground();
            }
            return configResolver.getNetworkEventCountForeground();
        }

        private static long getFlimitSec(ConfigResolver configResolver, String string2) {
            if (string2 == "Trace") {
                return configResolver.getRateLimitSec();
            }
            return configResolver.getRateLimitSec();
        }

        private void setRateByReadingRemoteConfigValues(ConfigResolver configResolver, String string2, boolean z3) {
            int str;
            int valueOf;
            int arr;
            AndroidLogger logger;
            TimeUnit arr2;
            long flimitEvents;
            long logger2;
            final Object obj = this;
            flimitEvents = RateLimiter.RateLimiterImpl.getFlimitEvents(configResolver, string2);
            final TimeUnit sECONDS = TimeUnit.SECONDS;
            super(flimitEvents, obj3, RateLimiter.RateLimiterImpl.getFlimitSec(configResolver, string2), obj5, sECONDS);
            obj.foregroundRate = rate3;
            obj.foregroundCapacity = flimitEvents;
            str = 2;
            valueOf = 1;
            final int i = 0;
            arr = 3;
            if (z3) {
                arr2 = new Object[arr];
                arr2[i] = string2;
                arr2[valueOf] = rate3;
                arr2[str] = Long.valueOf(flimitEvents);
                RateLimiter.RateLimiterImpl.logger.debug("Foreground %s logging rate:%f, burst capacity:%d", arr2);
            }
            long blimitEvents = RateLimiter.RateLimiterImpl.getBlimitEvents(configResolver, string2);
            super(blimitEvents, obj12, RateLimiter.RateLimiterImpl.getBlimitSec(configResolver, string2), obj14, sECONDS);
            obj.backgroundRate = rate2;
            obj.backgroundCapacity = blimitEvents;
            if (z3) {
                arr = new Object[arr];
                arr[i] = string2;
                arr[valueOf] = rate2;
                arr[str] = Long.valueOf(blimitEvents);
                RateLimiter.RateLimiterImpl.logger.debug("Background %s logging rate:%f, capacity:%d", arr);
            }
        }

        void changeRate(boolean z) {
            Rate foregroundRate;
            long backgroundCapacity;
            synchronized (this) {
                foregroundRate = this.foregroundRate;
                try {
                    this.rate = foregroundRate;
                    if (z != null) {
                    } else {
                    }
                    backgroundCapacity = this.foregroundCapacity;
                    backgroundCapacity = this.backgroundCapacity;
                    this.capacity = backgroundCapacity;
                    throw z;
                }
            }
        }

        boolean check(PerfMetric perfMetric) {
            long l;
            long tokenCount;
            long mICROS_IN_A_SECOND;
            long l2;
            int obj11;
            mICROS_IN_A_SECOND = RateLimiter.RateLimiterImpl.MICROS_IN_A_SECOND;
            int i7 = 0;
            l = Math.max(i7, obj5);
            this.tokenCount = Math.min(tokenCount2 += l, obj7);
            synchronized (this) {
                try {
                    obj11 = new Timer(micros += l, obj7);
                    this.lastTimeTokenReplenished = obj11;
                    tokenCount = this.tokenCount;
                    if (Long.compare(tokenCount, i7) > 0) {
                    }
                    this.tokenCount = tokenCount -= i6;
                    return 1;
                    if (this.isLogcatEnabled) {
                    }
                    RateLimiter.RateLimiterImpl.logger.warn("Exceeded log rate limit, dropping the log.");
                    return 0;
                    throw perfMetric;
                }
            }
        }

        long getBackgroundCapacity() {
            return this.backgroundCapacity;
        }

        Rate getBackgroundRate() {
            return this.backgroundRate;
        }

        long getForegroundCapacity() {
            return this.foregroundCapacity;
        }

        Rate getForegroundRate() {
            return this.foregroundRate;
        }

        Rate getRate() {
            return this.rate;
        }

        void setRate(Rate rate) {
            this.rate = rate;
        }
    }
    public RateLimiter(Context context, Rate rate2, long l3) {
        Clock clock = new Clock();
        super(rate2, l3, obj3, clock, RateLimiter.getSamplingBucketId(), ConfigResolver.getInstance());
        this.isLogcatEnabled = Utils.isDebugLoggingEnabled(context);
    }

    RateLimiter(Rate rate, long l2, Clock clock3, float f4, ConfigResolver configResolver5) {
        int i;
        int cmp;
        final Object obj = this;
        int i2 = configResolver5;
        super();
        int i3 = 0;
        obj.traceLimiter = i3;
        obj.networkLimiter = i3;
        obj.isLogcatEnabled = false;
        if (Float.compare(i4, i2) <= 0 && Float.compare(i2, i5) < 0) {
            i = Float.compare(i2, i5) < 0 ? 1 : i;
        }
        Utils.checkArgument(i, "Sampling bucket ID should be in range [0.0f, 1.0f).");
        obj.samplingBucketId = i2;
        obj.configResolver = obj18;
        final Rate rate2 = rate;
        final long l = l2;
        final ConfigResolver configResolver2 = f4;
        final String str2 = obj18;
        super(rate2, l, obj7, configResolver2, str2, "Trace", obj.isLogcatEnabled);
        obj.traceLimiter = rateLimiterImpl;
        super(rate2, l, obj7, configResolver2, str2, "Network", obj.isLogcatEnabled);
        obj.networkLimiter = rateLimiterImpl2;
    }

    static float getSamplingBucketId() {
        Random random = new Random();
        return random.nextFloat();
    }

    private boolean hasVerboseSessions(List<PerfSession> list) {
        int sessionVerbosityCount;
        int i;
        SessionVerbosity obj3;
        i = 0;
        if (list.size() > 0 && (PerfSession)list.get(i).getSessionVerbosityCount() > 0 && (PerfSession)list.get(i).getSessionVerbosity(i) == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
            if ((PerfSession)list.get(i).getSessionVerbosityCount() > 0) {
                if ((PerfSession)list.get(i).getSessionVerbosity(i) == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS) {
                    i = 1;
                }
            }
        }
        return i;
    }

    private boolean isDeviceAllowedToSendNetworkEvents() {
        int i;
        i = Float.compare(samplingBucketId, networkRequestSamplingRate) < 0 ? 1 : 0;
        return i;
    }

    private boolean isDeviceAllowedToSendTraces() {
        int i;
        i = Float.compare(samplingBucketId, traceSamplingRate) < 0 ? 1 : 0;
        return i;
    }

    void changeRate(boolean z) {
        this.traceLimiter.changeRate(z);
        this.networkLimiter.changeRate(z);
    }

    boolean check(PerfMetric perfMetric) {
        boolean deviceAllowedToSendTraces;
        boolean networkRequestMetric;
        final int i = 0;
        if (perfMetric.hasTraceMetric() && !isDeviceAllowedToSendTraces() && !hasVerboseSessions(perfMetric.getTraceMetric().getPerfSessionsList())) {
            if (!isDeviceAllowedToSendTraces()) {
                if (!hasVerboseSessions(perfMetric.getTraceMetric().getPerfSessionsList())) {
                    return i;
                }
            }
        }
        if (perfMetric.hasNetworkRequestMetric() && !isDeviceAllowedToSendNetworkEvents() && !hasVerboseSessions(perfMetric.getNetworkRequestMetric().getPerfSessionsList())) {
            if (!isDeviceAllowedToSendNetworkEvents()) {
                if (!hasVerboseSessions(perfMetric.getNetworkRequestMetric().getPerfSessionsList())) {
                    return i;
                }
            }
        }
        if (!isRateLimited(perfMetric)) {
            return 1;
        }
        if (perfMetric.hasNetworkRequestMetric()) {
            return this.networkLimiter.check(perfMetric);
        }
        if (perfMetric.hasTraceMetric()) {
            return this.traceLimiter.check(perfMetric);
        }
        return i;
    }

    boolean getIsDeviceAllowedToSendNetworkEvents() {
        return isDeviceAllowedToSendNetworkEvents();
    }

    boolean getIsDeviceAllowedToSendTraces() {
        return isDeviceAllowedToSendTraces();
    }

    boolean isRateLimited(PerfMetric perfMetric) {
        boolean countersCount;
        String string;
        final int i = 0;
        if (perfMetric.hasTraceMetric()) {
            if (!perfMetric.getTraceMetric().getName().equals(Constants.TraceNames.FOREGROUND_TRACE_NAME.toString())) {
                if (perfMetric.getTraceMetric().getName().equals(Constants.TraceNames.BACKGROUND_TRACE_NAME.toString()) && perfMetric.getTraceMetric().getCountersCount() > 0) {
                    if (perfMetric.getTraceMetric().getCountersCount() > 0) {
                        return i;
                    }
                }
            } else {
            }
        }
        if (perfMetric.hasGaugeMetric()) {
            return i;
        }
        return 1;
    }
}
