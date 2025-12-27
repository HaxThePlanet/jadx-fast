package o.b;

/* compiled from: Filters.java */
/* loaded from: classes3.dex */
public class i {

    public static final h a = new i$b(0);
    public static final h b = new i$c(0);

    static class a {
    }

    private static class b implements h {
        private b() {
            super();
        }

        /* synthetic */ b(i.a aVar) {
            this();
        }

        public boolean a(Object object, Object object2) {
            return true;
        }
    }

    private static class c implements h {
        private c() {
            super();
        }

        public boolean a(Object object, Object object2) {
            return !object.equals(object2);
        }

        /* synthetic */ c(i.a aVar) {
            this();
        }
    }
}
