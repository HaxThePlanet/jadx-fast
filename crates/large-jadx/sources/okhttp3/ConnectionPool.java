package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0011\u0008\u0000\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008\u000e\u0010\u000fB!\u0008\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\u0008\u000e\u0010\u0015B\t\u0008\u0016¢\u0006\u0004\u0008\u000e\u0010\u0008J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0007\u0010\u0008R\u001c\u0010\n\u001a\u00020\t8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0016", d2 = {"Lokhttp3/ConnectionPool;", "", "", "idleConnectionCount", "()I", "connectionCount", "Lkotlin/w;", "evictAll", "()V", "Lokhttp3/internal/connection/RealConnectionPool;", "delegate", "Lokhttp3/internal/connection/RealConnectionPool;", "getDelegate$okhttp", "()Lokhttp3/internal/connection/RealConnectionPool;", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;)V", "maxIdleConnections", "", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "(IJLjava/util/concurrent/TimeUnit;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ConnectionPool {

    private final RealConnectionPool delegate;
    public ConnectionPool() {
        super(5, 5, obj3, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long l2, TimeUnit timeUnit3) {
        n.f(obj11, "timeUnit");
        super(TaskRunner.INSTANCE, i, l2, obj5, obj11);
        super(realConnectionPool);
    }

    public ConnectionPool(RealConnectionPool realConnectionPool) {
        n.f(realConnectionPool, "delegate");
        super();
        this.delegate = realConnectionPool;
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }
}
