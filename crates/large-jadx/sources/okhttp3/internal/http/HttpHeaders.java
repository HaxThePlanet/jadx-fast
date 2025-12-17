package okhttp3.internal.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.j0;
import l.f;
import l.i;
import l.i.a;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.Cookie.Companion;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0005\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u001f\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\u0008\u0005\u0010\u0006\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00072\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0008H\u0002¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0007H\u0002¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\u0008\u0016\u0010\u0015\u001a!\u0010\u001b\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\u0008\u001b\u0010\u001c\u001a\u0011\u0010\u001e\u001a\u00020\r*\u00020\u001d¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a\u0017\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001dH\u0007¢\u0006\u0004\u0008!\u0010\u001f\"\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008#\u0010$\"\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008%\u0010$¨\u0006&", d2 = {"Lokhttp3/Headers;", "", "headerName", "", "Lokhttp3/Challenge;", "parseChallenges", "(Lokhttp3/Headers;Ljava/lang/String;)Ljava/util/List;", "Ll/f;", "", "result", "Lkotlin/w;", "readChallengeHeader", "(Ll/f;Ljava/util/List;)V", "", "skipCommasAndWhitespace", "(Ll/f;)Z", "", "prefix", "startsWith", "(Ll/f;B)Z", "readQuotedString", "(Ll/f;)Ljava/lang/String;", "readToken", "Lokhttp3/CookieJar;", "Lokhttp3/HttpUrl;", "url", "headers", "receiveHeaders", "(Lokhttp3/CookieJar;Lokhttp3/HttpUrl;Lokhttp3/Headers;)V", "Lokhttp3/Response;", "promisesBody", "(Lokhttp3/Response;)Z", "response", "hasBody", "Ll/i;", "TOKEN_DELIMITERS", "Ll/i;", "QUOTED_STRING_DELIMITERS", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class HttpHeaders {

    private static final i QUOTED_STRING_DELIMITERS;
    private static final i TOKEN_DELIMITERS;
    static {
        i.a aVar = i.v;
        HttpHeaders.QUOTED_STRING_DELIMITERS = aVar.d("\"\\");
        HttpHeaders.TOKEN_DELIMITERS = aVar.d("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        n.f(response, "response");
        return HttpHeaders.promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String string2) {
        int i2;
        Throwable fVar;
        Platform.Companion value;
        int i;
        String str;
        n.f(headers, "$this$parseChallenges");
        n.f(string2, "headerName");
        ArrayList arrayList = new ArrayList();
        i2 = 0;
        while (i2 < headers.size()) {
            if (l.x(string2, headers.name(i2), true)) {
            }
            i2++;
            fVar = new f();
            fVar.b1(headers.value(i2));
            HttpHeaders.readChallengeHeader(fVar, arrayList);
            value = Platform.Companion;
            value = value.get();
            value.log("Unable to parse challenge", 5, fVar);
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        int cmp;
        int str;
        long headersContentLength;
        Object obj8;
        n.f(response, "$this$promisesBody");
        int i2 = 0;
        if (n.b(response.request().method(), "HEAD")) {
            return i2;
        }
        int code = response.code();
        final int i3 = 1;
        if (code >= 100) {
            if (code >= 200 && code != 204 && code != 304) {
                if (code != 204) {
                    if (code != 304) {
                        return i3;
                    }
                }
            }
        } else {
        }
        headersContentLength = 0;
        if (Long.compare(headersContentLength, i4) == 0 && l.x("chunked", Response.header$default(response, "Transfer-Encoding", headersContentLength, 2, headersContentLength), i3)) {
            headersContentLength = 0;
            if (l.x("chunked", Response.header$default(response, "Transfer-Encoding", headersContentLength, 2, headersContentLength), i3)) {
            }
            return i2;
        }
        return i3;
    }

    private static final void readChallengeHeader(f f, List<Challenge> list2) {
        int token;
        Challenge linkedHashMap;
        boolean skipCommasAndWhitespace4;
        Map singletonMap;
        boolean skipCommasAndWhitespace;
        String challenge;
        int skipCommasAndWhitespace2;
        boolean skipCommasAndWhitespace3;
        int i = 0;
        while (/* condition */) {
            while (token == null) {
                HttpHeaders.skipCommasAndWhitespace(f);
                singletonMap = HttpHeaders.readToken(f);
                byte b = (byte)i2;
                skipCommasAndWhitespace2 = Util.skipAll(f, b);
                linkedHashMap = new LinkedHashMap();
                skipCommasAndWhitespace2 += skipCommasAndWhitespace3;
                while (singletonMap == null) {
                    singletonMap = HttpHeaders.readToken(f);
                    skipCommasAndWhitespace2 = Util.skipAll(f, b);
                    if (HttpHeaders.startsWith(f, (byte)i4)) {
                    } else {
                    }
                    skipCommasAndWhitespace3 = HttpHeaders.readToken(f);
                    singletonMap = i;
                    skipCommasAndWhitespace3 = HttpHeaders.readQuotedString(f);
                }
                if (HttpHeaders.startsWith(f, (byte)i4)) {
                } else {
                }
                skipCommasAndWhitespace3 = HttpHeaders.readToken(f);
                singletonMap = i;
                skipCommasAndWhitespace3 = HttpHeaders.readQuotedString(f);
                challenge = new Challenge(token, linkedHashMap);
                list2.add(challenge);
                token = singletonMap;
                singletonMap = HttpHeaders.readToken(f);
                skipCommasAndWhitespace2 = Util.skipAll(f, b);
            }
            singletonMap = HttpHeaders.readToken(f);
            b = (byte)i2;
            skipCommasAndWhitespace2 = Util.skipAll(f, b);
            linkedHashMap = new LinkedHashMap();
            skipCommasAndWhitespace2 += skipCommasAndWhitespace3;
            while (singletonMap == null) {
                singletonMap = HttpHeaders.readToken(f);
                skipCommasAndWhitespace2 = Util.skipAll(f, b);
                if (HttpHeaders.startsWith(f, (byte)i4)) {
                } else {
                }
                skipCommasAndWhitespace3 = HttpHeaders.readToken(f);
                singletonMap = i;
                skipCommasAndWhitespace3 = HttpHeaders.readQuotedString(f);
            }
            if (HttpHeaders.startsWith(f, (byte)i4)) {
            } else {
            }
            skipCommasAndWhitespace3 = HttpHeaders.readToken(f);
            singletonMap = i;
            skipCommasAndWhitespace3 = HttpHeaders.readQuotedString(f);
            challenge = new Challenge(token, linkedHashMap);
            list2.add(challenge);
            token = singletonMap;
            singletonMap = HttpHeaders.readToken(f);
            skipCommasAndWhitespace2 = Util.skipAll(f, b);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(singletonMap);
            stringBuilder.append(l.C("=", skipCommasAndWhitespace2));
            singletonMap = Collections.singletonMap(i, stringBuilder.toString());
            n.e(singletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
            linkedHashMap = new Challenge(token, singletonMap);
            list2.add(linkedHashMap);
            token = i;
            HttpHeaders.skipCommasAndWhitespace(f);
        }
    }

    private static final String readQuotedString(f f) {
        int i4;
        long l;
        int cmp;
        int i;
        long size;
        int i2;
        int i3;
        byte b = (byte)i5;
        i4 = f.readByte() == b ? 1 : 0;
        if (i4 == 0) {
        } else {
            f fVar = new f();
            l = f.n0(HttpHeaders.QUOTED_STRING_DELIMITERS);
            i = 0;
            while (Long.compare(l, i6) == 0) {
                i2 = 1;
                fVar.write(f, l);
                f.readByte();
                fVar.write(f, i2);
                l = f.n0(HttpHeaders.QUOTED_STRING_DELIMITERS);
                i = 0;
            }
            return i;
        }
        IllegalArgumentException obj12 = new IllegalArgumentException("Failed requirement.".toString());
        throw obj12;
    }

    private static final String readToken(f f) {
        long size;
        String obj4;
        if (Long.compare(size, i) == 0) {
            size = f.size();
        }
        if (Long.compare(size, i2) != 0) {
            obj4 = f.L(size);
        } else {
            obj4 = 0;
        }
        return obj4;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl2, Headers headers3) {
        n.f(cookieJar, "$this$receiveHeaders");
        n.f(httpUrl2, "url");
        n.f(headers3, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
        }
        final List obj3 = Cookie.Companion.parseAll(httpUrl2, headers3);
        if (obj3.isEmpty()) {
        }
        cookieJar.saveFromResponse(httpUrl2, obj3);
    }

    private static final boolean skipCommasAndWhitespace(f f) {
        int i2;
        byte b;
        int i;
        i2 = 0;
        while (!f.b0()) {
            b = f.n(0);
            if (b != 9) {
                break;
            } else {
            }
            f.readByte();
            if (b != 32) {
                break;
            } else {
            }
            if (b != 44) {
                break;
            } else {
            }
            f.readByte();
            i2 = 1;
        }
        return i2;
    }

    private static final boolean startsWith(f f, byte b2) {
        boolean z;
        byte obj2;
        if (!f.b0() && f.n(0) == b2) {
            obj2 = f.n(0) == b2 ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
