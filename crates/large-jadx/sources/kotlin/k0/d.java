package kotlin.k0;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lkotlin/text/Charsets;", "", "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class d {

    public static final Charset a;
    private static Charset b;
    private static Charset c;
    public static final kotlin.k0.d d;
    static {
        d dVar = new d();
        d.d = dVar;
        Charset forName = Charset.forName("UTF-8");
        n.e(forName, "Charset.forName(\"UTF-8\")");
        d.a = forName;
        n.e(Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        n.e(Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        n.e(Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        n.e(Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        n.e(Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }

    public final Charset a() {
        Charset forName;
        String str;
        if (d.c != null) {
        } else {
            forName = Charset.forName("UTF-32BE");
            n.e(forName, "Charset.forName(\"UTF-32BE\")");
            d.c = forName;
        }
        return forName;
    }

    public final Charset b() {
        Charset forName;
        String str;
        if (d.b != null) {
        } else {
            forName = Charset.forName("UTF-32LE");
            n.e(forName, "Charset.forName(\"UTF-32LE\")");
            d.b = forName;
        }
        return forName;
    }
}
