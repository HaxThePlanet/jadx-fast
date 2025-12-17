package com.google.firebase.perf.v1;

import android.accounts.Account;
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
public final class GaugeMetadata extends z<com.google.firebase.perf.v1.GaugeMetadata, com.google.firebase.perf.v1.GaugeMetadata.Builder> implements com.google.firebase.perf.v1.GaugeMetadataOrBuilder {

    public static final int CPU_CLOCK_RATE_KHZ_FIELD_NUMBER = 2;
    public static final int CPU_PROCESSOR_COUNT_FIELD_NUMBER = 6;
    private static final com.google.firebase.perf.v1.GaugeMetadata DEFAULT_INSTANCE = null;
    public static final int DEVICE_RAM_SIZE_KB_FIELD_NUMBER = 3;
    public static final int MAX_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 4;
    public static final int MAX_ENCOURAGED_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 5;
    private static volatile d1<com.google.firebase.perf.v1.GaugeMetadata> PARSER = null;
    public static final int PROCESS_NAME_FIELD_NUMBER = 1;
    private int bitField0_;
    private int cpuClockRateKhz_;
    private int cpuProcessorCount_;
    private int deviceRamSizeKb_;
    private int maxAppJavaHeapMemoryKb_;
    private int maxEncouragedAppJavaHeapMemoryKb_;
    private String processName_;

    public static final class Builder extends z.a<com.google.firebase.perf.v1.GaugeMetadata, com.google.firebase.perf.v1.GaugeMetadata.Builder> implements com.google.firebase.perf.v1.GaugeMetadataOrBuilder {
        private Builder() {
            super(GaugeMetadata.access$000());
        }

