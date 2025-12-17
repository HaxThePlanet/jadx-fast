package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u000c\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u0015\u0010\nR\u0019\u0010\u0016\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u0017\u0010\nR\u0019\u0010\u0018\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u0019\u0010\nR\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0006R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0006R\u0011\u0010\"\u001a\u00020\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/material3/tokens/DateInputModalTokens;", "", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ContainerSurfaceTintLayerColor", "getContainerSurfaceTintLayerColor", "ContainerWidth", "getContainerWidth-D9Ej5fM", "HeaderContainerHeight", "getHeaderContainerHeight-D9Ej5fM", "HeaderContainerWidth", "getHeaderContainerWidth-D9Ej5fM", "HeaderHeadlineColor", "getHeaderHeadlineColor", "HeaderHeadlineFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getHeaderHeadlineFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "HeaderSupportingTextColor", "getHeaderSupportingTextColor", "HeaderSupportingTextFont", "getHeaderSupportingTextFont", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DateInputModalTokens {

    public static final int $stable;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final float ContainerHeight;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens ContainerShape;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ContainerSurfaceTintLayerColor;
    private static final float ContainerWidth;
    private static final float HeaderContainerHeight;
    private static final float HeaderContainerWidth;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens HeaderHeadlineColor;
    private static final androidx.compose.material3.tokens.TypographyKeyTokens HeaderHeadlineFont;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens HeaderSupportingTextColor;
    private static final androidx.compose.material3.tokens.TypographyKeyTokens HeaderSupportingTextFont;
    public static final androidx.compose.material3.tokens.DateInputModalTokens INSTANCE;
    static {
        DateInputModalTokens dateInputModalTokens = new DateInputModalTokens();
        DateInputModalTokens.INSTANCE = dateInputModalTokens;
        DateInputModalTokens.ContainerColor = ColorSchemeKeyTokens.Surface;
        DateInputModalTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel3-D9Ej5fM();
        int i = 0;
        DateInputModalTokens.ContainerHeight = Dp.constructor-impl((float)l);
        DateInputModalTokens.ContainerShape = ShapeKeyTokens.CornerExtraLarge;
        DateInputModalTokens.ContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;
        int i2 = 0;
        DateInputModalTokens.ContainerWidth = Dp.constructor-impl((float)l2);
        int i3 = 0;
        DateInputModalTokens.HeaderContainerHeight = Dp.constructor-impl((float)l3);
        int i4 = 0;
        DateInputModalTokens.HeaderContainerWidth = Dp.constructor-impl((float)l4);
        DateInputModalTokens.HeaderHeadlineColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        DateInputModalTokens.HeaderHeadlineFont = TypographyKeyTokens.HeadlineLarge;
        DateInputModalTokens.HeaderSupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        DateInputModalTokens.HeaderSupportingTextFont = TypographyKeyTokens.LabelLarge;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getContainerColor() {
        return DateInputModalTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return DateInputModalTokens.ContainerElevation;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return DateInputModalTokens.ContainerHeight;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getContainerShape() {
        return DateInputModalTokens.ContainerShape;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getContainerSurfaceTintLayerColor() {
        return DateInputModalTokens.ContainerSurfaceTintLayerColor;
    }

    public final float getContainerWidth-D9Ej5fM() {
        return DateInputModalTokens.ContainerWidth;
    }

    public final float getHeaderContainerHeight-D9Ej5fM() {
        return DateInputModalTokens.HeaderContainerHeight;
    }

    public final float getHeaderContainerWidth-D9Ej5fM() {
        return DateInputModalTokens.HeaderContainerWidth;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getHeaderHeadlineColor() {
        return DateInputModalTokens.HeaderHeadlineColor;
    }

    public final androidx.compose.material3.tokens.TypographyKeyTokens getHeaderHeadlineFont() {
        return DateInputModalTokens.HeaderHeadlineFont;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getHeaderSupportingTextColor() {
        return DateInputModalTokens.HeaderSupportingTextColor;
    }

    public final androidx.compose.material3.tokens.TypographyKeyTokens getHeaderSupportingTextFont() {
        return DateInputModalTokens.HeaderSupportingTextFont;
    }
}
