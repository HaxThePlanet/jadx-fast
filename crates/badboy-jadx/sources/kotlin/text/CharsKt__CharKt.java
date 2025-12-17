package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u000c\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u000c\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\u0008\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\u000c\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u001a\u000c\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0007¨\u0006\u0010", d2 = {"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "titlecase", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharKt extends kotlin.text.CharsKt__CharJVMKt {
    public static final char digitToChar(int $this$digitToChar) {
        int i;
        int i2;
        i = 0;
        if ($this$digitToChar >= 0 && $this$digitToChar < 10) {
            if ($this$digitToChar < 10) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            return (char)i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Int ").append($this$digitToChar).append(" is not a decimal digit").toString());
        throw illegalArgumentException;
    }

    public static final char digitToChar(int $this$digitToChar, int radix) {
        int i2;
        char c;
        int i;
        i = 0;
        if (2 <= radix && radix < 37) {
            if (radix < 37) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            if ($this$digitToChar < 0) {
            } else {
                if ($this$digitToChar >= radix) {
                } else {
                    int i3 = 10;
                    if ($this$digitToChar < i3) {
                        c = (char)i4;
                    } else {
                        c = (char)i;
                    }
                    return c;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Digit ").append($this$digitToChar).append(" does not represent a valid digit in radix ").append(radix).toString());
            throw illegalArgumentException2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Invalid radix: ").append(radix).append(". Valid radix values are in range 2..36").toString());
        throw illegalArgumentException;
    }

    public static final int digitToInt(char $this$digitToInt) {
        int digitOf = CharsKt.digitOf($this$digitToInt, 10);
        final int i3 = 0;
        if (digitOf < 0) {
        } else {
            return digitOf;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Char ").append($this$digitToInt).append(" is not a decimal digit").toString());
        throw illegalArgumentException;
    }

    public static final int digitToInt(char $this$digitToInt, int radix) {
        Integer digitToIntOrNull = CharsKt.digitToIntOrNull($this$digitToInt, radix);
        if (digitToIntOrNull == null) {
        } else {
            return digitToIntOrNull.intValue();
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Char ").append($this$digitToInt).append(" is not a digit in the given radix=").append(radix).toString());
        throw illegalArgumentException;
    }

    public static final Integer digitToIntOrNull(char $this$digitToIntOrNull) {
        int valueOf;
        int i;
        final int i3 = 0;
        i = (Number)Integer.valueOf(CharsKt.digitOf($this$digitToIntOrNull, 10)).intValue() >= 0 ? 1 : 0;
        if (i != 0) {
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final Integer digitToIntOrNull(char $this$digitToIntOrNull, int radix) {
        int valueOf;
        int i;
        CharsKt.checkRadix(radix);
        final int i2 = 0;
        i = (Number)Integer.valueOf(CharsKt.digitOf($this$digitToIntOrNull, radix)).intValue() >= 0 ? 1 : 0;
        if (i != 0) {
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final boolean equals(char $this$equals, char other, boolean ignoreCase) {
        int i;
        char lowerCase;
        char lowerCase2;
        if ($this$equals == other) {
            return 1;
        }
        final int i2 = 0;
        if (!ignoreCase) {
            return i2;
        }
        final char upperCase = Character.toUpperCase($this$equals);
        final char upperCase2 = Character.toUpperCase(other);
        if (upperCase != upperCase2) {
            if (Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            } else {
                i = i2;
            }
        }
        return i;
    }

    public static boolean equals$default(char c, char c2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return CharsKt.equals(c, c2, obj2);
    }

    public static final boolean isSurrogate(char $this$isSurrogate) {
        int i2;
        int i;
        i = 0;
        if (55296 <= $this$isSurrogate && $this$isSurrogate < 57344) {
            if ($this$isSurrogate < 57344) {
                i = 1;
            }
        }
        return i;
    }

    private static final String plus(char $this$plus, String other) {
        Intrinsics.checkNotNullParameter(other, "other");
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append($this$plus).append(other).toString();
    }

    public static final String titlecase(char $this$titlecase) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl($this$titlecase);
    }
}
