package net.time4j.calendar;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.time4j.b0;
import net.time4j.calendar.s.h;
import net.time4j.engine.m;
import net.time4j.engine.u;
import net.time4j.g0;
import net.time4j.i0;

/* compiled from: SolarTerm.java */
/* loaded from: classes3.dex */
public enum o {

    MAJOR_01_YUSHUI_330,
    MAJOR_02_CHUNFEN_000,
    MAJOR_03_GUYU_030,
    MAJOR_04_XIAOMAN_060,
    MAJOR_05_XIAZHI_090,
    MAJOR_06_DASHU_120,
    MAJOR_07_CHUSHU_150,
    MAJOR_08_QIUFEN_180,
    MAJOR_09_SHUANGJIANG_210,
    MAJOR_10_XIAOXUE_240,
    MAJOR_11_DONGZHI_270,
    MAJOR_12_DAHAN_300;

    class a implements u<D> {

        final /* synthetic */ o a;
        a() {
            this.a = oVar;
            super();
        }

        public D a(D d) {
            final int i2 = 1;
            return this.a.onOrAfter(o.MINOR_01_LICHUN_315.onOrAfter(d.X().v(g0.K0((g0)d.W(g0.class).m(), i2, i2).c())));
        }
    }

    class b implements u<D> {

        final /* synthetic */ o a;
        b() {
            this.a = oVar;
            super();
        }

        public D a(D d) {
            return this.a.onOrAfter(d.X().v(o.newYear(d)));
        }
    }
    static /* synthetic */ long access$000(f fVar) {
        return o.newYear(fVar);
    }

    private b0 atOrAfter(b0 b0Var) {
        double max;
        double d3 = (double)getSolarLongitude();
        double d4 = c.h(b0Var).d();
        double d9 = (o.modulo360(d3 - o.solarLongitude(d4))) * 365.242189d / 360d + d4;
        max = 5d;
        d = d9 - max;
        max = Math.max(d4, d);
        max = d9 + max;
        max = (max + max) / 2d;
        double d13 = max - max;
        while (d13 < 4532020583610935537L) {
            double d = o.modulo360(o.solarLongitude(max) - d3);
            double d2 = 180d;
        }
        return c.g(max).i();
    }

    private static String[] getTextForms(Locale locale) {
        String[] cHINESE_SIMPLIFIED2;
        String[] sIMPLE2;
        if (locale.getLanguage().equals("zh")) {
            locale = locale.getCountry().equals("TW") ? o.CHINESE_TRADITIONAL : o.CHINESE_SIMPLIFIED;
            return (locale.getCountry().equals("TW") ? o.CHINESE_TRADITIONAL : o.CHINESE_SIMPLIFIED);
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
        locale = locale.getLanguage().isEmpty() ? o.SIMPLE : o.TRANSSCRIPTION;
        return (locale.getLanguage().isEmpty() ? o.SIMPLE : o.TRANSSCRIPTION);
    }

    public static <D extends f<?, D>> List<D> list(int i, Class<D> cls) {
        int i2 = 1;
        net.time4j.calendar.f onOrAfter;
        final int i3 = 24;
        final ArrayList arrayList = new ArrayList(i3);
        i2 = 1;
        arrayList.add(o.MINOR_01_LICHUN_315.onOrAfter((f)g0.K0(i, i2, i2).W(cls)));
        while (i2 < i3) {
            arrayList.add(o.values()[i2].onOrAfter(onOrAfter));
            i2 = i2 + 1;
        }
        return arrayList;
    }

    private static double modulo360(double d) {
        final double d2 = 360d;
        return d - (Math.floor(d / d2)) * d2;
    }

    private static <D extends f<?, ?>> long newYear(D d) {
        return d.X().q(d.Y(), d.i0().getNumber());
    }

    public static o of(b0 b0Var) {
        return o.ENUMS[(int)(Math.floor(o.solarLongitude(c.h(b0Var).d()) / 15d)) + 3 % 24];
    }

    public static o ofMajor(int i) {
        int i3 = 1;
        if (i < i3) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i2 = 12;
            if (i <= 12) {
                return o.ENUMS[(i * 2) - i3];
            }
        }
    }

    public static o ofMinor(int i) {
        int i3 = 1;
        if (i < i3) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i2 = 12;
            if (i <= 12) {
                return o.ENUMS[(i - i3) * 2];
            }
        }
    }

    public static o parse(java.lang.CharSequence charSequence, Locale locale) throws ParseException {
        final int i = 0;
        net.time4j.calendar.o parse = o.parse(charSequence, locale, new ParsePosition(i));
        if (parse == null) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Cannot parse: ";
            charSequence = str + charSequence;
            throw new ParseException(charSequence, i);
        } else {
            return parse;
        }
    }

    static double solarLongitude(double d) {
        return h.TIME4J.getFeature(d, "solar-longitude");
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return o.getTextForms(locale)[ordinal()];
    }

    @Override // java.lang.Enum
    public int getIndex() {
        return (ordinal() / 2) + 1;
    }

    @Override // java.lang.Enum
    public int getSolarLongitude() {
        return (ordinal() + 21) % 24 * 15;
    }

    @Override // java.lang.Enum
    public boolean isMajor() {
        boolean z = true;
        if (ordinal() % 2 != 1) {
            int i3 = 0;
        }
        return z;
    }

    @Override // java.lang.Enum
    public boolean isMinor() {
        boolean z = true;
        int r0 = ordinal() % 2 == 0 ? 1 : 0;
        return (ordinal() % 2 == 0 ? 1 : 0);
    }

    @Override // java.lang.Enum
    public <D extends f<?, D>> D onOrAfter(D d) {
        final net.time4j.calendar.d dVar = d.X();
        long l = d.c();
        return dVar.v(atOrAfter(dVar.n(l)).w0(dVar.i(l)).h0().c());
    }

    @Override // java.lang.Enum
    public o roll(int i) {
        return o.ENUMS[c.c(ordinal() + i, 24)];
    }

    @Override // java.lang.Enum
    public <D extends f<?, D>> u<D> sinceLichun() {
        return new o.a(this);
    }

    @Override // java.lang.Enum
    public <D extends f<?, D>> u<D> sinceNewYear() {
        return new o.b(this);
    }

    static o parse(java.lang.CharSequence charSequence, Locale locale, ParsePosition parsePosition) {
        int i = 0;
        int i2;
        final String[] textForms = o.getTextForms(locale);
        final int index = parsePosition.getIndex();
        i = 0;
        while (i < textForms.length) {
            String str = textForms[i];
            i2 = str.length() + index;
            String charSequence2 = charSequence.subSequence(index, Math.min(charSequence.length(), i2)).toString();
            if (charSequence2.equals(str)) {
                parsePosition.setIndex(parsePosition.getIndex() + str.length());
                return o.ENUMS[i];
            }
            if (charSequence2.equalsIgnoreCase(str)) {
                parsePosition.setIndex(parsePosition.getIndex() + str.length());
                return o.ENUMS[i];
            }
        }
        parsePosition.setErrorIndex(parsePosition.getIndex());
        return null;
    }
}
