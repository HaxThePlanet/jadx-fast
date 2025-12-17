package com.google.firebase.perf.config;

import com.google.firebase.perf.BuildConfig;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
final class ConfigurationConstants {

    protected static final class CollectionDeactivated extends com.google.firebase.perf.config.ConfigurationFlag<Boolean> {

        private static com.google.firebase.perf.config.ConfigurationConstants.CollectionDeactivated instance;
        protected static com.google.firebase.perf.config.ConfigurationConstants.CollectionDeactivated getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.CollectionDeactivated collectionDeactivated;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.CollectionDeactivated> obj = ConfigurationConstants.CollectionDeactivated.class;
            synchronized (obj) {
                collectionDeactivated = new ConfigurationConstants.CollectionDeactivated();
                ConfigurationConstants.CollectionDeactivated.instance = collectionDeactivated;
                return ConfigurationConstants.CollectionDeactivated.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Boolean getDefault() {
            return Boolean.FALSE;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "firebase_performance_collection_deactivated";
        }
    }

    protected static final class CollectionEnabled extends com.google.firebase.perf.config.ConfigurationFlag<Boolean> {

        private static com.google.firebase.perf.config.ConfigurationConstants.CollectionEnabled instance;
        protected static com.google.firebase.perf.config.ConfigurationConstants.CollectionEnabled getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.CollectionEnabled collectionEnabled;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.CollectionEnabled> obj = ConfigurationConstants.CollectionEnabled.class;
            synchronized (obj) {
                collectionEnabled = new ConfigurationConstants.CollectionEnabled();
                ConfigurationConstants.CollectionEnabled.instance = collectionEnabled;
                return ConfigurationConstants.CollectionEnabled.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Boolean getDefault() {
            return Boolean.TRUE;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "isEnabled";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "firebase_performance_collection_enabled";
        }
    }

    protected static final class LogSourceName extends com.google.firebase.perf.config.ConfigurationFlag<String> {

        private static final Map<Long, String> LOG_SOURCE_MAP;
        private static com.google.firebase.perf.config.ConfigurationConstants.LogSourceName instance;
        static {
            ConfigurationConstants.LogSourceName.1 anon = new ConfigurationConstants.LogSourceName.1();
            ConfigurationConstants.LogSourceName.LOG_SOURCE_MAP = Collections.unmodifiableMap(anon);
        }

        public static com.google.firebase.perf.config.ConfigurationConstants.LogSourceName getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.LogSourceName logSourceName;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.LogSourceName> obj = ConfigurationConstants.LogSourceName.class;
            synchronized (obj) {
                logSourceName = new ConfigurationConstants.LogSourceName();
                ConfigurationConstants.LogSourceName.instance = logSourceName;
                return ConfigurationConstants.LogSourceName.instance;
            }
        }

        protected static String getLogSourceName(long l) {
            return (String)ConfigurationConstants.LogSourceName.LOG_SOURCE_MAP.get(Long.valueOf(l));
        }

        protected static boolean isLogSourceKnown(long l) {
            return ConfigurationConstants.LogSourceName.LOG_SOURCE_MAP.containsKey(Long.valueOf(l));
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDefault() {
            return BuildConfig.TRANSPORT_LOG_SRC;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.LogSourceName";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_log_source";
        }
    }

    protected static final class NetworkEventCountBackground extends com.google.firebase.perf.config.ConfigurationFlag<Long> {

        private static com.google.firebase.perf.config.ConfigurationConstants.NetworkEventCountBackground instance;
        public static com.google.firebase.perf.config.ConfigurationConstants.NetworkEventCountBackground getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.NetworkEventCountBackground networkEventCountBackground;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.NetworkEventCountBackground> obj = ConfigurationConstants.NetworkEventCountBackground.class;
            synchronized (obj) {
                networkEventCountBackground = new ConfigurationConstants.NetworkEventCountBackground();
                ConfigurationConstants.NetworkEventCountBackground.instance = networkEventCountBackground;
                return ConfigurationConstants.NetworkEventCountBackground.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Long getDefault() {
            return Long.valueOf(70);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountBackground";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_bg";
        }
    }

