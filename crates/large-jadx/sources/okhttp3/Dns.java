package okhttp3;

import java.net.InetAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u0000 \u00082\u00020\u0001:\u0001\u0008J\u001d\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\t", d2 = {"Lokhttp3/Dns;", "", "", "hostname", "", "Ljava/net/InetAddress;", "lookup", "(Ljava/lang/String;)Ljava/util/List;", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public interface Dns {

    public static final okhttp3.Dns.Companion Companion;
    public static final okhttp3.Dns SYSTEM;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0001\u0082\u0002\u0007\n\u0005\u0008\u0091F0\u0001¨\u0006\u0008", d2 = {"Lokhttp3/Dns$Companion;", "", "Lokhttp3/Dns;", "SYSTEM", "Lokhttp3/Dns;", "<init>", "()V", "DnsSystem", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        static final okhttp3.Dns.Companion $$INSTANCE;
        public Companion(g g) {
            super();
        }
    }
    static {
        Dns.Companion companion = new Dns.Companion(0);
        Dns.Companion = companion;
        Dns.Companion.DnsSystem dnsSystem = new Dns.Companion.DnsSystem();
        Dns.SYSTEM = dnsSystem;
    }

    public abstract List<InetAddress> lookup(String string);
}
