package com.google.firebase.firestore.proto;

import com.google.protobuf.a;
import com.google.protobuf.c0.j;
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
import f.c.e.c.y;
import f.c.e.c.y.b;
import f.c.e.c.z;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class WriteBatch extends z<com.google.firebase.firestore.proto.WriteBatch, com.google.firebase.firestore.proto.WriteBatch.Builder> implements com.google.firebase.firestore.proto.WriteBatchOrBuilder {

    public static final int BASE_WRITES_FIELD_NUMBER = 4;
    public static final int BATCH_ID_FIELD_NUMBER = 1;
    private static final com.google.firebase.firestore.proto.WriteBatch DEFAULT_INSTANCE = null;
    public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
    private static volatile d1<com.google.firebase.firestore.proto.WriteBatch> PARSER = null;
    public static final int WRITES_FIELD_NUMBER = 2;
    private c0.j<y> baseWrites_;
    private int batchId_;
    private r1 localWriteTime_;
    private c0.j<y> writes_;

    public static final class Builder extends z.a<com.google.firebase.firestore.proto.WriteBatch, com.google.firebase.firestore.proto.WriteBatch.Builder> implements com.google.firebase.firestore.proto.WriteBatchOrBuilder {
        private Builder() {
            super(WriteBatch.access$000());
        }

        Builder(com.google.firebase.firestore.proto.WriteBatch.1 writeBatch$1) {
            super();
        }

        public com.google.firebase.firestore.proto.WriteBatch.Builder addAllBaseWrites(Iterable<? extends y> iterable) {
            copyOnWrite();
            WriteBatch.access$1500((WriteBatch)this.instance, iterable);
            return this;
        }

        public com.google.firebase.firestore.proto.WriteBatch.Builder addAllWrites(Iterable<? extends y> iterable) {
            copyOnWrite();
            WriteBatch.access$600((WriteBatch)this.instance, iterable);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder addBaseWrites(int i, y.b y$b2) {
            copyOnWrite();
            WriteBatch.access$1400((WriteBatch)this.instance, i, (y)b2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder addBaseWrites(int i, y y2) {
            copyOnWrite();
            WriteBatch.access$1400((WriteBatch)this.instance, i, y2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder addBaseWrites(y.b y$b) {
            copyOnWrite();
            WriteBatch.access$1300((WriteBatch)this.instance, (y)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder addBaseWrites(y y) {
            copyOnWrite();
            WriteBatch.access$1300((WriteBatch)this.instance, y);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder addWrites(int i, y.b y$b2) {
            copyOnWrite();
            WriteBatch.access$500((WriteBatch)this.instance, i, (y)b2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder addWrites(int i, y y2) {
            copyOnWrite();
            WriteBatch.access$500((WriteBatch)this.instance, i, y2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder addWrites(y.b y$b) {
            copyOnWrite();
            WriteBatch.access$400((WriteBatch)this.instance, (y)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder addWrites(y y) {
            copyOnWrite();
            WriteBatch.access$400((WriteBatch)this.instance, y);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder clearBaseWrites() {
            copyOnWrite();
            WriteBatch.access$1600((WriteBatch)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder clearBatchId() {
            copyOnWrite();
            WriteBatch.access$200((WriteBatch)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder clearLocalWriteTime() {
            copyOnWrite();
            WriteBatch.access$1100((WriteBatch)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder clearWrites() {
            copyOnWrite();
            WriteBatch.access$700((WriteBatch)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public y getBaseWrites(int i) {
            return (WriteBatch)this.instance.getBaseWrites(i);
        }

        @Override // com.google.protobuf.z$a
        public int getBaseWritesCount() {
            return (WriteBatch)this.instance.getBaseWritesCount();
        }

        public List<y> getBaseWritesList() {
            return Collections.unmodifiableList((WriteBatch)this.instance.getBaseWritesList());
        }

        @Override // com.google.protobuf.z$a
        public int getBatchId() {
            return (WriteBatch)this.instance.getBatchId();
        }

        @Override // com.google.protobuf.z$a
        public r1 getLocalWriteTime() {
            return (WriteBatch)this.instance.getLocalWriteTime();
        }

        @Override // com.google.protobuf.z$a
        public y getWrites(int i) {
            return (WriteBatch)this.instance.getWrites(i);
        }

        @Override // com.google.protobuf.z$a
        public int getWritesCount() {
            return (WriteBatch)this.instance.getWritesCount();
        }

        public List<y> getWritesList() {
            return Collections.unmodifiableList((WriteBatch)this.instance.getWritesList());
        }

        @Override // com.google.protobuf.z$a
        public boolean hasLocalWriteTime() {
            return (WriteBatch)this.instance.hasLocalWriteTime();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder mergeLocalWriteTime(r1 r1) {
            copyOnWrite();
            WriteBatch.access$1000((WriteBatch)this.instance, r1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder removeBaseWrites(int i) {
            copyOnWrite();
            WriteBatch.access$1700((WriteBatch)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder removeWrites(int i) {
            copyOnWrite();
            WriteBatch.access$800((WriteBatch)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder setBaseWrites(int i, y.b y$b2) {
            copyOnWrite();
            WriteBatch.access$1200((WriteBatch)this.instance, i, (y)b2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder setBaseWrites(int i, y y2) {
            copyOnWrite();
            WriteBatch.access$1200((WriteBatch)this.instance, i, y2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder setBatchId(int i) {
            copyOnWrite();
            WriteBatch.access$100((WriteBatch)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder setLocalWriteTime(r1.b r1$b) {
            copyOnWrite();
            WriteBatch.access$900((WriteBatch)this.instance, (r1)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder setLocalWriteTime(r1 r1) {
            copyOnWrite();
            WriteBatch.access$900((WriteBatch)this.instance, r1);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder setWrites(int i, y.b y$b2) {
            copyOnWrite();
            WriteBatch.access$300((WriteBatch)this.instance, i, (y)b2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.WriteBatch.Builder setWrites(int i, y y2) {
            copyOnWrite();
            WriteBatch.access$300((WriteBatch)this.instance, i, y2);
            return this;
        }
    }
    static {
        WriteBatch writeBatch = new WriteBatch();
        WriteBatch.DEFAULT_INSTANCE = writeBatch;
        z.registerDefaultInstance(WriteBatch.class, writeBatch);
    }

    private WriteBatch() {
        super();
        this.writes_ = z.emptyProtobufList();
        this.baseWrites_ = z.emptyProtobufList();
    }

    static com.google.firebase.firestore.proto.WriteBatch access$000() {
        return WriteBatch.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.firestore.proto.WriteBatch writeBatch, int i2) {
        writeBatch.setBatchId(i2);
    }

    static void access$1000(com.google.firebase.firestore.proto.WriteBatch writeBatch, r1 r12) {
        writeBatch.mergeLocalWriteTime(r12);
    }

    static void access$1100(com.google.firebase.firestore.proto.WriteBatch writeBatch) {
        writeBatch.clearLocalWriteTime();
    }

    static void access$1200(com.google.firebase.firestore.proto.WriteBatch writeBatch, int i2, y y3) {
        writeBatch.setBaseWrites(i2, y3);
    }

    static void access$1300(com.google.firebase.firestore.proto.WriteBatch writeBatch, y y2) {
        writeBatch.addBaseWrites(y2);
    }

    static void access$1400(com.google.firebase.firestore.proto.WriteBatch writeBatch, int i2, y y3) {
        writeBatch.addBaseWrites(i2, y3);
    }

    static void access$1500(com.google.firebase.firestore.proto.WriteBatch writeBatch, Iterable iterable2) {
        writeBatch.addAllBaseWrites(iterable2);
    }

    static void access$1600(com.google.firebase.firestore.proto.WriteBatch writeBatch) {
        writeBatch.clearBaseWrites();
    }

    static void access$1700(com.google.firebase.firestore.proto.WriteBatch writeBatch, int i2) {
        writeBatch.removeBaseWrites(i2);
    }

    static void access$200(com.google.firebase.firestore.proto.WriteBatch writeBatch) {
        writeBatch.clearBatchId();
    }

    static void access$300(com.google.firebase.firestore.proto.WriteBatch writeBatch, int i2, y y3) {
        writeBatch.setWrites(i2, y3);
    }

    static void access$400(com.google.firebase.firestore.proto.WriteBatch writeBatch, y y2) {
        writeBatch.addWrites(y2);
    }

    static void access$500(com.google.firebase.firestore.proto.WriteBatch writeBatch, int i2, y y3) {
        writeBatch.addWrites(i2, y3);
    }

    static void access$600(com.google.firebase.firestore.proto.WriteBatch writeBatch, Iterable iterable2) {
        writeBatch.addAllWrites(iterable2);
    }

    static void access$700(com.google.firebase.firestore.proto.WriteBatch writeBatch) {
        writeBatch.clearWrites();
    }

    static void access$800(com.google.firebase.firestore.proto.WriteBatch writeBatch, int i2) {
        writeBatch.removeWrites(i2);
    }

    static void access$900(com.google.firebase.firestore.proto.WriteBatch writeBatch, r1 r12) {
        writeBatch.setLocalWriteTime(r12);
    }

    private void addAllBaseWrites(Iterable<? extends y> iterable) {
        ensureBaseWritesIsMutable();
        a.addAll(iterable, this.baseWrites_);
    }

    private void addAllWrites(Iterable<? extends y> iterable) {
        ensureWritesIsMutable();
        a.addAll(iterable, this.writes_);
    }

    private void addBaseWrites(int i, y y2) {
        y2.getClass();
        ensureBaseWritesIsMutable();
        this.baseWrites_.add(i, y2);
    }

    private void addBaseWrites(y y) {
        y.getClass();
        ensureBaseWritesIsMutable();
        this.baseWrites_.add(y);
    }

    private void addWrites(int i, y y2) {
        y2.getClass();
        ensureWritesIsMutable();
        this.writes_.add(i, y2);
    }

    private void addWrites(y y) {
        y.getClass();
        ensureWritesIsMutable();
        this.writes_.add(y);
    }

    private void clearBaseWrites() {
        this.baseWrites_ = z.emptyProtobufList();
    }

    private void clearBatchId() {
        this.batchId_ = 0;
    }

    private void clearLocalWriteTime() {
        this.localWriteTime_ = 0;
    }

    private void clearWrites() {
        this.writes_ = z.emptyProtobufList();
    }

    private void ensureBaseWritesIsMutable() {
        c0.j baseWrites_;
        baseWrites_ = this.baseWrites_;
        if (!baseWrites_.c2()) {
            this.baseWrites_ = z.mutableCopy(baseWrites_);
        }
    }

    private void ensureWritesIsMutable() {
        c0.j mutableCopy;
        mutableCopy = this.writes_;
        if (!mutableCopy.c2()) {
            this.writes_ = z.mutableCopy(mutableCopy);
        }
    }

    public static com.google.firebase.firestore.proto.WriteBatch getDefaultInstance() {
        return WriteBatch.DEFAULT_INSTANCE;
    }

    private void mergeLocalWriteTime(r1 r1) {
        Object localWriteTime_;
        r1 r1Var;
        z obj3;
        r1.getClass();
        localWriteTime_ = this.localWriteTime_;
        if (localWriteTime_ != null && localWriteTime_ != r1.e()) {
            if (localWriteTime_ != r1.e()) {
                this.localWriteTime_ = (r1)(r1.b)r1.i(this.localWriteTime_).mergeFrom(r1).buildPartial();
            } else {
                this.localWriteTime_ = r1;
            }
        } else {
        }
    }

    public static com.google.firebase.firestore.proto.WriteBatch.Builder newBuilder() {
        return (WriteBatch.Builder)WriteBatch.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.firestore.proto.WriteBatch.Builder newBuilder(com.google.firebase.firestore.proto.WriteBatch writeBatch) {
        return (WriteBatch.Builder)WriteBatch.DEFAULT_INSTANCE.createBuilder(writeBatch);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseDelimitedFrom(InputStream inputStream) {
        return (WriteBatch)z.parseDelimitedFrom(WriteBatch.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseDelimitedFrom(InputStream inputStream, q q2) {
        return (WriteBatch)z.parseDelimitedFrom(WriteBatch.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseFrom(j j) {
        return (WriteBatch)z.parseFrom(WriteBatch.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseFrom(j j, q q2) {
        return (WriteBatch)z.parseFrom(WriteBatch.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseFrom(k k) {
        return (WriteBatch)z.parseFrom(WriteBatch.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseFrom(k k, q q2) {
        return (WriteBatch)z.parseFrom(WriteBatch.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseFrom(InputStream inputStream) {
        return (WriteBatch)z.parseFrom(WriteBatch.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseFrom(InputStream inputStream, q q2) {
        return (WriteBatch)z.parseFrom(WriteBatch.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseFrom(ByteBuffer byteBuffer) {
        return (WriteBatch)z.parseFrom(WriteBatch.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseFrom(ByteBuffer byteBuffer, q q2) {
        return (WriteBatch)z.parseFrom(WriteBatch.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseFrom(byte[] bArr) {
        return (WriteBatch)z.parseFrom(WriteBatch.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.firestore.proto.WriteBatch parseFrom(byte[] bArr, q q2) {
        return (WriteBatch)z.parseFrom(WriteBatch.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.firestore.proto.WriteBatch> parser() {
        return WriteBatch.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBaseWrites(int i) {
        ensureBaseWritesIsMutable();
        this.baseWrites_.remove(i);
    }

    private void removeWrites(int i) {
        ensureWritesIsMutable();
        this.writes_.remove(i);
    }

    private void setBaseWrites(int i, y y2) {
        y2.getClass();
        ensureBaseWritesIsMutable();
        this.baseWrites_.set(i, y2);
    }

    private void setBatchId(int i) {
        this.batchId_ = i;
    }

    private void setLocalWriteTime(r1 r1) {
        r1.getClass();
        this.localWriteTime_ = r1;
    }

    private void setWrites(int i, y y2) {
        y2.getClass();
        ensureWritesIsMutable();
        this.writes_.set(i, y2);
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
        d1 obj3;
        Class<y> obj4;
        int obj5;
        obj4 = y.class;
        obj5 = 1;
        int i = 0;
        switch (obj3) {
            case 1:
                obj3 = new WriteBatch();
                return obj3;
            case 2:
                obj3 = new WriteBatch.Builder(i);
                return obj3;
            case 3:
                obj3 = new Object[6];
                obj3[obj5] = "writes_";
                obj3[2] = obj4;
                obj3[3] = "localWriteTime_";
                obj3[4] = "baseWrites_";
                obj3[5] = obj4;
                return z.newMessageInfo(WriteBatch.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003\t\u0004\u001b", obj3);
            case 4:
                return WriteBatch.DEFAULT_INSTANCE;
            case 5:
                return obj3;
            case 6:
                return Byte.valueOf(obj5);
            case 7:
                return i;
            default:
                obj3 = new UnsupportedOperationException();
                throw obj3;
        }
        obj4 = WriteBatch.class;
        synchronized (obj4) {
            obj3 = new z.b(WriteBatch.DEFAULT_INSTANCE);
            WriteBatch.PARSER = obj3;
        }
    }

    @Override // com.google.protobuf.z
    public y getBaseWrites(int i) {
        return (y)this.baseWrites_.get(i);
    }

    @Override // com.google.protobuf.z
    public int getBaseWritesCount() {
        return this.baseWrites_.size();
    }

    public List<y> getBaseWritesList() {
        return this.baseWrites_;
    }

    @Override // com.google.protobuf.z
    public z getBaseWritesOrBuilder(int i) {
        return (z)this.baseWrites_.get(i);
    }

    public List<? extends z> getBaseWritesOrBuilderList() {
        return this.baseWrites_;
    }

    @Override // com.google.protobuf.z
    public int getBatchId() {
        return this.batchId_;
    }

    @Override // com.google.protobuf.z
    public r1 getLocalWriteTime() {
        r1 localWriteTime_;
        if (this.localWriteTime_ == null) {
            localWriteTime_ = r1.e();
        }
        return localWriteTime_;
    }

    @Override // com.google.protobuf.z
    public y getWrites(int i) {
        return (y)this.writes_.get(i);
    }

    @Override // com.google.protobuf.z
    public int getWritesCount() {
        return this.writes_.size();
    }

    public List<y> getWritesList() {
        return this.writes_;
    }

    @Override // com.google.protobuf.z
    public z getWritesOrBuilder(int i) {
        return (z)this.writes_.get(i);
    }

    public List<? extends z> getWritesOrBuilderList() {
        return this.writes_;
    }

    @Override // com.google.protobuf.z
    public boolean hasLocalWriteTime() {
        int i;
        i = this.localWriteTime_ != null ? 1 : 0;
        return i;
    }
}
