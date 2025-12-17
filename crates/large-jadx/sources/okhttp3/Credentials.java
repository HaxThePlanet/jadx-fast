package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.d0.d.n;
import l.i;
import l.i.a;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\t\u0010\nJ)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0008¨\u0006\u000b", d2 = {"Lokhttp3/Credentials;", "", "", "username", "password", "Ljava/nio/charset/Charset;", "charset", "basic", "(Ljava/lang/String;Ljava/lang/String;Ljava/nio/charset/Charset;)Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Credentials {

    public static final okhttp3.Credentials INSTANCE;
    static {
        Credentials credentials = new Credentials();
        Credentials.INSTANCE = credentials;
    }

    public static final String basic(String string, String string2) {
        final int i = 0;
        return Credentials.basic$default(string, string2, i, 4, i);
    }

    public static final String basic(String string, String string2, Charset charset3) {
        n.f(string, "username");
        n.f(string2, "password");
        n.f(charset3, "charset");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(':');
        stringBuilder.append(string2);
        StringBuilder obj2 = new StringBuilder();
        obj2.append("Basic ");
        obj2.append(i.v.c(stringBuilder.toString(), charset3).a());
        return obj2.toString();
    }

    public static String basic$default(String string, String string2, Charset charset3, int i4, Object object5) {
        Charset obj2;
        int obj3;
        if (i4 &= 4 != 0) {
            n.e(StandardCharsets.ISO_8859_1, "ISO_8859_1");
        }
        return Credentials.basic(string, string2, obj2);
    }
}
