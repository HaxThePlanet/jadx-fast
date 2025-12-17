package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u000c\u0010\n\u001a\u00020\u000b*\u00020\u000bH\u0000\u001a\u000c\u0010\u000c\u001a\u00020\u000b*\u00020\u000bH\u0000\u001a\u0014\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0000\u001a\u000c\u0010\u000e\u001a\u00020\u000b*\u00020\u000bH\u0000\u001a\u000c\u0010\u000f\u001a\u00020\u000b*\u00020\u000bH\u0000\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078AX\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0010", d2 = {"LocalShapes", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/Shapes;", "getLocalShapes", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "value", "Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getValue", "(Landroidx/compose/material3/tokens/ShapeKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "bottom", "Landroidx/compose/foundation/shape/CornerBasedShape;", "end", "fromToken", "start", "top", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShapesKt {

    private static final ProvidableCompositionLocal<androidx.compose.material3.Shapes> LocalShapes;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal5;
            int ordinal6;
            int ordinal7;
            int ordinal4;
            int ordinal11;
            int ordinal3;
            int ordinal2;
            int ordinal8;
            int ordinal;
            int ordinal9;
            int ordinal10;
            int[] iArr = new int[values.length];
            iArr[ShapeKeyTokens.CornerExtraLarge.ordinal()] = 1;
            iArr[ShapeKeyTokens.CornerExtraLargeTop.ordinal()] = 2;
            iArr[ShapeKeyTokens.CornerExtraSmall.ordinal()] = 3;
            iArr[ShapeKeyTokens.CornerExtraSmallTop.ordinal()] = 4;
            iArr[ShapeKeyTokens.CornerFull.ordinal()] = 5;
            iArr[ShapeKeyTokens.CornerLarge.ordinal()] = 6;
            iArr[ShapeKeyTokens.CornerLargeEnd.ordinal()] = 7;
            iArr[ShapeKeyTokens.CornerLargeTop.ordinal()] = 8;
            iArr[ShapeKeyTokens.CornerMedium.ordinal()] = 9;
            try {
                iArr[ShapeKeyTokens.CornerNone.ordinal()] = 10;
                iArr[ShapeKeyTokens.CornerSmall.ordinal()] = 11;
                ShapesKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
            } catch (java.lang.NoSuchFieldError e) {
            }
        }
    }
    static {
        ShapesKt.LocalShapes = CompositionLocalKt.staticCompositionLocalOf((Function0)ShapesKt.LocalShapes.1.INSTANCE);
    }

    public static final CornerBasedShape bottom(CornerBasedShape $this$bottom) {
        int i3 = 0;
        int i4 = 0;
        return CornerBasedShape.copy$default($this$bottom, CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl((float)i)), CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl((float)i2)), 0, 0, 12, 0);
    }

    public static final CornerBasedShape end(CornerBasedShape $this$end) {
        int i3 = 0;
        int i4 = 0;
        return CornerBasedShape.copy$default($this$end, CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl((float)i)), 0, 0, CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl((float)i2)), 6, 0);
    }

    public static final Shape fromToken(androidx.compose.material3.Shapes $this$fromToken, ShapeKeyTokens value) {
        Shape rectangleShape;
        switch (i) {
            case 1:
                rectangleShape = $this$fromToken.getExtraLarge();
                break;
            case 2:
                rectangleShape = ShapesKt.top($this$fromToken.getExtraLarge());
                break;
            case 3:
                rectangleShape = $this$fromToken.getExtraSmall();
                break;
            case 4:
                rectangleShape = ShapesKt.top($this$fromToken.getExtraSmall());
                break;
            case 5:
                rectangleShape = RoundedCornerShapeKt.getCircleShape();
                break;
            case 6:
                rectangleShape = $this$fromToken.getLarge();
                break;
            case 7:
                rectangleShape = ShapesKt.end($this$fromToken.getLarge());
                break;
            case 8:
                rectangleShape = ShapesKt.top($this$fromToken.getLarge());
                break;
            case 9:
                rectangleShape = $this$fromToken.getMedium();
                break;
            case 10:
                rectangleShape = RectangleShapeKt.getRectangleShape();
                break;
            case 11:
                rectangleShape = $this$fromToken.getSmall();
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return rectangleShape;
    }

    public static final ProvidableCompositionLocal<androidx.compose.material3.Shapes> getLocalShapes() {
        return ShapesKt.LocalShapes;
    }

    public static final Shape getValue(ShapeKeyTokens $this$value, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1629172543;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C191@7815L6:Shapes.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.<get-value> (Shapes.kt:191)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.fromToken(MaterialTheme.INSTANCE.getShapes($composer, 6), $this$value);
    }

    public static final CornerBasedShape start(CornerBasedShape $this$start) {
        int i3 = 0;
        int i4 = 0;
        return CornerBasedShape.copy$default($this$start, 0, CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl((float)i)), CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl((float)i2)), 0, 9, 0);
    }

    public static final CornerBasedShape top(CornerBasedShape $this$top) {
        int i3 = 0;
        int i4 = 0;
        return CornerBasedShape.copy$default($this$top, 0, 0, CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl((float)i2)), CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl((float)i)), 3, 0);
    }
}