    protected static final class NetworkEventCountForeground extends com.google.firebase.perf.config.ConfigurationFlag<Long> {

        private static com.google.firebase.perf.config.ConfigurationConstants.NetworkEventCountForeground instance;
        public static com.google.firebase.perf.config.ConfigurationConstants.NetworkEventCountForeground getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.NetworkEventCountForeground networkEventCountForeground;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.NetworkEventCountForeground> obj = ConfigurationConstants.NetworkEventCountForeground.class;
            synchronized (obj) {
                networkEventCountForeground = new ConfigurationConstants.NetworkEventCountForeground();
                ConfigurationConstants.NetworkEventCountForeground.instance = networkEventCountForeground;
                return ConfigurationConstants.NetworkEventCountForeground.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Long getDefault() {
            return Long.valueOf(700);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountForeground";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_fg";
        }
    }

    protected static final class NetworkRequestSamplingRate extends com.google.firebase.perf.config.ConfigurationFlag<Float> {

        private static com.google.firebase.perf.config.ConfigurationConstants.NetworkRequestSamplingRate instance;
        protected static com.google.firebase.perf.config.ConfigurationConstants.NetworkRequestSamplingRate getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.NetworkRequestSamplingRate networkRequestSamplingRate;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.NetworkRequestSamplingRate> obj = ConfigurationConstants.NetworkRequestSamplingRate.class;
            synchronized (obj) {
                networkRequestSamplingRate = new ConfigurationConstants.NetworkRequestSamplingRate();
                ConfigurationConstants.NetworkRequestSamplingRate.instance = networkRequestSamplingRate;
                return ConfigurationConstants.NetworkRequestSamplingRate.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Float getDefault() {
            return 1f;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkRequestSamplingRate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_network_request_sampling_rate";
        }
    }

    protected static final class RateLimitSec extends com.google.firebase.perf.config.ConfigurationFlag<Long> {

        private static com.google.firebase.perf.config.ConfigurationConstants.RateLimitSec instance;
        public static com.google.firebase.perf.config.ConfigurationConstants.RateLimitSec getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.RateLimitSec rateLimitSec;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.RateLimitSec> obj = ConfigurationConstants.RateLimitSec.class;
            synchronized (obj) {
                rateLimitSec = new ConfigurationConstants.RateLimitSec();
                ConfigurationConstants.RateLimitSec.instance = rateLimitSec;
                return ConfigurationConstants.RateLimitSec.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Long getDefault() {
            return Long.valueOf(600);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TimeLimitSec";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_time_limit_sec";
        }
    }

    protected static final class SdkDisabledVersions extends com.google.firebase.perf.config.ConfigurationFlag<String> {

        private static com.google.firebase.perf.config.ConfigurationConstants.SdkDisabledVersions instance;
        protected static com.google.firebase.perf.config.ConfigurationConstants.SdkDisabledVersions getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.SdkDisabledVersions sdkDisabledVersions;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.SdkDisabledVersions> obj = ConfigurationConstants.SdkDisabledVersions.class;
            synchronized (obj) {
                sdkDisabledVersions = new ConfigurationConstants.SdkDisabledVersions();
                ConfigurationConstants.SdkDisabledVersions.instance = sdkDisabledVersions;
                return ConfigurationConstants.SdkDisabledVersions.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDefault() {
            return "";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkDisabledVersions";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_disabled_android_versions";
        }
    }

    protected static final class SdkEnabled extends com.google.firebase.perf.config.ConfigurationFlag<Boolean> {

        private static com.google.firebase.perf.config.ConfigurationConstants.SdkEnabled instance;
        protected static com.google.firebase.perf.config.ConfigurationConstants.SdkEnabled getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.SdkEnabled sdkEnabled;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.SdkEnabled> obj = ConfigurationConstants.SdkEnabled.class;
            synchronized (obj) {
                sdkEnabled = new ConfigurationConstants.SdkEnabled();
                ConfigurationConstants.SdkEnabled.instance = sdkEnabled;
                return ConfigurationConstants.SdkEnabled.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Boolean getDefault() {
            return Boolean.TRUE;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkEnabled";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_enabled";
        }
    }

