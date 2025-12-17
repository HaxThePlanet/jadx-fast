package com.google.firebase.perf.metrics.validator;

import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetric;

/* loaded from: classes2.dex */
final class FirebasePerfGaugeMetricValidator extends com.google.firebase.perf.metrics.validator.PerfMetricValidator {

    private final GaugeMetric gaugeMetric;
    FirebasePerfGaugeMetricValidator(GaugeMetric gaugeMetric) {
        super();
        this.gaugeMetric = gaugeMetric;
    }

    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    public boolean isValidPerfMetric() {
        int i;
        boolean cpuMetricReadingsCount;
        if (this.gaugeMetric.hasSessionId()) {
            if (this.gaugeMetric.getCpuMetricReadingsCount() <= 0 && this.gaugeMetric.getAndroidMemoryReadingsCount() <= 0) {
                if (this.gaugeMetric.getAndroidMemoryReadingsCount() <= 0) {
                    if (this.gaugeMetric.hasGaugeMetadata() && this.gaugeMetric.getGaugeMetadata().hasMaxAppJavaHeapMemoryKb()) {
                        i = this.gaugeMetric.getGaugeMetadata().hasMaxAppJavaHeapMemoryKb() ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
