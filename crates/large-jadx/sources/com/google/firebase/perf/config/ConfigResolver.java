package com.google.firebase.perf.config;

import android.content.Context;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.perf.util.Utils;

/* loaded from: classes2.dex */
public class ConfigResolver {

    private static volatile com.google.firebase.perf.config.ConfigResolver instance;
    private static final AndroidLogger logger;
    private com.google.firebase.perf.config.DeviceCacheManager deviceCacheManager;
    private ImmutableBundle metadataBundle;
    private final com.google.firebase.perf.config.RemoteConfigManager remoteConfigManager;
    static {
        ConfigResolver.logger = AndroidLogger.getInstance();
    }

    public ConfigResolver(com.google.firebase.perf.config.RemoteConfigManager remoteConfigManager, ImmutableBundle immutableBundle2, com.google.firebase.perf.config.DeviceCacheManager deviceCacheManager3) {
        com.google.firebase.perf.config.RemoteConfigManager obj1;
        ImmutableBundle obj2;
        com.google.firebase.perf.config.DeviceCacheManager obj3;
        super();
        if (remoteConfigManager == null) {
            obj1 = RemoteConfigManager.getInstance();
        }
        this.remoteConfigManager = obj1;
        if (immutableBundle2 == null) {
            obj2 = new ImmutableBundle();
        }
        this.metadataBundle = obj2;
        if (deviceCacheManager3 == null) {
            obj3 = DeviceCacheManager.getInstance();
        }
        this.deviceCacheManager = obj3;
    }

    public static void clearInstance() {
        ConfigResolver.instance = 0;
    }

