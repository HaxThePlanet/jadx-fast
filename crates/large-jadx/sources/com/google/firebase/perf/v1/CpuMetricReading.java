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
public final class CpuMetricReading extends z<com.google.firebase.perf.v1.CpuMetricReading, com.google.firebase.perf.v1.CpuMetricReading.Builder> implements com.google.firebase.perf.v1.CpuMetricReadingOrBuilder {

    public static final int CLIENT_TIME_US_FIELD_NUMBER = 1;
    private static final com.google.firebase.perf.v1.CpuMetricReading DEFAULT_INSTANCE = null;
    private static volatile d1<com.google.firebase.perf.v1.CpuMetricReading> PARSER = null;
    public static final int SYSTEM_TIME_US_FIELD_NUMBER = 3;
    public static final int USER_TIME_US_FIELD_NUMBER = 2;
    private int bitField0_;
    private long clientTimeUs_;
    private long systemTimeUs_;
    private long userTimeUs_;

    public static final class Builder extends z.a<com.google.firebase.perf.v1.CpuMetricReading, com.google.firebase.perf.v1.CpuMetricReading.Builder> implements com.google.firebase.perf.v1.CpuMetricReadingOrBuilder {
        private Builder() {
            super(CpuMetricReading.access$000());
        }

        Builder(com.google.firebase.perf.v1.CpuMetricReading.1 cpuMetricReading$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.CpuMetricReading.Builder clearClientTimeUs() {
            copyOnWrite();
            CpuMetricReading.access$200((CpuMetricReading)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.CpuMetricReading.Builder clearSystemTimeUs() {
            copyOnWrite();
            CpuMetricReading.access$600((CpuMetricReading)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.CpuMetricReading.Builder clearUserTimeUs() {
            copyOnWrite();
            CpuMetricReading.access$400((CpuMetricReading)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public long getClientTimeUs() {
            return (CpuMetricReading)this.instance.getClientTimeUs();
        }

        @Override // com.google.protobuf.z$a
        public long getSystemTimeUs() {
            return (CpuMetricReading)this.instance.getSystemTimeUs();
        }

        @Override // com.google.protobuf.z$a
        public long getUserTimeUs() {
            return (CpuMetricReading)this.instance.getUserTimeUs();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasClientTimeUs() {
            return (CpuMetricReading)this.instance.hasClientTimeUs();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasSystemTimeUs() {
            return (CpuMetricReading)this.instance.hasSystemTimeUs();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasUserTimeUs() {
            return (CpuMetricReading)this.instance.hasUserTimeUs();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.CpuMetricReading.Builder setClientTimeUs(long l) {
            copyOnWrite();
            CpuMetricReading.access$100((CpuMetricReading)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.CpuMetricReading.Builder setSystemTimeUs(long l) {
            copyOnWrite();
            CpuMetricReading.access$500((CpuMetricReading)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.CpuMetricReading.Builder setUserTimeUs(long l) {
            copyOnWrite();
            CpuMetricReading.access$300((CpuMetricReading)this.instance, l);
            return this;
        }
    }
    static {
        CpuMetricReading cpuMetricReading = new CpuMetricReading();
        CpuMetricReading.DEFAULT_INSTANCE = cpuMetricReading;
        z.registerDefaultInstance(CpuMetricReading.class, cpuMetricReading);
    }

    static com.google.firebase.perf.v1.CpuMetricReading access$000() {
        return CpuMetricReading.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading, long l2) {
        cpuMetricReading.setClientTimeUs(l2);
    }

    static void access$200(com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading) {
        cpuMetricReading.clearClientTimeUs();
    }

    static void access$300(com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading, long l2) {
        cpuMetricReading.setUserTimeUs(l2);
    }

    static void access$400(com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading) {
        cpuMetricReading.clearUserTimeUs();
    }

    static void access$500(com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading, long l2) {
        cpuMetricReading.setSystemTimeUs(l2);
    }

    static void access$600(com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading) {
        cpuMetricReading.clearSystemTimeUs();
    }

    private void clearClientTimeUs() {
        this.bitField0_ = bitField0_ &= -2;
        this.clientTimeUs_ = 0;
    }

    private void clearSystemTimeUs() {
        this.bitField0_ = bitField0_ &= -5;
        this.systemTimeUs_ = 0;
    }

    private void clearUserTimeUs() {
        this.bitField0_ = bitField0_ &= -3;
        this.userTimeUs_ = 0;
    }

    public static com.google.firebase.perf.v1.CpuMetricReading getDefaultInstance() {
        return CpuMetricReading.DEFAULT_INSTANCE;
    }

    public static com.google.firebase.perf.v1.CpuMetricReading.Builder newBuilder() {
        return (CpuMetricReading.Builder)CpuMetricReading.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.CpuMetricReading.Builder newBuilder(com.google.firebase.perf.v1.CpuMetricReading cpuMetricReading) {
        return (CpuMetricReading.Builder)CpuMetricReading.DEFAULT_INSTANCE.createBuilder(cpuMetricReading);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseDelimitedFrom(InputStream inputStream) {
        return (CpuMetricReading)z.parseDelimitedFrom(CpuMetricReading.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseDelimitedFrom(InputStream inputStream, q q2) {
        return (CpuMetricReading)z.parseDelimitedFrom(CpuMetricReading.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseFrom(j j) {
        return (CpuMetricReading)z.parseFrom(CpuMetricReading.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseFrom(j j, q q2) {
        return (CpuMetricReading)z.parseFrom(CpuMetricReading.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseFrom(k k) {
        return (CpuMetricReading)z.parseFrom(CpuMetricReading.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseFrom(k k, q q2) {
        return (CpuMetricReading)z.parseFrom(CpuMetricReading.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseFrom(InputStream inputStream) {
        return (CpuMetricReading)z.parseFrom(CpuMetricReading.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseFrom(InputStream inputStream, q q2) {
        return (CpuMetricReading)z.parseFrom(CpuMetricReading.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseFrom(ByteBuffer byteBuffer) {
        return (CpuMetricReading)z.parseFrom(CpuMetricReading.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseFrom(ByteBuffer byteBuffer, q q2) {
        return (CpuMetricReading)z.parseFrom(CpuMetricReading.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseFrom(byte[] bArr) {
        return (CpuMetricReading)z.parseFrom(CpuMetricReading.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.CpuMetricReading parseFrom(byte[] bArr, q q2) {
        return (CpuMetricReading)z.parseFrom(CpuMetricReading.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.CpuMetricReading> parser() {
        return CpuMetricReading.DEFAULT_INSTANCE.getParserForType();
    }

    private void setClientTimeUs(long l) {
        this.bitField0_ = bitField0_ |= 1;
        this.clientTimeUs_ = l;
    }

    private void setSystemTimeUs(long l) {
        this.bitField0_ = bitField0_ |= 4;
        this.systemTimeUs_ = l;
    }

    private void setUserTimeUs(long l) {
        this.bitField0_ = bitField0_ |= 2;
        this.userTimeUs_ = l;
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
                obj2 = new CpuMetricReading();
                return obj2;
            case 2:
                obj2 = new CpuMetricReading.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[4];
                obj2[obj3] = "clientTimeUs_";
                obj2[2] = "userTimeUs_";
                obj2[3] = "systemTimeUs_";
                return z.newMessageInfo(CpuMetricReading.DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", obj2);
            case 4:
                return CpuMetricReading.DEFAULT_INSTANCE;
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
        obj3 = CpuMetricReading.class;
        synchronized (obj3) {
            obj2 = new z.b(CpuMetricReading.DEFAULT_INSTANCE);
            CpuMetricReading.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public long getClientTimeUs() {
        return this.clientTimeUs_;
    }

    @Override // com.google.protobuf.z
    public long getSystemTimeUs() {
        return this.systemTimeUs_;
    }

    @Override // com.google.protobuf.z
    public long getUserTimeUs() {
        return this.userTimeUs_;
    }

    @Override // com.google.protobuf.z
    public boolean hasClientTimeUs() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasSystemTimeUs() {
        int i;
        i = bitField0_ &= 4 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasUserTimeUs() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }
}
