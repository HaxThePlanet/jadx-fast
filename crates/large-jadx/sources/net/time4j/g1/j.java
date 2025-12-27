package net.time4j.g1;

import android.app.ActivityManager.MemoryInfo;
import java.util.Locale;
import net.time4j.f1.c;

/* compiled from: NumberSystem.java */
/* loaded from: classes3.dex */
public enum j {

    ARABIC("latn") {
        @Override // net.time4j.g1.j
        public boolean contains(char c) {
            int i = 48;
            boolean z = false;
            i = 48;
            c = c >= 48 && c <= 57 ? 1 : 0;
            return (c >= 48 && c <= 57 ? 1 : 0);
        }

        @Override // net.time4j.g1.j
        public String getDigits() {
            return "0123456789";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.g1.j
        public int toInteger(String str, g gVar) {
            int parsed = Integer.parseInt(str);
            if (parsed < 0) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str2 = "Cannot convert negative number: ";
                str = str2 + str;
                throw new NumberFormatException(str);
            } else {
                return parsed;
            }
        }

        @Override // net.time4j.g1.j
        public String toNumeral(int i) {
            if (i < 0) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "Cannot convert: ";
                i = str + i;
                throw new IllegalArgumentException(i);
            } else {
                return Integer.toString(i);
            }
        }
    },
    ARABIC_INDIC("arab") {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "٠١٢٣٤٥٦٧٨٩";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return true;
        }
    },
    ARABIC_INDIC_EXT("arabext") {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "۰۱۲۳۴۵۶۷۸۹";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return true;
        }
    },
    BENGALI("beng") {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "০১২৩৪৫৬৭৮৯";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return true;
        }
    },
    DEVANAGARI("deva") {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "०१२३४५६७८९";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return true;
        }
    },
    DOZENAL("dozenal") {
        @Override // net.time4j.g1.j
        public boolean contains(char c) {
            int i = 8586;
            boolean z = true;
            i = 48;
            if (c < 48 || c > 57) {
                i = 8586;
                if (c == 8586 || c == 8587) {
                    int i2 = 1;
                }
            }
            return z;
        }

        @Override // net.time4j.g1.j
        public String getDigits() {
            return "0123456789↊↋";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return false;
        }

        @Override // net.time4j.g1.j
        public int toInteger(String str, g gVar) {
            int parsed = Integer.parseInt(str.replace('\u218a', 'a').replace('\u218b', 'b'), 12);
            if (parsed < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "Cannot convert negative number: ";
                str = str2 + str;
                throw new NumberFormatException(str);
            } else {
                return parsed;
            }
        }

        @Override // net.time4j.g1.j
        public int toNumeral(int i, java.lang.Appendable appendable) throws java.io.IOException {
            int i2 = 0;
            int i3;
            int i4 = 4;
            char c = 8587;
            int i6;
            if (i >= 0) {
                i2 = 0;
                i2 = 1;
                i4 = 4;
                while (i2 <= 4) {
                    if (i < j.D_FACTORS[i2]) {
                        break;
                    }
                }
                if (i2 > 0) {
                    i3 = i2 - 1;
                    int i8 = i6 / j.D_FACTORS[i3];
                    do {
                        i8 = i6 / j.access$100()[i3];
                        c = '\u218b';
                        appendable.append(c);
                        i4 = i8 * j.D_FACTORS[i3];
                        i6 = i6 - i4;
                        i3 = i3 - 1;
                        if (i3 - 1 < 0) {
                            return i2;
                        }
                    } while (j.D_FACTORS[i2] == 11);
                    return i2;
                }
            }
            return j.super.toNumeral(i, appendable);
        }

        @Override // net.time4j.g1.j
        public String toNumeral(int i) {
            if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str = "Cannot convert: ";
                i = str + i;
                throw new IllegalArgumentException(i);
            } else {
                return Integer.toString(i, 12).replace('a', '\u218a').replace('b', '\u218b');
            }
        }
    },
    ETHIOPIC("ethiopic") {
        @Override // net.time4j.g1.j
        public boolean contains(char c) {
            int i = 4969;
            boolean z = false;
            i = 4969;
            c = c >= 4969 && c <= 4988 ? 1 : 0;
            return (c >= 4969 && c <= 4988 ? 1 : 0);
        }

        @Override // net.time4j.g1.j
        public String getDigits() {
            return "፩፪፫፬፭፮፯፰፱፲፳፴፵፶፷፸፹፺፻፼";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return false;
        }

        @Override // net.time4j.g1.j
        public int toInteger(String str, g gVar) {
            int i = 1;
            int i2;
            char charAt;
            char c = 4969;
            char c2 = 4988;
            int i3;
            i = 1;
            i3 = str.length() - i;
            i = 0;
            while (i3 >= 0) {
                charAt = str.charAt(i3);
                c = '\u1369';
                c2 = '\u1372';
                i3 = i3 - 1;
            }
            if (i != 0 || i != 0) {
                if (i != 0) {
                }
            }
            return j.addEthiopic(i, i, i);
        }

        @Override // net.time4j.g1.j
        public String toNumeral(int i) {
            int i2;
            char c;
            char c2;
            char c3 = 4988;
            char c4 = 4987;
            String str2;
            int i4 = 1;
            if (i < i4) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "Can only convert positive numbers: ";
                i = str3 + i;
                throw new IllegalArgumentException(i);
            } else {
                str2 = String.valueOf(i);
                i2 = str2.length() - i4;
                i3 = i2 % 2;
                if (i2 % 2 == 0) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    str = "0";
                    str2 = str + str2;
                    i2 = i2 + 1;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                while (i2 >= 0) {
                    char charAt = str2.charAt(i2 - i2);
                    i2--;
                    char charAt2 = str2.charAt(i2 - i5);
                    char c6 = '0';
                    c2 = '\0';
                    c4 = '\u137b';
                    char c5 = '\u1369';
                    i2 = i5 - 1;
                }
                return stringBuilder2.toString();
            }
        }
    };

    private final String code;

    enum a extends j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "០១២៣៤៥៦៧៨៩";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return true;
        }
    }

    enum b extends j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "၀၁၂၃၄၅၆၇၈၉";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return true;
        }
    }

    enum c extends j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "୦୧୨୩୪୫୬୭୮୯";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return true;
        }
    }

    enum d extends j {
        @Override // net.time4j.g1.j
        public boolean contains(char c) {
            char c2 = 73;
            boolean z = true;
            char upperCase = Character.toUpperCase(c);
            c2 = 'I';
            if (upperCase == 'I' || !(upperCase == 'V' && upperCase == 'X' && upperCase == 'L' && upperCase == 'C' && upperCase == 'D' && upperCase != 'M')) {
                int i = 1;
            }
            return z;
        }

        @Override // net.time4j.g1.j
        public int toInteger(String str, g gVar) {
            int i = 0;
            char charAt;
            int i3 = 1;
            char charAt2;
            int i4;
            if (str.isEmpty()) {
                throw new NumberFormatException("Empty Roman numeral.");
            } else {
                String str2 = str.toUpperCase(Locale.US);
                boolean strict = gVar.isStrict();
                int length = str.length();
                i = 0;
                while (i < length) {
                    charAt = str2.charAt(i);
                    int i2 = j.getValue(charAt);
                    i = i + 1;
                    if (i + 1 != length) {
                        i3 = 1;
                    }
                }
                int i5 = 3999;
                if (i > 3999) {
                    throw new NumberFormatException("Roman numbers bigger than 3999 not supported.");
                } else {
                    if (strict && i >= 900) {
                        if (str2.contains("DCD")) {
                            throw new NumberFormatException("Roman number contains invalid sequence DCD.");
                        } else {
                            int i7 = 90;
                            if (i >= 90) {
                                if (str2.contains("LXL")) {
                                    throw new NumberFormatException("Roman number contains invalid sequence LXL.");
                                }
                            }
                            i5 = 9;
                            if (i >= 9) {
                                if (str2.contains("VIV")) {
                                    throw new NumberFormatException("Roman number contains invalid sequence VIV.");
                                }
                            }
                        }
                    }
                    return i;
                }
            }
        }

        @Override // net.time4j.g1.j
        public String toNumeral(int i) {
            int i3 = 0;
            int i5;
            int i2 = 1;
            if (i < 1) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str2 = "Out of range (1-3999): ";
                i = str2 + i;
                throw new IllegalArgumentException(i);
            } else {
                i2 = 3999;
                if (i <= 3999) {
                    StringBuilder stringBuilder = new StringBuilder();
                    i3 = 0;
                    length = j.NUMBERS.length;
                    while (i3 < j.access$300().length) {
                        while (i5 >= j.NUMBERS[i3]) {
                            stringBuilder.append(j.LETTERS[i3]);
                            i5 = i5 - j.NUMBERS[i3];
                        }
                        i3 = i3 + 1;
                        length = j.access$300().length;
                        stringBuilder.append(j.LETTERS[i3]);
                        i5 = i5 - j.NUMBERS[i3];
                    }
                    return stringBuilder.toString();
                }
            }
        }

        @Override // net.time4j.g1.j
        public String getDigits() {
            return "IVXLCDM";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return false;
        }
    }

    enum e extends j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "౦౧౨౩౪౫౬౭౮౯";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return true;
        }
    }

    enum f extends j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "๐๑๒๓๔๕๖๗๘๙";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return true;
        }
    }

    enum n extends j {
        @Override // net.time4j.g1.j
        public String getDigits() {
            return "૦૧૨૩૪૫૬૭૮૯";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return true;
        }
    }

    enum o extends j {
        @Override // net.time4j.g1.j
        public int toInteger(String str, g gVar) {
            int i;
            int i2;
            char charAt;
            char c = 21315;
            int i3;
            i2 = 1;
            i = str.length() - i2;
            i2 = 0;
            while (i >= 0) {
                charAt = str.charAt(i);
                c = '\u5341';
                str2 = "Invalid Japanese numeral: ";
                if (charAt != '\u5341') {
                    c = '\u5343';
                }
            }
            if (i2 == i2) {
                i2 = i2 + 10;
            }
            if (i2 == i2) {
                i2 = i2 + 100;
            }
            if (i2 == i2) {
                i2 = i2 + 1000;
            }
            return i2;
        }

        @Override // net.time4j.g1.j
        public String toNumeral(int i) {
            int i3 = 21315;
            int i4;
            int i5;
            int i7 = 1;
            if (i < i7) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Cannot convert: ";
                i = str + i;
                throw new IllegalArgumentException(i);
            } else {
                int i2 = 9999;
                if (i <= 9999) {
                    String digits = getDigits();
                    i3 = i / 1000;
                    i %= 1000;
                    i4 = i9 / 100;
                    int i10 = i9 % 100;
                    i5 = i10 / 10;
                    i6 = i10 % 10;
                    final StringBuilder stringBuilder2 = new StringBuilder();
                    if (i3 >= i7) {
                        if (i3 > i7) {
                            stringBuilder2.append(digits.charAt(i3 - i7));
                        }
                        stringBuilder2.append('\u5343');
                    }
                    if (i4 >= i7) {
                        if (i4 > i7) {
                            i4 = i4 - i7;
                            stringBuilder2.append(digits.charAt(i4));
                        }
                        stringBuilder2.append('\u767e');
                    }
                    if (i5 >= i7) {
                        if (i5 > i7) {
                            i5 = i5 - i7;
                            stringBuilder2.append(digits.charAt(i5));
                        }
                        stringBuilder2.append('\u5341');
                    }
                    if (i6 > 0) {
                        stringBuilder2.append(digits.charAt(i6 - i7));
                    }
                    return stringBuilder2.toString();
                }
            }
        }

        @Override // net.time4j.g1.j
        public String getDigits() {
            return "一二三四五六七八九十百千";
        }

        @Override // net.time4j.g1.j
        public boolean isDecimal() {
            return false;
        }
    }
    static /* synthetic */ int[] access$100() {
        return j.D_FACTORS;
    }

    static /* synthetic */ int access$200(int i, int i2, int i3) {
        return j.addEthiopic(i, i2, i3);
    }

    static /* synthetic */ int[] access$300() {
        return j.NUMBERS;
    }

    static /* synthetic */ String[] access$400() {
        return j.LETTERS;
    }

    static /* synthetic */ int access$500(char c) {
        return j.getValue(c);
    }

    static /* synthetic */ boolean access$600(char c, char c2) {
        return j.isValidRomanCombination(c, c2);
    }

    private static int addEthiopic(int i, int i2, int i3) {
        return c.e(i, c.h(i2, i3));
    }

    private static int getValue(char c) {
        if (c != 67 && c != 68) {
            if (c != 73 && c != 86) {
                if (c != 88 && c != 76) {
                    if (c != 77) {
                        final StringBuilder stringBuilder = new StringBuilder();
                        final String str = "Invalid Roman digit: ";
                        c = str + c;
                        throw new NumberFormatException(c);
                    } else {
                        return 1000;
                    }
                }
                return 10;
            }
            return 1;
        }
        return 100;
    }

    @Override // java.lang.Enum
    public boolean contains(char c) {
        int i;
        final String digits = getDigits();
        i = 0;
        while (i < digits.length()) {
            if (digits.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Enum
    public String getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public String getDigits() throws java.lang.AbstractMethodError {
        throw new AbstractMethodError();
    }

    @Override // java.lang.Enum
    public boolean isDecimal() throws java.lang.AbstractMethodError {
        throw new AbstractMethodError();
    }

    @Override // java.lang.Enum
    public final int toInteger(String str) {
        return toInteger(str, g.SMART);
    }

    @Override // java.lang.Enum
    public String toNumeral(int i) {
        int i2 = 0;
        if (!isDecimal()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Cannot convert: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            if (i >= 0) {
                i2 = 0;
                String integer = Integer.toString(i);
                StringBuilder stringBuilder2 = new StringBuilder();
                while (i2 < integer.length()) {
                    c = (char)(integer.charAt(i2) + (getDigits().charAt(i2) - 48));
                    stringBuilder2.append(c);
                    i2 = i2 + 1;
                }
                return stringBuilder2.toString();
            }
        }
    }

    @Override // java.lang.Enum
    public int toInteger(String str, g gVar) {
        int i = 0;
        if (!isDecimal()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Cannot convert: ";
            str = str2 + str;
            throw new NumberFormatException(str);
        } else {
            i = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            while (i < str.length()) {
                c = (char)(str.charAt(i) - (getDigits().charAt(i) - 48));
                stringBuilder3.append(c);
                i = i + 1;
            }
            int parsed = Integer.parseInt(stringBuilder3.toString());
            if (parsed < 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str3 = "Cannot convert negative number: ";
                str = str3 + str;
                throw new NumberFormatException(str);
            } else {
                return parsed;
            }
        }
    }

    @Override // java.lang.Enum
    public int toNumeral(int i, java.lang.Appendable appendable) throws java.io.IOException {
        String numeral = toNumeral(i);
        appendable.append(numeral);
        return numeral.length();
    }

    private static boolean isValidRomanCombination(char c, char c2) {
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        final int i5 = 67;
        int i6 = 1;
        final int i = 0;
        if (c != i5 && c != 73) {
            if (c != i8) {
                return false;
            }
            return z3;
        }
        int i2 = 77;
        return z;
    }
}
