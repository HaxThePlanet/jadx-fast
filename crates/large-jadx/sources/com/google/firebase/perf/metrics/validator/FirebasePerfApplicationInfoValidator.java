package com.google.firebase.perf.metrics.validator;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo;

/* loaded from: classes2.dex */
public class FirebasePerfApplicationInfoValidator extends com.google.firebase.perf.metrics.validator.PerfMetricValidator {

    private static final AndroidLogger logger;
    private final ApplicationInfo applicationInfo;
    static {
        FirebasePerfApplicationInfoValidator.logger = AndroidLogger.getInstance();
    }

    FirebasePerfApplicationInfoValidator(ApplicationInfo applicationInfo) {
        super();
        this.applicationInfo = applicationInfo;
    }

    private boolean isValidApplicationInfo() {
        boolean androidAppInfo;
        ApplicationInfo applicationInfo = this.applicationInfo;
        final int i2 = 0;
        if (applicationInfo == null) {
            FirebasePerfApplicationInfoValidator.logger.warn("ApplicationInfo is null");
            return i2;
        }
        if (!applicationInfo.hasGoogleAppId()) {
            FirebasePerfApplicationInfoValidator.logger.warn("GoogleAppId is null");
            return i2;
        }
        if (!this.applicationInfo.hasAppInstanceId()) {
            FirebasePerfApplicationInfoValidator.logger.warn("AppInstanceId is null");
            return i2;
        }
        if (!this.applicationInfo.hasApplicationProcessState()) {
            FirebasePerfApplicationInfoValidator.logger.warn("ApplicationProcessState is null");
            return i2;
        }
        if (this.applicationInfo.hasAndroidAppInfo() && !this.applicationInfo.getAndroidAppInfo().hasPackageName()) {
            if (!this.applicationInfo.getAndroidAppInfo().hasPackageName()) {
                FirebasePerfApplicationInfoValidator.logger.warn("AndroidAppInfo.packageName is null");
                return i2;
            }
            if (!this.applicationInfo.getAndroidAppInfo().hasSdkVersion()) {
                FirebasePerfApplicationInfoValidator.logger.warn("AndroidAppInfo.sdkVersion is null");
                return i2;
            }
        }
        return 1;
    }

    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    public boolean isValidPerfMetric() {
        if (!isValidApplicationInfo()) {
            FirebasePerfApplicationInfoValidator.logger.warn("ApplicationInfo is invalid");
            return 0;
        }
        return 1;
    }
}
