package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0012R\u0019\u0010\u001a\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u001b\u0010\u0016\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/material3/tokens/BadgeTokens;", "", "()V", "Color", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "LargeColor", "getLargeColor", "LargeLabelTextColor", "getLargeLabelTextColor", "LargeLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLargeLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "LargeShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getLargeShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "LargeSize", "Landroidx/compose/ui/unit/Dp;", "getLargeSize-D9Ej5fM", "()F", "F", "Shape", "getShape", "Size", "getSize-D9Ej5fM", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BadgeTokens {

    public static final int $stable;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens Color;
    public static final androidx.compose.material3.tokens.BadgeTokens INSTANCE;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens LargeColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens LargeLabelTextColor;
    private static final androidx.compose.material3.tokens.TypographyKeyTokens LargeLabelTextFont;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens LargeShape;
    private static final float LargeSize;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens Shape;
    private static final float Size;
    static {
        BadgeTokens badgeTokens = new BadgeTokens();
        BadgeTokens.INSTANCE = badgeTokens;
        BadgeTokens.Color = ColorSchemeKeyTokens.Error;
        BadgeTokens.LargeColor = ColorSchemeKeyTokens.Error;
        BadgeTokens.LargeLabelTextColor = ColorSchemeKeyTokens.OnError;
        BadgeTokens.LargeLabelTextFont = TypographyKeyTokens.LabelSmall;
        BadgeTokens.LargeShape = ShapeKeyTokens.CornerFull;
        int i = 0;
        BadgeTokens.LargeSize = Dp.constructor-impl((float)l);
        BadgeTokens.Shape = ShapeKeyTokens.CornerFull;
        int i2 = 0;
        BadgeTokens.Size = Dp.constructor-impl((float)l2);
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getColor() {
        return BadgeTokens.Color;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getLargeColor() {
        return BadgeTokens.LargeColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getLargeLabelTextColor() {
        return BadgeTokens.LargeLabelTextColor;
    }

    public final androidx.compose.material3.tokens.TypographyKeyTokens getLargeLabelTextFont() {
        return BadgeTokens.LargeLabelTextFont;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getLargeShape() {
        return BadgeTokens.LargeShape;
    }

    public final float getLargeSize-D9Ej5fM() {
        return BadgeTokens.LargeSize;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getShape() {
        return BadgeTokens.Shape;
    }

    public final float getSize-D9Ej5fM() {
        return BadgeTokens.Size;
    }
}
