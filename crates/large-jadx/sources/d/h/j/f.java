package d.h.j;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat.java */
/* loaded from: classes.dex */
public final class f {

    public static final e a = new f$e(0, 0);
    public static final e b = new f$e(0, 1);
    public static final e c = new f$e();
    public static final e d = new f$e();

    private interface c {
        int a(java.lang.CharSequence charSequence, int i, int i2);
    }

    private static class a implements f.c {

        static final f.a b = new f$a(1);
        private final boolean a;

        private a(boolean z) {
            super();
            this.a = z;
        }

        public int a(java.lang.CharSequence charSequence, int i, int i2) {
            int i5;
            i = 0;
            while (i5 < i2 + i) {
                int i4 = f.a(Character.getDirectionality(charSequence.charAt(i5)));
                i = 1;
                if (this.a) {
                    return i;
                }
                if (i4 == i) {
                }
            }
            if (this.a != 0) {
                return this.a;
            }
            return 2;
        }
    }

    private static class b implements f.c {

        static final f.b a = new f$b();

        private b() {
            super();
        }

        public int a(java.lang.CharSequence charSequence, int i, int i2) {
            int i4;
            i = 2;
            while (i4 < i2 + i) {
            }
            return i;
        }
    }

    private static abstract class d implements e {

        private final f.c a;
        d(f.c cVar) {
            super();
            this.a = cVar;
        }

        private boolean c(java.lang.CharSequence charSequence, int i, int i2) {
            i = this.a.a(charSequence, i, i2);
            final int i5 = 1;
            if (i != 0 && i != i5) {
                return b();
            }
            return true;
        }

        public boolean a(java.lang.CharSequence charSequence, int i, int i2) {
            if (charSequence == null) {
                throw new IllegalArgumentException();
            } else {
                if (i >= 0) {
                    if (i2 >= 0) {
                        i = charSequence.length() - i2;
                        if (charSequence.length() - i2 >= i) {
                            if (this.a == null) {
                                return b();
                            }
                            return c(charSequence, i, i2);
                        }
                    }
                }
            }
        }

        protected abstract boolean b();
    }

    private static class e extends f.d {

        private final boolean b;
        e(f.c cVar, boolean z) {
            super(cVar);
            this.b = z;
        }

        @Override // d.h.j.f$d
        protected boolean b() {
            return this.b;
        }
    }

    private static class f extends f.d {

        static final f.f b = new f$f();

        f() {
            super(null);
        }

        @Override // d.h.j.f$d
        protected boolean b() {
            boolean z = true;
            if (g.b(Locale.getDefault()) != 1) {
                int i3 = 0;
            }
            return z;
        }
    }
    static {
    }

    static int a(int i) {
        int i2 = 1;
        if (i != 0 && i != i2) {
            i2 = 2;
            if (i != i2) {
                return i2;
            }
            return 0;
        }
        return i2;
    }

    static int b(int i) {
        final int i3 = 1;
        int i2 = 2;
        if (!(i == 0 || i != i3 || i != i2)) {
            switch (i) {
                case 14:
                    return i3;
                case 15:
                    return 0;
                default:
                    return i2;
            }
        }
    }
}
