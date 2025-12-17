package com.google.firebase.perf.metrics;

import android.accounts.Account;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionAwareObject;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric.Builder;
import com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod;
import com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason;
import com.google.protobuf.z.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class NetworkRequestMetricBuilder extends AppStateUpdateHandler implements SessionAwareObject {

    private static final char HIGHEST_ASCII_CHAR = '\u007f';
    private static final char HIGHEST_CONTROL_CHAR = '\u001f';
    private static final AndroidLogger logger;
    private final NetworkRequestMetric.Builder builder;
    private final GaugeManager gaugeManager;
    private boolean isManualNetworkRequestMetric;
    private boolean isReportSent;
    private final List<PerfSession> sessions;
    private final TransportManager transportManager;
    private String userAgent;
    private final WeakReference<SessionAwareObject> weakReference;
    static {
        NetworkRequestMetricBuilder.logger = AndroidLogger.getInstance();
    }

    private NetworkRequestMetricBuilder(TransportManager transportManager) {
        super(transportManager, AppStateMonitor.getInstance(), GaugeManager.getInstance());
    }

    public NetworkRequestMetricBuilder(TransportManager transportManager, AppStateMonitor appStateMonitor2, GaugeManager gaugeManager3) {
        super(appStateMonitor2);
        this.builder = NetworkRequestMetric.newBuilder();
        WeakReference obj2 = new WeakReference(this);
        this.weakReference = obj2;
        this.transportManager = transportManager;
        this.gaugeManager = gaugeManager3;
        ArrayList obj1 = new ArrayList();
        this.sessions = Collections.synchronizedList(obj1);
        registerForAppState();
    }

    public static com.google.firebase.perf.metrics.NetworkRequestMetricBuilder builder(TransportManager transportManager) {
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(transportManager);
        return networkRequestMetricBuilder;
    }

    private boolean hasStarted() {
        return this.builder.hasClientStartTimeUs();
    }

    private boolean isStopped() {
        return this.builder.hasTimeToResponseCompletedUs();
    }

    private static boolean isValidContentType(String string) {
        int i;
        int charAt;
        int i2;
        final int i3 = 0;
        if (string.length() > 128) {
            return i3;
        }
        i = i3;
        while (i < string.length()) {
            charAt = string.charAt(i);
            i++;
        }
        return 1;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public NetworkRequestMetric build() {
        com.google.firebase.perf.v1.PerfSession[] andSort;
        Object weakReference;
        boolean isManualNetworkRequestMetric;
        String str;
        SessionManager.getInstance().unregisterForSessionUpdates(this.weakReference);
        unregisterForAppState();
        andSort = PerfSession.buildAndSort(getSessions());
        if (andSort != null) {
            this.builder.addAllPerfSessions(Arrays.asList(andSort));
        }
        com.google.protobuf.z build = this.builder.build();
        if (!NetworkRequestMetricBuilderUtil.isAllowedUserAgent(this.userAgent)) {
            NetworkRequestMetricBuilder.logger.debug("Dropping network request from a 'User-Agent' that is not allowed");
            return (NetworkRequestMetric)build;
        }
        if (!this.isReportSent) {
            this.transportManager.log(build, getAppState());
            this.isReportSent = true;
            return build;
        }
        if (this.isManualNetworkRequestMetric) {
            NetworkRequestMetricBuilder.logger.debug("This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
        }
        return build;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    void clearBuilderFields() {
        this.builder.clear();
    }

    List<PerfSession> getSessions() {
        Object next;
        final List sessions = this.sessions;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.sessions.iterator();
        synchronized (sessions) {
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((PerfSession)next != null) {
                }
                arrayList.add((PerfSession)next);
            }
            return Collections.unmodifiableList(arrayList);
        }
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public long getTimeToResponseInitiatedMicros() {
        return this.builder.getTimeToResponseInitiatedUs();
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public String getUrl() {
        return this.builder.getUrl();
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public boolean hasHttpResponseCode() {
        return this.builder.hasHttpResponseCode();
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    boolean isReportSent() {
        return this.isReportSent;
    }

    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setCustomAttributes(Map<String, String> map) {
        this.builder.clearCustomAttributes().putAllCustomAttributes(map);
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setHttpMethod(String string) {
        Object hTTP_METHOD_UNKNOWN;
        int i;
        String str;
        NetworkRequestMetric.Builder obj4;
        if (string != 0) {
            hTTP_METHOD_UNKNOWN = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
            obj4.hashCode();
            i = -1;
            switch (obj4) {
                case "OPTIONS":
                    i = 0;
                    break;
                case "GET":
                    i = 1;
                    break;
                case "PUT":
                    i = 2;
                    break;
                case "HEAD":
                    i = 3;
                    break;
                case "POST":
                    i = 4;
                    break;
                case "PATCH":
                    i = 5;
                    break;
                case "TRACE":
                    i = 6;
                    break;
                case "CONNECT":
                    i = 7;
                    break;
                case "DELETE":
                    i = 8;
                    break;
                default:
            }
            switch (i) {
                case 0:
                    hTTP_METHOD_UNKNOWN = NetworkRequestMetric.HttpMethod.OPTIONS;
                    break;
                case 1:
                    hTTP_METHOD_UNKNOWN = NetworkRequestMetric.HttpMethod.GET;
                    break;
                case 2:
                    hTTP_METHOD_UNKNOWN = NetworkRequestMetric.HttpMethod.PUT;
                    break;
                case 3:
                    hTTP_METHOD_UNKNOWN = NetworkRequestMetric.HttpMethod.HEAD;
                    break;
                case 4:
                    hTTP_METHOD_UNKNOWN = NetworkRequestMetric.HttpMethod.POST;
                    break;
                case 5:
                    hTTP_METHOD_UNKNOWN = NetworkRequestMetric.HttpMethod.PATCH;
                    break;
                case 6:
                    hTTP_METHOD_UNKNOWN = NetworkRequestMetric.HttpMethod.TRACE;
                    break;
                case 7:
                    hTTP_METHOD_UNKNOWN = NetworkRequestMetric.HttpMethod.CONNECT;
                    break;
                case 8:
                    hTTP_METHOD_UNKNOWN = NetworkRequestMetric.HttpMethod.DELETE;
                    break;
                default:
            }
            this.builder.setHttpMethod(hTTP_METHOD_UNKNOWN);
        }
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setHttpResponseCode(int i) {
        this.builder.setHttpResponseCode(i);
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public void setManualNetworkRequestMetric() {
        this.isManualNetworkRequestMetric = true;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setNetworkClientErrorReason() {
        this.builder.setNetworkClientErrorReason(NetworkRequestMetric.NetworkClientErrorReason.GENERIC_CLIENT_ERROR);
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    void setReportSent() {
        this.isReportSent = true;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setRequestPayloadBytes(long l) {
        this.builder.setRequestPayloadBytes(l);
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setRequestStartTimeMicros(long l) {
        boolean obj4;
        com.google.firebase.perf.util.Timer obj5;
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.weakReference);
        this.builder.setClientStartTimeUs(l);
        updateSession(perfSession);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(perfSession.getTimer());
        }
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setResponseContentType(String string) {
        Object builder;
        StringBuilder stringBuilder;
        String str;
        String obj4;
        if (string == null) {
            this.builder.clearResponseContentType();
            return this;
        }
        if (NetworkRequestMetricBuilder.isValidContentType(string)) {
            this.builder.setResponseContentType(string);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("The content type of the response is not a valid content-type:");
            stringBuilder.append(string);
            NetworkRequestMetricBuilder.logger.warn(stringBuilder.toString());
        }
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setResponsePayloadBytes(long l) {
        this.builder.setResponsePayloadBytes(l);
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setTimeToRequestCompletedMicros(long l) {
        this.builder.setTimeToRequestCompletedUs(l);
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setTimeToResponseCompletedMicros(long l) {
        boolean obj2;
        com.google.firebase.perf.util.Timer obj3;
        this.builder.setTimeToResponseCompletedUs(l);
        if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
        }
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setTimeToResponseInitiatedMicros(long l) {
        this.builder.setTimeToResponseInitiatedUs(l);
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setUrl(String string) {
        NetworkRequestMetric.Builder builder;
        int i;
        String obj3;
        if (string != null) {
            this.builder.setUrl(Utils.truncateURL(Utils.stripSensitiveInfo(string), 2000));
        }
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public com.google.firebase.perf.metrics.NetworkRequestMetricBuilder setUserAgent(String string) {
        this.userAgent = string;
        return this;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public void updateSession(PerfSession perfSession) {
        boolean sessions;
        if (perfSession == null) {
            NetworkRequestMetricBuilder.logger.warn("Unable to add new SessionId to the Network Trace. Continuing without it.");
        }
        if (hasStarted() && !isStopped()) {
            if (!isStopped()) {
                this.sessions.add(perfSession);
            }
        }
    }
}
