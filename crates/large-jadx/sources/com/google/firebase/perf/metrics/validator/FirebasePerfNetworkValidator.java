package com.google.firebase.perf.metrics.validator;

import android.content.Context;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.URLAllowlist;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod;
import java.net.URI;

/* loaded from: classes2.dex */
final class FirebasePerfNetworkValidator extends com.google.firebase.perf.metrics.validator.PerfMetricValidator {

    private static final int EMPTY_PORT = -1;
    private static final String HTTPS = "https";
    private static final String HTTP_SCHEMA = "http";
    private static final AndroidLogger logger;
    private final Context appContext;
    private final NetworkRequestMetric networkMetric;
    static {
        FirebasePerfNetworkValidator.logger = AndroidLogger.getInstance();
    }

    FirebasePerfNetworkValidator(NetworkRequestMetric networkRequestMetric, Context context2) {
        super();
        this.appContext = context2;
        this.networkMetric = networkRequestMetric;
    }

    private URI getResultUrl(String string) {
        if (string == null) {
            return null;
        }
        return URI.create(string);
    }

    private boolean isAllowlisted(URI uRI, Context context2) {
        if (uRI == null) {
            return 0;
        }
        return URLAllowlist.isURLAllowlisted(uRI, context2);
    }

    private boolean isBlank(String string) {
        if (string == null) {
            return 1;
        }
        return string.trim().isEmpty();
    }

    private boolean isEmptyUrl(String string) {
        return isBlank(string);
    }

