package com.google.firebase.inappmessaging;

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
public final class ClientAppInfo extends z<com.google.firebase.inappmessaging.ClientAppInfo, com.google.firebase.inappmessaging.ClientAppInfo.Builder> implements com.google.firebase.inappmessaging.ClientAppInfoOrBuilder {

    private static final com.google.firebase.inappmessaging.ClientAppInfo DEFAULT_INSTANCE = null;
    public static final int FIREBASE_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int GOOGLE_APP_ID_FIELD_NUMBER = 1;
    private static volatile d1<com.google.firebase.inappmessaging.ClientAppInfo> PARSER;
    private int bitField0_;
    private String firebaseInstanceId_;
    private String googleAppId_;

    public static final class Builder extends z.a<com.google.firebase.inappmessaging.ClientAppInfo, com.google.firebase.inappmessaging.ClientAppInfo.Builder> implements com.google.firebase.inappmessaging.ClientAppInfoOrBuilder {
        private Builder() {
            super(ClientAppInfo.access$000());
        }

        Builder(com.google.firebase.inappmessaging.ClientAppInfo.1 clientAppInfo$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.ClientAppInfo.Builder clearFirebaseInstanceId() {
            copyOnWrite();
            ClientAppInfo.access$500((ClientAppInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.ClientAppInfo.Builder clearGoogleAppId() {
            copyOnWrite();
            ClientAppInfo.access$200((ClientAppInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public String getFirebaseInstanceId() {
            return (ClientAppInfo)this.instance.getFirebaseInstanceId();
        }

        @Override // com.google.protobuf.z$a
        public j getFirebaseInstanceIdBytes() {
            return (ClientAppInfo)this.instance.getFirebaseInstanceIdBytes();
        }

        @Override // com.google.protobuf.z$a
        public String getGoogleAppId() {
            return (ClientAppInfo)this.instance.getGoogleAppId();
        }

        @Override // com.google.protobuf.z$a
        public j getGoogleAppIdBytes() {
            return (ClientAppInfo)this.instance.getGoogleAppIdBytes();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasFirebaseInstanceId() {
            return (ClientAppInfo)this.instance.hasFirebaseInstanceId();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasGoogleAppId() {
            return (ClientAppInfo)this.instance.hasGoogleAppId();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.ClientAppInfo.Builder setFirebaseInstanceId(String string) {
            copyOnWrite();
            ClientAppInfo.access$400((ClientAppInfo)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.ClientAppInfo.Builder setFirebaseInstanceIdBytes(j j) {
            copyOnWrite();
            ClientAppInfo.access$600((ClientAppInfo)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.ClientAppInfo.Builder setGoogleAppId(String string) {
            copyOnWrite();
            ClientAppInfo.access$100((ClientAppInfo)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.inappmessaging.ClientAppInfo.Builder setGoogleAppIdBytes(j j) {
            copyOnWrite();
            ClientAppInfo.access$300((ClientAppInfo)this.instance, j);
            return this;
        }
    }
    static {
        ClientAppInfo clientAppInfo = new ClientAppInfo();
        ClientAppInfo.DEFAULT_INSTANCE = clientAppInfo;
        z.registerDefaultInstance(ClientAppInfo.class, clientAppInfo);
    }

    private ClientAppInfo() {
        super();
        final String str = "";
        this.googleAppId_ = str;
        this.firebaseInstanceId_ = str;
    }

    static com.google.firebase.inappmessaging.ClientAppInfo access$000() {
        return ClientAppInfo.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo, String string2) {
        clientAppInfo.setGoogleAppId(string2);
    }

    static void access$200(com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo) {
        clientAppInfo.clearGoogleAppId();
    }

    static void access$300(com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo, j j2) {
        clientAppInfo.setGoogleAppIdBytes(j2);
    }

    static void access$400(com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo, String string2) {
        clientAppInfo.setFirebaseInstanceId(string2);
    }

    static void access$500(com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo) {
        clientAppInfo.clearFirebaseInstanceId();
    }

    static void access$600(com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo, j j2) {
        clientAppInfo.setFirebaseInstanceIdBytes(j2);
    }

    private void clearFirebaseInstanceId() {
        this.bitField0_ = bitField0_ &= -3;
        this.firebaseInstanceId_ = ClientAppInfo.getDefaultInstance().getFirebaseInstanceId();
    }

    private void clearGoogleAppId() {
        this.bitField0_ = bitField0_ &= -2;
        this.googleAppId_ = ClientAppInfo.getDefaultInstance().getGoogleAppId();
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo getDefaultInstance() {
        return ClientAppInfo.DEFAULT_INSTANCE;
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo.Builder newBuilder() {
        return (ClientAppInfo.Builder)ClientAppInfo.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo.Builder newBuilder(com.google.firebase.inappmessaging.ClientAppInfo clientAppInfo) {
        return (ClientAppInfo.Builder)ClientAppInfo.DEFAULT_INSTANCE.createBuilder(clientAppInfo);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseDelimitedFrom(InputStream inputStream) {
        return (ClientAppInfo)z.parseDelimitedFrom(ClientAppInfo.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseDelimitedFrom(InputStream inputStream, q q2) {
        return (ClientAppInfo)z.parseDelimitedFrom(ClientAppInfo.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseFrom(j j) {
        return (ClientAppInfo)z.parseFrom(ClientAppInfo.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseFrom(j j, q q2) {
        return (ClientAppInfo)z.parseFrom(ClientAppInfo.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseFrom(k k) {
        return (ClientAppInfo)z.parseFrom(ClientAppInfo.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseFrom(k k, q q2) {
        return (ClientAppInfo)z.parseFrom(ClientAppInfo.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseFrom(InputStream inputStream) {
        return (ClientAppInfo)z.parseFrom(ClientAppInfo.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseFrom(InputStream inputStream, q q2) {
        return (ClientAppInfo)z.parseFrom(ClientAppInfo.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseFrom(ByteBuffer byteBuffer) {
        return (ClientAppInfo)z.parseFrom(ClientAppInfo.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseFrom(ByteBuffer byteBuffer, q q2) {
        return (ClientAppInfo)z.parseFrom(ClientAppInfo.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseFrom(byte[] bArr) {
        return (ClientAppInfo)z.parseFrom(ClientAppInfo.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.inappmessaging.ClientAppInfo parseFrom(byte[] bArr, q q2) {
        return (ClientAppInfo)z.parseFrom(ClientAppInfo.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.inappmessaging.ClientAppInfo> parser() {
        return ClientAppInfo.DEFAULT_INSTANCE.getParserForType();
    }

    private void setFirebaseInstanceId(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 2;
        this.firebaseInstanceId_ = string;
    }

    private void setFirebaseInstanceIdBytes(j j) {
        this.firebaseInstanceId_ = j.R();
        this.bitField0_ = obj1 |= 2;
    }

    private void setGoogleAppId(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 1;
        this.googleAppId_ = string;
    }

    private void setGoogleAppIdBytes(j j) {
        this.googleAppId_ = j.R();
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
                obj2 = new ClientAppInfo();
                return obj2;
            case 2:
                obj2 = new ClientAppInfo.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = "googleAppId_";
                obj2[2] = "firebaseInstanceId_";
                return z.newMessageInfo(ClientAppInfo.DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", obj2);
            case 4:
                return ClientAppInfo.DEFAULT_INSTANCE;
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
        obj3 = ClientAppInfo.class;
        synchronized (obj3) {
            obj2 = new z.b(ClientAppInfo.DEFAULT_INSTANCE);
            ClientAppInfo.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public String getFirebaseInstanceId() {
        return this.firebaseInstanceId_;
    }

    @Override // com.google.protobuf.z
    public j getFirebaseInstanceIdBytes() {
        return j.u(this.firebaseInstanceId_);
    }

    @Override // com.google.protobuf.z
    public String getGoogleAppId() {
        return this.googleAppId_;
    }

    @Override // com.google.protobuf.z
    public j getGoogleAppIdBytes() {
        return j.u(this.googleAppId_);
    }

    @Override // com.google.protobuf.z
    public boolean hasFirebaseInstanceId() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasGoogleAppId() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }
}
