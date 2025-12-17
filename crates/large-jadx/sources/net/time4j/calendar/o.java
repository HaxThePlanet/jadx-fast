package net.time4j.calendar;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.time4j.b0;
import net.time4j.calendar.s.c;
import net.time4j.calendar.s.h;
import net.time4j.engine.m;
import net.time4j.engine.u;
import net.time4j.f1.c;
import net.time4j.g0;
import net.time4j.i0;

/* loaded from: classes3.dex */
public enum o {

    MINOR_01_LICHUN_315,
    MAJOR_01_YUSHUI_330,
    MINOR_02_JINGZHE_345,
    MAJOR_02_CHUNFEN_000,
    MINOR_03_QINGMING_015,
    MAJOR_03_GUYU_030,
    MINOR_04_LIXIA_045,
    MAJOR_04_XIAOMAN_060,
    MINOR_05_MANGZHONG_075,
    MAJOR_05_XIAZHI_090,
    MINOR_06_XIAOSHU_105,
    MAJOR_06_DASHU_120,
    MINOR_07_LIQIU_135,
    MAJOR_07_CHUSHU_150,
    MINOR_08_BAILU_165,
    MAJOR_08_QIUFEN_180,
    MINOR_09_HANLU_195,
    MAJOR_09_SHUANGJIANG_210,
    MINOR_10_LIDONG_225,
    MAJOR_10_XIAOXUE_240,
    MINOR_11_DAXUE_255,
    MAJOR_11_DONGZHI_270,
    MINOR_12_XIAOHAN_285,
    MAJOR_12_DAHAN_300;

    class a implements u<D> {

        final net.time4j.calendar.o a;
        a(net.time4j.calendar.o o) {
            this.a = o;
            super();
        }

        public D a(D d) {
            final int i2 = 1;
            return this.a.onOrAfter(o.MINOR_01_LICHUN_315.onOrAfter(d.X().v(g0.K0((g0)d.W(g0.class).m(), i2, i2).c())));
        }

        @Override // net.time4j.engine.u
        public Object apply(Object object) {
            return a((f)object);
        }
    }

    class b implements u<D> {

        final net.time4j.calendar.o a;
        b(net.time4j.calendar.o o) {
            this.a = o;
            super();
        }

        public D a(D d) {
            return this.a.onOrAfter(d.X().v(o.access$000(d)));
        }

        @Override // net.time4j.engine.u
        public Object apply(Object object) {
            return a((f)object);
        }
    }
    static long access$000(net.time4j.calendar.f f) {
        return o.newYear(f);
    }

    private b0 atOrAfter(b0 b0) {
        double d;
        int i;
        long l2;
        int i2;
        long l;
        c obj13;
        double d2 = (double)solarLongitude;
        double d3 = c.h(b0).d();
        i5 += d3;
        l2 = 4617315517961601024L;
        d = Math.max(d3, obj3);
        i6 += l2;
        i7 /= l5;
        while (Double.compare(i8, l6) < 0) {
            if (Double.compare(i2, l) < 0) {
            } else {
            }
            d = l2;
            i7 /= l5;
            i = l2;
        }
        return c.g(l2).i();
    }

    private static String[] getTextForms(Locale locale) {
        String[] obj2;
        if (locale.getLanguage().equals("zh")) {
            obj2 = locale.getCountry().equals("TW") ? o.CHINESE_TRADITIONAL : o.CHINESE_SIMPLIFIED;
            return obj2;
        }
        if (locale.getLanguage().equals("ko")) {
            return o.KOREAN;
        }
        if (locale.getLanguage().equals("vi")) {
            return o.VIETNAMESE;
        }
        if (locale.getLanguage().equals("ja")) {
            return o.JAPANESE;
        }
        obj2 = locale.getLanguage().isEmpty() ? o.SIMPLE : o.TRANSSCRIPTION;
        return obj2;
    }

