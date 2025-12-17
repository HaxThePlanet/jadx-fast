package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008æ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0002\u0008\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lokhttp3/Interceptor;", "", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Companion", "Chain", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface Interceptor {

    public static final okhttp3.Interceptor.Companion Companion;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008f\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\u0008H&¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000c\u001a\u00020\u000bH&¢\u0006\u0004\u0008\u000c\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH&¢\u0006\u0004\u0008\u0016\u0010\u0010J\u001f\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\u0008\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u000eH&¢\u0006\u0004\u0008\u0018\u0010\u0010J\u001f\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\u0008\u0019\u0010\u0015¨\u0006\u001a", d2 = {"Lokhttp3/Interceptor$Chain;", "", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "Lokhttp3/Response;", "proceed", "(Lokhttp3/Request;)Lokhttp3/Response;", "Lokhttp3/Connection;", "connection", "()Lokhttp3/Connection;", "Lokhttp3/Call;", "call", "()Lokhttp3/Call;", "", "connectTimeoutMillis", "()I", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "withConnectTimeout", "(ILjava/util/concurrent/TimeUnit;)Lokhttp3/Interceptor$Chain;", "readTimeoutMillis", "withReadTimeout", "writeTimeoutMillis", "withWriteTimeout", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Chain {
        public abstract okhttp3.Call call();

        public abstract int connectTimeoutMillis();

        public abstract okhttp3.Connection connection();

        public abstract okhttp3.Response proceed(okhttp3.Request request);

        public abstract int readTimeoutMillis();

        public abstract okhttp3.Request request();

        public abstract okhttp3.Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit2);

        public abstract okhttp3.Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit2);

        public abstract okhttp3.Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit2);

        public abstract int writeTimeoutMillis();
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\t\u0010\nJ)\u0010\u0007\u001a\u00020\u00062\u0014\u0008\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0086\nø\u0001\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u000b", d2 = {"Lokhttp3/Interceptor$Companion;", "", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lokhttp3/Response;", "block", "Lokhttp3/Interceptor;", "invoke", "(Lkotlin/d0/c/l;)Lokhttp3/Interceptor;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        static final okhttp3.Interceptor.Companion $$INSTANCE;
        static {
            Interceptor.Companion companion = new Interceptor.Companion();
            Interceptor.Companion.$$INSTANCE = companion;
        }

        public final okhttp3.Interceptor invoke(l<? super okhttp3.Interceptor.Chain, okhttp3.Response> l) {
            n.f(l, "block");
            Interceptor.Companion.invoke.1 anon = new Interceptor.Companion.invoke.1(l);
            return anon;
        }
    }
    static {
        Interceptor.Companion = Interceptor.Companion.$$INSTANCE;
    }

    public abstract okhttp3.Response intercept(okhttp3.Interceptor.Chain interceptor$Chain);
}
