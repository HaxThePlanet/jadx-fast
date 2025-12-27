package net.time4j.calendar;

import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.f1.c;
import net.time4j.g1.b;

/* compiled from: SexagesimalName.java */
/* loaded from: classes3.dex */
public class n implements Comparable<n>, Serializable {

    private static final String[] A;
    private static final String[] B;
    private static final String[] C;
    private static final String[] D;
    private static final n[] E;
    private static final Map<String, String[]> F;
    private static final Map<String, String[]> G;
    private static final Set<String> H;
    private static final String[] a;
    private static final String[] b;
    private static final String[] c;
    private static final long serialVersionUID = -4556668597489844917L;
    private static final String[] v;
    private static final String[] w;
    private static final String[] x;
    private static final String[] y;
    private static final String[] z;
    private final int number;

    public enum a {

        CHEN_5_DRAGON,
        CHOU_2_OX,
        HAI_12_PIG,
        MAO_4_HARE,
        SHEN_9_MONKEY,
        SI_6_SNAKE,
        WEI_8_SHEEP,
        WU_7_HORSE,
        XU_11_DOG,
        YIN_3_TIGER,
        YOU_10_FOWL,
        ZI_1_RAT;
        @Override // java.lang.Enum
        public String getDisplayName(Locale locale) {
            String language;
            Object value;
            if (locale.getLanguage().isEmpty()) {
                language = "root";
            }
            if ((String[])n.G.get(language) == null) {
                String[] strArr = n.z;
            }
            return value[ordinal()];
        }