    private Optional<Boolean> getDeviceCacheBoolean(com.google.firebase.perf.config.ConfigurationFlag<Boolean> configurationFlag) {
        return this.deviceCacheManager.getBoolean(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<Float> getDeviceCacheFloat(com.google.firebase.perf.config.ConfigurationFlag<Float> configurationFlag) {
        return this.deviceCacheManager.getFloat(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<Long> getDeviceCacheLong(com.google.firebase.perf.config.ConfigurationFlag<Long> configurationFlag) {
        return this.deviceCacheManager.getLong(configurationFlag.getDeviceCacheFlag());
    }

    private Optional<String> getDeviceCacheString(com.google.firebase.perf.config.ConfigurationFlag<String> configurationFlag) {
        return this.deviceCacheManager.getString(configurationFlag.getDeviceCacheFlag());
    }

    public static com.google.firebase.perf.config.ConfigResolver getInstance() {
        com.google.firebase.perf.config.ConfigResolver configResolver;
        int i;
        final Class<com.google.firebase.perf.config.ConfigResolver> obj = ConfigResolver.class;
        synchronized (obj) {
            i = 0;
            configResolver = new ConfigResolver(i, i, i);
            ConfigResolver.instance = configResolver;
            return ConfigResolver.instance;
        }
    }

    private boolean getIsSdkEnabled() {
        com.google.firebase.perf.config.ConfigurationConstants.SdkEnabled instance = ConfigurationConstants.SdkEnabled.getInstance();
        Optional remoteConfigBoolean = getRemoteConfigBoolean(instance);
        if (remoteConfigBoolean.isAvailable() && this.remoteConfigManager.isLastFetchFailed()) {
            if (this.remoteConfigManager.isLastFetchFailed()) {
                return 0;
            }
            this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Boolean)remoteConfigBoolean.get().booleanValue());
            return (Boolean)remoteConfigBoolean.get().booleanValue();
        }
        Optional deviceCacheBoolean = getDeviceCacheBoolean(instance);
        if (deviceCacheBoolean.isAvailable()) {
            return (Boolean)deviceCacheBoolean.get().booleanValue();
        }
        return instance.getDefault().booleanValue();
    }

    private boolean getIsSdkVersionDisabled() {
        com.google.firebase.perf.config.ConfigurationConstants.SdkDisabledVersions instance = ConfigurationConstants.SdkDisabledVersions.getInstance();
        Optional remoteConfigString = getRemoteConfigString(instance);
        if (remoteConfigString.isAvailable()) {
            this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (String)remoteConfigString.get());
            return isFireperfSdkVersionInList((String)remoteConfigString.get());
        }
        Optional deviceCacheString = getDeviceCacheString(instance);
        if (deviceCacheString.isAvailable()) {
            return isFireperfSdkVersionInList((String)deviceCacheString.get());
        }
        return isFireperfSdkVersionInList(instance.getDefault());
    }

    private Optional<Boolean> getMetadataBoolean(com.google.firebase.perf.config.ConfigurationFlag<Boolean> configurationFlag) {
        return this.metadataBundle.getBoolean(configurationFlag.getMetadataFlag());
    }

    private Optional<Float> getMetadataFloat(com.google.firebase.perf.config.ConfigurationFlag<Float> configurationFlag) {
        return this.metadataBundle.getFloat(configurationFlag.getMetadataFlag());
    }

    private Optional<Long> getMetadataLong(com.google.firebase.perf.config.ConfigurationFlag<Long> configurationFlag) {
        return this.metadataBundle.getLong(configurationFlag.getMetadataFlag());
    }

    private Optional<Boolean> getRemoteConfigBoolean(com.google.firebase.perf.config.ConfigurationFlag<Boolean> configurationFlag) {
        return this.remoteConfigManager.getBoolean(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<Float> getRemoteConfigFloat(com.google.firebase.perf.config.ConfigurationFlag<Float> configurationFlag) {
        return this.remoteConfigManager.getFloat(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<Long> getRemoteConfigLong(com.google.firebase.perf.config.ConfigurationFlag<Long> configurationFlag) {
        return this.remoteConfigManager.getLong(configurationFlag.getRemoteConfigFlag());
    }

    private Optional<String> getRemoteConfigString(com.google.firebase.perf.config.ConfigurationFlag<String> configurationFlag) {
        return this.remoteConfigManager.getString(configurationFlag.getRemoteConfigFlag());
    }

    private Long getRemoteConfigValue(com.google.firebase.perf.config.ConfigurationFlag<Long> configurationFlag) {
        com.google.firebase.perf.config.RemoteConfigManager remoteConfigManager;
        Object obj3;
        final String remoteConfigFlag = configurationFlag.getRemoteConfigFlag();
        if (remoteConfigFlag == null) {
            obj3 = configurationFlag.getDefault();
        } else {
            obj3 = this.remoteConfigManager.getRemoteConfigValueOrDefault(remoteConfigFlag, (Long)configurationFlag.getDefault());
        }
        return obj3;
    }

    private boolean isEventCountValid(long l) {
        int obj3;
        obj3 = Long.compare(l, i) >= 0 ? 1 : 0;
        return obj3;
    }

    private boolean isFireperfSdkVersionInList(String string) {
        int i;
        boolean equals;
        String fIREPERF_VERSION_NAME;
        final int i2 = 0;
        if (string.trim().isEmpty()) {
            return i2;
        }
        String[] obj6 = string.split(";");
        i = i2;
        while (i < obj6.length) {
            i++;
        }
        return i2;
    }

    private boolean isGaugeCaptureFrequencyMsValid(long l) {
        int obj3;
        obj3 = Long.compare(l, i) >= 0 ? 1 : 0;
        return obj3;
    }

    private boolean isSamplingRateValid(float f) {
        int cmp;
        int obj2;
        if (Float.compare(i, f) <= 0 && Float.compare(f, cmp) <= 0) {
            obj2 = Float.compare(f, cmp) <= 0 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private boolean isSessionsMaxDurationMinutesValid(long l) {
        int obj3;
        obj3 = Long.compare(l, i) > 0 ? 1 : 0;
        return obj3;
    }

    private boolean isTimeRangeSecValid(long l) {
        int obj3;
        obj3 = Long.compare(l, i) > 0 ? 1 : 0;
        return obj3;
    }

    public String getAndCacheLogSourceName() {
        Object remoteConfigValueOrDefault;
        int logSourceName;
        com.google.firebase.perf.config.RemoteConfigManager remoteConfigManager;
        com.google.firebase.perf.config.ConfigurationConstants.LogSourceName instance = ConfigurationConstants.LogSourceName.getInstance();
        if (BuildConfig.ENFORCE_DEFAULT_LOG_SRC.booleanValue()) {
            return instance.getDefault();
        }
        remoteConfigValueOrDefault = instance.getRemoteConfigFlag();
        if (remoteConfigValueOrDefault == null) {
        } else {
            logSourceName = (Long)this.remoteConfigManager.getRemoteConfigValueOrDefault(remoteConfigValueOrDefault, Long.valueOf(-1)).longValue();
        }
        logSourceName = ConfigurationConstants.LogSourceName.getLogSourceName(logSourceName);
        if (ConfigurationConstants.LogSourceName.isLogSourceKnown(logSourceName) && logSourceName != null) {
            logSourceName = ConfigurationConstants.LogSourceName.getLogSourceName(logSourceName);
            if (logSourceName != null) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), logSourceName);
                return logSourceName;
            }
        }
        Optional deviceCacheString = getDeviceCacheString(instance);
        if (deviceCacheString.isAvailable()) {
            return (String)deviceCacheString.get();
        }
        return instance.getDefault();
    }

    public Boolean getIsPerformanceCollectionDeactivated() {
        com.google.firebase.perf.config.ConfigurationConstants.CollectionDeactivated instance = ConfigurationConstants.CollectionDeactivated.getInstance();
        final Optional metadataBoolean = getMetadataBoolean(instance);
        if (metadataBoolean.isAvailable()) {
            return (Boolean)metadataBoolean.get();
        }
        return instance.getDefault();
    }

    public Boolean getIsPerformanceCollectionEnabled() {
        if (getIsPerformanceCollectionDeactivated().booleanValue()) {
            return Boolean.FALSE;
        }
        com.google.firebase.perf.config.ConfigurationConstants.CollectionEnabled instance = ConfigurationConstants.CollectionEnabled.getInstance();
        Optional deviceCacheBoolean = getDeviceCacheBoolean(instance);
        if (deviceCacheBoolean.isAvailable()) {
            return (Boolean)deviceCacheBoolean.get();
        }
        Optional metadataBoolean = getMetadataBoolean(instance);
        if (metadataBoolean.isAvailable()) {
            return (Boolean)metadataBoolean.get();
        }
        return null;
    }

    public boolean getIsServiceCollectionEnabled() {
        boolean isSdkVersionDisabled;
        int i;
        if (getIsSdkEnabled() && !getIsSdkVersionDisabled()) {
            i = !getIsSdkVersionDisabled() ? 1 : 0;
        } else {
        }
        return i;
    }

    public long getNetworkEventCountBackground() {
        boolean eventCountValid2;
        boolean eventCountValid;
        com.google.firebase.perf.config.ConfigurationConstants.NetworkEventCountBackground instance = ConfigurationConstants.NetworkEventCountBackground.getInstance();
        Optional remoteConfigLong = getRemoteConfigLong(instance);
        if (remoteConfigLong.isAvailable() && isEventCountValid((Long)remoteConfigLong.get().longValue())) {
            if (isEventCountValid((Long)remoteConfigLong.get().longValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Long)remoteConfigLong.get().longValue());
                return (Long)remoteConfigLong.get().longValue();
            }
        }
        Optional deviceCacheLong = getDeviceCacheLong(instance);
        if (deviceCacheLong.isAvailable() && isEventCountValid((Long)deviceCacheLong.get().longValue())) {
            if (isEventCountValid((Long)deviceCacheLong.get().longValue())) {
                return (Long)deviceCacheLong.get().longValue();
            }
        }
        return instance.getDefault().longValue();
    }

    public long getNetworkEventCountForeground() {
        boolean eventCountValid2;
        boolean eventCountValid;
        com.google.firebase.perf.config.ConfigurationConstants.NetworkEventCountForeground instance = ConfigurationConstants.NetworkEventCountForeground.getInstance();
        Optional remoteConfigLong = getRemoteConfigLong(instance);
        if (remoteConfigLong.isAvailable() && isEventCountValid((Long)remoteConfigLong.get().longValue())) {
            if (isEventCountValid((Long)remoteConfigLong.get().longValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Long)remoteConfigLong.get().longValue());
                return (Long)remoteConfigLong.get().longValue();
            }
        }
        Optional deviceCacheLong = getDeviceCacheLong(instance);
        if (deviceCacheLong.isAvailable() && isEventCountValid((Long)deviceCacheLong.get().longValue())) {
            if (isEventCountValid((Long)deviceCacheLong.get().longValue())) {
                return (Long)deviceCacheLong.get().longValue();
            }
        }
        return instance.getDefault().longValue();
    }

    public float getNetworkRequestSamplingRate() {
        boolean samplingRateValid2;
        boolean samplingRateValid;
        com.google.firebase.perf.config.ConfigurationConstants.NetworkRequestSamplingRate instance = ConfigurationConstants.NetworkRequestSamplingRate.getInstance();
        Optional remoteConfigFloat = getRemoteConfigFloat(instance);
        if (remoteConfigFloat.isAvailable() && isSamplingRateValid((Float)remoteConfigFloat.get().floatValue())) {
            if (isSamplingRateValid((Float)remoteConfigFloat.get().floatValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Float)remoteConfigFloat.get().floatValue());
                return (Float)remoteConfigFloat.get().floatValue();
            }
        }
        Optional deviceCacheFloat = getDeviceCacheFloat(instance);
        if (deviceCacheFloat.isAvailable() && isSamplingRateValid((Float)deviceCacheFloat.get().floatValue())) {
            if (isSamplingRateValid((Float)deviceCacheFloat.get().floatValue())) {
                return (Float)deviceCacheFloat.get().floatValue();
            }
        }
        return instance.getDefault().floatValue();
    }

    public long getRateLimitSec() {
        boolean timeRangeSecValid;
        boolean timeRangeSecValid2;
        com.google.firebase.perf.config.ConfigurationConstants.RateLimitSec instance = ConfigurationConstants.RateLimitSec.getInstance();
        Optional remoteConfigLong = getRemoteConfigLong(instance);
        if (remoteConfigLong.isAvailable() && isTimeRangeSecValid((Long)remoteConfigLong.get().longValue())) {
            if (isTimeRangeSecValid((Long)remoteConfigLong.get().longValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Long)remoteConfigLong.get().longValue());
                return (Long)remoteConfigLong.get().longValue();
            }
        }
        Optional deviceCacheLong = getDeviceCacheLong(instance);
        if (deviceCacheLong.isAvailable() && isTimeRangeSecValid((Long)deviceCacheLong.get().longValue())) {
            if (isTimeRangeSecValid((Long)deviceCacheLong.get().longValue())) {
                return (Long)deviceCacheLong.get().longValue();
            }
        }
        return instance.getDefault().longValue();
    }

