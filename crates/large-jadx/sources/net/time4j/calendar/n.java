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

/* loaded from: classes3.dex */
public class n implements Comparable<net.time4j.calendar.n>, Serializable {

    private static final String[] A = null;
    private static final String[] B = null;
    private static final String[] C = null;
    private static final String[] D = null;
    private static final net.time4j.calendar.n[] E = null;
    private static final Map<String, String[]> F = null;
    private static final Map<String, String[]> G = null;
    private static final Set<String> H = null;
    private static final String[] a = null;
    private static final String[] b = null;
    private static final String[] c = null;
    private static final long serialVersionUID = -4556668597489844917L;
    private static final String[] v;
    private static final String[] w;
    private static final String[] x;
    private static final String[] y;
    private static final String[] z;
    private final int number;

    public static enum a {

        ZI_1_RAT,
        CHOU_2_OX,
        YIN_3_TIGER,
        MAO_4_HARE,
        CHEN_5_DRAGON,
        SI_6_SNAKE,
        WU_7_HORSE,
        WEI_8_SHEEP,
        SHEN_9_MONKEY,
        YOU_10_FOWL,
        XU_11_DOG,
        HAI_12_PIG;
        @Override // java.lang.Enum
        public String getDisplayName(Locale locale) {
            String obj3;
            if (locale.getLanguage().isEmpty()) {
                obj3 = "root";
            }
            if ((String[])n.e().get(obj3) == null) {
                obj3 = n.f();
            }
            return obj3[ordinal()];
        }

