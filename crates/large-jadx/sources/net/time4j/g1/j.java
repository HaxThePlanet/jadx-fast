package net.time4j.g1;

import android.app.ActivityManager.MemoryInfo;
import java.util.Locale;
import net.time4j.f1.c;

/* loaded from: classes3.dex */
public enum j {

    ARABIC("latn"),
    ARABIC_INDIC("arab"),
    ARABIC_INDIC_EXT("arabext"),
    BENGALI("beng"),
    DEVANAGARI("deva"),
    DOZENAL("dozenal"),
    ETHIOPIC("ethiopic"),
    GUJARATI(5),
    JAPANESE(4),
    KHMER(3),
    MYANMAR(2),
    ORYA(true),
    ROMAN(false),
    TELUGU(true),
    THAI(false);

    private final String code;

    static enum a extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "០១២៣៤៥៦៧៨៩";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 1;
        }
    }

    static enum b extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "၀၁၂၃၄၅၆၇၈၉";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 1;
        }
    }

    static enum c extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "୦୧୨୩୪୫୬୭୮୯";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 1;
        }
    }

    static enum d extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public boolean contains(char c) {
            int i;
            int obj2;
            obj2 = Character.toUpperCase(c);
            if (obj2 != 73 && obj2 != 86 && obj2 != 88 && obj2 != 76 && obj2 != 67 && obj2 != 68) {
                if (obj2 != 86) {
                    if (obj2 != 88) {
                        if (obj2 != 76) {
                            if (obj2 != 67) {
                                if (obj2 != 68) {
                                    if (obj2 == 77) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = 0;
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj2;
        }

        @Override // net.time4j.g1.j
        public String getDigits() {
            return "IVXLCDM";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 0;
        }

        @Override // net.time4j.g1.j
        public int toInteger(String string, net.time4j.g1.g g2) {
            int i5;
            int i2;
            char charAt2;
            int i4;
            int i6;
            int i3;
            char charAt;
            int i;
            int obj11;
            if (string.isEmpty()) {
            } else {
                String upperCase = string.toUpperCase(Locale.US);
                boolean obj12 = g2.isStrict();
                int length = string.length();
                i2 = i5;
                while (i5 < length) {
                    charAt2 = upperCase.charAt(i5);
                    i4 = j.access$500(charAt2);
                    if (i5++ == length) {
                    } else {
                    }
                    i6 = 1;
                    i3 = i6;
                    while (i5 < length) {
                        charAt = upperCase.charAt(i5);
                        i5++;
                        i3++;
                        if (i5 == length) {
                        }
                        i2 += charAt;
                    }
                    charAt = upperCase.charAt(i5);
                    i5++;
                    i = j.access$500(charAt);
                    i7 -= i4;
                    i2 += i4;
                    i5--;
                    i3++;
                    if (i5 == length) {
                    }
                    i2 += charAt;
                    i2 += i4;
                }
                if (i2 > 3999) {
                } else {
                    if (obj12 != null && i2 >= 900) {
                        if (i2 >= 900) {
                            if (upperCase.contains("DCD")) {
                            } else {
                            }
                            obj11 = new NumberFormatException("Roman number contains invalid sequence DCD.");
                            throw obj11;
                        }
                        if (i2 >= 90) {
                            if (upperCase.contains("LXL")) {
                            } else {
                            }
                            obj11 = new NumberFormatException("Roman number contains invalid sequence LXL.");
                            throw obj11;
                        }
                        if (i2 >= 9) {
                            if (upperCase.contains("VIV")) {
                            } else {
                            }
                            obj11 = new NumberFormatException("Roman number contains invalid sequence VIV.");
                            throw obj11;
                        }
                    }
                    return i2;
                }
                obj11 = new NumberFormatException("Roman numbers bigger than 3999 not supported.");
                throw obj11;
            }
            obj11 = new NumberFormatException("Empty Roman numeral.");
            throw obj11;
        }

        @Override // net.time4j.g1.j
        public String toNumeral(int i) {
            int i2;
            int i3;
            int i4;
            int length;
            int obj4;
            if (i < 1) {
            } else {
                if (i > 3999) {
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    i3 = 0;
                    for (int length : obj2) {
                        while (obj4 >= j.access$300()[i3]) {
                            stringBuilder.append(j.access$400()[i3]);
                            obj4 -= length;
                        }
                        stringBuilder.append(j.access$400()[i3]);
                        obj4 -= length;
                    }
                    return stringBuilder.toString();
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Out of range (1-3999): ");
            stringBuilder2.append(i);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
            throw illegalArgumentException;
        }
    }

    static enum e extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "౦౧౨౩౪౫౬౭౮౯";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 1;
        }
    }

    static enum f extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "๐๑๒๓๔๕๖๗๘๙";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 1;
        }
    }

    static enum g extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public boolean contains(char c) {
            int i;
            int obj2;
            if (c >= 48 && c <= 57) {
                obj2 = c <= 57 ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // net.time4j.g1.j
        public String getDigits() {
            return "0123456789";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 1;
        }

        @Override // net.time4j.g1.j
        public int toInteger(String string, net.time4j.g1.g g2) {
            int obj4 = Integer.parseInt(string);
            if (obj4 < 0) {
            } else {
                return obj4;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot convert negative number: ");
            stringBuilder.append(string);
            obj4 = new NumberFormatException(stringBuilder.toString());
            throw obj4;
        }

        @Override // net.time4j.g1.j
        public String toNumeral(int i) {
            if (i < 0) {
            } else {
                return Integer.toString(i);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot convert: ");
            stringBuilder.append(i);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
    }

    static enum h extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "٠١٢٣٤٥٦٧٨٩";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 1;
        }
    }

    static enum i extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "۰۱۲۳۴۵۶۷۸۹";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 1;
        }
    }

    static enum j extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "০১২৩৪৫৬৭৮৯";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 1;
        }
    }

    static enum k extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "०१२३४५६७८९";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 1;
        }
    }

    static enum l extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public boolean contains(char c) {
            int i;
            int obj2;
            if (c >= 48) {
                if (c > 57 && c != 8586) {
                    if (c != 8586) {
                        if (c == 8587) {
                            obj2 = 1;
                        } else {
                            obj2 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj2;
        }

        @Override // net.time4j.g1.j
        public String getDigits() {
            return "0123456789↊↋";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 0;
        }

        @Override // net.time4j.g1.j
        public int toInteger(String string, net.time4j.g1.g g2) {
            int obj4 = Integer.parseInt(string.replace('\u218a', 'a').replace('\u218b', 'b'), 12);
            if (obj4 < 0) {
            } else {
                return obj4;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot convert negative number: ");
            stringBuilder.append(string);
            obj4 = new NumberFormatException(stringBuilder.toString());
            throw obj4;
        }

        @Override // net.time4j.g1.j
        public int toNumeral(int i, java.lang.Appendable appendable2) {
            int i7;
            int i2;
            int i5;
            int i4;
            int i6;
            int i3;
            int obj5;
            if (i >= 0) {
                i7 = 0;
                i2 = 1;
                while (i2 <= 4) {
                    if (i < j.access$100()[i2]) {
                        break;
                    } else {
                    }
                    i2++;
                }
                if (i7 > 0) {
                    i5 = i7 + -1;
                    int i9 = obj5 / i8;
                    do {
                        i9 = obj5 / i8;
                        if (i9 == 10) {
                        } else {
                        }
                        i3 = (char)i12;
                        appendable2.append(i3);
                        obj5 -= i4;
                        if (i5-- >= 0) {
                        }
                        i3 = 8586;
                        i3 = 8587;
                    } while (i9 == 11);
                    return i7;
                }
            }
            return super.toNumeral(i, appendable2);
        }

        @Override // net.time4j.g1.j
        public String toNumeral(int i) {
            if (i < 0) {
            } else {
                return Integer.toString(i, 12).replace('a', '\u218a').replace('b', '\u218b');
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot convert: ");
            stringBuilder.append(i);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
    }

    static enum m extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public boolean contains(char c) {
            int i;
            int obj2;
            if (c >= 4969 && c <= 4988) {
                obj2 = c <= 4988 ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // net.time4j.g1.j
        public String getDigits() {
            return "፩፪፫፬፭፮፯፰፱፲፳፴፵፶፷፸፹፺፻፼";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 0;
        }

        @Override // net.time4j.g1.j
        public int toInteger(String string, net.time4j.g1.g g2) {
            int i2;
            int i4;
            int i;
            int i7;
            int i8;
            int i6;
            char charAt;
            int i3;
            int i5;
            int obj12;
            i2 = 1;
            obj12 -= i2;
            final int i9 = 0;
            i6 = i2;
            i8 = i7;
            while (obj12 >= 0) {
                charAt = string.charAt(obj12);
                i3 = 4969;
                i5 = 4978;
                if (charAt >= i3 && charAt < i5) {
                } else {
                }
                i3 = 4987;
                if (charAt >= i5) {
                } else {
                }
                if (charAt == 4988) {
                } else {
                }
                if (charAt == i3) {
                }
                obj12--;
                i7 = j.access$200(i7, i8, i6);
                i6 *= 100;
                i4 = i2;
                i8 = i;
                if (i4 != 0 && i8 == 0) {
                }
                i7 = j.access$200(i7, i8, i6);
                if (i4 != 0) {
                } else {
                }
                i6 *= 10000;
                i = i2;
                i8 = i4;
                i6 *= 100;
                if (i8 == 0) {
                }
                i8 = i2;
                if (charAt < i3) {
                } else {
                }
                i12 *= 10;
                i8 += charAt;
                if (charAt < i5) {
                } else {
                }
                i10 -= i3;
            }
            if (i4 == 0) {
                if (i != 0 && i8 == 0) {
                    if (i8 == 0) {
                    } else {
                        i2 = i8;
                    }
                } else {
                }
            } else {
            }
            return j.access$200(i7, i2, i6);
        }

        @Override // net.time4j.g1.j
        public String toNumeral(int i) {
            int i3;
            int stringBuilder;
            String str;
            int i5;
            char c;
            char c2;
            int i4;
            char c3;
            int i6;
            int i2;
            String obj11;
            int i7 = 1;
            if (i < i7) {
            } else {
                obj11 = String.valueOf(i);
                length -= i7;
                if (i3 % 2 == 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("0");
                    stringBuilder.append(obj11);
                    obj11 = stringBuilder.toString();
                    i3++;
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                i5 = i3;
                while (i5 >= 0) {
                    char charAt = obj11.charAt(i3 - i5);
                    i5--;
                    char charAt2 = obj11.charAt(i3 - i8);
                    int i13 = 48;
                    c3 = 0;
                    if (charAt2 != i13) {
                    } else {
                    }
                    c2 = c3;
                    if (charAt != i13) {
                    } else {
                    }
                    c = c3;
                    i6 = 4987;
                    if (i8 != 0) {
                    } else {
                    }
                    i4 = c3;
                    if (c2 == 4969 && c == 0 && i3 > i7) {
                    } else {
                    }
                    c3 = c2;
                    if (c != 0) {
                    }
                    if (c3 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    i8--;
                    stringBuilder3.append(i4);
                    stringBuilder3.append(c3);
                    stringBuilder3.append(c);
                    if (c == 0) {
                    } else {
                    }
                    if (i3 > i7) {
                    } else {
                    }
                    if (i4 != i6) {
                    }
                    if (i8 + 1 == i3) {
                    } else {
                    }
                    if (i14 /= 2 != 0) {
                    } else {
                    }
                    i4 = 4988;
                    if (c2 == 0) {
                    } else {
                    }
                    i4 = i6;
                    if (c != 0) {
                    } else {
                    }
                    c = (char)i10;
                    c2 = (char)i12;
                }
                return stringBuilder3.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Can only convert positive numbers: ");
            stringBuilder2.append(i);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
            throw illegalArgumentException;
        }
    }

    static enum n extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "૦૧૨૩૪૫૬૭૮૯";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 1;
        }
    }

    static enum o extends net.time4j.g1.j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "一二三四五六七八九十百千";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return 0;
        }

        @Override // net.time4j.g1.j
        public int toInteger(String string, net.time4j.g1.g g2) {
            int i4;
            int i6;
            int i3;
            int i5;
            int i;
            char charAt2;
            int i2;
            String str;
            int charAt;
            final int i7 = 1;
            length -= i7;
            final int i8 = 0;
            i = i5;
            while (i4 >= 0) {
                charAt2 = string.charAt(i4);
                str = "Invalid Japanese numeral: ";
                i6++;
                i4--;
                i++;
                i5++;
                i2 = i8;
                while (i2 < 9) {
                    i2++;
                }
                charAt2 = i8;
                if (obj13.charAt(i2) == charAt2) {
                } else {
                }
                i2++;
                i2++;
                int i9 = -1;
                if (i == i7) {
                } else {
                }
                if (i5 == i7) {
                } else {
                }
                if (i6 == i7) {
                } else {
                }
                i3 += i2;
                charAt2 = i7;
                i3 += i2;
                i6 = i9;
                i3 += i2;
                i5 = i9;
                i3 += i2;
                i = i9;
            }
            if (i6 == i7) {
                i3 += 10;
            }
            if (i5 == i7) {
                i3 += 100;
            }
            if (i == i7) {
                i3 += 1000;
            }
            return i3;
        }

        @Override // net.time4j.g1.j
        public String toNumeral(int i) {
            int i2;
            int charAt;
            int i4;
            int i3;
            int obj7;
            int i5 = 1;
            if (i < i5) {
            } else {
                if (i > 9999) {
                } else {
                    String digits = getDigits();
                    charAt = i / 1000;
                    i %= 1000;
                    i4 = obj7 / 100;
                    obj7 %= 100;
                    i3 = obj7 / 10;
                    obj7 %= 10;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    if (charAt >= i5 && charAt > i5) {
                        if (charAt > i5) {
                            stringBuilder2.append(digits.charAt(charAt -= i5));
                        }
                        stringBuilder2.append('\u5343');
                    }
                    if (i4 >= i5 && i4 > i5) {
                        if (i4 > i5) {
                            stringBuilder2.append(digits.charAt(i4 -= i5));
                        }
                        stringBuilder2.append('\u767e');
                    }
                    if (i3 >= i5 && i3 > i5) {
                        if (i3 > i5) {
                            stringBuilder2.append(digits.charAt(i3 -= i5));
                        }
                        stringBuilder2.append('\u5341');
                    }
                    if (obj7 > 0) {
                        stringBuilder2.append(digits.charAt(obj7 -= i5));
                    }
                    return stringBuilder2.toString();
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot convert: ");
            stringBuilder.append(i);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
    }
    static int[] access$100() {
        return j.D_FACTORS;
    }

    static int access$200(int i, int i2, int i3) {
        return j.addEthiopic(i, i2, i3);
    }

    static int[] access$300() {
        return j.NUMBERS;
    }

    static String[] access$400() {
        return j.LETTERS;
    }

    static int access$500(char c) {
        return j.getValue(c);
    }

    static boolean access$600(char c, char c2) {
        return j.isValidRomanCombination(c, c2);
    }

    private static int addEthiopic(int i, int i2, int i3) {
        return c.e(i, c.h(i2, i3));
    }

    private static int getValue(char c) {
        if (c != 67 && c != 68 && c != 73 && c != 86 && c != 88 && c != 76) {
            if (c != 68) {
                if (c != 73) {
                    if (c != 86) {
                        if (c != 88) {
                            if (c != 76) {
                                if (c != 77) {
                                } else {
                                    return 1000;
                                }
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Invalid Roman digit: ");
                                stringBuilder.append(c);
                                NumberFormatException numberFormatException = new NumberFormatException(stringBuilder.toString());
                                throw numberFormatException;
                            }
                            return 50;
                        }
                        return 10;
                    }
                    return 5;
                }
                return 1;
            }
            return 500;
        }
        return 100;
    }

    private static boolean isValidRomanCombination(char c, char c2) {
        int i;
        int obj5;
        final int i2 = 67;
        i = 1;
        final int i3 = 0;
        final int i5 = 88;
        if (c != i2 && c != 73 && c != i5) {
            i5 = 88;
            if (c != 73) {
                if (c != i5) {
                    return i3;
                }
                if (c2 != i2) {
                    if (c2 == 76) {
                    } else {
                        i = i3;
                    }
                }
                return i;
            }
            if (c2 != i5) {
                if (c2 == 86) {
                } else {
                    i = i3;
                }
            }
            return i;
        }
        if (c2 != 77) {
            if (c2 == 68) {
            } else {
                i = i3;
            }
        }
        return i;
    }

    @Override // java.lang.Enum
    public boolean contains(char c) {
        int i;
        char charAt;
        final String digits = getDigits();
        final int i2 = 0;
        i = i2;
        while (i < digits.length()) {
            i++;
        }
        return i2;
    }

    @Override // java.lang.Enum
    public String getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public String getDigits() {
        AbstractMethodError abstractMethodError = new AbstractMethodError();
        throw abstractMethodError;
    }

    @Override // java.lang.Enum
    public boolean isDecimal() {
        AbstractMethodError abstractMethodError = new AbstractMethodError();
        throw abstractMethodError;
    }

    @Override // java.lang.Enum
    public final int toInteger(String string) {
        return toInteger(string, g.SMART);
    }

    @Override // java.lang.Enum
    public int toInteger(String string, net.time4j.g1.g g2) {
        int i;
        char c;
        if (!isDecimal()) {
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            while (i < string.length()) {
                stringBuilder3.append((char)i2);
                i++;
            }
            int obj6 = Integer.parseInt(stringBuilder3.toString());
            if (obj6 < 0) {
            } else {
                return obj6;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Cannot convert negative number: ");
            stringBuilder2.append(string);
            obj6 = new NumberFormatException(stringBuilder2.toString());
            throw obj6;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot convert: ");
        stringBuilder.append(string);
        obj6 = new NumberFormatException(stringBuilder.toString());
        throw obj6;
    }

    @Override // java.lang.Enum
    public int toNumeral(int i, java.lang.Appendable appendable2) {
        String obj1 = toNumeral(i);
        appendable2.append(obj1);
        return obj1.length();
    }

    @Override // java.lang.Enum
    public String toNumeral(int i) {
        int i2;
        char c;
        if (!isDecimal()) {
        } else {
            if (i < 0) {
            } else {
                String obj6 = Integer.toString(i);
                StringBuilder stringBuilder2 = new StringBuilder();
                while (i2 < obj6.length()) {
                    stringBuilder2.append((char)i4);
                    i2++;
                }
                return stringBuilder2.toString();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot convert: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}
