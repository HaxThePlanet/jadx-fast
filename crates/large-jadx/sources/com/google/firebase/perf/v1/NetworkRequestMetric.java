package com.google.firebase.perf.v1;

import com.google.protobuf.a;
import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.m0;
import com.google.protobuf.n0;
import com.google.protobuf.q;
import com.google.protobuf.y1.b;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class NetworkRequestMetric extends z<com.google.firebase.perf.v1.NetworkRequestMetric, com.google.firebase.perf.v1.NetworkRequestMetric.Builder> implements com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder {

    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 7;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 12;
    private static final com.google.firebase.perf.v1.NetworkRequestMetric DEFAULT_INSTANCE = null;
    public static final int HTTP_METHOD_FIELD_NUMBER = 2;
    public static final int HTTP_RESPONSE_CODE_FIELD_NUMBER = 5;
    public static final int NETWORK_CLIENT_ERROR_REASON_FIELD_NUMBER = 11;
    private static volatile d1<com.google.firebase.perf.v1.NetworkRequestMetric> PARSER = null;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 13;
    public static final int REQUEST_PAYLOAD_BYTES_FIELD_NUMBER = 3;
    public static final int RESPONSE_CONTENT_TYPE_FIELD_NUMBER = 6;
    public static final int RESPONSE_PAYLOAD_BYTES_FIELD_NUMBER = 4;
    public static final int TIME_TO_REQUEST_COMPLETED_US_FIELD_NUMBER = 8;
    public static final int TIME_TO_RESPONSE_COMPLETED_US_FIELD_NUMBER = 10;
    public static final int TIME_TO_RESPONSE_INITIATED_US_FIELD_NUMBER = 9;
    public static final int URL_FIELD_NUMBER = 1;
    private int bitField0_;
    private long clientStartTimeUs_;
    private n0<String, String> customAttributes_;
    private int httpMethod_;
    private int httpResponseCode_;
    private int networkClientErrorReason_;
    private c0.j<com.google.firebase.perf.v1.PerfSession> perfSessions_;
    private long requestPayloadBytes_;
    private String responseContentType_;
    private long responsePayloadBytes_;
    private long timeToRequestCompletedUs_;
    private long timeToResponseCompletedUs_;
    private long timeToResponseInitiatedUs_;
    private String url_;

    private static final class CustomAttributesDefaultEntryHolder {

        static final m0<String, String> defaultEntry;
        static {
            y1.b sTRING = y1.b.STRING;
            final String str = "";
            NetworkRequestMetric.CustomAttributesDefaultEntryHolder.defaultEntry = m0.d(sTRING, str, sTRING, str);
        }
    }

    public static enum HttpMethod implements c0.c {

        HTTP_METHOD_UNKNOWN(false),
        GET(true),
        PUT(2),
        POST(3),
        DELETE(4),
        HEAD(5),
        PATCH(6),
        OPTIONS(6),
        TRACE(5),
        CONNECT(4);

        private final int value;
        public static com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod forNumber(int i) {
            switch (i) {
                case 0:
                    return NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
                case 1:
                    return NetworkRequestMetric.HttpMethod.GET;
                case 2:
                    return NetworkRequestMetric.HttpMethod.PUT;
                case 3:
                    return NetworkRequestMetric.HttpMethod.POST;
                case 4:
                    return NetworkRequestMetric.HttpMethod.DELETE;
                case 5:
                    return NetworkRequestMetric.HttpMethod.HEAD;
                case 6:
                    return NetworkRequestMetric.HttpMethod.PATCH;
                case 7:
                    return NetworkRequestMetric.HttpMethod.OPTIONS;
                case 8:
                    return NetworkRequestMetric.HttpMethod.TRACE;
                case 9:
                    return NetworkRequestMetric.HttpMethod.CONNECT;
                default:
                    return null;
            }
        }

        public static c0.d<com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod> internalGetValueMap() {
            return NetworkRequestMetric.HttpMethod.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return NetworkRequestMetric.HttpMethod.HttpMethodVerifier.INSTANCE;
        }

        @Deprecated
        public static com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod valueOf(int i) {
            return NetworkRequestMetric.HttpMethod.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    public static enum NetworkClientErrorReason implements c0.c {

        NETWORK_CLIENT_ERROR_REASON_UNKNOWN(false),
        GENERIC_CLIENT_ERROR(true);

        private final int value;
        public static com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason forNumber(int i) {
            if (i != 0 && i != 1) {
                if (i != 1) {
                    return null;
                }
                return NetworkRequestMetric.NetworkClientErrorReason.GENERIC_CLIENT_ERROR;
            }
            return NetworkRequestMetric.NetworkClientErrorReason.NETWORK_CLIENT_ERROR_REASON_UNKNOWN;
        }

        public static c0.d<com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason> internalGetValueMap() {
            return NetworkRequestMetric.NetworkClientErrorReason.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return NetworkRequestMetric.NetworkClientErrorReason.NetworkClientErrorReasonVerifier.INSTANCE;
        }

        @Deprecated
        public static com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason valueOf(int i) {
            return NetworkRequestMetric.NetworkClientErrorReason.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    public static final class Builder extends z.a<com.google.firebase.perf.v1.NetworkRequestMetric, com.google.firebase.perf.v1.NetworkRequestMetric.Builder> implements com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder {
        private Builder() {
            super(NetworkRequestMetric.access$000());
        }

        Builder(com.google.firebase.perf.v1.NetworkRequestMetric.1 networkRequestMetric$1) {
            super();
        }

        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder addAllPerfSessions(Iterable<? extends com.google.firebase.perf.v1.PerfSession> iterable) {
            copyOnWrite();
            NetworkRequestMetric.access$2900((NetworkRequestMetric)this.instance, iterable);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder addPerfSessions(int i, com.google.firebase.perf.v1.PerfSession.Builder perfSession$Builder2) {
            copyOnWrite();
            NetworkRequestMetric.access$2800((NetworkRequestMetric)this.instance, i, (PerfSession)builder2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder addPerfSessions(int i, com.google.firebase.perf.v1.PerfSession perfSession2) {
            copyOnWrite();
            NetworkRequestMetric.access$2800((NetworkRequestMetric)this.instance, i, perfSession2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder addPerfSessions(com.google.firebase.perf.v1.PerfSession.Builder perfSession$Builder) {
            copyOnWrite();
            NetworkRequestMetric.access$2700((NetworkRequestMetric)this.instance, (PerfSession)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder addPerfSessions(com.google.firebase.perf.v1.PerfSession perfSession) {
            copyOnWrite();
            NetworkRequestMetric.access$2700((NetworkRequestMetric)this.instance, perfSession);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearClientStartTimeUs() {
            copyOnWrite();
            NetworkRequestMetric.access$1800((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearCustomAttributes() {
            copyOnWrite();
            NetworkRequestMetric.access$2500((NetworkRequestMetric)this.instance).clear();
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearHttpMethod() {
            copyOnWrite();
            NetworkRequestMetric.access$500((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearHttpResponseCode() {
            copyOnWrite();
            NetworkRequestMetric.access$1300((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearNetworkClientErrorReason() {
            copyOnWrite();
            NetworkRequestMetric.access$1100((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearPerfSessions() {
            copyOnWrite();
            NetworkRequestMetric.access$3000((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearRequestPayloadBytes() {
            copyOnWrite();
            NetworkRequestMetric.access$700((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearResponseContentType() {
            copyOnWrite();
            NetworkRequestMetric.access$1500((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearResponsePayloadBytes() {
            copyOnWrite();
            NetworkRequestMetric.access$900((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearTimeToRequestCompletedUs() {
            copyOnWrite();
            NetworkRequestMetric.access$2000((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearTimeToResponseCompletedUs() {
            copyOnWrite();
            NetworkRequestMetric.access$2400((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearTimeToResponseInitiatedUs() {
            copyOnWrite();
            NetworkRequestMetric.access$2200((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder clearUrl() {
            copyOnWrite();
            NetworkRequestMetric.access$200((NetworkRequestMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public boolean containsCustomAttributes(String string) {
            string.getClass();
            return (NetworkRequestMetric)this.instance.getCustomAttributesMap().containsKey(string);
        }

        @Override // com.google.protobuf.z$a
        public long getClientStartTimeUs() {
            return (NetworkRequestMetric)this.instance.getClientStartTimeUs();
        }

        @Deprecated
        public Map<String, String> getCustomAttributes() {
            return getCustomAttributesMap();
        }

        @Override // com.google.protobuf.z$a
        public int getCustomAttributesCount() {
            return (NetworkRequestMetric)this.instance.getCustomAttributesMap().size();
        }

        public Map<String, String> getCustomAttributesMap() {
            return Collections.unmodifiableMap((NetworkRequestMetric)this.instance.getCustomAttributesMap());
        }

        @Override // com.google.protobuf.z$a
        public String getCustomAttributesOrDefault(String string, String string2) {
            Object obj3;
            Object obj4;
            string.getClass();
            Map customAttributesMap = (NetworkRequestMetric)this.instance.getCustomAttributesMap();
            if (customAttributesMap.containsKey(string)) {
                obj4 = obj3;
            }
            return obj4;
        }

        @Override // com.google.protobuf.z$a
        public String getCustomAttributesOrThrow(String string) {
            string.getClass();
            Map customAttributesMap = (NetworkRequestMetric)this.instance.getCustomAttributesMap();
            if (!customAttributesMap.containsKey(string)) {
            } else {
                return (String)customAttributesMap.get(string);
            }
            IllegalArgumentException obj3 = new IllegalArgumentException();
            throw obj3;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod getHttpMethod() {
            return (NetworkRequestMetric)this.instance.getHttpMethod();
        }

        @Override // com.google.protobuf.z$a
        public int getHttpResponseCode() {
            return (NetworkRequestMetric)this.instance.getHttpResponseCode();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason getNetworkClientErrorReason() {
            return (NetworkRequestMetric)this.instance.getNetworkClientErrorReason();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfSession getPerfSessions(int i) {
            return (NetworkRequestMetric)this.instance.getPerfSessions(i);
        }

        @Override // com.google.protobuf.z$a
        public int getPerfSessionsCount() {
            return (NetworkRequestMetric)this.instance.getPerfSessionsCount();
        }

        public List<com.google.firebase.perf.v1.PerfSession> getPerfSessionsList() {
            return Collections.unmodifiableList((NetworkRequestMetric)this.instance.getPerfSessionsList());
        }

        @Override // com.google.protobuf.z$a
        public long getRequestPayloadBytes() {
            return (NetworkRequestMetric)this.instance.getRequestPayloadBytes();
        }

        @Override // com.google.protobuf.z$a
        public String getResponseContentType() {
            return (NetworkRequestMetric)this.instance.getResponseContentType();
        }

        @Override // com.google.protobuf.z$a
        public j getResponseContentTypeBytes() {
            return (NetworkRequestMetric)this.instance.getResponseContentTypeBytes();
        }

        @Override // com.google.protobuf.z$a
        public long getResponsePayloadBytes() {
            return (NetworkRequestMetric)this.instance.getResponsePayloadBytes();
        }

        @Override // com.google.protobuf.z$a
        public long getTimeToRequestCompletedUs() {
            return (NetworkRequestMetric)this.instance.getTimeToRequestCompletedUs();
        }

        @Override // com.google.protobuf.z$a
        public long getTimeToResponseCompletedUs() {
            return (NetworkRequestMetric)this.instance.getTimeToResponseCompletedUs();
        }

        @Override // com.google.protobuf.z$a
        public long getTimeToResponseInitiatedUs() {
            return (NetworkRequestMetric)this.instance.getTimeToResponseInitiatedUs();
        }

        @Override // com.google.protobuf.z$a
        public String getUrl() {
            return (NetworkRequestMetric)this.instance.getUrl();
        }

        @Override // com.google.protobuf.z$a
        public j getUrlBytes() {
            return (NetworkRequestMetric)this.instance.getUrlBytes();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasClientStartTimeUs() {
            return (NetworkRequestMetric)this.instance.hasClientStartTimeUs();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasHttpMethod() {
            return (NetworkRequestMetric)this.instance.hasHttpMethod();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasHttpResponseCode() {
            return (NetworkRequestMetric)this.instance.hasHttpResponseCode();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasNetworkClientErrorReason() {
            return (NetworkRequestMetric)this.instance.hasNetworkClientErrorReason();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasRequestPayloadBytes() {
            return (NetworkRequestMetric)this.instance.hasRequestPayloadBytes();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasResponseContentType() {
            return (NetworkRequestMetric)this.instance.hasResponseContentType();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasResponsePayloadBytes() {
            return (NetworkRequestMetric)this.instance.hasResponsePayloadBytes();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasTimeToRequestCompletedUs() {
            return (NetworkRequestMetric)this.instance.hasTimeToRequestCompletedUs();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasTimeToResponseCompletedUs() {
            return (NetworkRequestMetric)this.instance.hasTimeToResponseCompletedUs();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasTimeToResponseInitiatedUs() {
            return (NetworkRequestMetric)this.instance.hasTimeToResponseInitiatedUs();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasUrl() {
            return (NetworkRequestMetric)this.instance.hasUrl();
        }

        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder putAllCustomAttributes(Map<String, String> map) {
            copyOnWrite();
            NetworkRequestMetric.access$2500((NetworkRequestMetric)this.instance).putAll(map);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder putCustomAttributes(String string, String string2) {
            string.getClass();
            string2.getClass();
            copyOnWrite();
            NetworkRequestMetric.access$2500((NetworkRequestMetric)this.instance).put(string, string2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder removeCustomAttributes(String string) {
            string.getClass();
            copyOnWrite();
            NetworkRequestMetric.access$2500((NetworkRequestMetric)this.instance).remove(string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder removePerfSessions(int i) {
            copyOnWrite();
            NetworkRequestMetric.access$3100((NetworkRequestMetric)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setClientStartTimeUs(long l) {
            copyOnWrite();
            NetworkRequestMetric.access$1700((NetworkRequestMetric)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setHttpMethod(com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod networkRequestMetric$HttpMethod) {
            copyOnWrite();
            NetworkRequestMetric.access$400((NetworkRequestMetric)this.instance, httpMethod);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setHttpResponseCode(int i) {
            copyOnWrite();
            NetworkRequestMetric.access$1200((NetworkRequestMetric)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setNetworkClientErrorReason(com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason networkRequestMetric$NetworkClientErrorReason) {
            copyOnWrite();
            NetworkRequestMetric.access$1000((NetworkRequestMetric)this.instance, networkClientErrorReason);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setPerfSessions(int i, com.google.firebase.perf.v1.PerfSession.Builder perfSession$Builder2) {
            copyOnWrite();
            NetworkRequestMetric.access$2600((NetworkRequestMetric)this.instance, i, (PerfSession)builder2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setPerfSessions(int i, com.google.firebase.perf.v1.PerfSession perfSession2) {
            copyOnWrite();
            NetworkRequestMetric.access$2600((NetworkRequestMetric)this.instance, i, perfSession2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setRequestPayloadBytes(long l) {
            copyOnWrite();
            NetworkRequestMetric.access$600((NetworkRequestMetric)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setResponseContentType(String string) {
            copyOnWrite();
            NetworkRequestMetric.access$1400((NetworkRequestMetric)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setResponseContentTypeBytes(j j) {
            copyOnWrite();
            NetworkRequestMetric.access$1600((NetworkRequestMetric)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setResponsePayloadBytes(long l) {
            copyOnWrite();
            NetworkRequestMetric.access$800((NetworkRequestMetric)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setTimeToRequestCompletedUs(long l) {
            copyOnWrite();
            NetworkRequestMetric.access$1900((NetworkRequestMetric)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setTimeToResponseCompletedUs(long l) {
            copyOnWrite();
            NetworkRequestMetric.access$2300((NetworkRequestMetric)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setTimeToResponseInitiatedUs(long l) {
            copyOnWrite();
            NetworkRequestMetric.access$2100((NetworkRequestMetric)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setUrl(String string) {
            copyOnWrite();
            NetworkRequestMetric.access$100((NetworkRequestMetric)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric.Builder setUrlBytes(j j) {
            copyOnWrite();
            NetworkRequestMetric.access$300((NetworkRequestMetric)this.instance, j);
            return this;
        }
    }
    static {
        NetworkRequestMetric networkRequestMetric = new NetworkRequestMetric();
        NetworkRequestMetric.DEFAULT_INSTANCE = networkRequestMetric;
        z.registerDefaultInstance(NetworkRequestMetric.class, networkRequestMetric);
    }

    private NetworkRequestMetric() {
        super();
        this.customAttributes_ = n0.e();
        String str = "";
        this.url_ = str;
        this.responseContentType_ = str;
        this.perfSessions_ = z.emptyProtobufList();
    }

    static com.google.firebase.perf.v1.NetworkRequestMetric access$000() {
        return NetworkRequestMetric.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, String string2) {
        networkRequestMetric.setUrl(string2);
    }

    static void access$1000(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason networkRequestMetric$NetworkClientErrorReason2) {
        networkRequestMetric.setNetworkClientErrorReason(networkClientErrorReason2);
    }

    static void access$1100(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearNetworkClientErrorReason();
    }

    static void access$1200(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, int i2) {
        networkRequestMetric.setHttpResponseCode(i2);
    }

    static void access$1300(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearHttpResponseCode();
    }

    static void access$1400(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, String string2) {
        networkRequestMetric.setResponseContentType(string2);
    }

    static void access$1500(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearResponseContentType();
    }

    static void access$1600(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, j j2) {
        networkRequestMetric.setResponseContentTypeBytes(j2);
    }

    static void access$1700(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, long l2) {
        networkRequestMetric.setClientStartTimeUs(l2);
    }

    static void access$1800(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearClientStartTimeUs();
    }

    static void access$1900(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, long l2) {
        networkRequestMetric.setTimeToRequestCompletedUs(l2);
    }

    static void access$200(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearUrl();
    }

    static void access$2000(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearTimeToRequestCompletedUs();
    }

    static void access$2100(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, long l2) {
        networkRequestMetric.setTimeToResponseInitiatedUs(l2);
    }

    static void access$2200(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearTimeToResponseInitiatedUs();
    }

    static void access$2300(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, long l2) {
        networkRequestMetric.setTimeToResponseCompletedUs(l2);
    }

    static void access$2400(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearTimeToResponseCompletedUs();
    }

    static Map access$2500(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        return networkRequestMetric.getMutableCustomAttributesMap();
    }

    static void access$2600(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, int i2, com.google.firebase.perf.v1.PerfSession perfSession3) {
        networkRequestMetric.setPerfSessions(i2, perfSession3);
    }

    static void access$2700(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, com.google.firebase.perf.v1.PerfSession perfSession2) {
        networkRequestMetric.addPerfSessions(perfSession2);
    }

    static void access$2800(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, int i2, com.google.firebase.perf.v1.PerfSession perfSession3) {
        networkRequestMetric.addPerfSessions(i2, perfSession3);
    }

    static void access$2900(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, Iterable iterable2) {
        networkRequestMetric.addAllPerfSessions(iterable2);
    }

    static void access$300(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, j j2) {
        networkRequestMetric.setUrlBytes(j2);
    }

    static void access$3000(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearPerfSessions();
    }

    static void access$3100(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, int i2) {
        networkRequestMetric.removePerfSessions(i2);
    }

    static void access$400(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod networkRequestMetric$HttpMethod2) {
        networkRequestMetric.setHttpMethod(httpMethod2);
    }

    static void access$500(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearHttpMethod();
    }

    static void access$600(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, long l2) {
        networkRequestMetric.setRequestPayloadBytes(l2);
    }

    static void access$700(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearRequestPayloadBytes();
    }

    static void access$800(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric, long l2) {
        networkRequestMetric.setResponsePayloadBytes(l2);
    }

    static void access$900(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.clearResponsePayloadBytes();
    }

    private void addAllPerfSessions(Iterable<? extends com.google.firebase.perf.v1.PerfSession> iterable) {
        ensurePerfSessionsIsMutable();
        a.addAll(iterable, this.perfSessions_);
    }

    private void addPerfSessions(int i, com.google.firebase.perf.v1.PerfSession perfSession2) {
        perfSession2.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(i, perfSession2);
    }

    private void addPerfSessions(com.google.firebase.perf.v1.PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(perfSession);
    }

    private void clearClientStartTimeUs() {
        this.bitField0_ = bitField0_ &= -129;
        this.clientStartTimeUs_ = 0;
    }

    private void clearHttpMethod() {
        this.bitField0_ = bitField0_ &= -3;
        this.httpMethod_ = 0;
    }

    private void clearHttpResponseCode() {
        this.bitField0_ = bitField0_ &= -33;
        this.httpResponseCode_ = 0;
    }

    private void clearNetworkClientErrorReason() {
        this.bitField0_ = bitField0_ &= -17;
        this.networkClientErrorReason_ = 0;
    }

    private void clearPerfSessions() {
        this.perfSessions_ = z.emptyProtobufList();
    }

    private void clearRequestPayloadBytes() {
        this.bitField0_ = bitField0_ &= -5;
        this.requestPayloadBytes_ = 0;
    }

    private void clearResponseContentType() {
        this.bitField0_ = bitField0_ &= -65;
        this.responseContentType_ = NetworkRequestMetric.getDefaultInstance().getResponseContentType();
    }

    private void clearResponsePayloadBytes() {
        this.bitField0_ = bitField0_ &= -9;
        this.responsePayloadBytes_ = 0;
    }

    private void clearTimeToRequestCompletedUs() {
        this.bitField0_ = bitField0_ &= -257;
        this.timeToRequestCompletedUs_ = 0;
    }

    private void clearTimeToResponseCompletedUs() {
        this.bitField0_ = bitField0_ &= -1025;
        this.timeToResponseCompletedUs_ = 0;
    }

    private void clearTimeToResponseInitiatedUs() {
        this.bitField0_ = bitField0_ &= -513;
        this.timeToResponseInitiatedUs_ = 0;
    }

    private void clearUrl() {
        this.bitField0_ = bitField0_ &= -2;
        this.url_ = NetworkRequestMetric.getDefaultInstance().getUrl();
    }

    private void ensurePerfSessionsIsMutable() {
        c0.j perfSessions_;
        perfSessions_ = this.perfSessions_;
        if (!perfSessions_.c2()) {
            this.perfSessions_ = z.mutableCopy(perfSessions_);
        }
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric getDefaultInstance() {
        return NetworkRequestMetric.DEFAULT_INSTANCE;
    }

    private Map<String, String> getMutableCustomAttributesMap() {
        return internalGetMutableCustomAttributes();
    }

    private n0<String, String> internalGetCustomAttributes() {
        return this.customAttributes_;
    }

    private n0<String, String> internalGetMutableCustomAttributes() {
        boolean z;
        if (!this.customAttributes_.j()) {
            this.customAttributes_ = this.customAttributes_.m();
        }
        return this.customAttributes_;
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric.Builder newBuilder() {
        return (NetworkRequestMetric.Builder)NetworkRequestMetric.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric.Builder newBuilder(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        return (NetworkRequestMetric.Builder)NetworkRequestMetric.DEFAULT_INSTANCE.createBuilder(networkRequestMetric);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseDelimitedFrom(InputStream inputStream) {
        return (NetworkRequestMetric)z.parseDelimitedFrom(NetworkRequestMetric.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseDelimitedFrom(InputStream inputStream, q q2) {
        return (NetworkRequestMetric)z.parseDelimitedFrom(NetworkRequestMetric.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseFrom(j j) {
        return (NetworkRequestMetric)z.parseFrom(NetworkRequestMetric.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseFrom(j j, q q2) {
        return (NetworkRequestMetric)z.parseFrom(NetworkRequestMetric.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseFrom(k k) {
        return (NetworkRequestMetric)z.parseFrom(NetworkRequestMetric.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseFrom(k k, q q2) {
        return (NetworkRequestMetric)z.parseFrom(NetworkRequestMetric.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseFrom(InputStream inputStream) {
        return (NetworkRequestMetric)z.parseFrom(NetworkRequestMetric.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseFrom(InputStream inputStream, q q2) {
        return (NetworkRequestMetric)z.parseFrom(NetworkRequestMetric.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseFrom(ByteBuffer byteBuffer) {
        return (NetworkRequestMetric)z.parseFrom(NetworkRequestMetric.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseFrom(ByteBuffer byteBuffer, q q2) {
        return (NetworkRequestMetric)z.parseFrom(NetworkRequestMetric.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseFrom(byte[] bArr) {
        return (NetworkRequestMetric)z.parseFrom(NetworkRequestMetric.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.NetworkRequestMetric parseFrom(byte[] bArr, q q2) {
        return (NetworkRequestMetric)z.parseFrom(NetworkRequestMetric.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.NetworkRequestMetric> parser() {
        return NetworkRequestMetric.DEFAULT_INSTANCE.getParserForType();
    }

    private void removePerfSessions(int i) {
        ensurePerfSessionsIsMutable();
        this.perfSessions_.remove(i);
    }

    private void setClientStartTimeUs(long l) {
        this.bitField0_ = bitField0_ |= 128;
        this.clientStartTimeUs_ = l;
    }

    private void setHttpMethod(com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod networkRequestMetric$HttpMethod) {
        this.httpMethod_ = httpMethod.getNumber();
        this.bitField0_ = obj1 |= 2;
    }

    private void setHttpResponseCode(int i) {
        this.bitField0_ = bitField0_ |= 32;
        this.httpResponseCode_ = i;
    }

    private void setNetworkClientErrorReason(com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason networkRequestMetric$NetworkClientErrorReason) {
        this.networkClientErrorReason_ = networkClientErrorReason.getNumber();
        this.bitField0_ = obj1 |= 16;
    }

    private void setPerfSessions(int i, com.google.firebase.perf.v1.PerfSession perfSession2) {
        perfSession2.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.set(i, perfSession2);
    }

    private void setRequestPayloadBytes(long l) {
        this.bitField0_ = bitField0_ |= 4;
        this.requestPayloadBytes_ = l;
    }

    private void setResponseContentType(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 64;
        this.responseContentType_ = string;
    }

    private void setResponseContentTypeBytes(j j) {
        this.responseContentType_ = j.R();
        this.bitField0_ = obj1 |= 64;
    }

    private void setResponsePayloadBytes(long l) {
        this.bitField0_ = bitField0_ |= 8;
        this.responsePayloadBytes_ = l;
    }

    private void setTimeToRequestCompletedUs(long l) {
        this.bitField0_ = bitField0_ |= 256;
        this.timeToRequestCompletedUs_ = l;
    }

    private void setTimeToResponseCompletedUs(long l) {
        this.bitField0_ = bitField0_ |= 1024;
        this.timeToResponseCompletedUs_ = l;
    }

    private void setTimeToResponseInitiatedUs(long l) {
        this.bitField0_ = bitField0_ |= 512;
        this.timeToResponseInitiatedUs_ = l;
    }

    private void setUrl(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 1;
        this.url_ = string;
    }

    private void setUrlBytes(j j) {
        this.url_ = j.R();
        this.bitField0_ = obj1 |= 1;
    }

    @Override // com.google.protobuf.z
    public boolean containsCustomAttributes(String string) {
        string.getClass();
        return internalGetCustomAttributes().containsKey(string);
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
        d1 obj2;
        int obj3;
        int obj4;
        obj3 = 1;
        obj4 = 0;
        switch (obj2) {
            case 1:
                obj2 = new NetworkRequestMetric();
                return obj2;
            case 2:
                obj2 = new NetworkRequestMetric.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[18];
                obj2[obj3] = "url_";
                obj2[2] = "httpMethod_";
                obj2[3] = NetworkRequestMetric.HttpMethod.internalGetVerifier();
                obj2[4] = "requestPayloadBytes_";
                obj2[5] = "responsePayloadBytes_";
                obj2[6] = "httpResponseCode_";
                obj2[7] = "responseContentType_";
                obj2[8] = "clientStartTimeUs_";
                obj2[9] = "timeToRequestCompletedUs_";
                obj2[10] = "timeToResponseInitiatedUs_";
                obj2[11] = "timeToResponseCompletedUs_";
                obj2[12] = "networkClientErrorReason_";
                obj2[13] = NetworkRequestMetric.NetworkClientErrorReason.internalGetVerifier();
                obj2[14] = "customAttributes_";
                obj2[15] = NetworkRequestMetric.CustomAttributesDefaultEntryHolder.defaultEntry;
                obj2[16] = "perfSessions_";
                obj2[17] = PerfSession.class;
                return z.newMessageInfo(NetworkRequestMetric.DEFAULT_INSTANCE, "\u0001\r\u0000\u0001\u0001\r\r\u0001\u0001\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005င\u0005\u0006ဈ\u0006\u0007ဂ\u0007\u0008ဂ\u0008\tဂ\t\nဂ\n\u000bဌ\u0004\u000c2\r\u001b", obj2);
            case 4:
                return NetworkRequestMetric.DEFAULT_INSTANCE;
            case 5:
                return obj2;
            case 6:
                return Byte.valueOf(obj3);
            case 7:
                return obj4;
            default:
                obj2 = new UnsupportedOperationException();
                throw obj2;
        }
        obj3 = NetworkRequestMetric.class;
        synchronized (obj3) {
            obj2 = new z.b(NetworkRequestMetric.DEFAULT_INSTANCE);
            NetworkRequestMetric.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public long getClientStartTimeUs() {
        return this.clientStartTimeUs_;
    }

    @Deprecated
    public Map<String, String> getCustomAttributes() {
        return getCustomAttributesMap();
    }

    @Override // com.google.protobuf.z
    public int getCustomAttributesCount() {
        return internalGetCustomAttributes().size();
    }

    public Map<String, String> getCustomAttributesMap() {
        return Collections.unmodifiableMap(internalGetCustomAttributes());
    }

    @Override // com.google.protobuf.z
    public String getCustomAttributesOrDefault(String string, String string2) {
        Object obj3;
        Object obj4;
        string.getClass();
        final n0 internalGetCustomAttributes = internalGetCustomAttributes();
        if (internalGetCustomAttributes.containsKey(string)) {
            obj4 = obj3;
        }
        return obj4;
    }

    @Override // com.google.protobuf.z
    public String getCustomAttributesOrThrow(String string) {
        string.getClass();
        final n0 internalGetCustomAttributes = internalGetCustomAttributes();
        if (!internalGetCustomAttributes.containsKey(string)) {
        } else {
            return (String)internalGetCustomAttributes.get(string);
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod getHttpMethod() {
        com.google.firebase.perf.v1.NetworkRequestMetric.HttpMethod hTTP_METHOD_UNKNOWN;
        if (NetworkRequestMetric.HttpMethod.forNumber(this.httpMethod_) == null) {
            hTTP_METHOD_UNKNOWN = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
        }
        return hTTP_METHOD_UNKNOWN;
    }

    @Override // com.google.protobuf.z
    public int getHttpResponseCode() {
        return this.httpResponseCode_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason getNetworkClientErrorReason() {
        com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason nETWORK_CLIENT_ERROR_REASON_UNKNOWN;
        if (NetworkRequestMetric.NetworkClientErrorReason.forNumber(this.networkClientErrorReason_) == null) {
            nETWORK_CLIENT_ERROR_REASON_UNKNOWN = NetworkRequestMetric.NetworkClientErrorReason.NETWORK_CLIENT_ERROR_REASON_UNKNOWN;
        }
        return nETWORK_CLIENT_ERROR_REASON_UNKNOWN;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.PerfSession getPerfSessions(int i) {
        return (PerfSession)this.perfSessions_.get(i);
    }

    @Override // com.google.protobuf.z
    public int getPerfSessionsCount() {
        return this.perfSessions_.size();
    }

    public List<com.google.firebase.perf.v1.PerfSession> getPerfSessionsList() {
        return this.perfSessions_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.PerfSessionOrBuilder getPerfSessionsOrBuilder(int i) {
        return (PerfSessionOrBuilder)this.perfSessions_.get(i);
    }

    public List<? extends com.google.firebase.perf.v1.PerfSessionOrBuilder> getPerfSessionsOrBuilderList() {
        return this.perfSessions_;
    }

    @Override // com.google.protobuf.z
    public long getRequestPayloadBytes() {
        return this.requestPayloadBytes_;
    }

    @Override // com.google.protobuf.z
    public String getResponseContentType() {
        return this.responseContentType_;
    }

    @Override // com.google.protobuf.z
    public j getResponseContentTypeBytes() {
        return j.u(this.responseContentType_);
    }

    @Override // com.google.protobuf.z
    public long getResponsePayloadBytes() {
        return this.responsePayloadBytes_;
    }

    @Override // com.google.protobuf.z
    public long getTimeToRequestCompletedUs() {
        return this.timeToRequestCompletedUs_;
    }

    @Override // com.google.protobuf.z
    public long getTimeToResponseCompletedUs() {
        return this.timeToResponseCompletedUs_;
    }

    @Override // com.google.protobuf.z
    public long getTimeToResponseInitiatedUs() {
        return this.timeToResponseInitiatedUs_;
    }

    @Override // com.google.protobuf.z
    public String getUrl() {
        return this.url_;
    }

    @Override // com.google.protobuf.z
    public j getUrlBytes() {
        return j.u(this.url_);
    }

    @Override // com.google.protobuf.z
    public boolean hasClientStartTimeUs() {
        int i;
        i = bitField0_ &= 128 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasHttpMethod() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasHttpResponseCode() {
        int i;
        i = bitField0_ &= 32 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasNetworkClientErrorReason() {
        int i;
        i = bitField0_ &= 16 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasRequestPayloadBytes() {
        int i;
        i = bitField0_ &= 4 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasResponseContentType() {
        int i;
        i = bitField0_ &= 64 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasResponsePayloadBytes() {
        int i;
        i = bitField0_ &= 8 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasTimeToRequestCompletedUs() {
        int i;
        i = bitField0_ &= 256 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasTimeToResponseCompletedUs() {
        int i;
        i = bitField0_ &= 1024 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasTimeToResponseInitiatedUs() {
        int i;
        i = bitField0_ &= 512 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasUrl() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }
}
