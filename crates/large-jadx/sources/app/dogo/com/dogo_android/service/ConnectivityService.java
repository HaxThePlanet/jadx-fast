package app.dogo.com.dogo_android.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ConnectivityService.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u000c\u001a\u00020\u0008R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\t¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/service/ConnectivityService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "isConnectedToInternet", "", "()Z", "getActiveNetworkType", "Lapp/dogo/com/dogo_android/service/ConnectivityService$NetworkType;", "isActiveNetworkUsingVpn", "NetworkType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j2, reason: from kotlin metadata */
public final class ConnectivityService {

    /* renamed from: a, reason: from kotlin metadata */
    private final ConnectivityManager connectivityManager;
    public j2(Context context) {
        n.f(context, "context");
        super();
        final Object systemService = context.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = systemService;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final boolean getActiveNetworkType() {
        boolean z = false;
        android.net.Network activeNetwork;
        NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(this.connectivityManager.getActiveNetwork());
        if (networkCapabilities != null) {
            int r0 = networkCapabilities.hasCapability(16) ? 1 : 0;
        }
        return (networkCapabilities.hasCapability(16) ? 1 : 0);
    }
}
