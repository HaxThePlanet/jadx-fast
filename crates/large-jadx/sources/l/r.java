package l;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
final class r {

    private static final Logger a;
    static {
        r.a = Logger.getLogger("okio.Okio");
    }

    public static final /* synthetic */ Logger a() {
        return r.a;
    }

    public static final b0 b(File file) throws java.io.FileNotFoundException {
        n.f(file, "$this$appendingSink");
        return q.h(new FileOutputStream(file, true));
    }

    public static final boolean c(java.lang.AssertionError th) {
        Throwable cause;
        boolean z = false;
        Object obj = null;
        String str;
        n.f(th, "$this$isAndroidGetsocknameError");
        z = false;
        if (th.getCause() != null && message != null) {
            obj = null;
            str = "getsockname failed";
            z = v.R(message, str, z, 2, obj);
            if (z) {
                int i2 = 1;
            }
        }
        return z;
    }

    public static final b0 d(File file, boolean z) throws java.io.FileNotFoundException {
        n.f(file, "$this$sink");
        return q.h(new FileOutputStream(file, z));
    }

    public static final b0 e(OutputStream outputStream) {
        n.f(outputStream, "$this$sink");
        return new u(outputStream, new e0());
    }

    public static final b0 f(Socket socket) throws java.io.IOException {
        n.f(socket, "$this$sink");
        l.c0 c0Var = new c0(socket);
        OutputStream outputStream = socket.getOutputStream();
        n.e(outputStream, "getOutputStream()");
        return c0Var.sink(new u(outputStream, c0Var));
    }

    public static /* synthetic */ b0 g(File file, boolean z, int i, Object object) {
        if (i & 1 != 0) {
            i = 0;
        }
        return q.g(file, z);
    }

    public static final d0 h(File file) throws java.io.FileNotFoundException {
        n.f(file, "$this$source");
        return q.l(new FileInputStream(file));
    }

    public static final d0 i(InputStream inputStream) {
        n.f(inputStream, "$this$source");
        return new p(inputStream, new e0());
    }

    public static final d0 j(Socket socket) throws java.io.IOException {
        n.f(socket, "$this$source");
        l.c0 c0Var = new c0(socket);
        InputStream inputStream = socket.getInputStream();
        n.e(inputStream, "getInputStream()");
        return c0Var.source(new p(inputStream, c0Var));
    }
}
