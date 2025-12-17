package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006R\u0019\u0010\r\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u0013\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\nR\u0019\u0010\u0016\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u0017\u0010\u0010R\u0019\u0010\u0018\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u0019\u0010\u0010R\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/material3/tokens/SheetBottomTokens;", "", "()V", "DockedContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDockedContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DockedContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getDockedContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DockedDragHandleColor", "getDockedDragHandleColor", "DockedDragHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedDragHandleHeight-D9Ej5fM", "()F", "F", "DockedDragHandleWidth", "getDockedDragHandleWidth-D9Ej5fM", "DockedMinimizedContainerShape", "getDockedMinimizedContainerShape", "DockedModalContainerElevation", "getDockedModalContainerElevation-D9Ej5fM", "DockedStandardContainerElevation", "getDockedStandardContainerElevation-D9Ej5fM", "FocusIndicatorColor", "getFocusIndicatorColor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SheetBottomTokens {

    public static final int $stable;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens DockedContainerColor;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens DockedContainerShape;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens DockedDragHandleColor;
    private static final float DockedDragHandleHeight;
    private static final float DockedDragHandleWidth;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens DockedMinimizedContainerShape;
    private static final float DockedModalContainerElevation;
    private static final float DockedStandardContainerElevation;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens FocusIndicatorColor;
    public static final androidx.compose.material3.tokens.SheetBottomTokens INSTANCE;
    static {
        SheetBottomTokens sheetBottomTokens = new SheetBottomTokens();
        SheetBottomTokens.INSTANCE = sheetBottomTokens;
        SheetBottomTokens.DockedContainerColor = ColorSchemeKeyTokens.SurfaceContainerLow;
        SheetBottomTokens.DockedContainerShape = ShapeKeyTokens.CornerExtraLargeTop;
        SheetBottomTokens.DockedDragHandleColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        int i = 0;
        SheetBottomTokens.DockedDragHandleHeight = Dp.constructor-impl((float)l);
        int i2 = 0;
        SheetBottomTokens.DockedDragHandleWidth = Dp.constructor-impl((float)l2);
        SheetBottomTokens.DockedMinimizedContainerShape = ShapeKeyTokens.CornerNone;
        SheetBottomTokens.DockedModalContainerElevation = ElevationTokens.INSTANCE.getLevel1-D9Ej5fM();
        SheetBottomTokens.DockedStandardContainerElevation = ElevationTokens.INSTANCE.getLevel1-D9Ej5fM();
        SheetBottomTokens.FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getDockedContainerColor() {
        return SheetBottomTokens.DockedContainerColor;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getDockedContainerShape() {
        return SheetBottomTokens.DockedContainerShape;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getDockedDragHandleColor() {
        return SheetBottomTokens.DockedDragHandleColor;
    }

    public final float getDockedDragHandleHeight-D9Ej5fM() {
        return SheetBottomTokens.DockedDragHandleHeight;
    }

    public final float getDockedDragHandleWidth-D9Ej5fM() {
        return SheetBottomTokens.DockedDragHandleWidth;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getDockedMinimizedContainerShape() {
        return SheetBottomTokens.DockedMinimizedContainerShape;
    }

    public final float getDockedModalContainerElevation-D9Ej5fM() {
        return SheetBottomTokens.DockedModalContainerElevation;
    }

    public final float getDockedStandardContainerElevation-D9Ej5fM() {
        return SheetBottomTokens.DockedStandardContainerElevation;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getFocusIndicatorColor() {
        return SheetBottomTokens.FocusIndicatorColor;
    }
}
