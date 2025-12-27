package net.time4j.h1;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.time4j.g1.k;
import net.time4j.g1.n;
import net.time4j.g1.o;
import net.time4j.g1.p;

/* compiled from: DefaultPluralProviderSPI.java */
/* loaded from: classes3.dex */
public final class a implements o {

    private static final Map<String, p> a = new HashMap<>(140);
    private static final p b = new a$b(0, 0);
    private static final Map<String, p> c = new HashMap<>(140);
    private static final p d = new a$c(0, 0);

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[k.values().length];
            a.a.a = iArr;
            try {
                iArr[k.CARDINALS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[k.ORDINALS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private static class b extends p {

        private final int g;
        /* synthetic */ b(int i, a.a aVar) {
            this(i);
        }

        @Override // net.time4j.g1.p
        public n e(long j) {
            n oNE2;
            n oNE22;
            n oTHER2;
            int f;
            int cmp28;
            int i = 13;
            final long l21 = 5L;
            long l25 = 99L;
            long l28 = 6L;
            i = 13;
            final long l36 = 14L;
            final long l37 = 9L;
            final long l38 = 12L;
            final long l39 = 19L;
            final long l40 = 4L;
            final long l41 = 3L;
            final long l42 = 11L;
            final long l43 = 100L;
            final long l44 = 0L;
            final long l45 = 10L;
            final long l46 = 2L;
            final long l47 = 1L;
            switch (this.g) {
                case 0:
                    oNE2 = n.ONE;
                    oNE2 = n.OTHER;
                    return oNE2;
                case 1:
                    oNE22 = n.OTHER;
                    oNE22 = n.ONE;
                    return oNE22;
                case 2:
                    return n.OTHER;
                case 3:
                    long l17 = j % l45;
                    long l18 = j % l43;
                    return n.ONE;
                case 4:
                    long l19 = j % l45;
                    long l20 = j % l43;
                    oTHER2 = n.ONE;
                    oTHER2 = n.OTHER;
                    return oTHER2;
                case 5:
                    return n.ONE;
                case 6:
                    long l15 = j % l45;
                    return n.ZERO;
                case 7:
                    return n.ZERO;
                case 8:
                    return n.ONE;
                case 9:
                    return n.FEW;
                case 10:
                    return n.ONE;
                case 11:
                    l = j % l43;
                    l11 = j % l45;
                    return n.ONE;
                case 12:
                    return n.FEW;
                case 13:
                    l10 = j % l43;
                    return n.ONE;
                case 14:
                    return n.ONE;
                case 15:
                    return n.ONE;
                case 16:
                    return n.ONE;
                case 17:
                    long l27 = j % l45;
                    long l31 = j % l43;
                    return n.ONE;
                case 18:
                    l3 = j % l45;
                    long l22 = j % l43;
                    return n.ONE;
                case 19:
                    return n.ONE;
                case 20:
                    l6 = j % l45;
                    long l30 = j % l43;
                    long l34 = 71L;
                    long l35 = 91L;
                    return n.ONE;
                case 21:
                    return n.ONE;
                case 22:
                    long l14 = j % l45;
                    long l23 = j % l43;
                    return n.ONE;
                case 23:
                    return n.ZERO;
                case 24:
                    return n.ZERO;
                case 25:
                    l8 = j % l43;
                    return n.ONE;
                case 26:
                    return n.ZERO;
                default:
                    return n.OTHER;
            }
        }

        private b(int i) {
            super();
            this.g = i;
        }
    }

    private static class c extends p {

        private final int g;
        /* synthetic */ c(int i, a.a aVar) {
            this(i);
        }

        @Override // net.time4j.g1.p
        public n e(long j) {
            int i;
            final long l13 = 60L;
            long l7 = 20L;
            final long l19 = 40L;
            long l20 = 800L;
            final long l22 = 80L;
            long l23 = 13L;
            long l25 = 9L;
            final long l27 = 8L;
            long l28 = 12L;
            final long l30 = 7L;
            final long l31 = 11L;
            final long l32 = 0L;
            final long l33 = 5L;
            final long l34 = 6L;
            final long l35 = 4L;
            final long l36 = 100L;
            final long l37 = 3L;
            final long l38 = 10L;
            final long l39 = 2L;
            final long l40 = 1L;
            switch (this.g) {
                case 0:
                    return n.OTHER;
                case 1:
                    l3 = j % l38;
                    long l14 = j % l36;
                    return n.ONE;
                case 2:
                    return n.ONE;
                case 3:
                    return n.OTHER;
                case 4:
                    return n.ONE;
                case 5:
                    l = j % l38;
                    return n.OTHER;
                case 6:
                    return n.OTHER;
                case 7:
                    long l21 = j % l36;
                    return n.ONE;
                case 8:
                    return n.ONE;
                case 9:
                    long l8 = j % l38;
                    long l15 = j % l36;
                    return n.ONE;
                case 10:
                    return n.ONE;
                case 11:
                    return n.TWO;
                case 12:
                    l4 = j % l38;
                    long l16 = j % l36;
                    return n.ONE;
                case 13:
                    long l24 = j % l38;
                    long l26 = j % l36;
                    long l29 = j % 1000L;
                    l7 = 50L;
                    l7 = 70L;
                    l7 = 200L;
                    l7 = 300L;
                    l7 = 400L;
                    l7 = 500L;
                    l7 = 600L;
                    l7 = 700L;
                    l7 = 900L;
                    return n.OTHER;
                case 14:
                    return n.ONE;
                case 15:
                    return n.FEW;
                case 16:
                    return n.ONE;
                case 17:
                    l5 = j % l38;
                    long l17 = j % l36;
                    return n.FEW;
                case 18:
                    long l12 = j % l38;
                    long l18 = j % l36;
                    return n.FEW;
                case 19:
                    l2 = j % l38;
                    return n.OTHER;
                case 20:
                    return n.FEW;
                case 21:
                    return n.OTHER;
                case 22:
                    long l9 = j % l36;
                    return n.ONE;
                default:
                    return n.OTHER;
            }
        }

        private c(int i) {
            super();
            this.g = i;
        }
    }
    static {
        HashMap hashMap2 = new HashMap();
        int i19 = -1;
        a.b(hashMap2, "bm bo dz id ig ii in ja jbo jv jw kde kea km ko lkt", i19);
        a.b(hashMap2, "lo ms my nqo root sah ses sg th to vi wo yo zh", i19);
        a.b(hashMap2, "pt_PT", 0);
        int i20 = 1;
        a.b(hashMap2, "am as bn fa gu hi kn zu", i20);
        a.b(hashMap2, "ff fr hy kab pt", i20);
        a.b(hashMap2, "si", i20);
        a.b(hashMap2, "ak bh guw ln mg nso pa ti wa", i20);
        final int i21 = 2;
        a.b(hashMap2, "tzm", i21);
        final int i22 = 3;
        a.b(hashMap2, "is", i22);
        String str30 = "mk";
        final int i23 = 4;
        a.b(hashMap2, str30, i23);
        final int i24 = 5;
        a.b(hashMap2, "ceb fil tl", i24);
        final int i25 = 6;
        a.b(hashMap2, "lv prg", i25);
        a.b(hashMap2, "lag ksh", 7);
        a.b(hashMap2, "iu naq se sma smi smj smn sms", 8);
        a.b(hashMap2, "shi", 9);
        a.b(hashMap2, "mo ro", 10);
        a.b(hashMap2, "bs hr sh sr", 11);
        String str38 = "gd";
        a.b(hashMap2, str38, 12);
        a.b(hashMap2, "sl", 13);
        a.b(hashMap2, "he iw", 14);
        a.b(hashMap2, "cs sk", 15);
        a.b(hashMap2, "pl", 16);
        int i45 = 17;
        a.b(hashMap2, "be", i45);
        a.b(hashMap2, "lt", 18);
        a.b(hashMap2, "mt", 19);
        a.b(hashMap2, "ru uk", i45);
        a.b(hashMap2, "br", 20);
        a.b(hashMap2, "ga", 21);
        a.b(hashMap2, "gv", 22);
        a.b(hashMap2, "ar", 23);
        a.b(hashMap2, "cy", 24);
        a.b(hashMap2, "dsb hsb", 25);
        a.b(hashMap2, "kw", 26);
        obj.putAll(hashMap2);
        HashMap hashMap = new HashMap();
        a.c(hashMap, "sv", i20);
        a.c(hashMap, "fil fr ga hy lo mo ms ro tl vi", i21);
        a.c(hashMap, "hu", i22);
        a.c(hashMap, "ne", i23);
        a.c(hashMap, "kk", i24);
        a.c(hashMap, "it sc scn", i25);
        a.c(hashMap, "ka", 7);
        a.c(hashMap, "sq", 8);
        a.c(hashMap, "en", 9);
        a.c(hashMap, "mr", 10);
        a.c(hashMap, "ca", 11);
        a.c(hashMap, str30, 12);
        a.c(hashMap, "az", 13);
        a.c(hashMap, "gu hi", 14);
        a.c(hashMap, "as bn", 15);
        a.c(hashMap, "cy", 16);
        a.c(hashMap, "be", i45);
        a.c(hashMap, "uk", 18);
        a.c(hashMap, "tk", 19);
        a.c(hashMap, "or", 20);
        a.c(hashMap, str38, 21);
        a.c(hashMap, "kw", 22);
        obj.putAll(hashMap);
    }

    private static void b(Map<String, p> map, String str, int i) {
        final String[] parts = str.split(" ");
        i = 0;
        for (String str3 : parts) {
            net.time4j.h1.a.a aVar = null;
            map.put(str3, new a.b(i, aVar));
        }
    }

    private static void c(Map<String, p> map, String str, int i) {
        final String[] parts = str.split(" ");
        i = 0;
        for (String str3 : parts) {
            net.time4j.h1.a.a aVar = null;
            map.put(str3, new a.c(i, aVar));
        }
    }

    public p a(Locale locale, k kVar) {
        p pVar;
        int i2 = 0;
        Map map;
        int i3 = a.a.a[kVar.ordinal()];
        int i = 1;
        if (a.a.a != 1) {
            i = 2;
            if (a.a.a != 2) {
                throw new UnsupportedOperationException(kVar.name());
            } else {
                map = a.c;
                pVar = a.d;
                i2 = 0;
                final String country = locale.getCountry();
                if (!country.isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String language = locale.getLanguage();
                    char c = '_';
                    str = language + c + country;
                    Object value = map.get(str);
                }
                if (i2 == 0) {
                }
                return i2 == 0 ? pVar : i2;
            }
        }
        map = a.a;
        pVar = a.b;
    }
}
