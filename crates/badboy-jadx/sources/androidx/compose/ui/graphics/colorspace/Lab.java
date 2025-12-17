package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\u0008\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0016J%\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\u0008\u0019J=\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008!\u0010\"R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\t\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006$", d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Lab extends androidx.compose.ui.graphics.colorspace.ColorSpace {

    private static final float A = 0.008856452f;
    private static final float B = 7.787037f;
    private static final float C = 0.13793103f;
    public static final androidx.compose.ui.graphics.colorspace.Lab.Companion Companion = null;
    private static final float D = 0.20689656f;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab$Companion;", "", "()V", "A", "", "B", "C", "D", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        Lab.Companion companion = new Lab.Companion(0);
        Lab.Companion = companion;
    }

    public Lab(String name, int id) {
        super(name, ColorModel.Companion.getLab-xdoWZVw(), obj4, id, 0);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v) {
        float f3;
        float f2;
        double cbrt2;
        int i;
        double cbrt;
        float f;
        int $this$fastCoerceAtLeast$iv$iv2;
        int $this$fastCoerceAtLeast$iv$iv;
        int $this$fastCoerceAtMost$iv$iv;
        int i2 = 0;
        i5 /= f4;
        int i7 = 1;
        i9 /= f5;
        int i11 = 2;
        i12 /= f6;
        int i14 = 1007753895;
        cbrt2 = 1041055179;
        i = 1090072424;
        if (Float.compare(i6, i14) > 0) {
            f2 = (float)cbrt;
        } else {
            i15 += cbrt2;
        }
        if (Float.compare(i10, i14) > 0) {
            f = (float)cbrt3;
        } else {
            i25 += cbrt2;
        }
        if (Float.compare(i13, i14) > 0) {
            f3 = (float)cbrt2;
        } else {
            f3 = i + cbrt2;
        }
        int i22 = 0;
        int i30 = 1120403456;
        int i35 = 0;
        int i40 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i22) < 0) {
            $this$fastCoerceAtMost$iv$iv = i22;
        }
        int i41 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i30) > 0) {
            $this$fastCoerceAtMost$iv$iv = i30;
        }
        v[i2] = $this$fastCoerceAtMost$iv$iv;
        int i3 = -1023410176;
        int i23 = 1124073472;
        int i34 = 0;
        int i38 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i3) < 0) {
            $this$fastCoerceAtLeast$iv$iv = i3;
        }
        int i39 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i23) > 0) {
            $this$fastCoerceAtLeast$iv$iv = i23;
        }
        v[i7] = $this$fastCoerceAtLeast$iv$iv;
        int i4 = -1023410176;
        int i8 = 1124073472;
        int i32 = 0;
        int i36 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv2, i4) < 0) {
            $this$fastCoerceAtLeast$iv$iv2 = i4;
        }
        int i37 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv2, i8) > 0) {
            $this$fastCoerceAtLeast$iv$iv2 = i8;
        }
        v[i11] = $this$fastCoerceAtLeast$iv$iv2;
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        int i;
        i = component == 0 ? 1120403456 : 1124073472;
        return i;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        int i;
        i = component == 0 ? 0 : -1023410176;
        return i;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return 1;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        int i;
        int i2;
        int $this$fastCoerceAtLeast$iv$iv;
        int $this$fastCoerceAtMost$iv$iv;
        int i3 = 0;
        int i8 = 1120403456;
        int i19 = 0;
        int i23 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i3) < 0) {
            $this$fastCoerceAtLeast$iv$iv = i3;
        }
        int i24 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i8) > 0) {
            $this$fastCoerceAtLeast$iv$iv = i8;
        }
        int i4 = -1023410176;
        int i9 = 1124073472;
        int i20 = 0;
        int i25 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i4) < 0) {
            $this$fastCoerceAtMost$iv$iv = i4;
        }
        int i26 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i9) > 0) {
            $this$fastCoerceAtMost$iv$iv = i9;
        }
        i6 /= i10;
        i12 += i7;
        int i16 = 1045683377;
        int i27 = 1041055179;
        int i29 = 1040416807;
        i2 = Float.compare(i13, i16) > 0 ? i21 * i13 : i22 * i29;
        i = Float.compare(i7, i16) > 0 ? i17 * i7 : i18 * i29;
        int i33 = 0;
        return i35 | i36;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v) {
        int $this$fastCoerceAtLeast$iv$iv2;
        int $this$fastCoerceAtMost$iv$iv;
        int i3;
        int $this$fastCoerceAtLeast$iv$iv;
        int i2;
        int i;
        int i4 = 0;
        int i9 = 0;
        int i12 = 1120403456;
        int i18 = 0;
        int i32 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv2, i9) < 0) {
            $this$fastCoerceAtLeast$iv$iv2 = i9;
        }
        int i33 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv2, i12) > 0) {
            $this$fastCoerceAtLeast$iv$iv2 = i12;
        }
        v[i4] = $this$fastCoerceAtLeast$iv$iv2;
        int i8 = 1;
        int i13 = -1023410176;
        int i19 = 1124073472;
        int i26 = 0;
        int i39 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i13) < 0) {
            $this$fastCoerceAtMost$iv$iv = i13;
        }
        int i40 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i19) > 0) {
            $this$fastCoerceAtMost$iv$iv = i19;
        }
        v[i8] = $this$fastCoerceAtMost$iv$iv;
        int i11 = 2;
        int i20 = -1023410176;
        int i27 = 1124073472;
        int i34 = 0;
        int i43 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i20) < 0) {
            $this$fastCoerceAtLeast$iv$iv = i20;
        }
        int i44 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i27) > 0) {
            $this$fastCoerceAtLeast$iv$iv = i27;
        }
        v[i11] = $this$fastCoerceAtLeast$iv$iv;
        i16 /= i22;
        i24 += i17;
        int i31 = i17 - i30;
        int i36 = 1045683377;
        int i45 = 1041055179;
        int i47 = 1040416807;
        i2 = Float.compare(i25, i36) > 0 ? i42 * i25 : i41 * i47;
        i = Float.compare(i17, i36) > 0 ? i49 * i17 : i48 * i47;
        i3 = Float.compare(i31, i36) > 0 ? i38 * i31 : i37 * i47;
        v[i4] = f3 *= i2;
        v[i8] = f *= i;
        v[i11] = f2 *= i3;
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        int i2;
        int i;
        int $this$fastCoerceAtMost$iv$iv2;
        int $this$fastCoerceAtMost$iv$iv;
        int i3 = 0;
        int i8 = 1120403456;
        int i20 = 0;
        int i22 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv2, i3) < 0) {
            $this$fastCoerceAtMost$iv$iv2 = i3;
        }
        int i23 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv2, i8) > 0) {
            $this$fastCoerceAtMost$iv$iv2 = i8;
        }
        int i4 = -1023410176;
        int i9 = 1124073472;
        i = 0;
        int i24 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i4) < 0) {
            $this$fastCoerceAtMost$iv$iv = i4;
        }
        int i25 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i9) > 0) {
            $this$fastCoerceAtMost$iv$iv = i9;
        }
        int i13 = i7 - i12;
        if (Float.compare(i13, i16) > 0) {
            i19 *= i13;
        } else {
            i18 *= i;
        }
        return f *= i2;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long xyzaToColor-JlNiLsg$ui_graphics_release(float x, float y, float z, float a, androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        float f;
        float f2;
        double cbrt;
        int i;
        double cbrt2;
        float f3;
        int $this$fastCoerceAtMost$iv$iv;
        int $this$fastCoerceAtLeast$iv$iv2;
        int $this$fastCoerceAtLeast$iv$iv;
        int i2 = x / f4;
        int i4 = y / f5;
        int i6 = z / f6;
        int i8 = 1007753895;
        cbrt = 1041055179;
        i = 1090072424;
        if (Float.compare(i2, i8) > 0) {
            f2 = (float)cbrt2;
        } else {
            i9 += cbrt;
        }
        if (Float.compare(i4, i8) > 0) {
            f3 = (float)cbrt3;
        } else {
            i17 += cbrt;
        }
        if (Float.compare(i6, i8) > 0) {
            f = (float)cbrt;
        } else {
            f = i + cbrt;
        }
        int i16 = 0;
        int i22 = 1120403456;
        int i28 = 0;
        int i31 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i16) < 0) {
            $this$fastCoerceAtMost$iv$iv = i16;
        }
        int i32 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i22) > 0) {
            $this$fastCoerceAtMost$iv$iv = i22;
        }
        int minimumValue$iv = -1023410176;
        int i23 = 1124073472;
        int i29 = 0;
        int i33 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv2, minimumValue$iv) < 0) {
            $this$fastCoerceAtLeast$iv$iv2 = minimumValue$iv;
        }
        int i34 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv2, i23) > 0) {
            $this$fastCoerceAtLeast$iv$iv2 = i23;
        }
        int minimumValue$iv2 = -1023410176;
        int i24 = 1124073472;
        int i30 = 0;
        int i35 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, minimumValue$iv2) < 0) {
            $this$fastCoerceAtLeast$iv$iv = minimumValue$iv2;
        }
        int i36 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i24) > 0) {
            $this$fastCoerceAtLeast$iv$iv = i24;
        }
        return ColorKt.Color($this$fastCoerceAtMost$iv$iv, $this$fastCoerceAtLeast$iv$iv2, $this$fastCoerceAtLeast$iv$iv, a, colorSpace);
    }
}
