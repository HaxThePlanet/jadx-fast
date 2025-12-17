package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008&\u0018\u0000 72\u00020\u0001:\u00017B\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0013\u0010\u0017\u001a\u00020\u000f2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0007J\u0012\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0001\u0010\u001f\u001a\u00020\u001aH'J\u0012\u0010 \u001a\u00020\u001c2\u0008\u0008\u0001\u0010!\u001a\u00020\u0008H&J\u0012\u0010\"\u001a\u00020\u001c2\u0008\u0008\u0001\u0010!\u001a\u00020\u0008H&J\u0008\u0010#\u001a\u00020\u0008H\u0016J\u0008\u0010$\u001a\u00020\u0003H\u0016J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001cH\u0010¢\u0006\u0002\u0008*J \u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001cH\u0007J\u0012\u0010+\u001a\u00020\u001a2\u0008\u0008\u0001\u0010\u001f\u001a\u00020\u001aH'J%\u0010/\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001cH\u0010¢\u0006\u0002\u00080J=\u00101\u001a\u0002022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u0000H\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00085\u00106R\u0011\u0010\n\u001a\u00020\u00088G¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0007\u001a\u00020\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0010R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00068", d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "", "name", "", "model", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "id", "", "(Ljava/lang/String;JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "componentCount", "getComponentCount", "()I", "getId$ui_graphics_release", "isSrgb", "", "()Z", "isWideGamut", "getModel-xdoWZVw", "()J", "J", "getName", "()Ljava/lang/String;", "equals", "other", "fromXyz", "", "x", "", "y", "z", "v", "getMaxValue", "component", "getMinValue", "hashCode", "toString", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "r", "g", "b", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ColorSpace {

    public static final androidx.compose.ui.graphics.colorspace.ColorSpace.Companion Companion = null;
    public static final int MaxId = 63;
    public static final int MinId = -1;
    private final int id;
    private final long model;
    private final String name;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpace$Companion;", "", "()V", "MaxId", "", "MinId", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        ColorSpace.Companion companion = new ColorSpace.Companion(0);
        ColorSpace.Companion = companion;
    }

    private ColorSpace(String name, long model) {
        super(name, model, obj3, -1, 0);
    }

    private ColorSpace(String name, long model, int id) {
        int i2;
        int i;
        int i3;
        super();
        this.name = name;
        this.model = model;
        this.id = obj6;
        i2 = (CharSequence)this.name.length() == 0 ? 1 : 0;
        if (i2 != 0) {
        } else {
            if (this.id < -1) {
            } else {
                if (this.id > 63) {
                } else {
                }
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("The id must be between -1 and 63");
            throw illegalArgumentException2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        throw illegalArgumentException;
    }

    public ColorSpace(String string, long l2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(string, l2, i3, defaultConstructorMarker4);
    }

    public ColorSpace(String string, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(string, l2, defaultConstructorMarker3);
    }

    public boolean equals(Object other) {
        boolean equals-impl0;
        Class class2;
        long equal;
        Class class;
        long model;
        if (this == other) {
            return 1;
        }
        equals-impl0 = 0;
        if (other != null) {
            if (getClass() != other.getClass()) {
            } else {
                Object obj = other;
                if (this.id != obj.id) {
                    return equals-impl0;
                }
                String name2 = obj.name;
                if (!Intrinsics.areEqual(this.name, name2)) {
                } else {
                    equals-impl0 = ColorModel.equals-impl0(this.model, name2);
                }
            }
            return equals-impl0;
        }
        return equals-impl0;
    }

    public final float[] fromXyz(float x, float y, float z) {
        float[] fArr = new float[ColorModel.getComponentCount-impl(this.model)];
        fArr[0] = x;
        fArr[1] = y;
        fArr[2] = z;
        return fromXyz(fArr);
    }

    public abstract float[] fromXyz(float[] fArr);

    public final int getComponentCount() {
        return ColorModel.getComponentCount-impl(this.model);
    }

    public final int getId$ui_graphics_release() {
        return this.id;
    }

    public abstract float getMaxValue(int i);

    public abstract float getMinValue(int i);

    public final long getModel-xdoWZVw() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return result += i6;
    }

    public boolean isSrgb() {
        return 0;
    }

    public abstract boolean isWideGamut();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(this.name).append(" (id=").append(this.id).append(", model=").append(ColorModel.toString-impl(this.model)).append(')').toString();
    }

    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        final float[] xyz = toXyz(v0, v1, v2);
        final int i3 = 0;
        return i5 | i6;
    }

    public final float[] toXyz(float r, float g, float b) {
        float[] fArr = new float[3];
        return toXyz(fArr);
    }

    public abstract float[] toXyz(float[] fArr);

    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        return toXyz(v0, v1, v2)[2];
    }

    public long xyzaToColor-JlNiLsg$ui_graphics_release(float x, float y, float z, float a, androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        final float[] xyz = fromXyz(x, y, z);
        return ColorKt.Color(xyz[0], xyz[1], xyz[2], a, colorSpace);
    }
}
