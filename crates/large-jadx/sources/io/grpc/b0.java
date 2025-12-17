package io.grpc;

import java.net.SocketAddress;
import javax.net.ssl.SSLSession;

/* loaded from: classes2.dex */
public final class b0 {

    public static final io.grpc.a.c<SocketAddress> a;
    public static final io.grpc.a.c<SocketAddress> b;
    public static final io.grpc.a.c<SSLSession> c;
    static {
        b0.a = a.c.a("remote-addr");
        b0.b = a.c.a("local-addr");
        b0.c = a.c.a("ssl-session");
    }
}
