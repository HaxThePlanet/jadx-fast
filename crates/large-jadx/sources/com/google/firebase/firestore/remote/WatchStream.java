package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.AsyncQueue.TimerId;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.protobuf.j;
import com.google.protobuf.z.a;
import f.c.e.c.o;
import f.c.e.c.p;
import f.c.e.c.p.b;
import f.c.e.c.q;

/* loaded from: classes2.dex */
public class WatchStream extends com.google.firebase.firestore.remote.AbstractStream<p, q, com.google.firebase.firestore.remote.WatchStream.Callback> {

    public static final j EMPTY_RESUME_TOKEN;
    private final com.google.firebase.firestore.remote.RemoteSerializer serializer;

    interface Callback extends com.google.firebase.firestore.remote.Stream.StreamCallback {
        @Override // com.google.firebase.firestore.remote.Stream$StreamCallback
        public abstract void onWatchChange(SnapshotVersion snapshotVersion, com.google.firebase.firestore.remote.WatchChange watchChange2);
    }
    static {
        WatchStream.EMPTY_RESUME_TOKEN = j.a;
    }

    WatchStream(com.google.firebase.firestore.remote.FirestoreChannel firestoreChannel, AsyncQueue asyncQueue2, com.google.firebase.firestore.remote.RemoteSerializer remoteSerializer3, com.google.firebase.firestore.remote.WatchStream.Callback watchStream$Callback4) {
        super(firestoreChannel, o.c(), asyncQueue2, AsyncQueue.TimerId.LISTEN_STREAM_CONNECTION_BACKOFF, AsyncQueue.TimerId.LISTEN_STREAM_IDLE, AsyncQueue.TimerId.HEALTH_CHECK_TIMEOUT, callback4);
        this.serializer = remoteSerializer3;
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void inhibitBackoff() {
        super.inhibitBackoff();
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
    public void onNext(q q) {
        this.backoff.reset();
        (WatchStream.Callback)this.listener.onWatchChange(this.serializer.decodeVersionFromListenResponse(q), this.serializer.decodeWatchChange(q));
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void onNext(Object object) {
        onNext((q)object);
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void start() {
        super.start();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void stop() {
        super.stop();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void unwatchTarget(int i) {
        Assert.hardAssert(isOpen(), "Unwatching targets requires an open stream", new Object[0]);
        p.b bVar = p.j();
        bVar.d(this.serializer.databaseName());
        bVar.e(i);
        writeRequest((p)bVar.build());
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void watchQuery(TargetData targetData) {
        Assert.hardAssert(isOpen(), "Watching queries requires an open stream", new Object[0]);
        p.b bVar = p.j();
        bVar.d(this.serializer.databaseName());
        bVar.c(this.serializer.encodeTarget(targetData));
        java.util.Map obj4 = this.serializer.encodeListenRequestLabels(targetData);
        if (obj4 != null) {
            bVar.b(obj4);
        }
        writeRequest((p)bVar.build());
    }
}
