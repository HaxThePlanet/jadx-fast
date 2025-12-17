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

/* loaded from: classes3.dex */
final class r {

    private static final Logger a;
    static {
        r.a = Logger.getLogger("okio.Okio");
    }

    public static final Logger a() {
        return r.a;
    }

    public static final l.b0 b(File file) {
        n.f(file, "$this$appendingSink");
        FileOutputStream fileOutputStream = new FileOutputStream(file, 1);
        return q.h(fileOutputStream);
    }

    public static final boolean c(java.lang.AssertionError assertionError) {
        Throwable cause;
        int i;
        int i2;
        String str;
        int obj4;
        n.f(assertionError, "$this$isAndroidGetsocknameError");
        i = 0;
        if (assertionError.getCause() != null) {
            obj4 = assertionError.getMessage();
            if (obj4 != null) {
                obj4 = l.R(obj4, "getsockname failed", i, 2, 0);
            } else {
                obj4 = i;
            }
            if (obj4 != null) {
                i = 1;
            }
        }
        return i;
    }

    public static final l.b0 d(File file, boolean z2) {
        n.f(file, "$this$sink");
        FileOutputStream fileOutputStream = new FileOutputStream(file, z2);
        return q.h(fileOutputStream);
    }

    public static final l.b0 e(OutputStream outputStream) {
        n.f(outputStream, "$this$sink");
        e0 e0Var = new e0();
        u uVar = new u(outputStream, e0Var);
        return uVar;
    }

    public static final l.b0 f(Socket socket) {
        n.f(socket, "$this$sink");
        c0 c0Var = new c0(socket);
        OutputStream obj3 = socket.getOutputStream();
        n.e(obj3, "getOutputStream()");
        u uVar = new u(obj3, c0Var);
        return c0Var.sink(uVar);
    }

    public static l.b0 g(File file, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return q.g(file, obj1);
    }

    public static final l.d0 h(File file) {
        n.f(file, "$this$source");
        FileInputStream fileInputStream = new FileInputStream(file);
        return q.l(fileInputStream);
    }

    public static final l.d0 i(InputStream inputStream) {
        n.f(inputStream, "$this$source");
        e0 e0Var = new e0();
        p pVar = new p(inputStream, e0Var);
        return pVar;
    }

    public static final l.d0 j(Socket socket) {
        n.f(socket, "$this$source");
        c0 c0Var = new c0(socket);
        InputStream obj3 = socket.getInputStream();
        n.e(obj3, "getInputStream()");
        p pVar = new p(obj3, c0Var);
        return c0Var.source(pVar);
    }
}
