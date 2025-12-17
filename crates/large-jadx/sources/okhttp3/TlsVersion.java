package okhttp3;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\u0008\r\u0008\u0086\u0001\u0018\u0000 \t2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\u0008\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0005\u0010\u0004j\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000e¨\u0006\u000f", d2 = {"Lokhttp3/TlsVersion;", "", "", "-deprecated_javaName", "()Ljava/lang/String;", "javaName", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "okhttp"}, k = 1, mv = {1, 4, 0})
public enum TlsVersion {

    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.3"),
    TLS_1_1("TLSv1.3"),
    TLS_1_0("TLSv1.3"),
    SSL_3_0("TLSv1.3");

    private final String javaName;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lokhttp3/TlsVersion$Companion;", "", "", "javaName", "Lokhttp3/TlsVersion;", "forJavaName", "(Ljava/lang/String;)Lokhttp3/TlsVersion;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.TlsVersion forJavaName(String string) {
            boolean equals;
            int i;
            okhttp3.TlsVersion obj4;
            n.f(string, "javaName");
            equals = string.hashCode();
            if (equals != 79201641) {
                if (equals != 79923350) {
                    switch (equals) {
                        case -503070503:
                            obj4 = TlsVersion.TLS_1_1;
                            return obj4;
                        case -503070502:
                            obj4 = TlsVersion.TLS_1_2;
                            return obj4;
                        case -503070501:
                            obj4 = TlsVersion.TLS_1_3;
                            return obj4;
                        default:
                    }
                } else {
                    if (!string.equals("TLSv1")) {
                    } else {
                        obj4 = TlsVersion.TLS_1_0;
                    }
                }
            } else {
                if (!string.equals("SSLv3")) {
                } else {
                    obj4 = TlsVersion.SSL_3_0;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected TLS version: ");
            stringBuilder.append(string);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
    }
    public static final okhttp3.TlsVersion forJavaName(String string) {
        return TlsVersion.Companion.forJavaName(string);
    }

    @Override // java.lang.Enum
    public final String -deprecated_javaName() {
        return this.javaName;
    }

    @Override // java.lang.Enum
    public final String javaName() {
        return this.javaName;
    }
}