    public static <D extends net.time4j.calendar.f<?, D>> List<D> list(int i, Class<D> class2) {
        int i2;
        net.time4j.calendar.o oVar;
        net.time4j.calendar.f obj4;
        final int i3 = 24;
        ArrayList arrayList = new ArrayList(i3);
        i2 = 1;
        arrayList.add(o.MINOR_01_LICHUN_315.onOrAfter((f)g0.K0(i, i2, i2).W(class2)));
        while (i2 < i3) {
            arrayList.add(o.values()[i2].onOrAfter(obj4));
            i2++;
        }
        return arrayList;
    }

    private static double modulo360(double d) {
        final long l = 4645040803167600640L;
        return d -= i2;
    }

    private static <D extends net.time4j.calendar.f<?, ?>> long newYear(D d) {
        return d.X().q(d.Y(), d.i0().getNumber());
    }

    public static net.time4j.calendar.o of(b0 b0) {
        return o.ENUMS[obj4 %= 24];
    }

    public static net.time4j.calendar.o ofMajor(int i) {
        int i2;
        int i3 = 1;
        if (i < i3) {
        } else {
            if (i > 12) {
            } else {
                return o.ENUMS[obj3 -= i3];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static net.time4j.calendar.o ofMinor(int i) {
        int i2;
        int i3 = 1;
        if (i < i3) {
        } else {
            if (i > 12) {
            } else {
                return o.ENUMS[obj3 *= 2];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static net.time4j.calendar.o parse(java.lang.CharSequence charSequence, Locale locale2) {
        final int i = 0;
        ParsePosition parsePosition = new ParsePosition(i);
        net.time4j.calendar.o obj4 = o.parse(charSequence, locale2, parsePosition);
        if (obj4 == null) {
        } else {
            return obj4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot parse: ");
        stringBuilder.append(charSequence);
        obj4 = new ParseException(stringBuilder.toString(), i);
        throw obj4;
    }

    static net.time4j.calendar.o parse(java.lang.CharSequence charSequence, Locale locale2, ParsePosition parsePosition3) {
        int i;
        String str;
        boolean string;
        int equalsIgnoreCase;
        boolean obj8;
        final String[] textForms = o.getTextForms(locale2);
        final int index = parsePosition3.getIndex();
        i = 0;
        for (Object str : obj0) {
            string = charSequence.subSequence(index, Math.min(charSequence.length(), length3 += index)).toString();
        }
        if (!locale2.getLanguage().isEmpty() && textForms != o.TRANSSCRIPTION) {
            if (textForms != o.TRANSSCRIPTION) {
            }
            return o.parse(charSequence, Locale.ROOT, parsePosition3);
        }
        parsePosition3.setErrorIndex(parsePosition3.getIndex());
        return null;
    }

    static double solarLongitude(double d) {
        return h.TIME4J.getFeature(d, obj3);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return o.getTextForms(locale)[ordinal()];
    }

    @Override // java.lang.Enum
    public int getIndex() {
        return i++;
    }

    @Override // java.lang.Enum
    public int getSolarLongitude() {
        return i2 *= 15;
    }

    @Override // java.lang.Enum
    public boolean isMajor() {
        int i;
        if (ordinal %= 2 == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // java.lang.Enum
    public boolean isMinor() {
        int i;
        i = ordinal %= 2 == 0 ? 1 : 0;
        return i;
    }

    public <D extends net.time4j.calendar.f<?, D>> D onOrAfter(D d) {
        final net.time4j.calendar.d dVar = d.X();
        long l = d.c();
        return dVar.v(atOrAfter(dVar.n(l)).w0(dVar.i(l)).h0().c());
    }

    @Override // java.lang.Enum
    public net.time4j.calendar.o roll(int i) {
        return o.ENUMS[c.c(ordinal += i, 24)];
    }

    public <D extends net.time4j.calendar.f<?, D>> u<D> sinceLichun() {
        o.a aVar = new o.a(this);
        return aVar;
    }

    public <D extends net.time4j.calendar.f<?, D>> u<D> sinceNewYear() {
        o.b bVar = new o.b(this);
        return bVar;
    }
}
