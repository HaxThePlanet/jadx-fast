package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.AsyncQueue.DelayedTask;
import com.google.firebase.firestore.util.AsyncQueue.TimerId;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import io.grpc.d1;
import io.grpc.d1.b;
import io.grpc.h;
import io.grpc.t0;
import io.grpc.t0.f;
import io.grpc.u0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
abstract class AbstractStream<ReqT, RespT, CallbackT extends com.google.firebase.firestore.remote.Stream.StreamCallback>  implements com.google.firebase.firestore.remote.Stream<CallbackT> {

    private static final long BACKOFF_CLIENT_NETWORK_FAILURE_MAX_DELAY_MS = 0L;
    private static final double BACKOFF_FACTOR = 1.5d;
    private static final long BACKOFF_INITIAL_DELAY_MS;
    private static final long BACKOFF_MAX_DELAY_MS;
    private static final long HEALTHY_TIMEOUT_MS;
    private static final long IDLE_TIMEOUT_MS;
    final ExponentialBackoff backoff;
    private h<ReqT, RespT> call;
    private long closeCount;
    private final com.google.firebase.firestore.remote.FirestoreChannel firestoreChannel;
    private AsyncQueue.DelayedTask healthCheck;
    private final AsyncQueue.TimerId healthTimerId;
    private final com.google.firebase.firestore.remote.AbstractStream.IdleTimeoutRunnable<ReqT, RespT, CallbackT> idleTimeoutRunnable;
    private AsyncQueue.DelayedTask idleTimer;
    private final AsyncQueue.TimerId idleTimerId;
    final CallbackT listener;
    private final u0<ReqT, RespT> methodDescriptor;
    private com.google.firebase.firestore.remote.Stream.State state;
    private final AsyncQueue workerQueue;

    class CloseGuardedRunner {

        private final long initialCloseCount;
        final com.google.firebase.firestore.remote.AbstractStream this$0;
        CloseGuardedRunner(com.google.firebase.firestore.remote.AbstractStream abstractStream, long l2) {
            this.this$0 = abstractStream;
            super();
            this.initialCloseCount = l2;
        }

        void run(Runnable runnable) {
            int cmp;
            String str;
            String obj5;
            AbstractStream.access$000(this.this$0).verifyIsCurrentThread();
            if (Long.compare(l, initialCloseCount) == 0) {
                runnable.run();
            } else {
                Logger.debug(this.this$0.getClass().getSimpleName(), "stream callback skipped by CloseGuardedRunner.", new Object[0]);
            }
        }
    }

    class IdleTimeoutRunnable implements Runnable {

        final com.google.firebase.firestore.remote.AbstractStream this$0;
        IdleTimeoutRunnable(com.google.firebase.firestore.remote.AbstractStream abstractStream) {
            this.this$0 = abstractStream;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractStream.access$300(this.this$0);
        }
    }

    class StreamObserver implements com.google.firebase.firestore.remote.IncomingStreamObserver<RespT> {

        private final com.google.firebase.firestore.remote.AbstractStream.CloseGuardedRunner<ReqT, RespT, CallbackT> dispatcher;
        final com.google.firebase.firestore.remote.AbstractStream this$0;
        StreamObserver(com.google.firebase.firestore.remote.AbstractStream abstractStream, com.google.firebase.firestore.remote.AbstractStream.CloseGuardedRunner abstractStream$CloseGuardedRunner2) {
            this.this$0 = abstractStream;
            super();
            this.dispatcher = closeGuardedRunner2;
        }

        private void a(d1 d1) {
            String simpleName;
            Object[] arr;
            String str;
            Integer valueOf;
            Integer valueOf2;
            int i = 1;
            str = 0;
            if (d1.p()) {
                arr = new Object[i];
                arr[str] = Integer.valueOf(System.identityHashCode(this.this$0));
                Logger.debug(this.this$0.getClass().getSimpleName(), "(%x) Stream closed.", arr);
            } else {
                valueOf = new Object[2];
                valueOf[str] = Integer.valueOf(System.identityHashCode(this.this$0));
                valueOf[i] = d1;
                Logger.warn(this.this$0.getClass().getSimpleName(), "(%x) Stream closed with status: %s.", valueOf);
            }
            this.this$0.handleServerClose(d1);
        }

