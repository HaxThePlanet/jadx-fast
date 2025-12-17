package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* loaded from: classes2.dex */
public final class c0 extends io.grpc.z0 {

    private static final long serialVersionUID;
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
        b(io.grpc.c0.a c0$a) {
            super();
        }

        public io.grpc.c0 a() {
            super(this.a, this.b, this.c, this.d, 0);
            return c0Var2;
        }

        public io.grpc.c0.b b(String string) {
            this.d = string;
            return this;
        }

        public io.grpc.c0.b c(SocketAddress socketAddress) {
            n.p(socketAddress, "proxyAddress");
            this.a = (SocketAddress)socketAddress;
            return this;
        }

        public io.grpc.c0.b d(InetSocketAddress inetSocketAddress) {
            n.p(inetSocketAddress, "targetAddress");
            this.b = (InetSocketAddress)inetSocketAddress;
            return this;
        }

        public io.grpc.c0.b e(String string) {
            this.c = string;
            return this;
        }
    }
    private c0(SocketAddress socketAddress, InetSocketAddress inetSocketAddress2, String string3, String string4) {
        boolean z;
        String str;
        super();
        n.p(socketAddress, "proxyAddress");
        n.p(inetSocketAddress2, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            n.x(unresolved ^= 1, "The proxy address %s is not resolved", socketAddress);
        }
        this.proxyAddress = socketAddress;
        this.targetAddress = inetSocketAddress2;
        this.username = string3;
        this.password = string4;
    }

    c0(SocketAddress socketAddress, InetSocketAddress inetSocketAddress2, String string3, String string4, io.grpc.c0.a c0$a5) {
        super(socketAddress, inetSocketAddress2, string3, string4);
    }

    public static io.grpc.c0.b e() {
        c0.b bVar = new c0.b(0);
        return bVar;
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
        boolean password;
        int i;
        Object targetAddress;
        Object obj4;
        if (!object instanceof c0) {
            return 0;
        }
        if (k.a(this.proxyAddress, object.proxyAddress) && k.a(this.targetAddress, object.targetAddress) && k.a(this.username, object.username) && k.a(this.password, object.password)) {
            if (k.a(this.targetAddress, object.targetAddress)) {
                if (k.a(this.username, object.username)) {
                    if (k.a(this.password, object.password)) {
                        i = 1;
                    }
                }
            }
        }
        return i;
    }

    @Override // io.grpc.z0
    public int hashCode() {
        Object[] arr = new Object[4];
        return k.b(this.proxyAddress, this.targetAddress, this.username, this.password);
    }

    @Override // io.grpc.z0
    public String toString() {
        int i;
        j.b bVar = j.c(this);
        bVar.d("proxyAddr", this.proxyAddress);
        bVar.d("targetAddr", this.targetAddress);
        bVar.d("username", this.username);
        i = this.password != null ? 1 : 0;
        bVar.e("hasPassword", i);
        return bVar.toString();
    }
}
