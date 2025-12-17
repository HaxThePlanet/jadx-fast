package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\n\n\u0002\u0008\r\u001a\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0080\u0008\u001a\u0011\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0017H\u0080\u0008\u001a\"\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a\"\u0010 \u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\u001f\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0017H\u0082\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\"\u0010\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006$", d2 = {"Fp16Combined", "", "Fp16ExponentBias", "Fp16ExponentMask", "Fp16ExponentMax", "Fp16ExponentShift", "Fp16SignMask", "Fp16SignShift", "Fp16SignificandMask", "Fp32DenormalFloat", "", "Fp32DenormalMagic", "Fp32ExponentBias", "Fp32ExponentMask", "Fp32ExponentShift", "Fp32QNaNMask", "Fp32SignShift", "Fp32SignificandMask", "NegativeOne", "Landroidx/compose/ui/graphics/Float16;", "S", "One", "floatToHalf", "", "f", "halfToFloat", "h", "max", "x", "y", "max-AoSsdG0", "(SS)S", "min", "min-AoSsdG0", "toCompareValue", "value", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Float16Kt {

    private static final int Fp16Combined = 32767;
    private static final int Fp16ExponentBias = 15;
    private static final int Fp16ExponentMask = 31;
    private static final int Fp16ExponentMax = 31744;
    private static final int Fp16ExponentShift = 10;
    private static final int Fp16SignMask = 32768;
    private static final int Fp16SignShift = 15;
    private static final int Fp16SignificandMask = 1023;
    private static final float Fp32DenormalFloat = 0f;
    private static final int Fp32DenormalMagic = 1056964608;
    private static final int Fp32ExponentBias = 127;
    private static final int Fp32ExponentMask = 255;
    private static final int Fp32ExponentShift = 23;
    private static final int Fp32QNaNMask = 4194304;
    private static final int Fp32SignShift = 31;
    private static final int Fp32SignificandMask = 8388607;
    private static final short NegativeOne;
    private static final short One;
    static {
        Float16Kt.One = Float16.constructor-impl(1065353216);
        Float16Kt.NegativeOne = Float16.constructor-impl(-1082130432);
        final int i4 = 0;
        Float16Kt.Fp32DenormalFloat = Float.intBitsToFloat(1056964608);
    }

    public static final float access$getFp32DenormalFloat$p() {
        return Float16Kt.Fp32DenormalFloat;
    }

    public static final short access$getNegativeOne$p() {
        return Float16Kt.NegativeOne;
    }

    public static final short access$getOne$p() {
        return Float16Kt.One;
    }

    public static final short floatToHalf(float f) {
        int e;
        int m;
        int i;
        int outE;
        int outM;
        int i2;
        final int i3 = 0;
        final int floatToRawIntBits = Float.floatToRawIntBits(f);
        final int i4 = floatToRawIntBits >>> 31;
        int i6 = 255;
        i5 &= i6;
        i14 &= floatToRawIntBits;
        outE = 0;
        outM = 0;
        if (e == i6) {
            outE = 31;
            m = i != 0 ? 512 : 0;
            outM = m;
        } else {
            e = i9 + 15;
            if (e >= 31) {
                outE = 49;
            } else {
                if (e <= 0) {
                    i13 >>= i2;
                    if (e >= -10 && m & 4096 != 0) {
                        i13 >>= i2;
                        if (m & 4096 != 0) {
                            m += 8192;
                        }
                        outM = i >> 13;
                    }
                } else {
                    if (i & 4096 != 0) {
                        return (short)i17;
                    }
                }
            }
        }
        return (short)i8;
    }

    public static final float halfToFloat(short h) {
        int i;
        int outE;
        int outM;
        int i2;
        final int i3 = 0;
        i4 &= h;
        i6 &= i5;
        i = 31;
        i8 &= i;
        final int i15 = i5 & 1023;
        outE = 0;
        outM = 0;
        if (i9 == 0) {
            if (i15 != 0) {
                int i18 = 0;
                bits$iv -= f;
                i2 = i7 == 0 ? o : -o;
                return i2;
            }
        } else {
            outM = i15 << 13;
            if (i9 == i) {
                outE = 255;
                if (outM != 0) {
                    outM |= i;
                }
            } else {
                outE = i + 127;
            }
        }
        int i17 = 0;
        return Float.intBitsToFloat(i11 |= outM);
    }

    public static final short max-AoSsdG0(short x, short y) {
        boolean naN-impl;
        short s;
        if (!Float16.isNaN-impl(x)) {
            if (Float16.isNaN-impl(y)) {
            } else {
                s = Float16.compareTo-41bOqos(x, y) >= 0 ? x : y;
            }
            return s;
        }
        return Float16.Companion.getNaN-slo4al4();
    }

    public static final short min-AoSsdG0(short x, short y) {
        boolean naN-impl;
        short s;
        if (!Float16.isNaN-impl(x)) {
            if (Float16.isNaN-impl(y)) {
            } else {
                s = Float16.compareTo-41bOqos(x, y) <= 0 ? x : y;
            }
            return s;
        }
        return Float16.Companion.getNaN-slo4al4();
    }

    private static final int toCompareValue(short value) {
        int i;
        int i2;
        final int i3 = 0;
        int i4 = 32768;
        final int i5 = 65535;
        i = value & i4 != 0 ? i4 - i2 : value & i5;
        return i;
    }
}
