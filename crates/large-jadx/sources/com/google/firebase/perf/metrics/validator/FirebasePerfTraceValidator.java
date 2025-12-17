package com.google.firebase.perf.metrics.validator;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Constants.CounterNames;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class FirebasePerfTraceValidator extends com.google.firebase.perf.metrics.validator.PerfMetricValidator {

    private static final AndroidLogger logger;
    private final TraceMetric traceMetric;
    static {
        FirebasePerfTraceValidator.logger = AndroidLogger.getInstance();
    }

    FirebasePerfTraceValidator(TraceMetric traceMetric) {
        super();
        this.traceMetric = traceMetric;
    }

    private boolean areCountersValid(TraceMetric traceMetric) {
        return areCountersValid(traceMetric, 0);
    }

    private boolean areCountersValid(TraceMetric traceMetric, int i2) {
        Iterator countersValid;
        Object next;
        boolean next2;
        boolean validCounterValue;
        final int i = 0;
        if (traceMetric == null) {
            return i;
        }
        int i3 = 1;
        if (i2 > i3) {
            FirebasePerfTraceValidator.logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return i;
        }
        countersValid = traceMetric.getCountersMap().entrySet().iterator();
        for (Map.Entry next : countersValid) {
        }
        Iterator obj6 = traceMetric.getSubtracesList().iterator();
        for (TraceMetric next4 : obj6) {
        }
        return i3;
    }

    private boolean hasCounters(TraceMetric traceMetric) {
        int i;
        final int i2 = 0;
        final int i3 = 1;
        i = traceMetric.getCountersCount() > 0 ? i3 : i2;
        if (i != 0) {
            return i3;
        }
        Iterator obj4 = traceMetric.getSubtracesList().iterator();
        while (obj4.hasNext()) {
            if ((TraceMetric)obj4.next().getCountersCount() > 0) {
            } else {
            }
            i = i2;
            i = i3;
        }
        return i2;
    }

    private boolean hasValidAttributes(Map<String, String> map) {
        String validateAttribute;
        Iterator obj2 = map.entrySet().iterator();
        for (Map.Entry next2 : obj2) {
            validateAttribute = PerfMetricValidator.validateAttribute(next2);
        }
        return 1;
    }

    private boolean isScreenTrace(TraceMetric traceMetric) {
        return traceMetric.getName().startsWith("_st_");
    }

    private boolean isValidCounterId(String string) {
        final int i = 0;
        if (string == null) {
            return i;
        }
        String obj3 = string.trim();
        if (obj3.isEmpty()) {
            FirebasePerfTraceValidator.logger.warn("counterId is empty");
            return i;
        }
        if (obj3.length() > 100) {
            FirebasePerfTraceValidator.logger.warn("counterId exceeded max length 100");
            return i;
        }
        return 1;
    }

    private boolean isValidCounterValue(Long long) {
        int obj1;
        obj1 = long != null ? 1 : 0;
        return obj1;
    }

    private boolean isValidScreenTrace(TraceMetric traceMetric) {
        Object valueOf;
        Object obj3;
        obj3 = traceMetric.getCountersMap().get(Constants.CounterNames.FRAMES_TOTAL.toString());
        if (obj3 != null && (Long)obj3.compareTo(Long.valueOf(0)) > 0) {
            obj3 = obj3.compareTo(Long.valueOf(0)) > 0 ? 1 : 0;
        } else {
        }
        return obj3;
    }

    private boolean isValidTrace(TraceMetric traceMetric, int i2) {
        boolean validScreenTrace;
        boolean validTrace;
        int i;
        final int i3 = 0;
        if (traceMetric == null) {
            FirebasePerfTraceValidator.logger.warn("TraceMetric is null");
            return i3;
        }
        int i4 = 1;
        if (i2 > i4) {
            FirebasePerfTraceValidator.logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return i3;
        }
        if (!isValidTraceId(traceMetric.getName())) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("invalid TraceId:");
            stringBuilder3.append(traceMetric.getName());
            FirebasePerfTraceValidator.logger.warn(stringBuilder3.toString());
            return i3;
        }
        if (!isValidTraceDuration(traceMetric)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid TraceDuration:");
            stringBuilder.append(traceMetric.getDurationUs());
            FirebasePerfTraceValidator.logger.warn(stringBuilder.toString());
            return i3;
        }
        if (!traceMetric.hasClientStartTimeUs()) {
            FirebasePerfTraceValidator.logger.warn("clientStartTimeUs is null.");
            return i3;
        }
        if (isScreenTrace(traceMetric) && !isValidScreenTrace(traceMetric)) {
            if (!isValidScreenTrace(traceMetric)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("non-positive totalFrames in screen trace ");
                stringBuilder2.append(traceMetric.getName());
                FirebasePerfTraceValidator.logger.warn(stringBuilder2.toString());
                return i3;
            }
        }
        Iterator iterator = traceMetric.getSubtracesList().iterator();
        for (TraceMetric next2 : iterator) {
        }
        if (!hasValidAttributes(traceMetric.getCustomAttributesMap())) {
            return i3;
        }
        return i4;
    }

    private boolean isValidTraceDuration(TraceMetric traceMetric) {
        long durationUs;
        int i;
        int obj5;
        if (traceMetric != 0 && Long.compare(durationUs, i) > 0) {
            obj5 = Long.compare(durationUs, i) > 0 ? 1 : 0;
        } else {
        }
        return obj5;
    }

    private boolean isValidTraceId(String string) {
        int i;
        boolean empty;
        String obj3;
        if (string == null) {
            return 0;
        }
        obj3 = string.trim();
        if (!obj3.isEmpty() && obj3.length() <= 100) {
            if (obj3.length() <= 100) {
                i = 1;
            }
        }
        return i;
    }

    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    public boolean isValidPerfMetric() {
        boolean countersValid;
        final int i2 = 0;
        if (!isValidTrace(this.traceMetric, i2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid Trace:");
            stringBuilder.append(this.traceMetric.getName());
            FirebasePerfTraceValidator.logger.warn(stringBuilder.toString());
            return i2;
        }
        if (hasCounters(this.traceMetric) && !areCountersValid(this.traceMetric)) {
            if (!areCountersValid(this.traceMetric)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Invalid Counters for Trace:");
                stringBuilder2.append(this.traceMetric.getName());
                FirebasePerfTraceValidator.logger.warn(stringBuilder2.toString());
                return i2;
            }
        }
        return 1;
    }
}
