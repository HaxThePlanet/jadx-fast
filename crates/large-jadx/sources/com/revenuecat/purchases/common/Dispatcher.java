package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.g0.c;
import kotlin.h0.f;
import kotlin.h0.g;
import kotlin.w;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0016\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\u0008\u0010\u0010\u0011J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u000b\u0010\u000cR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u000f¨\u0006\u0013", d2 = {"Lcom/revenuecat/purchases/common/Dispatcher;", "", "Ljava/lang/Runnable;", "command", "", "useRandomDelay", "Lkotlin/w;", "enqueue", "(Ljava/lang/Runnable;Z)V", "close", "()V", "isClosed", "()Z", "Ljava/util/concurrent/ExecutorService;", "executorService", "Ljava/util/concurrent/ExecutorService;", "<init>", "(Ljava/util/concurrent/ExecutorService;)V", "AsyncCall", "common_release"}, k = 1, mv = {1, 4, 0})
public class Dispatcher {

    private final ExecutorService executorService;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u000f\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0017\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0008\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\r\u0010\u000e¨\u0006\u0010", d2 = {"Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "Ljava/lang/Runnable;", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "call", "()Lcom/revenuecat/purchases/common/networking/HTTPResult;", "Lcom/revenuecat/purchases/PurchasesError;", "error", "Lkotlin/w;", "onError", "(Lcom/revenuecat/purchases/PurchasesError;)V", "result", "onCompletion", "(Lcom/revenuecat/purchases/common/networking/HTTPResult;)V", "run", "()V", "<init>", "common_release"}, k = 1, mv = {1, 4, 0})
    public static abstract class AsyncCall implements Runnable {
        @Override // java.lang.Runnable
        public abstract HTTPResult call();

        @Override // java.lang.Runnable
        public void onCompletion(HTTPResult hTTPResult) {
            n.f(hTTPResult, "result");
        }

        @Override // java.lang.Runnable
        public void onError(PurchasesError purchasesError) {
            n.f(purchasesError, "error");
        }

        @Override // java.lang.Runnable
        public void run() {
            HTTPResult call;
            w wVar;
            try {
                onCompletion(call());
                Throwable purchasesError = ErrorsKt.toPurchasesError(purchasesError);
                LogUtilsKt.errorLog(purchasesError);
                wVar = w.a;
                onError(purchasesError);
                purchasesError = ErrorsKt.toPurchasesError(purchasesError);
                LogUtilsKt.errorLog(purchasesError);
                wVar = w.a;
                onError(purchasesError);
                purchasesError = ErrorsKt.toPurchasesError(purchasesError);
                LogUtilsKt.errorLog(purchasesError);
                wVar = w.a;
                onError(purchasesError);
            }
        }
    }
    public Dispatcher(ExecutorService executorService) {
        n.f(executorService, "executorService");
        super();
        this.executorService = executorService;
    }

    public static void enqueue$default(com.revenuecat.purchases.common.Dispatcher dispatcher, Runnable runnable2, boolean z3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            dispatcher.enqueue(runnable2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
        throw obj0;
    }

    public void close() {
        final ExecutorService executorService = this.executorService;
        this.executorService.shutdownNow();
        return;
        synchronized (executorService) {
            executorService = this.executorService;
            this.executorService.shutdownNow();
        }
    }

    public void enqueue(Runnable runnable, boolean z2) {
        boolean executorService;
        long l;
        Object obj5;
        Object obj6;
        n.f(runnable, "command");
        ExecutorService executorService2 = this.executorService;
        synchronized (executorService2) {
            if (z2 && obj6 instanceof ScheduledExecutorService != null) {
                if (obj6 instanceof ScheduledExecutorService != null) {
                    f fVar = new f(0, 5000);
                    obj5 = (ScheduledExecutorService)this.executorService.schedule(runnable, (long)obj6, obj3);
                } else {
                    obj5 = this.executorService.submit(runnable);
                }
            } else {
            }
            executorService = new Dispatcher.enqueue.1.1(obj5);
            obj6 = new Thread(executorService);
            obj6.start();
            obj5 = w.a;
        }
    }

    public boolean isClosed() {
        final ExecutorService executorService = this.executorService;
        return this.executorService.isShutdown();
        synchronized (executorService) {
            executorService = this.executorService;
            return this.executorService.isShutdown();
        }
    }
}
