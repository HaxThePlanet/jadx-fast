package okhttp3.internal.http;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealCall;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u001a\u001a\u00020 \u0012\u000c\u0010&\u001a\u0008\u0012\u0004\u0012\u00020%0$\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0008\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\u00082\u00103JM\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00022\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\u00022\u0008\u0008\u0002\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010J\u000f\u0010\u0008\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0008\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\t\u0010\u0011J\u001f\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\u0008\u0017\u0010\u0016J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\n\u0010\u0011J\u001f\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\u0008\u0018\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u0007\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u001e\u0010\u001fR\u001c\u0010\u001a\u001a\u00020 8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u001a\u0010!\u001a\u0004\u0008\"\u0010#R\u001c\u0010&\u001a\u0008\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008&\u0010'R\u001c\u0010\u0008\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u0008\u0010(\u001a\u0004\u0008)\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u0007\u0010*\u001a\u0004\u0008+\u0010\u001cR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010(R\u001c\u0010\n\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\n\u0010(\u001a\u0004\u0008,\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u0005\u0010-\u001a\u0004\u0008.\u0010/R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00080\u0010(R\u001c\u0010\t\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\t\u0010(\u001a\u0004\u00081\u0010\u0011¨\u00064", d2 = {"Lokhttp3/internal/http/RealInterceptorChain;", "Lokhttp3/Interceptor$Chain;", "", "index", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/Request;", "request", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "copy$okhttp", "(ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)Lokhttp3/internal/http/RealInterceptorChain;", "copy", "Lokhttp3/Connection;", "connection", "()Lokhttp3/Connection;", "()I", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "withConnectTimeout", "(ILjava/util/concurrent/TimeUnit;)Lokhttp3/Interceptor$Chain;", "withReadTimeout", "withWriteTimeout", "Lokhttp3/Call;", "call", "()Lokhttp3/Call;", "()Lokhttp3/Request;", "Lokhttp3/Response;", "proceed", "(Lokhttp3/Request;)Lokhttp3/Response;", "Lokhttp3/internal/connection/RealCall;", "Lokhttp3/internal/connection/RealCall;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "", "Lokhttp3/Interceptor;", "interceptors", "Ljava/util/List;", "I", "getConnectTimeoutMillis$okhttp", "Lokhttp3/Request;", "getRequest$okhttp", "getWriteTimeoutMillis$okhttp", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "calls", "getReadTimeoutMillis$okhttp", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/util/List;ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealInterceptorChain implements Interceptor.Chain {

    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;
    public RealInterceptorChain(RealCall realCall, List<? extends Interceptor> list2, int i3, Exchange exchange4, Request request5, int i6, int i7, int i8) {
        n.f(realCall, "call");
        n.f(list2, "interceptors");
        n.f(request5, "request");
        super();
        this.call = realCall;
        this.interceptors = list2;
        this.index = i3;
        this.exchange = exchange4;
        this.request = request5;
        this.connectTimeoutMillis = i6;
        this.readTimeoutMillis = i7;
        this.writeTimeoutMillis = i8;
    }

    public static okhttp3.internal.http.RealInterceptorChain copy$okhttp$default(okhttp3.internal.http.RealInterceptorChain realInterceptorChain, int i2, Exchange exchange3, Request request4, int i5, int i6, int i7, int i8, Object object9) {
        int obj5;
        Exchange obj6;
        Request obj7;
        int obj8;
        int obj9;
        int obj10;
        if (i8 & 1 != 0) {
            obj5 = realInterceptorChain.index;
        }
        if (i8 & 2 != 0) {
            obj6 = realInterceptorChain.exchange;
        }
        if (i8 & 4 != 0) {
            obj7 = realInterceptorChain.request;
        }
        if (i8 & 8 != 0) {
            obj8 = realInterceptorChain.connectTimeoutMillis;
        }
        if (i8 & 16 != 0) {
            obj9 = realInterceptorChain.readTimeoutMillis;
        }
        if (i8 & 32 != 0) {
            obj10 = realInterceptorChain.writeTimeoutMillis;
        }
        return realInterceptorChain.copy$okhttp(obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // okhttp3.Interceptor$Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor$Chain
    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor$Chain
    public Connection connection() {
        okhttp3.internal.connection.RealConnection connection$okhttp;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            connection$okhttp = exchange.getConnection$okhttp();
        } else {
            connection$okhttp = 0;
        }
        return connection$okhttp;
    }

    @Override // okhttp3.Interceptor$Chain
    public final okhttp3.internal.http.RealInterceptorChain copy$okhttp(int i, Exchange exchange2, Request request3, int i4, int i5, int i6) {
        final Object obj = this;
        n.f(request3, "request");
        super(obj.call, obj.interceptors, i, exchange2, request3, i4, i5, i6);
        return realInterceptorChain;
    }

    @Override // okhttp3.Interceptor$Chain
    public final RealCall getCall$okhttp() {
        return this.call;
    }

    @Override // okhttp3.Interceptor$Chain
    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor$Chain
    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    @Override // okhttp3.Interceptor$Chain
    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor$Chain
    public final Request getRequest$okhttp() {
        return this.request;
    }

    @Override // okhttp3.Interceptor$Chain
    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    @Override // okhttp3.Interceptor$Chain
    public Response proceed(Request request) {
        int i2;
        int exchange;
        int i;
        okhttp3.HttpUrl httpUrl;
        Exchange exchange2;
        Object size;
        int obj15;
        n.f(request, "request");
        i = 0;
        final int i6 = 1;
        i2 = this.index < this.interceptors.size() ? i6 : i;
        if (i2 == 0) {
        } else {
            this.calls = calls += i6;
            exchange = this.exchange;
            String str6 = " must call proceed() exactly once";
            final String str7 = "network interceptor ";
            if (exchange != null) {
                if (!exchange.getFinder$okhttp().sameHostAndPort(request.url())) {
                } else {
                    exchange = this.calls == i6 ? i6 : i;
                    if (exchange == 0) {
                    } else {
                    }
                    obj15 = new StringBuilder();
                    obj15.append(str7);
                    obj15.append((Interceptor)this.interceptors.get(index4 -= i6));
                    obj15.append(str6);
                    IllegalStateException illegalStateException = new IllegalStateException(obj15.toString().toString());
                    throw illegalStateException;
                }
                obj15 = new StringBuilder();
                obj15.append(str7);
                obj15.append((Interceptor)this.interceptors.get(index3 -= i6));
                obj15.append(" must retain the same host and port");
                IllegalStateException illegalStateException2 = new IllegalStateException(obj15.toString().toString());
                throw illegalStateException2;
            }
            obj15 = RealInterceptorChain.copy$okhttp$default(this, index2 + 1, 0, request, 0, 0, 0, 58, 0);
            Object obj3 = this.interceptors.get(this.index);
            Response intercept = (Interceptor)obj3.intercept(obj15);
            String str8 = "interceptor ";
            if (intercept == null) {
            } else {
                if (this.exchange != null) {
                    if (index6 += i6 < this.interceptors.size()) {
                        if (obj15.calls == i6) {
                            obj15 = i6;
                        } else {
                            obj15 = i;
                        }
                    } else {
                    }
                    if (obj15 == null) {
                    } else {
                    }
                    obj15 = new StringBuilder();
                    obj15.append(str7);
                    obj15.append(obj3);
                    obj15.append(str6);
                    IllegalStateException illegalStateException3 = new IllegalStateException(obj15.toString().toString());
                    throw illegalStateException3;
                }
                if (intercept.body() != null) {
                    i = i6;
                }
                if (i == 0) {
                } else {
                    return intercept;
                }
                obj15 = new StringBuilder();
                obj15.append(str8);
                obj15.append(obj3);
                obj15.append(" returned a response with no body");
                IllegalStateException illegalStateException4 = new IllegalStateException(obj15.toString().toString());
                throw illegalStateException4;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str8);
            stringBuilder.append(obj3);
            stringBuilder.append(" returned null");
            obj15 = new NullPointerException(stringBuilder.toString());
            throw obj15;
        }
        obj15 = new IllegalStateException("Check failed.".toString());
        throw obj15;
    }

    @Override // okhttp3.Interceptor$Chain
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor$Chain
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor$Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit2) {
        int i2;
        n.f(timeUnit2, "unit");
        i2 = this.exchange == null ? 1 : 0;
        if (i2 == 0) {
        } else {
            return RealInterceptorChain.copy$okhttp$default(this, 0, 0, 0, Util.checkDuration("connectTimeout", (long)i, obj1), 0, 0, 55, 0);
        }
        IllegalStateException obj11 = new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
        throw obj11;
    }

    @Override // okhttp3.Interceptor$Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit2) {
        int i2;
        n.f(timeUnit2, "unit");
        i2 = this.exchange == null ? 1 : 0;
        if (i2 == 0) {
        } else {
            return RealInterceptorChain.copy$okhttp$default(this, 0, 0, 0, 0, Util.checkDuration("readTimeout", (long)i, obj1), 0, 47, 0);
        }
        IllegalStateException obj11 = new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
        throw obj11;
    }

    @Override // okhttp3.Interceptor$Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit2) {
        int i2;
        n.f(timeUnit2, "unit");
        i2 = this.exchange == null ? 1 : 0;
        if (i2 == 0) {
        } else {
            return RealInterceptorChain.copy$okhttp$default(this, 0, 0, 0, 0, 0, Util.checkDuration("writeTimeout", (long)i, obj1), 31, 0);
        }
        IllegalStateException obj11 = new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
        throw obj11;
    }

    @Override // okhttp3.Interceptor$Chain
    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
