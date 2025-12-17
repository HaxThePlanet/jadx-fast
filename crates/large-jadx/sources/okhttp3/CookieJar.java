package okhttp3;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008f\u0018\u0000 \u000c2\u00020\u0001:\u0001\u000cJ%\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\u0008\u0008\u0010\tJ\u001d\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\n\u0010\u000b¨\u0006\r", d2 = {"Lokhttp3/CookieJar;", "", "Lokhttp3/HttpUrl;", "url", "", "Lokhttp3/Cookie;", "cookies", "Lkotlin/w;", "saveFromResponse", "(Lokhttp3/HttpUrl;Ljava/util/List;)V", "loadForRequest", "(Lokhttp3/HttpUrl;)Ljava/util/List;", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface CookieJar {

    public static final okhttp3.CookieJar.Companion Companion;
    public static final okhttp3.CookieJar NO_COOKIES;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0001\u0082\u0002\u0007\n\u0005\u0008\u0091F0\u0001¨\u0006\u0008", d2 = {"Lokhttp3/CookieJar$Companion;", "", "Lokhttp3/CookieJar;", "NO_COOKIES", "Lokhttp3/CookieJar;", "<init>", "()V", "NoCookies", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        static final okhttp3.CookieJar.Companion $$INSTANCE;
        public Companion(g g) {
            super();
        }
    }
    static {
        CookieJar.Companion companion = new CookieJar.Companion(0);
        CookieJar.Companion = companion;
        CookieJar.Companion.NoCookies noCookies = new CookieJar.Companion.NoCookies();
        CookieJar.NO_COOKIES = noCookies;
    }

    public abstract List<okhttp3.Cookie> loadForRequest(okhttp3.HttpUrl httpUrl);

    public abstract void saveFromResponse(okhttp3.HttpUrl httpUrl, List<okhttp3.Cookie> list2);
}
