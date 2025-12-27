package l;

import kotlin.d0.d.n;
import kotlin.k0.d;

/* compiled from: -Platform.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final byte[] a(String str) throws java.io.UnsupportedEncodingException {
        n.f(str, "$this$asUtf8ToByteArray");
        final byte[] bytes = str.getBytes(Charsets.a);
        n.e(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] bArr) throws java.io.UnsupportedEncodingException {
        n.f(bArr, "$this$toUtf8String");
        return new String(bArr, Charsets.a);
    }
}
