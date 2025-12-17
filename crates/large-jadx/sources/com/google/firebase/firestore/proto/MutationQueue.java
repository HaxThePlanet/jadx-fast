package com.google.firebase.firestore.proto;

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
public final class MutationQueue extends z<com.google.firebase.firestore.proto.MutationQueue, com.google.firebase.firestore.proto.MutationQueue.Builder> implements com.google.firebase.firestore.proto.MutationQueueOrBuilder {

    private static final com.google.firebase.firestore.proto.MutationQueue DEFAULT_INSTANCE = null;
    public static final int LAST_ACKNOWLEDGED_BATCH_ID_FIELD_NUMBER = 1;
    public static final int LAST_STREAM_TOKEN_FIELD_NUMBER = 2;
    private static volatile d1<com.google.firebase.firestore.proto.MutationQueue> PARSER;
    private int lastAcknowledgedBatchId_;
    private j lastStreamToken_;

    public static final class Builder extends z.a<com.google.firebase.firestore.proto.MutationQueue, com.google.firebase.firestore.proto.MutationQueue.Builder> implements com.google.firebase.firestore.proto.MutationQueueOrBuilder {
        private Builder() {
            super(MutationQueue.access$000());
        }

        Builder(com.google.firebase.firestore.proto.MutationQueue.1 mutationQueue$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MutationQueue.Builder clearLastAcknowledgedBatchId() {
            copyOnWrite();
            MutationQueue.access$200((MutationQueue)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MutationQueue.Builder clearLastStreamToken() {
            copyOnWrite();
            MutationQueue.access$400((MutationQueue)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public int getLastAcknowledgedBatchId() {
            return (MutationQueue)this.instance.getLastAcknowledgedBatchId();
        }

        @Override // com.google.protobuf.z$a
        public j getLastStreamToken() {
            return (MutationQueue)this.instance.getLastStreamToken();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MutationQueue.Builder setLastAcknowledgedBatchId(int i) {
            copyOnWrite();
            MutationQueue.access$100((MutationQueue)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.firestore.proto.MutationQueue.Builder setLastStreamToken(j j) {
            copyOnWrite();
            MutationQueue.access$300((MutationQueue)this.instance, j);
            return this;
        }
    }
    static {
        MutationQueue mutationQueue = new MutationQueue();
        MutationQueue.DEFAULT_INSTANCE = mutationQueue;
        z.registerDefaultInstance(MutationQueue.class, mutationQueue);
    }

    private MutationQueue() {
        super();
        this.lastStreamToken_ = j.a;
    }

    static com.google.firebase.firestore.proto.MutationQueue access$000() {
        return MutationQueue.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.firestore.proto.MutationQueue mutationQueue, int i2) {
        mutationQueue.setLastAcknowledgedBatchId(i2);
    }

    static void access$200(com.google.firebase.firestore.proto.MutationQueue mutationQueue) {
        mutationQueue.clearLastAcknowledgedBatchId();
    }

    static void access$300(com.google.firebase.firestore.proto.MutationQueue mutationQueue, j j2) {
        mutationQueue.setLastStreamToken(j2);
    }

    static void access$400(com.google.firebase.firestore.proto.MutationQueue mutationQueue) {
        mutationQueue.clearLastStreamToken();
    }

    private void clearLastAcknowledgedBatchId() {
        this.lastAcknowledgedBatchId_ = 0;
    }

    private void clearLastStreamToken() {
        this.lastStreamToken_ = MutationQueue.getDefaultInstance().getLastStreamToken();
    }

    public static com.google.firebase.firestore.proto.MutationQueue getDefaultInstance() {
        return MutationQueue.DEFAULT_INSTANCE;
    }

    public static com.google.firebase.firestore.proto.MutationQueue.Builder newBuilder() {
        return (MutationQueue.Builder)MutationQueue.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.firestore.proto.MutationQueue.Builder newBuilder(com.google.firebase.firestore.proto.MutationQueue mutationQueue) {
        return (MutationQueue.Builder)MutationQueue.DEFAULT_INSTANCE.createBuilder(mutationQueue);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseDelimitedFrom(InputStream inputStream) {
        return (MutationQueue)z.parseDelimitedFrom(MutationQueue.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseDelimitedFrom(InputStream inputStream, q q2) {
        return (MutationQueue)z.parseDelimitedFrom(MutationQueue.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseFrom(j j) {
        return (MutationQueue)z.parseFrom(MutationQueue.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseFrom(j j, q q2) {
        return (MutationQueue)z.parseFrom(MutationQueue.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseFrom(k k) {
        return (MutationQueue)z.parseFrom(MutationQueue.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseFrom(k k, q q2) {
        return (MutationQueue)z.parseFrom(MutationQueue.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseFrom(InputStream inputStream) {
        return (MutationQueue)z.parseFrom(MutationQueue.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseFrom(InputStream inputStream, q q2) {
        return (MutationQueue)z.parseFrom(MutationQueue.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseFrom(ByteBuffer byteBuffer) {
        return (MutationQueue)z.parseFrom(MutationQueue.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseFrom(ByteBuffer byteBuffer, q q2) {
        return (MutationQueue)z.parseFrom(MutationQueue.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseFrom(byte[] bArr) {
        return (MutationQueue)z.parseFrom(MutationQueue.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.firestore.proto.MutationQueue parseFrom(byte[] bArr, q q2) {
        return (MutationQueue)z.parseFrom(MutationQueue.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.firestore.proto.MutationQueue> parser() {
        return MutationQueue.DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastAcknowledgedBatchId(int i) {
        this.lastAcknowledgedBatchId_ = i;
    }

    private void setLastStreamToken(j j) {
        j.getClass();
        this.lastStreamToken_ = j;
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
                obj2 = new MutationQueue();
                return obj2;
            case 2:
                obj2 = new MutationQueue.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[2];
                obj2[obj3] = "lastStreamToken_";
                return z.newMessageInfo(MutationQueue.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\n", obj2);
            case 4:
                return MutationQueue.DEFAULT_INSTANCE;
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
        obj3 = MutationQueue.class;
        synchronized (obj3) {
            obj2 = new z.b(MutationQueue.DEFAULT_INSTANCE);
            MutationQueue.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public int getLastAcknowledgedBatchId() {
        return this.lastAcknowledgedBatchId_;
    }

    @Override // com.google.protobuf.z
    public j getLastStreamToken() {
        return this.lastStreamToken_;
    }
}
