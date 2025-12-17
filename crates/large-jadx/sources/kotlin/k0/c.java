package kotlin.k0;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u000c\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u000c\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\u0008\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\u000c\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u001a\u000c\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0007¨\u0006\u0010", d2 = {"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "titlecase", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/CharsKt")
class c extends kotlin.k0.b {
    public static int d(char c) {
        int i2 = b.b(c, 10);
        if (i2 < 0) {
        } else {
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Char ");
        stringBuilder.append(c);
        stringBuilder.append(" is not a decimal digit");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static final boolean e(char c, char c2, boolean z3) {
        int i;
        char obj2;
        char obj3;
        if (c == c2) {
            return 1;
        }
        final int i2 = 0;
        if (!z3) {
            return i2;
        }
        obj2 = Character.toUpperCase(c);
        obj3 = Character.toUpperCase(c2);
        if (obj2 != obj3) {
            if (Character.toLowerCase(obj2) == Character.toLowerCase(obj3)) {
            } else {
                i = i2;
            }
        }
        return i;
    }
}
