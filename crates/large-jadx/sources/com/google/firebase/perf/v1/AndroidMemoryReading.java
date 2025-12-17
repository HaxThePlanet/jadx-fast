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
public final class AndroidMemoryReading extends z<com.google.firebase.perf.v1.AndroidMemoryReading, com.google.firebase.perf.v1.AndroidMemoryReading.Builder> implements com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder {

    public static final int CLIENT_TIME_US_FIELD_NUMBER = 1;
    private static final com.google.firebase.perf.v1.AndroidMemoryReading DEFAULT_INSTANCE = null;
    private static volatile d1<com.google.firebase.perf.v1.AndroidMemoryReading> PARSER = null;
    public static final int USED_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 2;
    private int bitField0_;
    private long clientTimeUs_;
    private int usedAppJavaHeapMemoryKb_;

    public static final class Builder extends z.a<com.google.firebase.perf.v1.AndroidMemoryReading, com.google.firebase.perf.v1.AndroidMemoryReading.Builder> implements com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder {
        private Builder() {
            super(AndroidMemoryReading.access$000());
        }

        Builder(com.google.firebase.perf.v1.AndroidMemoryReading.1 androidMemoryReading$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidMemoryReading.Builder clearClientTimeUs() {
            copyOnWrite();
            AndroidMemoryReading.access$200((AndroidMemoryReading)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidMemoryReading.Builder clearUsedAppJavaHeapMemoryKb() {
            copyOnWrite();
            AndroidMemoryReading.access$400((AndroidMemoryReading)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public long getClientTimeUs() {
            return (AndroidMemoryReading)this.instance.getClientTimeUs();
        }

        @Override // com.google.protobuf.z$a
        public int getUsedAppJavaHeapMemoryKb() {
            return (AndroidMemoryReading)this.instance.getUsedAppJavaHeapMemoryKb();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasClientTimeUs() {
            return (AndroidMemoryReading)this.instance.hasClientTimeUs();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasUsedAppJavaHeapMemoryKb() {
            return (AndroidMemoryReading)this.instance.hasUsedAppJavaHeapMemoryKb();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidMemoryReading.Builder setClientTimeUs(long l) {
            copyOnWrite();
            AndroidMemoryReading.access$100((AndroidMemoryReading)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidMemoryReading.Builder setUsedAppJavaHeapMemoryKb(int i) {
            copyOnWrite();
            AndroidMemoryReading.access$300((AndroidMemoryReading)this.instance, i);
            return this;
        }
    }
    static {
        AndroidMemoryReading androidMemoryReading = new AndroidMemoryReading();
        AndroidMemoryReading.DEFAULT_INSTANCE = androidMemoryReading;
        z.registerDefaultInstance(AndroidMemoryReading.class, androidMemoryReading);
    }

    static com.google.firebase.perf.v1.AndroidMemoryReading access$000() {
        return AndroidMemoryReading.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading, long l2) {
        androidMemoryReading.setClientTimeUs(l2);
    }

    static void access$200(com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.clearClientTimeUs();
    }

    static void access$300(com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading, int i2) {
        androidMemoryReading.setUsedAppJavaHeapMemoryKb(i2);
    }

    static void access$400(com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.clearUsedAppJavaHeapMemoryKb();
    }

    private void clearClientTimeUs() {
        this.bitField0_ = bitField0_ &= -2;
        this.clientTimeUs_ = 0;
    }

    private void clearUsedAppJavaHeapMemoryKb() {
        this.bitField0_ = bitField0_ &= -3;
        this.usedAppJavaHeapMemoryKb_ = 0;
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading getDefaultInstance() {
        return AndroidMemoryReading.DEFAULT_INSTANCE;
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading.Builder newBuilder() {
        return (AndroidMemoryReading.Builder)AndroidMemoryReading.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading.Builder newBuilder(com.google.firebase.perf.v1.AndroidMemoryReading androidMemoryReading) {
        return (AndroidMemoryReading.Builder)AndroidMemoryReading.DEFAULT_INSTANCE.createBuilder(androidMemoryReading);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseDelimitedFrom(InputStream inputStream) {
        return (AndroidMemoryReading)z.parseDelimitedFrom(AndroidMemoryReading.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseDelimitedFrom(InputStream inputStream, q q2) {
        return (AndroidMemoryReading)z.parseDelimitedFrom(AndroidMemoryReading.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseFrom(j j) {
        return (AndroidMemoryReading)z.parseFrom(AndroidMemoryReading.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseFrom(j j, q q2) {
        return (AndroidMemoryReading)z.parseFrom(AndroidMemoryReading.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseFrom(k k) {
        return (AndroidMemoryReading)z.parseFrom(AndroidMemoryReading.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseFrom(k k, q q2) {
        return (AndroidMemoryReading)z.parseFrom(AndroidMemoryReading.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseFrom(InputStream inputStream) {
        return (AndroidMemoryReading)z.parseFrom(AndroidMemoryReading.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseFrom(InputStream inputStream, q q2) {
        return (AndroidMemoryReading)z.parseFrom(AndroidMemoryReading.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseFrom(ByteBuffer byteBuffer) {
        return (AndroidMemoryReading)z.parseFrom(AndroidMemoryReading.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseFrom(ByteBuffer byteBuffer, q q2) {
        return (AndroidMemoryReading)z.parseFrom(AndroidMemoryReading.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseFrom(byte[] bArr) {
        return (AndroidMemoryReading)z.parseFrom(AndroidMemoryReading.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.AndroidMemoryReading parseFrom(byte[] bArr, q q2) {
        return (AndroidMemoryReading)z.parseFrom(AndroidMemoryReading.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.AndroidMemoryReading> parser() {
        return AndroidMemoryReading.DEFAULT_INSTANCE.getParserForType();
    }

    private void setClientTimeUs(long l) {
        this.bitField0_ = bitField0_ |= 1;
        this.clientTimeUs_ = l;
    }

    private void setUsedAppJavaHeapMemoryKb(int i) {
        this.bitField0_ = bitField0_ |= 2;
        this.usedAppJavaHeapMemoryKb_ = i;
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
                obj2 = new AndroidMemoryReading();
                return obj2;
            case 2:
                obj2 = new AndroidMemoryReading.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = "clientTimeUs_";
                obj2[2] = "usedAppJavaHeapMemoryKb_";
                return z.newMessageInfo(AndroidMemoryReading.DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002င\u0001", obj2);
            case 4:
                return AndroidMemoryReading.DEFAULT_INSTANCE;
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
        obj3 = AndroidMemoryReading.class;
        synchronized (obj3) {
            obj2 = new z.b(AndroidMemoryReading.DEFAULT_INSTANCE);
            AndroidMemoryReading.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public long getClientTimeUs() {
        return this.clientTimeUs_;
    }

    @Override // com.google.protobuf.z
    public int getUsedAppJavaHeapMemoryKb() {
        return this.usedAppJavaHeapMemoryKb_;
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
    public boolean hasUsedAppJavaHeapMemoryKb() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }
}
