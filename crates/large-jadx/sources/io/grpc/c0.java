package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* compiled from: HttpConnectProxiedSocketAddress.java */
/* loaded from: classes2.dex */
public final class c0 extends z0 {

    private static final long serialVersionUID = 0L;
    private final String password;
    private final SocketAddress proxyAddress;
    private final InetSocketAddress targetAddress;
    private final String username;

    static class a {
    }

    public static final class b {

        private SocketAddress a;
        private InetSocketAddress b;
        private String c;
        private String d;
        /* synthetic */ b(c0.a aVar) {
            this();
        }

        public c0 a() {
            c0 c0Var = new c0(this.a, this.b, this.c, this.d, null);
            return c0Var;
        }

        public c0.b b(String str) {
            this.d = str;
            return this;
        }

        public c0.b c(SocketAddress socketAddress) {
            n.p(socketAddress, "proxyAddress");
            this.a = socketAddress;
            return this;
        }

        public c0.b d(InetSocketAddress inetSocketAddress) {
            n.p(inetSocketAddress, "targetAddress");
            this.b = inetSocketAddress;
            return this;
        }

        public c0.b e(String str) {
            this.c = str;
            return this;
        }

        private b() {
            super();
        }
    }
    /* synthetic */ c0(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2, c0.a aVar) {
        this(socketAddress, inetSocketAddress, str, str2);
    }

    public static c0.b e() {
        return new c0.b(null);
    }

    @Override // io.grpc.z0
    public String a() {
        return this.password;
    }

    @Override // io.grpc.z0
    public SocketAddress b() {
        return this.proxyAddress;
    }

    @Override // io.grpc.z0
    public InetSocketAddress c() {
        return this.targetAddress;
    }

    @Override // io.grpc.z0
    public String d() {
        return this.username;
    }

    @Override // io.grpc.z0
    public boolean equals(Object object) {
        boolean z2 = false;
        z2 = false;
        if (!(object instanceof c0)) {
            return false;
        }
        if (k.a(this.proxyAddress, object.proxyAddress)) {
            if (k.a(this.targetAddress, object.targetAddress)) {
                if (k.a(this.username, object.username)) {
                    if (k.a(this.password, object.password)) {
                        int i = 1;
                    }
                }
            }
        }
        return z2;
    }

    @Override // io.grpc.z0
    public int hashCode() {
        Object[] arr = new Object[4];
        return k.b(this.proxyAddress, this.targetAddress, this.username, this.password);
    }

    @Override // io.grpc.z0
    public String toString() {
        boolean z = true;
        j.b bVar = j.c(this);
        bVar.d("proxyAddr", this.proxyAddress);
        bVar.d("targetAddr", this.targetAddress);
        bVar.d("username", this.username);
        int r1 = this.password != null ? 1 : 0;
        bVar.e("hasPassword", (this.password != null ? 1 : 0));
        return bVar.toString();
    }

    private c0(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        super();
        n.p(socketAddress, "proxyAddress");
        n.p(inetSocketAddress, "targetAddress");
        z = socketAddress instanceof InetSocketAddress;
        if (socketAddress instanceof InetSocketAddress) {
            str = "The proxy address %s is not resolved";
            n.x(!(InetSocketAddress)socketAddress.isUnresolved(), str, socketAddress);
        }
        this.proxyAddress = socketAddress;
        this.targetAddress = inetSocketAddress;
        this.username = str;
        this.password = str2;
    }
}
