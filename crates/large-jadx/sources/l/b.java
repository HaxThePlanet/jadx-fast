package l;

import kotlin.d0.d.n;
import kotlin.k0.d;

/* loaded from: classes3.dex */
public final class b {
    public static final byte[] a(String string) {
        n.f(string, "$this$asUtf8ToByteArray");
        final byte[] obj1 = string.getBytes(d.a);
        n.e(obj1, "(this as java.lang.String).getBytes(charset)");
        return obj1;
    }

    public static final String b(byte[] bArr) {
        n.f(bArr, "$this$toUtf8String");
        String string = new String(bArr, d.a);
        return string;
    }
}
