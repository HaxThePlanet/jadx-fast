package com.google.firebase.firestore.proto;

import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.q;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import f.c.e.c.h;
import f.c.e.c.h.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class MaybeDocument extends z<com.google.firebase.firestore.proto.MaybeDocument, com.google.firebase.firestore.proto.MaybeDocument.Builder> implements com.google.firebase.firestore.proto.MaybeDocumentOrBuilder {

    private static final com.google.firebase.firestore.proto.MaybeDocument DEFAULT_INSTANCE = null;
    public static final int DOCUMENT_FIELD_NUMBER = 2;
    public static final int HAS_COMMITTED_MUTATIONS_FIELD_NUMBER = 4;
    public static final int NO_DOCUMENT_FIELD_NUMBER = 1;
    private static volatile d1<com.google.firebase.firestore.proto.MaybeDocument> PARSER = null;
    public static final int UNKNOWN_DOCUMENT_FIELD_NUMBER = 3;
    private int documentTypeCase_ = 0;
    private Object documentType_;
    private boolean hasCommittedMutations_;

    public static enum DocumentTypeCase {

        NO_DOCUMENT(true),
        DOCUMENT(2),
        UNKNOWN_DOCUMENT(3),
        DOCUMENTTYPE_NOT_SET(false);

        private final int value;
        public static com.google.firebase.firestore.proto.MaybeDocument.DocumentTypeCase forNumber(int i) {
            if (i != 0 && i != 1 && i != 2 && i != 3) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return MaybeDocument.DocumentTypeCase.UNKNOWN_DOCUMENT;
                    }
                    return MaybeDocument.DocumentTypeCase.DOCUMENT;
                }
                return MaybeDocument.DocumentTypeCase.NO_DOCUMENT;
            }
            return MaybeDocument.DocumentTypeCase.DOCUMENTTYPE_NOT_SET;
        }

        @Deprecated
        public static com.google.firebase.firestore.proto.MaybeDocument.DocumentTypeCase valueOf(int i) {
            return MaybeDocument.DocumentTypeCase.forNumber(i);
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.value;
        }
    }

    public static final class Builder extends z.a<com.google.firebase.firestore.proto.MaybeDocument, com.google.firebase.firestore.proto.MaybeDocument.Builder> implements com.google.firebase.firestore.proto.MaybeDocumentOrBuilder {
        private Builder() {
            super(MaybeDocument.access$000());
        }

        Builder(com.google.firebase.firestore.proto.MaybeDocument.1 maybeDocument$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder clearDocument() {
            copyOnWrite();
            MaybeDocument.access$700((MaybeDocument)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder clearDocumentType() {
            copyOnWrite();
            MaybeDocument.access$100((MaybeDocument)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder clearHasCommittedMutations() {
            copyOnWrite();
            MaybeDocument.access$1200((MaybeDocument)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder clearNoDocument() {
            copyOnWrite();
            MaybeDocument.access$400((MaybeDocument)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder clearUnknownDocument() {
            copyOnWrite();
            MaybeDocument.access$1000((MaybeDocument)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public h getDocument() {
            return (MaybeDocument)this.instance.getDocument();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.DocumentTypeCase getDocumentTypeCase() {
            return (MaybeDocument)this.instance.getDocumentTypeCase();
        }

        @Override // com.google.protobuf.z$a
        public boolean getHasCommittedMutations() {
            return (MaybeDocument)this.instance.getHasCommittedMutations();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.NoDocument getNoDocument() {
            return (MaybeDocument)this.instance.getNoDocument();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.UnknownDocument getUnknownDocument() {
            return (MaybeDocument)this.instance.getUnknownDocument();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasDocument() {
            return (MaybeDocument)this.instance.hasDocument();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasNoDocument() {
            return (MaybeDocument)this.instance.hasNoDocument();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasUnknownDocument() {
            return (MaybeDocument)this.instance.hasUnknownDocument();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder mergeDocument(h h) {
            copyOnWrite();
            MaybeDocument.access$600((MaybeDocument)this.instance, h);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder mergeNoDocument(com.google.firebase.firestore.proto.NoDocument noDocument) {
            copyOnWrite();
            MaybeDocument.access$300((MaybeDocument)this.instance, noDocument);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder mergeUnknownDocument(com.google.firebase.firestore.proto.UnknownDocument unknownDocument) {
            copyOnWrite();
            MaybeDocument.access$900((MaybeDocument)this.instance, unknownDocument);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder setDocument(h.b h$b) {
            copyOnWrite();
            MaybeDocument.access$500((MaybeDocument)this.instance, (h)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder setDocument(h h) {
            copyOnWrite();
            MaybeDocument.access$500((MaybeDocument)this.instance, h);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder setHasCommittedMutations(boolean z) {
            copyOnWrite();
            MaybeDocument.access$1100((MaybeDocument)this.instance, z);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder setNoDocument(com.google.firebase.firestore.proto.NoDocument.Builder noDocument$Builder) {
            copyOnWrite();
            MaybeDocument.access$200((MaybeDocument)this.instance, (NoDocument)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder setNoDocument(com.google.firebase.firestore.proto.NoDocument noDocument) {
            copyOnWrite();
            MaybeDocument.access$200((MaybeDocument)this.instance, noDocument);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder setUnknownDocument(com.google.firebase.firestore.proto.UnknownDocument.Builder unknownDocument$Builder) {
            copyOnWrite();
            MaybeDocument.access$800((MaybeDocument)this.instance, (UnknownDocument)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MaybeDocument.Builder setUnknownDocument(com.google.firebase.firestore.proto.UnknownDocument unknownDocument) {
            copyOnWrite();
            MaybeDocument.access$800((MaybeDocument)this.instance, unknownDocument);
            return this;
        }
    }
    static {
        MaybeDocument maybeDocument = new MaybeDocument();
        MaybeDocument.DEFAULT_INSTANCE = maybeDocument;
        z.registerDefaultInstance(MaybeDocument.class, maybeDocument);
    }

    private MaybeDocument() {
        super();
        final int i = 0;
    }

    static com.google.firebase.firestore.proto.MaybeDocument access$000() {
        return MaybeDocument.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.firestore.proto.MaybeDocument maybeDocument) {
        maybeDocument.clearDocumentType();
    }

    static void access$1000(com.google.firebase.firestore.proto.MaybeDocument maybeDocument) {
        maybeDocument.clearUnknownDocument();
    }

    static void access$1100(com.google.firebase.firestore.proto.MaybeDocument maybeDocument, boolean z2) {
        maybeDocument.setHasCommittedMutations(z2);
    }

    static void access$1200(com.google.firebase.firestore.proto.MaybeDocument maybeDocument) {
        maybeDocument.clearHasCommittedMutations();
    }

    static void access$200(com.google.firebase.firestore.proto.MaybeDocument maybeDocument, com.google.firebase.firestore.proto.NoDocument noDocument2) {
        maybeDocument.setNoDocument(noDocument2);
    }

    static void access$300(com.google.firebase.firestore.proto.MaybeDocument maybeDocument, com.google.firebase.firestore.proto.NoDocument noDocument2) {
        maybeDocument.mergeNoDocument(noDocument2);
    }

    static void access$400(com.google.firebase.firestore.proto.MaybeDocument maybeDocument) {
        maybeDocument.clearNoDocument();
    }

    static void access$500(com.google.firebase.firestore.proto.MaybeDocument maybeDocument, h h2) {
        maybeDocument.setDocument(h2);
    }

    static void access$600(com.google.firebase.firestore.proto.MaybeDocument maybeDocument, h h2) {
        maybeDocument.mergeDocument(h2);
    }

    static void access$700(com.google.firebase.firestore.proto.MaybeDocument maybeDocument) {
        maybeDocument.clearDocument();
    }

    static void access$800(com.google.firebase.firestore.proto.MaybeDocument maybeDocument, com.google.firebase.firestore.proto.UnknownDocument unknownDocument2) {
        maybeDocument.setUnknownDocument(unknownDocument2);
    }

    static void access$900(com.google.firebase.firestore.proto.MaybeDocument maybeDocument, com.google.firebase.firestore.proto.UnknownDocument unknownDocument2) {
        maybeDocument.mergeUnknownDocument(unknownDocument2);
    }

    private void clearDocument() {
        int documentTypeCase_;
        if (this.documentTypeCase_ == 2) {
            this.documentTypeCase_ = 0;
            this.documentType_ = 0;
        }
    }

    private void clearDocumentType() {
        this.documentTypeCase_ = 0;
        this.documentType_ = 0;
    }

    private void clearHasCommittedMutations() {
        this.hasCommittedMutations_ = false;
    }

    private void clearNoDocument() {
        int documentTypeCase_;
        if (this.documentTypeCase_ == 1) {
            this.documentTypeCase_ = 0;
            this.documentType_ = 0;
        }
    }

    private void clearUnknownDocument() {
        int documentTypeCase_;
        if (this.documentTypeCase_ == 3) {
            this.documentTypeCase_ = 0;
            this.documentType_ = 0;
        }
    }

    public static com.google.firebase.firestore.proto.MaybeDocument getDefaultInstance() {
        return MaybeDocument.DEFAULT_INSTANCE;
    }

    private void mergeDocument(h h) {
        int documentTypeCase_;
        h hVar;
        z obj4;
        h.getClass();
        final int i = 2;
        if (this.documentTypeCase_ == i && this.documentType_ != h.f()) {
            if (this.documentType_ != h.f()) {
                this.documentType_ = (h.b)h.m((h)this.documentType_).mergeFrom(h).buildPartial();
            } else {
                this.documentType_ = h;
            }
        } else {
        }
        this.documentTypeCase_ = i;
    }

    private void mergeNoDocument(com.google.firebase.firestore.proto.NoDocument noDocument) {
        int documentTypeCase_;
        com.google.firebase.firestore.proto.NoDocument defaultInstance;
        z obj4;
        noDocument.getClass();
        final int i = 1;
        if (this.documentTypeCase_ == i && this.documentType_ != NoDocument.getDefaultInstance()) {
            if (this.documentType_ != NoDocument.getDefaultInstance()) {
                this.documentType_ = (NoDocument.Builder)NoDocument.newBuilder((NoDocument)this.documentType_).mergeFrom(noDocument).buildPartial();
            } else {
                this.documentType_ = noDocument;
            }
        } else {
        }
        this.documentTypeCase_ = i;
    }

    private void mergeUnknownDocument(com.google.firebase.firestore.proto.UnknownDocument unknownDocument) {
        int documentTypeCase_;
        com.google.firebase.firestore.proto.UnknownDocument defaultInstance;
        z obj4;
        unknownDocument.getClass();
        final int i = 3;
        if (this.documentTypeCase_ == i && this.documentType_ != UnknownDocument.getDefaultInstance()) {
            if (this.documentType_ != UnknownDocument.getDefaultInstance()) {
                this.documentType_ = (UnknownDocument.Builder)UnknownDocument.newBuilder((UnknownDocument)this.documentType_).mergeFrom(unknownDocument).buildPartial();
            } else {
                this.documentType_ = unknownDocument;
            }
        } else {
        }
        this.documentTypeCase_ = i;
    }

    public static com.google.firebase.firestore.proto.MaybeDocument.Builder newBuilder() {
        return (MaybeDocument.Builder)MaybeDocument.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.firestore.proto.MaybeDocument.Builder newBuilder(com.google.firebase.firestore.proto.MaybeDocument maybeDocument) {
        return (MaybeDocument.Builder)MaybeDocument.DEFAULT_INSTANCE.createBuilder(maybeDocument);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseDelimitedFrom(InputStream inputStream) {
        return (MaybeDocument)z.parseDelimitedFrom(MaybeDocument.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseDelimitedFrom(InputStream inputStream, q q2) {
        return (MaybeDocument)z.parseDelimitedFrom(MaybeDocument.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseFrom(j j) {
        return (MaybeDocument)z.parseFrom(MaybeDocument.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseFrom(j j, q q2) {
        return (MaybeDocument)z.parseFrom(MaybeDocument.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseFrom(k k) {
        return (MaybeDocument)z.parseFrom(MaybeDocument.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseFrom(k k, q q2) {
        return (MaybeDocument)z.parseFrom(MaybeDocument.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseFrom(InputStream inputStream) {
        return (MaybeDocument)z.parseFrom(MaybeDocument.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseFrom(InputStream inputStream, q q2) {
        return (MaybeDocument)z.parseFrom(MaybeDocument.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseFrom(ByteBuffer byteBuffer) {
        return (MaybeDocument)z.parseFrom(MaybeDocument.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseFrom(ByteBuffer byteBuffer, q q2) {
        return (MaybeDocument)z.parseFrom(MaybeDocument.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseFrom(byte[] bArr) {
        return (MaybeDocument)z.parseFrom(MaybeDocument.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.firestore.proto.MaybeDocument parseFrom(byte[] bArr, q q2) {
        return (MaybeDocument)z.parseFrom(MaybeDocument.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.firestore.proto.MaybeDocument> parser() {
        return MaybeDocument.DEFAULT_INSTANCE.getParserForType();
    }

    private void setDocument(h h) {
        h.getClass();
        this.documentType_ = h;
        this.documentTypeCase_ = 2;
    }

    private void setHasCommittedMutations(boolean z) {
        this.hasCommittedMutations_ = z;
    }

    private void setNoDocument(com.google.firebase.firestore.proto.NoDocument noDocument) {
        noDocument.getClass();
        this.documentType_ = noDocument;
        this.documentTypeCase_ = 1;
    }

    private void setUnknownDocument(com.google.firebase.firestore.proto.UnknownDocument unknownDocument) {
        unknownDocument.getClass();
        this.documentType_ = unknownDocument;
        this.documentTypeCase_ = 3;
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
                obj2 = new MaybeDocument();
                return obj2;
            case 2:
                obj2 = new MaybeDocument.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[6];
                obj2[obj3] = "documentTypeCase_";
                obj2[2] = NoDocument.class;
                obj2[3] = h.class;
                obj2[4] = UnknownDocument.class;
                obj2[5] = "hasCommittedMutations_";
                return z.newMessageInfo(MaybeDocument.DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004\u0007", obj2);
            case 4:
                return MaybeDocument.DEFAULT_INSTANCE;
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
        obj3 = MaybeDocument.class;
        synchronized (obj3) {
            obj2 = new z.b(MaybeDocument.DEFAULT_INSTANCE);
            MaybeDocument.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public h getDocument() {
        if (this.documentTypeCase_ == 2) {
            return (h)this.documentType_;
        }
        return h.f();
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.firestore.proto.MaybeDocument.DocumentTypeCase getDocumentTypeCase() {
        return MaybeDocument.DocumentTypeCase.forNumber(this.documentTypeCase_);
    }

    @Override // com.google.protobuf.z
    public boolean getHasCommittedMutations() {
        return this.hasCommittedMutations_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.firestore.proto.NoDocument getNoDocument() {
        if (this.documentTypeCase_ == 1) {
            return (NoDocument)this.documentType_;
        }
        return NoDocument.getDefaultInstance();
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.firestore.proto.UnknownDocument getUnknownDocument() {
        if (this.documentTypeCase_ == 3) {
            return (UnknownDocument)this.documentType_;
        }
        return UnknownDocument.getDefaultInstance();
    }

    @Override // com.google.protobuf.z
    public boolean hasDocument() {
        int i;
        i = this.documentTypeCase_ == 2 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasNoDocument() {
        int i;
        if (this.documentTypeCase_ == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasUnknownDocument() {
        int i;
        i = this.documentTypeCase_ == 3 ? 1 : 0;
        return i;
    }
}
