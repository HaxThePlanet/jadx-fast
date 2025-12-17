package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008f\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0003À\u0006\u0001", d2 = {"Landroidx/compose/ui/graphics/PathEffect;", "", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PathEffect {

    public static final androidx.compose.ui.graphics.PathEffect.Companion Companion;

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\tJ0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"Landroidx/compose/ui/graphics/PathEffect$Companion;", "", "()V", "chainPathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "outer", "inner", "cornerPathEffect", "radius", "", "dashPathEffect", "intervals", "", "phase", "stampedPathEffect", "shape", "Landroidx/compose/ui/graphics/Path;", "advance", "style", "Landroidx/compose/ui/graphics/StampedPathEffectStyle;", "stampedPathEffect-7aD1DOk", "(Landroidx/compose/ui/graphics/Path;FFI)Landroidx/compose/ui/graphics/PathEffect;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.graphics.PathEffect.Companion $$INSTANCE;
        static {
            PathEffect.Companion companion = new PathEffect.Companion();
            PathEffect.Companion.$$INSTANCE = companion;
        }

        public static androidx.compose.ui.graphics.PathEffect dashPathEffect$default(androidx.compose.ui.graphics.PathEffect.Companion pathEffect$Companion, float[] f2Arr2, float f3, int i4, Object object5) {
            int obj2;
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            return companion.dashPathEffect(f2Arr2, obj2);
        }

        public final androidx.compose.ui.graphics.PathEffect chainPathEffect(androidx.compose.ui.graphics.PathEffect outer, androidx.compose.ui.graphics.PathEffect inner) {
            return AndroidPathEffect_androidKt.actualChainPathEffect(outer, inner);
        }

        public final androidx.compose.ui.graphics.PathEffect cornerPathEffect(float radius) {
            return AndroidPathEffect_androidKt.actualCornerPathEffect(radius);
        }

        public final androidx.compose.ui.graphics.PathEffect dashPathEffect(float[] intervals, float phase) {
            return AndroidPathEffect_androidKt.actualDashPathEffect(intervals, phase);
        }

        public final androidx.compose.ui.graphics.PathEffect stampedPathEffect-7aD1DOk(androidx.compose.ui.graphics.Path shape, float advance, float phase, int style) {
            return AndroidPathEffect_androidKt.actualStampedPathEffect-7aD1DOk(shape, advance, phase, style);
        }
    }
    static {
        PathEffect.Companion = PathEffect.Companion.$$INSTANCE;
    }
}
