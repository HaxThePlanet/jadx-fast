package okhttp3;

import kotlin.Metadata;
import kotlin.d0.d.g;
import okhttp3.internal.authenticator.JavaNetAuthenticator;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008æ\u0080\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\u0008\u0007\u0010\u0008¨\u0006\n", d2 = {"Lokhttp3/Authenticator;", "", "Lokhttp3/Route;", "route", "Lokhttp3/Response;", "response", "Lokhttp3/Request;", "authenticate", "(Lokhttp3/Route;Lokhttp3/Response;)Lokhttp3/Request;", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface Authenticator {

    public static final okhttp3.Authenticator.Companion Companion;
    public static final okhttp3.Authenticator JAVA_NET_AUTHENTICATOR;
    public static final okhttp3.Authenticator NONE;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0008B\t\u0008\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0001R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004¨\u0006\u0001\u0082\u0002\u0007\n\u0005\u0008\u0091F0\u0001¨\u0006\t", d2 = {"Lokhttp3/Authenticator$Companion;", "", "Lokhttp3/Authenticator;", "JAVA_NET_AUTHENTICATOR", "Lokhttp3/Authenticator;", "NONE", "<init>", "()V", "AuthenticatorNone", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        static final okhttp3.Authenticator.Companion $$INSTANCE;
        public Companion(g g) {
            super();
        }
    }
    static {
        final int i = 0;
        Authenticator.Companion companion = new Authenticator.Companion(i);
        Authenticator.Companion = companion;
        Authenticator.Companion.AuthenticatorNone authenticatorNone = new Authenticator.Companion.AuthenticatorNone();
        Authenticator.NONE = authenticatorNone;
        JavaNetAuthenticator javaNetAuthenticator = new JavaNetAuthenticator(i, 1, i);
        Authenticator.JAVA_NET_AUTHENTICATOR = javaNetAuthenticator;
    }

    public abstract okhttp3.Request authenticate(okhttp3.Route route, okhttp3.Response response2);
}
