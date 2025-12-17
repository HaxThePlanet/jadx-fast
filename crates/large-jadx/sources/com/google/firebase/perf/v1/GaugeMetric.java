package com.google.firebase.perf.v1;

import android.accounts.Account;
import com.google.protobuf.a;
import com.google.protobuf.c0.j;
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
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class GaugeMetric extends z<com.google.firebase.perf.v1.GaugeMetric, com.google.firebase.perf.v1.GaugeMetric.Builder> implements com.google.firebase.perf.v1.GaugeMetricOrBuilder {

    public static final int ANDROID_MEMORY_READINGS_FIELD_NUMBER = 4;
    public static final int CPU_METRIC_READINGS_FIELD_NUMBER = 2;
    private static final com.google.firebase.perf.v1.GaugeMetric DEFAULT_INSTANCE = null;
    public static final int GAUGE_METADATA_FIELD_NUMBER = 3;
    private static volatile d1<com.google.firebase.perf.v1.GaugeMetric> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private c0.j<com.google.firebase.perf.v1.AndroidMemoryReading> androidMemoryReadings_;
    private int bitField0_;
    private c0.j<com.google.firebase.perf.v1.CpuMetricReading> cpuMetricReadings_;
    private com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata_;
    private String sessionId_;

    public static final class Builder extends z.a<com.google.firebase.perf.v1.GaugeMetric, com.google.firebase.perf.v1.GaugeMetric.Builder> implements com.google.firebase.perf.v1.GaugeMetricOrBuilder {
        private Builder() {
            super(GaugeMetric.access$000());
        }

        Builder(com.google.firebase.perf.v1.GaugeMetric.1 gaugeMetric$1) {
            super();
        }

        public com.google.firebase.perf.v1.GaugeMetric.Builder addAllAndroidMemoryReadings(Iterable<? extends com.google.firebase.perf.v1.AndroidMemoryReading> iterable) {
            copyOnWrite();
            GaugeMetric.access$1600((GaugeMetric)this.instance, iterable);
            return this;
        }

        public com.google.firebase.perf.v1.GaugeMetric.Builder addAllCpuMetricReadings(Iterable<? extends com.google.firebase.perf.v1.CpuMetricReading> iterable) {
            copyOnWrite();
            GaugeMetric.access$1000((GaugeMetric)this.instance, iterable);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder addAndroidMemoryReadings(int i, com.google.firebase.perf.v1.AndroidMemoryReading.Builder androidMemoryReading$Builder2) {
            copyOnWrite();
            GaugeMetric.access$1500((GaugeMetric)this.instance, i, (AndroidMemoryReading)builder2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder addAndroidMemoryReadings(int i, com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading2) {
            copyOnWrite();
            GaugeMetric.access$1500((GaugeMetric)this.instance, i, androidMemoryReading2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder addAndroidMemoryReadings(com.google.firebase.perf.v1.AndroidMemoryReading.Builder androidMemoryReading$Builder) {
            copyOnWrite();
            GaugeMetric.access$1400((GaugeMetric)this.instance, (AndroidMemoryReading)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder addAndroidMemoryReadings(com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading) {
            copyOnWrite();
            GaugeMetric.access$1400((GaugeMetric)this.instance, androidMemoryReading);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder addCpuMetricReadings(int i, com.google.firebase.perf.v1.CpuMetricReading.Builder cpuMetricReading$Builder2) {
            copyOnWrite();
            GaugeMetric.access$900((GaugeMetric)this.instance, i, (CpuMetricReading)builder2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder addCpuMetricReadings(int i, com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading2) {
            copyOnWrite();
            GaugeMetric.access$900((GaugeMetric)this.instance, i, cpuMetricReading2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder addCpuMetricReadings(com.google.firebase.perf.v1.CpuMetricReading.Builder cpuMetricReading$Builder) {
            copyOnWrite();
            GaugeMetric.access$800((GaugeMetric)this.instance, (CpuMetricReading)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder addCpuMetricReadings(com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading) {
            copyOnWrite();
            GaugeMetric.access$800((GaugeMetric)this.instance, cpuMetricReading);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder clearAndroidMemoryReadings() {
            copyOnWrite();
            GaugeMetric.access$1700((GaugeMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder clearCpuMetricReadings() {
            copyOnWrite();
            GaugeMetric.access$1100((GaugeMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder clearGaugeMetadata() {
            copyOnWrite();
            GaugeMetric.access$600((GaugeMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder clearSessionId() {
            copyOnWrite();
            GaugeMetric.access$200((GaugeMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidMemoryReading getAndroidMemoryReadings(int i) {
            return (GaugeMetric)this.instance.getAndroidMemoryReadings(i);
        }

        @Override // com.google.protobuf.z$a
        public int getAndroidMemoryReadingsCount() {
            return (GaugeMetric)this.instance.getAndroidMemoryReadingsCount();
        }

        public List<com.google.firebase.perf.v1.AndroidMemoryReading> getAndroidMemoryReadingsList() {
            return Collections.unmodifiableList((GaugeMetric)this.instance.getAndroidMemoryReadingsList());
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.CpuMetricReading getCpuMetricReadings(int i) {
            return (GaugeMetric)this.instance.getCpuMetricReadings(i);
        }

        @Override // com.google.protobuf.z$a
        public int getCpuMetricReadingsCount() {
            return (GaugeMetric)this.instance.getCpuMetricReadingsCount();
        }

        public List<com.google.firebase.perf.v1.CpuMetricReading> getCpuMetricReadingsList() {
            return Collections.unmodifiableList((GaugeMetric)this.instance.getCpuMetricReadingsList());
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata getGaugeMetadata() {
            return (GaugeMetric)this.instance.getGaugeMetadata();
        }

        @Override // com.google.protobuf.z$a
        public String getSessionId() {
            return (GaugeMetric)this.instance.getSessionId();
        }

        @Override // com.google.protobuf.z$a
        public j getSessionIdBytes() {
            return (GaugeMetric)this.instance.getSessionIdBytes();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasGaugeMetadata() {
            return (GaugeMetric)this.instance.hasGaugeMetadata();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasSessionId() {
            return (GaugeMetric)this.instance.hasSessionId();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder mergeGaugeMetadata(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata) {
            copyOnWrite();
            GaugeMetric.access$500((GaugeMetric)this.instance, gaugeMetadata);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder removeAndroidMemoryReadings(int i) {
            copyOnWrite();
            GaugeMetric.access$1800((GaugeMetric)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder removeCpuMetricReadings(int i) {
            copyOnWrite();
            GaugeMetric.access$1200((GaugeMetric)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder setAndroidMemoryReadings(int i, com.google.firebase.perf.v1.AndroidMemoryReading.Builder androidMemoryReading$Builder2) {
            copyOnWrite();
            GaugeMetric.access$1300((GaugeMetric)this.instance, i, (AndroidMemoryReading)builder2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder setAndroidMemoryReadings(int i, com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading2) {
            copyOnWrite();
            GaugeMetric.access$1300((GaugeMetric)this.instance, i, androidMemoryReading2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder setCpuMetricReadings(int i, com.google.firebase.perf.v1.CpuMetricReading.Builder cpuMetricReading$Builder2) {
            copyOnWrite();
            GaugeMetric.access$700((GaugeMetric)this.instance, i, (CpuMetricReading)builder2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder setCpuMetricReadings(int i, com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading2) {
            copyOnWrite();
            GaugeMetric.access$700((GaugeMetric)this.instance, i, cpuMetricReading2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder setGaugeMetadata(com.google.firebase.perf.v1.GaugeMetadata.Builder gaugeMetadata$Builder) {
            copyOnWrite();
            GaugeMetric.access$400((GaugeMetric)this.instance, (GaugeMetadata)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder setGaugeMetadata(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata) {
            copyOnWrite();
            GaugeMetric.access$400((GaugeMetric)this.instance, gaugeMetadata);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder setSessionId(String string) {
            copyOnWrite();
            GaugeMetric.access$100((GaugeMetric)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetric.Builder setSessionIdBytes(j j) {
            copyOnWrite();
            GaugeMetric.access$300((GaugeMetric)this.instance, j);
            return this;
        }
    }
    static {
        GaugeMetric gaugeMetric = new GaugeMetric();
        GaugeMetric.DEFAULT_INSTANCE = gaugeMetric;
        z.registerDefaultInstance(GaugeMetric.class, gaugeMetric);
    }

    private GaugeMetric() {
        super();
        this.sessionId_ = "";
        this.cpuMetricReadings_ = z.emptyProtobufList();
        this.androidMemoryReadings_ = z.emptyProtobufList();
    }

    static com.google.firebase.perf.v1.GaugeMetric access$000() {
        return GaugeMetric.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, String string2) {
        gaugeMetric.setSessionId(string2);
    }

    static void access$1000(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, Iterable iterable2) {
        gaugeMetric.addAllCpuMetricReadings(iterable2);
    }

    static void access$1100(com.google.firebase.perf.v1.GaugeMetric gaugeMetric) {
        gaugeMetric.clearCpuMetricReadings();
    }

    static void access$1200(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, int i2) {
        gaugeMetric.removeCpuMetricReadings(i2);
    }

    static void access$1300(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, int i2, com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading3) {
        gaugeMetric.setAndroidMemoryReadings(i2, androidMemoryReading3);
    }

    static void access$1400(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading2) {
        gaugeMetric.addAndroidMemoryReadings(androidMemoryReading2);
    }

    static void access$1500(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, int i2, com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading3) {
        gaugeMetric.addAndroidMemoryReadings(i2, androidMemoryReading3);
    }

    static void access$1600(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, Iterable iterable2) {
        gaugeMetric.addAllAndroidMemoryReadings(iterable2);
    }

    static void access$1700(com.google.firebase.perf.v1.GaugeMetric gaugeMetric) {
        gaugeMetric.clearAndroidMemoryReadings();
    }

    static void access$1800(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, int i2) {
        gaugeMetric.removeAndroidMemoryReadings(i2);
    }

    static void access$200(com.google.firebase.perf.v1.GaugeMetric gaugeMetric) {
        gaugeMetric.clearSessionId();
    }

    static void access$300(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, j j2) {
        gaugeMetric.setSessionIdBytes(j2);
    }

    static void access$400(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata2) {
        gaugeMetric.setGaugeMetadata(gaugeMetadata2);
    }

    static void access$500(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata2) {
        gaugeMetric.mergeGaugeMetadata(gaugeMetadata2);
    }

    static void access$600(com.google.firebase.perf.v1.GaugeMetric gaugeMetric) {
        gaugeMetric.clearGaugeMetadata();
    }

    static void access$700(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, int i2, com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading3) {
        gaugeMetric.setCpuMetricReadings(i2, cpuMetricReading3);
    }

    static void access$800(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading2) {
        gaugeMetric.addCpuMetricReadings(cpuMetricReading2);
    }

    static void access$900(com.google.firebase.perf.v1.GaugeMetric gaugeMetric, int i2, com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading3) {
        gaugeMetric.addCpuMetricReadings(i2, cpuMetricReading3);
    }

    private void addAllAndroidMemoryReadings(Iterable<? extends com.google.firebase.perf.v1.AndroidMemoryReading> iterable) {
        ensureAndroidMemoryReadingsIsMutable();
        a.addAll(iterable, this.androidMemoryReadings_);
    }

    private void addAllCpuMetricReadings(Iterable<? extends com.google.firebase.perf.v1.CpuMetricReading> iterable) {
        ensureCpuMetricReadingsIsMutable();
        a.addAll(iterable, this.cpuMetricReadings_);
    }

    private void addAndroidMemoryReadings(int i, com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading2) {
        androidMemoryReading2.getClass();
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.add(i, androidMemoryReading2);
    }

    private void addAndroidMemoryReadings(com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.getClass();
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.add(androidMemoryReading);
    }

    private void addCpuMetricReadings(int i, com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading2) {
        cpuMetricReading2.getClass();
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.add(i, cpuMetricReading2);
    }

    private void addCpuMetricReadings(com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading) {
        cpuMetricReading.getClass();
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.add(cpuMetricReading);
    }

    private void clearAndroidMemoryReadings() {
        this.androidMemoryReadings_ = z.emptyProtobufList();
    }

    private void clearCpuMetricReadings() {
        this.cpuMetricReadings_ = z.emptyProtobufList();
    }

    private void clearGaugeMetadata() {
        this.gaugeMetadata_ = 0;
        this.bitField0_ = bitField0_ &= -3;
    }

    private void clearSessionId() {
        this.bitField0_ = bitField0_ &= -2;
        this.sessionId_ = GaugeMetric.getDefaultInstance().getSessionId();
    }

    private void ensureAndroidMemoryReadingsIsMutable() {
        c0.j androidMemoryReadings_;
        androidMemoryReadings_ = this.androidMemoryReadings_;
        if (!androidMemoryReadings_.c2()) {
            this.androidMemoryReadings_ = z.mutableCopy(androidMemoryReadings_);
        }
    }

    private void ensureCpuMetricReadingsIsMutable() {
        c0.j cpuMetricReadings_;
        cpuMetricReadings_ = this.cpuMetricReadings_;
        if (!cpuMetricReadings_.c2()) {
            this.cpuMetricReadings_ = z.mutableCopy(cpuMetricReadings_);
        }
    }

    public static com.google.firebase.perf.v1.GaugeMetric getDefaultInstance() {
        return GaugeMetric.DEFAULT_INSTANCE;
    }

    private void mergeGaugeMetadata(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata) {
        Object gaugeMetadata_;
        com.google.firebase.perf.v1.GaugeMetadata defaultInstance;
        z obj3;
        gaugeMetadata.getClass();
        gaugeMetadata_ = this.gaugeMetadata_;
        if (gaugeMetadata_ != null && gaugeMetadata_ != GaugeMetadata.getDefaultInstance()) {
            if (gaugeMetadata_ != GaugeMetadata.getDefaultInstance()) {
                this.gaugeMetadata_ = (GaugeMetadata)(GaugeMetadata.Builder)GaugeMetadata.newBuilder(this.gaugeMetadata_).mergeFrom(gaugeMetadata).buildPartial();
            } else {
                this.gaugeMetadata_ = gaugeMetadata;
            }
        } else {
        }
        this.bitField0_ = obj3 |= 2;
    }

    public static com.google.firebase.perf.v1.GaugeMetric.Builder newBuilder() {
        return (GaugeMetric.Builder)GaugeMetric.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.GaugeMetric.Builder newBuilder(com.google.firebase.perf.v1.GaugeMetric gaugeMetric) {
        return (GaugeMetric.Builder)GaugeMetric.DEFAULT_INSTANCE.createBuilder(gaugeMetric);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseDelimitedFrom(InputStream inputStream) {
        return (GaugeMetric)z.parseDelimitedFrom(GaugeMetric.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseDelimitedFrom(InputStream inputStream, q q2) {
        return (GaugeMetric)z.parseDelimitedFrom(GaugeMetric.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseFrom(j j) {
        return (GaugeMetric)z.parseFrom(GaugeMetric.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseFrom(j j, q q2) {
        return (GaugeMetric)z.parseFrom(GaugeMetric.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseFrom(k k) {
        return (GaugeMetric)z.parseFrom(GaugeMetric.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseFrom(k k, q q2) {
        return (GaugeMetric)z.parseFrom(GaugeMetric.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseFrom(InputStream inputStream) {
        return (GaugeMetric)z.parseFrom(GaugeMetric.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseFrom(InputStream inputStream, q q2) {
        return (GaugeMetric)z.parseFrom(GaugeMetric.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseFrom(ByteBuffer byteBuffer) {
        return (GaugeMetric)z.parseFrom(GaugeMetric.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseFrom(ByteBuffer byteBuffer, q q2) {
        return (GaugeMetric)z.parseFrom(GaugeMetric.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseFrom(byte[] bArr) {
        return (GaugeMetric)z.parseFrom(GaugeMetric.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.GaugeMetric parseFrom(byte[] bArr, q q2) {
        return (GaugeMetric)z.parseFrom(GaugeMetric.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.GaugeMetric> parser() {
        return GaugeMetric.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAndroidMemoryReadings(int i) {
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.remove(i);
    }

    private void removeCpuMetricReadings(int i) {
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.remove(i);
    }

    private void setAndroidMemoryReadings(int i, com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading2) {
        androidMemoryReading2.getClass();
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.set(i, androidMemoryReading2);
    }

    private void setCpuMetricReadings(int i, com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading2) {
        cpuMetricReading2.getClass();
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.set(i, cpuMetricReading2);
    }

    private void setGaugeMetadata(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata) {
        gaugeMetadata.getClass();
        this.gaugeMetadata_ = gaugeMetadata;
        this.bitField0_ = obj1 |= 2;
    }

    private void setSessionId(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 1;
        this.sessionId_ = string;
    }

    private void setSessionIdBytes(j j) {
        this.sessionId_ = j.R();
        this.bitField0_ = obj1 |= 1;
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
                obj2 = new GaugeMetric();
                return obj2;
            case 2:
                obj2 = new GaugeMetric.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[7];
                obj2[obj3] = "sessionId_";
                obj2[2] = "cpuMetricReadings_";
                obj2[3] = CpuMetricReading.class;
                obj2[4] = "gaugeMetadata_";
                obj2[5] = "androidMemoryReadings_";
                obj2[6] = AndroidMemoryReading.class;
                return z.newMessageInfo(GaugeMetric.DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u001b", obj2);
            case 4:
                return GaugeMetric.DEFAULT_INSTANCE;
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
        obj3 = GaugeMetric.class;
        synchronized (obj3) {
            obj2 = new z.b(GaugeMetric.DEFAULT_INSTANCE);
            GaugeMetric.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.AndroidMemoryReading getAndroidMemoryReadings(int i) {
        return (AndroidMemoryReading)this.androidMemoryReadings_.get(i);
    }

    @Override // com.google.protobuf.z
    public int getAndroidMemoryReadingsCount() {
        return this.androidMemoryReadings_.size();
    }

    public List<com.google.firebase.perf.v1.AndroidMemoryReading> getAndroidMemoryReadingsList() {
        return this.androidMemoryReadings_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder getAndroidMemoryReadingsOrBuilder(int i) {
        return (AndroidMemoryReadingOrBuilder)this.androidMemoryReadings_.get(i);
    }

    public List<? extends com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder> getAndroidMemoryReadingsOrBuilderList() {
        return this.androidMemoryReadings_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.CpuMetricReading getCpuMetricReadings(int i) {
        return (CpuMetricReading)this.cpuMetricReadings_.get(i);
    }

    @Override // com.google.protobuf.z
    public int getCpuMetricReadingsCount() {
        return this.cpuMetricReadings_.size();
    }

    public List<com.google.firebase.perf.v1.CpuMetricReading> getCpuMetricReadingsList() {
        return this.cpuMetricReadings_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.CpuMetricReadingOrBuilder getCpuMetricReadingsOrBuilder(int i) {
        return (CpuMetricReadingOrBuilder)this.cpuMetricReadings_.get(i);
    }

    public List<? extends com.google.firebase.perf.v1.CpuMetricReadingOrBuilder> getCpuMetricReadingsOrBuilderList() {
        return this.cpuMetricReadings_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.GaugeMetadata getGaugeMetadata() {
        com.google.firebase.perf.v1.GaugeMetadata defaultInstance;
        if (this.gaugeMetadata_ == null) {
            defaultInstance = GaugeMetadata.getDefaultInstance();
        }
        return defaultInstance;
    }

    @Override // com.google.protobuf.z
    public String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.google.protobuf.z
    public j getSessionIdBytes() {
        return j.u(this.sessionId_);
    }

    @Override // com.google.protobuf.z
    public boolean hasGaugeMetadata() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasSessionId() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }
}
