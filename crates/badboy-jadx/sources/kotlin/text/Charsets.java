package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lkotlin/text/Charsets;", "", "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Charsets {

    public static final kotlin.text.Charsets INSTANCE;
    public static final Charset ISO_8859_1;
    public static final Charset US_ASCII;
    public static final Charset UTF_16;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;
    private static volatile Charset utf_32;
    private static volatile Charset utf_32be;
    private static volatile Charset utf_32le;
    static {
        Charsets charsets = new Charsets();
        Charsets.INSTANCE = charsets;
        Charset forName = Charset.forName("UTF-8");
        final String str7 = "forName(...)";
        Intrinsics.checkNotNullExpressionValue(forName, str7);
        Charsets.UTF_8 = forName;
        Charset forName2 = Charset.forName("UTF-16");
        Intrinsics.checkNotNullExpressionValue(forName2, str7);
        Charsets.UTF_16 = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        Intrinsics.checkNotNullExpressionValue(forName3, str7);
        Charsets.UTF_16BE = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        Intrinsics.checkNotNullExpressionValue(forName4, str7);
        Charsets.UTF_16LE = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        Intrinsics.checkNotNullExpressionValue(forName5, str7);
        Charsets.US_ASCII = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        Intrinsics.checkNotNullExpressionValue(forName6, str7);
        Charsets.ISO_8859_1 = forName6;
    }

    public final Charset UTF32() {
        Charset $this$_get_UTF_32__u24lambda_u240;
        int i;
        Charset forName;
        String str;
        if (Charsets.utf_32 == null) {
            kotlin.text.Charsets charsets = this;
            i = 0;
            forName = Charset.forName("UTF-32");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
            Charsets.utf_32 = forName;
            $this$_get_UTF_32__u24lambda_u240 = forName;
        }
        return $this$_get_UTF_32__u24lambda_u240;
    }

    public final Charset UTF32_BE() {
        Charset $this$_get_UTF_32BE__u24lambda_u242;
        int i;
        Charset forName;
        String str;
        if (Charsets.utf_32be == null) {
            kotlin.text.Charsets charsets = this;
            i = 0;
            forName = Charset.forName("UTF-32BE");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
            Charsets.utf_32be = forName;
            $this$_get_UTF_32BE__u24lambda_u242 = forName;
        }
        return $this$_get_UTF_32BE__u24lambda_u242;
    }

    public final Charset UTF32_LE() {
        Charset $this$_get_UTF_32LE__u24lambda_u241;
        int i;
        Charset forName;
        String str;
        if (Charsets.utf_32le == null) {
            kotlin.text.Charsets charsets = this;
            i = 0;
            forName = Charset.forName("UTF-32LE");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
            Charsets.utf_32le = forName;
            $this$_get_UTF_32LE__u24lambda_u241 = forName;
        }
        return $this$_get_UTF_32LE__u24lambda_u241;
    }
}
