package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0010\n\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0014\n\u0002\u0010\u0005\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u000f\u0008\u0081@\u0018\u0000 R2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001RB\u0011\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005B\u0011\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\u0008\u0004\u0010\u0007B\u000f\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0004\u0008\u0004\u0010\nJ\u0013\u0010\u0015\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\nJ\u0013\u0010\u0017\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\nJ\u001b\u0010\u0019\u001a\u00020\u000c2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\u0008 \u0010!J\u0013\u0010\"\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008#\u0010\nJ\u0010\u0010$\u001a\u00020\u000cHÖ\u0001¢\u0006\u0004\u0008%\u0010\u000eJ\r\u0010&\u001a\u00020\u001e¢\u0006\u0004\u0008'\u0010(J\r\u0010)\u001a\u00020\u001e¢\u0006\u0004\u0008*\u0010(J\r\u0010+\u001a\u00020\u001e¢\u0006\u0004\u0008,\u0010(J\r\u0010-\u001a\u00020\u001e¢\u0006\u0004\u0008.\u0010(J\u0013\u0010/\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00080\u0010\nJ\r\u00101\u001a\u00020\u000c¢\u0006\u0004\u00082\u0010\u000eJ\r\u00103\u001a\u000204¢\u0006\u0004\u00085\u00106J\r\u00107\u001a\u00020\u0006¢\u0006\u0004\u00088\u00109J\r\u0010:\u001a\u00020\u0003¢\u0006\u0004\u0008;\u0010<J\r\u0010=\u001a\u00020>¢\u0006\u0004\u0008?\u0010@J\r\u0010A\u001a\u00020\u000c¢\u0006\u0004\u0008B\u0010\u000eJ\r\u0010C\u001a\u00020D¢\u0006\u0004\u0008E\u0010FJ\r\u0010G\u001a\u00020\u000c¢\u0006\u0004\u0008H\u0010\u000eJ\r\u0010I\u001a\u00020\t¢\u0006\u0004\u0008J\u0010\nJ\u000f\u0010K\u001a\u00020>H\u0016¢\u0006\u0004\u0008L\u0010@J\u0013\u0010M\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008N\u0010\nJ\u0018\u0010O\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\u0008P\u0010QR\u0011\u0010\u000b\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u000e\u0088\u0001\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006S", d2 = {"Landroidx/compose/ui/graphics/Float16;", "", "value", "", "constructor-impl", "(F)S", "", "(D)S", "halfValue", "", "(S)S", "exponent", "", "getExponent-impl", "(S)I", "getHalfValue", "()S", "sign", "getSign-slo4al4", "significand", "getSignificand-impl", "absoluteValue", "absoluteValue-slo4al4", "ceil", "ceil-slo4al4", "compareTo", "other", "compareTo-41bOqos", "(SS)I", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floor", "floor-slo4al4", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(S)Z", "isInfinite", "isInfinite-impl", "isNaN", "isNaN-impl", "isNormalized", "isNormalized-impl", "round", "round-slo4al4", "toBits", "toBits-impl", "toByte", "", "toByte-impl", "(S)B", "toDouble", "toDouble-impl", "(S)D", "toFloat", "toFloat-impl", "(S)F", "toHexString", "", "toHexString-impl", "(S)Ljava/lang/String;", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toRawBits", "toRawBits-impl", "toShort", "toShort-impl", "toString", "toString-impl", "trunc", "trunc-slo4al4", "withSign", "withSign-qCeQghg", "(SS)S", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Float16 implements Comparable<androidx.compose.ui.graphics.Float16> {

    public static final androidx.compose.ui.graphics.Float16.Companion Companion = null;
    private static final short Epsilon = (short) 0;
    private static final short LowestValue = (short) 0;
    public static final int MaxExponent = 15;
    private static final short MaxValue = (short) 0;
    public static final int MinExponent = -14;
    private static final short MinNormal = (short) 0;
    private static final short MinValue = (short) 0;
    private static final short NaN = (short) 0;
    private static final short NegativeInfinity = (short) 0;
    private static final short NegativeZero = (short) 0;
    private static final short PositiveInfinity = (short) 0;
    private static final short PositiveZero = (short) 0;
    public static final int Size = 16;
    private final short halfValue;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0013\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0010\u0010\u0006R\u0019\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0012\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0014\u0010\u0006R\u0019\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0016\u0010\u0006R\u0019\u0010\u0017\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0018\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u001a\u0010\u0006R\u0019\u0010\u001b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u001c\u0010\u0006R\u000e\u0010\u001d\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001e", d2 = {"Landroidx/compose/ui/graphics/Float16$Companion;", "", "()V", "Epsilon", "Landroidx/compose/ui/graphics/Float16;", "getEpsilon-slo4al4", "()S", "S", "LowestValue", "getLowestValue-slo4al4", "MaxExponent", "", "MaxValue", "getMaxValue-slo4al4", "MinExponent", "MinNormal", "getMinNormal-slo4al4", "MinValue", "getMinValue-slo4al4", "NaN", "getNaN-slo4al4", "NegativeInfinity", "getNegativeInfinity-slo4al4", "NegativeZero", "getNegativeZero-slo4al4", "PositiveInfinity", "getPositiveInfinity-slo4al4", "PositiveZero", "getPositiveZero-slo4al4", "Size", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final short getEpsilon-slo4al4() {
            return Float16.access$getEpsilon$cp();
        }

        public final short getLowestValue-slo4al4() {
            return Float16.access$getLowestValue$cp();
        }

        public final short getMaxValue-slo4al4() {
            return Float16.access$getMaxValue$cp();
        }

        public final short getMinNormal-slo4al4() {
            return Float16.access$getMinNormal$cp();
        }

        public final short getMinValue-slo4al4() {
            return Float16.access$getMinValue$cp();
        }

        public final short getNaN-slo4al4() {
            return Float16.access$getNaN$cp();
        }

        public final short getNegativeInfinity-slo4al4() {
            return Float16.access$getNegativeInfinity$cp();
        }

        public final short getNegativeZero-slo4al4() {
            return Float16.access$getNegativeZero$cp();
        }

        public final short getPositiveInfinity-slo4al4() {
            return Float16.access$getPositiveInfinity$cp();
        }

        public final short getPositiveZero-slo4al4() {
            return Float16.access$getPositiveZero$cp();
        }
    }
    static {
        Float16.Companion companion = new Float16.Companion(0);
        Float16.Companion = companion;
        Float16.Epsilon = Float16.constructor-impl(5120);
        Float16.LowestValue = Float16.constructor-impl(-1025);
        Float16.MaxValue = Float16.constructor-impl(31743);
        Float16.MinNormal = Float16.constructor-impl(1024);
        Float16.MinValue = Float16.constructor-impl(1);
        Float16.NaN = Float16.constructor-impl(32256);
        Float16.NegativeInfinity = Float16.constructor-impl(-1024);
        Float16.NegativeZero = Float16.constructor-impl(-32768);
        Float16.PositiveInfinity = Float16.constructor-impl(31744);
        Float16.PositiveZero = Float16.constructor-impl(0);
    }

    private Float16(short halfValue) {
        super();
        this.halfValue = halfValue;
    }

    public static final short absoluteValue-slo4al4(short arg0) {
        return Float16.constructor-impl((short)i);
    }

    public static final short access$getEpsilon$cp() {
        return Float16.Epsilon;
    }

    public static final short access$getLowestValue$cp() {
        return Float16.LowestValue;
    }

    public static final short access$getMaxValue$cp() {
        return Float16.MaxValue;
    }

    public static final short access$getMinNormal$cp() {
        return Float16.MinNormal;
    }

    public static final short access$getMinValue$cp() {
        return Float16.MinValue;
    }

    public static final short access$getNaN$cp() {
        return Float16.NaN;
    }

    public static final short access$getNegativeInfinity$cp() {
        return Float16.NegativeInfinity;
    }

    public static final short access$getNegativeZero$cp() {
        return Float16.NegativeZero;
    }

    public static final short access$getPositiveInfinity$cp() {
        return Float16.PositiveInfinity;
    }

    public static final short access$getPositiveZero$cp() {
        return Float16.PositiveZero;
    }

    public static final androidx.compose.ui.graphics.Float16 box-impl(short s) {
        Float16 float16 = new Float16(s);
        return float16;
    }

    public static final short ceil-slo4al4(short arg0) {
        int e;
        int result;
        int i2;
        int i3;
        int i;
        i4 &= arg0;
        e = i5 & 32767;
        result = i5;
        i2 = 1;
        i3 = 15360;
        if (e < i3) {
            if (e != 0) {
            } else {
                i2 = 0;
            }
            result3 |= i2;
        } else {
            if (e < 25600) {
                i10 -= i2;
                result2 &= i2;
            }
        }
        return Float16.constructor-impl((short)result);
    }

    public static int compareTo-41bOqos(short arg0, short other) {
        int i3;
        int i;
        int i2;
        if (Float16.isNaN-impl(arg0)) {
            return naN-impl3 ^= 1;
        }
        if (Float16.isNaN-impl(other)) {
            return -1;
        }
        short s = arg0;
        int i6 = 0;
        int i8 = 32768;
        i2 = 65535;
        i = s & i8 != 0 ? i8 - i10 : s & i2;
        short value$iv = other;
        int i7 = 0;
        i3 = value$iv & i8 != 0 ? i8 - i2 : value$iv & i2;
        return Intrinsics.compare(i, i3);
    }

    public static short constructor-impl(double value) {
        return Float16.constructor-impl((float)value);
    }

    public static short constructor-impl(float value) {
        int e$iv;
        int m$iv;
        int out$iv;
        int i;
        int outE$iv;
        int outM$iv;
        int i2;
        short s;
        int i3 = 0;
        final int floatToRawIntBits = Float.floatToRawIntBits(value);
        final int i4 = floatToRawIntBits >>> 31;
        int i6 = 255;
        i5 &= i6;
        i13 &= floatToRawIntBits;
        outE$iv = 0;
        outM$iv = 0;
        if (e$iv == i6) {
            outE$iv = 31;
            m$iv = i != 0 ? 512 : 0;
            outM$iv = m$iv;
            s = (short)out$iv;
        } else {
            e$iv = i8 + 15;
            if (e$iv >= 31) {
                outE$iv = 49;
            } else {
                if (e$iv <= 0) {
                    i12 >>= i2;
                    if (e$iv >= -10 && m$iv & 4096 != 0) {
                        i12 >>= i2;
                        if (m$iv & 4096 != 0) {
                            m$iv += 8192;
                        }
                        outM$iv = i >> 13;
                    }
                } else {
                    if (i & 4096 != 0) {
                        s = (short)i16;
                    } else {
                    }
                }
            }
        }
        return Float16.constructor-impl(s);
    }

    public static short constructor-impl(short s) {
        return s;
    }

    public static boolean equals-impl(short s, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof Float16) {
            return i2;
        }
        if (s != (Float16)object2.unbox-impl()) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(short s, short s2) {
        int i;
        i = s == s2 ? 1 : 0;
        return i;
    }

    public static final short floor-slo4al4(short arg0) {
        int i4;
        int i;
        int e;
        int result;
        int i2;
        int i3;
        final int i10 = arg0 & i;
        e = i10 & 32767;
        result = i10;
        i2 = 15360;
        if (e < i2) {
            i3 = 32768;
            if (i10 > i3) {
            } else {
                i = 0;
            }
            result3 |= i4;
        } else {
            if (e < 25600) {
                int i6 = 1;
                i11 -= i6;
                result2 &= i4;
            }
        }
        return Float16.constructor-impl((short)result);
    }

    public static final int getExponent-impl(short arg0) {
        return i2 += -15;
    }

    public static final short getSign-slo4al4(short arg0) {
        short naN;
        if (Float16.isNaN-impl(arg0)) {
            naN = Float16.NaN;
        } else {
            if (Float16.compareTo-41bOqos(arg0, Float16.NegativeZero) < 0) {
                naN = Float16Kt.access$getNegativeOne$p();
            } else {
                if (Float16.compareTo-41bOqos(arg0, Float16.PositiveZero) > 0) {
                    naN = Float16Kt.access$getOne$p();
                } else {
                    naN = arg0;
                }
            }
        }
        return naN;
    }

    public static final int getSignificand-impl(short arg0) {
        return arg0 & 1023;
    }

    public static int hashCode-impl(short s) {
        return Short.hashCode(s);
    }

    public static final boolean isFinite-impl(short arg0) {
        int i;
        i = arg0 & 32767 != 31744 ? 1 : 0;
        return i;
    }

    public static final boolean isInfinite-impl(short arg0) {
        int i;
        i = arg0 & 32767 == 31744 ? 1 : 0;
        return i;
    }

    public static final boolean isNaN-impl(short arg0) {
        int i;
        i = arg0 & 32767 > 31744 ? 1 : 0;
        return i;
    }

    public static final boolean isNormalized-impl(short arg0) {
        int i3;
        int i2;
        int i;
        if (arg0 & 31744 != 0 && arg0 & 31744 != 31744) {
            i2 = arg0 & 31744 != 31744 ? 1 : 0;
        } else {
        }
        return i2;
    }

    public static final short round-slo4al4(short arg0) {
        int i2;
        int i;
        int e;
        int result;
        int i3;
        int i4;
        final int i8 = arg0 & i;
        e = i8 & 32767;
        result = i8;
        i3 = 15360;
        if (e < i3) {
            if (e >= 14336) {
            } else {
                i = 0;
            }
            result3 |= i2;
        } else {
            if (e < 25600) {
                e = i5 - 25;
                int i6 = 1;
                result2 &= i2;
            }
        }
        return Float16.constructor-impl((short)result);
    }

    public static final int toBits-impl(short arg0) {
        short naN;
        naN = Float16.isNaN-impl(arg0) ? Float16.NaN : i & arg0;
        return naN;
    }

    public static final byte toByte-impl(short arg0) {
        return (byte)i;
    }

    public static final double toDouble-impl(short arg0) {
        return (double)float-impl;
    }

    public static final float toFloat-impl(short arg0) {
        float out$iv;
        int i;
        int outE$iv;
        int outM$iv;
        float $i$f$floatFromBits;
        final int i2 = 0;
        i3 &= obj;
        i5 &= i4;
        i = 31;
        i7 &= i;
        final int i14 = i4 & 1023;
        outE$iv = 0;
        outM$iv = 0;
        if (i8 == 0) {
            if (i14 != 0) {
                int i17 = 0;
                if (i6 == 0) {
                } else {
                    out$iv = $i$f$floatFromBits;
                }
            } else {
                int i16 = 0;
                out$iv = $i$f$floatFromBits;
            }
        } else {
            outM$iv = i14 << 13;
            if (i8 == i) {
                outE$iv = 255;
                if (outM$iv != 0) {
                    outM$iv |= i;
                }
            } else {
                outE$iv = i + 127;
            }
        }
        return out$iv;
    }

    public static final String toHexString-impl(short arg0) {
        String valueOf;
        String str;
        String str2;
        String string;
        Regex regex;
        StringBuilder stringBuilder = new StringBuilder();
        i &= arg0;
        final int i3 = i2 >>> 15;
        int i6 = 31;
        i4 &= i6;
        final int i10 = i2 & 1023;
        str = 45;
        if (i5 == i6) {
            if (i10 == 0) {
                if (i3 != 0) {
                    stringBuilder.append(str);
                }
                stringBuilder.append("Infinity");
            } else {
                stringBuilder.append("NaN");
            }
        } else {
            if (i3 == 1) {
                stringBuilder.append(str);
            }
            String str3 = "";
            str = "0{2,}$";
            str2 = "toString(this, checkRadix(radix))";
            string = 16;
            if (i5 == 0) {
                if (i10 == 0) {
                    stringBuilder.append("0x0.0p0");
                } else {
                    stringBuilder.append("0x0.");
                    string = Integer.toString(i10, CharsKt.checkRadix(string));
                    Intrinsics.checkNotNullExpressionValue(string, str2);
                    regex = new Regex(str);
                    stringBuilder.append(regex.replaceFirst((CharSequence)string, str3));
                    stringBuilder.append("p-14");
                }
            } else {
                stringBuilder.append("0x1.");
                string = Integer.toString(i10, CharsKt.checkRadix(string));
                Intrinsics.checkNotNullExpressionValue(string, str2);
                regex = new Regex(str);
                stringBuilder.append(regex.replaceFirst((CharSequence)string, str3));
                stringBuilder.append('p');
                stringBuilder.append(String.valueOf(i5 + -15));
            }
        }
        return stringBuilder.toString();
    }

    public static final int toInt-impl(short arg0) {
        return (int)float-impl;
    }

    public static final long toLong-impl(short arg0) {
        return (long)float-impl;
    }

    public static final int toRawBits-impl(short arg0) {
        return i &= arg0;
    }

    public static final short toShort-impl(short arg0) {
        return (short)i;
    }

    public static String toString-impl(short arg0) {
        return String.valueOf(Float16.toFloat-impl(arg0));
    }

    public static final short trunc-slo4al4(short arg0) {
        int e;
        int result;
        int i2;
        int i;
        i3 &= arg0;
        e = i4 & 32767;
        result = i4;
        if (e < 15360) {
            result &= i2;
        } else {
            if (e < 25600) {
                int i7 = 1;
                result &= i2;
            }
        }
        return Float16.constructor-impl((short)result);
    }

    public static final short withSign-qCeQghg(short arg0, short sign) {
        return Float16.constructor-impl((short)i3);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        return compareTo-41bOqos((Float16)other.unbox-impl());
    }

    @Override // java.lang.Comparable
    public int compareTo-41bOqos(short other) {
        return Float16.compareTo-41bOqos(this.halfValue, other);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        return Float16.equals-impl(this.halfValue, object);
    }

    @Override // java.lang.Comparable
    public final short getHalfValue() {
        return this.halfValue;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return Float16.hashCode-impl(this.halfValue);
    }

    @Override // java.lang.Comparable
    public String toString() {
        return Float16.toString-impl(this.halfValue);
    }

    @Override // java.lang.Comparable
    public final short unbox-impl() {
        return this.halfValue;
    }
}
