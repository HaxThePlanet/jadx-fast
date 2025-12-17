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
public final class NoDocument extends z<com.google.firebase.firestore.proto.NoDocument, com.google.firebase.firestore.proto.NoDocument.Builder> implements com.google.firebase.firestore.proto.NoDocumentOrBuilder {

    private static final com.google.firebase.firestore.proto.NoDocument DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile d1<com.google.firebase.firestore.proto.NoDocument> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 2;
    private String name_;
    private r1 readTime_;

    public static final class Builder extends z.a<com.google.firebase.firestore.proto.NoDocument, com.google.firebase.firestore.proto.NoDocument.Builder> implements com.google.firebase.firestore.proto.NoDocumentOrBuilder {
        private Builder() {
            super(NoDocument.access$000());
        }

        Builder(com.google.firebase.firestore.proto.NoDocument.1 noDocument$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.NoDocument.Builder clearName() {
            copyOnWrite();
            NoDocument.access$200((NoDocument)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.NoDocument.Builder clearReadTime() {
            copyOnWrite();
            NoDocument.access$600((NoDocument)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public String getName() {
            return (NoDocument)this.instance.getName();
        }

        @Override // com.google.protobuf.z$a
        public j getNameBytes() {
            return (NoDocument)this.instance.getNameBytes();
        }

        @Override // com.google.protobuf.z$a
        public r1 getReadTime() {
            return (NoDocument)this.instance.getReadTime();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasReadTime() {
            return (NoDocument)this.instance.hasReadTime();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.NoDocument.Builder mergeReadTime(r1 r1) {
            copyOnWrite();
            NoDocument.access$500((NoDocument)this.instance, r1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.NoDocument.Builder setName(String string) {
            copyOnWrite();
            NoDocument.access$100((NoDocument)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.NoDocument.Builder setNameBytes(j j) {
            copyOnWrite();
            NoDocument.access$300((NoDocument)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.NoDocument.Builder setReadTime(r1.b r1$b) {
            copyOnWrite();
            NoDocument.access$400((NoDocument)this.instance, (r1)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.NoDocument.Builder setReadTime(r1 r1) {
            copyOnWrite();
            NoDocument.access$400((NoDocument)this.instance, r1);
            return this;
        }
    }
    static {
        NoDocument noDocument = new NoDocument();
        NoDocument.DEFAULT_INSTANCE = noDocument;
        z.registerDefaultInstance(NoDocument.class, noDocument);
    }

    private NoDocument() {
        super();
        this.name_ = "";
    }

    static com.google.firebase.firestore.proto.NoDocument access$000() {
        return NoDocument.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.firestore.proto.NoDocument noDocument, String string2) {
        noDocument.setName(string2);
    }

    static void access$200(com.google.firebase.firestore.proto.NoDocument noDocument) {
        noDocument.clearName();
    }

    static void access$300(com.google.firebase.firestore.proto.NoDocument noDocument, j j2) {
        noDocument.setNameBytes(j2);
    }

    static void access$400(com.google.firebase.firestore.proto.NoDocument noDocument, r1 r12) {
        noDocument.setReadTime(r12);
    }

    static void access$500(com.google.firebase.firestore.proto.NoDocument noDocument, r1 r12) {
        noDocument.mergeReadTime(r12);
    }

    static void access$600(com.google.firebase.firestore.proto.NoDocument noDocument) {
        noDocument.clearReadTime();
    }

    private void clearName() {
        this.name_ = NoDocument.getDefaultInstance().getName();
    }

    private void clearReadTime() {
        this.readTime_ = 0;
    }

    public static com.google.firebase.firestore.proto.NoDocument getDefaultInstance() {
        return NoDocument.DEFAULT_INSTANCE;
    }

    private void mergeReadTime(r1 r1) {
        Object readTime_;
        r1 r1Var;
        z obj3;
        r1.getClass();
        readTime_ = this.readTime_;
        if (readTime_ != null && readTime_ != r1.e()) {
            if (readTime_ != r1.e()) {
                this.readTime_ = (r1)(r1.b)r1.i(this.readTime_).mergeFrom(r1).buildPartial();
            } else {
                this.readTime_ = r1;
            }
        } else {
        }
    }

    public static com.google.firebase.firestore.proto.NoDocument.Builder newBuilder() {
        return (NoDocument.Builder)NoDocument.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.firestore.proto.NoDocument.Builder newBuilder(com.google.firebase.firestore.proto.NoDocument noDocument) {
        return (NoDocument.Builder)NoDocument.DEFAULT_INSTANCE.createBuilder(noDocument);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseDelimitedFrom(InputStream inputStream) {
        return (NoDocument)z.parseDelimitedFrom(NoDocument.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseDelimitedFrom(InputStream inputStream, q q2) {
        return (NoDocument)z.parseDelimitedFrom(NoDocument.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseFrom(j j) {
        return (NoDocument)z.parseFrom(NoDocument.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseFrom(j j, q q2) {
        return (NoDocument)z.parseFrom(NoDocument.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseFrom(k k) {
        return (NoDocument)z.parseFrom(NoDocument.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseFrom(k k, q q2) {
        return (NoDocument)z.parseFrom(NoDocument.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseFrom(InputStream inputStream) {
        return (NoDocument)z.parseFrom(NoDocument.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseFrom(InputStream inputStream, q q2) {
        return (NoDocument)z.parseFrom(NoDocument.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseFrom(ByteBuffer byteBuffer) {
        return (NoDocument)z.parseFrom(NoDocument.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseFrom(ByteBuffer byteBuffer, q q2) {
        return (NoDocument)z.parseFrom(NoDocument.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseFrom(byte[] bArr) {
        return (NoDocument)z.parseFrom(NoDocument.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.firestore.proto.NoDocument parseFrom(byte[] bArr, q q2) {
        return (NoDocument)z.parseFrom(NoDocument.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.firestore.proto.NoDocument> parser() {
        return NoDocument.DEFAULT_INSTANCE.getParserForType();
    }

    private void setName(String string) {
        string.getClass();
        this.name_ = string;
    }

    private void setNameBytes(j j) {
        a.checkByteStringIsUtf8(j);
        this.name_ = j.R();
    }

    private void setReadTime(r1 r1) {
        r1.getClass();
        this.readTime_ = r1;
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
                obj2 = new NoDocument();
                return obj2;
            case 2:
                obj2 = new NoDocument.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[2];
                obj2[obj3] = "readTime_";
                return z.newMessageInfo(NoDocument.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", obj2);
            case 4:
                return NoDocument.DEFAULT_INSTANCE;
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
        obj3 = NoDocument.class;
        synchronized (obj3) {
            obj2 = new z.b(NoDocument.DEFAULT_INSTANCE);
            NoDocument.PARSER = obj2;
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
    public r1 getReadTime() {
        r1 readTime_;
        if (this.readTime_ == null) {
            readTime_ = r1.e();
        }
        return readTime_;
    }

    @Override // com.google.protobuf.z
    public boolean hasReadTime() {
        int i;
        i = this.readTime_ != null ? 1 : 0;
        return i;
    }
}
