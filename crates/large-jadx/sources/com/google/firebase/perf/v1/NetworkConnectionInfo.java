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
public final class NetworkConnectionInfo extends z<com.google.firebase.perf.v1.NetworkConnectionInfo, com.google.firebase.perf.v1.NetworkConnectionInfo.Builder> implements com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder {

    private static final com.google.firebase.perf.v1.NetworkConnectionInfo DEFAULT_INSTANCE = null;
    public static final int MOBILE_SUBTYPE_FIELD_NUMBER = 2;
    public static final int NETWORK_TYPE_FIELD_NUMBER = 1;
    private static volatile d1<com.google.firebase.perf.v1.NetworkConnectionInfo> PARSER;
    private int bitField0_;
    private int mobileSubtype_;
    private int networkType_ = -1;

    public static enum MobileSubtype implements c0.c {

        UNKNOWN_MOBILE_SUBTYPE(false),
        GPRS(true),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(6),
        HSDPA(5),
        HSUPA(4),
        HSPA(3),
        IDEN(2),
        EVDO_B(true),
        LTE(false),
        EHRPD(2),
        HSPAP(true),
        GSM(false),
        TD_SCDMA(2),
        IWLAN(true),
        LTE_CA(false),
        COMBINED(3);

        private final int value;
        public static com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype forNumber(int i) {
            if (i != 100) {
                switch (i) {
                    case 0:
                        return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE;
                    case 1:
                        return NetworkConnectionInfo.MobileSubtype.GPRS;
                    case 2:
                        return NetworkConnectionInfo.MobileSubtype.EDGE;
                    case 3:
                        return NetworkConnectionInfo.MobileSubtype.UMTS;
                    case 4:
                        return NetworkConnectionInfo.MobileSubtype.CDMA;
                    case 5:
                        return NetworkConnectionInfo.MobileSubtype.EVDO_0;
                    case 6:
                        return NetworkConnectionInfo.MobileSubtype.EVDO_A;
                    case 7:
                        return NetworkConnectionInfo.MobileSubtype.RTT;
                    case 8:
                        return NetworkConnectionInfo.MobileSubtype.HSDPA;
                    case 9:
                        return NetworkConnectionInfo.MobileSubtype.HSUPA;
                    case 10:
                        return NetworkConnectionInfo.MobileSubtype.HSPA;
                    case 11:
                        return NetworkConnectionInfo.MobileSubtype.IDEN;
                    case 12:
                        return NetworkConnectionInfo.MobileSubtype.EVDO_B;
                    case 13:
                        return NetworkConnectionInfo.MobileSubtype.LTE;
                    case 14:
                        return NetworkConnectionInfo.MobileSubtype.EHRPD;
                    case 15:
                        return NetworkConnectionInfo.MobileSubtype.HSPAP;
                    case 16:
                        return NetworkConnectionInfo.MobileSubtype.GSM;
                    case 17:
                        return NetworkConnectionInfo.MobileSubtype.TD_SCDMA;
                    case 18:
                        return NetworkConnectionInfo.MobileSubtype.IWLAN;
                    case 19:
                        return NetworkConnectionInfo.MobileSubtype.LTE_CA;
                    default:
                        return null;
                }
            }
            return NetworkConnectionInfo.MobileSubtype.COMBINED;
        }

        public static c0.d<com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype> internalGetValueMap() {
            return NetworkConnectionInfo.MobileSubtype.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return NetworkConnectionInfo.MobileSubtype.MobileSubtypeVerifier.INSTANCE;
        }

