package com.google.firebase.perf.v1;

import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;
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
public final class TransportInfo extends z<com.google.firebase.perf.v1.TransportInfo, com.google.firebase.perf.v1.TransportInfo.Builder> implements com.google.firebase.perf.v1.TransportInfoOrBuilder {

    private static final com.google.firebase.perf.v1.TransportInfo DEFAULT_INSTANCE = null;
    public static final int DISPATCH_DESTINATION_FIELD_NUMBER = 1;
    private static volatile d1<com.google.firebase.perf.v1.TransportInfo> PARSER;
    private int bitField0_;
    private int dispatchDestination_;

    public static enum DispatchDestination implements c0.c {

        SOURCE_UNKNOWN(false),
        FL_LEGACY_V1(true);

        private final int value;
        public static com.google.firebase.perf.v1.TransportInfo.DispatchDestination forNumber(int i) {
            if (i != 0 && i != 1) {
                if (i != 1) {
                    return null;
                }
                return TransportInfo.DispatchDestination.FL_LEGACY_V1;
            }
            return TransportInfo.DispatchDestination.SOURCE_UNKNOWN;
        }

        public static c0.d<com.google.firebase.perf.v1.TransportInfo.DispatchDestination> internalGetValueMap() {
            return TransportInfo.DispatchDestination.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return TransportInfo.DispatchDestination.DispatchDestinationVerifier.INSTANCE;
        }

        @Deprecated
        public static com.google.firebase.perf.v1.TransportInfo.DispatchDestination valueOf(int i) {
            return TransportInfo.DispatchDestination.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    public static final class Builder extends z.a<com.google.firebase.perf.v1.TransportInfo, com.google.firebase.perf.v1.TransportInfo.Builder> implements com.google.firebase.perf.v1.TransportInfoOrBuilder {
        private Builder() {
            super(TransportInfo.access$000());
        }

        Builder(com.google.firebase.perf.v1.TransportInfo.1 transportInfo$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TransportInfo.Builder clearDispatchDestination() {
            copyOnWrite();
            TransportInfo.access$200((TransportInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TransportInfo.DispatchDestination getDispatchDestination() {
            return (TransportInfo)this.instance.getDispatchDestination();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasDispatchDestination() {
            return (TransportInfo)this.instance.hasDispatchDestination();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TransportInfo.Builder setDispatchDestination(com.google.firebase.perf.v1.TransportInfo.DispatchDestination transportInfo$DispatchDestination) {
            copyOnWrite();
            TransportInfo.access$100((TransportInfo)this.instance, dispatchDestination);
            return this;
        }
    }
    static {
        TransportInfo transportInfo = new TransportInfo();
        TransportInfo.DEFAULT_INSTANCE = transportInfo;
        z.registerDefaultInstance(TransportInfo.class, transportInfo);
    }

    static com.google.firebase.perf.v1.TransportInfo access$000() {
        return TransportInfo.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.TransportInfo transportInfo, com.google.firebase.perf.v1.TransportInfo.DispatchDestination transportInfo$DispatchDestination2) {
        transportInfo.setDispatchDestination(dispatchDestination2);
    }

    static void access$200(com.google.firebase.perf.v1.TransportInfo transportInfo) {
        transportInfo.clearDispatchDestination();
    }

    private void clearDispatchDestination() {
        this.bitField0_ = bitField0_ &= -2;
        this.dispatchDestination_ = 0;
    }

    public static com.google.firebase.perf.v1.TransportInfo getDefaultInstance() {
        return TransportInfo.DEFAULT_INSTANCE;
    }

    public static com.google.firebase.perf.v1.TransportInfo.Builder newBuilder() {
        return (TransportInfo.Builder)TransportInfo.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.TransportInfo.Builder newBuilder(com.google.firebase.perf.v1.TransportInfo transportInfo) {
        return (TransportInfo.Builder)TransportInfo.DEFAULT_INSTANCE.createBuilder(transportInfo);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseDelimitedFrom(InputStream inputStream) {
        return (TransportInfo)z.parseDelimitedFrom(TransportInfo.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseDelimitedFrom(InputStream inputStream, q q2) {
        return (TransportInfo)z.parseDelimitedFrom(TransportInfo.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseFrom(j j) {
        return (TransportInfo)z.parseFrom(TransportInfo.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseFrom(j j, q q2) {
        return (TransportInfo)z.parseFrom(TransportInfo.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseFrom(k k) {
        return (TransportInfo)z.parseFrom(TransportInfo.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseFrom(k k, q q2) {
        return (TransportInfo)z.parseFrom(TransportInfo.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseFrom(InputStream inputStream) {
        return (TransportInfo)z.parseFrom(TransportInfo.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseFrom(InputStream inputStream, q q2) {
        return (TransportInfo)z.parseFrom(TransportInfo.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseFrom(ByteBuffer byteBuffer) {
        return (TransportInfo)z.parseFrom(TransportInfo.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseFrom(ByteBuffer byteBuffer, q q2) {
        return (TransportInfo)z.parseFrom(TransportInfo.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseFrom(byte[] bArr) {
        return (TransportInfo)z.parseFrom(TransportInfo.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.TransportInfo parseFrom(byte[] bArr, q q2) {
        return (TransportInfo)z.parseFrom(TransportInfo.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.TransportInfo> parser() {
        return TransportInfo.DEFAULT_INSTANCE.getParserForType();
    }

    private void setDispatchDestination(com.google.firebase.perf.v1.TransportInfo.DispatchDestination transportInfo$DispatchDestination) {
        this.dispatchDestination_ = dispatchDestination.getNumber();
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
                obj2 = new TransportInfo();
                return obj2;
            case 2:
                obj2 = new TransportInfo.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = "dispatchDestination_";
                obj2[2] = TransportInfo.DispatchDestination.internalGetVerifier();
                return z.newMessageInfo(TransportInfo.DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", obj2);
            case 4:
                return TransportInfo.DEFAULT_INSTANCE;
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
        obj3 = TransportInfo.class;
        synchronized (obj3) {
            obj2 = new z.b(TransportInfo.DEFAULT_INSTANCE);
            TransportInfo.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.TransportInfo.DispatchDestination getDispatchDestination() {
        com.google.firebase.perf.v1.TransportInfo.DispatchDestination sOURCE_UNKNOWN;
        if (TransportInfo.DispatchDestination.forNumber(this.dispatchDestination_) == null) {
            sOURCE_UNKNOWN = TransportInfo.DispatchDestination.SOURCE_UNKNOWN;
        }
        return sOURCE_UNKNOWN;
    }

    @Override // com.google.protobuf.z
    public boolean hasDispatchDestination() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }
}
