package d.h.j;

import java.util.Locale;

/* loaded from: classes.dex */
public final class f {

    public static final d.h.j.e a;
    public static final d.h.j.e b;
    public static final d.h.j.e c;
    public static final d.h.j.e d;

    private interface c {
        public abstract int a(java.lang.CharSequence charSequence, int i2, int i3);
    }

    private static class a implements d.h.j.f.c {

        static final d.h.j.f.a b;
        private final boolean a;
        static {
            f.a aVar = new f.a(1);
            f.a.b = aVar;
        }

        private a(boolean z) {
            super();
            this.a = z;
        }

        @Override // d.h.j.f$c
        public int a(java.lang.CharSequence charSequence, int i2, int i3) {
            int i5;
            boolean z;
            int i4;
            int i;
            int obj6;
            final int i6 = 0;
            i5 = i6;
            while (obj6 < i3 += i2) {
                i4 = f.a(Character.getDirectionality(charSequence.charAt(obj6)));
                i = 1;
                i5 = i;
                obj6++;
            }
            if (i5 != 0) {
                return this.a;
            }
            return 2;
        }
    }

    private static class b implements d.h.j.f.c {

        static final d.h.j.f.b a;
        static {
            f.b bVar = new f.b();
            f.b.a = bVar;
        }

        @Override // d.h.j.f$c
        public int a(java.lang.CharSequence charSequence, int i2, int i3) {
            int i;
            int obj4;
            final int i4 = 2;
            i = i4;
            while (obj4 < i3 += i2) {
                if (i == i4) {
                }
                i = f.b(Character.getDirectionality(charSequence.charAt(obj4)));
                obj4++;
            }
            return i;
        }
    }

    private static abstract class d implements d.h.j.e {

        private final d.h.j.f.c a;
        d(d.h.j.f.c f$c) {
            super();
            this.a = c;
        }

        private boolean c(java.lang.CharSequence charSequence, int i2, int i3) {
            int obj2 = this.a.a(charSequence, i2, i3);
            final int obj3 = 1;
            if (obj2 != null && obj2 != obj3) {
                if (obj2 != obj3) {
                    return b();
                }
                return 0;
            }
            return obj3;
        }

        @Override // d.h.j.e
        public boolean a(java.lang.CharSequence charSequence, int i2, int i3) {
            int i;
            if (charSequence == null) {
            } else {
                if (i2 < 0) {
                } else {
                    if (i3 < 0) {
                    } else {
                        if (length -= i3 < i2) {
                        } else {
                            if (this.a == null) {
                                return b();
                            }
                            return c(charSequence, i2, i3);
                        }
                    }
                }
            }
            IllegalArgumentException obj2 = new IllegalArgumentException();
            throw obj2;
        }

        @Override // d.h.j.e
        protected abstract boolean b();
    }

    private static class e extends d.h.j.f.d {

        private final boolean b;
        e(d.h.j.f.c f$c, boolean z2) {
            super(c);
            this.b = z2;
        }

        @Override // d.h.j.f$d
        protected boolean b() {
            return this.b;
        }
    }

    private static class f extends d.h.j.f.d {

        static final d.h.j.f.f b;
        static {
            f.f fVar = new f.f();
            f.f.b = fVar;
        }

        f() {
            super(0);
        }

        @Override // d.h.j.f$d
        protected boolean b() {
            int i;
            if (g.b(Locale.getDefault()) == 1) {
            } else {
                i = 0;
            }
            return i;
        }
    }
    static {
        int i = 0;
        final int i2 = 0;
        f.e eVar = new f.e(i, i2);
        f.a = eVar;
        final int i3 = 1;
        f.e eVar2 = new f.e(i, i3);
        f.b = eVar2;
        d.h.j.f.b bVar = f.b.a;
        f.e eVar3 = new f.e(bVar, i2);
        f.c = eVar3;
        f.e eVar4 = new f.e(bVar, i3);
        f.d = eVar4;
        d.h.j.f.a aVar = f.a.b;
        d.h.j.f.f fVar = f.f.b;
    }

    static int a(int i) {
        int i2;
        i2 = 1;
        i2 = 2;
        if (i != 0 && i != i2 && i != i2) {
            if (i != i2) {
                i2 = 2;
                if (i != i2) {
                    return i2;
                }
            }
            return 0;
        }
        return i2;
    }

    static int b(int i) {
        int i2;
        final int i3 = 1;
        i2 = 2;
        if (i != 0 && i != i3 && i != i2) {
            if (i != i3) {
                i2 = 2;
                if (i != i2) {
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
    }
}