    protected static final class SessionsCpuCaptureFrequencyBackgroundMs extends com.google.firebase.perf.config.ConfigurationFlag<Long> {

        private static com.google.firebase.perf.config.ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs instance;
        public static com.google.firebase.perf.config.ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs sessionsCpuCaptureFrequencyBackgroundMs;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs> obj = ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs.class;
            synchronized (obj) {
                sessionsCpuCaptureFrequencyBackgroundMs = new ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs();
                ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs.instance = sessionsCpuCaptureFrequencyBackgroundMs;
                return ConfigurationConstants.SessionsCpuCaptureFrequencyBackgroundMs.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Long getDefault() {
            return Long.valueOf(0);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
        }
    }

    protected static final class SessionsCpuCaptureFrequencyForegroundMs extends com.google.firebase.perf.config.ConfigurationFlag<Long> {

        private static com.google.firebase.perf.config.ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs instance;
        public static com.google.firebase.perf.config.ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs sessionsCpuCaptureFrequencyForegroundMs;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs> obj = ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs.class;
            synchronized (obj) {
                sessionsCpuCaptureFrequencyForegroundMs = new ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs();
                ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs.instance = sessionsCpuCaptureFrequencyForegroundMs;
                return ConfigurationConstants.SessionsCpuCaptureFrequencyForegroundMs.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Long getDefault() {
            return Long.valueOf(100);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
        }
    }

    protected static final class SessionsMaxDurationMinutes extends com.google.firebase.perf.config.ConfigurationFlag<Long> {

        private static com.google.firebase.perf.config.ConfigurationConstants.SessionsMaxDurationMinutes instance;
        public static com.google.firebase.perf.config.ConfigurationConstants.SessionsMaxDurationMinutes getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.SessionsMaxDurationMinutes sessionsMaxDurationMinutes;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.SessionsMaxDurationMinutes> obj = ConfigurationConstants.SessionsMaxDurationMinutes.class;
            synchronized (obj) {
                sessionsMaxDurationMinutes = new ConfigurationConstants.SessionsMaxDurationMinutes();
                ConfigurationConstants.SessionsMaxDurationMinutes.instance = sessionsMaxDurationMinutes;
                return ConfigurationConstants.SessionsMaxDurationMinutes.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Long getDefault() {
            return Long.valueOf(240);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMaxDurationMinutes";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_max_length_minutes";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_max_duration_min";
        }
    }

    protected static final class SessionsMemoryCaptureFrequencyBackgroundMs extends com.google.firebase.perf.config.ConfigurationFlag<Long> {

        private static com.google.firebase.perf.config.ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs instance;
        public static com.google.firebase.perf.config.ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs sessionsMemoryCaptureFrequencyBackgroundMs;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs> obj = ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs.class;
            synchronized (obj) {
                sessionsMemoryCaptureFrequencyBackgroundMs = new ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs();
                ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs.instance = sessionsMemoryCaptureFrequencyBackgroundMs;
                return ConfigurationConstants.SessionsMemoryCaptureFrequencyBackgroundMs.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Long getDefault() {
            return Long.valueOf(0);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_memory_capture_frequency_bg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_bg_ms";
        }
    }

    protected static final class SessionsMemoryCaptureFrequencyForegroundMs extends com.google.firebase.perf.config.ConfigurationFlag<Long> {

        private static com.google.firebase.perf.config.ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs instance;
        public static com.google.firebase.perf.config.ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs sessionsMemoryCaptureFrequencyForegroundMs;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs> obj = ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs.class;
            synchronized (obj) {
                sessionsMemoryCaptureFrequencyForegroundMs = new ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs();
                ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs.instance = sessionsMemoryCaptureFrequencyForegroundMs;
                return ConfigurationConstants.SessionsMemoryCaptureFrequencyForegroundMs.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Long getDefault() {
            return Long.valueOf(100);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_memory_capture_frequency_fg_ms";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_fg_ms";
        }
    }

