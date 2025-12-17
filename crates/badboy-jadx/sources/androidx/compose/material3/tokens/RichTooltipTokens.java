package androidx.compose.material3.tokens;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u000eR\u0011\u0010 \u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0006R\u0011\u0010\"\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/material3/tokens/RichTooltipTokens;", "", "()V", "ActionFocusLabelTextColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActionFocusLabelTextColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActionHoverLabelTextColor", "getActionHoverLabelTextColor", "ActionLabelTextColor", "getActionLabelTextColor", "ActionLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getActionLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "ActionPressedLabelTextColor", "getActionPressedLabelTextColor", "ContainerColor", "getContainerColor", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "SubheadColor", "getSubheadColor", "SubheadFont", "getSubheadFont", "SupportingTextColor", "getSupportingTextColor", "SupportingTextFont", "getSupportingTextFont", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RichTooltipTokens {

    public static final int $stable;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActionFocusLabelTextColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActionHoverLabelTextColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActionLabelTextColor;
    private static final androidx.compose.material3.tokens.TypographyKeyTokens ActionLabelTextFont;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActionPressedLabelTextColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens ContainerShape;
    public static final androidx.compose.material3.tokens.RichTooltipTokens INSTANCE;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SubheadColor;
    private static final androidx.compose.material3.tokens.TypographyKeyTokens SubheadFont;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SupportingTextColor;
    private static final androidx.compose.material3.tokens.TypographyKeyTokens SupportingTextFont;
    static {
        RichTooltipTokens richTooltipTokens = new RichTooltipTokens();
        RichTooltipTokens.INSTANCE = richTooltipTokens;
        RichTooltipTokens.ActionFocusLabelTextColor = ColorSchemeKeyTokens.Primary;
        RichTooltipTokens.ActionHoverLabelTextColor = ColorSchemeKeyTokens.Primary;
        RichTooltipTokens.ActionLabelTextColor = ColorSchemeKeyTokens.Primary;
        RichTooltipTokens.ActionLabelTextFont = TypographyKeyTokens.LabelLarge;
        RichTooltipTokens.ActionPressedLabelTextColor = ColorSchemeKeyTokens.Primary;
        RichTooltipTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        RichTooltipTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
        RichTooltipTokens.ContainerShape = ShapeKeyTokens.CornerMedium;
        RichTooltipTokens.SubheadColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        RichTooltipTokens.SubheadFont = TypographyKeyTokens.TitleSmall;
        RichTooltipTokens.SupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        RichTooltipTokens.SupportingTextFont = TypographyKeyTokens.BodyMedium;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActionFocusLabelTextColor() {
        return RichTooltipTokens.ActionFocusLabelTextColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActionHoverLabelTextColor() {
        return RichTooltipTokens.ActionHoverLabelTextColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActionLabelTextColor() {
        return RichTooltipTokens.ActionLabelTextColor;
    }

    public final androidx.compose.material3.tokens.TypographyKeyTokens getActionLabelTextFont() {
        return RichTooltipTokens.ActionLabelTextFont;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActionPressedLabelTextColor() {
        return RichTooltipTokens.ActionPressedLabelTextColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getContainerColor() {
        return RichTooltipTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return RichTooltipTokens.ContainerElevation;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getContainerShape() {
        return RichTooltipTokens.ContainerShape;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSubheadColor() {
        return RichTooltipTokens.SubheadColor;
    }

    public final androidx.compose.material3.tokens.TypographyKeyTokens getSubheadFont() {
        return RichTooltipTokens.SubheadFont;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSupportingTextColor() {
        return RichTooltipTokens.SupportingTextColor;
    }

    public final androidx.compose.material3.tokens.TypographyKeyTokens getSupportingTextFont() {
        return RichTooltipTokens.SupportingTextFont;
    }
}
