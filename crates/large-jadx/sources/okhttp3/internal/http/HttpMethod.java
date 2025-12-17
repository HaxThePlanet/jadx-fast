package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0006J\u0015\u0010\u0008\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0008\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\t\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\n\u0010\u0006¨\u0006\r", d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "", "method", "", "requiresRequestBody", "(Ljava/lang/String;)Z", "permitsRequestBody", "invalidatesCache", "redirectsWithBody", "redirectsToGet", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class HttpMethod {

    public static final okhttp3.internal.http.HttpMethod INSTANCE;
    static {
        HttpMethod httpMethod = new HttpMethod();
        HttpMethod.INSTANCE = httpMethod;
    }

    public static final boolean permitsRequestBody(String string) {
        boolean str;
        Object obj1;
        n.f(string, "method");
        if (!n.b(string, "GET") && !n.b(string, "HEAD")) {
            obj1 = !n.b(string, "HEAD") ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static final boolean requiresRequestBody(String string) {
        boolean str;
        Object obj1;
        n.f(string, "method");
        if (!n.b(string, "POST") && !n.b(string, "PUT") && !n.b(string, "PATCH") && !n.b(string, "PROPPATCH")) {
            if (!n.b(string, "PUT")) {
                if (!n.b(string, "PATCH")) {
                    if (!n.b(string, "PROPPATCH")) {
                        if (n.b(string, "REPORT")) {
                            obj1 = 1;
                        } else {
                            obj1 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    public final boolean invalidatesCache(String string) {
        boolean str;
        Object obj2;
        n.f(string, "method");
        if (!n.b(string, "POST") && !n.b(string, "PATCH") && !n.b(string, "PUT") && !n.b(string, "DELETE")) {
            if (!n.b(string, "PATCH")) {
                if (!n.b(string, "PUT")) {
                    if (!n.b(string, "DELETE")) {
                        if (n.b(string, "MOVE")) {
                            obj2 = 1;
                        } else {
                            obj2 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    public final boolean redirectsToGet(String string) {
        n.f(string, "method");
        return obj2 ^= 1;
    }

    public final boolean redirectsWithBody(String string) {
        n.f(string, "method");
        return n.b(string, "PROPFIND");
    }
}
