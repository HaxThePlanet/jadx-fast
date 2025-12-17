package okhttp3.internal.connection;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.p;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000i\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005*\u0001*\u0018\u0000 42\u00020\u0001:\u00014B'\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010/\u001a\u00020\u0004\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\u00082\u00103J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\u0008\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\u0008\u000b\u0010\nJ5\u0010\u0015\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008 \u0010!R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008%\u0010&R\u001c\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008+\u0010,¨\u00065", d2 = {"Lokhttp3/internal/connection/RealConnectionPool;", "", "Lokhttp3/internal/connection/RealConnection;", "connection", "", "now", "", "pruneAndGetAllocationCount", "(Lokhttp3/internal/connection/RealConnection;J)I", "idleConnectionCount", "()I", "connectionCount", "Lokhttp3/Address;", "address", "Lokhttp3/internal/connection/RealCall;", "call", "", "Lokhttp3/Route;", "routes", "", "requireMultiplexed", "callAcquirePooledConnection", "(Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Ljava/util/List;Z)Z", "Lkotlin/w;", "put", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionBecameIdle", "(Lokhttp3/internal/connection/RealConnection;)Z", "evictAll", "()V", "cleanup", "(J)J", "maxIdleConnections", "I", "keepAliveDurationNs", "J", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "connections", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "cleanupTask", "Lokhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealConnectionPool {

    public static final okhttp3.internal.connection.RealConnectionPool.Companion Companion;
    private final TaskQueue cleanupQueue;
    private final okhttp3.internal.connection.RealConnectionPool.cleanupTask.1 cleanupTask;
    private final ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "Lokhttp3/ConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "get", "(Lokhttp3/ConnectionPool;)Lokhttp3/internal/connection/RealConnectionPool;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.connection.RealConnectionPool get(ConnectionPool connectionPool) {
            n.f(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }
    }
    static {
        RealConnectionPool.Companion companion = new RealConnectionPool.Companion(0);
        RealConnectionPool.Companion = companion;
    }

    public RealConnectionPool(TaskRunner taskRunner, int i2, long l3, TimeUnit timeUnit4) {
        int obj3;
        n.f(taskRunner, "taskRunner");
        n.f(obj7, "timeUnit");
        super();
        this.maxIdleConnections = i2;
        this.keepAliveDurationNs = obj7.toNanos(l3);
        this.cleanupQueue = taskRunner.newQueue();
        StringBuilder obj4 = new StringBuilder();
        obj4.append(Util.okHttpName);
        obj4.append(" ConnectionPool");
        obj3 = new RealConnectionPool.cleanupTask.1(this, obj4.toString());
        this.cleanupTask = obj3;
        obj3 = new ConcurrentLinkedQueue();
        this.connections = obj3;
        obj3 = Long.compare(l3, obj3) > 0 ? 1 : 0;
        if (obj3 == null) {
        } else {
        }
        obj3 = new StringBuilder();
        obj3.append("keepAliveDuration <= 0: ");
        obj3.append(l3);
        obj4 = new IllegalArgumentException(obj3.toString().toString());
        throw obj4;
    }

    private final int pruneAndGetAllocationCount(okhttp3.internal.connection.RealConnection realConnection, long l2) {
        boolean assertionsEnabled;
        int i;
        Object empty;
        Object string;
        Platform platform;
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(realConnection)) {
            } else {
            }
            StringBuilder obj9 = new StringBuilder();
            obj9.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            obj9.append(currentThread.getName());
            obj9.append(" MUST hold lock on ");
            obj9.append(realConnection);
            AssertionError obj8 = new AssertionError(obj9.toString());
            throw obj8;
        }
        List calls = realConnection.getCalls();
        int i2 = 0;
        i = i2;
        while (i < calls.size()) {
            empty = calls.get(i);
            Objects.requireNonNull(empty, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("A connection to ");
            stringBuilder.append(realConnection.route().address().url());
            stringBuilder.append(" was leaked. ");
            stringBuilder.append("Did you forget to close a response body?");
            Platform.Companion.get().logCloseableLeak(stringBuilder.toString(), (RealCall.CallReference)empty.getCallStackTrace());
            calls.remove(i);
            realConnection.setNoNewExchanges(true);
            i++;
        }
        return calls.size();
    }

    public final boolean callAcquirePooledConnection(Address address, okhttp3.internal.connection.RealCall realCall2, List<Route> list3, boolean z4) {
        Object next;
        w wVar;
        boolean multiplexed$okhttp;
        n.f(address, "address");
        n.f(realCall2, "call");
        Iterator iterator = this.connections.iterator();
        for (RealConnection next : iterator) {
            n.e(next, "connection");
            wVar = w.a;
        }
        return 0;
    }

    public final long cleanup(long l) {
        int maxIdleConnections;
        int i2;
        int i;
        int i3;
        long l2;
        Object next;
        int pruneAndGetAllocationCount;
        int cmp;
        boolean obj11;
        Iterator iterator = this.connections.iterator();
        l2 = l3;
        i3 = i6;
        i = i2;
        while (iterator.hasNext()) {
            next = iterator.next();
            n.e((RealConnection)next, "connection");
            if (pruneAndGetAllocationCount(next, l) > 0) {
            } else {
            }
            i2++;
            pruneAndGetAllocationCount = l - idleAtNs$okhttp;
            if (Long.compare(pruneAndGetAllocationCount, l2) > 0) {
            } else {
            }
            pruneAndGetAllocationCount = w.a;
            w wVar = w.a;
            i3 = next;
            l2 = pruneAndGetAllocationCount;
            i++;
        }
        long keepAliveDurationNs = this.keepAliveDurationNs;
        if (Long.compare(l2, keepAliveDurationNs) < 0) {
            if (i2 > this.maxIdleConnections) {
            } else {
                if (i2 > 0) {
                    return keepAliveDurationNs -= l2;
                }
                if (i > 0) {
                    return keepAliveDurationNs;
                }
            }
            return -1;
        }
        n.d(i3);
        int i5 = 1;
        int i7 = 0;
        synchronized (i3) {
            return i7;
        }
        this.cleanupQueue.cancelAll();
        return i7;
    }

    public final boolean connectionBecameIdle(okhttp3.internal.connection.RealConnection realConnection) {
        boolean assertionsEnabled;
        int maxIdleConnections;
        int i3;
        TaskQueue cleanupQueue;
        okhttp3.internal.connection.RealConnectionPool.cleanupTask.1 cleanupTask;
        int i;
        int i4;
        int i2;
        Object obj9;
        n.f(realConnection, "connection");
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(realConnection)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(realConnection);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
        if (!realConnection.getNoNewExchanges()) {
            if (this.maxIdleConnections == 0) {
                realConnection.setNoNewExchanges(true);
                this.connections.remove(realConnection);
                if (this.connections.isEmpty()) {
                    this.cleanupQueue.cancelAll();
                }
            } else {
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, obj5, 2);
                i3 = 0;
            }
        } else {
        }
        return i3;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        boolean cleanupQueue;
        String next;
        java.net.Socket socket;
        Iterator iterator = this.connections.iterator();
        n.e(iterator, "connections.iterator()");
        while (iterator.hasNext()) {
            next = iterator.next();
            n.e((RealConnection)next, "connection");
            if (next.getCalls().isEmpty()) {
            } else {
            }
            socket = 0;
            if (socket != null) {
            }
            Util.closeQuietly(socket);
            iterator.remove();
            next.setNoNewExchanges(true);
            socket = next.socket();
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        Object connections;
        boolean empty;
        int i;
        boolean empty2;
        connections = this.connections;
        i = 0;
        if (connections instanceof Collection != null && connections.isEmpty()) {
            if (connections.isEmpty()) {
            } else {
                connections = connections.iterator();
                for (RealConnection empty : connections) {
                    n.e(empty, "it");
                }
            }
        } else {
        }
        return i;
    }

    public final void put(okhttp3.internal.connection.RealConnection realConnection) {
        boolean assertionsEnabled;
        n.f(realConnection, "connection");
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(realConnection)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(realConnection);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
        this.connections.add(realConnection);
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, obj4, 2);
    }
}