        @Override // java.lang.Enum
        public String getZodiac(Locale locale) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("zodiac-");
            stringBuilder.append(String.valueOf(ordinal++));
            return (String)b.c("chinese", locale).m().get(stringBuilder.toString());
        }
    }

    public static enum b {

        JIA_1_WOOD_YANG,
        YI_2_WOOD_YIN,
        BING_3_FIRE_YANG,
        DING_4_FIRE_YIN,
        WU_5_EARTH_YANG,
        JI_6_EARTH_YIN,
        GENG_7_METAL_YANG,
        XIN_8_METAL_YIN,
        REN_9_WATER_YANG,
        GUI_10_WATER_YIN;
        @Override // java.lang.Enum
        public String getDisplayName(Locale locale) {
            String obj3;
            if (locale.getLanguage().isEmpty()) {
                obj3 = "root";
            }
            if ((String[])n.a().get(obj3) == null) {
                obj3 = n.c();
            }
            return obj3[ordinal()];
        }
    }
    static {
        int i;
        String nVar;
        String str;
        n.a = /* result */;
        n.b = /* result */;
        n.c = /* result */;
        n.v = /* result */;
        n.w = /* result */;
        n.x = /* result */;
        n.y = /* result */;
        n.z = /* result */;
        n.A = /* result */;
        n.B = /* result */;
        n.C = /* result */;
        n.D = /* result */;
        int i2 = 60;
        net.time4j.calendar.n[] arr = new n[i2];
        i = 0;
        while (i < i2) {
            str = i + 1;
            nVar = new n(str);
            arr[i] = nVar;
            i = str;
        }
        n.E = arr;
        HashMap hashMap = new HashMap();
        String str27 = "root";
        hashMap.put(str27, n.a);
        String[] strArr14 = n.c;
        String str39 = "zh";
        hashMap.put(str39, strArr14);
        String str51 = "ja";
        hashMap.put(str51, strArr14);
        String str64 = "ko";
        hashMap.put(str64, n.v);
        String str77 = "vi";
        hashMap.put(str77, n.w);
        String str90 = "ru";
        hashMap.put(str90, n.x);
        n.F = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(str27, n.y);
        String[] strArr19 = n.A;
        hashMap2.put(str39, strArr19);
        hashMap2.put(str51, strArr19);
        hashMap2.put(str64, n.B);
        hashMap2.put(str77, n.C);
        hashMap2.put(str90, n.D);
        n.G = Collections.unmodifiableMap(hashMap2);
        HashSet hashSet = new HashSet();
        hashSet.add(str39);
        hashSet.add(str51);
        hashSet.add(str64);
        n.H = Collections.unmodifiableSet(hashSet);
    }

    n(int i) {
        super();
        this.number = i;
    }

    static Map a() {
        return n.F;
    }

    static String[] c() {
        return n.b;
    }

    static Map e() {
        return n.G;
    }

    static String[] f() {
        return n.z;
    }

    public static net.time4j.calendar.n n(int i) {
        int i2;
        int i3 = 1;
        if (i < i3) {
        } else {
            if (i > 60) {
            } else {
                return n.E[i -= i3];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static net.time4j.calendar.n o(net.time4j.calendar.n.b n$b, net.time4j.calendar.n.a n$a2) {
        Enum obj3;
        int ordinal = b.ordinal();
        net.time4j.calendar.n nVar = n.n(i5 += i2);
        if (nVar.m() != b) {
        } else {
            if (nVar.j() != a2) {
            } else {
                return nVar;
            }
        }
        obj3 = new IllegalArgumentException("Invalid combination of stem and branch.");
        throw obj3;
    }

    static net.time4j.calendar.n p(java.lang.CharSequence charSequence, ParsePosition parsePosition2, Locale locale3, boolean z4) {
        Locale length3;
        int charAt4;
        net.time4j.calendar.n.b[] length;
        int i5;
        int values;
        boolean contains;
        net.time4j.calendar.n.b[] charAt;
        int length2;
        int i4;
        int i3;
        char c;
        char charAt3;
        int displayName;
        int i6;
        int i2;
        int charAt5;
        char charAt6;
        char displayName2;
        int i;
        char charAt2;
        net.time4j.calendar.n.b[] objArr;
        char charAt7;
        java.lang.CharSequence charSequence2 = charSequence;
        final ParsePosition parsePosition = parsePosition2;
        length3 = locale3;
        charAt4 = parsePosition2.getIndex();
        length = charSequence.length();
        boolean empty = locale3.getLanguage().isEmpty();
        i5 = charAt4 + 1;
        values = 0;
        if (i5 < length) {
            if (charAt4 < 0) {
            } else {
                i4 = 0;
                if (n.H.contains(locale3.getLanguage())) {
                    length = n.b.values();
                    displayName = i4;
                    while (displayName < length.length) {
                        displayName++;
                    }
                    i6 = values;
                    if (i6 != null) {
                        length = n.a.values();
                        displayName = i4;
                        while (displayName < length.length) {
                            displayName++;
                        }
                        charAt5 = values;
                    } else {
                    }
                }
                if (i6 != 0 && charAt5 == 0) {
                    if (charAt5 == 0) {
                    }
                    parsePosition.setIndex(charAt4);
                    return n.o(i6, charAt5);
                }
                if (z4 && !empty) {
                    if (!empty) {
                        return n.p(charSequence2, parsePosition, Locale.ROOT, true);
                    }
                }
            }
            parsePosition.setErrorIndex(charAt4);
            return null;
        }
        parsePosition.setErrorIndex(charAt4);
        return values;
    }

    private static char q(char c) {
        int i;
        int i4;
        int i2;
        int i3;
        if (c != 224 && c != 249 && c != 275 && c != 299 && c != 363 && c != 462 && c != 464 && c != 466 && c != 232 && c != 233 && c != 236 && c != 237) {
            if (c != 249) {
                if (c != 275) {
                    if (c != 299) {
                        if (c != 363) {
                            if (c != 462) {
                                if (c != 464) {
                                    if (c != 466) {
                                        if (c != 232) {
                                            if (c != 233) {
                                                if (c != 236) {
                                                    if (c != 237) {
                                                        return c;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    return 111;
                                }
                            }
                        }
                    }
                    return 105;
                }
                return 101;
            }
            return 117;
        }
        return 97;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return i((n)object);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        boolean equals;
        int i;
        Object obj3;
        i = 0;
        if (getClass().equals(object.getClass()) && this.number == object.number) {
            if (this.number == object.number) {
                i = 1;
            }
        }
        return i;
    }

    @Override // java.lang.Comparable
    public int getNumber() {
        return this.number;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return this.number;
    }

    @Override // java.lang.Comparable
    public int i(net.time4j.calendar.n n) {
        if (!getClass().equals(n.getClass())) {
        } else {
            return number -= obj3;
        }
        ClassCastException obj3 = new ClassCastException("Cannot compare different types.");
        throw obj3;
    }

    @Override // java.lang.Comparable
    public net.time4j.calendar.n.a j() {
        int i;
        number %= i;
        if (i2 == 0) {
        } else {
            i = i2;
        }
        return n.a.values()[i--];
    }

    @Override // java.lang.Comparable
    public String k(Locale locale) {
        String str;
        str = n.H.contains(locale.getLanguage()) ? "" : "-";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m().getDisplayName(locale));
        stringBuilder.append(str);
        stringBuilder.append(j().getDisplayName(locale));
        return stringBuilder.toString();
    }

    @Override // java.lang.Comparable
    public net.time4j.calendar.n.b m() {
        int i;
        number %= i;
        if (i2 == 0) {
        } else {
            i = i2;
        }
        return n.b.values()[i--];
    }

    @Override // java.lang.Comparable
    Object readResolve() {
        return n.n(this.number);
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k(Locale.ROOT));
        stringBuilder.append("(");
        stringBuilder.append(String.valueOf(this.number));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
