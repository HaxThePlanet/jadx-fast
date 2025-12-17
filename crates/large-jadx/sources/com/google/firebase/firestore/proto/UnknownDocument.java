package com.google.firebase.firestore.proto;

import com.google.protobuf.a;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.q;
import com.google.protobuf.r1;
import com.google.protobuf.r1.b;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class UnknownDocument extends z<com.google.firebase.firestore.proto.UnknownDocument, com.google.firebase.firestore.proto.UnknownDocument.Builder> implements com.google.firebase.firestore.proto.UnknownDocumentOrBuilder {

    private static final com.google.firebase.firestore.proto.UnknownDocument DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile d1<com.google.firebase.firestore.proto.UnknownDocument> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private String name_;
    private r1 version_;

    public static final class Builder extends z.a<com.google.firebase.firestore.proto.UnknownDocument, com.google.firebase.firestore.proto.UnknownDocument.Builder> implements com.google.firebase.firestore.proto.UnknownDocumentOrBuilder {
        private Builder() {
            super(UnknownDocument.access$000());
        }

        Builder(com.google.firebase.firestore.proto.UnknownDocument.1 unknownDocument$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.UnknownDocument.Builder clearName() {
            copyOnWrite();
            UnknownDocument.access$200((UnknownDocument)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.UnknownDocument.Builder clearVersion() {
            copyOnWrite();
            UnknownDocument.access$600((UnknownDocument)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public String getName() {
            return (UnknownDocument)this.instance.getName();
        }

        @Override // com.google.protobuf.z$a
        public j getNameBytes() {
            return (UnknownDocument)this.instance.getNameBytes();
        }

        @Override // com.google.protobuf.z$a
        public r1 getVersion() {
            return (UnknownDocument)this.instance.getVersion();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasVersion() {
            return (UnknownDocument)this.instance.hasVersion();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.UnknownDocument.Builder mergeVersion(r1 r1) {
            copyOnWrite();
            UnknownDocument.access$500((UnknownDocument)this.instance, r1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.UnknownDocument.Builder setName(String string) {
            copyOnWrite();
            UnknownDocument.access$100((UnknownDocument)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.UnknownDocument.Builder setNameBytes(j j) {
            copyOnWrite();
            UnknownDocument.access$300((UnknownDocument)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.UnknownDocument.Builder setVersion(r1.b r1$b) {
            copyOnWrite();
            UnknownDocument.access$400((UnknownDocument)this.instance, (r1)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.UnknownDocument.Builder setVersion(r1 r1) {
            copyOnWrite();
            UnknownDocument.access$400((UnknownDocument)this.instance, r1);
            return this;
        }
    }
    static {
        UnknownDocument unknownDocument = new UnknownDocument();
        UnknownDocument.DEFAULT_INSTANCE = unknownDocument;
        z.registerDefaultInstance(UnknownDocument.class, unknownDocument);
    }

    private UnknownDocument() {
        super();
        this.name_ = "";
    }

    static com.google.firebase.firestore.proto.UnknownDocument access$000() {
        return UnknownDocument.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.firestore.proto.UnknownDocument unknownDocument, String string2) {
        unknownDocument.setName(string2);
    }

    static void access$200(com.google.firebase.firestore.proto.UnknownDocument unknownDocument) {
        unknownDocument.clearName();
    }

    static void access$300(com.google.firebase.firestore.proto.UnknownDocument unknownDocument, j j2) {
        unknownDocument.setNameBytes(j2);
    }

    static void access$400(com.google.firebase.firestore.proto.UnknownDocument unknownDocument, r1 r12) {
        unknownDocument.setVersion(r12);
    }

    static void access$500(com.google.firebase.firestore.proto.UnknownDocument unknownDocument, r1 r12) {
        unknownDocument.mergeVersion(r12);
    }

    static void access$600(com.google.firebase.firestore.proto.UnknownDocument unknownDocument) {
        unknownDocument.clearVersion();
    }

    private void clearName() {
        this.name_ = UnknownDocument.getDefaultInstance().getName();
    }

    private void clearVersion() {
        this.version_ = 0;
    }

    public static com.google.firebase.firestore.proto.UnknownDocument getDefaultInstance() {
        return UnknownDocument.DEFAULT_INSTANCE;
    }

    private void mergeVersion(r1 r1) {
        Object version_;
        r1 r1Var;
        z obj3;
        r1.getClass();
        version_ = this.version_;
        if (version_ != null && version_ != r1.e()) {
            if (version_ != r1.e()) {
                this.version_ = (r1)(r1.b)r1.i(this.version_).mergeFrom(r1).buildPartial();
            } else {
                this.version_ = r1;
            }
        } else {
        }
    }

    public static com.google.firebase.firestore.proto.UnknownDocument.Builder newBuilder() {
        return (UnknownDocument.Builder)UnknownDocument.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.firestore.proto.UnknownDocument.Builder newBuilder(com.google.firebase.firestore.proto.UnknownDocument unknownDocument) {
        return (UnknownDocument.Builder)UnknownDocument.DEFAULT_INSTANCE.createBuilder(unknownDocument);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseDelimitedFrom(InputStream inputStream) {
        return (UnknownDocument)z.parseDelimitedFrom(UnknownDocument.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseDelimitedFrom(InputStream inputStream, q q2) {
        return (UnknownDocument)z.parseDelimitedFrom(UnknownDocument.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseFrom(j j) {
        return (UnknownDocument)z.parseFrom(UnknownDocument.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseFrom(j j, q q2) {
        return (UnknownDocument)z.parseFrom(UnknownDocument.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseFrom(k k) {
        return (UnknownDocument)z.parseFrom(UnknownDocument.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseFrom(k k, q q2) {
        return (UnknownDocument)z.parseFrom(UnknownDocument.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseFrom(InputStream inputStream) {
        return (UnknownDocument)z.parseFrom(UnknownDocument.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseFrom(InputStream inputStream, q q2) {
        return (UnknownDocument)z.parseFrom(UnknownDocument.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseFrom(ByteBuffer byteBuffer) {
        return (UnknownDocument)z.parseFrom(UnknownDocument.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseFrom(ByteBuffer byteBuffer, q q2) {
        return (UnknownDocument)z.parseFrom(UnknownDocument.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseFrom(byte[] bArr) {
        return (UnknownDocument)z.parseFrom(UnknownDocument.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.firestore.proto.UnknownDocument parseFrom(byte[] bArr, q q2) {
        return (UnknownDocument)z.parseFrom(UnknownDocument.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.firestore.proto.UnknownDocument> parser() {
        return UnknownDocument.DEFAULT_INSTANCE.getParserForType();
    }

    private void setName(String string) {
        string.getClass();
        this.name_ = string;
    }

    private void setNameBytes(j j) {
        a.checkByteStringIsUtf8(j);
        this.name_ = j.R();
    }

    private void setVersion(r1 r1) {
        r1.getClass();
        this.version_ = r1;
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
                obj2 = new UnknownDocument();
                return obj2;
            case 2:
                obj2 = new UnknownDocument.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[2];
                obj2[obj3] = "version_";
                return z.newMessageInfo(UnknownDocument.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", obj2);
            case 4:
                return UnknownDocument.DEFAULT_INSTANCE;
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
        obj3 = UnknownDocument.class;
        synchronized (obj3) {
            obj2 = new z.b(UnknownDocument.DEFAULT_INSTANCE);
            UnknownDocument.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.z
    public j getNameBytes() {
        return j.u(this.name_);
    }

    @Override // com.google.protobuf.z
    public r1 getVersion() {
        r1 version_;
        if (this.version_ == null) {
            version_ = r1.e();
        }
        return version_;
    }

    @Override // com.google.protobuf.z
    public boolean hasVersion() {
        int i;
        i = this.version_ != null ? 1 : 0;
        return i;
    }
}
