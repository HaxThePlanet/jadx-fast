package com.google.firebase.firestore.proto;

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
public final class TargetGlobal extends z<com.google.firebase.firestore.proto.TargetGlobal, com.google.firebase.firestore.proto.TargetGlobal.Builder> implements com.google.firebase.firestore.proto.TargetGlobalOrBuilder {

    private static final com.google.firebase.firestore.proto.TargetGlobal DEFAULT_INSTANCE = null;
    public static final int HIGHEST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 2;
    public static final int HIGHEST_TARGET_ID_FIELD_NUMBER = 1;
    public static final int LAST_REMOTE_SNAPSHOT_VERSION_FIELD_NUMBER = 3;
    private static volatile d1<com.google.firebase.firestore.proto.TargetGlobal> PARSER = null;
    public static final int TARGET_COUNT_FIELD_NUMBER = 4;
    private long highestListenSequenceNumber_;
    private int highestTargetId_;
    private r1 lastRemoteSnapshotVersion_;
    private int targetCount_;

    public static final class Builder extends z.a<com.google.firebase.firestore.proto.TargetGlobal, com.google.firebase.firestore.proto.TargetGlobal.Builder> implements com.google.firebase.firestore.proto.TargetGlobalOrBuilder {
        private Builder() {
            super(TargetGlobal.access$000());
        }

