package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import okhttp3.Route;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0015\u0010\u0008\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\u0008\u0008\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\u0008\n\u0010\u000bR\u001c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\r\u0010\u000e¨\u0006\u0011", d2 = {"Lokhttp3/internal/connection/RouteDatabase;", "", "Lokhttp3/Route;", "failedRoute", "Lkotlin/w;", "failed", "(Lokhttp3/Route;)V", "route", "connected", "", "shouldPostpone", "(Lokhttp3/Route;)Z", "", "failedRoutes", "Ljava/util/Set;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RouteDatabase {

    private final Set<Route> failedRoutes;
    public RouteDatabase() {
        super();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.failedRoutes = linkedHashSet;
    }

    public final void connected(Route route) {
        n.f(route, "route");
        this.failedRoutes.remove(route);
        return;
        synchronized (this) {
            n.f(route, "route");
            this.failedRoutes.remove(route);
        }
    }

    public final void failed(Route route) {
        n.f(route, "failedRoute");
        this.failedRoutes.add(route);
        return;
        synchronized (this) {
            n.f(route, "failedRoute");
            this.failedRoutes.add(route);
        }
    }

    public final boolean shouldPostpone(Route route) {
        n.f(route, "route");
        return this.failedRoutes.contains(route);
        synchronized (this) {
            n.f(route, "route");
            return this.failedRoutes.contains(route);
        }
    }
}
