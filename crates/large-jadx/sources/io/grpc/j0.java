package io.grpc;

import com.google.common.io.BaseEncoding;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class j0 {

    public static final Charset a;
    public static final BaseEncoding b;

    public interface a extends io.grpc.t0.i<T> {
    }
    static {
        j0.a = Charset.forName("US-ASCII");
        j0.b = t0.d;
    }

    public static int a(io.grpc.t0 t0) {
        return t0.g();
    }

    public static <T> io.grpc.t0.f<T> b(String string, io.grpc.j0.a<T> j0$a2) {
        int i;
        boolean charAt;
        int i2;
        if (string != null && !string.isEmpty() && string.charAt(0) == 58) {
            if (!string.isEmpty()) {
                if (string.charAt(i) == 58) {
                    i = 1;
                }
            }
        }
        return t0.f.g(string, i, a2);
    }

    public static io.grpc.t0 c(byte[]... bArrArr) {
        t0 t0Var = new t0(bArrArr);
        return t0Var;
    }

    public static byte[][] d(io.grpc.t0 t0) {
        return t0.p();
    }
}
