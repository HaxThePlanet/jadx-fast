package io.grpc.j1;

import com.google.common.base.n;
import com.google.common.base.q;
import io.grpc.k0;
import io.grpc.v0;
import io.grpc.v0.b;
import io.grpc.w0;
import java.net.URI;

/* compiled from: DnsNameResolverProvider.java */
/* loaded from: classes3.dex */
public final class d0 extends w0 {
    @Override // io.grpc.w0
    public c0 f(URI uri, v0.b bVar) {
        if ("dns".equals(uri.getScheme())) {
            String path = uri.getPath();
            n.p(path, "targetPath");
            n.l(path.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", path, uri);
            c0 c0Var = new c0(uri.getAuthority(), path.substring(1), bVar, r0.n, q.c(), k0.a(d0.class.getClassLoader()));
            return c0Var;
        }
        return null;
    }

    @Override // io.grpc.w0
    public String a() {
        return "dns";
    }

    @Override // io.grpc.w0
    protected boolean d() {
        return true;
    }

    @Override // io.grpc.w0
    public int e() {
        return 5;
    }
}
