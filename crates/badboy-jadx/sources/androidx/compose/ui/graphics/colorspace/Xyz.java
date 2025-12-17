package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0082\u0008J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0010¢\u0006\u0002\u0008\u0018J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J%\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0010¢\u0006\u0002\u0008\u001bJ=\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\"\u0010#R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\t\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006$", d2 = {"Landroidx/compose/ui/graphics/colorspace/Xyz;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "clamp", "", "x", "fromXyz", "", "v", "getMaxValue", "component", "getMinValue", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Xyz extends androidx.compose.ui.graphics.colorspace.ColorSpace {
    public Xyz(String name, int id) {
        super(name, ColorModel.Companion.getXyz-xdoWZVw(), obj4, id, 0);
    }

    private final float clamp(float x) {
        int $this$fastCoerceAtLeast$iv$iv;
        final int i = 0;
        final int i2 = -1073741824;
        final int i3 = 1073741824;
        final int i5 = 0;
        int i6 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i2) < 0) {
            $this$fastCoerceAtLeast$iv$iv = i2;
        }
        int i7 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i3) > 0) {
            $this$fastCoerceAtLeast$iv$iv = i3;
        }
        return $this$fastCoerceAtLeast$iv$iv;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v) {
        int $this$fastCoerceAtMost$iv$iv$iv2;
        int $this$fastCoerceAtMost$iv$iv$iv;
        int $this$fastCoerceAtMost$iv$iv$iv3;
        int i = 0;
        Object obj = this;
        int i7 = 0;
        int i10 = -1073741824;
        int i13 = 1073741824;
        int i19 = 0;
        int i22 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv2, i10) < 0) {
            $this$fastCoerceAtMost$iv$iv$iv2 = i10;
        }
        int i23 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv2, i13) > 0) {
            $this$fastCoerceAtMost$iv$iv$iv2 = i13;
        }
        v[i] = $this$fastCoerceAtMost$iv$iv$iv2;
        int i2 = 1;
        Object obj2 = this;
        int i8 = 0;
        int i11 = -1073741824;
        int i14 = 1073741824;
        int i20 = 0;
        int i24 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv, i11) < 0) {
            $this$fastCoerceAtMost$iv$iv$iv = i11;
        }
        int i25 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv, i14) > 0) {
            $this$fastCoerceAtMost$iv$iv$iv = i14;
        }
        v[i2] = $this$fastCoerceAtMost$iv$iv$iv;
        int i3 = 2;
        Object obj3 = this;
        int i9 = 0;
        int i12 = -1073741824;
        int i15 = 1073741824;
        int i21 = 0;
        int i26 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv3, i12) < 0) {
            $this$fastCoerceAtMost$iv$iv$iv3 = i12;
        }
        int i27 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv3, i15) > 0) {
            $this$fastCoerceAtMost$iv$iv$iv3 = i15;
        }
        v[i3] = $this$fastCoerceAtMost$iv$iv$iv3;
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return 1073741824;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return -1073741824;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return 1;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        int $this$fastCoerceAtMost$iv$iv$iv;
        int $this$fastCoerceAtMost$iv$iv$iv2;
        Object obj = this;
        int i2 = 0;
        int i4 = -1073741824;
        int i6 = 1073741824;
        int i10 = 0;
        int i13 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv, i4) < 0) {
            $this$fastCoerceAtMost$iv$iv$iv = i4;
        }
        int i14 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv, i6) > 0) {
            $this$fastCoerceAtMost$iv$iv$iv = i6;
        }
        Object this_$iv = this;
        int i3 = 0;
        int i5 = -1073741824;
        int i7 = 1073741824;
        int i11 = 0;
        int i15 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv2, i5) < 0) {
            $this$fastCoerceAtMost$iv$iv$iv2 = i5;
        }
        int i16 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv2, i7) > 0) {
            $this$fastCoerceAtMost$iv$iv$iv2 = i7;
        }
        int i = 0;
        return i17 | i18;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v) {
        int $this$fastCoerceAtMost$iv$iv$iv2;
        int $this$fastCoerceAtMost$iv$iv$iv;
        int $this$fastCoerceAtMost$iv$iv$iv3;
        int i = 0;
        Object obj = this;
        int i7 = 0;
        int i10 = -1073741824;
        int i13 = 1073741824;
        int i19 = 0;
        int i22 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv2, i10) < 0) {
            $this$fastCoerceAtMost$iv$iv$iv2 = i10;
        }
        int i23 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv2, i13) > 0) {
            $this$fastCoerceAtMost$iv$iv$iv2 = i13;
        }
        v[i] = $this$fastCoerceAtMost$iv$iv$iv2;
        int i2 = 1;
        Object obj2 = this;
        int i8 = 0;
        int i11 = -1073741824;
        int i14 = 1073741824;
        int i20 = 0;
        int i24 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv, i11) < 0) {
            $this$fastCoerceAtMost$iv$iv$iv = i11;
        }
        int i25 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv, i14) > 0) {
            $this$fastCoerceAtMost$iv$iv$iv = i14;
        }
        v[i2] = $this$fastCoerceAtMost$iv$iv$iv;
        int i3 = 2;
        Object obj3 = this;
        int i9 = 0;
        int i12 = -1073741824;
        int i15 = 1073741824;
        int i21 = 0;
        int i26 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv3, i12) < 0) {
            $this$fastCoerceAtMost$iv$iv$iv3 = i12;
        }
        int i27 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv3, i15) > 0) {
            $this$fastCoerceAtMost$iv$iv$iv3 = i15;
        }
        v[i3] = $this$fastCoerceAtMost$iv$iv$iv3;
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        int $this$fastCoerceAtLeast$iv$iv$iv;
        final Object obj = this;
        final int i = 0;
        final int i2 = -1073741824;
        final int i3 = 1073741824;
        final int i5 = 0;
        int i6 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv$iv, i2) < 0) {
            $this$fastCoerceAtLeast$iv$iv$iv = i2;
        }
        int i7 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv$iv, i3) > 0) {
            $this$fastCoerceAtLeast$iv$iv$iv = i3;
        }
        return $this$fastCoerceAtLeast$iv$iv$iv;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long xyzaToColor-JlNiLsg$ui_graphics_release(float x, float y, float z, float a, androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        int $this$fastCoerceAtMost$iv$iv$iv3;
        int $this$fastCoerceAtMost$iv$iv$iv2;
        int $this$fastCoerceAtMost$iv$iv$iv;
        Object obj = this;
        int i = 0;
        int i4 = -1073741824;
        int i7 = 1073741824;
        int i13 = 0;
        int i16 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv3, i4) < 0) {
            $this$fastCoerceAtMost$iv$iv$iv3 = i4;
        }
        int i17 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv3, i7) > 0) {
            $this$fastCoerceAtMost$iv$iv$iv3 = i7;
        }
        Object this_$iv = this;
        int i2 = 0;
        int i5 = -1073741824;
        int i8 = 1073741824;
        int i14 = 0;
        int i18 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv2, i5) < 0) {
            $this$fastCoerceAtMost$iv$iv$iv2 = i5;
        }
        int i19 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv2, i8) > 0) {
            $this$fastCoerceAtMost$iv$iv$iv2 = i8;
        }
        Object this_$iv2 = this;
        int i3 = 0;
        int i6 = -1073741824;
        int i9 = 1073741824;
        int i15 = 0;
        int i20 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv, i6) < 0) {
            $this$fastCoerceAtMost$iv$iv$iv = i6;
        }
        int i21 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv$iv, i9) > 0) {
            $this$fastCoerceAtMost$iv$iv$iv = i9;
        }
        return ColorKt.Color($this$fastCoerceAtMost$iv$iv$iv3, $this$fastCoerceAtMost$iv$iv$iv2, $this$fastCoerceAtMost$iv$iv$iv, a, colorSpace);
    }
}
