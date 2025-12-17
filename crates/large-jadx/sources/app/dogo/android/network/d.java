package app.dogo.android.network;

import i.b.a0;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.h;
import kotlin.k0.l;
import kotlin.y.i;
import kotlin.y.p;
import n.a.a;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017R&\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000f¨\u0006\u0018", d2 = {"Lapp/dogo/android/network/TokenInterceptor;", "Lokhttp3/Interceptor;", "token", "", "refreshTokenCallBack", "Lkotlin/Function0;", "Lio/reactivex/Single;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getRefreshTokenCallBack", "()Lkotlin/jvm/functions/Function0;", "setRefreshTokenCallBack", "(Lkotlin/jvm/functions/Function0;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "isJwtTokenStillValid", "", "currentTimeSeconds", "", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d implements Interceptor {

    private String a;
    private a<? extends a0<String>> b;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0010\u0012\u000c\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n", d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<a0<String>> {

        final String $token;
        a(String string) {
            this.$token = string;
            super(0);
        }

        public final a0<String> a() {
            a0 just = a0.just(this.$token);
            n.e(just, "just(token)");
            return just;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    public d(String string, a<? extends a0<String>> a2) {
        n.f(string, "token");
        n.f(a2, "refreshTokenCallBack");
        super();
        this.a = string;
        this.b = a2;
    }

    public d(String string, a a2, int i3, g g4) {
        String obj1;
        app.dogo.android.network.d.a obj2;
        obj1 = i3 & 1 != 0 ? "" : obj1;
        if (i3 &= 2 != 0) {
            obj2 = new d.a(obj1);
        }
        super(obj1, obj2);
    }

    private static final String a(Throwable throwable) {
        n.f(throwable, "it");
        return "";
    }

    private static final String b(Throwable throwable) {
        n.f(throwable, "it");
        return "";
    }

    public static String d(Throwable throwable) {
        return d.a(throwable);
    }

    public static String e(Throwable throwable) {
        return d.b(throwable);
    }

    @Override // okhttp3.Interceptor
    public final boolean c(String string, long l2) {
        int i;
        long longValue;
        int obj12;
        n.f(string, "token");
        final int i2 = 0;
        h hVar = new h("\\.");
        obj12 = hVar.f(string, i2).toArray(new String[i2]);
        if (obj12 == null) {
        } else {
            obj12 = l.o(String.valueOf((Claims)Jwts.parserBuilder().build().parseClaimsJwt(p.h0(i.u(obj12, 1), ".", 0, ".", 0, 0, 0, 58, 0)).getBody().get("exp")));
            if (obj12 == null) {
                longValue = 0;
            } else {
                longValue = obj12.longValue();
            }
            if (Long.compare(l2, longValue) < 0) {
            } else {
                i = i2;
            }
            return i;
        }
        obj12 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw obj12;
    }

    public final void f(a<? extends a0<String>> a) {
        n.f(a, "<set-?>");
        this.b = a;
    }

    @Override // okhttp3.Interceptor
    public final void g(String string) {
        n.f(string, "<set-?>");
        this.a = string;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain interceptor$Chain) {
        Object blockingGet;
        Response proceed;
        String str;
        int blockingGet2;
        boolean z;
        int builder;
        n.f(chain, "chain");
        if (!l.z(this.a)) {
            if (!c(this.a, currentTimeMillis /= l)) {
                blockingGet = (a0)this.b.invoke().onErrorReturn(a.a).blockingGet();
                n.e(blockingGet, "refreshTokenCallBack().onErrorReturn { \"\" }.blockingGet()");
                this.a = (String)blockingGet;
            }
        } else {
        }
        if (z2 ^= 1 == 0) {
        } else {
            String str9 = "Bearer ";
            final String str10 = "Authorization";
            proceed = chain.proceed(chain.request().newBuilder().header(str10, n.o(str9, this.a)).build());
            blockingGet2 = (a0)this.b.invoke().onErrorReturn(b.a).blockingGet();
            n.e((String)blockingGet2, "newToken");
            if (proceed.code() == 401 && z3 ^= 1 != 0) {
                blockingGet2 = (a0)this.b.invoke().onErrorReturn(b.a).blockingGet();
                n.e((String)blockingGet2, "newToken");
                if (z3 ^= 1 != 0) {
                    this.a = blockingGet2;
                    proceed.close();
                    proceed = chain.proceed(chain.request().newBuilder().header(str10, n.o(str9, blockingGet2)).build());
                }
            }
            return proceed;
        }
        int i4 = 0;
        NetworkExceptions.BlankTokenException obj6 = new NetworkExceptions.BlankTokenException("Authorisation token was blank when calling backend api", i4, 2, i4);
        throw obj6;
    }
}