        Builder(com.google.firebase.firestore.proto.TargetGlobal.1 targetGlobal$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.TargetGlobal.Builder clearHighestListenSequenceNumber() {
            copyOnWrite();
            TargetGlobal.access$400((TargetGlobal)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.TargetGlobal.Builder clearHighestTargetId() {
            copyOnWrite();
            TargetGlobal.access$200((TargetGlobal)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.TargetGlobal.Builder clearLastRemoteSnapshotVersion() {
            copyOnWrite();
            TargetGlobal.access$700((TargetGlobal)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.TargetGlobal.Builder clearTargetCount() {
            copyOnWrite();
            TargetGlobal.access$900((TargetGlobal)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public long getHighestListenSequenceNumber() {
            return (TargetGlobal)this.instance.getHighestListenSequenceNumber();
        }

        @Override // com.google.protobuf.z$a
        public int getHighestTargetId() {
            return (TargetGlobal)this.instance.getHighestTargetId();
        }

        @Override // com.google.protobuf.z$a
        public r1 getLastRemoteSnapshotVersion() {
            return (TargetGlobal)this.instance.getLastRemoteSnapshotVersion();
        }

        @Override // com.google.protobuf.z$a
        public int getTargetCount() {
            return (TargetGlobal)this.instance.getTargetCount();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasLastRemoteSnapshotVersion() {
            return (TargetGlobal)this.instance.hasLastRemoteSnapshotVersion();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.TargetGlobal.Builder mergeLastRemoteSnapshotVersion(r1 r1) {
            copyOnWrite();
            TargetGlobal.access$600((TargetGlobal)this.instance, r1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.TargetGlobal.Builder setHighestListenSequenceNumber(long l) {
            copyOnWrite();
            TargetGlobal.access$300((TargetGlobal)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.TargetGlobal.Builder setHighestTargetId(int i) {
            copyOnWrite();
            TargetGlobal.access$100((TargetGlobal)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.TargetGlobal.Builder setLastRemoteSnapshotVersion(r1.b r1$b) {
            copyOnWrite();
            TargetGlobal.access$500((TargetGlobal)this.instance, (r1)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.TargetGlobal.Builder setLastRemoteSnapshotVersion(r1 r1) {
            copyOnWrite();
            TargetGlobal.access$500((TargetGlobal)this.instance, r1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.TargetGlobal.Builder setTargetCount(int i) {
            copyOnWrite();
            TargetGlobal.access$800((TargetGlobal)this.instance, i);
            return this;
        }
    }
    static {
        TargetGlobal targetGlobal = new TargetGlobal();
        TargetGlobal.DEFAULT_INSTANCE = targetGlobal;
        z.registerDefaultInstance(TargetGlobal.class, targetGlobal);
    }

    static com.google.firebase.firestore.proto.TargetGlobal access$000() {
        return TargetGlobal.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.firestore.proto.TargetGlobal targetGlobal, int i2) {
        targetGlobal.setHighestTargetId(i2);
    }

    static void access$200(com.google.firebase.firestore.proto.TargetGlobal targetGlobal) {
        targetGlobal.clearHighestTargetId();
    }

    static void access$300(com.google.firebase.firestore.proto.TargetGlobal targetGlobal, long l2) {
        targetGlobal.setHighestListenSequenceNumber(l2);
    }

    static void access$400(com.google.firebase.firestore.proto.TargetGlobal targetGlobal) {
        targetGlobal.clearHighestListenSequenceNumber();
    }

    static void access$500(com.google.firebase.firestore.proto.TargetGlobal targetGlobal, r1 r12) {
        targetGlobal.setLastRemoteSnapshotVersion(r12);
    }

    static void access$600(com.google.firebase.firestore.proto.TargetGlobal targetGlobal, r1 r12) {
        targetGlobal.mergeLastRemoteSnapshotVersion(r12);
    }

    static void access$700(com.google.firebase.firestore.proto.TargetGlobal targetGlobal) {
        targetGlobal.clearLastRemoteSnapshotVersion();
    }

    static void access$800(com.google.firebase.firestore.proto.TargetGlobal targetGlobal, int i2) {
        targetGlobal.setTargetCount(i2);
    }

    static void access$900(com.google.firebase.firestore.proto.TargetGlobal targetGlobal) {
        targetGlobal.clearTargetCount();
    }

    private void clearHighestListenSequenceNumber() {
        this.highestListenSequenceNumber_ = 0;
    }

    private void clearHighestTargetId() {
        this.highestTargetId_ = 0;
    }

    private void clearLastRemoteSnapshotVersion() {
        this.lastRemoteSnapshotVersion_ = 0;
    }

    private void clearTargetCount() {
        this.targetCount_ = 0;
    }

    public static com.google.firebase.firestore.proto.TargetGlobal getDefaultInstance() {
        return TargetGlobal.DEFAULT_INSTANCE;
    }

    private void mergeLastRemoteSnapshotVersion(r1 r1) {
        Object lastRemoteSnapshotVersion_;
        r1 r1Var;
        z obj3;
        r1.getClass();
        lastRemoteSnapshotVersion_ = this.lastRemoteSnapshotVersion_;
        if (lastRemoteSnapshotVersion_ != null && lastRemoteSnapshotVersion_ != r1.e()) {
            if (lastRemoteSnapshotVersion_ != r1.e()) {
                this.lastRemoteSnapshotVersion_ = (r1)(r1.b)r1.i(this.lastRemoteSnapshotVersion_).mergeFrom(r1).buildPartial();
            } else {
                this.lastRemoteSnapshotVersion_ = r1;
            }
        } else {
        }
    }

    public static com.google.firebase.firestore.proto.TargetGlobal.Builder newBuilder() {
        return (TargetGlobal.Builder)TargetGlobal.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.firestore.proto.TargetGlobal.Builder newBuilder(com.google.firebase.firestore.proto.TargetGlobal targetGlobal) {
        return (TargetGlobal.Builder)TargetGlobal.DEFAULT_INSTANCE.createBuilder(targetGlobal);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseDelimitedFrom(InputStream inputStream) {
        return (TargetGlobal)z.parseDelimitedFrom(TargetGlobal.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseDelimitedFrom(InputStream inputStream, q q2) {
        return (TargetGlobal)z.parseDelimitedFrom(TargetGlobal.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseFrom(j j) {
        return (TargetGlobal)z.parseFrom(TargetGlobal.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseFrom(j j, q q2) {
        return (TargetGlobal)z.parseFrom(TargetGlobal.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseFrom(k k) {
        return (TargetGlobal)z.parseFrom(TargetGlobal.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseFrom(k k, q q2) {
        return (TargetGlobal)z.parseFrom(TargetGlobal.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseFrom(InputStream inputStream) {
        return (TargetGlobal)z.parseFrom(TargetGlobal.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseFrom(InputStream inputStream, q q2) {
        return (TargetGlobal)z.parseFrom(TargetGlobal.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseFrom(ByteBuffer byteBuffer) {
        return (TargetGlobal)z.parseFrom(TargetGlobal.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseFrom(ByteBuffer byteBuffer, q q2) {
        return (TargetGlobal)z.parseFrom(TargetGlobal.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseFrom(byte[] bArr) {
        return (TargetGlobal)z.parseFrom(TargetGlobal.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.firestore.proto.TargetGlobal parseFrom(byte[] bArr, q q2) {
        return (TargetGlobal)z.parseFrom(TargetGlobal.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.firestore.proto.TargetGlobal> parser() {
        return TargetGlobal.DEFAULT_INSTANCE.getParserForType();
    }

    private void setHighestListenSequenceNumber(long l) {
        this.highestListenSequenceNumber_ = l;
    }

    private void setHighestTargetId(int i) {
        this.highestTargetId_ = i;
    }

    private void setLastRemoteSnapshotVersion(r1 r1) {
        r1.getClass();
        this.lastRemoteSnapshotVersion_ = r1;
    }

    private void setTargetCount(int i) {
        this.targetCount_ = i;
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
                obj2 = new TargetGlobal();
                return obj2;
            case 2:
                obj2 = new TargetGlobal.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[4];
                obj2[obj3] = "highestListenSequenceNumber_";
                obj2[2] = "lastRemoteSnapshotVersion_";
                obj2[3] = "targetCount_";
                return z.newMessageInfo(TargetGlobal.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\t\u0004\u0004", obj2);
            case 4:
                return TargetGlobal.DEFAULT_INSTANCE;
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
        obj3 = TargetGlobal.class;
        synchronized (obj3) {
            obj2 = new z.b(TargetGlobal.DEFAULT_INSTANCE);
            TargetGlobal.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public long getHighestListenSequenceNumber() {
        return this.highestListenSequenceNumber_;
    }

    @Override // com.google.protobuf.z
    public int getHighestTargetId() {
        return this.highestTargetId_;
    }

    @Override // com.google.protobuf.z
    public r1 getLastRemoteSnapshotVersion() {
        r1 lastRemoteSnapshotVersion_;
        if (this.lastRemoteSnapshotVersion_ == null) {
            lastRemoteSnapshotVersion_ = r1.e();
        }
        return lastRemoteSnapshotVersion_;
    }

    @Override // com.google.protobuf.z
    public int getTargetCount() {
        return this.targetCount_;
    }

    @Override // com.google.protobuf.z
    public boolean hasLastRemoteSnapshotVersion() {
        int i;
        i = this.lastRemoteSnapshotVersion_ != null ? 1 : 0;
        return i;
    }
}