    protected static final class SessionsSamplingRate extends com.google.firebase.perf.config.ConfigurationFlag<Float> {

        private static com.google.firebase.perf.config.ConfigurationConstants.SessionsSamplingRate instance;
        public static com.google.firebase.perf.config.ConfigurationConstants.SessionsSamplingRate getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.SessionsSamplingRate sessionsSamplingRate;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.SessionsSamplingRate> obj = ConfigurationConstants.SessionsSamplingRate.class;
            synchronized (obj) {
                sessionsSamplingRate = new ConfigurationConstants.SessionsSamplingRate();
                ConfigurationConstants.SessionsSamplingRate.instance = sessionsSamplingRate;
                return ConfigurationConstants.SessionsSamplingRate.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Float getDefault() {
            return 0.01f;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionSamplingRate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getMetadataFlag() {
            return "sessions_sampling_percentage";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_session_sampling_rate";
        }
    }

    protected static final class TraceEventCountBackground extends com.google.firebase.perf.config.ConfigurationFlag<Long> {

        private static com.google.firebase.perf.config.ConfigurationConstants.TraceEventCountBackground instance;
        public static com.google.firebase.perf.config.ConfigurationConstants.TraceEventCountBackground getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.TraceEventCountBackground traceEventCountBackground;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.TraceEventCountBackground> obj = ConfigurationConstants.TraceEventCountBackground.class;
            synchronized (obj) {
                traceEventCountBackground = new ConfigurationConstants.TraceEventCountBackground();
                ConfigurationConstants.TraceEventCountBackground.instance = traceEventCountBackground;
                return ConfigurationConstants.TraceEventCountBackground.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Long getDefault() {
            return Long.valueOf(30);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountBackground";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_bg";
        }
    }

    protected static final class TraceEventCountForeground extends com.google.firebase.perf.config.ConfigurationFlag<Long> {

        private static com.google.firebase.perf.config.ConfigurationConstants.TraceEventCountForeground instance;
        public static com.google.firebase.perf.config.ConfigurationConstants.TraceEventCountForeground getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.TraceEventCountForeground traceEventCountForeground;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.TraceEventCountForeground> obj = ConfigurationConstants.TraceEventCountForeground.class;
            synchronized (obj) {
                traceEventCountForeground = new ConfigurationConstants.TraceEventCountForeground();
                ConfigurationConstants.TraceEventCountForeground.instance = traceEventCountForeground;
                return ConfigurationConstants.TraceEventCountForeground.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Long getDefault() {
            return Long.valueOf(300);
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountForeground";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_fg";
        }
    }

    protected static final class TraceSamplingRate extends com.google.firebase.perf.config.ConfigurationFlag<Float> {

        private static com.google.firebase.perf.config.ConfigurationConstants.TraceSamplingRate instance;
        protected static com.google.firebase.perf.config.ConfigurationConstants.TraceSamplingRate getInstance() {
            com.google.firebase.perf.config.ConfigurationConstants.TraceSamplingRate traceSamplingRate;
            final Class<com.google.firebase.perf.config.ConfigurationConstants.TraceSamplingRate> obj = ConfigurationConstants.TraceSamplingRate.class;
            synchronized (obj) {
                traceSamplingRate = new ConfigurationConstants.TraceSamplingRate();
                ConfigurationConstants.TraceSamplingRate.instance = traceSamplingRate;
                return ConfigurationConstants.TraceSamplingRate.instance;
            }
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Float getDefault() {
            return 1f;
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected Object getDefault() {
            return getDefault();
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceSamplingRate";
        }

        @Override // com.google.firebase.perf.config.ConfigurationFlag
        protected String getRemoteConfigFlag() {
            return "fpr_vc_trace_sampling_rate";
        }
    }
}
