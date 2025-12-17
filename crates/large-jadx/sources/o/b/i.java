package o.b;

/* loaded from: classes3.dex */
public class i {

    public static final o.b.h a;
    public static final o.b.h b;

    static class a {
    }

    private static class b implements o.b.h {
        b(o.b.i.a i$a) {
            super();
        }

        @Override // o.b.h
        public boolean a(Object object, Object object2) {
            return 1;
        }
    }

    private static class c implements o.b.h {
        c(o.b.i.a i$a) {
            super();
        }

        @Override // o.b.h
        public boolean a(Object object, Object object2) {
            return obj1 ^= 1;
        }
    }
    static {
        final int i = 0;
        i.b bVar = new i.b(i);
        i.a = bVar;
        i.c cVar = new i.c(i);
        i.b = cVar;
    }
}
