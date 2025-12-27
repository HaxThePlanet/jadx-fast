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

/* compiled from: UserAgentInterceptor.kt */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016R\u000e\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lapp/dogo/android/network/UserAgentInterceptor;", "Lokhttp3/Interceptor;", "versionName", "", "versionCode", "", "androidVersion", "(Ljava/lang/String;ILjava/lang/String;)V", "userAgent", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class UserAgentInterceptor implements Interceptor {

    /* renamed from: a, reason: from kotlin metadata */
    private final String userAgent;
    public e(String str, int i, String str2) {
        n.f(str, "versionName");
        n.f(str2, "androidVersion");
        super();
        StringBuilder stringBuilder = new StringBuilder();
        final String str5 = "Dogo Android ";
        String str6 = " (";
        String str7 = "); Android ";
        str8 = str5 + str + str6 + i + str7 + str2;
        this.userAgent = str8;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        n.f(chain, "chain");
        return chain.proceed(chain.request().newBuilder().header("User-Agent", this.userAgent).build());
    }

    public /* synthetic */ e(String str, int i, String str2, int i2, g gVar) {
        String rELEASE2;
        str2 = i2 & 1 != 0 ? "7.22.1" : str2;
        i = i2 & 2 != 0 ? 70220100 : i;
        i3 = i2 & 4;
        if (i2 & 4 != 0) {
            n.e(Build.VERSION.RELEASE, "RELEASE");
        }
        this(str2, i, rELEASE2);
    }
}
