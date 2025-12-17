package app.dogo.com.dogo_android.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u000c\u001a\u00020\u0008R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\t¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/service/ConnectivityService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "isConnectedToInternet", "", "()Z", "getActiveNetworkType", "Lapp/dogo/com/dogo_android/service/ConnectivityService$NetworkType;", "isActiveNetworkUsingVpn", "NetworkType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j2 {

    private final ConnectivityManager a;
    public j2(Context context) {
        n.f(context, "context");
        super();
        final Object obj2 = context.getSystemService("connectivity");
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.a = (ConnectivityManager)obj2;
    }

    public final boolean a() {
        NetworkCapabilities networkCapabilities;
        int i;
        android.net.Network activeNetwork;
        ConnectivityManager connectivityManager = this.a;
        networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
            i = networkCapabilities.hasCapability(16) ? 1 : 0;
        } else {
        }
        return i;
    }
}
