package io.grpc.k1;

import com.google.common.base.n;
import io.grpc.k1.r.b;
import io.grpc.k1.r.d;
import io.grpc.k1.r.g;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
final class m {

    static final List<g> a;
    static {
        g[] arr = new g[1];
        m.a = Collections.unmodifiableList(Arrays.asList(g.HTTP_2));
    }

    static String a(String string) {
        boolean startsWith;
        int i;
        String obj2;
        if (string.startsWith("[") && string.endsWith("]")) {
            if (string.endsWith("]")) {
                i = 1;
                obj2 = string.substring(i, length -= i);
            }
        }
        return obj2;
    }

    public static SSLSocket b(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier2, Socket socket3, String string4, int i5, b b6) {
        d obj3;
        int obj6;
        n.p(sSLSocketFactory, "sslSocketFactory");
        n.p(socket3, "socket");
        n.p(b6, "spec");
        Socket obj2 = sSLSocketFactory.createSocket(socket3, string4, i5, true);
        b6.c((SSLSocket)obj2, false);
        obj6 = b6.f() ? m.a : 0;
        String obj4 = j.e().h(obj2, string4, obj6);
        obj6 = m.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Only ");
        stringBuilder.append(obj6);
        stringBuilder.append(" are supported, but negotiated protocol is %s");
        n.x(obj6.contains(g.get(obj4)), stringBuilder.toString(), obj4);
        if (hostnameVerifier2 == null) {
            obj3 = d.a;
        }
        if (!obj3.verify(m.a(string4), obj2.getSession())) {
        } else {
            return obj2;
        }
        obj3 = new StringBuilder();
        obj3.append("Cannot verify hostname: ");
        obj3.append(string4);
        obj2 = new SSLPeerUnverifiedException(obj3.toString());
        throw obj2;
    }
}
