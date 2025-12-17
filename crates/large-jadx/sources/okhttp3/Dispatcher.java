package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.p;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealCall.AsyncCall;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008?\u0010\u0016B\u0011\u0008\u0016\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\u0008?\u0010@J\u001d\u0010\u0006\u001a\u0008\u0018\u00010\u0004R\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f\"\u0004\u0008\u0000\u0010\u000b2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000c2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u000f2\n\u0010\u000e\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u001b\u0010\u0010\u001a\u00020\u000f2\n\u0010\u000e\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\u0008\u001a\u0010\u0013J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0000¢\u0006\u0004\u0008\u001a\u0010\u0018J\u0013\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\u0008\u001f\u0010\u001eJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\u0008!\u0010\"J\r\u0010#\u001a\u00020 ¢\u0006\u0004\u0008#\u0010\"J\u000f\u0010'\u001a\u00020$H\u0007¢\u0006\u0004\u0008%\u0010&R*\u0010(\u001a\u00020 2\u0006\u0010(\u001a\u00020 8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\u0008(\u0010)\u001a\u0004\u0008*\u0010\"\"\u0004\u0008+\u0010,R \u0010.\u001a\u000c\u0012\u0008\u0012\u00060\u0004R\u00020\u00050-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008.\u0010/R\u001c\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00050-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00080\u0010/R*\u00101\u001a\u00020 2\u0006\u00101\u001a\u00020 8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\u00081\u0010)\u001a\u0004\u00082\u0010\"\"\u0004\u00083\u0010,R\u0013\u0010'\u001a\u00020$8G@\u0006¢\u0006\u0006\u001a\u0004\u0008'\u0010&R.\u00106\u001a\u0004\u0018\u0001042\u0008\u00105\u001a\u0004\u0018\u0001048F@FX\u0086\u000e¢\u0006\u0012\n\u0004\u00086\u00107\u001a\u0004\u00088\u00109\"\u0004\u0008:\u0010;R \u0010<\u001a\u000c\u0012\u0008\u0012\u00060\u0004R\u00020\u00050-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008<\u0010/R\u0018\u0010=\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008=\u0010>¨\u0006A", d2 = {"Lokhttp3/Dispatcher;", "", "", "host", "Lokhttp3/internal/connection/RealCall$AsyncCall;", "Lokhttp3/internal/connection/RealCall;", "findExistingCallWithHost", "(Ljava/lang/String;)Lokhttp3/internal/connection/RealCall$AsyncCall;", "", "promoteAndExecute", "()Z", "T", "Ljava/util/Deque;", "calls", "call", "Lkotlin/w;", "finished", "(Ljava/util/Deque;Ljava/lang/Object;)V", "enqueue$okhttp", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "enqueue", "cancelAll", "()V", "executed$okhttp", "(Lokhttp3/internal/connection/RealCall;)V", "executed", "finished$okhttp", "", "Lokhttp3/Call;", "queuedCalls", "()Ljava/util/List;", "runningCalls", "", "queuedCallsCount", "()I", "runningCallsCount", "Ljava/util/concurrent/ExecutorService;", "-deprecated_executorService", "()Ljava/util/concurrent/ExecutorService;", "executorService", "maxRequestsPerHost", "I", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "(I)V", "Ljava/util/ArrayDeque;", "readyAsyncCalls", "Ljava/util/ArrayDeque;", "runningSyncCalls", "maxRequests", "getMaxRequests", "setMaxRequests", "Ljava/lang/Runnable;", "<set-?>", "idleCallback", "Ljava/lang/Runnable;", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "runningAsyncCalls", "executorServiceOrNull", "Ljava/util/concurrent/ExecutorService;", "<init>", "(Ljava/util/concurrent/ExecutorService;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Dispatcher {

    private ExecutorService executorServiceOrNull;
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;
    public Dispatcher() {
        super();
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.readyAsyncCalls = arrayDeque;
        ArrayDeque arrayDeque2 = new ArrayDeque();
        this.runningAsyncCalls = arrayDeque2;
        ArrayDeque arrayDeque3 = new ArrayDeque();
        this.runningSyncCalls = arrayDeque3;
    }

    public Dispatcher(ExecutorService executorService) {
        n.f(executorService, "executorService");
        super();
        this.executorServiceOrNull = executorService;
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String string) {
        Object next;
        boolean next2;
        boolean z;
        Iterator iterator = this.runningAsyncCalls.iterator();
        for (RealCall.AsyncCall next : iterator) {
        }
        Iterator iterator2 = this.readyAsyncCalls.iterator();
        for (RealCall.AsyncCall next2 : iterator2) {
        }
        return null;
    }

    private final <T> void finished(Deque<T> deque, T t2) {
        synchronized (this) {
            try {
                Runnable obj1 = this.idleCallback;
                w obj2 = w.a;
                if (!promoteAndExecute() && obj1 != null) {
                }
                if (obj1 != null) {
                }
                obj1.run();
                obj1 = new AssertionError("Call wasn't in-flight!");
                throw obj1;
                throw deque;
            }
        }
    }

    private final boolean promoteAndExecute() {
        boolean assertionsEnabled;
        int i2;
        String next;
        int i;
        int runningAsyncCalls;
        int maxRequestsPerHost;
        ExecutorService executorService;
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(this);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.readyAsyncCalls.iterator();
        n.e(iterator, "readyAsyncCalls.iterator()");
        synchronized (this) {
            while (iterator.hasNext()) {
                next = iterator.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                } else {
                }
                if ((RealCall.AsyncCall)next.getCallsPerHost().get() >= this.maxRequestsPerHost) {
                } else {
                }
                iterator.remove();
                next.getCallsPerHost().incrementAndGet();
                n.e(next, "asyncCall");
                arrayList.add(next);
                this.runningAsyncCalls.add(next);
            }
            i2 = runningCallsCount() > 0 ? 1 : i;
            w wVar = w.a;
        }
        while (i < arrayList.size()) {
            (RealCall.AsyncCall)arrayList.get(i).executeOn(executorService());
            i++;
        }
        return i2;
    }

    public final ExecutorService -deprecated_executorService() {
        return executorService();
    }

    public final void cancelAll() {
        RealCall call;
        boolean next;
        boolean next2;
        Iterator iterator = this.readyAsyncCalls.iterator();
        synchronized (this) {
            try {
                for (RealCall.AsyncCall next5 : iterator) {
                    next5.getCall().cancel();
                }
                (RealCall.AsyncCall)iterator.next().getCall().cancel();
                Iterator iterator2 = this.runningAsyncCalls.iterator();
                for (RealCall.AsyncCall next4 : iterator2) {
                    next4.getCall().cancel();
                }
                (RealCall.AsyncCall)iterator2.next().getCall().cancel();
                Iterator iterator3 = this.runningSyncCalls.iterator();
                for (RealCall next2 : iterator3) {
                    next2.cancel();
                }
                (RealCall)iterator3.next().cancel();
                throw th;
            }
        }
    }

    public final void enqueue$okhttp(RealCall.AsyncCall realCall$AsyncCall) {
        boolean existingCallWithHost;
        n.f(asyncCall, "call");
        this.readyAsyncCalls.add(asyncCall);
        synchronized (this) {
            existingCallWithHost = findExistingCallWithHost(asyncCall.getHost());
            if (existingCallWithHost != null) {
                asyncCall.reuseCallsPerHostFrom(existingCallWithHost);
            }
            final w obj2 = w.a;
            promoteAndExecute();
        }
    }

    public final void executed$okhttp(RealCall realCall) {
        n.f(realCall, "call");
        this.runningSyncCalls.add(realCall);
        return;
        synchronized (this) {
            n.f(realCall, "call");
            this.runningSyncCalls.add(realCall);
        }
    }

    public final ExecutorService executorService() {
        Object executorServiceOrNull;
        ThreadPoolExecutor threadPoolExecutor;
        int i2;
        int i3;
        int i;
        TimeUnit sECONDS;
        SynchronousQueue synchronousQueue;
        java.util.concurrent.ThreadFactory threadFactory;
        synchronized (this) {
            try {
                synchronousQueue = new SynchronousQueue();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Util.okHttpName);
                stringBuilder.append(" Dispatcher");
                super(0, Integer.MAX_VALUE, 60, obj5, TimeUnit.SECONDS, synchronousQueue, Util.threadFactory(stringBuilder.toString(), false));
                this.executorServiceOrNull = executorServiceOrNull;
                ExecutorService executorServiceOrNull2 = this.executorServiceOrNull;
                n.d(executorServiceOrNull2);
                return executorServiceOrNull2;
                throw th;
            }
        }
    }

    public final void finished$okhttp(RealCall.AsyncCall realCall$AsyncCall) {
        n.f(asyncCall, "call");
        asyncCall.getCallsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, asyncCall);
    }

    public final void finished$okhttp(RealCall realCall) {
        n.f(realCall, "call");
        finished(this.runningSyncCalls, realCall);
    }

    public final Runnable getIdleCallback() {
        return this.idleCallback;
        synchronized (this) {
            return this.idleCallback;
        }
    }

    public final int getMaxRequests() {
        return this.maxRequests;
        synchronized (this) {
            return this.maxRequests;
        }
    }

    public final int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
        synchronized (this) {
            return this.maxRequestsPerHost;
        }
    }

    public final List<okhttp3.Call> queuedCalls() {
        int call;
        ArrayDeque readyAsyncCalls = this.readyAsyncCalls;
        ArrayList arrayList = new ArrayList(p.r(readyAsyncCalls, 10));
        Iterator iterator = readyAsyncCalls.iterator();
        synchronized (this) {
            try {
                for (RealCall.AsyncCall next2 : iterator) {
                    arrayList.add(next2.getCall());
                }
                arrayList.add((RealCall.AsyncCall)iterator.next().getCall());
                List unmodifiableList = Collections.unmodifiableList(arrayList);
                n.e(unmodifiableList, "Collections.unmodifiable…yncCalls.map { it.call })");
                return unmodifiableList;
                throw th;
            }
        }
    }

    public final int queuedCallsCount() {
        return this.readyAsyncCalls.size();
        synchronized (this) {
            return this.readyAsyncCalls.size();
        }
    }

    public final List<okhttp3.Call> runningCalls() {
        int call;
        ArrayDeque runningAsyncCalls = this.runningAsyncCalls;
        ArrayList arrayList = new ArrayList(p.r(runningAsyncCalls, 10));
        Iterator iterator = runningAsyncCalls.iterator();
        synchronized (this) {
            try {
                for (RealCall.AsyncCall next2 : iterator) {
                    arrayList.add(next2.getCall());
                }
                arrayList.add((RealCall.AsyncCall)iterator.next().getCall());
                List unmodifiableList = Collections.unmodifiableList(p.t0(this.runningSyncCalls, arrayList));
                n.e(unmodifiableList, "Collections.unmodifiable…yncCalls.map { it.call })");
                return unmodifiableList;
                throw th;
            }
        }
    }

    public final int runningCallsCount() {
        return size += size2;
        synchronized (this) {
            return size += size2;
        }
    }

    public final void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
        return;
        synchronized (this) {
            this.idleCallback = runnable;
        }
    }

    public final void setMaxRequests(int i) {
        int i2;
        if (i >= 1) {
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
        } else {
            this.maxRequests = i;
            w obj3 = w.a;
            promoteAndExecute();
            return;
            synchronized (this) {
                this.maxRequests = i;
                obj3 = w.a;
                promoteAndExecute();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("max < 1: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
        throw illegalArgumentException;
    }

    public final void setMaxRequestsPerHost(int i) {
        int i2;
        if (i >= 1) {
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
        } else {
            this.maxRequestsPerHost = i;
            w obj3 = w.a;
            promoteAndExecute();
            return;
            synchronized (this) {
                this.maxRequestsPerHost = i;
                obj3 = w.a;
                promoteAndExecute();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("max < 1: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
        throw illegalArgumentException;
    }
}
