package io.grpc.j1;

import com.google.common.base.n;
import com.google.common.base.q;
import io.grpc.k0;
import io.grpc.v0;
import io.grpc.v0.b;
import io.grpc.w0;
import java.net.URI;

/* loaded from: classes3.dex */
public final class d0 extends w0 {
    @Override // io.grpc.w0
    public String a() {
        return "dns";
    }

    @Override // io.grpc.w0
    public v0 b(URI uRI, v0.b v0$b2) {
        return f(uRI, b2);
    }

    @Override // io.grpc.w0
    protected boolean d() {
        return 1;
    }

    @Override // io.grpc.w0
    public int e() {
        return 5;
    }

    @Override // io.grpc.w0
    public io.grpc.j1.c0 f(URI uRI, v0.b v0$b2) {
        if ("dns".equals(uRI.getScheme())) {
            String path = uRI.getPath();
            n.p(path, "targetPath");
            n.l((String)path.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", path, uRI);
            super(uRI.getAuthority(), path.substring(1), b2, r0.n, q.c(), k0.a(d0.class.getClassLoader()));
            return c0Var;
        }
        return null;
    }
}
