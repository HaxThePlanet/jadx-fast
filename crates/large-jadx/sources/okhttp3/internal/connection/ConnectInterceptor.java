package okhttp3.internal.connection;

import kotlin.Metadata;
import kotlin.d0.d.n;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lokhttp3/internal/connection/ConnectInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ConnectInterceptor implements Interceptor {

    public static final okhttp3.internal.connection.ConnectInterceptor INSTANCE;
    static {
        ConnectInterceptor connectInterceptor = new ConnectInterceptor();
        ConnectInterceptor.INSTANCE = connectInterceptor;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        n.f(chain, "chain");
        return RealInterceptorChain.copy$okhttp$default(chain, 0, (RealInterceptorChain)chain.getCall$okhttp().initExchange$okhttp(chain), 0, 0, 0, 0, 61, 0).proceed(chain.getRequest$okhttp());
    }
}
