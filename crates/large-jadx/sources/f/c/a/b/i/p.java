package f.c.a.b.i;

import android.util.Base64;
import f.c.a.b.d;

/* loaded from: classes.dex */
public abstract class p {

    public static abstract class a {
        public abstract f.c.a.b.i.p a();

        public abstract f.c.a.b.i.p.a b(String string);

        public abstract f.c.a.b.i.p.a c(byte[] bArr);

        public abstract f.c.a.b.i.p.a d(d d);
    }
    public static f.c.a.b.i.p.a a() {
        e.b bVar = new e.b();
        bVar.d(d.DEFAULT);
        return bVar;
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract d d();

    public boolean e() {
        int i;
        i = c() != null ? 1 : 0;
        return i;
    }

    public f.c.a.b.i.p f(d d) {
        final f.c.a.b.i.p.a aVar = p.a();
        aVar.b(b());
        aVar.d(d);
        aVar.c(c());
        return aVar.a();
    }

    public final String toString() {
        String encodeToString;
        Object[] arr = new Object[3];
        int i4 = 2;
        if (c() == null) {
            encodeToString = "";
        } else {
            encodeToString = Base64.encodeToString(c(), i4);
        }
        arr[i4] = encodeToString;
        return String.format("TransportContext(%s, %s, %s)", arr);
    }
}
