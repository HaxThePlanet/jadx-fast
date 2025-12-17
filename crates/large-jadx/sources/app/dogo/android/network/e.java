package app.dogo.android.network;

import android.os.Build.VERSION;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016R\u000e\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lapp/dogo/android/network/UserAgentInterceptor;", "Lokhttp3/Interceptor;", "versionName", "", "versionCode", "", "androidVersion", "(Ljava/lang/String;ILjava/lang/String;)V", "userAgent", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e implements Interceptor {

    private final String a;
    public e(String string, int i2, String string3) {
        n.f(string, "versionName");
        n.f(string3, "androidVersion");
        super();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dogo Android ");
        stringBuilder.append(string);
        stringBuilder.append(" (");
        stringBuilder.append(i2);
        stringBuilder.append("); Android ");
        stringBuilder.append(string3);
        this.a = stringBuilder.toString();
    }

    public e(String string, int i2, String string3, int i4, g g5) {
        String obj1;
        int obj2;
        String obj3;
        int obj4;
        obj1 = i4 & 1 != 0 ? "7.22.1" : obj1;
        obj2 = i4 & 2 != 0 ? 70220100 : obj2;
        if (i4 &= 4 != 0) {
            n.e(Build.VERSION.RELEASE, "RELEASE");
        }
        super(obj1, obj2, obj3);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        n.f(chain, "chain");
        return chain.proceed(chain.request().newBuilder().header("User-Agent", this.a).build());
    }
}
