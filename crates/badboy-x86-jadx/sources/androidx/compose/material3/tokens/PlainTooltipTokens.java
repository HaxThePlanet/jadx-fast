package androidx.compose.material3.tokens;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0011", d2 = {"Landroidx/compose/material3/tokens/PlainTooltipTokens;", "", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "SupportingTextColor", "getSupportingTextColor", "SupportingTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getSupportingTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlainTooltipTokens {

    public static final int $stable;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ContainerColor;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens ContainerShape;
    public static final androidx.compose.material3.tokens.PlainTooltipTokens INSTANCE;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SupportingTextColor;
    private static final androidx.compose.material3.tokens.TypographyKeyTokens SupportingTextFont;
    static {
        PlainTooltipTokens plainTooltipTokens = new PlainTooltipTokens();
        PlainTooltipTokens.INSTANCE = plainTooltipTokens;
        PlainTooltipTokens.ContainerColor = ColorSchemeKeyTokens.InverseSurface;
        PlainTooltipTokens.ContainerShape = ShapeKeyTokens.CornerExtraSmall;
        PlainTooltipTokens.SupportingTextColor = ColorSchemeKeyTokens.InverseOnSurface;
        PlainTooltipTokens.SupportingTextFont = TypographyKeyTokens.BodySmall;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getContainerColor() {
        return PlainTooltipTokens.ContainerColor;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getContainerShape() {
        return PlainTooltipTokens.ContainerShape;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSupportingTextColor() {
        return PlainTooltipTokens.SupportingTextColor;
    }

    public final androidx.compose.material3.tokens.TypographyKeyTokens getSupportingTextFont() {
        return PlainTooltipTokens.SupportingTextFont;
    }
}