    private boolean isValidHost(String string) {
        int blank;
        int obj2;
        if (string != null && !isBlank(string) && string.length() <= 255) {
            if (!isBlank(string)) {
                obj2 = string.length() <= 255 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private boolean isValidHttpResponseCode(int i) {
        int obj1;
        obj1 = i > 0 ? 1 : 0;
        return obj1;
    }

    private boolean isValidPayload(long l) {
        int obj3;
        obj3 = Long.compare(l, i) >= 0 ? 1 : 0;
        return obj3;
    }

    private boolean isValidPort(int i) {
        int obj2;
        if (i != -1) {
            if (i > 0) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    private boolean isValidScheme(String string) {
        int i;
        String equalsIgnoreCase;
        boolean obj3;
        if (string == null) {
            return 0;
        }
        if (!"http".equalsIgnoreCase(string)) {
            if ("https".equalsIgnoreCase(string)) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    private boolean isValidTime(long l) {
        int obj3;
        obj3 = Long.compare(l, i) >= 0 ? 1 : 0;
        return obj3;
    }

    private boolean isValidUserInfo(String string) {
        int obj1;
        obj1 = string == null ? 1 : 0;
        return obj1;
    }

    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    boolean isValidHttpMethod(NetworkRequestMetric.HttpMethod networkRequestMetric$HttpMethod) {
        NetworkRequestMetric.HttpMethod hTTP_METHOD_UNKNOWN;
        int obj2;
        if (httpMethod != null && httpMethod != NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN) {
            obj2 = httpMethod != NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    public boolean isValidPerfMetric() {
        NetworkRequestMetric.HttpMethod httpMethod;
        boolean validHttpResponseCode;
        boolean requestPayloadBytes;
        boolean responsePayloadBytes;
        boolean clientStartTimeUs;
        boolean timeToRequestCompletedUs;
        boolean timeToResponseInitiatedUs;
        boolean timeToResponseCompletedUs2;
        boolean timeToResponseCompletedUs;
        int i;
        final int i3 = 0;
        if (isEmptyUrl(this.networkMetric.getUrl())) {
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append("URL is missing:");
            stringBuilder9.append(this.networkMetric.getUrl());
            FirebasePerfNetworkValidator.logger.warn(stringBuilder9.toString());
            return i3;
        }
        URI resultUrl = getResultUrl(this.networkMetric.getUrl());
        if (resultUrl == null) {
            FirebasePerfNetworkValidator.logger.warn("URL cannot be parsed");
            return i3;
        }
        if (!isAllowlisted(resultUrl, this.appContext)) {
            StringBuilder stringBuilder10 = new StringBuilder();
            stringBuilder10.append("URL fails allowlist rule: ");
            stringBuilder10.append(resultUrl);
            FirebasePerfNetworkValidator.logger.warn(stringBuilder10.toString());
            return i3;
        }
        if (!isValidHost(resultUrl.getHost())) {
            FirebasePerfNetworkValidator.logger.warn("URL host is null or invalid");
            return i3;
        }
        if (!isValidScheme(resultUrl.getScheme())) {
            FirebasePerfNetworkValidator.logger.warn("URL scheme is null or invalid");
            return i3;
        }
        if (!isValidUserInfo(resultUrl.getUserInfo())) {
            FirebasePerfNetworkValidator.logger.warn("URL user info is null");
            return i3;
        }
        if (!isValidPort(resultUrl.getPort())) {
            FirebasePerfNetworkValidator.logger.warn("URL port is less than or equal to 0");
            return i3;
        }
        if (this.networkMetric.hasHttpMethod()) {
            httpMethod = this.networkMetric.getHttpMethod();
        } else {
            httpMethod = 0;
        }
        if (!isValidHttpMethod(httpMethod)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HTTP Method is null or invalid: ");
            stringBuilder.append(this.networkMetric.getHttpMethod());
            FirebasePerfNetworkValidator.logger.warn(stringBuilder.toString());
            return i3;
        }
        if (this.networkMetric.hasHttpResponseCode() && !isValidHttpResponseCode(this.networkMetric.getHttpResponseCode())) {
            if (!isValidHttpResponseCode(this.networkMetric.getHttpResponseCode())) {
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append("HTTP ResponseCode is a negative value:");
                stringBuilder8.append(this.networkMetric.getHttpResponseCode());
                FirebasePerfNetworkValidator.logger.warn(stringBuilder8.toString());
                return i3;
            }
        }
        if (this.networkMetric.hasRequestPayloadBytes() && !isValidPayload(this.networkMetric.getRequestPayloadBytes())) {
            if (!isValidPayload(this.networkMetric.getRequestPayloadBytes())) {
                StringBuilder stringBuilder7 = new StringBuilder();
                stringBuilder7.append("Request Payload is a negative value:");
                stringBuilder7.append(this.networkMetric.getRequestPayloadBytes());
                FirebasePerfNetworkValidator.logger.warn(stringBuilder7.toString());
                return i3;
            }
        }
        if (this.networkMetric.hasResponsePayloadBytes() && !isValidPayload(this.networkMetric.getResponsePayloadBytes())) {
            if (!isValidPayload(this.networkMetric.getResponsePayloadBytes())) {
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append("Response Payload is a negative value:");
                stringBuilder6.append(this.networkMetric.getResponsePayloadBytes());
                FirebasePerfNetworkValidator.logger.warn(stringBuilder6.toString());
                return i3;
            }
        }
        if (this.networkMetric.hasClientStartTimeUs()) {
            i = 0;
            if (Long.compare(timeToResponseCompletedUs, i) <= 0) {
            } else {
                if (this.networkMetric.hasTimeToRequestCompletedUs() && !isValidTime(this.networkMetric.getTimeToRequestCompletedUs())) {
                    if (!isValidTime(this.networkMetric.getTimeToRequestCompletedUs())) {
                        StringBuilder stringBuilder5 = new StringBuilder();
                        stringBuilder5.append("Time to complete the request is a negative value:");
                        stringBuilder5.append(this.networkMetric.getTimeToRequestCompletedUs());
                        FirebasePerfNetworkValidator.logger.warn(stringBuilder5.toString());
                        return i3;
                    }
                }
                if (this.networkMetric.hasTimeToResponseInitiatedUs() && !isValidTime(this.networkMetric.getTimeToResponseInitiatedUs())) {
                    if (!isValidTime(this.networkMetric.getTimeToResponseInitiatedUs())) {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("Time from the start of the request to the start of the response is null or a negative value:");
                        stringBuilder4.append(this.networkMetric.getTimeToResponseInitiatedUs());
                        FirebasePerfNetworkValidator.logger.warn(stringBuilder4.toString());
                        return i3;
                    }
                }
                if (this.networkMetric.hasTimeToResponseCompletedUs()) {
                    if (Long.compare(timeToResponseCompletedUs, i) <= 0) {
                    } else {
                        if (!this.networkMetric.hasHttpResponseCode()) {
                            FirebasePerfNetworkValidator.logger.warn("Did not receive a HTTP Response Code");
                            return i3;
                        }
                    }
                    return 1;
                }
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Time from the start of the request to the end of the response is null, negative or zero:");
            stringBuilder3.append(this.networkMetric.getTimeToResponseCompletedUs());
            FirebasePerfNetworkValidator.logger.warn(stringBuilder3.toString());
            return i3;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Start time of the request is null, or zero, or a negative value:");
        stringBuilder2.append(this.networkMetric.getClientStartTimeUs());
        FirebasePerfNetworkValidator.logger.warn(stringBuilder2.toString());
        return i3;
    }
}
