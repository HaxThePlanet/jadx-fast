package l;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: classes3.dex */
public final class q {
    public static final b0 a(File file) {
        return r.b(file);
    }

    public static final b0 b() {
        return s.a();
    }

    public static final g c(b0 b0Var) {
        return s.b(b0Var);
    }

    public static final h d(d0 d0Var) {
        return s.c(d0Var);
    }

    public static final boolean e(java.lang.AssertionError th) {
        return r.c(th);
    }

    public static final b0 g(File file, boolean z) {
        return r.d(file, z);
    }

    public static final b0 h(OutputStream outputStream) {
        return r.e(outputStream);
    }

    public static final b0 i(Socket socket) {
        return r.f(socket);
    }

    public static /* synthetic */ b0 j(File file, boolean z, int i, Object object) {
        return r.g(file, z, i, object);
    }

    public static final d0 k(File file) {
        return r.h(file);
    }

    public static final d0 l(InputStream inputStream) {
        return r.i(inputStream);
    }

    public static final d0 m(Socket socket) {
        return r.j(socket);
    }

    public static final b0 f(File file) {
        return r.g(file, 0, 1, 0);
    }
}