        @Override // java.lang.Enum
        public String getZodiac(Locale locale) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "zodiac-";
            String str3 = String.valueOf(ordinal() + 1);
            str = str2 + str3;
            return (String)b.c("chinese", locale).m().get(str);
        }
    }

    public enum b {

        BING_3_FIRE_YANG,
        DING_4_FIRE_YIN,
        GENG_7_METAL_YANG,
        GUI_10_WATER_YIN,
        JIA_1_WOOD_YANG,
        JI_6_EARTH_YIN,
        REN_9_WATER_YANG,
        WU_5_EARTH_YANG,
        XIN_8_METAL_YIN,
        YI_2_WOOD_YIN;
        @Override // java.lang.Enum
        public String getDisplayName(Locale locale) {
            String language;
            Object value;
            if (locale.getLanguage().isEmpty()) {
                language = "root";
            }
            if ((String[])n.F.get(language) == null) {
                String[] strArr = n.b;
            }
            return value[ordinal()];
        }
    }
    static {
        int i = 0;
        n.a = new String[] { "jia", "yi", "bing", "ding", "wu", "ji", "geng", "xin", "ren", "gui" };
        n.b = new String[] { "jiǎ", "yǐ", "bǐng", "dīng", "wù", "jǐ", "gēng", "xīn", "rén", "guǐ" };
        n.c = new String[] { "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸" };
        n.v = new String[] { "갑", "을", "병", "정", "무", "기", "경", "신", "임", "계" };
        n.w = new String[] { "giáp", "ất", "bính", "đinh", "mậu", "kỷ", "canh", "tân", "nhâm", "quý" };
        n.x = new String[] { "Цзя", "И", "Бин", "Дин", "У", "Цзи", "Гэн", "Синь", "Жэнь", "Гуй" };
        n.y = new String[] { "zi", "chou", "yin", "mao", "chen", "si", "wu", "wei", "shen", "you", "xu", "hai" };
        n.z = new String[] { "zǐ", "chǒu", "yín", "mǎo", "chén", "sì", "wǔ", "wèi", "shēn", "yǒu", "xū", "hài" };
        n.A = new String[] { "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥" };
        n.B = new String[] { "자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해" };
        n.C = new String[] { "tí", "sửu", "dần", "mão", "thìn", "tị", "ngọ", "mùi", "thân", "dậu", "tuất", "hợi" };
        str = "Инь";
        str2 = "Мао";
        n.D = new String[] { "Цзы", "Чоу", str, str2, "Чэнь", "Сы", "У", "Вэй", "Шэнь", "Ю", "Сюй", "Хай" };
        int i2 = 60;
        net.time4j.calendar.n[] arr = new n[i2];
        i = 0;
        while (i < i2) {
            i = i + 1;
            arr[i] = new n(i);
        }
        n.E = arr;
        HashMap hashMap = new HashMap();
        String str28 = "root";
        hashMap.put(str28, n.a);
        String[] strArr14 = n.c;
        String str40 = "zh";
        hashMap.put(str40, strArr14);
        String str52 = "ja";
        hashMap.put(str52, strArr14);
        String str65 = "ko";
        hashMap.put(str65, n.v);
        String str78 = "vi";
        hashMap.put(str78, n.w);
        String str91 = "ru";
        hashMap.put(str91, n.x);
        n.F = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(str28, n.y);
        String[] strArr19 = n.A;
        hashMap2.put(str40, strArr19);
        hashMap2.put(str52, strArr19);
        hashMap2.put(str65, n.B);
        hashMap2.put(str78, n.C);
        hashMap2.put(str91, n.D);
        n.G = Collections.unmodifiableMap(hashMap2);
        HashSet hashSet = new HashSet();
        hashSet.add(str40);
        hashSet.add(str52);
        hashSet.add(str65);
        n.H = Collections.unmodifiableSet(hashSet);
    }

    n(int i) {
        super();
        this.number = i;
    }

    static /* synthetic */ Map a() {
        return n.F;
    }

    static /* synthetic */ String[] c() {
        return n.b;
    }

    static /* synthetic */ Map e() {
        return n.G;
    }

    static /* synthetic */ String[] f() {
        return n.z;
    }

    public static n n(int i) {
        int i3 = 1;
        if (i < i3) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            int i2 = 60;
            if (i <= 60) {
                return n.E[i - i3];
            }
        }
    }

    public static n o(n.b bVar, n.a aVar) {
        int ordinal = bVar.ordinal();
        net.time4j.calendar.n nVar = n.n((ordinal + 1) + (c.c((aVar.ordinal() - ordinal) * 25, 60)));
        if (nVar.m() != bVar) {
            throw new IllegalArgumentException("Invalid combination of stem and branch.");
        } else {
            if (nVar.j() == aVar) {
                return nVar;
            }
        }
    }

    static n p(java.lang.CharSequence charSequence, ParsePosition parsePosition, Locale locale, boolean z) {
        Locale locale32;
        int length;
        net.time4j.calendar.n.b[] values;
        int i2;
        int i = 0;
        net.time4j.calendar.n.b[] values3;
        int length3;
        int length4 = 0;
        char charAt2;
        char charAt3;
        char c = 45;
        net.time4j.calendar.n.b bVar2;
        int i3 = 0;
        char charAt4;
        net.time4j.calendar.n.a aVar2;
        net.time4j.calendar.n.b bVar;
        int i4;
        char charAt5;
        String displayName;
        char charAt6;
        char charAt;
        java.lang.CharSequence charSequence2 = charSequence;
        final ParsePosition parsePosition22 = parsePosition;
        locale32 = locale;
        length = parsePosition.getIndex();
        int length2 = charSequence.length();
        boolean empty = locale.getLanguage().isEmpty();
        i2 = length + 1;
        i = 0;
        parsePosition22.setErrorIndex(length);
        return i;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = false;
        int i = 0;
        if (getClass().equals(object.getClass())) {
            if (this.number == object.number) {
                int i2 = 1;
            }
        }
        return z;
    }

    public int getNumber() {
        return this.number;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.number;
    }

    public int i(n nVar) {
        if (!getClass().equals(nVar.getClass())) {
            throw new ClassCastException("Cannot compare different types.");
        } else {
            return this.number - (n)n.class.cast(nVar).number;
        }
    }

    public n.a j() {
        int i = 12;
        i = 12;
        i = this.number % i;
        if (this.number != 0) {
        }
        return n.a.values()[i - 1];
    }

    public String k(Locale locale) {
        String str;
        String r2 = n.H.contains(locale.getLanguage()) ? "" : "-";
        StringBuilder stringBuilder = new StringBuilder();
        String displayName = m().getDisplayName(locale);
        String displayName2 = j().getDisplayName(locale);
        str2 = displayName + r2 + displayName2;
        return displayName + (n.H.contains(locale.getLanguage()) ? "" : "-") + displayName2;
    }

    public n.b m() {
        int i = 10;
        i = 10;
        i = this.number % i;
        if (this.number != 0) {
        }
        return n.b.values()[i - 1];
    }

    Object readResolve() {
        return n.n(this.number);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = k(Locale.ROOT);
        String str3 = "(";
        String str4 = String.valueOf(this.number);
        String str5 = ")";
        str = str2 + str3 + str4 + str5;
        return str;
    }

    private static char q(char c) {
        char c2 = '\u00e0';
        char c3 = '\u00f9';
        char c4 = '\u0113';
        if (!(c == '\u00e0' || c != '\u00f9' || c != '\u0113')) {
            char c5 = '\u012b';
            c3 = '\u016b';
            c2 = '\u01ce';
            if (!(c == '\u012b' || c != '\u016b' || c != '\u01ce')) {
                c5 = '\u01d0';
                c4 = '\u00e8';
                if (!(c == '\u01d0' || c != 466 || c != '\u00e8')) {
                    c4 = '\u00e9';
                    if (c != '\u00e9' && c != '\u00ec') {
                        c5 = '\u00ed';
                        if (c != '\u00ed') {
                            return c;
                        }
                    }
                    return 101;
                }
            }
            return 105;
        }
        return 97;
    }
}