        private void c(t0 t0) {
            boolean debugEnabled;
            Iterator iterator;
            boolean next;
            Integer valueOf;
            String lowerCase;
            boolean obj6;
            if (Logger.isDebugEnabled()) {
                debugEnabled = new HashMap();
                iterator = t0.i().iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if (Datastore.WHITE_LISTED_HEADERS.contains((String)next.toLowerCase(Locale.ENGLISH))) {
                    }
                    debugEnabled.put(next, (String)t0.f(t0.f.e(next, t0.c)));
                }
                if (!debugEnabled.isEmpty()) {
                    iterator = new Object[2];
                    Logger.debug(this.this$0.getClass().getSimpleName(), "(%x) Stream received headers: %s", Integer.valueOf(System.identityHashCode(this.this$0)), debugEnabled);
                }
            }
        }

        private void e(Object object) {
            boolean debugEnabled;
            Object[] arr;
            String str;
            Integer valueOf;
            if (Logger.isDebugEnabled()) {
                arr = new Object[2];
                Logger.debug(this.this$0.getClass().getSimpleName(), "(%x) Stream received: %s", Integer.valueOf(System.identityHashCode(this.this$0)), object);
            }
            this.this$0.onNext(object);
        }

        private void g() {
            Object[] arr = new Object[1];
            Logger.debug(this.this$0.getClass().getSimpleName(), "(%x) Stream is open", Integer.valueOf(System.identityHashCode(this.this$0)));
            AbstractStream.access$200(this.this$0);
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void b(d1 d1) {
            a(d1);
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void d(t0 t0) {
            c(t0);
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void f(Object object) {
            e(object);
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void h() {
            g();
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onClose(d1 d1) {
            d dVar = new d(this, d1);
            this.dispatcher.run(dVar);
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onHeaders(t0 t0) {
            a aVar = new a(this, t0);
            this.dispatcher.run(aVar);
        }

        public void onNext(RespT respt) {
            c cVar = new c(this, respt);
            this.dispatcher.run(cVar);
        }

        @Override // com.google.firebase.firestore.remote.IncomingStreamObserver
        public void onOpen() {
            b bVar = new b(this);
            this.dispatcher.run(bVar);
        }
    }
    static {
        TimeUnit sECONDS = TimeUnit.SECONDS;
        int i = 1;
        AbstractStream.BACKOFF_INITIAL_DELAY_MS = sECONDS.toMillis(i);
        TimeUnit mINUTES = TimeUnit.MINUTES;
        AbstractStream.BACKOFF_MAX_DELAY_MS = mINUTES.toMillis(i);
        AbstractStream.IDLE_TIMEOUT_MS = mINUTES.toMillis(i);
        int i2 = 10;
        AbstractStream.HEALTHY_TIMEOUT_MS = sECONDS.toMillis(i2);
        AbstractStream.BACKOFF_CLIENT_NETWORK_FAILURE_MAX_DELAY_MS = sECONDS.toMillis(i2);
    }

    AbstractStream(com.google.firebase.firestore.remote.FirestoreChannel firestoreChannel, u0<ReqT, RespT> u02, AsyncQueue asyncQueue3, AsyncQueue.TimerId asyncQueue$TimerId4, AsyncQueue.TimerId asyncQueue$TimerId5, AsyncQueue.TimerId asyncQueue$TimerId6, CallbackT callbackt7) {
        final Object obj = this;
        super();
        obj.state = Stream.State.Initial;
        obj.closeCount = 0;
        obj.firestoreChannel = firestoreChannel;
        obj.methodDescriptor = u02;
        final AsyncQueue queue3 = asyncQueue3;
        obj.workerQueue = queue3;
        obj.idleTimerId = timerId5;
        obj.healthTimerId = timerId6;
        obj.listener = callbackt7;
        AbstractStream.IdleTimeoutRunnable idleTimeoutRunnable = new AbstractStream.IdleTimeoutRunnable(this);
        obj.idleTimeoutRunnable = idleTimeoutRunnable;
        super(queue3, timerId4, AbstractStream.BACKOFF_INITIAL_DELAY_MS, obj5, 4609434218613702656L, obj7, AbstractStream.BACKOFF_MAX_DELAY_MS, obj9);
        obj.backoff = exponentialBackoff2;
    }

    private void a() {
        boolean healthy;
        if (isOpen()) {
            this.state = Stream.State.Healthy;
        }
    }

    static AsyncQueue access$000(com.google.firebase.firestore.remote.AbstractStream abstractStream) {
        return abstractStream.workerQueue;
    }

    static long access$100(com.google.firebase.firestore.remote.AbstractStream abstractStream) {
        return abstractStream.closeCount;
    }

    static void access$200(com.google.firebase.firestore.remote.AbstractStream abstractStream) {
        abstractStream.onOpen();
    }

    static void access$300(com.google.firebase.firestore.remote.AbstractStream abstractStream) {
        abstractStream.handleIdleCloseTimer();
    }

    private void c() {
        int i;
        com.google.firebase.firestore.remote.Stream.State state = this.state;
        int i2 = 1;
        final int i3 = 0;
        i = state == Stream.State.Backoff ? i2 : i3;
        Object[] arr2 = new Object[i2];
        arr2[i3] = state;
        Assert.hardAssert(i, "State should still be backoff but was %s", arr2);
        this.state = Stream.State.Initial;
        start();
        Assert.hardAssert(isStarted(), "Stream should have started", new Object[i3]);
    }

    private void cancelHealthCheck() {
        AsyncQueue.DelayedTask healthCheck;
        healthCheck = this.healthCheck;
        if (healthCheck != null) {
            healthCheck.cancel();
            this.healthCheck = 0;
        }
    }

    private void cancelIdleCheck() {
        AsyncQueue.DelayedTask idleTimer;
        idleTimer = this.idleTimer;
        if (idleTimer != null) {
            idleTimer.cancel();
            this.idleTimer = 0;
        }
    }

    private void close(com.google.firebase.firestore.remote.Stream.State stream$State, d1 d12) {
        Object simpleName;
        boolean call;
        h call2;
        int str3;
        int arr2;
        String str;
        int i;
        boolean illegalStateException;
        boolean firestoreChannel;
        Object[] arr;
        Enum bACKOFF_CLIENT_NETWORK_FAILURE_MAX_DELAY_MS;
        String str2;
        int healthy;
        str3 = 0;
        Assert.hardAssert(isStarted(), "Only started streams should be closed.", new Object[str3]);
        simpleName = Stream.State.Error;
        arr2 = 1;
        if (state != simpleName) {
            if (d12.p()) {
                i = arr2;
            } else {
                i = str3;
            }
        } else {
        }
        Assert.hardAssert(i, "Can't provide an error when not in an error state.", new Object[str3]);
        this.workerQueue.verifyIsCurrentThread();
        if (Datastore.isMissingSslCiphers(d12)) {
            illegalStateException = new IllegalStateException("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", d12.m());
            Util.crashMainThread(illegalStateException);
        }
        cancelIdleCheck();
        cancelHealthCheck();
        this.backoff.cancel();
        this.closeCount = closeCount += healthy;
        firestoreChannel = d12.n();
        if (firestoreChannel == d1.b.OK) {
            this.backoff.reset();
        } else {
            if (firestoreChannel == d1.b.RESOURCE_EXHAUSTED) {
                bACKOFF_CLIENT_NETWORK_FAILURE_MAX_DELAY_MS = new Object[arr2];
                bACKOFF_CLIENT_NETWORK_FAILURE_MAX_DELAY_MS[str3] = Integer.valueOf(System.identityHashCode(this));
                Logger.debug(getClass().getSimpleName(), "(%x) Using maximum backoff delay to prevent overloading the backend.", bACKOFF_CLIENT_NETWORK_FAILURE_MAX_DELAY_MS);
                this.backoff.resetToMax();
            } else {
                if (firestoreChannel == d1.b.UNAUTHENTICATED && this.state != Stream.State.Healthy) {
                    if (this.state != Stream.State.Healthy) {
                        this.firestoreChannel.invalidateToken();
                    } else {
                        if (firestoreChannel == d1.b.UNAVAILABLE) {
                            if (th instanceof UnknownHostException == null) {
                                if (th2 instanceof ConnectException != null) {
                                    this.backoff.setTemporaryMaxDelay(AbstractStream.BACKOFF_CLIENT_NETWORK_FAILURE_MAX_DELAY_MS);
                                }
                            } else {
                            }
                        }
                    }
                } else {
                }
            }
        }
        if (state != simpleName) {
            firestoreChannel = new Object[arr2];
            firestoreChannel[str3] = Integer.valueOf(System.identityHashCode(this));
            Logger.debug(getClass().getSimpleName(), "(%x) Performing stream teardown", firestoreChannel);
            tearDown();
        }
        if (this.call != null && d12.p()) {
            if (d12.p()) {
                arr2 = new Object[arr2];
                arr2[str3] = Integer.valueOf(System.identityHashCode(this));
                Logger.debug(getClass().getSimpleName(), "(%x) Closing stream client-side", arr2);
                this.call.halfClose();
            }
            this.call = 0;
        }
        this.state = state;
        this.listener.onClose(d12);
    }

    private void handleIdleCloseTimer() {
        boolean initial;
        d1 d1Var;
        if (isOpen()) {
            close(Stream.State.Initial, d1.f);
        }
    }

    private void onOpen() {
        AsyncQueue.DelayedTask enqueueAfterDelay;
        AsyncQueue.TimerId healthTimerId;
        long hEALTHY_TIMEOUT_MS;
        com.google.firebase.firestore.remote.f fVar;
        this.state = Stream.State.Open;
        this.listener.onOpen();
        if (this.healthCheck == null) {
            fVar = new f(this);
            this.healthCheck = this.workerQueue.enqueueAfterDelay(this.healthTimerId, AbstractStream.HEALTHY_TIMEOUT_MS, obj3);
        }
    }

    private void performBackoff() {
        int i;
        int i2 = 0;
        i = this.state == Stream.State.Error ? 1 : i2;
        Assert.hardAssert(i, "Should only perform backoff in an error state", new Object[i2]);
        this.state = Stream.State.Backoff;
        e eVar = new e(this);
        this.backoff.backoffAndRun(eVar);
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public void b() {
        a();
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public void d() {
        c();
    }

    @Override // com.google.firebase.firestore.remote.Stream
    void handleServerClose(d1 d1) {
        Assert.hardAssert(isStarted(), "Can't handle server close on non-started stream!", new Object[0]);
        close(Stream.State.Error, d1);
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public void inhibitBackoff() {
        Assert.hardAssert(started ^= 1, "Can only inhibit backoff after in a stopped state", new Object[0]);
        this.workerQueue.verifyIsCurrentThread();
        this.state = Stream.State.Initial;
        this.backoff.reset();
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public boolean isOpen() {
        int i;
        com.google.firebase.firestore.remote.Stream.State healthy;
        this.workerQueue.verifyIsCurrentThread();
        com.google.firebase.firestore.remote.Stream.State state = this.state;
        if (state != Stream.State.Open) {
            if (state == Stream.State.Healthy) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public boolean isStarted() {
        com.google.firebase.firestore.remote.Stream.State state;
        int i;
        com.google.firebase.firestore.remote.Stream.State starting;
        this.workerQueue.verifyIsCurrentThread();
        state = this.state;
        if (state != Stream.State.Starting && state != Stream.State.Backoff) {
            if (state != Stream.State.Backoff) {
                if (isOpen()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.google.firebase.firestore.remote.Stream
    void markIdle() {
        boolean enqueueAfterDelay;
        AsyncQueue.TimerId idleTimerId;
        long iDLE_TIMEOUT_MS;
        com.google.firebase.firestore.remote.AbstractStream.IdleTimeoutRunnable idleTimeoutRunnable;
        if (isOpen() && this.idleTimer == null) {
            if (this.idleTimer == null) {
                this.idleTimer = this.workerQueue.enqueueAfterDelay(this.idleTimerId, AbstractStream.IDLE_TIMEOUT_MS, obj3);
            }
        }
    }

    public abstract void onNext(RespT respt);

    @Override // com.google.firebase.firestore.remote.Stream
    public void start() {
        int i3;
        int i;
        int i2;
        this.workerQueue.verifyIsCurrentThread();
        i2 = 1;
        int i4 = 0;
        i3 = this.call == null ? i2 : i4;
        Assert.hardAssert(i3, "Last call still set", new Object[i4]);
        i = this.idleTimer == null ? i2 : i4;
        Assert.hardAssert(i, "Idle timer still set", new Object[i4]);
        com.google.firebase.firestore.remote.Stream.State state = this.state;
        if (state == Stream.State.Error) {
            performBackoff();
        }
        if (state == Stream.State.Initial) {
        } else {
            i2 = i4;
        }
        String str = "Already started";
        Assert.hardAssert(i2, str, new Object[i4]);
        AbstractStream.CloseGuardedRunner closeGuardedRunner = new AbstractStream.CloseGuardedRunner(this, this.closeCount, str);
        AbstractStream.StreamObserver streamObserver = new AbstractStream.StreamObserver(this, closeGuardedRunner);
        this.call = this.firestoreChannel.runBidiStreamingRpc(this.methodDescriptor, streamObserver);
        this.state = Stream.State.Starting;
    }

    @Override // com.google.firebase.firestore.remote.Stream
    public void stop() {
        boolean started;
        d1 d1Var;
        if (isStarted()) {
            close(Stream.State.Initial, d1.f);
        }
    }

    @Override // com.google.firebase.firestore.remote.Stream
    protected void tearDown() {
    }

    protected void writeRequest(ReqT reqt) {
        this.workerQueue.verifyIsCurrentThread();
        Object[] arr = new Object[2];
        Logger.debug(getClass().getSimpleName(), "(%x) Stream sending: %s", Integer.valueOf(System.identityHashCode(this)), reqt);
        cancelIdleCheck();
        this.call.sendMessage(reqt);
    }
}
