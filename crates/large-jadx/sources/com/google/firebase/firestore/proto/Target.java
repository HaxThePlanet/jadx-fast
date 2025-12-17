package com.google.firebase.firestore.proto;

import android.accounts.Account;
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
import f.c.e.c.u.c;
import f.c.e.c.u.c.a;
import f.c.e.c.u.d;
import f.c.e.c.u.d.a;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class Target extends z<com.google.firebase.firestore.proto.Target, com.google.firebase.firestore.proto.Target.Builder> implements com.google.firebase.firestore.proto.TargetOrBuilder {

    private static final com.google.firebase.firestore.proto.Target DEFAULT_INSTANCE = null;
    public static final int DOCUMENTS_FIELD_NUMBER = 6;
    public static final int LAST_LIMBO_FREE_SNAPSHOT_VERSION_FIELD_NUMBER = 7;
    public static final int LAST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 4;
    private static volatile d1<com.google.firebase.firestore.proto.Target> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 5;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 3;
    public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 2;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private r1 lastLimboFreeSnapshotVersion_;
    private long lastListenSequenceNumber_;
    private j resumeToken_ = null;
    private r1 snapshotVersion_;
    private int targetId_;
    private int targetTypeCase_ = 0;
    private Object targetType_;

    public static enum TargetTypeCase {

        QUERY(5),
        DOCUMENTS(6),
        TARGETTYPE_NOT_SET(false);

        private final int value;
        public static com.google.firebase.firestore.proto.Target.TargetTypeCase forNumber(int i) {
            if (i != 0 && i != 5 && i != 6) {
                if (i != 5) {
                    if (i != 6) {
                        return null;
                    }
                    return Target.TargetTypeCase.DOCUMENTS;
                }
                return Target.TargetTypeCase.QUERY;
            }
            return Target.TargetTypeCase.TARGETTYPE_NOT_SET;
        }

        @Deprecated
        public static com.google.firebase.firestore.proto.Target.TargetTypeCase valueOf(int i) {
            return Target.TargetTypeCase.forNumber(i);
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.value;
        }
    }

    public static final class Builder extends z.a<com.google.firebase.firestore.proto.Target, com.google.firebase.firestore.proto.Target.Builder> implements com.google.firebase.firestore.proto.TargetOrBuilder {
        private Builder() {
            super(Target.access$000());
        }

        Builder(com.google.firebase.firestore.proto.Target.1 target$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder clearDocuments() {
            copyOnWrite();
            Target.access$1600((Target)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder clearLastLimboFreeSnapshotVersion() {
            copyOnWrite();
            Target.access$1900((Target)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder clearLastListenSequenceNumber() {
            copyOnWrite();
            Target.access$1000((Target)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder clearQuery() {
            copyOnWrite();
            Target.access$1300((Target)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder clearResumeToken() {
            copyOnWrite();
            Target.access$800((Target)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder clearSnapshotVersion() {
            copyOnWrite();
            Target.access$600((Target)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder clearTargetId() {
            copyOnWrite();
            Target.access$300((Target)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder clearTargetType() {
            copyOnWrite();
            Target.access$100((Target)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public u.c getDocuments() {
            return (Target)this.instance.getDocuments();
        }

        @Override // com.google.protobuf.z$a
        public r1 getLastLimboFreeSnapshotVersion() {
            return (Target)this.instance.getLastLimboFreeSnapshotVersion();
        }

        @Override // com.google.protobuf.z$a
        public long getLastListenSequenceNumber() {
            return (Target)this.instance.getLastListenSequenceNumber();
        }

        @Override // com.google.protobuf.z$a
        public u.d getQuery() {
            return (Target)this.instance.getQuery();
        }

        @Override // com.google.protobuf.z$a
        public j getResumeToken() {
            return (Target)this.instance.getResumeToken();
        }

        @Override // com.google.protobuf.z$a
        public r1 getSnapshotVersion() {
            return (Target)this.instance.getSnapshotVersion();
        }

        @Override // com.google.protobuf.z$a
        public int getTargetId() {
            return (Target)this.instance.getTargetId();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.TargetTypeCase getTargetTypeCase() {
            return (Target)this.instance.getTargetTypeCase();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasDocuments() {
            return (Target)this.instance.hasDocuments();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasLastLimboFreeSnapshotVersion() {
            return (Target)this.instance.hasLastLimboFreeSnapshotVersion();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasQuery() {
            return (Target)this.instance.hasQuery();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasSnapshotVersion() {
            return (Target)this.instance.hasSnapshotVersion();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder mergeDocuments(u.c u$c) {
            copyOnWrite();
            Target.access$1500((Target)this.instance, c);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder mergeLastLimboFreeSnapshotVersion(r1 r1) {
            copyOnWrite();
            Target.access$1800((Target)this.instance, r1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder mergeQuery(u.d u$d) {
            copyOnWrite();
            Target.access$1200((Target)this.instance, d);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder mergeSnapshotVersion(r1 r1) {
            copyOnWrite();
            Target.access$500((Target)this.instance, r1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder setDocuments(u.c.a u$c$a) {
            copyOnWrite();
            Target.access$1400((Target)this.instance, (u.c)a.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder setDocuments(u.c u$c) {
            copyOnWrite();
            Target.access$1400((Target)this.instance, c);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder setLastLimboFreeSnapshotVersion(r1.b r1$b) {
            copyOnWrite();
            Target.access$1700((Target)this.instance, (r1)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder setLastLimboFreeSnapshotVersion(r1 r1) {
            copyOnWrite();
            Target.access$1700((Target)this.instance, r1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder setLastListenSequenceNumber(long l) {
            copyOnWrite();
            Target.access$900((Target)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder setQuery(u.d.a u$d$a) {
            copyOnWrite();
            Target.access$1100((Target)this.instance, (u.d)a.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder setQuery(u.d u$d) {
            copyOnWrite();
            Target.access$1100((Target)this.instance, d);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder setResumeToken(j j) {
            copyOnWrite();
            Target.access$700((Target)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder setSnapshotVersion(r1.b r1$b) {
            copyOnWrite();
            Target.access$400((Target)this.instance, (r1)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder setSnapshotVersion(r1 r1) {
            copyOnWrite();
            Target.access$400((Target)this.instance, r1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.Target.Builder setTargetId(int i) {
            copyOnWrite();
            Target.access$200((Target)this.instance, i);
            return this;
        }
    }
    static {
        Target target = new Target();
        Target.DEFAULT_INSTANCE = target;
        z.registerDefaultInstance(Target.class, target);
    }

    private Target() {
        super();
        int i = 0;
        j jVar = j.a;
    }

    static com.google.firebase.firestore.proto.Target access$000() {
        return Target.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.firestore.proto.Target target) {
        target.clearTargetType();
    }

    static void access$1000(com.google.firebase.firestore.proto.Target target) {
        target.clearLastListenSequenceNumber();
    }

    static void access$1100(com.google.firebase.firestore.proto.Target target, u.d u$d2) {
        target.setQuery(d2);
    }

    static void access$1200(com.google.firebase.firestore.proto.Target target, u.d u$d2) {
        target.mergeQuery(d2);
    }

    static void access$1300(com.google.firebase.firestore.proto.Target target) {
        target.clearQuery();
    }

    static void access$1400(com.google.firebase.firestore.proto.Target target, u.c u$c2) {
        target.setDocuments(c2);
    }

    static void access$1500(com.google.firebase.firestore.proto.Target target, u.c u$c2) {
        target.mergeDocuments(c2);
    }

    static void access$1600(com.google.firebase.firestore.proto.Target target) {
        target.clearDocuments();
    }

    static void access$1700(com.google.firebase.firestore.proto.Target target, r1 r12) {
        target.setLastLimboFreeSnapshotVersion(r12);
    }

    static void access$1800(com.google.firebase.firestore.proto.Target target, r1 r12) {
        target.mergeLastLimboFreeSnapshotVersion(r12);
    }

    static void access$1900(com.google.firebase.firestore.proto.Target target) {
        target.clearLastLimboFreeSnapshotVersion();
    }

    static void access$200(com.google.firebase.firestore.proto.Target target, int i2) {
        target.setTargetId(i2);
    }

    static void access$300(com.google.firebase.firestore.proto.Target target) {
        target.clearTargetId();
    }

    static void access$400(com.google.firebase.firestore.proto.Target target, r1 r12) {
        target.setSnapshotVersion(r12);
    }

    static void access$500(com.google.firebase.firestore.proto.Target target, r1 r12) {
        target.mergeSnapshotVersion(r12);
    }

    static void access$600(com.google.firebase.firestore.proto.Target target) {
        target.clearSnapshotVersion();
    }

    static void access$700(com.google.firebase.firestore.proto.Target target, j j2) {
        target.setResumeToken(j2);
    }

    static void access$800(com.google.firebase.firestore.proto.Target target) {
        target.clearResumeToken();
    }

    static void access$900(com.google.firebase.firestore.proto.Target target, long l2) {
        target.setLastListenSequenceNumber(l2);
    }

    private void clearDocuments() {
        int targetTypeCase_;
        if (this.targetTypeCase_ == 6) {
            this.targetTypeCase_ = 0;
            this.targetType_ = 0;
        }
    }

    private void clearLastLimboFreeSnapshotVersion() {
        this.lastLimboFreeSnapshotVersion_ = 0;
    }

    private void clearLastListenSequenceNumber() {
        this.lastListenSequenceNumber_ = 0;
    }

    private void clearQuery() {
        int targetTypeCase_;
        if (this.targetTypeCase_ == 5) {
            this.targetTypeCase_ = 0;
            this.targetType_ = 0;
        }
    }

    private void clearResumeToken() {
        this.resumeToken_ = Target.getDefaultInstance().getResumeToken();
    }

    private void clearSnapshotVersion() {
        this.snapshotVersion_ = 0;
    }

    private void clearTargetId() {
        this.targetId_ = 0;
    }

    private void clearTargetType() {
        this.targetTypeCase_ = 0;
        this.targetType_ = 0;
    }

    public static com.google.firebase.firestore.proto.Target getDefaultInstance() {
        return Target.DEFAULT_INSTANCE;
    }

    private void mergeDocuments(u.c u$c) {
        int targetTypeCase_;
        u.c cVar;
        z obj4;
        c.getClass();
        final int i = 6;
        if (this.targetTypeCase_ == i && this.targetType_ != u.c.f()) {
            if (this.targetType_ != u.c.f()) {
                this.targetType_ = (u.c.a)u.c.j((u.c)this.targetType_).mergeFrom(c).buildPartial();
            } else {
                this.targetType_ = c;
            }
        } else {
        }
        this.targetTypeCase_ = i;
    }

    private void mergeLastLimboFreeSnapshotVersion(r1 r1) {
        Object lastLimboFreeSnapshotVersion_;
        r1 r1Var;
        z obj3;
        r1.getClass();
        lastLimboFreeSnapshotVersion_ = this.lastLimboFreeSnapshotVersion_;
        if (lastLimboFreeSnapshotVersion_ != null && lastLimboFreeSnapshotVersion_ != r1.e()) {
            if (lastLimboFreeSnapshotVersion_ != r1.e()) {
                this.lastLimboFreeSnapshotVersion_ = (r1)(r1.b)r1.i(this.lastLimboFreeSnapshotVersion_).mergeFrom(r1).buildPartial();
            } else {
                this.lastLimboFreeSnapshotVersion_ = r1;
            }
        } else {
        }
    }

    private void mergeQuery(u.d u$d) {
        int targetTypeCase_;
        u.d dVar;
        z obj4;
        d.getClass();
        final int i = 5;
        if (this.targetTypeCase_ == i && this.targetType_ != u.d.e()) {
            if (this.targetType_ != u.d.e()) {
                this.targetType_ = (u.d.a)u.d.i((u.d)this.targetType_).mergeFrom(d).buildPartial();
            } else {
                this.targetType_ = d;
            }
        } else {
        }
        this.targetTypeCase_ = i;
    }

    private void mergeSnapshotVersion(r1 r1) {
        Object snapshotVersion_;
        r1 r1Var;
        z obj3;
        r1.getClass();
        snapshotVersion_ = this.snapshotVersion_;
        if (snapshotVersion_ != null && snapshotVersion_ != r1.e()) {
            if (snapshotVersion_ != r1.e()) {
                this.snapshotVersion_ = (r1)(r1.b)r1.i(this.snapshotVersion_).mergeFrom(r1).buildPartial();
            } else {
                this.snapshotVersion_ = r1;
            }
        } else {
        }
    }

    public static com.google.firebase.firestore.proto.Target.Builder newBuilder() {
        return (Target.Builder)Target.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.firestore.proto.Target.Builder newBuilder(com.google.firebase.firestore.proto.Target target) {
        return (Target.Builder)Target.DEFAULT_INSTANCE.createBuilder(target);
    }

    public static com.google.firebase.firestore.proto.Target parseDelimitedFrom(InputStream inputStream) {
        return (Target)z.parseDelimitedFrom(Target.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.Target parseDelimitedFrom(InputStream inputStream, q q2) {
        return (Target)z.parseDelimitedFrom(Target.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.Target parseFrom(j j) {
        return (Target)z.parseFrom(Target.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.firestore.proto.Target parseFrom(j j, q q2) {
        return (Target)z.parseFrom(Target.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.firestore.proto.Target parseFrom(k k) {
        return (Target)z.parseFrom(Target.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.firestore.proto.Target parseFrom(k k, q q2) {
        return (Target)z.parseFrom(Target.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.firestore.proto.Target parseFrom(InputStream inputStream) {
        return (Target)z.parseFrom(Target.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.Target parseFrom(InputStream inputStream, q q2) {
        return (Target)z.parseFrom(Target.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.Target parseFrom(ByteBuffer byteBuffer) {
        return (Target)z.parseFrom(Target.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.firestore.proto.Target parseFrom(ByteBuffer byteBuffer, q q2) {
        return (Target)z.parseFrom(Target.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.firestore.proto.Target parseFrom(byte[] bArr) {
        return (Target)z.parseFrom(Target.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.firestore.proto.Target parseFrom(byte[] bArr, q q2) {
        return (Target)z.parseFrom(Target.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.firestore.proto.Target> parser() {
        return Target.DEFAULT_INSTANCE.getParserForType();
    }

    private void setDocuments(u.c u$c) {
        c.getClass();
        this.targetType_ = c;
        this.targetTypeCase_ = 6;
    }

    private void setLastLimboFreeSnapshotVersion(r1 r1) {
        r1.getClass();
        this.lastLimboFreeSnapshotVersion_ = r1;
    }

    private void setLastListenSequenceNumber(long l) {
        this.lastListenSequenceNumber_ = l;
    }

    private void setQuery(u.d u$d) {
        d.getClass();
        this.targetType_ = d;
        this.targetTypeCase_ = 5;
    }

    private void setResumeToken(j j) {
        j.getClass();
        this.resumeToken_ = j;
    }

    private void setSnapshotVersion(r1 r1) {
        r1.getClass();
        this.snapshotVersion_ = r1;
    }

    private void setTargetId(int i) {
        this.targetId_ = i;
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
                obj2 = new Target();
                return obj2;
            case 2:
                obj2 = new Target.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[9];
                obj2[obj3] = "targetTypeCase_";
                obj2[2] = "targetId_";
                obj2[3] = "snapshotVersion_";
                obj2[4] = "resumeToken_";
                obj2[5] = "lastListenSequenceNumber_";
                obj2[6] = u.d.class;
                obj2[7] = u.c.class;
                obj2[8] = "lastLimboFreeSnapshotVersion_";
                return z.newMessageInfo(Target.DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002\t\u0003\n\u0004\u0002\u0005<\u0000\u0006<\u0000\u0007\t", obj2);
            case 4:
                return Target.DEFAULT_INSTANCE;
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
        obj3 = Target.class;
        synchronized (obj3) {
            obj2 = new z.b(Target.DEFAULT_INSTANCE);
            Target.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public u.c getDocuments() {
        if (this.targetTypeCase_ == 6) {
            return (u.c)this.targetType_;
        }
        return u.c.f();
    }

    @Override // com.google.protobuf.z
    public r1 getLastLimboFreeSnapshotVersion() {
        r1 lastLimboFreeSnapshotVersion_;
        if (this.lastLimboFreeSnapshotVersion_ == null) {
            lastLimboFreeSnapshotVersion_ = r1.e();
        }
        return lastLimboFreeSnapshotVersion_;
    }

    @Override // com.google.protobuf.z
    public long getLastListenSequenceNumber() {
        return this.lastListenSequenceNumber_;
    }

    @Override // com.google.protobuf.z
    public u.d getQuery() {
        if (this.targetTypeCase_ == 5) {
            return (u.d)this.targetType_;
        }
        return u.d.e();
    }

    @Override // com.google.protobuf.z
    public j getResumeToken() {
        return this.resumeToken_;
    }

    @Override // com.google.protobuf.z
    public r1 getSnapshotVersion() {
        r1 snapshotVersion_;
        if (this.snapshotVersion_ == null) {
            snapshotVersion_ = r1.e();
        }
        return snapshotVersion_;
    }

    @Override // com.google.protobuf.z
    public int getTargetId() {
        return this.targetId_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.firestore.proto.Target.TargetTypeCase getTargetTypeCase() {
        return Target.TargetTypeCase.forNumber(this.targetTypeCase_);
    }

    @Override // com.google.protobuf.z
    public boolean hasDocuments() {
        int i;
        i = this.targetTypeCase_ == 6 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasLastLimboFreeSnapshotVersion() {
        int i;
        i = this.lastLimboFreeSnapshotVersion_ != null ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasQuery() {
        int i;
        i = this.targetTypeCase_ == 5 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasSnapshotVersion() {
        int i;
        i = this.snapshotVersion_ != null ? 1 : 0;
        return i;
    }
}
