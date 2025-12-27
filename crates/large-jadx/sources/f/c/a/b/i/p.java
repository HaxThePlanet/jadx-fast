package f.c.a.b.i;

import android.util.Base64;
import f.c.a.b.d;

/* compiled from: TransportContext.java */
/* loaded from: classes.dex */
public abstract class p {

    public static abstract class a {
        public abstract p a();

        public abstract p.a b(String str);

        public abstract p.a c(byte[] bArr);

        public abstract p.a d(d dVar);
    }
    public static p.a a() {
        final f.c.a.b.i.e.b bVar = new e.b();
        bVar.d(d.DEFAULT);
        return bVar;
    }

    public boolean e() {
        boolean z = true;
        int r0 = c() != null ? 1 : 0;
        return (c() != null ? 1 : 0);
    }

    public p f(d dVar) {
        final f.c.a.b.i.p.a aVar = p.a();
        aVar.b(b());
        aVar.d(dVar);
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
        return String.format("TransportContext(%s, %s, %s)", new Object[] { b(), d(), encodeToString });
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract d d();
}
