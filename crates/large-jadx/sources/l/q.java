package l;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: classes3.dex */
public final class q {
    public static final l.b0 a(File file) {
        return r.b(file);
    }

    public static final l.b0 b() {
        return s.a();
    }

    public static final l.g c(l.b0 b0) {
        return s.b(b0);
    }

    public static final l.h d(l.d0 d0) {
        return s.c(d0);
    }

    public static final boolean e(java.lang.AssertionError assertionError) {
        return r.c(assertionError);
    }

    public static final l.b0 f(File file) {
        return q.j(file, false, 1, 0);
    }

    public static final l.b0 g(File file, boolean z2) {
        return r.d(file, z2);
    }

    public static final l.b0 h(OutputStream outputStream) {
        return r.e(outputStream);
    }

    public static final l.b0 i(Socket socket) {
        return r.f(socket);
    }

    public static l.b0 j(File file, boolean z2, int i3, Object object4) {
        return r.g(file, z2, i3, object4);
    }

    public static final l.d0 k(File file) {
        return r.h(file);
    }

    public static final l.d0 l(InputStream inputStream) {
        return r.i(inputStream);
    }

    public static final l.d0 m(Socket socket) {
        return r.j(socket);
    }
}
