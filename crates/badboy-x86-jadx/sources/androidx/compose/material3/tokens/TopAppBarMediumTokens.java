package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u000c\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u001d\u0010\nR\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0006R\u0019\u0010 \u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008!\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\"", d2 = {"Landroidx/compose/material3/tokens/TopAppBarMediumTokens;", "", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerSurfaceTintLayerColor", "getContainerSurfaceTintLayerColor", "HeadlineColor", "getHeadlineColor", "HeadlineFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getHeadlineFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "LeadingIconColor", "getLeadingIconColor", "LeadingIconSize", "getLeadingIconSize-D9Ej5fM", "TrailingIconColor", "getTrailingIconColor", "TrailingIconSize", "getTrailingIconSize-D9Ej5fM", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TopAppBarMediumTokens {

    public static final int $stable;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final float ContainerHeight;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens ContainerShape;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ContainerSurfaceTintLayerColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens HeadlineColor;
    private static final androidx.compose.material3.tokens.TypographyKeyTokens HeadlineFont;
    public static final androidx.compose.material3.tokens.TopAppBarMediumTokens INSTANCE;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens LeadingIconColor;
    private static final float LeadingIconSize;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens TrailingIconColor;
    private static final float TrailingIconSize;
    static {
        TopAppBarMediumTokens topAppBarMediumTokens = new TopAppBarMediumTokens();
        TopAppBarMediumTokens.INSTANCE = topAppBarMediumTokens;
        TopAppBarMediumTokens.ContainerColor = ColorSchemeKeyTokens.Surface;
        TopAppBarMediumTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        int i = 0;
        TopAppBarMediumTokens.ContainerHeight = Dp.constructor-impl((float)l);
        TopAppBarMediumTokens.ContainerShape = ShapeKeyTokens.CornerNone;
        TopAppBarMediumTokens.ContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;
        TopAppBarMediumTokens.HeadlineColor = ColorSchemeKeyTokens.OnSurface;
        TopAppBarMediumTokens.HeadlineFont = TypographyKeyTokens.HeadlineSmall;
        TopAppBarMediumTokens.LeadingIconColor = ColorSchemeKeyTokens.OnSurface;
        int i2 = 0;
        TopAppBarMediumTokens.LeadingIconSize = Dp.constructor-impl((float)l2);
        TopAppBarMediumTokens.TrailingIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        int i3 = 0;
        TopAppBarMediumTokens.TrailingIconSize = Dp.constructor-impl((float)l3);
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getContainerColor() {
        return TopAppBarMediumTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return TopAppBarMediumTokens.ContainerElevation;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return TopAppBarMediumTokens.ContainerHeight;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getContainerShape() {
        return TopAppBarMediumTokens.ContainerShape;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getContainerSurfaceTintLayerColor() {
        return TopAppBarMediumTokens.ContainerSurfaceTintLayerColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getHeadlineColor() {
        return TopAppBarMediumTokens.HeadlineColor;
    }

    public final androidx.compose.material3.tokens.TypographyKeyTokens getHeadlineFont() {
        return TopAppBarMediumTokens.HeadlineFont;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getLeadingIconColor() {
        return TopAppBarMediumTokens.LeadingIconColor;
    }

    public final float getLeadingIconSize-D9Ej5fM() {
        return TopAppBarMediumTokens.LeadingIconSize;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getTrailingIconColor() {
        return TopAppBarMediumTokens.TrailingIconColor;
    }

    public final float getTrailingIconSize-D9Ej5fM() {
        return TopAppBarMediumTokens.TrailingIconSize;
    }
}
