package androidx.compose.ui.graphics.colorspace;

import androidx.compose.material3.IconToggleButtonColors;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\u0008\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0016J%\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\u0008\u0019J=\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008!\u0010\"R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\t\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006$", d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Oklab extends androidx.compose.ui.graphics.colorspace.ColorSpace {

    public static final androidx.compose.ui.graphics.colorspace.Oklab.Companion Companion;
    private static final float[] InverseM1;
    private static final float[] InverseM2;
    private static final float[] M1;
    private static final float[] M2;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0004\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Landroidx/compose/ui/graphics/colorspace/Oklab$Companion;", "", "()V", "InverseM1", "", "InverseM2", "M1", "M2", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        Oklab.Companion companion = new Oklab.Companion(0);
        Oklab.Companion = companion;
        int i = 9;
        float[] fArr2 = new float[i];
        fArr2 = new int[]{1062315416, 1023875789, 1027960238, 1052329625, 1064167266, 1049058052, -1107037235, 1024724339, 1059210267};
        Oklab.M1 = ColorSpaceKt.mul3x3(fArr2, ColorSpaceKt.chromaticAdaptation(Adaptation.Companion.getBradford().getTransform$ui_graphics_release(), Illuminant.INSTANCE.getD50().toXyz$ui_graphics_release(), Illuminant.INSTANCE.getD65().toXyz$ui_graphics_release()));
        float[] fArr = new float[i];
        fArr = new int[]{1045922130, 1073557262, 1020540084, 1061890697, -1071944178, 1061708731, -1148883250, 1055306808, -1085340320};
        Oklab.M2 = fArr;
        Oklab.InverseM1 = ColorSpaceKt.inverse3x3(Oklab.M1);
        Oklab.InverseM2 = ColorSpaceKt.inverse3x3(Oklab.M2);
    }

    public Oklab(String name, int id) {
        super(name, ColorModel.Companion.getLab-xdoWZVw(), obj4, id, 0);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v) {
        ColorSpaceKt.mul3x3Float3(Oklab.M1, v);
        int i = 0;
        v[i] = MathHelpersKt.fastCbrt(v[i]);
        int i2 = 1;
        v[i2] = MathHelpersKt.fastCbrt(v[i2]);
        int i3 = 2;
        v[i3] = MathHelpersKt.fastCbrt(v[i3]);
        ColorSpaceKt.mul3x3Float3(Oklab.M2, v);
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        int i;
        i = component == 0 ? 1065353216 : 1056964608;
        return i;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        int i;
        i = component == 0 ? 0 : -1090519040;
        return i;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return 1;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        int $this$fastCoerceAtMost$iv$iv2;
        int $this$fastCoerceAtMost$iv$iv;
        int $this$fastCoerceAtMost$iv$iv3;
        int i = 0;
        int i6 = 1065353216;
        int i21 = 0;
        int i27 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv2, i) < 0) {
            $this$fastCoerceAtMost$iv$iv2 = i;
        }
        int i28 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv2, i6) > 0) {
            $this$fastCoerceAtMost$iv$iv2 = i6;
        }
        int i2 = -1090519040;
        int i7 = 1056964608;
        int i22 = 0;
        int i29 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i2) < 0) {
            $this$fastCoerceAtMost$iv$iv = i2;
        }
        int i30 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i7) > 0) {
            $this$fastCoerceAtMost$iv$iv = i7;
        }
        int i3 = -1090519040;
        int i8 = 1056964608;
        int i23 = 0;
        int i31 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv3, i3) < 0) {
            $this$fastCoerceAtMost$iv$iv3 = i3;
        }
        int i32 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv3, i8) > 0) {
            $this$fastCoerceAtMost$iv$iv3 = i8;
        }
        float[] inverseM2 = Oklab.InverseM2;
        int i9 = 0;
        int i17 = 0;
        int i33 = 3;
        int i38 = 6;
        i25 += i41;
        float[] inverseM22 = Oklab.InverseM2;
        int i10 = 0;
        int i42 = 1;
        int i49 = 4;
        int i53 = 7;
        i47 += i54;
        float[] inverseM23 = Oklab.InverseM2;
        int i11 = 0;
        i57 += i62;
        i4 *= i26;
        i12 *= i48;
        i63 *= i58;
        float[] inverseM12 = Oklab.InverseM1;
        int i66 = 0;
        float[] inverseM1 = Oklab.InverseM1;
        int i39 = 0;
        int i36 = 0;
        int i65 = i5;
        int i67 = i13;
        return i68 | i69;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v) {
        int $this$fastCoerceAtMost$iv$iv3;
        int $this$fastCoerceAtMost$iv$iv2;
        int $this$fastCoerceAtMost$iv$iv;
        int i = 0;
        int i12 = 0;
        int i15 = 1065353216;
        int i23 = 0;
        int i30 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv3, i12) < 0) {
            $this$fastCoerceAtMost$iv$iv3 = i12;
        }
        int i31 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv3, i15) > 0) {
            $this$fastCoerceAtMost$iv$iv3 = i15;
        }
        v[i] = $this$fastCoerceAtMost$iv$iv3;
        int i9 = 1;
        int i16 = -1090519040;
        int i24 = 1056964608;
        int i28 = 0;
        int i33 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv2, i16) < 0) {
            $this$fastCoerceAtMost$iv$iv2 = i16;
        }
        int i34 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv2, i24) > 0) {
            $this$fastCoerceAtMost$iv$iv2 = i24;
        }
        v[i9] = $this$fastCoerceAtMost$iv$iv2;
        int i14 = 2;
        int i25 = -1090519040;
        int i29 = 1056964608;
        int i32 = 0;
        int i35 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i25) < 0) {
            $this$fastCoerceAtMost$iv$iv = i25;
        }
        int i36 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i29) > 0) {
            $this$fastCoerceAtMost$iv$iv = i29;
        }
        v[i14] = $this$fastCoerceAtMost$iv$iv;
        ColorSpaceKt.mul3x3Float3(Oklab.InverseM2, v);
        v[i] = i19 *= i27;
        v[i9] = i3 *= i22;
        v[i14] = i6 *= i11;
        ColorSpaceKt.mul3x3Float3(Oklab.InverseM1, v);
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        int $this$fastCoerceAtMost$iv$iv3;
        int $this$fastCoerceAtMost$iv$iv;
        int $this$fastCoerceAtMost$iv$iv2;
        int i = 0;
        int i6 = 1065353216;
        int i21 = 0;
        int i32 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv3, i) < 0) {
            $this$fastCoerceAtMost$iv$iv3 = i;
        }
        int i33 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv3, i6) > 0) {
            $this$fastCoerceAtMost$iv$iv3 = i6;
        }
        int i2 = -1090519040;
        int i7 = 1056964608;
        int i22 = 0;
        int i34 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i2) < 0) {
            $this$fastCoerceAtMost$iv$iv = i2;
        }
        int i35 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i7) > 0) {
            $this$fastCoerceAtMost$iv$iv = i7;
        }
        int i3 = -1090519040;
        int i8 = 1056964608;
        int i23 = 0;
        int i36 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv2, i3) < 0) {
            $this$fastCoerceAtMost$iv$iv2 = i3;
        }
        int i37 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv2, i8) > 0) {
            $this$fastCoerceAtMost$iv$iv2 = i8;
        }
        float[] inverseM2 = Oklab.InverseM2;
        int i9 = 0;
        i19 += i27;
        float[] inverseM22 = Oklab.InverseM2;
        int i10 = 0;
        i30 += i41;
        float[] inverseM23 = Oklab.InverseM2;
        int i11 = 0;
        int i42 = 2;
        int i49 = 5;
        int i53 = 8;
        i47 += i54;
        final float[] inverseM1 = Oklab.InverseM1;
        final int i57 = 0;
        return i44 += i51;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long xyzaToColor-JlNiLsg$ui_graphics_release(float x, float y, float z, float a, androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        float[] m1 = Oklab.M1;
        int i = 0;
        int i4 = 0;
        int i11 = 3;
        int i15 = 6;
        float[] m12 = Oklab.M1;
        int i2 = 0;
        int i19 = 1;
        int i31 = 4;
        int i35 = 7;
        float[] m13 = Oklab.M1;
        int i3 = 0;
        int i37 = 2;
        final int i42 = 5;
        int i44 = 8;
        float fastCbrt = MathHelpersKt.fastCbrt(i9 += i18);
        float fastCbrt2 = MathHelpersKt.fastCbrt(i24 += i36);
        float fastCbrt3 = MathHelpersKt.fastCbrt(i39 += i45);
        float[] m23 = Oklab.M2;
        int i41 = 0;
        float[] m2 = Oklab.M2;
        int i16 = 0;
        float[] m22 = Oklab.M2;
        int i17 = 0;
        return ColorKt.Color(i6 += i13, i21 += i27, i29 += i33, a, colorSpace);
    }
}
