package com.google.firebase.firestore.remote;

import io.grpc.d1;

/* loaded from: classes2.dex */
public interface Stream<CallbackType extends com.google.firebase.firestore.remote.Stream.StreamCallback>  {

    public static enum State {

        Initial,
        Starting,
        Open,
        Healthy,
        Error,
        Backoff;
    }

    public interface StreamCallback {
        public abstract void onClose(d1 d1);

        public abstract void onOpen();
    }
    public abstract void inhibitBackoff();

    public abstract boolean isOpen();

    public abstract boolean isStarted();

    public abstract void start();

    public abstract void stop();
}
