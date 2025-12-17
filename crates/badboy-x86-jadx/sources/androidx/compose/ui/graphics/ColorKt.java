package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorModel.Companion;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0013\n\u0002\u0010\u0014\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a9\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a\u0017\u0010\u000f\u001a\u00020\u00072\u0008\u0008\u0001\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a5\u0010\u000f\u001a\u00020\u00072\u0008\u0008\u0001\u0010\u0010\u001a\u00020\u00192\u0008\u0008\u0001\u0010\u0012\u001a\u00020\u00192\u0008\u0008\u0001\u0010\u0013\u001a\u00020\u00192\u0008\u0008\u0003\u0010\u0014\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001b\u001a\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a9\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\u0010\u0017\u001a1\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0082\u0008\u001a,\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0008\u0008\u0001\u0010(\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\u001a\u001e\u0010+\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.\u001a\u0016\u0010/\u001a\u000200*\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\u00081\u00102\u001a\u0016\u00103\u001a\u00020\u0011*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u00084\u00105\u001a%\u00106\u001a\u00020\u0007*\u00020\u00072\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u00020\u000708H\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u00089\u0010:\u001a\u0016\u0010;\u001a\u00020\u0019*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=\"\u0018\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\u0008\u0002\u0010\u0003\"\u001f\u0010\u0005\u001a\u00020\u0006*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000b\"\u001f\u0010\u000c\u001a\u00020\u0006*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\r\u0010\t\u001a\u0004\u0008\u000e\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006>", d2 = {"UnspecifiedColor", "Lkotlin/ULong;", "getUnspecifiedColor$annotations", "()V", "J", "isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "UncheckedColor", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorKt {

    public static final long UnspecifiedColor = 16L;
    public static final long Color(float red, float green, float blue, float alpha, ColorSpace colorSpace) {
        int i11;
        int out$iv;
        int m$iv2;
        short s3;
        int i12;
        int out$iv2;
        int i;
        int i8;
        short s;
        int out$iv3;
        int i7;
        String $i$a$RequirePreconditionColorKt$Color$1;
        int e$iv3;
        int $this$fastCoerceAtMost$iv$iv7;
        int $this$fastCoerceAtMost$iv$iv2;
        String $i$a$RequirePreconditionColorKt$Color$2;
        int e$iv;
        float $this$fastCoerceAtMost$iv$iv3;
        int $this$fastCoerceAtMost$iv$iv5;
        int $this$fastCoerceAtMost$iv$iv4;
        int e$iv2;
        float $this$fastCoerceAtMost$iv$iv6;
        int i14;
        int $this$fastCoerceAtLeast$iv$iv;
        float $this$fastCoerceAtMost$iv$iv;
        int m$iv;
        int outE$iv2;
        int i2;
        short s2;
        int m$iv3;
        int outE$iv3;
        int outM$iv;
        int outE$iv;
        int outM$iv3;
        int outM$iv2;
        int i5;
        int i9;
        int i13;
        int i6;
        int i3;
        int i10;
        int i4;
        final Object obj = colorSpace;
        int i18 = 32;
        i = 1056964608;
        int i15 = 0;
        int i51 = 1065353216;
        int i78 = 0;
        int i106 = 0;
        if (obj.isSrgb() && Float.compare($this$fastCoerceAtMost$iv$iv2, i15) < 0) {
            i15 = 0;
            i51 = 1065353216;
            i78 = 0;
            i106 = 0;
            if (Float.compare($this$fastCoerceAtMost$iv$iv2, i15) < 0) {
                $this$fastCoerceAtMost$iv$iv2 = i15;
            }
            int i107 = 0;
            if (Float.compare($this$fastCoerceAtMost$iv$iv2, i51) > 0) {
                $this$fastCoerceAtMost$iv$iv2 = i51;
            }
            int minimumValue$iv = 1132396544;
            int i62 = 0;
            int i79 = 1065353216;
            int i108 = 0;
            int i125 = 0;
            if (Float.compare($this$fastCoerceAtLeast$iv$iv, i62) < 0) {
                $this$fastCoerceAtLeast$iv$iv = i62;
            }
            int i126 = 0;
            if (Float.compare($this$fastCoerceAtLeast$iv$iv, i79) > 0) {
                $this$fastCoerceAtLeast$iv$iv = i79;
            }
            int i54 = 0;
            int i64 = 1065353216;
            int i92 = 0;
            int i119 = 0;
            if (Float.compare($this$fastCoerceAtMost$iv$iv5, i54) < 0) {
                $this$fastCoerceAtMost$iv$iv5 = i54;
            }
            int i120 = 0;
            if (Float.compare($this$fastCoerceAtMost$iv$iv5, i64) > 0) {
                $this$fastCoerceAtMost$iv$iv5 = i64;
            }
            int i57 = 0;
            int i65 = 1065353216;
            int i93 = 0;
            int i121 = 0;
            if (Float.compare($this$fastCoerceAtMost$iv$iv4, i57) < 0) {
                $this$fastCoerceAtMost$iv$iv4 = i57;
            }
            int i122 = 0;
            if (Float.compare($this$fastCoerceAtMost$iv$iv4, i65) > 0) {
                $this$fastCoerceAtMost$iv$iv4 = i65;
            }
            long constructor-impl3 = ULong.constructor-impl((long)i17);
            return Color.constructor-impl(ULong.constructor-impl(constructor-impl3 << i18));
        }
        int i58 = 0;
        i7 = 1;
        i11 = obj.getComponentCount() == 3 ? i7 : i58;
        int i48 = 0;
        if (i11 == 0) {
            int i88 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("Color only works with ColorSpaces with 3 components");
        }
        int id$ui_graphics_release = obj.getId$ui_graphics_release();
        i8 = id$ui_graphics_release != -1 ? i7 : i58;
        int i82 = 0;
        if (i8 == 0) {
            int i105 = 0;
            InlineClassHelperKt.throwIllegalArgumentException("Unknown color space, please use a color space in ColorSpaces");
        }
        float minValue2 = obj.getMinValue(i58);
        float maxValue3 = obj.getMaxValue(i58);
        int i113 = 0;
        int i127 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, minValue2) < 0) {
            $this$fastCoerceAtMost$iv$iv = minValue2;
        }
        int i128 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, maxValue3) > 0) {
            $this$fastCoerceAtMost$iv$iv = maxValue3;
        }
        int i50 = 0;
        int floatToRawIntBits3 = Float.floatToRawIntBits($this$fastCoerceAtMost$iv$iv);
        int i94 = floatToRawIntBits3 >>> 31;
        i2 = 255;
        i114 &= i2;
        int i129 = 8388607;
        m$iv3 = floatToRawIntBits3 & i129;
        outE$iv = 0;
        outM$iv2 = 0;
        final int i134 = 8388608;
        m$iv2 = -10;
        i13 = 512;
        i12 = 31;
        if (e$iv2 == i2) {
            outE$iv = 31;
            i3 = m$iv3 != 0 ? i13 : i58;
            outM$iv2 = i3;
            i6 = i;
            s = (short)out$iv2;
        } else {
            e$iv2 = i137 + 15;
            if (e$iv2 >= i12) {
                outE$iv = 49;
                i6 = i;
            } else {
                if (e$iv2 <= 0) {
                    if (e$iv2 >= m$iv2) {
                        m$iv3 = i138 >> i10;
                        i6 = i;
                        if (m$iv3 & 4096 != 0) {
                            m$iv3 += 8192;
                        }
                        outM$iv2 = m$iv3 >> 13;
                    } else {
                        i6 = i;
                    }
                } else {
                    i6 = i;
                    if (m$iv3 & 4096 != 0) {
                        s = (short)i59;
                    } else {
                    }
                }
            }
        }
        float minValue = obj.getMinValue(i7);
        float maxValue2 = obj.getMaxValue(i7);
        int i95 = 0;
        int i123 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv6, minValue) < 0) {
            $this$fastCoerceAtMost$iv$iv6 = minValue;
        }
        int i124 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv6, maxValue2) > 0) {
            $this$fastCoerceAtMost$iv$iv6 = maxValue2;
        }
        int i36 = 0;
        int floatToRawIntBits = Float.floatToRawIntBits($this$fastCoerceAtMost$iv$iv6);
        int i83 = floatToRawIntBits >>> 31;
        i96 &= i2;
        m$iv = floatToRawIntBits & i129;
        outE$iv3 = 0;
        outM$iv3 = 0;
        if (e$iv == i2) {
            outE$iv3 = 31;
            i9 = m$iv != 0 ? i13 : 0;
            outM$iv3 = i9;
            i5 = i7;
            i4 = i129;
            s2 = (short)out$iv3;
        } else {
            e$iv = i132 + 15;
            if (e$iv >= i12) {
                outE$iv3 = 49;
                i5 = i7;
                i4 = i129;
            } else {
                if (e$iv <= 0) {
                    if (e$iv >= m$iv2) {
                        m$iv = i133 >> i10;
                        i5 = i7;
                        if (m$iv & 4096 != 0) {
                            m$iv += 8192;
                        }
                        outM$iv3 = m$iv >> 13;
                        i4 = i129;
                    } else {
                        i5 = i7;
                        i4 = i129;
                    }
                } else {
                    i5 = i7;
                    if (m$iv & 4096 != 0) {
                        i4 = i129;
                        s2 = (short)i131;
                    } else {
                        i4 = i129;
                    }
                }
            }
        }
        int i37 = 2;
        float minValue3 = obj.getMinValue(i37);
        float maxValue = obj.getMaxValue(i37);
        int i84 = 0;
        int i115 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv3, minValue3) < 0) {
            $this$fastCoerceAtMost$iv$iv3 = minValue3;
        }
        int i116 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv3, maxValue) > 0) {
            $this$fastCoerceAtMost$iv$iv3 = maxValue;
        }
        int i38 = 0;
        int floatToRawIntBits2 = Float.floatToRawIntBits($this$fastCoerceAtMost$iv$iv3);
        int i66 = floatToRawIntBits2 >>> 31;
        i85 &= i2;
        i14 = floatToRawIntBits2 & i4;
        outE$iv2 = 0;
        outM$iv = 0;
        if (e$iv3 == i2) {
            outE$iv2 = 31;
            if (i14 != 0) {
            } else {
                i13 = 0;
            }
            outM$iv = i13;
            s3 = (short)out$iv;
        } else {
            e$iv3 = i2 + 15;
            if (e$iv3 >= i12) {
                outE$iv2 = 49;
            } else {
                if (e$iv3 <= 0) {
                    i22 >>= i28;
                    if (e$iv3 >= m$iv2 && m$iv2 & 4096 != 0) {
                        i22 >>= i28;
                        if (m$iv2 & 4096 != 0) {
                            m$iv2 += 8192;
                        }
                        outM$iv = i14 >> 13;
                    }
                } else {
                    if (i14 & 4096 != 0) {
                        s3 = (short)i30;
                    } else {
                    }
                }
            }
        }
        int i19 = 0;
        int i39 = 1065353216;
        long l3 = alpha;
        int i67 = 0;
        int i97 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv7, i19) < 0) {
            $this$fastCoerceAtMost$iv$iv7 = i19;
        }
        int i98 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv7, i39) > 0) {
            $this$fastCoerceAtMost$iv$iv7 = i39;
        }
        int i68 = 65535;
        return Color.constructor-impl(ULong.constructor-impl(i44 |= i73));
    }

    public static final long Color(int color) {
        return Color.constructor-impl(ULong.constructor-impl(constructor-impl <<= i2));
    }

    public static final long Color(int red, int green, int blue, int alpha) {
        return ColorKt.Color(i4 |= i10);
    }

    public static final long Color(long color) {
        return Color.constructor-impl(ULong.constructor-impl(color << i));
    }

    public static long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace5, int i6, Object object7) {
        int obj3;
        Rgb obj4;
        if (i6 & 8 != 0) {
            obj3 = 1065353216;
        }
        if (i6 &= 16 != 0) {
            obj4 = ColorSpaces.INSTANCE.getSrgb();
        }
        return ColorKt.Color(f, f2, f3, obj3, obj4);
    }

    public static long Color$default(int i, int i2, int i3, int i4, int i5, Object object6) {
        int obj3;
        if (i5 &= 8 != 0) {
            obj3 = 255;
        }
        return ColorKt.Color(i, i2, i3, obj3);
    }

    public static final long UncheckedColor(float red, float green, float blue, float alpha, ColorSpace colorSpace) {
        int m$iv;
        int out$iv;
        int i9;
        int out$iv3;
        short s2;
        int e$iv2;
        int e$iv;
        int e$iv3;
        int m$iv3;
        int i8;
        int i;
        short s;
        short s3;
        int m$iv2;
        int outE$iv;
        int outE$iv3;
        int outE$iv2;
        int outM$iv;
        int outM$iv2;
        int outM$iv3;
        int out$iv2;
        int i2;
        int i10;
        int i3;
        int i7;
        int i4;
        int i5;
        int i6;
        final int i11 = alpha;
        int i23 = 32;
        i9 = 16;
        int i40 = 1056964608;
        if (colorSpace.isSrgb()) {
            int i18 = 1132396544;
            long constructor-impl3 = ULong.constructor-impl((long)i22);
            return Color.constructor-impl(ULong.constructor-impl(constructor-impl3 << i23));
        }
        int argb = 0;
        int floatToRawIntBits3 = Float.floatToRawIntBits(red);
        int i59 = floatToRawIntBits3 >>> 31;
        i = 255;
        i65 &= i;
        int i69 = 8388607;
        m$iv2 = floatToRawIntBits3 & i69;
        outE$iv2 = 0;
        outM$iv3 = 0;
        final int i87 = 8388608;
        final int i88 = -10;
        i10 = 512;
        final int i89 = 0;
        m$iv = 31;
        if (e$iv3 == i) {
            outE$iv2 = 31;
            i3 = m$iv2 != 0 ? i10 : i89;
            outM$iv3 = i3;
            i7 = i9;
            i5 = i40;
            s2 = (short)out$iv3;
        } else {
            e$iv3 = i91 + 15;
            if (e$iv3 >= m$iv) {
                outE$iv2 = 49;
                i7 = i9;
                i5 = i40;
            } else {
                if (e$iv3 <= 0) {
                    if (e$iv3 >= i88) {
                        m$iv2 = i92 >> i4;
                        i7 = i9;
                        if (m$iv2 & 4096 != 0) {
                            m$iv2 += 8192;
                        }
                        outM$iv3 = m$iv2 >> 13;
                        i5 = i40;
                    } else {
                        i7 = i9;
                        i5 = i40;
                    }
                } else {
                    i7 = i9;
                    if (m$iv2 & 4096 != 0) {
                        i5 = i40;
                        s2 = (short)i42;
                    } else {
                        i5 = i40;
                    }
                }
            }
        }
        int i12 = 0;
        int floatToRawIntBits = Float.floatToRawIntBits(green);
        int i43 = floatToRawIntBits >>> 31;
        i60 &= i;
        m$iv3 = floatToRawIntBits & i69;
        outE$iv = 0;
        outM$iv = 0;
        if (e$iv2 == i) {
            outE$iv = 31;
            i2 = m$iv3 != 0 ? i10 : i89;
            outM$iv = i2;
            i6 = i69;
            s3 = (short)i73;
        } else {
            e$iv2 = i2 + 15;
            if (e$iv2 >= m$iv) {
                outE$iv = 49;
                i6 = i69;
            } else {
                if (e$iv2 <= 0) {
                    if (e$iv2 >= i88) {
                        m$iv3 = i80 >> i4;
                        if (m$iv3 & 4096 != 0) {
                            m$iv3 += 8192;
                        }
                        outM$iv = m$iv3 >> 13;
                        i6 = i69;
                    } else {
                        i6 = i69;
                    }
                } else {
                    if (m$iv3 & 4096 != 0) {
                        i6 = i69;
                        s3 = (short)i70;
                    } else {
                        i6 = i69;
                    }
                }
            }
        }
        int i13 = 0;
        int floatToRawIntBits2 = Float.floatToRawIntBits(blue);
        int i44 = floatToRawIntBits2 >>> 31;
        i61 &= i;
        i8 = floatToRawIntBits2 & i6;
        outE$iv3 = 0;
        outM$iv2 = 0;
        if (e$iv == i) {
            outE$iv3 = 31;
            if (i8 != 0) {
            } else {
                i10 = i89;
            }
            outM$iv2 = i10;
            s = (short)out$iv;
        } else {
            e$iv = i + 15;
            if (e$iv >= m$iv) {
                outE$iv3 = 49;
            } else {
                if (e$iv <= 0) {
                    i27 >>= i;
                    if (e$iv >= i88 && m$iv & 4096 != 0) {
                        i27 >>= i;
                        if (m$iv & 4096 != 0) {
                            m$iv += 8192;
                        }
                        outM$iv2 = i8 >> 13;
                    }
                } else {
                    if (i8 & 4096 != 0) {
                        s = (short)i68;
                    } else {
                    }
                }
            }
        }
        int i74 = 65535;
        return Color.constructor-impl(ULong.constructor-impl(i49 |= i79));
    }

    public static long UncheckedColor$default(float f, float f2, float f3, float f4, ColorSpace colorSpace5, int i6, Object object7) {
        int obj3;
        Rgb obj4;
        if (i6 & 8 != 0) {
            obj3 = 1065353216;
        }
        if (i6 &= 16 != 0) {
            obj4 = ColorSpaces.INSTANCE.getSrgb();
        }
        return ColorKt.UncheckedColor(f, f2, f3, obj3, obj4);
    }

    private static final float compositeComponent(float fgC, float bgC, float fgA, float bgA, float a) {
        int i2;
        int i3;
        int i;
        final int i4 = 0;
        i3 = Float.compare(a, i2) == 0 ? 1 : 0;
        if (i3 != 0) {
        } else {
            i6 /= a;
        }
        return i2;
    }

    public static final long compositeOver--OWjLjI(long $this$compositeOver_u2d_u2dOWjLjI, long background) {
        int i5;
        int i9;
        int i7;
        int i3;
        int i4;
        int i6;
        int i2;
        int i;
        int i8;
        int i10;
        final long convert-vNxB06k = Color.convert-vNxB06k($this$compositeOver_u2d_u2dOWjLjI, obj2);
        float alpha-impl = Color.getAlpha-impl(obj20);
        final float alpha-impl2 = Color.getAlpha-impl(convert-vNxB06k);
        i5 = 1065353216;
        i12 += alpha-impl2;
        int i14 = 0;
        i9 = 0;
        i4 = 1;
        final int i22 = 0;
        i7 = Float.compare(i13, i9) == 0 ? i4 : i22;
        if (i7 != 0) {
            i3 = i9;
        } else {
            i20 /= i13;
        }
        int i15 = 0;
        i2 = Float.compare(i13, i9) == 0 ? i4 : i22;
        if (i2 != 0) {
            i = i9;
        } else {
            i24 /= i13;
        }
        int i16 = 0;
        if (Float.compare(i13, i9) == 0) {
        } else {
            i4 = i22;
        }
        if (i4 != 0) {
        } else {
            i18 /= i13;
        }
        return ColorKt.UncheckedColor(i3, i, i9, i13, Color.getColorSpace-impl(obj20));
    }

    private static final float[] getComponents-8_81llA(long $this$getComponents_u2d8_81llA) {
        float[] fArr = new float[4];
        return fArr;
    }

    public static void getUnspecifiedColor$annotations() {
    }

    public static final boolean isSpecified-8_81llA(long $this$isSpecified) {
        int i;
        final int i2 = 0;
        i = Long.compare($this$isSpecified, i3) != 0 ? 1 : 0;
        return i;
    }

    public static void isSpecified-8_81llA$annotations(long l) {
    }

    public static final boolean isUnspecified-8_81llA(long $this$isUnspecified) {
        int i;
        final int i2 = 0;
        i = Long.compare($this$isUnspecified, i3) == 0 ? 1 : 0;
        return i;
    }

    public static void isUnspecified-8_81llA$annotations(long l) {
    }

    public static final long lerp-jxsXWHM(long start, long stop, float fraction) {
        int $this$fastCoerceAtLeast$iv$iv;
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long convert-vNxB06k = Color.convert-vNxB06k(start, obj2);
        final long convert-vNxB06k3 = Color.convert-vNxB06k(fraction, obj6);
        int i = 0;
        int i2 = 1065353216;
        final int i4 = 0;
        int i5 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i) < 0) {
            $this$fastCoerceAtLeast$iv$iv = i;
        }
        int i6 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i2) > 0) {
            $this$fastCoerceAtLeast$iv$iv = i2;
        }
        int minimumValue$iv = $this$fastCoerceAtLeast$iv$iv;
        long l2 = convert-vNxB06k;
        final float lerp2 = MathHelpersKt.lerp(Color.getGreen-impl(convert-vNxB06k), Color.getGreen-impl(convert-vNxB06k3), minimumValue$iv);
        return Color.convert-vNxB06k(ColorKt.UncheckedColor(MathHelpersKt.lerp(Color.getRed-impl(convert-vNxB06k), Color.getRed-impl(convert-vNxB06k3), minimumValue$iv), lerp2, MathHelpersKt.lerp(Color.getBlue-impl(convert-vNxB06k), Color.getBlue-impl(convert-vNxB06k3), minimumValue$iv), MathHelpersKt.lerp(Color.getAlpha-impl(convert-vNxB06k), Color.getAlpha-impl(convert-vNxB06k3), minimumValue$iv), oklab), lerp2);
    }

    public static final float luminance-8_81llA(long $this$luminance_u2d8_81llA) {
        long $i$a$RequirePreconditionColorKt$luminance$1;
        StringBuilder append;
        String string-impl;
        float $this$fastCoerceAtLeast$iv$iv;
        final ColorSpace colorSpace-impl = Color.getColorSpace-impl($this$luminance_u2d8_81llA);
        int i = 0;
        if (!ColorModel.equals-impl0(colorSpace-impl.getModel-xdoWZVw(), obj2)) {
            int i2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalArgumentException(stringBuilder.append("The specified color must be encoded in an RGB color space. The supplied color space is ").append(ColorModel.toString-impl(colorSpace-impl.getModel-xdoWZVw())).toString());
        }
        Intrinsics.checkNotNull(colorSpace-impl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = (Rgb)colorSpace-impl.getEotfFunc$ui_graphics_release();
        final int i6 = 0;
        int i9 = 1065353216;
        final int i10 = 0;
        int i11 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i6) < 0) {
            $this$fastCoerceAtLeast$iv$iv = i6;
        }
        int i12 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i9) > 0) {
            $this$fastCoerceAtLeast$iv$iv = i9;
        }
        return $this$fastCoerceAtLeast$iv$iv;
    }

    public static final long takeOrElse-DxMtmZc(long $this$takeOrElse_u2dDxMtmZc, Function0<androidx.compose.ui.graphics.Color> block) {
        long unbox-impl;
        int i;
        final int i2 = 0;
        final int i4 = 0;
        i = Long.compare(i3, i5) != 0 ? 1 : 0;
        if (i != 0) {
            unbox-impl = $this$takeOrElse_u2dDxMtmZc;
        } else {
            unbox-impl = (Color)obj8.invoke().unbox-impl();
        }
        return unbox-impl;
    }

    public static final int toArgb-8_81llA(long $this$toArgb_u2d8_81llA) {
        return (int)constructor-impl;
    }
}
