package net.time4j.h1;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.time4j.g1.k;
import net.time4j.g1.n;
import net.time4j.g1.o;
import net.time4j.g1.p;

/* loaded from: classes3.dex */
public final class a implements o {

    private static final Map<String, p> a;
    private static final p b;
    private static final Map<String, p> c;
    private static final p d;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            a.a.a = iArr;
            iArr[k.CARDINALS.ordinal()] = 1;
            a.a.a[k.ORDINALS.ordinal()] = 2;
        }
    }

    private static class b extends p {

        private final int g;
        private b(int i) {
            super();
            this.g = i;
        }

        b(int i, net.time4j.h1.a.a a$a2) {
            super(i);
        }

        @Override // net.time4j.g1.p
        public n e(long l) {
            int cmp29;
            n oTHER3;
            int cmp34;
            int cmp28;
            int cmp16;
            int cmp22;
            int cmp6;
            int cmp23;
            int cmp8;
            int cmp24;
            int cmp9;
            n oTHER;
            int cmp3;
            int cmp35;
            int cmp40;
            int cmp39;
            int cmp26;
            int cmp15;
            int cmp7;
            int cmp5;
            int cmp38;
            int cmp27;
            int cmp36;
            int cmp21;
            int cmp30;
            int cmp13;
            int cmp33;
            int cmp11;
            int cmp44;
            int cmp31;
            int cmp25;
            n oTHER2;
            int cmp37;
            int cmp32;
            int f;
            int cmp2;
            int cmp4;
            int cmp20;
            int cmp17;
            int cmp;
            int cmp10;
            int cmp41;
            int cmp42;
            int cmp19;
            int cmp14;
            int cmp12;
            int cmp18;
            int cmp43;
            int i;
            final int i21 = 5;
            int i35 = 99;
            int i38 = 6;
            i = 13;
            final int i42 = 14;
            final int i43 = 9;
            final int i44 = 12;
            final int i45 = 19;
            final int i46 = 4;
            final int i47 = 3;
            final int i48 = 11;
            final int i49 = 100;
            final int i50 = 0;
            final int i51 = 10;
            final int i52 = 2;
            final int i53 = 1;
            switch (i2) {
                case 0:
                    oTHER3 = n.ONE;
                    oTHER3 = n.OTHER;
                    return oTHER3;
                case 1:
                    oTHER = n.OTHER;
                    oTHER = n.ONE;
                    return oTHER;
                case 2:
                    return n.OTHER;
                    return n.ONE;
                case 3:
                    return n.ONE;
                    return n.OTHER;
                case 4:
                    oTHER2 = n.ONE;
                    oTHER2 = n.OTHER;
                    return oTHER2;
                case 5:
                    return n.ONE;
                    cmp9 = l % i51;
                    return n.ONE;
                    return n.OTHER;
                case 6:
                    int i10 = l % i51;
                    return n.ZERO;
                    cmp17 = l % i49;
                    return n.ZERO;
                    return n.ONE;
                    return n.OTHER;
                case 7:
                    return n.ZERO;
                    return n.ONE;
                    return n.OTHER;
                case 8:
                    return n.ONE;
                    return n.TWO;
                    return n.OTHER;
                case 9:
                    return n.FEW;
                    return n.OTHER;
                    return n.ONE;
                case 10:
                    return n.ONE;
                    return n.FEW;
                    cmp27 = l % i49;
                    return n.FEW;
                    return n.OTHER;
                case 11:
                    cmp29 = l % i49;
                    cmp2 = l % i51;
                    return n.ONE;
                    return n.FEW;
                    return n.OTHER;
                case 12:
                    return n.FEW;
                    return n.OTHER;
                    return n.TWO;
                    return n.ONE;
                case 13:
                    cmp32 = l % i49;
                    return n.ONE;
                    return n.TWO;
                    return n.OTHER;
                    return n.FEW;
                case 14:
                    return n.ONE;
                    return n.TWO;
                    return n.MANY;
                    return n.OTHER;
                case 15:
                    return n.ONE;
                    return n.FEW;
                    return n.OTHER;
                case 16:
                    return n.ONE;
                    int i36 = l % i51;
                    int i39 = l % i49;
                    return n.FEW;
                    return n.MANY;
                    return n.OTHER;
                case 17:
                    int i37 = l % i51;
                    int i41 = l % i49;
                    return n.ONE;
                    return n.FEW;
                    return n.OTHER;
                    return n.MANY;
                case 18:
                    cmp23 = l % i51;
                    int i22 = l % i49;
                    return n.ONE;
                    return n.FEW;
                    return n.OTHER;
                case 19:
                    return n.ONE;
                    cmp30 = l % i49;
                    return n.MANY;
                    return n.OTHER;
                    return n.FEW;
                case 20:
                    cmp36 = l % i51;
                    int i40 = l % i49;
                    return n.ONE;
                    return n.TWO;
                    return n.MANY;
                    return n.OTHER;
                    return n.FEW;
                case 21:
                    return n.ONE;
                    return n.TWO;
                    return n.FEW;
                    return n.MANY;
                    return n.OTHER;
                case 22:
                    int i5 = l % i51;
                    int i23 = l % i49;
                    return n.ONE;
                    return n.TWO;
                    return n.OTHER;
                    return n.FEW;
                case 23:
                    return n.ZERO;
                    return n.ONE;
                    return n.TWO;
                    cmp34 = l % i49;
                    return n.FEW;
                    return n.MANY;
                    return n.OTHER;
                case 24:
                    return n.ZERO;
                    return n.ONE;
                    return n.TWO;
                    return n.FEW;
                    return n.MANY;
                    return n.OTHER;
                case 25:
                    cmp31 = l % i49;
                    return n.ONE;
                    return n.TWO;
                    return n.OTHER;
                    return n.FEW;
                case 26:
                    return n.ZERO;
                    return n.ONE;
                    cmp25 = l % i49;
                    return n.OTHER;
                    return n.MANY;
                    return n.FEW;
                    return n.TWO;
                default:
                    return n.OTHER;
            }
        }
    }

    private static class c extends p {

        private final int g;
        private c(int i) {
            super();
            this.g = i;
        }

        c(int i, net.time4j.h1.a.a a$a2) {
            super(i);
        }

        @Override // net.time4j.g1.p
        public n e(long l) {
            int cmp22;
            int cmp30;
            int cmp6;
            int cmp5;
            int cmp31;
            int cmp11;
            int cmp18;
            int cmp35;
            int cmp28;
            int cmp25;
            int cmp27;
            int cmp10;
            int cmp14;
            int cmp29;
            int cmp19;
            int cmp32;
            int cmp21;
            int cmp33;
            int cmp3;
            int cmp15;
            int cmp16;
            int cmp13;
            int cmp34;
            int cmp23;
            int cmp26;
            int cmp17;
            int cmp8;
            int cmp4;
            int i;
            int cmp2;
            int cmp;
            int cmp12;
            int i3;
            int cmp7;
            int cmp9;
            int cmp20;
            int cmp24;
            final int i13 = 60;
            i3 = 20;
            final int i27 = 40;
            int i28 = 800;
            final int i30 = 80;
            int i31 = 13;
            int i33 = 9;
            final int i35 = 8;
            int i36 = 12;
            final int i39 = 7;
            final int i40 = 11;
            final int i41 = 0;
            final int i42 = 5;
            final int i43 = 6;
            final int i44 = 4;
            final int i45 = 100;
            final int i46 = 3;
            final int i47 = 10;
            final int i48 = 2;
            final int i49 = 1;
            switch (i4) {
                case 0:
                    return n.OTHER;
                case 1:
                    cmp5 = l % i47;
                    int i14 = l % i45;
                    return n.ONE;
                    return n.OTHER;
                case 2:
                    return n.ONE;
                    return n.OTHER;
                case 3:
                    return n.OTHER;
                    return n.ONE;
                case 4:
                    return n.ONE;
                    return n.OTHER;
                case 5:
                    cmp22 = l % i47;
                    return n.OTHER;
                    return n.MANY;
                case 6:
                    return n.OTHER;
                    return n.MANY;
                case 7:
                    int i29 = l % i45;
                    return n.ONE;
                    return n.OTHER;
                    return n.MANY;
                case 8:
                    return n.ONE;
                    return n.MANY;
                    return n.OTHER;
                case 9:
                    int i5 = l % i47;
                    int i15 = l % i45;
                    return n.ONE;
                    return n.TWO;
                    return n.FEW;
                    return n.OTHER;
                case 10:
                    return n.ONE;
                    return n.FEW;
                    return n.OTHER;
                    return n.TWO;
                case 11:
                    return n.TWO;
                    return n.FEW;
                    return n.OTHER;
                    return n.ONE;
                case 12:
                    cmp27 = l % i47;
                    int i16 = l % i45;
                    return n.ONE;
                    return n.TWO;
                    return n.MANY;
                    return n.OTHER;
                case 13:
                    int i32 = l % i47;
                    int i34 = l % i45;
                    int i38 = l % i37;
                    return n.OTHER;
                    return n.MANY;
                    return n.FEW;
                    return n.ONE;
                case 14:
                    return n.ONE;
                    return n.FEW;
                    return n.MANY;
                    return n.OTHER;
                    return n.TWO;
                case 15:
                    return n.FEW;
                    return n.MANY;
                    return n.OTHER;
                    return n.TWO;
                    return n.ONE;
                case 16:
                    return n.ONE;
                    return n.TWO;
                    return n.OTHER;
                    return n.MANY;
                    return n.FEW;
                    return n.ZERO;
                case 17:
                    cmp3 = l % i47;
                    int i17 = l % i45;
                    return n.FEW;
                    return n.OTHER;
                case 18:
                    return n.FEW;
                    return n.OTHER;
                case 19:
                    cmp6 = l % i47;
                    return n.OTHER;
                    return n.FEW;
                case 20:
                    return n.FEW;
                    return n.MANY;
                    return n.OTHER;
                    return n.TWO;
                    return n.ONE;
                case 21:
                    return n.OTHER;
                    return n.FEW;
                    return n.TWO;
                    return n.ONE;
                case 22:
                    int i9 = l % i45;
                    return n.ONE;
                    return n.MANY;
                    return n.OTHER;
                default:
                    return n.OTHER;
            }
        }
    }
    static {
        int i = 140;
        HashMap hashMap = new HashMap(i);
        a.a = hashMap;
        int i4 = 0;
        final int i18 = 0;
        a.b bVar = new a.b(i4, i18);
        a.b = bVar;
        HashMap hashMap4 = new HashMap();
        int i19 = -1;
        a.b(hashMap4, "bm bo dz id ig ii in ja jbo jv jw kde kea km ko lkt", i19);
        a.b(hashMap4, "lo ms my nqo root sah ses sg th to vi wo yo zh", i19);
        a.b(hashMap4, "pt_PT", i4);
        int i20 = 1;
        a.b(hashMap4, "am as bn fa gu hi kn zu", i20);
        a.b(hashMap4, "ff fr hy kab pt", i20);
        a.b(hashMap4, "si", i20);
        a.b(hashMap4, "ak bh guw ln mg nso pa ti wa", i20);
        final int i21 = 2;
        a.b(hashMap4, "tzm", i21);
        final int i22 = 3;
        a.b(hashMap4, "is", i22);
        String str30 = "mk";
        final int i23 = 4;
        a.b(hashMap4, str30, i23);
        final int i24 = 5;
        a.b(hashMap4, "ceb fil tl", i24);
        final int i25 = 6;
        a.b(hashMap4, "lv prg", i25);
        a.b(hashMap4, "lag ksh", 7);
        a.b(hashMap4, "iu naq se sma smi smj smn sms", 8);
        a.b(hashMap4, "shi", 9);
        a.b(hashMap4, "mo ro", 10);
        a.b(hashMap4, "bs hr sh sr", 11);
        String str38 = "gd";
        a.b(hashMap4, str38, 12);
        a.b(hashMap4, "sl", 13);
        a.b(hashMap4, "he iw", 14);
        a.b(hashMap4, "cs sk", 15);
        a.b(hashMap4, "pl", 16);
        int i45 = 17;
        a.b(hashMap4, "be", i45);
        a.b(hashMap4, "lt", 18);
        a.b(hashMap4, "mt", 19);
        a.b(hashMap4, "ru uk", i45);
        a.b(hashMap4, "br", 20);
        a.b(hashMap4, "ga", 21);
        a.b(hashMap4, "gv", 22);
        a.b(hashMap4, "ar", 23);
        a.b(hashMap4, "cy", 24);
        a.b(hashMap4, "dsb hsb", 25);
        a.b(hashMap4, "kw", 26);
        hashMap.putAll(hashMap4);
        HashMap hashMap2 = new HashMap(i);
        a.c = hashMap2;
        a.c cVar = new a.c(i4, i18);
        a.d = cVar;
        HashMap hashMap3 = new HashMap();
        a.c(hashMap3, "sv", i20);
        a.c(hashMap3, "fil fr ga hy lo mo ms ro tl vi", i21);
        a.c(hashMap3, "hu", i22);
        a.c(hashMap3, "ne", i23);
        a.c(hashMap3, "kk", i24);
        a.c(hashMap3, "it sc scn", i25);
        a.c(hashMap3, "ka", 7);
        a.c(hashMap3, "sq", 8);
        a.c(hashMap3, "en", 9);
        a.c(hashMap3, "mr", 10);
        a.c(hashMap3, "ca", 11);
        a.c(hashMap3, str30, 12);
        a.c(hashMap3, "az", 13);
        a.c(hashMap3, "gu hi", 14);
        a.c(hashMap3, "as bn", 15);
        a.c(hashMap3, "cy", 16);
        a.c(hashMap3, "be", i45);
        a.c(hashMap3, "uk", 18);
        a.c(hashMap3, "tk", 19);
        a.c(hashMap3, "or", 20);
        a.c(hashMap3, str38, 21);
        a.c(hashMap3, "kw", 22);
        hashMap2.putAll(hashMap3);
    }

    private static void b(Map<String, p> map, String string2, int i3) {
        int i;
        String str;
        net.time4j.h1.a.b bVar;
        int i2;
        final String[] obj6 = string2.split(" ");
        i = 0;
        while (i < obj6.length) {
            bVar = new a.b(i3, 0);
            map.put(obj6[i], bVar);
            i++;
        }
    }

    private static void c(Map<String, p> map, String string2, int i3) {
        int i;
        String str;
        net.time4j.h1.a.c cVar;
        int i2;
        final String[] obj6 = string2.split(" ");
        i = 0;
        while (i < obj6.length) {
            cVar = new a.c(i3, 0);
            map.put(obj6[i], cVar);
            i++;
        }
    }

    @Override // net.time4j.g1.o
    public p a(Locale locale, k k2) {
        p pVar;
        int i2;
        int i;
        boolean empty;
        Object obj5;
        Map obj6;
        int i3 = a.a.a[k2.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
            } else {
                obj6 = a.c;
                pVar = a.d;
                i = 0;
                final String country = locale.getCountry();
                if (!country.isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(locale.getLanguage());
                    stringBuilder.append('_');
                    stringBuilder.append(country);
                    i = obj6.get(stringBuilder.toString());
                }
                if (i == 0) {
                    i = obj5;
                }
                if (i == 0) {
                    return pVar;
                }
                return i;
            }
            obj5 = new UnsupportedOperationException(k2.name());
            throw obj5;
        }
        obj6 = a.a;
        pVar = a.b;
    }
}
