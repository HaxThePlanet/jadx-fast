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
public final class AndroidApplicationInfo extends z<com.google.firebase.perf.v1.AndroidApplicationInfo, com.google.firebase.perf.v1.AndroidApplicationInfo.Builder> implements com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder {

    private static final com.google.firebase.perf.v1.AndroidApplicationInfo DEFAULT_INSTANCE = null;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 1;
    private static volatile d1<com.google.firebase.perf.v1.AndroidApplicationInfo> PARSER = null;
    public static final int SDK_VERSION_FIELD_NUMBER = 2;
    public static final int VERSION_NAME_FIELD_NUMBER = 3;
    private int bitField0_;
    private String packageName_;
    private String sdkVersion_;
    private String versionName_;

    public static final class Builder extends z.a<com.google.firebase.perf.v1.AndroidApplicationInfo, com.google.firebase.perf.v1.AndroidApplicationInfo.Builder> implements com.google.firebase.perf.v1.AndroidApplicationInfoOrBuilder {
        private Builder() {
            super(AndroidApplicationInfo.access$000());
        }

        Builder(com.google.firebase.perf.v1.AndroidApplicationInfo.1 androidApplicationInfo$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidApplicationInfo.Builder clearPackageName() {
            copyOnWrite();
            AndroidApplicationInfo.access$200((AndroidApplicationInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidApplicationInfo.Builder clearSdkVersion() {
            copyOnWrite();
            AndroidApplicationInfo.access$500((AndroidApplicationInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidApplicationInfo.Builder clearVersionName() {
            copyOnWrite();
            AndroidApplicationInfo.access$800((AndroidApplicationInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public String getPackageName() {
            return (AndroidApplicationInfo)this.instance.getPackageName();
        }

        @Override // com.google.protobuf.z$a
        public j getPackageNameBytes() {
            return (AndroidApplicationInfo)this.instance.getPackageNameBytes();
        }

        @Override // com.google.protobuf.z$a
        public String getSdkVersion() {
            return (AndroidApplicationInfo)this.instance.getSdkVersion();
        }

        @Override // com.google.protobuf.z$a
        public j getSdkVersionBytes() {
            return (AndroidApplicationInfo)this.instance.getSdkVersionBytes();
        }

        @Override // com.google.protobuf.z$a
        public String getVersionName() {
            return (AndroidApplicationInfo)this.instance.getVersionName();
        }

        @Override // com.google.protobuf.z$a
        public j getVersionNameBytes() {
            return (AndroidApplicationInfo)this.instance.getVersionNameBytes();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasPackageName() {
            return (AndroidApplicationInfo)this.instance.hasPackageName();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasSdkVersion() {
            return (AndroidApplicationInfo)this.instance.hasSdkVersion();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasVersionName() {
            return (AndroidApplicationInfo)this.instance.hasVersionName();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidApplicationInfo.Builder setPackageName(String string) {
            copyOnWrite();
            AndroidApplicationInfo.access$100((AndroidApplicationInfo)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidApplicationInfo.Builder setPackageNameBytes(j j) {
            copyOnWrite();
            AndroidApplicationInfo.access$300((AndroidApplicationInfo)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidApplicationInfo.Builder setSdkVersion(String string) {
            copyOnWrite();
            AndroidApplicationInfo.access$400((AndroidApplicationInfo)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidApplicationInfo.Builder setSdkVersionBytes(j j) {
            copyOnWrite();
            AndroidApplicationInfo.access$600((AndroidApplicationInfo)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidApplicationInfo.Builder setVersionName(String string) {
            copyOnWrite();
            AndroidApplicationInfo.access$700((AndroidApplicationInfo)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidApplicationInfo.Builder setVersionNameBytes(j j) {
            copyOnWrite();
            AndroidApplicationInfo.access$900((AndroidApplicationInfo)this.instance, j);
            return this;
        }
    }
    static {
        AndroidApplicationInfo androidApplicationInfo = new AndroidApplicationInfo();
        AndroidApplicationInfo.DEFAULT_INSTANCE = androidApplicationInfo;
        z.registerDefaultInstance(AndroidApplicationInfo.class, androidApplicationInfo);
    }

    private AndroidApplicationInfo() {
        super();
        final String str = "";
        this.packageName_ = str;
        this.sdkVersion_ = str;
        this.versionName_ = str;
    }

    static com.google.firebase.perf.v1.AndroidApplicationInfo access$000() {
        return AndroidApplicationInfo.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo, String string2) {
        androidApplicationInfo.setPackageName(string2);
    }

    static void access$200(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo) {
        androidApplicationInfo.clearPackageName();
    }

    static void access$300(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo, j j2) {
        androidApplicationInfo.setPackageNameBytes(j2);
    }

    static void access$400(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo, String string2) {
        androidApplicationInfo.setSdkVersion(string2);
    }

    static void access$500(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo) {
        androidApplicationInfo.clearSdkVersion();
    }

    static void access$600(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo, j j2) {
        androidApplicationInfo.setSdkVersionBytes(j2);
    }

    static void access$700(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo, String string2) {
        androidApplicationInfo.setVersionName(string2);
    }

    static void access$800(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo) {
        androidApplicationInfo.clearVersionName();
    }

    static void access$900(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo, j j2) {
        androidApplicationInfo.setVersionNameBytes(j2);
    }

    private void clearPackageName() {
        this.bitField0_ = bitField0_ &= -2;
        this.packageName_ = AndroidApplicationInfo.getDefaultInstance().getPackageName();
    }

    private void clearSdkVersion() {
        this.bitField0_ = bitField0_ &= -3;
        this.sdkVersion_ = AndroidApplicationInfo.getDefaultInstance().getSdkVersion();
    }

    private void clearVersionName() {
        this.bitField0_ = bitField0_ &= -5;
        this.versionName_ = AndroidApplicationInfo.getDefaultInstance().getVersionName();
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo getDefaultInstance() {
        return AndroidApplicationInfo.DEFAULT_INSTANCE;
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo.Builder newBuilder() {
        return (AndroidApplicationInfo.Builder)AndroidApplicationInfo.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo.Builder newBuilder(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo) {
        return (AndroidApplicationInfo.Builder)AndroidApplicationInfo.DEFAULT_INSTANCE.createBuilder(androidApplicationInfo);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseDelimitedFrom(InputStream inputStream) {
        return (AndroidApplicationInfo)z.parseDelimitedFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseDelimitedFrom(InputStream inputStream, q q2) {
        return (AndroidApplicationInfo)z.parseDelimitedFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseFrom(j j) {
        return (AndroidApplicationInfo)z.parseFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseFrom(j j, q q2) {
        return (AndroidApplicationInfo)z.parseFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseFrom(k k) {
        return (AndroidApplicationInfo)z.parseFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseFrom(k k, q q2) {
        return (AndroidApplicationInfo)z.parseFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseFrom(InputStream inputStream) {
        return (AndroidApplicationInfo)z.parseFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseFrom(InputStream inputStream, q q2) {
        return (AndroidApplicationInfo)z.parseFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseFrom(ByteBuffer byteBuffer) {
        return (AndroidApplicationInfo)z.parseFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseFrom(ByteBuffer byteBuffer, q q2) {
        return (AndroidApplicationInfo)z.parseFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseFrom(byte[] bArr) {
        return (AndroidApplicationInfo)z.parseFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.AndroidApplicationInfo parseFrom(byte[] bArr, q q2) {
        return (AndroidApplicationInfo)z.parseFrom(AndroidApplicationInfo.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.AndroidApplicationInfo> parser() {
        return AndroidApplicationInfo.DEFAULT_INSTANCE.getParserForType();
    }

    private void setPackageName(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 1;
        this.packageName_ = string;
    }

    private void setPackageNameBytes(j j) {
        this.packageName_ = j.R();
        this.bitField0_ = obj1 |= 1;
    }

    private void setSdkVersion(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 2;
        this.sdkVersion_ = string;
    }

    private void setSdkVersionBytes(j j) {
        this.sdkVersion_ = j.R();
        this.bitField0_ = obj1 |= 2;
    }

    private void setVersionName(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 4;
        this.versionName_ = string;
    }

    private void setVersionNameBytes(j j) {
        this.versionName_ = j.R();
        this.bitField0_ = obj1 |= 4;
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
                obj2 = new AndroidApplicationInfo();
                return obj2;
            case 2:
                obj2 = new AndroidApplicationInfo.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[4];
                obj2[obj3] = "packageName_";
                obj2[2] = "sdkVersion_";
                obj2[3] = "versionName_";
                return z.newMessageInfo(AndroidApplicationInfo.DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", obj2);
            case 4:
                return AndroidApplicationInfo.DEFAULT_INSTANCE;
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
        obj3 = AndroidApplicationInfo.class;
        synchronized (obj3) {
            obj2 = new z.b(AndroidApplicationInfo.DEFAULT_INSTANCE);
            AndroidApplicationInfo.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public String getPackageName() {
        return this.packageName_;
    }

    @Override // com.google.protobuf.z
    public j getPackageNameBytes() {
        return j.u(this.packageName_);
    }

    @Override // com.google.protobuf.z
    public String getSdkVersion() {
        return this.sdkVersion_;
    }

    @Override // com.google.protobuf.z
    public j getSdkVersionBytes() {
        return j.u(this.sdkVersion_);
    }

    @Override // com.google.protobuf.z
    public String getVersionName() {
        return this.versionName_;
    }

    @Override // com.google.protobuf.z
    public j getVersionNameBytes() {
        return j.u(this.versionName_);
    }

    @Override // com.google.protobuf.z
    public boolean hasPackageName() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasSdkVersion() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasVersionName() {
        int i;
        i = bitField0_ &= 4 != 0 ? 1 : 0;
        return i;
    }
}
