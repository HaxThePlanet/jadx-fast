package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\u0008\u000e\u0008\u0086\u0001\u0018\u0000 \t2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\u0008\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000f¨\u0006\u0010", d2 = {"Lokhttp3/Protocol;", "", "", "toString", "()Ljava/lang/String;", "protocol", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "okhttp"}, k = 1, mv = {1, 4, 0})
public enum Protocol {

    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.0"),
    SPDY_3("http/1.0"),
    HTTP_2("http/1.0"),
    H2_PRIOR_KNOWLEDGE("http/1.0"),
    QUIC("http/1.0");

    private final String protocol;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lokhttp3/Protocol$Companion;", "", "", "protocol", "Lokhttp3/Protocol;", "get", "(Ljava/lang/String;)Lokhttp3/Protocol;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.Protocol get(String string) {
            okhttp3.Protocol h2_PRIOR_KNOWLEDGE;
            boolean z;
            n.f(string, "protocol");
            if (n.b(string, Protocol.access$getProtocol$p(Protocol.HTTP_1_0))) {
                return h2_PRIOR_KNOWLEDGE;
            } else {
                if (n.b(string, Protocol.access$getProtocol$p(Protocol.HTTP_1_1))) {
                } else {
                    if (n.b(string, Protocol.access$getProtocol$p(Protocol.H2_PRIOR_KNOWLEDGE))) {
                    } else {
                        if (n.b(string, Protocol.access$getProtocol$p(Protocol.HTTP_2))) {
                        } else {
                            if (n.b(string, Protocol.access$getProtocol$p(Protocol.SPDY_3))) {
                            } else {
                                if (!n.b(string, Protocol.access$getProtocol$p(Protocol.QUIC))) {
                                } else {
                                }
                            }
                        }
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected protocol: ");
            stringBuilder.append(string);
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }
    }
    public static final String access$getProtocol$p(okhttp3.Protocol protocol) {
        return protocol.protocol;
    }

    public static final okhttp3.Protocol get(String string) {
        return Protocol.Companion.get(string);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
