package com.google.firebase.perf.v1;

import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.q;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class PerfMetric extends z<com.google.firebase.perf.v1.PerfMetric, com.google.firebase.perf.v1.PerfMetric.Builder> implements com.google.firebase.perf.v1.PerfMetricOrBuilder {

    public static final int APPLICATION_INFO_FIELD_NUMBER = 1;
    private static final com.google.firebase.perf.v1.PerfMetric DEFAULT_INSTANCE = null;
    public static final int GAUGE_METRIC_FIELD_NUMBER = 4;
    public static final int NETWORK_REQUEST_METRIC_FIELD_NUMBER = 3;
    private static volatile d1<com.google.firebase.perf.v1.PerfMetric> PARSER = null;
    public static final int TRACE_METRIC_FIELD_NUMBER = 2;
    public static final int TRANSPORT_INFO_FIELD_NUMBER = 5;
    private com.google.firebase.perf.v1.ApplicationInfo applicationInfo_;
    private int bitField0_;
    private com.google.firebase.perf.v1.GaugeMetric gaugeMetric_;
    private com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric_;
    private com.google.firebase.perf.v1.TraceMetric traceMetric_;
    private com.google.firebase.perf.v1.TransportInfo transportInfo_;

    public static final class Builder extends z.a<com.google.firebase.perf.v1.PerfMetric, com.google.firebase.perf.v1.PerfMetric.Builder> implements com.google.firebase.perf.v1.PerfMetricOrBuilder {
        private Builder() {
            super(PerfMetric.access$000());
        }

        Builder(com.google.firebase.perf.v1.PerfMetric.1 perfMetric$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder clearApplicationInfo() {
            copyOnWrite();
            PerfMetric.access$300((PerfMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder clearGaugeMetric() {
            copyOnWrite();
            PerfMetric.access$1200((PerfMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder clearNetworkRequestMetric() {
            copyOnWrite();
            PerfMetric.access$900((PerfMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder clearTraceMetric() {
            copyOnWrite();
            PerfMetric.access$600((PerfMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder clearTransportInfo() {
            copyOnWrite();
            PerfMetric.access$1500((PerfMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo getApplicationInfo() {
            return (PerfMetric)this.instance.getApplicationInfo();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric getGaugeMetric() {
            return (PerfMetric)this.instance.getGaugeMetric();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkRequestMetric getNetworkRequestMetric() {
            return (PerfMetric)this.instance.getNetworkRequestMetric();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric getTraceMetric() {
            return (PerfMetric)this.instance.getTraceMetric();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TransportInfo getTransportInfo() {
            return (PerfMetric)this.instance.getTransportInfo();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasApplicationInfo() {
            return (PerfMetric)this.instance.hasApplicationInfo();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasGaugeMetric() {
            return (PerfMetric)this.instance.hasGaugeMetric();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasNetworkRequestMetric() {
            return (PerfMetric)this.instance.hasNetworkRequestMetric();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasTraceMetric() {
            return (PerfMetric)this.instance.hasTraceMetric();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasTransportInfo() {
            return (PerfMetric)this.instance.hasTransportInfo();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder mergeApplicationInfo(com.google.firebase.perf.v1.ApplicationInfo applicationInfo) {
            copyOnWrite();
            PerfMetric.access$200((PerfMetric)this.instance, applicationInfo);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder mergeGaugeMetric(com.google.firebase.perf.v1.GaugeMetric gaugeMetric) {
            copyOnWrite();
            PerfMetric.access$1100((PerfMetric)this.instance, gaugeMetric);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder mergeNetworkRequestMetric(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
            copyOnWrite();
            PerfMetric.access$800((PerfMetric)this.instance, networkRequestMetric);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder mergeTraceMetric(com.google.firebase.perf.v1.TraceMetric traceMetric) {
            copyOnWrite();
            PerfMetric.access$500((PerfMetric)this.instance, traceMetric);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder mergeTransportInfo(com.google.firebase.perf.v1.TransportInfo transportInfo) {
            copyOnWrite();
            PerfMetric.access$1400((PerfMetric)this.instance, transportInfo);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder setApplicationInfo(com.google.firebase.perf.v1.ApplicationInfo.Builder applicationInfo$Builder) {
            copyOnWrite();
            PerfMetric.access$100((PerfMetric)this.instance, (ApplicationInfo)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder setApplicationInfo(com.google.firebase.perf.v1.ApplicationInfo applicationInfo) {
            copyOnWrite();
            PerfMetric.access$100((PerfMetric)this.instance, applicationInfo);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder setGaugeMetric(com.google.firebase.perf.v1.GaugeMetric.Builder gaugeMetric$Builder) {
            copyOnWrite();
            PerfMetric.access$1000((PerfMetric)this.instance, (GaugeMetric)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder setGaugeMetric(com.google.firebase.perf.v1.GaugeMetric gaugeMetric) {
            copyOnWrite();
            PerfMetric.access$1000((PerfMetric)this.instance, gaugeMetric);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder setNetworkRequestMetric(com.google.firebase.perf.v1.NetworkRequestMetric.Builder networkRequestMetric$Builder) {
            copyOnWrite();
            PerfMetric.access$700((PerfMetric)this.instance, (NetworkRequestMetric)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder setNetworkRequestMetric(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
            copyOnWrite();
            PerfMetric.access$700((PerfMetric)this.instance, networkRequestMetric);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder setTraceMetric(com.google.firebase.perf.v1.TraceMetric.Builder traceMetric$Builder) {
            copyOnWrite();
            PerfMetric.access$400((PerfMetric)this.instance, (TraceMetric)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder setTraceMetric(com.google.firebase.perf.v1.TraceMetric traceMetric) {
            copyOnWrite();
            PerfMetric.access$400((PerfMetric)this.instance, traceMetric);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder setTransportInfo(com.google.firebase.perf.v1.TransportInfo.Builder transportInfo$Builder) {
            copyOnWrite();
            PerfMetric.access$1300((PerfMetric)this.instance, (TransportInfo)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfMetric.Builder setTransportInfo(com.google.firebase.perf.v1.TransportInfo transportInfo) {
            copyOnWrite();
            PerfMetric.access$1300((PerfMetric)this.instance, transportInfo);
            return this;
        }
    }
    static {
        PerfMetric perfMetric = new PerfMetric();
        PerfMetric.DEFAULT_INSTANCE = perfMetric;
        z.registerDefaultInstance(PerfMetric.class, perfMetric);
    }

    static com.google.firebase.perf.v1.PerfMetric access$000() {
        return PerfMetric.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.PerfMetric perfMetric, com.google.firebase.perf.v1.ApplicationInfo applicationInfo2) {
        perfMetric.setApplicationInfo(applicationInfo2);
    }

    static void access$1000(com.google.firebase.perf.v1.PerfMetric perfMetric, com.google.firebase.perf.v1.GaugeMetric gaugeMetric2) {
        perfMetric.setGaugeMetric(gaugeMetric2);
    }

    static void access$1100(com.google.firebase.perf.v1.PerfMetric perfMetric, com.google.firebase.perf.v1.GaugeMetric gaugeMetric2) {
        perfMetric.mergeGaugeMetric(gaugeMetric2);
    }

    static void access$1200(com.google.firebase.perf.v1.PerfMetric perfMetric) {
        perfMetric.clearGaugeMetric();
    }

    static void access$1300(com.google.firebase.perf.v1.PerfMetric perfMetric, com.google.firebase.perf.v1.TransportInfo transportInfo2) {
        perfMetric.setTransportInfo(transportInfo2);
    }

    static void access$1400(com.google.firebase.perf.v1.PerfMetric perfMetric, com.google.firebase.perf.v1.TransportInfo transportInfo2) {
        perfMetric.mergeTransportInfo(transportInfo2);
    }

    static void access$1500(com.google.firebase.perf.v1.PerfMetric perfMetric) {
        perfMetric.clearTransportInfo();
    }

    static void access$200(com.google.firebase.perf.v1.PerfMetric perfMetric, com.google.firebase.perf.v1.ApplicationInfo applicationInfo2) {
        perfMetric.mergeApplicationInfo(applicationInfo2);
    }

    static void access$300(com.google.firebase.perf.v1.PerfMetric perfMetric) {
        perfMetric.clearApplicationInfo();
    }

    static void access$400(com.google.firebase.perf.v1.PerfMetric perfMetric, com.google.firebase.perf.v1.TraceMetric traceMetric2) {
        perfMetric.setTraceMetric(traceMetric2);
    }

    static void access$500(com.google.firebase.perf.v1.PerfMetric perfMetric, com.google.firebase.perf.v1.TraceMetric traceMetric2) {
        perfMetric.mergeTraceMetric(traceMetric2);
    }

    static void access$600(com.google.firebase.perf.v1.PerfMetric perfMetric) {
        perfMetric.clearTraceMetric();
    }

    static void access$700(com.google.firebase.perf.v1.PerfMetric perfMetric, com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric2) {
        perfMetric.setNetworkRequestMetric(networkRequestMetric2);
    }

    static void access$800(com.google.firebase.perf.v1.PerfMetric perfMetric, com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric2) {
        perfMetric.mergeNetworkRequestMetric(networkRequestMetric2);
    }

    static void access$900(com.google.firebase.perf.v1.PerfMetric perfMetric) {
        perfMetric.clearNetworkRequestMetric();
    }

    private void clearApplicationInfo() {
        this.applicationInfo_ = 0;
        this.bitField0_ = bitField0_ &= -2;
    }

    private void clearGaugeMetric() {
        this.gaugeMetric_ = 0;
        this.bitField0_ = bitField0_ &= -9;
    }

    private void clearNetworkRequestMetric() {
        this.networkRequestMetric_ = 0;
        this.bitField0_ = bitField0_ &= -5;
    }

    private void clearTraceMetric() {
        this.traceMetric_ = 0;
        this.bitField0_ = bitField0_ &= -3;
    }

    private void clearTransportInfo() {
        this.transportInfo_ = 0;
        this.bitField0_ = bitField0_ &= -17;
    }

    public static com.google.firebase.perf.v1.PerfMetric getDefaultInstance() {
        return PerfMetric.DEFAULT_INSTANCE;
    }

    private void mergeApplicationInfo(com.google.firebase.perf.v1.ApplicationInfo applicationInfo) {
        Object applicationInfo_;
        com.google.firebase.perf.v1.ApplicationInfo defaultInstance;
        z obj3;
        applicationInfo.getClass();
        applicationInfo_ = this.applicationInfo_;
        if (applicationInfo_ != null && applicationInfo_ != ApplicationInfo.getDefaultInstance()) {
            if (applicationInfo_ != ApplicationInfo.getDefaultInstance()) {
                this.applicationInfo_ = (ApplicationInfo)(ApplicationInfo.Builder)ApplicationInfo.newBuilder(this.applicationInfo_).mergeFrom(applicationInfo).buildPartial();
            } else {
                this.applicationInfo_ = applicationInfo;
            }
        } else {
        }
        this.bitField0_ = obj3 |= 1;
    }

    private void mergeGaugeMetric(com.google.firebase.perf.v1.GaugeMetric gaugeMetric) {
        Object gaugeMetric_;
        com.google.firebase.perf.v1.GaugeMetric defaultInstance;
        z obj3;
        gaugeMetric.getClass();
        gaugeMetric_ = this.gaugeMetric_;
        if (gaugeMetric_ != null && gaugeMetric_ != GaugeMetric.getDefaultInstance()) {
            if (gaugeMetric_ != GaugeMetric.getDefaultInstance()) {
                this.gaugeMetric_ = (GaugeMetric)(GaugeMetric.Builder)GaugeMetric.newBuilder(this.gaugeMetric_).mergeFrom(gaugeMetric).buildPartial();
            } else {
                this.gaugeMetric_ = gaugeMetric;
            }
        } else {
        }
        this.bitField0_ = obj3 |= 8;
    }

    private void mergeNetworkRequestMetric(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        Object networkRequestMetric_;
        com.google.firebase.perf.v1.NetworkRequestMetric defaultInstance;
        z obj3;
        networkRequestMetric.getClass();
        networkRequestMetric_ = this.networkRequestMetric_;
        if (networkRequestMetric_ != null && networkRequestMetric_ != NetworkRequestMetric.getDefaultInstance()) {
            if (networkRequestMetric_ != NetworkRequestMetric.getDefaultInstance()) {
                this.networkRequestMetric_ = (NetworkRequestMetric)(NetworkRequestMetric.Builder)NetworkRequestMetric.newBuilder(this.networkRequestMetric_).mergeFrom(networkRequestMetric).buildPartial();
            } else {
                this.networkRequestMetric_ = networkRequestMetric;
            }
        } else {
        }
        this.bitField0_ = obj3 |= 4;
    }

    private void mergeTraceMetric(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        Object traceMetric_;
        com.google.firebase.perf.v1.TraceMetric defaultInstance;
        z obj3;
        traceMetric.getClass();
        traceMetric_ = this.traceMetric_;
        if (traceMetric_ != null && traceMetric_ != TraceMetric.getDefaultInstance()) {
            if (traceMetric_ != TraceMetric.getDefaultInstance()) {
                this.traceMetric_ = (TraceMetric)(TraceMetric.Builder)TraceMetric.newBuilder(this.traceMetric_).mergeFrom(traceMetric).buildPartial();
            } else {
                this.traceMetric_ = traceMetric;
            }
        } else {
        }
        this.bitField0_ = obj3 |= 2;
    }

    private void mergeTransportInfo(com.google.firebase.perf.v1.TransportInfo transportInfo) {
        Object transportInfo_;
        com.google.firebase.perf.v1.TransportInfo defaultInstance;
        z obj3;
        transportInfo.getClass();
        transportInfo_ = this.transportInfo_;
        if (transportInfo_ != null && transportInfo_ != TransportInfo.getDefaultInstance()) {
            if (transportInfo_ != TransportInfo.getDefaultInstance()) {
                this.transportInfo_ = (TransportInfo)(TransportInfo.Builder)TransportInfo.newBuilder(this.transportInfo_).mergeFrom(transportInfo).buildPartial();
            } else {
                this.transportInfo_ = transportInfo;
            }
        } else {
        }
        this.bitField0_ = obj3 |= 16;
    }

    public static com.google.firebase.perf.v1.PerfMetric.Builder newBuilder() {
        return (PerfMetric.Builder)PerfMetric.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.PerfMetric.Builder newBuilder(com.google.firebase.perf.v1.PerfMetric perfMetric) {
        return (PerfMetric.Builder)PerfMetric.DEFAULT_INSTANCE.createBuilder(perfMetric);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseDelimitedFrom(InputStream inputStream) {
        return (PerfMetric)z.parseDelimitedFrom(PerfMetric.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseDelimitedFrom(InputStream inputStream, q q2) {
        return (PerfMetric)z.parseDelimitedFrom(PerfMetric.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseFrom(j j) {
        return (PerfMetric)z.parseFrom(PerfMetric.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseFrom(j j, q q2) {
        return (PerfMetric)z.parseFrom(PerfMetric.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseFrom(k k) {
        return (PerfMetric)z.parseFrom(PerfMetric.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseFrom(k k, q q2) {
        return (PerfMetric)z.parseFrom(PerfMetric.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseFrom(InputStream inputStream) {
        return (PerfMetric)z.parseFrom(PerfMetric.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseFrom(InputStream inputStream, q q2) {
        return (PerfMetric)z.parseFrom(PerfMetric.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseFrom(ByteBuffer byteBuffer) {
        return (PerfMetric)z.parseFrom(PerfMetric.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseFrom(ByteBuffer byteBuffer, q q2) {
        return (PerfMetric)z.parseFrom(PerfMetric.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseFrom(byte[] bArr) {
        return (PerfMetric)z.parseFrom(PerfMetric.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.PerfMetric parseFrom(byte[] bArr, q q2) {
        return (PerfMetric)z.parseFrom(PerfMetric.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.PerfMetric> parser() {
        return PerfMetric.DEFAULT_INSTANCE.getParserForType();
    }

    private void setApplicationInfo(com.google.firebase.perf.v1.ApplicationInfo applicationInfo) {
        applicationInfo.getClass();
        this.applicationInfo_ = applicationInfo;
        this.bitField0_ = obj1 |= 1;
    }

    private void setGaugeMetric(com.google.firebase.perf.v1.GaugeMetric gaugeMetric) {
        gaugeMetric.getClass();
        this.gaugeMetric_ = gaugeMetric;
        this.bitField0_ = obj1 |= 8;
    }

    private void setNetworkRequestMetric(com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric) {
        networkRequestMetric.getClass();
        this.networkRequestMetric_ = networkRequestMetric;
        this.bitField0_ = obj1 |= 4;
    }

    private void setTraceMetric(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        traceMetric.getClass();
        this.traceMetric_ = traceMetric;
        this.bitField0_ = obj1 |= 2;
    }

    private void setTransportInfo(com.google.firebase.perf.v1.TransportInfo transportInfo) {
        transportInfo.getClass();
        this.transportInfo_ = transportInfo;
        this.bitField0_ = obj1 |= 16;
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
                obj2 = new PerfMetric();
                return obj2;
            case 2:
                obj2 = new PerfMetric.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[6];
                obj2[obj3] = "applicationInfo_";
                obj2[2] = "traceMetric_";
                obj2[3] = "networkRequestMetric_";
                obj2[4] = "gaugeMetric_";
                obj2[5] = "transportInfo_";
                return z.newMessageInfo(PerfMetric.DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", obj2);
            case 4:
                return PerfMetric.DEFAULT_INSTANCE;
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
        obj3 = PerfMetric.class;
        synchronized (obj3) {
            obj2 = new z.b(PerfMetric.DEFAULT_INSTANCE);
            PerfMetric.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.ApplicationInfo getApplicationInfo() {
        com.google.firebase.perf.v1.ApplicationInfo applicationInfo_;
        if (this.applicationInfo_ == null) {
            applicationInfo_ = ApplicationInfo.getDefaultInstance();
        }
        return applicationInfo_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.GaugeMetric getGaugeMetric() {
        com.google.firebase.perf.v1.GaugeMetric defaultInstance;
        if (this.gaugeMetric_ == null) {
            defaultInstance = GaugeMetric.getDefaultInstance();
        }
        return defaultInstance;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.NetworkRequestMetric getNetworkRequestMetric() {
        com.google.firebase.perf.v1.NetworkRequestMetric networkRequestMetric_;
        if (this.networkRequestMetric_ == null) {
            networkRequestMetric_ = NetworkRequestMetric.getDefaultInstance();
        }
        return networkRequestMetric_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.TraceMetric getTraceMetric() {
        com.google.firebase.perf.v1.TraceMetric defaultInstance;
        if (this.traceMetric_ == null) {
            defaultInstance = TraceMetric.getDefaultInstance();
        }
        return defaultInstance;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.TransportInfo getTransportInfo() {
        com.google.firebase.perf.v1.TransportInfo defaultInstance;
        if (this.transportInfo_ == null) {
            defaultInstance = TransportInfo.getDefaultInstance();
        }
        return defaultInstance;
    }

    @Override // com.google.protobuf.z
    public boolean hasApplicationInfo() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasGaugeMetric() {
        int i;
        i = bitField0_ &= 8 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasNetworkRequestMetric() {
        int i;
        i = bitField0_ &= 4 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasTraceMetric() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasTransportInfo() {
        int i;
        i = bitField0_ &= 16 != 0 ? 1 : 0;
        return i;
    }
}