    public long getSessionsCpuCaptureFrequencyBackgroundMs() {
        boolean gaugeCaptureFrequencyMsValid3;
        boolean gaugeCaptureFrequencyMsValid;
        boolean gaugeCaptureFrequencyMsValid2;
        com.google.firebase.perf.config.ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs instance = ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs.getInstance();
        Optional metadataLong = getMetadataLong(instance);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)metadataLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)metadataLong.get().longValue())) {
                return (Long)metadataLong.get().longValue();
            }
        }
        Optional remoteConfigLong = getRemoteConfigLong(instance);
        if (remoteConfigLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)remoteConfigLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)remoteConfigLong.get().longValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Long)remoteConfigLong.get().longValue());
                return (Long)remoteConfigLong.get().longValue();
            }
        }
        Optional deviceCacheLong = getDeviceCacheLong(instance);
        if (deviceCacheLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)deviceCacheLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)deviceCacheLong.get().longValue())) {
                return (Long)deviceCacheLong.get().longValue();
            }
        }
        return instance.getDefault().longValue();
    }

    public long getSessionsCpuCaptureFrequencyForegroundMs() {
        boolean gaugeCaptureFrequencyMsValid;
        boolean gaugeCaptureFrequencyMsValid2;
        boolean gaugeCaptureFrequencyMsValid3;
        com.google.firebase.perf.config.ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs instance = ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs.getInstance();
        Optional metadataLong = getMetadataLong(instance);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)metadataLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)metadataLong.get().longValue())) {
                return (Long)metadataLong.get().longValue();
            }
        }
        Optional remoteConfigLong = getRemoteConfigLong(instance);
        if (remoteConfigLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)remoteConfigLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)remoteConfigLong.get().longValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Long)remoteConfigLong.get().longValue());
                return (Long)remoteConfigLong.get().longValue();
            }
        }
        Optional deviceCacheLong = getDeviceCacheLong(instance);
        if (deviceCacheLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)deviceCacheLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)deviceCacheLong.get().longValue())) {
                return (Long)deviceCacheLong.get().longValue();
            }
        }
        return instance.getDefault().longValue();
    }

    public long getSessionsMaxDurationMinutes() {
        boolean sessionsMaxDurationMinutesValid3;
        boolean sessionsMaxDurationMinutesValid2;
        boolean sessionsMaxDurationMinutesValid;
        com.google.firebase.perf.config.ConfigurationConstants.SessionsMaxDurationMinutes instance = ConfigurationConstants.SessionsMaxDurationMinutes.getInstance();
        Optional metadataLong = getMetadataLong(instance);
        if (metadataLong.isAvailable() && isSessionsMaxDurationMinutesValid((Long)metadataLong.get().longValue())) {
            if (isSessionsMaxDurationMinutesValid((Long)metadataLong.get().longValue())) {
                return (Long)metadataLong.get().longValue();
            }
        }
        Optional remoteConfigLong = getRemoteConfigLong(instance);
        if (remoteConfigLong.isAvailable() && isSessionsMaxDurationMinutesValid((Long)remoteConfigLong.get().longValue())) {
            if (isSessionsMaxDurationMinutesValid((Long)remoteConfigLong.get().longValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Long)remoteConfigLong.get().longValue());
                return (Long)remoteConfigLong.get().longValue();
            }
        }
        Optional deviceCacheLong = getDeviceCacheLong(instance);
        if (deviceCacheLong.isAvailable() && isSessionsMaxDurationMinutesValid((Long)deviceCacheLong.get().longValue())) {
            if (isSessionsMaxDurationMinutesValid((Long)deviceCacheLong.get().longValue())) {
                return (Long)deviceCacheLong.get().longValue();
            }
        }
        return instance.getDefault().longValue();
    }

    public long getSessionsMemoryCaptureFrequencyBackgroundMs() {
        boolean gaugeCaptureFrequencyMsValid;
        boolean gaugeCaptureFrequencyMsValid3;
        boolean gaugeCaptureFrequencyMsValid2;
        com.google.firebase.perf.config.ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs instance = ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs.getInstance();
        Optional metadataLong = getMetadataLong(instance);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)metadataLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)metadataLong.get().longValue())) {
                return (Long)metadataLong.get().longValue();
            }
        }
        Optional remoteConfigLong = getRemoteConfigLong(instance);
        if (remoteConfigLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)remoteConfigLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)remoteConfigLong.get().longValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Long)remoteConfigLong.get().longValue());
                return (Long)remoteConfigLong.get().longValue();
            }
        }
        Optional deviceCacheLong = getDeviceCacheLong(instance);
        if (deviceCacheLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)deviceCacheLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)deviceCacheLong.get().longValue())) {
                return (Long)deviceCacheLong.get().longValue();
            }
        }
        return instance.getDefault().longValue();
    }

    public long getSessionsMemoryCaptureFrequencyForegroundMs() {
        boolean gaugeCaptureFrequencyMsValid2;
        boolean gaugeCaptureFrequencyMsValid3;
        boolean gaugeCaptureFrequencyMsValid;
        com.google.firebase.perf.config.ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs instance = ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs.getInstance();
        Optional metadataLong = getMetadataLong(instance);
        if (metadataLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)metadataLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)metadataLong.get().longValue())) {
                return (Long)metadataLong.get().longValue();
            }
        }
        Optional remoteConfigLong = getRemoteConfigLong(instance);
        if (remoteConfigLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)remoteConfigLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)remoteConfigLong.get().longValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Long)remoteConfigLong.get().longValue());
                return (Long)remoteConfigLong.get().longValue();
            }
        }
        Optional deviceCacheLong = getDeviceCacheLong(instance);
        if (deviceCacheLong.isAvailable() && isGaugeCaptureFrequencyMsValid((Long)deviceCacheLong.get().longValue())) {
            if (isGaugeCaptureFrequencyMsValid((Long)deviceCacheLong.get().longValue())) {
                return (Long)deviceCacheLong.get().longValue();
            }
        }
        return instance.getDefault().longValue();
    }

    public float getSessionsSamplingRate() {
        Optional metadataFloat;
        boolean samplingRateValid;
        boolean samplingRateValid2;
        boolean samplingRateValid3;
        com.google.firebase.perf.config.ConfigurationConstants.SessionsSamplingRate instance = ConfigurationConstants.SessionsSamplingRate.getInstance();
        metadataFloat = getMetadataFloat(instance);
        floatValue4 /= i;
        if (metadataFloat.isAvailable() && isSamplingRateValid(metadataFloat)) {
            floatValue4 /= i;
            if (isSamplingRateValid(metadataFloat)) {
                return metadataFloat;
            }
        }
        Optional remoteConfigFloat = getRemoteConfigFloat(instance);
        if (remoteConfigFloat.isAvailable() && isSamplingRateValid((Float)remoteConfigFloat.get().floatValue())) {
            if (isSamplingRateValid((Float)remoteConfigFloat.get().floatValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Float)remoteConfigFloat.get().floatValue());
                return (Float)remoteConfigFloat.get().floatValue();
            }
        }
        Optional deviceCacheFloat = getDeviceCacheFloat(instance);
        if (deviceCacheFloat.isAvailable() && isSamplingRateValid((Float)deviceCacheFloat.get().floatValue())) {
            if (isSamplingRateValid((Float)deviceCacheFloat.get().floatValue())) {
                return (Float)deviceCacheFloat.get().floatValue();
            }
        }
        return instance.getDefault().floatValue();
    }

    public long getTraceEventCountBackground() {
        boolean eventCountValid;
        boolean eventCountValid2;
        com.google.firebase.perf.config.ConfigurationConstants.TraceEventCountBackground instance = ConfigurationConstants.TraceEventCountBackground.getInstance();
        Optional remoteConfigLong = getRemoteConfigLong(instance);
        if (remoteConfigLong.isAvailable() && isEventCountValid((Long)remoteConfigLong.get().longValue())) {
            if (isEventCountValid((Long)remoteConfigLong.get().longValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Long)remoteConfigLong.get().longValue());
                return (Long)remoteConfigLong.get().longValue();
            }
        }
        Optional deviceCacheLong = getDeviceCacheLong(instance);
        if (deviceCacheLong.isAvailable() && isEventCountValid((Long)deviceCacheLong.get().longValue())) {
            if (isEventCountValid((Long)deviceCacheLong.get().longValue())) {
                return (Long)deviceCacheLong.get().longValue();
            }
        }
        return instance.getDefault().longValue();
    }

    public long getTraceEventCountForeground() {
        boolean eventCountValid;
        boolean eventCountValid2;
        com.google.firebase.perf.config.ConfigurationConstants.TraceEventCountForeground instance = ConfigurationConstants.TraceEventCountForeground.getInstance();
        Optional remoteConfigLong = getRemoteConfigLong(instance);
        if (remoteConfigLong.isAvailable() && isEventCountValid((Long)remoteConfigLong.get().longValue())) {
            if (isEventCountValid((Long)remoteConfigLong.get().longValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Long)remoteConfigLong.get().longValue());
                return (Long)remoteConfigLong.get().longValue();
            }
        }
        Optional deviceCacheLong = getDeviceCacheLong(instance);
        if (deviceCacheLong.isAvailable() && isEventCountValid((Long)deviceCacheLong.get().longValue())) {
            if (isEventCountValid((Long)deviceCacheLong.get().longValue())) {
                return (Long)deviceCacheLong.get().longValue();
            }
        }
        return instance.getDefault().longValue();
    }

    public float getTraceSamplingRate() {
        boolean samplingRateValid2;
        boolean samplingRateValid;
        com.google.firebase.perf.config.ConfigurationConstants.TraceSamplingRate instance = ConfigurationConstants.TraceSamplingRate.getInstance();
        Optional remoteConfigFloat = getRemoteConfigFloat(instance);
        if (remoteConfigFloat.isAvailable() && isSamplingRateValid((Float)remoteConfigFloat.get().floatValue())) {
            if (isSamplingRateValid((Float)remoteConfigFloat.get().floatValue())) {
                this.deviceCacheManager.setValue(instance.getDeviceCacheFlag(), (Float)remoteConfigFloat.get().floatValue());
                return (Float)remoteConfigFloat.get().floatValue();
            }
        }
        Optional deviceCacheFloat = getDeviceCacheFloat(instance);
        if (deviceCacheFloat.isAvailable() && isSamplingRateValid((Float)deviceCacheFloat.get().floatValue())) {
            if (isSamplingRateValid((Float)deviceCacheFloat.get().floatValue())) {
                return (Float)deviceCacheFloat.get().floatValue();
            }
        }
        return instance.getDefault().floatValue();
    }

    public boolean isPerformanceMonitoringEnabled() {
        boolean isPerformanceCollectionEnabled;
        int i;
        isPerformanceCollectionEnabled = getIsPerformanceCollectionEnabled();
        if (isPerformanceCollectionEnabled != null) {
            if (isPerformanceCollectionEnabled.booleanValue() == 1 && getIsServiceCollectionEnabled()) {
                if (getIsServiceCollectionEnabled()) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public void setApplicationContext(Context context) {
        ConfigResolver.logger.setLogcatEnabled(Utils.isDebugLoggingEnabled(context));
        this.deviceCacheManager.setContext(context);
    }

    public void setContentProviderContext(Context context) {
        setApplicationContext(context.getApplicationContext());
    }

    public void setDeviceCacheManager(com.google.firebase.perf.config.DeviceCacheManager deviceCacheManager) {
        this.deviceCacheManager = deviceCacheManager;
    }

    public void setIsPerformanceCollectionEnabled(Boolean boolean) {
        com.google.firebase.perf.config.DeviceCacheManager deviceCacheManager;
        Boolean tRUE;
        Object obj4;
        if (getIsPerformanceCollectionDeactivated().booleanValue()) {
        }
        String deviceCacheFlag = ConfigurationConstants.CollectionEnabled.getInstance().getDeviceCacheFlag();
        if (deviceCacheFlag != null) {
            if (boolean != null) {
                this.deviceCacheManager.setValue(deviceCacheFlag, Boolean.TRUE.equals(boolean));
            } else {
                this.deviceCacheManager.clear(deviceCacheFlag);
            }
        }
    }

    public void setMetadataBundle(ImmutableBundle immutableBundle) {
        this.metadataBundle = immutableBundle;
    }
}
