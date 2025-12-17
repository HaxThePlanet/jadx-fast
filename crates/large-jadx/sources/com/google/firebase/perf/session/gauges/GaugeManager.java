package com.google.firebase.perf.session.gauges;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetadata.Builder;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.GaugeMetric.Builder;
import com.google.protobuf.z.a;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class GaugeManager {

    private static final long APPROX_NUMBER_OF_DATA_POINTS_PER_GAUGE_METRIC = 20L;
    private static final long INVALID_GAUGE_COLLECTION_FREQUENCY = -1L;
    private static final long TIME_TO_WAIT_BEFORE_FLUSHING_GAUGES_QUEUE_MS = 20L;
    private static final com.google.firebase.perf.session.gauges.GaugeManager instance;
    private static final AndroidLogger logger;
    private ApplicationProcessState applicationProcessState;
    private final ConfigResolver configResolver;
    private final com.google.firebase.perf.session.gauges.CpuGaugeCollector cpuGaugeCollector;
    private ScheduledFuture gaugeManagerDataCollectionJob;
    private final ScheduledExecutorService gaugeManagerExecutor;
    private com.google.firebase.perf.session.gauges.GaugeMetadataManager gaugeMetadataManager;
    private final com.google.firebase.perf.session.gauges.MemoryGaugeCollector memoryGaugeCollector;
    private String sessionId;
    private final TransportManager transportManager;
    static {
        GaugeManager.logger = AndroidLogger.getInstance();
        GaugeManager gaugeManager = new GaugeManager();
        GaugeManager.instance = gaugeManager;
    }

    private GaugeManager() {
        super(Executors.newSingleThreadScheduledExecutor(), TransportManager.getInstance(), ConfigResolver.getInstance(), 0, CpuGaugeCollector.getInstance(), MemoryGaugeCollector.getInstance());
    }

    GaugeManager(ScheduledExecutorService scheduledExecutorService, TransportManager transportManager2, ConfigResolver configResolver3, com.google.firebase.perf.session.gauges.GaugeMetadataManager gaugeMetadataManager4, com.google.firebase.perf.session.gauges.CpuGaugeCollector cpuGaugeCollector5, com.google.firebase.perf.session.gauges.MemoryGaugeCollector memoryGaugeCollector6) {
        super();
        int i = 0;
        this.gaugeManagerDataCollectionJob = i;
        this.sessionId = i;
        this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.gaugeManagerExecutor = scheduledExecutorService;
        this.transportManager = transportManager2;
        this.configResolver = configResolver3;
        this.gaugeMetadataManager = gaugeMetadataManager4;
        this.cpuGaugeCollector = cpuGaugeCollector5;
        this.memoryGaugeCollector = memoryGaugeCollector6;
    }

    private void a(String string, ApplicationProcessState applicationProcessState2) {
        syncFlush(string, applicationProcessState2);
    }

    private void c(String string, ApplicationProcessState applicationProcessState2) {
        syncFlush(string, applicationProcessState2);
    }

    private static void collectGaugeMetricOnce(com.google.firebase.perf.session.gauges.CpuGaugeCollector cpuGaugeCollector, com.google.firebase.perf.session.gauges.MemoryGaugeCollector memoryGaugeCollector2, Timer timer3) {
        cpuGaugeCollector.collectOnce(timer3);
        memoryGaugeCollector2.collectOnce(timer3);
    }

    private long getCpuGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState) {
        int i;
        long sessionsCpuCaptureFrequencyForegroundMs;
        ConfigResolver obj6;
        obj6 = GaugeManager.1.$SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState[applicationProcessState.ordinal()];
        final int i2 = -1;
        if (obj6 != 1) {
            if (obj6 != 2) {
                sessionsCpuCaptureFrequencyForegroundMs = i2;
            } else {
                sessionsCpuCaptureFrequencyForegroundMs = this.configResolver.getSessionsCpuCaptureFrequencyForegroundMs();
            }
        } else {
            sessionsCpuCaptureFrequencyForegroundMs = this.configResolver.getSessionsCpuCaptureFrequencyBackgroundMs();
        }
        if (CpuGaugeCollector.isInvalidCollectionFrequency(sessionsCpuCaptureFrequencyForegroundMs)) {
            return i2;
        }
        return sessionsCpuCaptureFrequencyForegroundMs;
    }

    private GaugeMetadata getGaugeMetadata() {
        return (GaugeMetadata)GaugeMetadata.newBuilder().setProcessName(this.gaugeMetadataManager.getProcessName()).setDeviceRamSizeKb(this.gaugeMetadataManager.getDeviceRamSizeKb()).setMaxAppJavaHeapMemoryKb(this.gaugeMetadataManager.getMaxAppJavaHeapMemoryKb()).setMaxEncouragedAppJavaHeapMemoryKb(this.gaugeMetadataManager.getMaxEncouragedAppJavaHeapMemoryKb()).build();
    }

    public static com.google.firebase.perf.session.gauges.GaugeManager getInstance() {
        final Class<com.google.firebase.perf.session.gauges.GaugeManager> obj = GaugeManager.class;
        return GaugeManager.instance;
        synchronized (obj) {
            obj = GaugeManager.class;
            return GaugeManager.instance;
        }
    }

    private long getMemoryGaugeCollectionFrequencyMs(ApplicationProcessState applicationProcessState) {
        int i;
        long sessionsMemoryCaptureFrequencyForegroundMs;
        ConfigResolver obj6;
        obj6 = GaugeManager.1.$SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState[applicationProcessState.ordinal()];
        final int i2 = -1;
        if (obj6 != 1) {
            if (obj6 != 2) {
                sessionsMemoryCaptureFrequencyForegroundMs = i2;
            } else {
                sessionsMemoryCaptureFrequencyForegroundMs = this.configResolver.getSessionsMemoryCaptureFrequencyForegroundMs();
            }
        } else {
            sessionsMemoryCaptureFrequencyForegroundMs = this.configResolver.getSessionsMemoryCaptureFrequencyBackgroundMs();
        }
        if (MemoryGaugeCollector.isInvalidCollectionFrequency(sessionsMemoryCaptureFrequencyForegroundMs)) {
            return i2;
        }
        return sessionsMemoryCaptureFrequencyForegroundMs;
    }

    private boolean startCollectingCpuMetrics(long l, Timer timer2) {
        if (Long.compare(l, i) == 0) {
            GaugeManager.logger.debug("Invalid Cpu Metrics collection frequency. Did not collect Cpu Metrics.");
            return 0;
        }
        this.cpuGaugeCollector.startCollecting(l, timer2);
        return 1;
    }

    private long startCollectingGauges(ApplicationProcessState applicationProcessState, Timer timer2) {
        int cpuGaugeCollectionFrequencyMs;
        boolean obj8;
        final int i = -1;
        if (startCollectingCpuMetrics(getCpuGaugeCollectionFrequencyMs(applicationProcessState), obj1)) {
        } else {
            cpuGaugeCollectionFrequencyMs = i;
        }
        final long memoryGaugeCollectionFrequencyMs = getMemoryGaugeCollectionFrequencyMs(applicationProcessState);
        if (startCollectingMemoryMetrics(memoryGaugeCollectionFrequencyMs, obj6)) {
            if (Long.compare(cpuGaugeCollectionFrequencyMs, i) == 0) {
                cpuGaugeCollectionFrequencyMs = memoryGaugeCollectionFrequencyMs;
            } else {
                cpuGaugeCollectionFrequencyMs = obj8;
            }
        }
        return cpuGaugeCollectionFrequencyMs;
    }

    private boolean startCollectingMemoryMetrics(long l, Timer timer2) {
        if (Long.compare(l, i) == 0) {
            GaugeManager.logger.debug("Invalid Memory Metrics collection frequency. Did not collect Memory Metrics.");
            return 0;
        }
        this.memoryGaugeCollector.startCollecting(l, timer2);
        return 1;
    }

    private void syncFlush(String string, ApplicationProcessState applicationProcessState2) {
        Object poll;
        boolean empty;
        GaugeMetric.Builder builder = GaugeMetric.newBuilder();
        while (!cpuGaugeCollector.cpuMetricReadings.isEmpty()) {
            builder.addCpuMetricReadings((CpuMetricReading)cpuGaugeCollector2.cpuMetricReadings.poll());
        }
        while (!memoryGaugeCollector.memoryMetricReadings.isEmpty()) {
            builder.addAndroidMemoryReadings((AndroidMemoryReading)memoryGaugeCollector2.memoryMetricReadings.poll());
        }
        builder.setSessionId(string);
        this.transportManager.log((GaugeMetric)builder.build(), applicationProcessState2);
    }

    public void b(String string, ApplicationProcessState applicationProcessState2) {
        a(string, applicationProcessState2);
    }

    public void collectGaugeMetricOnce(Timer timer) {
        GaugeManager.collectGaugeMetricOnce(this.cpuGaugeCollector, this.memoryGaugeCollector, timer);
    }

    public void d(String string, ApplicationProcessState applicationProcessState2) {
        c(string, applicationProcessState2);
    }

    public boolean logGaugeMetadata(String string, ApplicationProcessState applicationProcessState2) {
        if (this.gaugeMetadataManager != null) {
            this.transportManager.log((GaugeMetric)GaugeMetric.newBuilder().setSessionId(string).setGaugeMetadata(getGaugeMetadata()).build(), applicationProcessState2);
            return 1;
        }
        return 0;
    }

    public void setApplicationContext(Context context) {
        GaugeMetadataManager gaugeMetadataManager = new GaugeMetadataManager(context);
        this.gaugeMetadataManager = gaugeMetadataManager;
    }

    public void startCollectingGauges(PerfSession perfSession, ApplicationProcessState applicationProcessState2) {
        long collectingGauges;
        String str;
        ScheduledFuture obj10;
        ApplicationProcessState obj11;
        if (this.sessionId != null) {
            stopCollectingGauges();
        }
        collectingGauges = startCollectingGauges(applicationProcessState2, perfSession.getTimer());
        if (Long.compare(collectingGauges, i) == 0) {
            GaugeManager.logger.warn("Invalid gauge collection frequency. Unable to start collecting Gauges.");
        }
        obj10 = perfSession.sessionId();
        this.sessionId = obj10;
        this.applicationProcessState = applicationProcessState2;
        c cVar = new c(this, obj10, applicationProcessState2);
        final int i3 = collectingGauges * obj10;
        this.gaugeManagerDataCollectionJob = this.gaugeManagerExecutor.scheduleAtFixedRate(cVar, i3, obj5, i3);
    }

    public void stopCollectingGauges() {
        int i;
        String sessionId = this.sessionId;
        if (sessionId == null) {
        }
        final ApplicationProcessState applicationProcessState = this.applicationProcessState;
        this.cpuGaugeCollector.stopCollecting();
        this.memoryGaugeCollector.stopCollecting();
        ScheduledFuture gaugeManagerDataCollectionJob = this.gaugeManagerDataCollectionJob;
        if (gaugeManagerDataCollectionJob != null) {
            gaugeManagerDataCollectionJob.cancel(false);
        }
        d dVar = new d(this, sessionId, applicationProcessState);
        this.gaugeManagerExecutor.schedule(dVar, 20, applicationProcessState);
        this.sessionId = 0;
        this.applicationProcessState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
    }
}
