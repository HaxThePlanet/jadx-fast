package com.google.firebase.perf.metrics;

import com.google.firebase.perf.FirebasePerformanceAttributable;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.validator.PerfMetricValidator;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.net.URL;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class HttpMetric implements FirebasePerformanceAttributable {

    private static final AndroidLogger logger;
    private final Map<String, String> customAttributesMap;
    private boolean isDisabled;
    private boolean isStopped;
    private final com.google.firebase.perf.metrics.NetworkRequestMetricBuilder networkMetricBuilder;
    private final Timer timer;
    static {
        HttpMetric.logger = AndroidLogger.getInstance();
    }

    public HttpMetric(String string, String string2, TransportManager transportManager3, Timer timer4) {
        String obj3;
        boolean obj4;
        com.google.firebase.perf.metrics.NetworkRequestMetricBuilder obj5;
        Timer obj6;
        super();
        final int i = 0;
        this.isStopped = i;
        this.isDisabled = i;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.customAttributesMap = concurrentHashMap;
        this.timer = timer4;
        obj4 = NetworkRequestMetricBuilder.builder(transportManager3).setUrl(string).setHttpMethod(string2);
        this.networkMetricBuilder = obj4;
        obj4.setManualNetworkRequestMetric();
        if (!ConfigResolver.getInstance().isPerformanceMonitoringEnabled()) {
            obj5 = 1;
            obj6 = new Object[obj5];
            obj6[i] = string;
            HttpMetric.logger.info("HttpMetric feature is disabled. URL %s", obj6);
            this.isDisabled = obj5;
        }
    }

    public HttpMetric(URL uRL, String string2, TransportManager transportManager3, Timer timer4) {
        super(uRL.toString(), string2, transportManager3, timer4);
    }

    private void checkAttribute(String string, String string2) {
        boolean size;
        int i;
        if (this.isStopped) {
        } else {
            if (string == null) {
            } else {
                if (string2 == null) {
                } else {
                    if (!this.customAttributesMap.containsKey(string)) {
                        i = 5;
                        if (this.customAttributesMap.size() >= i) {
                        } else {
                        }
                        Object[] arr = new Object[1];
                        IllegalArgumentException obj4 = new IllegalArgumentException(String.format(Locale.ENGLISH, "Exceeds max limit of number of attributes - %d", Integer.valueOf(i)));
                        throw obj4;
                    }
                    AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(string, string2);
                    obj4 = PerfMetricValidator.validateAttribute(simpleEntry);
                    if (obj4 != null) {
                    } else {
                    }
                    IllegalArgumentException obj5 = new IllegalArgumentException(obj4);
                    throw obj5;
                }
            }
            obj4 = new IllegalArgumentException("Attribute must not have null key or value.");
            throw obj4;
        }
        obj4 = new IllegalArgumentException("HttpMetric has been logged already so unable to modify attributes");
        throw obj4;
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public String getAttribute(String string) {
        return (String)this.customAttributesMap.get(string);
    }

    public Map<String, String> getAttributes() {
        HashMap hashMap = new HashMap(this.customAttributesMap);
        return hashMap;
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void markRequestComplete() {
        this.networkMetricBuilder.setTimeToRequestCompletedMicros(this.timer.getDurationMicros());
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void markResponseStart() {
        this.networkMetricBuilder.setTimeToResponseInitiatedMicros(this.timer.getDurationMicros());
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void putAttribute(String string, String string2) {
        int customAttributesMap;
        int i;
        int i2;
        AndroidLogger logger;
        String str;
        i2 = 1;
        final String obj9 = string.trim();
        final String obj10 = string2.trim();
        checkAttribute(obj9, obj10);
        final Object[] arr2 = new Object[3];
        arr2[i2] = obj10;
        arr2[2] = this.networkMetricBuilder.getUrl();
        HttpMetric.logger.debug("Setting attribute '%s' to %s on network request '%s'", arr2);
        if (i2 != 0) {
            this.customAttributesMap.put(obj9, obj10);
        }
        try {
        }
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void removeAttribute(String string) {
        if (this.isStopped) {
            HttpMetric.logger.error("Can't remove a attribute from a HttpMetric that's stopped.");
        }
        this.customAttributesMap.remove(string);
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void setHttpResponseCode(int i) {
        this.networkMetricBuilder.setHttpResponseCode(i);
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void setRequestPayloadSize(long l) {
        this.networkMetricBuilder.setRequestPayloadBytes(l);
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void setResponseContentType(String string) {
        this.networkMetricBuilder.setResponseContentType(string);
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void setResponsePayloadSize(long l) {
        this.networkMetricBuilder.setResponsePayloadBytes(l);
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void start() {
        this.timer.reset();
        this.networkMetricBuilder.setRequestStartTimeMicros(this.timer.getMicros());
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void stop() {
        if (this.isDisabled) {
        }
        this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros()).setCustomAttributes(this.customAttributesMap).build();
        this.isStopped = true;
    }
}
