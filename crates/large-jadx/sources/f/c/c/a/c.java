package f.c.c.a;

/* compiled from: MathPreconditions.java */
/* loaded from: classes2.dex */
final class c {
    static void a(boolean z, String str, long j, long j2) {
        if (!z) {
            int i = String.valueOf(str).length() + 54;
            final StringBuilder stringBuilder = new StringBuilder(i);
            String str3 = "overflow: ";
            String str4 = "(";
            String str5 = ", ";
            String str6 = ")";
            str = i + str3 + str + str4 + j + str5 + j2 + str6;
            throw new ArithmeticException(str);
        }
    }

    static int b(String str, int i) {
        if (i <= 0) {
            i = String.valueOf(str).length() + 26;
            final StringBuilder stringBuilder = new StringBuilder(i);
            String str3 = " (";
            String str4 = ") must be > 0";
            str = i + str + str3 + i + str4;
            throw new IllegalArgumentException(str);
        } else {
            return i;
        }
    }

    static void c(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
