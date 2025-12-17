package com.google.firebase.perf.metrics.validator;

import android.content.Context;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Constants.CounterNames;
import com.google.firebase.perf.util.Constants.TraceNames;
import com.google.firebase.perf.v1.PerfMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public abstract class PerfMetricValidator {
    private static List<com.google.firebase.perf.metrics.validator.PerfMetricValidator> getValidators(PerfMetric perfMetric, Context context2) {
        boolean firebasePerfTraceValidator;
        boolean networkRequestMetric2;
        com.google.firebase.perf.v1.TraceMetric networkRequestMetric;
        com.google.firebase.perf.v1.GaugeMetric obj3;
        boolean obj4;
        ArrayList arrayList = new ArrayList();
        if (perfMetric.hasTraceMetric()) {
            firebasePerfTraceValidator = new FirebasePerfTraceValidator(perfMetric.getTraceMetric());
            arrayList.add(firebasePerfTraceValidator);
        }
        if (perfMetric.hasNetworkRequestMetric()) {
            networkRequestMetric2 = new FirebasePerfNetworkValidator(perfMetric.getNetworkRequestMetric(), context2);
            arrayList.add(networkRequestMetric2);
        }
        if (perfMetric.hasApplicationInfo()) {
            obj4 = new FirebasePerfApplicationInfoValidator(perfMetric.getApplicationInfo());
            arrayList.add(obj4);
        }
        if (perfMetric.hasGaugeMetric()) {
            obj4 = new FirebasePerfGaugeMetricValidator(perfMetric.getGaugeMetric());
            arrayList.add(obj4);
        }
        return arrayList;
    }

    public static boolean isValid(PerfMetric perfMetric, Context context2) {
        boolean obj2;
        List obj1 = PerfMetricValidator.getValidators(perfMetric, context2);
        final int i = 0;
        if (obj1.isEmpty()) {
            AndroidLogger.getInstance().debug("No validators found for PerfMetric.");
            return i;
        }
        obj1 = obj1.iterator();
        for (PerfMetricValidator obj2 : obj1) {
        }
        return 1;
    }

    public static String validateAttribute(Map.Entry<String, String> map$Entry) {
        Object key = entry.getKey();
        Object obj5 = entry.getValue();
        if ((String)key == null) {
            return "Attribute key must not be null";
        }
        if ((String)obj5 == null) {
            return "Attribute value must not be null";
        }
        final int i2 = 0;
        final int i3 = 1;
        final int i4 = 40;
        if ((String)key.length() > i4) {
            Object[] arr2 = new Object[i3];
            arr2[i2] = Integer.valueOf(i4);
            return String.format(Locale.US, "Attribute key length must not exceed %d characters", arr2);
        }
        int i = 100;
        if ((String)obj5.length() > i) {
            Object[] arr = new Object[i3];
            arr[i2] = Integer.valueOf(i);
            return String.format(Locale.US, "Attribute value length must not exceed %d characters", arr);
        }
        if (!key.matches("^(?!(firebase_|google_|ga_))[A-Za-z][A-Za-z_0-9]*")) {
            return "Attribute key must start with letter, must only contain alphanumeric characters and underscore and must not start with \"firebase_\", \"google_\" and \"ga_";
        }
        return null;
    }

    public static String validateMetricName(String string) {
        int i;
        boolean equals;
        if (string == null) {
            return "Metric name must not be null";
        }
        int i3 = 100;
        if (string.length() > i3) {
            Object[] arr = new Object[1];
            return String.format(Locale.US, "Metric name must not exceed %d characters", Integer.valueOf(i3));
        }
        int i4 = 0;
        if (string.startsWith("_")) {
            Constants.CounterNames[] values = Constants.CounterNames.values();
            while (i < values.length) {
                i++;
            }
            return "Metric name must not start with '_'";
        }
        return i4;
    }

    public static String validateTraceName(String string) {
        int i;
        boolean equals;
        if (string == null) {
            return "Trace name must not be null";
        }
        int i3 = 100;
        if (string.length() > i3) {
            Object[] arr = new Object[1];
            return String.format(Locale.US, "Trace name must not exceed %d characters", Integer.valueOf(i3));
        }
        int i4 = 0;
        if (string.startsWith("_")) {
            Constants.TraceNames[] values = Constants.TraceNames.values();
            while (i < values.length) {
                i++;
            }
            if (string.startsWith("_st_")) {
                return i4;
            }
            return "Trace name must not start with '_'";
        }
        return i4;
    }

    public abstract boolean isValidPerfMetric();
}
