package com.facebook.internal;

import com.facebook.o;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004B\u0015\u0008\u0016\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0010", d2 = {"Lcom/facebook/internal/LockOnGetVariable;", "T", "", "value", "(Ljava/lang/Object;)V", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)V", "initLatch", "Ljava/util/concurrent/CountDownLatch;", "storedValue", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "waitOnInit", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class u<T>  {

    private T a;
    private CountDownLatch b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\u0008\u0000\u0010\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "T", "call"}, k = 3, mv = {1, 5, 1})
    static final class a implements Callable {

        final com.facebook.internal.u a;
        final Callable b;
        a(com.facebook.internal.u u, Callable callable2) {
            this.a = u;
            this.b = callable2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public final Void a() {
            com.facebook.internal.u uVar;
            try {
                u.b(this.a, this.b.call());
                CountDownLatch countDownLatch = u.a(this.a);
                if (countDownLatch != null) {
                }
                countDownLatch.countDown();
                return null;
                uVar = this.a;
                uVar = u.a(uVar);
                if (uVar == null) {
                } else {
                }
                uVar.countDown();
                throw th;
            }
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }
    public u(Callable<T> callable) {
        n.f(callable, "callable");
        super();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.b = countDownLatch;
        u.a aVar = new u.a(this, callable);
        FutureTask futureTask = new FutureTask(aVar);
        o.n().execute(futureTask);
    }

    public static final CountDownLatch a(com.facebook.internal.u u) {
        return u.b;
    }

    public static final void b(com.facebook.internal.u u, Object object2) {
        u.a = object2;
    }
}
