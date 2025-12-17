package kotlinx.serialization.internal;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lkotlinx/serialization/internal/InternalHexConverter;", "", "<init>", "()V", "hexCode", "", "parseHexBinary", "", "s", "hexToInt", "", "ch", "", "printHexBinary", "data", "lowerCase", "", "toHexString", "n", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InternalHexConverter {

    public static final kotlinx.serialization.internal.InternalHexConverter INSTANCE = null;
    private static final String hexCode = "0123456789ABCDEF";
    static {
        InternalHexConverter internalHexConverter = new InternalHexConverter();
        InternalHexConverter.INSTANCE = internalHexConverter;
    }

    private final int hexToInt(char ch) {
        int i3;
        int i5;
        int i;
        int i2;
        int i4;
        int i6;
        int i7;
        i7 = 1;
        final int i10 = 0;
        if (48 <= ch && ch < 58) {
            i5 = ch < 58 ? i7 : i10;
        } else {
        }
        if (i5 != 0) {
            i6 = ch + -48;
        } else {
            if (65 <= ch && ch < 71) {
                i2 = ch < 71 ? i7 : i10;
            } else {
            }
            if (i2 != 0) {
                i8 += 10;
            } else {
                if (97 <= ch && ch < 103) {
                    if (ch < 103) {
                    } else {
                        i7 = i10;
                    }
                } else {
                }
                i6 = i7 != 0 ? i9 + 10 : -1;
            }
        }
        return i6;
    }

    public static String printHexBinary$default(kotlinx.serialization.internal.InternalHexConverter internalHexConverter, byte[] b2Arr2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return internalHexConverter.printHexBinary(b2Arr2, obj2);
    }

    public final byte[] parseHexBinary(String s) {
        int i4;
        int i3;
        int hexToInt2;
        int hexToInt;
        int i;
        int i2;
        byte b;
        Intrinsics.checkNotNullParameter(s, "s");
        int length = s.length();
        int i7 = 0;
        int i9 = 1;
        i4 = length % 2 == 0 ? i9 : i7;
        if (i4 == 0) {
        } else {
            byte[] bArr = new byte[length / 2];
            i3 = 0;
            while (i3 < length) {
                hexToInt2 = hexToInt(s.charAt(i3));
                hexToInt = hexToInt(s.charAt(i3 + 1));
                int i11 = -1;
                if (hexToInt2 != i11 && hexToInt != i11) {
                } else {
                }
                i2 = i7;
                bArr[i3 / 2] = (byte)i14;
                i3 += 2;
                if (hexToInt != i11) {
                } else {
                }
                i2 = i9;
            }
            return bArr;
        }
        int bytes = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("HexBinary string must be even length".toString());
        throw illegalArgumentException;
    }

    public final String printHexBinary(byte[] data, boolean lowerCase) {
        String lowerCase2;
        int i;
        String string;
        byte b;
        char charAt;
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        StringBuilder stringBuilder = new StringBuilder(length *= 2);
        i = 0;
        while (i < data.length) {
            b = data[i];
            str = "0123456789ABCDEF";
            stringBuilder.append(str.charAt(i3 &= 15));
            stringBuilder.append(str.charAt(b & 15));
            i++;
        }
        string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (lowerCase) {
            Intrinsics.checkNotNullExpressionValue(string.toLowerCase(Locale.ROOT), "toLowerCase(...)");
        } else {
            lowerCase2 = string;
        }
        return lowerCase2;
    }

    public final String toHexString(int n) {
        int i;
        int i2;
        String trimStart;
        byte b;
        int i3 = 4;
        final byte[] bArr = new byte[i3];
        i2 = 0;
        while (i2 < i3) {
            bArr[i2] = (byte)i6;
            i2++;
        }
        i = 1;
        char[] cArr = new char[i];
        final int i9 = 0;
        cArr[i9] = 48;
        int i8 = 0;
        if ((CharSequence)StringsKt.trimStart(printHexBinary(bArr, i), cArr).length() > 0) {
        } else {
            i = i9;
        }
        if (i != 0) {
        } else {
            trimStart = 0;
        }
        if (trimStart == null) {
            trimStart = "0";
        }
        return trimStart;
    }
}