        Builder(com.google.firebase.perf.v1.GaugeMetadata.1 gaugeMetadata$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder clearCpuClockRateKhz() {
            copyOnWrite();
            GaugeMetadata.access$500((GaugeMetadata)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder clearCpuProcessorCount() {
            copyOnWrite();
            GaugeMetadata.access$700((GaugeMetadata)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder clearDeviceRamSizeKb() {
            copyOnWrite();
            GaugeMetadata.access$900((GaugeMetadata)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder clearMaxAppJavaHeapMemoryKb() {
            copyOnWrite();
            GaugeMetadata.access$1100((GaugeMetadata)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder clearMaxEncouragedAppJavaHeapMemoryKb() {
            copyOnWrite();
            GaugeMetadata.access$1300((GaugeMetadata)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder clearProcessName() {
            copyOnWrite();
            GaugeMetadata.access$200((GaugeMetadata)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public int getCpuClockRateKhz() {
            return (GaugeMetadata)this.instance.getCpuClockRateKhz();
        }

        @Override // com.google.protobuf.z$a
        public int getCpuProcessorCount() {
            return (GaugeMetadata)this.instance.getCpuProcessorCount();
        }

        @Override // com.google.protobuf.z$a
        public int getDeviceRamSizeKb() {
            return (GaugeMetadata)this.instance.getDeviceRamSizeKb();
        }

        @Override // com.google.protobuf.z$a
        public int getMaxAppJavaHeapMemoryKb() {
            return (GaugeMetadata)this.instance.getMaxAppJavaHeapMemoryKb();
        }

        @Override // com.google.protobuf.z$a
        public int getMaxEncouragedAppJavaHeapMemoryKb() {
            return (GaugeMetadata)this.instance.getMaxEncouragedAppJavaHeapMemoryKb();
        }

        @Override // com.google.protobuf.z$a
        public String getProcessName() {
            return (GaugeMetadata)this.instance.getProcessName();
        }

        @Override // com.google.protobuf.z$a
        public j getProcessNameBytes() {
            return (GaugeMetadata)this.instance.getProcessNameBytes();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasCpuClockRateKhz() {
            return (GaugeMetadata)this.instance.hasCpuClockRateKhz();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasCpuProcessorCount() {
            return (GaugeMetadata)this.instance.hasCpuProcessorCount();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasDeviceRamSizeKb() {
            return (GaugeMetadata)this.instance.hasDeviceRamSizeKb();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasMaxAppJavaHeapMemoryKb() {
            return (GaugeMetadata)this.instance.hasMaxAppJavaHeapMemoryKb();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasMaxEncouragedAppJavaHeapMemoryKb() {
            return (GaugeMetadata)this.instance.hasMaxEncouragedAppJavaHeapMemoryKb();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasProcessName() {
            return (GaugeMetadata)this.instance.hasProcessName();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder setCpuClockRateKhz(int i) {
            copyOnWrite();
            GaugeMetadata.access$400((GaugeMetadata)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder setCpuProcessorCount(int i) {
            copyOnWrite();
            GaugeMetadata.access$600((GaugeMetadata)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder setDeviceRamSizeKb(int i) {
            copyOnWrite();
            GaugeMetadata.access$800((GaugeMetadata)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder setMaxAppJavaHeapMemoryKb(int i) {
            copyOnWrite();
            GaugeMetadata.access$1000((GaugeMetadata)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder setMaxEncouragedAppJavaHeapMemoryKb(int i) {
            copyOnWrite();
            GaugeMetadata.access$1200((GaugeMetadata)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder setProcessName(String string) {
            copyOnWrite();
            GaugeMetadata.access$100((GaugeMetadata)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.GaugeMetadata.Builder setProcessNameBytes(j j) {
            copyOnWrite();
            GaugeMetadata.access$300((GaugeMetadata)this.instance, j);
            return this;
        }
    }
    static {
        GaugeMetadata gaugeMetadata = new GaugeMetadata();
        GaugeMetadata.DEFAULT_INSTANCE = gaugeMetadata;
        z.registerDefaultInstance(GaugeMetadata.class, gaugeMetadata);
    }

    private GaugeMetadata() {
        super();
        this.processName_ = "";
    }

    static com.google.firebase.perf.v1.GaugeMetadata access$000() {
        return GaugeMetadata.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata, String string2) {
        gaugeMetadata.setProcessName(string2);
    }

    static void access$1000(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata, int i2) {
        gaugeMetadata.setMaxAppJavaHeapMemoryKb(i2);
    }

    static void access$1100(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearMaxAppJavaHeapMemoryKb();
    }

    static void access$1200(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata, int i2) {
        gaugeMetadata.setMaxEncouragedAppJavaHeapMemoryKb(i2);
    }

    static void access$1300(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearMaxEncouragedAppJavaHeapMemoryKb();
    }

    static void access$200(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearProcessName();
    }

    static void access$300(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata, j j2) {
        gaugeMetadata.setProcessNameBytes(j2);
    }

    static void access$400(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata, int i2) {
        gaugeMetadata.setCpuClockRateKhz(i2);
    }

    static void access$500(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearCpuClockRateKhz();
    }

    static void access$600(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata, int i2) {
        gaugeMetadata.setCpuProcessorCount(i2);
    }

    static void access$700(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearCpuProcessorCount();
    }

    static void access$800(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata, int i2) {
        gaugeMetadata.setDeviceRamSizeKb(i2);
    }

    static void access$900(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearDeviceRamSizeKb();
    }

    private void clearCpuClockRateKhz() {
        this.bitField0_ = bitField0_ &= -3;
        this.cpuClockRateKhz_ = 0;
    }

    private void clearCpuProcessorCount() {
        this.bitField0_ = bitField0_ &= -5;
        this.cpuProcessorCount_ = 0;
    }

    private void clearDeviceRamSizeKb() {
        this.bitField0_ = bitField0_ &= -9;
        this.deviceRamSizeKb_ = 0;
    }

    private void clearMaxAppJavaHeapMemoryKb() {
        this.bitField0_ = bitField0_ &= -17;
        this.maxAppJavaHeapMemoryKb_ = 0;
    }

    private void clearMaxEncouragedAppJavaHeapMemoryKb() {
        this.bitField0_ = bitField0_ &= -33;
        this.maxEncouragedAppJavaHeapMemoryKb_ = 0;
    }

    private void clearProcessName() {
        this.bitField0_ = bitField0_ &= -2;
        this.processName_ = GaugeMetadata.getDefaultInstance().getProcessName();
    }

    public static com.google.firebase.perf.v1.GaugeMetadata getDefaultInstance() {
        return GaugeMetadata.DEFAULT_INSTANCE;
    }

    public static com.google.firebase.perf.v1.GaugeMetadata.Builder newBuilder() {
        return (GaugeMetadata.Builder)GaugeMetadata.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.GaugeMetadata.Builder newBuilder(com.google.firebase.perf.v1.GaugeMetadata gaugeMetadata) {
        return (GaugeMetadata.Builder)GaugeMetadata.DEFAULT_INSTANCE.createBuilder(gaugeMetadata);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseDelimitedFrom(InputStream inputStream) {
        return (GaugeMetadata)z.parseDelimitedFrom(GaugeMetadata.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseDelimitedFrom(InputStream inputStream, q q2) {
        return (GaugeMetadata)z.parseDelimitedFrom(GaugeMetadata.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseFrom(j j) {
        return (GaugeMetadata)z.parseFrom(GaugeMetadata.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseFrom(j j, q q2) {
        return (GaugeMetadata)z.parseFrom(GaugeMetadata.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseFrom(k k) {
        return (GaugeMetadata)z.parseFrom(GaugeMetadata.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseFrom(k k, q q2) {
        return (GaugeMetadata)z.parseFrom(GaugeMetadata.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseFrom(InputStream inputStream) {
        return (GaugeMetadata)z.parseFrom(GaugeMetadata.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseFrom(InputStream inputStream, q q2) {
        return (GaugeMetadata)z.parseFrom(GaugeMetadata.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseFrom(ByteBuffer byteBuffer) {
        return (GaugeMetadata)z.parseFrom(GaugeMetadata.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseFrom(ByteBuffer byteBuffer, q q2) {
        return (GaugeMetadata)z.parseFrom(GaugeMetadata.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseFrom(byte[] bArr) {
        return (GaugeMetadata)z.parseFrom(GaugeMetadata.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.GaugeMetadata parseFrom(byte[] bArr, q q2) {
        return (GaugeMetadata)z.parseFrom(GaugeMetadata.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.GaugeMetadata> parser() {
        return GaugeMetadata.DEFAULT_INSTANCE.getParserForType();
    }

    private void setCpuClockRateKhz(int i) {
        this.bitField0_ = bitField0_ |= 2;
        this.cpuClockRateKhz_ = i;
    }

    private void setCpuProcessorCount(int i) {
        this.bitField0_ = bitField0_ |= 4;
        this.cpuProcessorCount_ = i;
    }

    private void setDeviceRamSizeKb(int i) {
        this.bitField0_ = bitField0_ |= 8;
        this.deviceRamSizeKb_ = i;
    }

    private void setMaxAppJavaHeapMemoryKb(int i) {
        this.bitField0_ = bitField0_ |= 16;
        this.maxAppJavaHeapMemoryKb_ = i;
    }

    private void setMaxEncouragedAppJavaHeapMemoryKb(int i) {
        this.bitField0_ = bitField0_ |= 32;
        this.maxEncouragedAppJavaHeapMemoryKb_ = i;
    }

    private void setProcessName(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 1;
        this.processName_ = string;
    }

    private void setProcessNameBytes(j j) {
        this.processName_ = j.R();
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
                obj2 = new GaugeMetadata();
                return obj2;
            case 2:
                obj2 = new GaugeMetadata.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[7];
                obj2[obj3] = "processName_";
                obj2[2] = "cpuClockRateKhz_";
                obj2[3] = "deviceRamSizeKb_";
                obj2[4] = "maxAppJavaHeapMemoryKb_";
                obj2[5] = "maxEncouragedAppJavaHeapMemoryKb_";
                obj2[6] = "cpuProcessorCount_";
                return z.newMessageInfo(GaugeMetadata.DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0003\u0004င\u0004\u0005င\u0005\u0006င\u0002", obj2);
            case 4:
                return GaugeMetadata.DEFAULT_INSTANCE;
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
        obj3 = GaugeMetadata.class;
        synchronized (obj3) {
            obj2 = new z.b(GaugeMetadata.DEFAULT_INSTANCE);
            GaugeMetadata.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public int getCpuClockRateKhz() {
        return this.cpuClockRateKhz_;
    }

    @Override // com.google.protobuf.z
    public int getCpuProcessorCount() {
        return this.cpuProcessorCount_;
    }

    @Override // com.google.protobuf.z
    public int getDeviceRamSizeKb() {
        return this.deviceRamSizeKb_;
    }

    @Override // com.google.protobuf.z
    public int getMaxAppJavaHeapMemoryKb() {
        return this.maxAppJavaHeapMemoryKb_;
    }

    @Override // com.google.protobuf.z
    public int getMaxEncouragedAppJavaHeapMemoryKb() {
        return this.maxEncouragedAppJavaHeapMemoryKb_;
    }

    @Override // com.google.protobuf.z
    public String getProcessName() {
        return this.processName_;
    }

    @Override // com.google.protobuf.z
    public j getProcessNameBytes() {
        return j.u(this.processName_);
    }

    @Override // com.google.protobuf.z
    public boolean hasCpuClockRateKhz() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasCpuProcessorCount() {
        int i;
        i = bitField0_ &= 4 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasDeviceRamSizeKb() {
        int i;
        i = bitField0_ &= 8 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasMaxAppJavaHeapMemoryKb() {
        int i;
        i = bitField0_ &= 16 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasMaxEncouragedAppJavaHeapMemoryKb() {
        int i;
        i = bitField0_ &= 32 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasProcessName() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }
}
