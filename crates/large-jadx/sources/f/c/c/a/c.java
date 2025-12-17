package f.c.c.a;

/* loaded from: classes2.dex */
final class c {
    static void a(boolean z, String string2, long l3, long l4) {
        if (!z) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder(length += 54);
        stringBuilder.append("overflow: ");
        stringBuilder.append(string2);
        stringBuilder.append("(");
        stringBuilder.append(l3);
        stringBuilder.append(", ");
        stringBuilder.append(obj6);
        stringBuilder.append(")");
        ArithmeticException obj2 = new ArithmeticException(stringBuilder.toString());
        throw obj2;
    }

    static int b(String string, int i2) {
        if (i2 <= 0) {
        } else {
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder(length += 26);
        stringBuilder.append(string);
        stringBuilder.append(" (");
        stringBuilder.append(i2);
        stringBuilder.append(") must be > 0");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    static void c(boolean z) {
        if (!z) {
        } else {
        }
        ArithmeticException obj1 = new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        throw obj1;
    }
}
