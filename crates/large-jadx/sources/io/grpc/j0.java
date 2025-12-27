package io.grpc;

import com.google.common.io.BaseEncoding;
import java.nio.charset.Charset;

/* compiled from: InternalMetadata.java */
/* loaded from: classes2.dex */
public final class j0 {

    public static final Charset a;
    public static final BaseEncoding b;

    public interface a<T> extends t0.i<T> {
    }
    static {
        j0.a = Charset.forName("US-ASCII");
        j0.b = t0.d;
    }

    public static int a(t0 t0Var) {
        return t0Var.g();
    }

    public static <T> t0.f<T> b(String str, j0.a<T> aVar) {
        boolean z = false;
        if (str != null && !str.isEmpty()) {
            char c = ':';
            if (str.charAt(0) == ':') {
                int i2 = 1;
            }
        }
        return t0.f.g(str, z, aVar);
    }

    public static t0 c(byte[]... bArrArr) {
        return new t0(bArrArr);
    }

    public static byte[][] d(t0 t0Var) {
        return t0Var.p();
    }
}
