package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0017\u0018\u0000 \u00082\u00020\u0001:\u0001\u0008B\u0013\u0008\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\t", d2 = {"Landroidx/compose/ui/graphics/ColorFilter;", "", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "(Landroid/graphics/ColorFilter;)V", "getNativeColorFilter$ui_graphics_release", "()Landroid/graphics/ColorFilter;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ColorFilter {

    public static final androidx.compose.ui.graphics.ColorFilter.Companion Companion;
    private final ColorFilter nativeColorFilter;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007J\"\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/ColorFilter$Companion;", "", "()V", "colorMatrix", "Landroidx/compose/ui/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/ColorMatrix;", "colorMatrix-jHG-Opc", "([F)Landroidx/compose/ui/graphics/ColorFilter;", "lighting", "multiply", "Landroidx/compose/ui/graphics/Color;", "add", "lighting--OWjLjI", "(JJ)Landroidx/compose/ui/graphics/ColorFilter;", "tint", "color", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "tint-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static androidx.compose.ui.graphics.ColorFilter tint-xETnrds$default(androidx.compose.ui.graphics.ColorFilter.Companion colorFilter$Companion, long l2, int i3, int i4, Object object5) {
            int obj3;
            if (object5 &= 2 != 0) {
                obj3 = BlendMode.Companion.getSrcIn-0nO6VwU();
            }
            return companion.tint-xETnrds(l2, i3);
        }

        public final androidx.compose.ui.graphics.ColorFilter colorMatrix-jHG-Opc(float[] colorMatrix) {
            ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix, 0);
            return (ColorFilter)colorMatrixColorFilter;
        }

        public final androidx.compose.ui.graphics.ColorFilter lighting--OWjLjI(long multiply, long add) {
            LightingColorFilter lightingColorFilter = new LightingColorFilter(multiply, obj2, obj9, obj4, 0);
            return (ColorFilter)lightingColorFilter;
        }

        public final androidx.compose.ui.graphics.ColorFilter tint-xETnrds(long color, int blendMode) {
            BlendModeColorFilter blendModeColorFilter = new BlendModeColorFilter(color, blendMode, obj5, 0);
            return (ColorFilter)blendModeColorFilter;
        }
    }
    static {
        ColorFilter.Companion companion = new ColorFilter.Companion(0);
        ColorFilter.Companion = companion;
    }

    public ColorFilter(ColorFilter nativeColorFilter) {
        super();
        this.nativeColorFilter = nativeColorFilter;
    }

    public final ColorFilter getNativeColorFilter$ui_graphics_release() {
        return this.nativeColorFilter;
    }
}
