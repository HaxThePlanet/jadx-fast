package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import l.i;
import l.i.a;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0008\u0086\u0008\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\u0008\u0017\u0010\u0018B\u0019\u0008\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\u0008\u0017\u0010\u0019B\u0019\u0008\u0016\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\u0008\u0017\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0010\u0010\u0008\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\u0008\u0008\u0010\u0007J$\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\t\u001a\u00020\u00052\u0008\u0008\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\n\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\t\u0010\u0016¨\u0006\u001c", d2 = {"Lokhttp3/internal/http2/Header;", "", "", "toString", "()Ljava/lang/String;", "Ll/i;", "component1", "()Ll/i;", "component2", "name", "value", "copy", "(Ll/i;Ll/i;)Lokhttp3/internal/http2/Header;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "hpackSize", "I", "Ll/i;", "<init>", "(Ll/i;Ll/i;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ll/i;Ljava/lang/String;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Header {

    public static final okhttp3.internal.http2.Header.Companion Companion = null;
    public static final i PSEUDO_PREFIX = null;
    public static final i RESPONSE_STATUS = null;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final i TARGET_AUTHORITY = null;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final i TARGET_METHOD = null;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final i TARGET_PATH = null;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final i TARGET_SCHEME = null;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final i name;
    public final i value;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\r\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\n\u0010\u0008R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0004R\u0016\u0010\u000c\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u0008R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u0008R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0008¨\u0006\u0013", d2 = {"Lokhttp3/internal/http2/Header$Companion;", "", "Ll/i;", "PSEUDO_PREFIX", "Ll/i;", "RESPONSE_STATUS", "", "RESPONSE_STATUS_UTF8", "Ljava/lang/String;", "TARGET_AUTHORITY", "TARGET_AUTHORITY_UTF8", "TARGET_METHOD", "TARGET_METHOD_UTF8", "TARGET_PATH", "TARGET_PATH_UTF8", "TARGET_SCHEME", "TARGET_SCHEME_UTF8", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }
    static {
        Header.Companion companion = new Header.Companion(0);
        Header.Companion = companion;
        i.a aVar = i.v;
        Header.PSEUDO_PREFIX = aVar.d(":");
        Header.RESPONSE_STATUS = aVar.d(":status");
        Header.TARGET_METHOD = aVar.d(":method");
        Header.TARGET_PATH = aVar.d(":path");
        Header.TARGET_SCHEME = aVar.d(":scheme");
        Header.TARGET_AUTHORITY = aVar.d(":authority");
    }

    public Header(String string, String string2) {
        n.f(string, "name");
        n.f(string2, "value");
        i.a aVar = i.v;
        super(aVar.d(string), aVar.d(string2));
    }

    public Header(i i, String string2) {
        n.f(i, "name");
        n.f(string2, "value");
        super(i, i.v.d(string2));
    }

    public Header(i i, i i2) {
        n.f(i, "name");
        n.f(i2, "value");
        super();
        this.name = i;
        this.value = i2;
        this.hpackSize = obj2 += obj3;
    }

    public static okhttp3.internal.http2.Header copy$default(okhttp3.internal.http2.Header header, i i2, i i3, int i4, Object object5) {
        i obj1;
        i obj2;
        if (i4 & 1 != 0) {
            obj1 = header.name;
        }
        if (i4 &= 2 != 0) {
            obj2 = header.value;
        }
        return header.copy(obj1, obj2);
    }

    public final i component1() {
        return this.name;
    }

    public final i component2() {
        return this.value;
    }

    public final okhttp3.internal.http2.Header copy(i i, i i2) {
        n.f(i, "name");
        n.f(i2, "value");
        Header header = new Header(i, i2);
        return header;
    }

    public boolean equals(Object object) {
        boolean value;
        i name;
        Object obj3;
        if (this != (Header)object && object instanceof Header && n.b(this.name, object.name) && n.b(this.value, object.value)) {
            if (object instanceof Header) {
                if (n.b(this.name, object.name)) {
                    if (n.b(this.value, object.value)) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public int hashCode() {
        int i;
        int i2;
        i name = this.name;
        if (name != null) {
            i = name.hashCode();
        } else {
            i = i2;
        }
        final i value = this.value;
        if (value != null) {
            i2 = value.hashCode();
        }
        return i3 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name.E());
        stringBuilder.append(": ");
        stringBuilder.append(this.value.E());
        return stringBuilder.toString();
    }
}
