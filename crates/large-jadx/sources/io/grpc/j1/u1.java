package io.grpc.j1;

import com.google.common.base.n;
import com.google.common.base.s;
import io.grpc.a1;
import io.grpc.c0;
import io.grpc.c0.b;
import io.grpc.z0;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ProxyDetectorImpl.java */
/* loaded from: classes3.dex */
class u1 implements a1 {

    private static final Logger d;
    private static final u1.c e = new u1$a();
    private static final s<ProxySelector> f = new u1$b<>();
    private final s<ProxySelector> a;
    private final u1.c b;
    private final InetSocketAddress c;

    interface c {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i, String str2, String str3, String str4);
    }

    class a implements u1.c {
        a() {
            super();
        }

        public PasswordAuthentication a(String str, InetAddress inetAddress, int i, String str2, String str3, String str4) {
            URL url;
            try {
                str2 = "";
                url = new URL(str2, str, i, str2);
            } catch (java.net.MalformedURLException unused) {
                int formatted = 2;
                formatted = new Object[formatted];
                int str7 = 0;
                formatted[str7] = str2;
                str7 = 1;
                formatted[str7] = str;
                str7 = "failed to create URL for Authenticator: %s %s";
                formatted = String.format(str7, formatted);
                u1.d.log(Level.WARNING, formatted);
            }
            return Authenticator.requestPasswordAuthentication(str, inetAddress, i, str2, str3, str4, url, Authenticator.RequestorType.PROXY);
        }
    }

    class b implements s<ProxySelector> {
        b() {
            super();
        }

        public ProxySelector a() {
            return ProxySelector.getDefault();
        }
    }
    static {
        u1.d = Logger.getLogger(u1.class.getName());
    }

    public u1() {
        this(u1.f, u1.e, System.getenv("GRPC_PROXY_EXP"));
    }

    static /* synthetic */ Logger b() {
        return u1.d;
    }

    private z0 c(InetSocketAddress inetSocketAddress) throws java.net.UnknownHostException, java.io.UnsupportedEncodingException {
        String string = null;
        SocketAddress address;
        int i2 = 0;
        try {
        } catch (java.net.URISyntaxException uRISyntax) {
            Logger logger = u1.d;
            Level wARNING2 = Level.WARNING;
            String str3 = "Failed to construct URI for proxy lookup, proceeding without proxy";
            logger.log(wARNING2, str3, uRISyntax);
            return obj;
        }
        try {
            URI uri = new URI("https", null, r0.h(inetSocketAddress), uRISyntax.getPort(), null, null, null);
        } catch (java.net.URISyntaxException uRISyntax) {
            logger = u1.d;
            wARNING2 = Level.WARNING;
            str3 = "Failed to construct URI for proxy lookup, proceeding without proxy";
            logger.log(wARNING2, str3, uRISyntax);
            return obj;
        }
        Object obj2 = this.a.get();
        if (obj2 == null) {
            u1.d.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
            return i2;
        }
        List select = obj2.select(uri);
        int i = 1;
        if (select.size() > 1) {
            u1.d.warning("More than 1 proxy detected, gRPC will select the first one");
        }
        Object item = select.get(0);
        if (item.type() == Proxy.Type.DIRECT) {
            return i2;
        }
        address = item.address();
        PasswordAuthentication passwordAuthentication = this.b.a(r0.h(address), address.getAddress(), address.getPort(), "https", "", null);
        if (address.isUnresolved()) {
        }
        c0.b bVar = c0.e();
        bVar.d(uRISyntax);
        bVar.c(address);
        if (passwordAuthentication == null) {
            return bVar.a();
        }
        bVar.e(passwordAuthentication.getUserName());
        if (passwordAuthentication.getPassword() != null) {
            string = new String(passwordAuthentication.getPassword());
        }
        bVar.b(string);
        return bVar.a();
    }

    private static InetSocketAddress d(String str) {
        int parsed = 80;
        if (str == null) {
            return null;
        }
        String[] parts = str.split(":", 2);
        parsed = 80;
        int i2 = 1;
        if (parts.length > i2) {
            parsed = Integer.parseInt(parts[i2]);
        }
        u1.d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(parts[0], parsed);
    }

    public z0 a(SocketAddress socketAddress) {
        if (!(socketAddress instanceof InetSocketAddress)) {
            return null;
        }
        if (this.c != null) {
            c0.b bVar = c0.e();
            bVar.c(this.c);
            bVar.d(socketAddress);
            return bVar.a();
        }
        return c(socketAddress);
    }

    u1(s<ProxySelector> sVar, u1.c cVar, String str) {
        super();
        n.o(sVar);
        this.a = sVar;
        n.o(cVar);
        this.b = cVar;
        if (str != null) {
            this.c = u1.d(str);
        } else {
            InetSocketAddress inetSocketAddress = null;
            this.c = inetSocketAddress;
        }
    }
}
