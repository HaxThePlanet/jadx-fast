package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.AsyncQueue.DelayedTask;
import com.google.firebase.firestore.util.AsyncQueue.TimerId;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import f.c.a.d.d.a;
import f.c.e.c.o;
import io.grpc.c;
import io.grpc.d;
import io.grpc.e;
import io.grpc.h;
import io.grpc.i1.a;
import io.grpc.m1.c;
import io.grpc.q;
import io.grpc.r0;
import io.grpc.s0;
import io.grpc.u0;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class GrpcCallProvider {

    private static final int CONNECTIVITY_ATTEMPT_TIMEOUT_MS = 15000;
    private static final String LOG_TAG = "GrpcCallProvider";
    private static Supplier<s0<?>> overrideChannelBuilderSupplier;
    private final AsyncQueue asyncQueue;
    private d callOptions;
    private j<r0> channelTask;
    private AsyncQueue.DelayedTask connectivityAttemptTimer;
    private final Context context;
    private final DatabaseInfo databaseInfo;
    private final c firestoreHeaders;
    GrpcCallProvider(AsyncQueue asyncQueue, Context context2, DatabaseInfo databaseInfo3, c c4) {
        super();
        this.asyncQueue = asyncQueue;
        this.context = context2;
        this.databaseInfo = databaseInfo3;
        this.firestoreHeaders = c4;
        initChannelTask();
    }

    private j a(u0 u0, j j2) {
        return m.e((r0)j2.getResult().h(u0, this.callOptions));
    }

    private void c(r0 r0) {
        onConnectivityStateChange(r0);
    }

    private void clearConnectivityAttemptTimer() {
        AsyncQueue.DelayedTask connectivityAttemptTimer;
        String str;
        String str2;
        if (this.connectivityAttemptTimer != null) {
            Logger.debug("GrpcCallProvider", "Clearing the connectivityAttemptTimer", new Object[0]);
            this.connectivityAttemptTimer.cancel();
            this.connectivityAttemptTimer = 0;
        }
    }

    private r0 e() {
        r0 channel = initChannel(this.context, this.databaseInfo);
        t tVar = new t(this, channel);
        this.asyncQueue.enqueueAndForget(tVar);
        this.callOptions = (o.b)(o.b)o.e(channel).d(this.firestoreHeaders).f(this.asyncQueue.getExecutor()).b();
        Logger.debug("GrpcCallProvider", "Channel successfully reset.", new Object[0]);
        return channel;
    }

    private void g(r0 r0) {
        Logger.debug("GrpcCallProvider", "connectivityAttemptTimer elapsed. Resetting the channel.", new Object[0]);
        clearConnectivityAttemptTimer();
        resetChannel(r0);
    }

    private void i(r0 r0) {
        onConnectivityStateChange(r0);
    }

    private r0 initChannel(Context context, DatabaseInfo databaseInfo2) {
        Throwable str2;
        Object overrideChannelBuilderSupplier;
        int arr;
        int str;
        Object obj5;
        try {
            a.a(context);
        }
        overrideChannelBuilderSupplier = GrpcCallProvider.overrideChannelBuilderSupplier;
        if (overrideChannelBuilderSupplier != null) {
            obj5 = overrideChannelBuilderSupplier.get();
        } else {
            overrideChannelBuilderSupplier = s0.b(databaseInfo2.getHost());
            if (!databaseInfo2.isSslEnabled()) {
                overrideChannelBuilderSupplier.d();
            }
            obj5 = overrideChannelBuilderSupplier;
        }
        obj5.c(30, arr);
        obj5 = a.k(obj5);
        obj5.i(context);
        return obj5.a();
    }

    private void initChannelTask() {
        r rVar = new r(this);
        this.channelTask = m.c(Executors.BACKGROUND_EXECUTOR, rVar);
    }

    private void k(r0 r0) {
        o oVar = new o(this, r0);
        this.asyncQueue.enqueueAndForget(oVar);
    }

    private void m(r0 r0) {
        r0.n();
        initChannelTask();
    }

    private void onConnectivityStateChange(r0 r0) {
        Object enqueueAfterDelay;
        int cONNECTIVITY_ATTEMPT_TIMER;
        Object[] arr;
        com.google.firebase.firestore.remote.s sVar;
        q qVar = r0.k(true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Current gRPC connectivity state: ");
        stringBuilder.append(qVar);
        cONNECTIVITY_ATTEMPT_TIMER = 0;
        final String str3 = "GrpcCallProvider";
        Logger.debug(str3, stringBuilder.toString(), new Object[cONNECTIVITY_ATTEMPT_TIMER]);
        clearConnectivityAttemptTimer();
        if (qVar == q.CONNECTING) {
            Logger.debug(str3, "Setting the connectivityAttemptTimer", new Object[cONNECTIVITY_ATTEMPT_TIMER]);
            sVar = new s(this, r0);
            this.connectivityAttemptTimer = this.asyncQueue.enqueueAfterDelay(AsyncQueue.TimerId.CONNECTIVITY_ATTEMPT_TIMER, 15000, str3);
        }
        p pVar = new p(this, r0);
        r0.l(qVar, pVar);
    }

    public static void overrideChannelBuilder(Supplier<s0<?>> supplier) {
        GrpcCallProvider.overrideChannelBuilderSupplier = supplier;
    }

    private void resetChannel(r0 r0) {
        u uVar = new u(this, r0);
        this.asyncQueue.enqueueAndForget(uVar);
    }

    public j b(u0 u0, j j2) {
        return a(u0, j2);
    }

    <ReqT, RespT> j<h<ReqT, RespT>> createClientCall(u0<ReqT, RespT> u0) {
        q qVar = new q(this, u0);
        return this.channelTask.continueWithTask(this.asyncQueue.getExecutor(), qVar);
    }

    public void d(r0 r0) {
        c(r0);
    }

    public r0 f() {
        return e();
    }

    public void h(r0 r0) {
        g(r0);
    }

    public void j(r0 r0) {
        i(r0);
    }

    public void l(r0 r0) {
        k(r0);
    }

    public void n(r0 r0) {
        m(r0);
    }

    void shutdown() {
        Class<com.google.firebase.firestore.remote.FirestoreChannel> obj2;
        int i;
        Object obj;
        boolean simpleName;
        Object str;
        TimeUnit sECONDS;
        Object[] arr;
        obj2 = FirestoreChannel.class;
        i = 0;
        obj = m.a(this.channelTask);
        (r0)obj.m();
        sECONDS = TimeUnit.SECONDS;
        str = "Unable to gracefully shutdown the gRPC ManagedChannel. Will attempt an immediate shutdown.";
        Logger.debug(obj2.getSimpleName(), str, new Object[i]);
        obj.n();
        if (!obj.i(1, obj4) && !obj.i(60, str)) {
            str = "Unable to gracefully shutdown the gRPC ManagedChannel. Will attempt an immediate shutdown.";
            Logger.debug(obj2.getSimpleName(), str, new Object[i]);
            obj.n();
            if (!obj.i(60, str)) {
                Logger.warn(obj2.getSimpleName(), "Unable to forcefully shutdown the gRPC ManagedChannel.", new Object[i]);
            }
        }
    }
}
