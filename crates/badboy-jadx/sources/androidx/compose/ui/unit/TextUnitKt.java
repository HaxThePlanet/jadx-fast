package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u001a \u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000c2\u0006\u0010 \u001a\u00020!ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#\u001a\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\u0008'\u0010\u0015\u001a\"\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\u001a*\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-\u001a*\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u000cH\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u00103\u001a\u001d\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u000cH\u0001¢\u0006\u0002\u00107\u001a%\u00108\u001a\u00020\u0006*\u00020\u00062\u000c\u00109\u001a\u0008\u0012\u0004\u0012\u00020\u00060:H\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<\u001a\u001f\u0010=\u001a\u00020\u0006*\u00020\u00072\u0006\u0010>\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008?\u0010@\u001a\u001f\u0010=\u001a\u00020\u0006*\u00020\u000c2\u0006\u0010>\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008?\u0010#\u001a\u001f\u0010=\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010>\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008?\u0010A\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000b\"\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u000c8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\r\u001a\u0004\u0008\n\u0010\u000e\"\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\u0010\u001a\u0004\u0008\n\u0010\u0011\"\u001f\u0010\u0012\u001a\u00020\u0013*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0016\u0010\u0017\"\u001e\u0010\u0018\u001a\u00020\u0013*\u00020\u00068FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0019\u0010\u0015\u001a\u0004\u0008\u001a\u0010\u0017\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001c\u0010\t\u001a\u0004\u0008\u001d\u0010\u000b\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020\u000c8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001c\u0010\r\u001a\u0004\u0008\u001d\u0010\u000e\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020\u000f8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001c\u0010\u0010\u001a\u0004\u0008\u001d\u0010\u0011\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006B", d2 = {"UNIT_MASK", "", "UNIT_TYPE_EM", "UNIT_TYPE_SP", "UNIT_TYPE_UNSPECIFIED", "em", "Landroidx/compose/ui/unit/TextUnit;", "", "getEm$annotations", "(D)V", "getEm", "(D)J", "", "(F)V", "(F)J", "", "(I)V", "(I)J", "isSpecified", "", "isSpecified--R2X_6o$annotations", "(J)V", "isSpecified--R2X_6o", "(J)Z", "isUnspecified", "isUnspecified--R2X_6o$annotations", "isUnspecified--R2X_6o", "sp", "getSp$annotations", "getSp", "TextUnit", "value", "type", "Landroidx/compose/ui/unit/TextUnitType;", "TextUnit-anM5pPY", "(FJ)J", "checkArithmetic", "", "a", "checkArithmetic--R2X_6o", "b", "checkArithmetic-NB67dxo", "(JJ)V", "c", "checkArithmetic-vU-0ePk", "(JJJ)V", "lerp", "start", "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "pack", "unitType", "v", "(JF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-eAf_CNQ", "(JLkotlin/jvm/functions/Function0;)J", "times", "other", "times-mpE4wyQ", "(DJ)J", "(IJ)J", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextUnitKt {

    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED;
    public static final long TextUnit-anM5pPY(float value, long type) {
        return TextUnitKt.pack(type, obj4);
    }

    public static final void checkArithmetic--R2X_6o(long a) {
        if (TextUnitKt.isUnspecified--R2X_6o(a)) {
        } else {
        }
        int i = 0;
        IllegalArgumentException $i$a$RequireTextUnitKt$checkArithmetic$1 = new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        throw $i$a$RequireTextUnitKt$checkArithmetic$1;
    }

    public static final void checkArithmetic-NB67dxo(long a, long b) {
        boolean unspecified--R2X_6o;
        int i;
        if (!TextUnitKt.isUnspecified--R2X_6o(a) && !TextUnitKt.isUnspecified--R2X_6o(obj6)) {
            i = !TextUnitKt.isUnspecified--R2X_6o(obj6) ? 1 : 0;
        } else {
        }
        if (i == 0) {
        } else {
            if (!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(a), obj1)) {
            } else {
            }
            int i2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot perform operation for ").append(TextUnitType.toString-impl(TextUnit.getType-UIouoOA(a))).append(" and ").append(TextUnitType.toString-impl(TextUnit.getType-UIouoOA(obj6))).toString().toString());
            throw illegalArgumentException;
        }
        int i3 = 0;
        IllegalArgumentException $i$a$RequireTextUnitKt$checkArithmetic$2 = new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        throw $i$a$RequireTextUnitKt$checkArithmetic$2;
    }

    public static final void checkArithmetic-vU-0ePk(long a, long b, long c) {
        int i;
        boolean equals-impl0;
        boolean unspecified--R2X_6o;
        int i2;
        long type-UIouoOA;
        long type-UIouoOA2;
        int i5 = 0;
        if (!TextUnitKt.isUnspecified--R2X_6o(a) && !TextUnitKt.isUnspecified--R2X_6o(c) && !TextUnitKt.isUnspecified--R2X_6o(obj11)) {
            if (!TextUnitKt.isUnspecified--R2X_6o(c)) {
                i = !TextUnitKt.isUnspecified--R2X_6o(obj11) ? i2 : i5;
            } else {
            }
        } else {
        }
        if (i == 0) {
        } else {
            if (TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(a), obj4) && TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(c), obj4)) {
                if (TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(c), obj4)) {
                } else {
                    i2 = i5;
                }
            } else {
            }
            if (i2 == 0) {
            } else {
            }
            int i3 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot perform operation for ").append(TextUnitType.toString-impl(TextUnit.getType-UIouoOA(a))).append(" and ").append(TextUnitType.toString-impl(TextUnit.getType-UIouoOA(c))).toString().toString());
            throw illegalArgumentException;
        }
        int i4 = 0;
        IllegalArgumentException $i$a$RequireTextUnitKt$checkArithmetic$4 = new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        throw $i$a$RequireTextUnitKt$checkArithmetic$4;
    }

    public static final long getEm(double $this$em) {
        return TextUnitKt.pack(8589934592L, obj1);
    }

    public static final long getEm(float $this$em) {
        return TextUnitKt.pack(8589934592L, obj1);
    }

    public static final long getEm(int $this$em) {
        return TextUnitKt.pack(8589934592L, obj1);
    }

    public static void getEm$annotations(double d) {
    }

    public static void getEm$annotations(float f) {
    }

    public static void getEm$annotations(int i) {
    }

    public static final long getSp(double $this$sp) {
        return TextUnitKt.pack(4294967296L, obj1);
    }

    public static final long getSp(float $this$sp) {
        return TextUnitKt.pack(4294967296L, obj1);
    }

    public static final long getSp(int $this$sp) {
        return TextUnitKt.pack(4294967296L, obj1);
    }

    public static void getSp$annotations(double d) {
    }

    public static void getSp$annotations(float f) {
    }

    public static void getSp$annotations(int i) {
    }

    public static final boolean isSpecified--R2X_6o(long $this$isSpecified) {
        final int i = 0;
        return unspecified--R2X_6o ^= 1;
    }

    public static void isSpecified--R2X_6o$annotations(long l) {
    }

    public static final boolean isUnspecified--R2X_6o(long $this$isUnspecified) {
        int i;
        i = Long.compare(rawType-impl, i2) == 0 ? 1 : 0;
        return i;
    }

    public static void isUnspecified--R2X_6o$annotations(long l) {
    }

    public static final long lerp-C3pnCVY(long start, long stop, float fraction) {
        TextUnitKt.checkArithmetic-NB67dxo(start, stop);
        return TextUnitKt.pack(TextUnit.getRawType-impl(start), obj1);
    }

    public static final long pack(long unitType, float v) {
        return TextUnit.constructor-impl(i |= unitType);
    }

    public static final long takeOrElse-eAf_CNQ(long $this$takeOrElse_u2deAf_CNQ, Function0<androidx.compose.ui.unit.TextUnit> block) {
        long unbox-impl;
        final int i = 0;
        final int i2 = 0;
        if (!TextUnitKt.isUnspecified--R2X_6o($this$takeOrElse_u2deAf_CNQ)) {
            unbox-impl = $this$takeOrElse_u2deAf_CNQ;
        } else {
            unbox-impl = (TextUnit)obj7.invoke().unbox-impl();
        }
        return unbox-impl;
    }

    public static final long times-mpE4wyQ(double $this$times_u2dmpE4wyQ, long other) {
        final int i = 0;
        TextUnitKt.checkArithmetic--R2X_6o(obj7);
        return TextUnitKt.pack(TextUnit.getRawType-impl(obj7), obj2);
    }

    public static final long times-mpE4wyQ(float $this$times_u2dmpE4wyQ, long other) {
        final int i = 0;
        TextUnitKt.checkArithmetic--R2X_6o(other);
        return TextUnitKt.pack(TextUnit.getRawType-impl(other), obj2);
    }

    public static final long times-mpE4wyQ(int $this$times_u2dmpE4wyQ, long other) {
        final int i = 0;
        TextUnitKt.checkArithmetic--R2X_6o(other);
        return TextUnitKt.pack(TextUnit.getRawType-impl(other), obj2);
    }
}
