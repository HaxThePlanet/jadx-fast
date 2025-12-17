package f.c.a.b.i;

import f.c.a.b.b;
import f.c.a.b.e;
import f.c.a.b.f;
import f.c.a.b.g;
import java.util.Set;

/* loaded from: classes.dex */
final class q implements g {

    private final Set<b> a;
    private final f.c.a.b.i.p b;
    private final f.c.a.b.i.s c;
    q(Set<b> set, f.c.a.b.i.p p2, f.c.a.b.i.s s3) {
        super();
        this.a = set;
        this.b = p2;
        this.c = s3;
    }

    public <T> f<T> a(String string, Class<T> class2, e<T, byte[]> e3) {
        return b(string, class2, b.b("proto"), e3);
    }

    public <T> f<T> b(String string, Class<T> class2, b b3, e<T, byte[]> e4) {
        if (!this.a.contains(b3)) {
        } else {
            super(this.b, string, b3, e4, this.c);
            return obj8;
        }
        Object[] obj8 = new Object[2];
        IllegalArgumentException obj7 = new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", b3, this.a));
        throw obj7;
    }
}
