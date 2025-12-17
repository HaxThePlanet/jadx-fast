package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.AsyncQueue.TimerId;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.firestore.util.Preconditions;
import com.google.protobuf.j;
import com.google.protobuf.z.a;
import f.c.e.c.a0;
import f.c.e.c.a0.b;
import f.c.e.c.b0;
import f.c.e.c.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class WriteStream extends com.google.firebase.firestore.remote.AbstractStream<a0, b0, com.google.firebase.firestore.remote.WriteStream.Callback> {

    public static final j EMPTY_STREAM_TOKEN;
    protected boolean handshakeComplete = false;
    private j lastStreamToken = null;
    private final com.google.firebase.firestore.remote.RemoteSerializer serializer;

    public interface Callback extends com.google.firebase.firestore.remote.Stream.StreamCallback {
        @Override // com.google.firebase.firestore.remote.Stream$StreamCallback
        public abstract void onHandshakeComplete();

        public abstract void onWriteResponse(SnapshotVersion snapshotVersion, List<MutationResult> list2);
    }
    static {
        WriteStream.EMPTY_STREAM_TOKEN = j.a;
    }

    WriteStream(com.google.firebase.firestore.remote.FirestoreChannel firestoreChannel, AsyncQueue asyncQueue2, com.google.firebase.firestore.remote.RemoteSerializer remoteSerializer3, com.google.firebase.firestore.remote.WriteStream.Callback writeStream$Callback4) {
        super(firestoreChannel, o.d(), asyncQueue2, AsyncQueue.TimerId.WRITE_STREAM_CONNECTION_BACKOFF, AsyncQueue.TimerId.WRITE_STREAM_IDLE, AsyncQueue.TimerId.HEALTH_CHECK_TIMEOUT, callback4);
        int obj9 = 0;
        obj9 = WriteStream.EMPTY_STREAM_TOKEN;
        this.serializer = remoteSerializer3;
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    j getLastStreamToken() {
        return this.lastStreamToken;
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void inhibitBackoff() {
        super.inhibitBackoff();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    boolean isHandshakeComplete() {
        return this.handshakeComplete;
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public boolean isOpen() {
        return super.isOpen();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public boolean isStarted() {
        return super.isStarted();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void onNext(b0 b0) {
        boolean handshakeComplete;
        int i2;
        ArrayList arrayList;
        int i;
        MutationResult decodeMutationResult;
        com.google.firebase.firestore.remote.RemoteSerializer serializer;
        com.google.firebase.firestore.remote.Stream.StreamCallback obj7;
        this.lastStreamToken = b0.e();
        if (!this.handshakeComplete) {
            this.handshakeComplete = true;
            (WriteStream.Callback)this.listener.onHandshakeComplete();
        } else {
            this.backoff.reset();
            handshakeComplete = this.serializer.decodeVersion(b0.c());
            i2 = b0.g();
            arrayList = new ArrayList(i2);
            i = 0;
            while (i < i2) {
                arrayList.add(this.serializer.decodeMutationResult(b0.f(i), handshakeComplete));
                i++;
            }
            (WriteStream.Callback)this.listener.onWriteResponse(handshakeComplete, arrayList);
        }
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void onNext(Object object) {
        onNext((b0)object);
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    void setLastStreamToken(j j) {
        this.lastStreamToken = (j)Preconditions.checkNotNull(j);
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void start() {
        this.handshakeComplete = false;
        super.start();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void stop() {
        super.stop();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    protected void tearDown() {
        boolean handshakeComplete;
        if (this.handshakeComplete) {
            writeMutations(Collections.emptyList());
        }
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    void writeHandshake() {
        int i2 = 0;
        Assert.hardAssert(isOpen(), "Writing handshake requires an opened stream", new Object[i2]);
        Assert.hardAssert(handshakeComplete ^= 1, "Handshake already completed", new Object[i2]);
        a0.b bVar = a0.g();
        bVar.c(this.serializer.databaseName());
        writeRequest((a0)bVar.build());
    }

    void writeMutations(List<Mutation> list) {
        Object[] encodeMutation;
        String serializer;
        int i = 0;
        Assert.hardAssert(isOpen(), "Writing mutations requires an opened stream", new Object[i]);
        Assert.hardAssert(this.handshakeComplete, "Handshake must be complete before writing mutations", new Object[i]);
        a0.b bVar = a0.g();
        Iterator obj5 = list.iterator();
        for (Mutation next2 : obj5) {
            bVar.b(this.serializer.encodeMutation(next2));
        }
        bVar.d(this.lastStreamToken);
        writeRequest((a0)bVar.build());
    }
}
