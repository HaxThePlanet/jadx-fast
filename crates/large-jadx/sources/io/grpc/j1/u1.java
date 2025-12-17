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

/* loaded from: classes3.dex */
class u1 implements a1 {

    private static final Logger d;
    private static final io.grpc.j1.u1.c e;
    private static final s<ProxySelector> f;
    private final s<ProxySelector> a;
    private final io.grpc.j1.u1.c b;
    private final InetSocketAddress c;

    interface c {
        public abstract PasswordAuthentication a(String string, InetAddress inetAddress2, int i3, String string4, String string5, String string6);
    }

    class a implements io.grpc.j1.u1.c {
        @Override // io.grpc.j1.u1$c
        public PasswordAuthentication a(String string, InetAddress inetAddress2, int i3, String string4, String string5, String string6) {
            URL url;
            String str;
            int format;
            int str2;
            try {
                url = new URL(string4, string, i3, "");
                format = 2;
                format = new Object[format];
                str2 = 0;
                format[str2] = string4;
                str2 = 1;
                format[str2] = string;
                str2 = "failed to create URL for Authenticator: %s %s";
                format = String.format(str2, format);
                u1.b().log(Level.WARNING, format);
                return Authenticator.requestPasswordAuthentication(string, inetAddress2, i3, string4, string5, string6, url, Authenticator.RequestorType.PROXY);
            }
        }
    }

    class b implements s<ProxySelector> {
        @Override // com.google.common.base.s
        public ProxySelector a() {
            return ProxySelector.getDefault();
        }

        @Override // com.google.common.base.s
        public Object get() {
            return a();
        }
    }
    static {
        u1.d = Logger.getLogger(u1.class.getName());
        u1.a aVar = new u1.a();
        u1.e = aVar;
        u1.b bVar = new u1.b();
        u1.f = bVar;
    }

    public u1() {
        super(u1.f, u1.e, System.getenv("GRPC_PROXY_EXP"));
    }

    u1(s<ProxySelector> s, io.grpc.j1.u1.c u1$c2, String string3) {
        InetSocketAddress obj1;
        super();
        n.o(s);
        this.a = (s)s;
        n.o(c2);
        this.b = (u1.c)c2;
        if (string3 != null) {
            this.c = u1.d(string3);
        } else {
            this.c = 0;
        }
    }

    static Logger b() {
        return u1.d;
    }

    private z0 c(InetSocketAddress inetSocketAddress) {
        int string;
        Object address;
        int size;
        int str;
        boolean byName;
        Object inetSocketAddress2;
        char[] obj11;
        string = 0;
        super("https", 0, r0.h(inetSocketAddress), inetSocketAddress.getPort(), 0, 0, 0);
        Object obj = this.a.get();
        if ((ProxySelector)obj == null) {
            try {
                u1.d.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                return string;
                List select = (ProxySelector)obj.select(uri2);
                if (select.size() > 1) {
                }
                u1.d.warning("More than 1 proxy detected, gRPC will select the first one");
                Object obj2 = select.get(0);
            } catch (java.net.URISyntaxException uRISyntax) {
            }
            try {
                return string;
                address = obj2.address();
                PasswordAuthentication passwordAuthentication = this.b.a(r0.h((InetSocketAddress)address), address.getAddress(), address.getPort(), "https", "", 0);
                if (address.isUnresolved()) {
                }
                inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(address.getHostName()), address.getPort());
                address = inetSocketAddress2;
                c0.b bVar = c0.e();
                bVar.d(inetSocketAddress);
                bVar.c(address);
                if (passwordAuthentication == null) {
                }
                return bVar.a();
                bVar.e(passwordAuthentication.getUserName());
                if (passwordAuthentication.getPassword() == null) {
                } else {
                }
                string = new String(passwordAuthentication.getPassword());
                bVar.b(string);
                return bVar.a();
                Logger logger = u1.d;
                Level wARNING = Level.WARNING;
                String str4 = "Failed to construct URI for proxy lookup, proceeding without proxy";
                logger.log(wARNING, str4, inetSocketAddress);
                return obj0;
                logger = u1.d;
                wARNING = Level.WARNING;
                str4 = "Failed to get host for proxy lookup, proceeding without proxy";
                logger.log(wARNING, str4, inetSocketAddress);
                return obj0;
            }
        }
    }

    private static InetSocketAddress d(String string) {
        int int;
        if (string == null) {
            return null;
        }
        String[] obj3 = string.split(":", 2);
        int = 80;
        int i2 = 1;
        if (obj3.length > i2) {
            int = Integer.parseInt(obj3[i2]);
        }
        u1.d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        InetSocketAddress inetSocketAddress = new InetSocketAddress(obj3[0], int);
        return inetSocketAddress;
    }

    @Override // io.grpc.a1
    public z0 a(SocketAddress socketAddress) {
        if (!socketAddress instanceof InetSocketAddress) {
            return null;
        }
        if (this.c != null) {
            c0.b bVar = c0.e();
            bVar.c(this.c);
            bVar.d((InetSocketAddress)socketAddress);
            return bVar.a();
        }
        return c((InetSocketAddress)socketAddress);
    }
}
