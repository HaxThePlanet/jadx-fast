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

/* compiled from: OkHttpTlsUpgrader.java */
/* loaded from: classes3.dex */
final class m {

    static final List<g> a;
    static {
        g[] arr = new g[1];
        m.a = Collections.unmodifiableList(Arrays.asList(new g[] { g.HTTP_2 }));
    }

    static String a(String str) {
        String substring;
        if (str.startsWith("[")) {
            if (str.endsWith("]")) {
                int i = 1;
                substring = str.substring(i, str.length() - i);
            }
        }
        return substring;
    }

    public static SSLSocket b(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String str, int i, b bVar) throws java.io.IOException, SSLPeerUnverifiedException {
        d dVar;
        List list = null;
        n.p(sSLSocketFactory, "sslSocketFactory");
        n.p(socket, "socket");
        n.p(bVar, "spec");
        socket = sSLSocketFactory.createSocket(socket, str, i, true);
        bVar.c(socket, false);
        i = bVar.f() ? m.a : 0;
        String str6 = j.e().h(socket, str, (bVar.f() ? m.a : 0));
        i = m.a;
        StringBuilder stringBuilder = new StringBuilder();
        final String str5 = "Only ";
        i = " are supported, but negotiated protocol is %s";
        i = str5 + i + i;
        n.x(i.contains(g.get(str6)), (bVar.f() ? m.a : 0), str6);
        if (hostnameVerifier == null) {
            dVar = d.a;
        }
        if (!dVar.verify(m.a(str), socket.getSession())) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str8 = "Cannot verify hostname: ";
            hostnameVerifier = str8 + str;
            throw new SSLPeerUnverifiedException(hostnameVerifier);
        } else {
            return socket;
        }
    }
}
