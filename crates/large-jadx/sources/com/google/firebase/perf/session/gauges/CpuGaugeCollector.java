package com.google.firebase.perf.session.gauges;

import android.os.Build.VERSION;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.CpuMetricReading;
import com.google.firebase.perf.v1.CpuMetricReading.Builder;
import com.google.protobuf.z.a;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class CpuGaugeCollector {

    private static final int CSTIME_POSITION_IN_PROC_PID_STAT = 16;
    private static final int CUTIME_POSITION_IN_PROC_PID_STAT = 15;
    public static final long INVALID_CPU_COLLECTION_FREQUENCY = -1L;
    private static final int INVALID_SC_PER_CPU_CLOCK_TICK = -1;
    private static final long MICROSECONDS_PER_SECOND = 0L;
    private static final int STIME_POSITION_IN_PROC_PID_STAT = 14;
    private static final int UNSET_CPU_METRIC_COLLECTION_RATE = -1;
    private static final int UTIME_POSITION_IN_PROC_PID_STAT = 13;
    private static com.google.firebase.perf.session.gauges.CpuGaugeCollector instance;
    private static final AndroidLogger logger;
    private final long clockTicksPerSecond;
    private long cpuMetricCollectionRateMs = -1;
    private final ScheduledExecutorService cpuMetricCollectorExecutor;
    private ScheduledFuture cpuMetricCollectorJob = null;
    public final ConcurrentLinkedQueue<CpuMetricReading> cpuMetricReadings;
    private final String procFileName;
    static {
        CpuGaugeCollector.logger = AndroidLogger.getInstance();
        CpuGaugeCollector.MICROSECONDS_PER_SECOND = TimeUnit.SECONDS.toMicros(1);
        CpuGaugeCollector.instance = 0;
    }

    private CpuGaugeCollector() {
        super();
        int i = 0;
        int i2 = -1;
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.cpuMetricReadings = concurrentLinkedQueue;
        this.cpuMetricCollectorExecutor = Executors.newSingleThreadScheduledExecutor();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/proc/");
        stringBuilder.append(Integer.toString(Process.myPid()));
        stringBuilder.append("/stat");
        this.procFileName = stringBuilder.toString();
        this.clockTicksPerSecond = getClockTicksPerSecond();
    }

    CpuGaugeCollector(ScheduledExecutorService scheduledExecutorService, String string2, long l3) {
        super();
        int i = 0;
        int i2 = -1;
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.cpuMetricReadings = concurrentLinkedQueue;
        this.cpuMetricCollectorExecutor = scheduledExecutorService;
        this.procFileName = string2;
        this.clockTicksPerSecond = l3;
    }

    private void a(Timer timer) {
        ConcurrentLinkedQueue cpuMetricReadings;
        final CpuMetricReading obj2 = syncCollectCpuMetric(timer);
        if (obj2 != null) {
            this.cpuMetricReadings.add(obj2);
        }
    }

    private void c(Timer timer) {
        ConcurrentLinkedQueue cpuMetricReadings;
        final CpuMetricReading obj2 = syncCollectCpuMetric(timer);
        if (obj2 != null) {
            this.cpuMetricReadings.add(obj2);
        }
    }

    private long convertClockTicksToMicroseconds(long l) {
        return Math.round(obj3 *= d2);
    }

    private long getClockTicksPerSecond() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Os.sysconf(OsConstants._SC_CLK_TCK);
        }
        return -1;
    }

    public static com.google.firebase.perf.session.gauges.CpuGaugeCollector getInstance() {
        com.google.firebase.perf.session.gauges.CpuGaugeCollector cpuGaugeCollector;
        if (CpuGaugeCollector.instance == null) {
            cpuGaugeCollector = new CpuGaugeCollector();
            CpuGaugeCollector.instance = cpuGaugeCollector;
        }
        return CpuGaugeCollector.instance;
    }

    public static boolean isInvalidCollectionFrequency(long l) {
        int obj2;
        obj2 = Long.compare(l, i) <= 0 ? 1 : 0;
        return obj2;
    }

    private void scheduleCpuMetricCollectionOnce(Timer timer) {
        ScheduledExecutorService cpuMetricCollectorExecutor;
        com.google.firebase.perf.session.gauges.a aVar;
        int i;
        TimeUnit obj5;
        aVar = new a(this, timer);
        this.cpuMetricCollectorExecutor.schedule(aVar, 0, obj3);
        synchronized (this) {
        }
    }

    private void scheduleCpuMetricCollectionWithRate(long l, Timer timer2) {
        ScheduledExecutorService cpuMetricCollectorExecutor;
        ScheduledFuture obj8;
        AndroidLogger obj9;
        Timer obj10;
        this.cpuMetricCollectionRateMs = l;
        b bVar = new b(this, obj10);
        this.cpuMetricCollectorJob = this.cpuMetricCollectorExecutor.scheduleAtFixedRate(bVar, 0, obj3, l);
        synchronized (this) {
        }
    }

    private CpuMetricReading syncCollectCpuMetric(Timer timer) {
        Throwable logger;
        StringBuilder stringBuilder;
        String str;
        if (timer == null) {
            return null;
        }
        final String procFileName = this.procFileName;
        FileReader fileReader = new FileReader(procFileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] obj13 = bufferedReader.readLine().split(" ");
        bufferedReader.close();
        return (CpuMetricReading)CpuMetricReading.newBuilder().setClientTimeUs(timer.getCurrentTimestampMicros()).setSystemTimeUs(convertClockTicksToMicroseconds(long3 += long4)).setUserTimeUs(convertClockTicksToMicroseconds(long += long2)).build();
    }

    public void b(Timer timer) {
        a(timer);
    }

    public void collectOnce(Timer timer) {
        scheduleCpuMetricCollectionOnce(timer);
    }

    public void d(Timer timer) {
        c(timer);
    }

    public void startCollecting(long l, Timer timer2) {
        long cpuMetricCollectorJob;
        int cmp;
        cpuMetricCollectorJob = this.clockTicksPerSecond;
        if (Long.compare(cpuMetricCollectorJob, i) != 0) {
            if (Long.compare(cpuMetricCollectorJob, cmp) == 0) {
            } else {
                if (CpuGaugeCollector.isInvalidCollectionFrequency(l)) {
                }
                if (this.cpuMetricCollectorJob != null && Long.compare(cpuMetricCollectionRateMs, l) != 0) {
                    if (Long.compare(cpuMetricCollectionRateMs, l) != 0) {
                        stopCollecting();
                        scheduleCpuMetricCollectionWithRate(l, timer2);
                    }
                }
                scheduleCpuMetricCollectionWithRate(l, timer2);
            }
        }
    }

    public void stopCollecting() {
        ScheduledFuture cpuMetricCollectorJob = this.cpuMetricCollectorJob;
        if (cpuMetricCollectorJob == null) {
        }
        cpuMetricCollectorJob.cancel(false);
        this.cpuMetricCollectorJob = 0;
        this.cpuMetricCollectionRateMs = -1;
    }
}
