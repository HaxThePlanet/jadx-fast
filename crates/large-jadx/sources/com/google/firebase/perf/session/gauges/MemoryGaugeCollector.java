package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.AndroidMemoryReading;
import com.google.firebase.perf.v1.AndroidMemoryReading.Builder;
import com.google.protobuf.z.a;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class MemoryGaugeCollector {

    public static final long INVALID_MEMORY_COLLECTION_FREQUENCY = -1L;
    private static final int UNSET_MEMORY_METRIC_COLLECTION_RATE = -1;
    private static final com.google.firebase.perf.session.gauges.MemoryGaugeCollector instance;
    private static final AndroidLogger logger;
    private long memoryMetricCollectionRateMs;
    private final ScheduledExecutorService memoryMetricCollectorExecutor;
    private ScheduledFuture memoryMetricCollectorJob;
    public final ConcurrentLinkedQueue<AndroidMemoryReading> memoryMetricReadings;
    private final java.lang.Runtime runtime;
    static {
        MemoryGaugeCollector.logger = AndroidLogger.getInstance();
        MemoryGaugeCollector memoryGaugeCollector = new MemoryGaugeCollector();
        MemoryGaugeCollector.instance = memoryGaugeCollector;
    }

    private MemoryGaugeCollector() {
        super(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    MemoryGaugeCollector(ScheduledExecutorService scheduledExecutorService, java.lang.Runtime runtime2) {
        super();
        this.memoryMetricCollectorJob = 0;
        this.memoryMetricCollectionRateMs = -1;
        this.memoryMetricCollectorExecutor = scheduledExecutorService;
        ConcurrentLinkedQueue obj3 = new ConcurrentLinkedQueue();
        this.memoryMetricReadings = obj3;
        this.runtime = runtime2;
    }

    private void a(Timer timer) {
        ConcurrentLinkedQueue memoryMetricReadings;
        final AndroidMemoryReading obj2 = syncCollectMemoryMetric(timer);
        if (obj2 != null) {
            this.memoryMetricReadings.add(obj2);
        }
    }

    private void c(Timer timer) {
        ConcurrentLinkedQueue memoryMetricReadings;
        final AndroidMemoryReading obj2 = syncCollectMemoryMetric(timer);
        if (obj2 != null) {
            this.memoryMetricReadings.add(obj2);
        }
    }

    private int getCurrentUsedAppJavaHeapMemoryKb() {
        totalMemory -= freeMemory;
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(i));
    }

    public static com.google.firebase.perf.session.gauges.MemoryGaugeCollector getInstance() {
        return MemoryGaugeCollector.instance;
    }

    public static boolean isInvalidCollectionFrequency(long l) {
        int obj2;
        obj2 = Long.compare(l, i) <= 0 ? 1 : 0;
        return obj2;
    }

    private void scheduleMemoryMetricCollectionOnce(Timer timer) {
        ScheduledExecutorService memoryMetricCollectorExecutor;
        com.google.firebase.perf.session.gauges.f fVar;
        int i;
        TimeUnit obj5;
        fVar = new f(this, timer);
        this.memoryMetricCollectorExecutor.schedule(fVar, 0, obj3);
        synchronized (this) {
        }
    }

    private void scheduleMemoryMetricCollectionWithRate(long l, Timer timer2) {
        ScheduledExecutorService memoryMetricCollectorExecutor;
        ScheduledFuture obj8;
        AndroidLogger obj9;
        Timer obj10;
        this.memoryMetricCollectionRateMs = l;
        e eVar = new e(this, obj10);
        this.memoryMetricCollectorJob = this.memoryMetricCollectorExecutor.scheduleAtFixedRate(eVar, 0, obj3, l);
        synchronized (this) {
        }
    }

    private AndroidMemoryReading syncCollectMemoryMetric(Timer timer) {
        if (timer == null) {
            return null;
        }
        return (AndroidMemoryReading)AndroidMemoryReading.newBuilder().setClientTimeUs(timer.getCurrentTimestampMicros()).setUsedAppJavaHeapMemoryKb(getCurrentUsedAppJavaHeapMemoryKb()).build();
    }

    public void b(Timer timer) {
        a(timer);
    }

    public void collectOnce(Timer timer) {
        scheduleMemoryMetricCollectionOnce(timer);
    }

    public void d(Timer timer) {
        c(timer);
    }

    public void startCollecting(long l, Timer timer2) {
        if (MemoryGaugeCollector.isInvalidCollectionFrequency(l)) {
        }
        if (this.memoryMetricCollectorJob != null && Long.compare(memoryMetricCollectionRateMs, l) != 0) {
            if (Long.compare(memoryMetricCollectionRateMs, l) != 0) {
                stopCollecting();
                scheduleMemoryMetricCollectionWithRate(l, timer2);
            }
        }
        scheduleMemoryMetricCollectionWithRate(l, timer2);
    }

    public void stopCollecting() {
        ScheduledFuture memoryMetricCollectorJob = this.memoryMetricCollectorJob;
        if (memoryMetricCollectorJob == null) {
        }
        memoryMetricCollectorJob.cancel(false);
        this.memoryMetricCollectorJob = 0;
        this.memoryMetricCollectionRateMs = -1;
    }
}
