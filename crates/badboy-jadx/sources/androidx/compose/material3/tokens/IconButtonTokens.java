package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0006R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u001b\u0010\u000cR\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0006R\u0011\u0010 \u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0006R\u0011\u0010\"\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/material3/tokens/IconButtonTokens;", "", "()V", "DisabledIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDisabledIconColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledIconOpacity", "", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "SelectedFocusIconColor", "getSelectedFocusIconColor", "SelectedHoverIconColor", "getSelectedHoverIconColor", "SelectedIconColor", "getSelectedIconColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "StateLayerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getStateLayerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "UnselectedFocusIconColor", "getUnselectedFocusIconColor", "UnselectedHoverIconColor", "getUnselectedHoverIconColor", "UnselectedIconColor", "getUnselectedIconColor", "UnselectedPressedIconColor", "getUnselectedPressedIconColor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IconButtonTokens {

    public static final int $stable = 0;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens DisabledIconColor = null;
    public static final float DisabledIconOpacity = 0.38f;
    public static final androidx.compose.material3.tokens.IconButtonTokens INSTANCE;
    private static final float IconSize;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedFocusIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedHoverIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedPressedIconColor;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens StateLayerShape;
    private static final float StateLayerSize;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedFocusIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedHoverIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedPressedIconColor;
    static {
        IconButtonTokens iconButtonTokens = new IconButtonTokens();
        IconButtonTokens.INSTANCE = iconButtonTokens;
        IconButtonTokens.DisabledIconColor = ColorSchemeKeyTokens.OnSurface;
        int i = 0;
        IconButtonTokens.IconSize = Dp.constructor-impl((float)l);
        IconButtonTokens.SelectedFocusIconColor = ColorSchemeKeyTokens.Primary;
        IconButtonTokens.SelectedHoverIconColor = ColorSchemeKeyTokens.Primary;
        IconButtonTokens.SelectedIconColor = ColorSchemeKeyTokens.Primary;
        IconButtonTokens.SelectedPressedIconColor = ColorSchemeKeyTokens.Primary;
        IconButtonTokens.StateLayerShape = ShapeKeyTokens.CornerFull;
        int i2 = 0;
        IconButtonTokens.StateLayerSize = Dp.constructor-impl((float)l2);
        IconButtonTokens.UnselectedFocusIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        IconButtonTokens.UnselectedHoverIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        IconButtonTokens.UnselectedIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        IconButtonTokens.UnselectedPressedIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getDisabledIconColor() {
        return IconButtonTokens.DisabledIconColor;
    }

    public final float getIconSize-D9Ej5fM() {
        return IconButtonTokens.IconSize;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedFocusIconColor() {
        return IconButtonTokens.SelectedFocusIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedHoverIconColor() {
        return IconButtonTokens.SelectedHoverIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedIconColor() {
        return IconButtonTokens.SelectedIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedPressedIconColor() {
        return IconButtonTokens.SelectedPressedIconColor;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getStateLayerShape() {
        return IconButtonTokens.StateLayerShape;
    }

    public final float getStateLayerSize-D9Ej5fM() {
        return IconButtonTokens.StateLayerSize;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedFocusIconColor() {
        return IconButtonTokens.UnselectedFocusIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedHoverIconColor() {
        return IconButtonTokens.UnselectedHoverIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedIconColor() {
        return IconButtonTokens.UnselectedIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedPressedIconColor() {
        return IconButtonTokens.UnselectedPressedIconColor;
    }
}
