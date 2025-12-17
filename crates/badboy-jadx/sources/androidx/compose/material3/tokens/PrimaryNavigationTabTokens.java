package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0006R\u0019\u0010\u0011\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0006R\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0006R\u0011\u0010 \u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0006R\u0019\u0010\"\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\u0008#\u0010\u0014R\u0019\u0010$\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\u0008%\u0010\u0014R\u0011\u0010&\u001a\u00020'¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0019\u0010*\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\u0008+\u0010\u0014R\u0019\u0010,\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\u0008-\u0010\u0014R\u0011\u0010.\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010\u0006R\u0011\u00100\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u0006R\u0011\u00102\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010\u0006R\u0011\u00104\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010\u0006R\u0011\u00106\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010\u0006R\u0011\u00108\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010\u0006R\u0011\u0010:\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010\u0006R\u0011\u0010<\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010\u0006R\u0011\u0010>\u001a\u00020?¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010A\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006B", d2 = {"Landroidx/compose/material3/tokens/PrimaryNavigationTabTokens;", "", "()V", "ActiveFocusIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveFocusIconColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveFocusLabelTextColor", "getActiveFocusLabelTextColor", "ActiveHoverIconColor", "getActiveHoverIconColor", "ActiveHoverLabelTextColor", "getActiveHoverLabelTextColor", "ActiveIconColor", "getActiveIconColor", "ActiveIndicatorColor", "getActiveIndicatorColor", "ActiveIndicatorHeight", "Landroidx/compose/ui/unit/Dp;", "getActiveIndicatorHeight-D9Ej5fM", "()F", "F", "ActiveIndicatorShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getActiveIndicatorShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "ActiveLabelTextColor", "getActiveLabelTextColor", "ActivePressedIconColor", "getActivePressedIconColor", "ActivePressedLabelTextColor", "getActivePressedLabelTextColor", "ContainerColor", "getContainerColor", "ContainerElevation", "getContainerElevation-D9Ej5fM", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "IconAndLabelTextContainerHeight", "getIconAndLabelTextContainerHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "InactiveFocusIconColor", "getInactiveFocusIconColor", "InactiveFocusLabelTextColor", "getInactiveFocusLabelTextColor", "InactiveHoverIconColor", "getInactiveHoverIconColor", "InactiveHoverLabelTextColor", "getInactiveHoverLabelTextColor", "InactiveIconColor", "getInactiveIconColor", "InactiveLabelTextColor", "getInactiveLabelTextColor", "InactivePressedIconColor", "getInactivePressedIconColor", "InactivePressedLabelTextColor", "getInactivePressedLabelTextColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PrimaryNavigationTabTokens {

    public static final int $stable;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActiveFocusIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActiveFocusLabelTextColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActiveHoverIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActiveHoverLabelTextColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActiveIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActiveIndicatorColor;
    private static final float ActiveIndicatorHeight;
    private static final RoundedCornerShape ActiveIndicatorShape;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActiveLabelTextColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActivePressedIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActivePressedLabelTextColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final float ContainerHeight;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens ContainerShape;
    public static final androidx.compose.material3.tokens.PrimaryNavigationTabTokens INSTANCE;
    private static final float IconAndLabelTextContainerHeight;
    private static final float IconSize;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens InactiveFocusIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens InactiveFocusLabelTextColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens InactiveHoverIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens InactiveHoverLabelTextColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens InactiveIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens InactiveLabelTextColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens InactivePressedIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens InactivePressedLabelTextColor;
    private static final androidx.compose.material3.tokens.TypographyKeyTokens LabelTextFont;
    static {
        PrimaryNavigationTabTokens primaryNavigationTabTokens = new PrimaryNavigationTabTokens();
        PrimaryNavigationTabTokens.INSTANCE = primaryNavigationTabTokens;
        PrimaryNavigationTabTokens.ActiveIndicatorColor = ColorSchemeKeyTokens.Primary;
        int i = 0;
        PrimaryNavigationTabTokens.ActiveIndicatorHeight = Dp.constructor-impl((float)l);
        int i2 = 0;
        PrimaryNavigationTabTokens.ActiveIndicatorShape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)l2));
        PrimaryNavigationTabTokens.ContainerColor = ColorSchemeKeyTokens.Surface;
        PrimaryNavigationTabTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        int i3 = 0;
        PrimaryNavigationTabTokens.ContainerHeight = Dp.constructor-impl((float)l3);
        PrimaryNavigationTabTokens.ContainerShape = ShapeKeyTokens.CornerNone;
        PrimaryNavigationTabTokens.ActiveFocusIconColor = ColorSchemeKeyTokens.Primary;
        PrimaryNavigationTabTokens.ActiveHoverIconColor = ColorSchemeKeyTokens.Primary;
        PrimaryNavigationTabTokens.ActiveIconColor = ColorSchemeKeyTokens.Primary;
        PrimaryNavigationTabTokens.ActivePressedIconColor = ColorSchemeKeyTokens.Primary;
        int i4 = 0;
        PrimaryNavigationTabTokens.IconAndLabelTextContainerHeight = Dp.constructor-impl((float)l4);
        int i5 = 0;
        PrimaryNavigationTabTokens.IconSize = Dp.constructor-impl((float)l5);
        PrimaryNavigationTabTokens.InactiveFocusIconColor = ColorSchemeKeyTokens.OnSurface;
        PrimaryNavigationTabTokens.InactiveHoverIconColor = ColorSchemeKeyTokens.OnSurface;
        PrimaryNavigationTabTokens.InactiveIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        PrimaryNavigationTabTokens.InactivePressedIconColor = ColorSchemeKeyTokens.OnSurface;
        PrimaryNavigationTabTokens.ActiveFocusLabelTextColor = ColorSchemeKeyTokens.Primary;
        PrimaryNavigationTabTokens.ActiveHoverLabelTextColor = ColorSchemeKeyTokens.Primary;
        PrimaryNavigationTabTokens.ActiveLabelTextColor = ColorSchemeKeyTokens.Primary;
        PrimaryNavigationTabTokens.ActivePressedLabelTextColor = ColorSchemeKeyTokens.Primary;
        PrimaryNavigationTabTokens.InactiveFocusLabelTextColor = ColorSchemeKeyTokens.OnSurface;
        PrimaryNavigationTabTokens.InactiveHoverLabelTextColor = ColorSchemeKeyTokens.OnSurface;
        PrimaryNavigationTabTokens.InactiveLabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        PrimaryNavigationTabTokens.InactivePressedLabelTextColor = ColorSchemeKeyTokens.OnSurface;
        PrimaryNavigationTabTokens.LabelTextFont = TypographyKeyTokens.TitleSmall;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActiveFocusIconColor() {
        return PrimaryNavigationTabTokens.ActiveFocusIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActiveFocusLabelTextColor() {
        return PrimaryNavigationTabTokens.ActiveFocusLabelTextColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActiveHoverIconColor() {
        return PrimaryNavigationTabTokens.ActiveHoverIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActiveHoverLabelTextColor() {
        return PrimaryNavigationTabTokens.ActiveHoverLabelTextColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActiveIconColor() {
        return PrimaryNavigationTabTokens.ActiveIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActiveIndicatorColor() {
        return PrimaryNavigationTabTokens.ActiveIndicatorColor;
    }

    public final float getActiveIndicatorHeight-D9Ej5fM() {
        return PrimaryNavigationTabTokens.ActiveIndicatorHeight;
    }

    public final RoundedCornerShape getActiveIndicatorShape() {
        return PrimaryNavigationTabTokens.ActiveIndicatorShape;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActiveLabelTextColor() {
        return PrimaryNavigationTabTokens.ActiveLabelTextColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActivePressedIconColor() {
        return PrimaryNavigationTabTokens.ActivePressedIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActivePressedLabelTextColor() {
        return PrimaryNavigationTabTokens.ActivePressedLabelTextColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getContainerColor() {
        return PrimaryNavigationTabTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return PrimaryNavigationTabTokens.ContainerElevation;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return PrimaryNavigationTabTokens.ContainerHeight;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getContainerShape() {
        return PrimaryNavigationTabTokens.ContainerShape;
    }

    public final float getIconAndLabelTextContainerHeight-D9Ej5fM() {
        return PrimaryNavigationTabTokens.IconAndLabelTextContainerHeight;
    }

    public final float getIconSize-D9Ej5fM() {
        return PrimaryNavigationTabTokens.IconSize;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getInactiveFocusIconColor() {
        return PrimaryNavigationTabTokens.InactiveFocusIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getInactiveFocusLabelTextColor() {
        return PrimaryNavigationTabTokens.InactiveFocusLabelTextColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getInactiveHoverIconColor() {
        return PrimaryNavigationTabTokens.InactiveHoverIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getInactiveHoverLabelTextColor() {
        return PrimaryNavigationTabTokens.InactiveHoverLabelTextColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getInactiveIconColor() {
        return PrimaryNavigationTabTokens.InactiveIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getInactiveLabelTextColor() {
        return PrimaryNavigationTabTokens.InactiveLabelTextColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getInactivePressedIconColor() {
        return PrimaryNavigationTabTokens.InactivePressedIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getInactivePressedLabelTextColor() {
        return PrimaryNavigationTabTokens.InactivePressedLabelTextColor;
    }

    public final androidx.compose.material3.tokens.TypographyKeyTokens getLabelTextFont() {
        return PrimaryNavigationTabTokens.LabelTextFont;
    }
}