        @Deprecated
        public static com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype valueOf(int i) {
            return NetworkConnectionInfo.MobileSubtype.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    public static enum NetworkType implements c0.c {

        NONE(-1),
        MOBILE(false),
        WIFI(true),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(5),
        DUMMY(4),
        ETHERNET(3),
        MOBILE_FOTA(2),
        MOBILE_IMS(true),
        MOBILE_CBS(false),
        WIFI_P2P(3),
        MOBILE_IA(2),
        MOBILE_EMERGENCY(true),
        PROXY(false),
        VPN(3);

        private final int value;
        public static com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType forNumber(int i) {
            switch (i) {
                case -1:
                    return NetworkConnectionInfo.NetworkType.NONE;
                case 0:
                    return NetworkConnectionInfo.NetworkType.MOBILE;
                case 1:
                    return NetworkConnectionInfo.NetworkType.WIFI;
                case 2:
                    return NetworkConnectionInfo.NetworkType.MOBILE_MMS;
                case 3:
                    return NetworkConnectionInfo.NetworkType.MOBILE_SUPL;
                case 4:
                    return NetworkConnectionInfo.NetworkType.MOBILE_DUN;
                case 5:
                    return NetworkConnectionInfo.NetworkType.MOBILE_HIPRI;
                case 6:
                    return NetworkConnectionInfo.NetworkType.WIMAX;
                case 7:
                    return NetworkConnectionInfo.NetworkType.BLUETOOTH;
                case 8:
                    return NetworkConnectionInfo.NetworkType.DUMMY;
                case 9:
                    return NetworkConnectionInfo.NetworkType.ETHERNET;
                case 10:
                    return NetworkConnectionInfo.NetworkType.MOBILE_FOTA;
                case 11:
                    return NetworkConnectionInfo.NetworkType.MOBILE_IMS;
                case 12:
                    return NetworkConnectionInfo.NetworkType.MOBILE_CBS;
                case 13:
                    return NetworkConnectionInfo.NetworkType.WIFI_P2P;
                case 14:
                    return NetworkConnectionInfo.NetworkType.MOBILE_IA;
                case 15:
                    return NetworkConnectionInfo.NetworkType.MOBILE_EMERGENCY;
                case 16:
                    return NetworkConnectionInfo.NetworkType.PROXY;
                case 17:
                    return NetworkConnectionInfo.NetworkType.VPN;
                default:
                    return null;
            }
        }

        public static c0.d<com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType> internalGetValueMap() {
            return NetworkConnectionInfo.NetworkType.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return NetworkConnectionInfo.NetworkType.NetworkTypeVerifier.INSTANCE;
        }

        @Deprecated
        public static com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType valueOf(int i) {
            return NetworkConnectionInfo.NetworkType.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            return this.value;
        }
    }

    public static final class Builder extends z.a<com.google.firebase.perf.v1.NetworkConnectionInfo, com.google.firebase.perf.v1.NetworkConnectionInfo.Builder> implements com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder {
        private Builder() {
            super(NetworkConnectionInfo.access$000());
        }

        Builder(com.google.firebase.perf.v1.NetworkConnectionInfo.1 networkConnectionInfo$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkConnectionInfo.Builder clearMobileSubtype() {
            copyOnWrite();
            NetworkConnectionInfo.access$400((NetworkConnectionInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkConnectionInfo.Builder clearNetworkType() {
            copyOnWrite();
            NetworkConnectionInfo.access$200((NetworkConnectionInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype getMobileSubtype() {
            return (NetworkConnectionInfo)this.instance.getMobileSubtype();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType getNetworkType() {
            return (NetworkConnectionInfo)this.instance.getNetworkType();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasMobileSubtype() {
            return (NetworkConnectionInfo)this.instance.hasMobileSubtype();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasNetworkType() {
            return (NetworkConnectionInfo)this.instance.hasNetworkType();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkConnectionInfo.Builder setMobileSubtype(com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype networkConnectionInfo$MobileSubtype) {
            copyOnWrite();
            NetworkConnectionInfo.access$300((NetworkConnectionInfo)this.instance, mobileSubtype);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.NetworkConnectionInfo.Builder setNetworkType(com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType networkConnectionInfo$NetworkType) {
            copyOnWrite();
            NetworkConnectionInfo.access$100((NetworkConnectionInfo)this.instance, networkType);
            return this;
        }
    }
    static {
        NetworkConnectionInfo networkConnectionInfo = new NetworkConnectionInfo();
        NetworkConnectionInfo.DEFAULT_INSTANCE = networkConnectionInfo;
        z.registerDefaultInstance(NetworkConnectionInfo.class, networkConnectionInfo);
    }

    private NetworkConnectionInfo() {
        super();
        final int i = -1;
    }

    static com.google.firebase.perf.v1.NetworkConnectionInfo access$000() {
        return NetworkConnectionInfo.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.NetworkConnectionInfo networkConnectionInfo, com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType networkConnectionInfo$NetworkType2) {
        networkConnectionInfo.setNetworkType(networkType2);
    }

    static void access$200(com.google.firebase.perf.v1.NetworkConnectionInfo networkConnectionInfo) {
        networkConnectionInfo.clearNetworkType();
    }

    static void access$300(com.google.firebase.perf.v1.NetworkConnectionInfo networkConnectionInfo, com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype networkConnectionInfo$MobileSubtype2) {
        networkConnectionInfo.setMobileSubtype(mobileSubtype2);
    }

    static void access$400(com.google.firebase.perf.v1.NetworkConnectionInfo networkConnectionInfo) {
        networkConnectionInfo.clearMobileSubtype();
    }

    private void clearMobileSubtype() {
        this.bitField0_ = bitField0_ &= -3;
        this.mobileSubtype_ = 0;
    }

    private void clearNetworkType() {
        this.bitField0_ = bitField0_ &= -2;
        this.networkType_ = -1;
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo getDefaultInstance() {
        return NetworkConnectionInfo.DEFAULT_INSTANCE;
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo.Builder newBuilder() {
        return (NetworkConnectionInfo.Builder)NetworkConnectionInfo.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo.Builder newBuilder(com.google.firebase.perf.v1.NetworkConnectionInfo networkConnectionInfo) {
        return (NetworkConnectionInfo.Builder)NetworkConnectionInfo.DEFAULT_INSTANCE.createBuilder(networkConnectionInfo);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseDelimitedFrom(InputStream inputStream) {
        return (NetworkConnectionInfo)z.parseDelimitedFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseDelimitedFrom(InputStream inputStream, q q2) {
        return (NetworkConnectionInfo)z.parseDelimitedFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseFrom(j j) {
        return (NetworkConnectionInfo)z.parseFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseFrom(j j, q q2) {
        return (NetworkConnectionInfo)z.parseFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseFrom(k k) {
        return (NetworkConnectionInfo)z.parseFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseFrom(k k, q q2) {
        return (NetworkConnectionInfo)z.parseFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseFrom(InputStream inputStream) {
        return (NetworkConnectionInfo)z.parseFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseFrom(InputStream inputStream, q q2) {
        return (NetworkConnectionInfo)z.parseFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseFrom(ByteBuffer byteBuffer) {
        return (NetworkConnectionInfo)z.parseFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseFrom(ByteBuffer byteBuffer, q q2) {
        return (NetworkConnectionInfo)z.parseFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseFrom(byte[] bArr) {
        return (NetworkConnectionInfo)z.parseFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.NetworkConnectionInfo parseFrom(byte[] bArr, q q2) {
        return (NetworkConnectionInfo)z.parseFrom(NetworkConnectionInfo.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.NetworkConnectionInfo> parser() {
        return NetworkConnectionInfo.DEFAULT_INSTANCE.getParserForType();
    }

    private void setMobileSubtype(com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype networkConnectionInfo$MobileSubtype) {
        this.mobileSubtype_ = mobileSubtype.getNumber();
        this.bitField0_ = obj1 |= 2;
    }

    private void setNetworkType(com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType networkConnectionInfo$NetworkType) {
        this.networkType_ = networkType.getNumber();
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
                obj2 = new NetworkConnectionInfo();
                return obj2;
            case 2:
                obj2 = new NetworkConnectionInfo.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[5];
                obj2[obj3] = "networkType_";
                obj2[2] = NetworkConnectionInfo.NetworkType.internalGetVerifier();
                obj2[3] = "mobileSubtype_";
                obj2[4] = NetworkConnectionInfo.MobileSubtype.internalGetVerifier();
                return z.newMessageInfo(NetworkConnectionInfo.DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", obj2);
            case 4:
                return NetworkConnectionInfo.DEFAULT_INSTANCE;
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
        obj3 = NetworkConnectionInfo.class;
        synchronized (obj3) {
            obj2 = new z.b(NetworkConnectionInfo.DEFAULT_INSTANCE);
            NetworkConnectionInfo.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype getMobileSubtype() {
        com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype uNKNOWN_MOBILE_SUBTYPE;
        if (NetworkConnectionInfo.MobileSubtype.forNumber(this.mobileSubtype_) == null) {
            uNKNOWN_MOBILE_SUBTYPE = NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE;
        }
        return uNKNOWN_MOBILE_SUBTYPE;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType getNetworkType() {
        com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType forNumber;
        if (NetworkConnectionInfo.NetworkType.forNumber(this.networkType_) == null) {
            forNumber = NetworkConnectionInfo.NetworkType.NONE;
        }
        return forNumber;
    }

    @Override // com.google.protobuf.z
    public boolean hasMobileSubtype() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasNetworkType() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }
}
