package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.j0;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\u0008\u001c\u0010\u001dB\u0019\u0008\u0016\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\u0008\u001c\u0010\u001eJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001d\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\u0008\u000e\u0010\u0008J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\u0008\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u0019\u0010\u0008R\u0013\u0010\u0003\u001a\u00020\u00028G@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0011R'\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\n8G@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010\u001a\u001a\u0004\u0008\r\u0010\u000cR\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010\u001b\u001a\u0004\u0008\t\u0010\u0008R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00068G@\u0006¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0008¨\u0006\u001f", d2 = {"Lokhttp3/Challenge;", "", "Ljava/nio/charset/Charset;", "charset", "withCharset", "(Ljava/nio/charset/Charset;)Lokhttp3/Challenge;", "", "-deprecated_scheme", "()Ljava/lang/String;", "scheme", "", "-deprecated_authParams", "()Ljava/util/Map;", "authParams", "-deprecated_realm", "realm", "-deprecated_charset", "()Ljava/nio/charset/Charset;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/Map;", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Challenge {

    private final Map<String, String> authParams;
    private final String scheme;
    public Challenge(String string, String string2) {
        n.f(string, "scheme");
        String str2 = "realm";
        n.f(string2, str2);
        final Map obj3 = Collections.singletonMap(str2, string2);
        n.e(obj3, "singletonMap(\"realm\", realm)");
        super(string, obj3);
    }

    public Challenge(String string, Map<String, String> map2) {
        String value;
        String lowerCase;
        String str;
        String str2;
        n.f(string, "scheme");
        n.f(map2, "authParams");
        super();
        this.scheme = string;
        LinkedHashMap obj5 = new LinkedHashMap();
        Iterator obj6 = map2.entrySet().iterator();
        while (obj6.hasNext()) {
            Object next2 = obj6.next();
            Object key = (Map.Entry)next2.getKey();
            if ((String)key != null) {
            } else {
            }
            lowerCase = 0;
            obj5.put(lowerCase, (String)next2.getValue());
            Locale uS = Locale.US;
            n.e(uS, "US");
            Objects.requireNonNull((String)key, "null cannot be cast to non-null type java.lang.String");
            n.e(key.toLowerCase(uS), "(this as java.lang.String).toLowerCase(locale)");
        }
        obj5 = Collections.unmodifiableMap(obj5);
        n.e(obj5, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = obj5;
    }

    public final Map<String, String> -deprecated_authParams() {
        return this.authParams;
    }

    public final Charset -deprecated_charset() {
        return charset();
    }

    public final String -deprecated_realm() {
        return realm();
    }

    public final String -deprecated_scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final Charset charset() {
        Object obj = this.authParams.get("charset");
        if ((String)obj != null) {
            Charset forName = Charset.forName((String)obj);
            n.e(forName, "Charset.forName(charset)");
            return forName;
        }
        Charset iSO_8859_1 = StandardCharsets.ISO_8859_1;
        n.e(iSO_8859_1, "ISO_8859_1");
        return iSO_8859_1;
    }

    public boolean equals(Object object) {
        Map authParams;
        String scheme;
        int obj3;
        if (object instanceof Challenge && n.b(object.scheme, this.scheme) && n.b(object.authParams, this.authParams)) {
            if (n.b(object.scheme, this.scheme)) {
                obj3 = n.b(object.authParams, this.authParams) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj3;
    }

    public int hashCode() {
        return i5 += i2;
    }

    public final String realm() {
        return (String)this.authParams.get("realm");
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.scheme);
        stringBuilder.append(" authParams=");
        stringBuilder.append(this.authParams);
        return stringBuilder.toString();
    }

    public final okhttp3.Challenge withCharset(Charset charset) {
        String str = "charset";
        n.f(charset, str);
        Map map = j0.y(this.authParams);
        String obj4 = charset.name();
        n.e(obj4, "charset.name()");
        map.put(str, obj4);
        obj4 = new Challenge(this.scheme, map);
        return obj4;
    }
}
