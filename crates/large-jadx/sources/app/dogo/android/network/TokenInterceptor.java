package app.dogo.android.network;

import i.b.a0;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.k0.l;
import kotlin.y.i;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

/* compiled from: TokenInterceptor.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017R&\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000f¨\u0006\u0018", d2 = {"Lapp/dogo/android/network/TokenInterceptor;", "Lokhttp3/Interceptor;", "token", "", "refreshTokenCallBack", "Lkotlin/Function0;", "Lio/reactivex/Single;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getRefreshTokenCallBack", "()Lkotlin/jvm/functions/Function0;", "setRefreshTokenCallBack", "(Lkotlin/jvm/functions/Function0;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "isJwtTokenStillValid", "", "currentTimeSeconds", "", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class TokenInterceptor implements Interceptor {

    private String a;
    private kotlin.d0.c.a<? extends a0<String>> b;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0010\u0012\u000c\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n", d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements kotlin.d0.c.a<a0<String>> {

        final /* synthetic */ String $token;
        @Override // kotlin.d0.d.p
        public final a0<String> a() {
            a0 just = a0.just(this.$token);
            n.e(just, "just(token)");
            return just;
        }

        a(String str) {
            this.$token = str;
            super(0);
        }
    }
    public d(String str, kotlin.d0.c.a<? extends a0<String>> aVar) {
        n.f(str, "token");
        n.f(aVar, "refreshTokenCallBack");
        super();
        this.a = str;
        this.b = aVar;
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final boolean isJwtTokenStillValid(String token, long currentTimeSeconds) {
        boolean z = true;
        int i2 = 0;
        n.f(token, "token");
        final int i = 0;
        try {
            Object[] array = new Regex("\\.").f(token, i).toArray(new String[i]);
            Long l = l.o(String.valueOf((Claims)Jwts.parserBuilder().build().parseClaimsJwt(p.h0(i.u(array, 1), ".", null, ".", 0, null, null, 58, null)).getBody().get("exp")));
            if (l == null) {
                i2 = 0;
            } else {
                long value = l.longValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Exception e) {
            a.d(e);
        } catch (io.jsonwebtoken.ExpiredJwtException unused) {
        }
        return z;
    }

    public final void f(kotlin.d0.c.a<? extends a0<String>> aVar) {
        n.f(aVar, "<set-?>");
        this.b = aVar;
    }

    public final void g(String str) {
        n.f(str, "<set-?>");
        this.a = str;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws NetworkExceptions.BlankTokenException {
        Response proceed;
        boolean z;
        n.f(chain, "chain");
        l = System.currentTimeMillis() / (long)1000;
        if (!l.z(this.a)) {
            if (!isJwtTokenStillValid(this.a, System.currentTimeMillis() / (long)1000)) {
                Object blockingGet = (a0)this.b.invoke().onErrorReturn(a.a).blockingGet();
                str = "refreshTokenCallBack().onErrorReturn { \"\" }.blockingGet()";
                n.e(blockingGet, str);
                this.a = blockingGet;
            }
        }
        if (!l.z(this.a) == 0) {
            Throwable th = null;
            throw new NetworkExceptions_BlankTokenException("Authorisation token was blank when calling backend api", th, 2, th);
        } else {
            String str9 = "Bearer ";
            final String str11 = "Authorization";
            proceed = chain.proceed(chain.request().newBuilder().header(str11, n.o(str9, this.a)).build());
            int i = 401;
            if (proceed.code() == 401) {
                Object blockingGet2 = (a0)this.b.invoke().onErrorReturn(b.a).blockingGet();
                n.e(blockingGet2, "newToken");
                i = !l.z(blockingGet2);
                if (!l.z(blockingGet2) != 0) {
                    this.a = blockingGet2;
                    proceed.close();
                    proceed = chain.proceed(chain.request().newBuilder().header(str11, n.o(str9, blockingGet2)).build());
                }
            }
            return proceed;
        }
    }

    public /* synthetic */ d(String str, kotlin.d0.c.a aVar, int i, g gVar) {
        String str2;
        app.dogo.android.network.d.a aVar2;
        str2 = i & 1 != 0 ? "" : str2;
        if (i & 2 != 0) {
            aVar2 = new d.a(str2);
        }
        this(str2, aVar2);
    }

    /* renamed from: a, reason: from kotlin metadata */
    private static final String intercept(Throwable chain) {
        n.f(chain, "it");
        return "";
    }

    private static final String b(Throwable th) {
        n.f(th, "it");
        return "";
    }

    public static /* synthetic */ String d(Throwable th) {
        return TokenInterceptor.intercept(th);
    }

    public static /* synthetic */ String e(Throwable th) {
        return TokenInterceptor.b(th);
    }
}
