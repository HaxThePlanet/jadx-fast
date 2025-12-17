package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000c\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u0013\u0010\nR\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0011R\u0019\u0010\u0016\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u0017\u0010\nR\u0011\u0010\u0018\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0006R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0006R\u0011\u0010 \u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0006R\u0011\u0010\"\u001a\u00020\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001dR\u0011\u0010$\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006&", d2 = {"Landroidx/compose/material3/tokens/SearchViewTokens;", "", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "DividerColor", "getDividerColor", "DockedContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getDockedContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DockedHeaderContainerHeight", "getDockedHeaderContainerHeight-D9Ej5fM", "FullScreenContainerShape", "getFullScreenContainerShape", "FullScreenHeaderContainerHeight", "getFullScreenHeaderContainerHeight-D9Ej5fM", "HeaderInputTextColor", "getHeaderInputTextColor", "HeaderInputTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getHeaderInputTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "HeaderLeadingIconColor", "getHeaderLeadingIconColor", "HeaderSupportingTextColor", "getHeaderSupportingTextColor", "HeaderSupportingTextFont", "getHeaderSupportingTextFont", "HeaderTrailingIconColor", "getHeaderTrailingIconColor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchViewTokens {

    public static final int $stable;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens DividerColor;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens DockedContainerShape;
    private static final float DockedHeaderContainerHeight;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens FullScreenContainerShape;
    private static final float FullScreenHeaderContainerHeight;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens HeaderInputTextColor;
    private static final androidx.compose.material3.tokens.TypographyKeyTokens HeaderInputTextFont;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens HeaderLeadingIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens HeaderSupportingTextColor;
    private static final androidx.compose.material3.tokens.TypographyKeyTokens HeaderSupportingTextFont;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens HeaderTrailingIconColor;
    public static final androidx.compose.material3.tokens.SearchViewTokens INSTANCE;
    static {
        SearchViewTokens searchViewTokens = new SearchViewTokens();
        SearchViewTokens.INSTANCE = searchViewTokens;
        SearchViewTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHigh;
        SearchViewTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel3-D9Ej5fM();
        SearchViewTokens.DividerColor = ColorSchemeKeyTokens.Outline;
        SearchViewTokens.DockedContainerShape = ShapeKeyTokens.CornerExtraLarge;
        int i = 0;
        SearchViewTokens.DockedHeaderContainerHeight = Dp.constructor-impl((float)l);
        SearchViewTokens.FullScreenContainerShape = ShapeKeyTokens.CornerNone;
        int i2 = 0;
        SearchViewTokens.FullScreenHeaderContainerHeight = Dp.constructor-impl((float)l2);
        SearchViewTokens.HeaderInputTextColor = ColorSchemeKeyTokens.OnSurface;
        SearchViewTokens.HeaderInputTextFont = TypographyKeyTokens.BodyLarge;
        SearchViewTokens.HeaderLeadingIconColor = ColorSchemeKeyTokens.OnSurface;
        SearchViewTokens.HeaderSupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        SearchViewTokens.HeaderSupportingTextFont = TypographyKeyTokens.BodyLarge;
        SearchViewTokens.HeaderTrailingIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getContainerColor() {
        return SearchViewTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return SearchViewTokens.ContainerElevation;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getDividerColor() {
        return SearchViewTokens.DividerColor;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getDockedContainerShape() {
        return SearchViewTokens.DockedContainerShape;
    }

    public final float getDockedHeaderContainerHeight-D9Ej5fM() {
        return SearchViewTokens.DockedHeaderContainerHeight;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getFullScreenContainerShape() {
        return SearchViewTokens.FullScreenContainerShape;
    }

    public final float getFullScreenHeaderContainerHeight-D9Ej5fM() {
        return SearchViewTokens.FullScreenHeaderContainerHeight;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getHeaderInputTextColor() {
        return SearchViewTokens.HeaderInputTextColor;
    }

    public final androidx.compose.material3.tokens.TypographyKeyTokens getHeaderInputTextFont() {
        return SearchViewTokens.HeaderInputTextFont;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getHeaderLeadingIconColor() {
        return SearchViewTokens.HeaderLeadingIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getHeaderSupportingTextColor() {
        return SearchViewTokens.HeaderSupportingTextColor;
    }

    public final androidx.compose.material3.tokens.TypographyKeyTokens getHeaderSupportingTextFont() {
        return SearchViewTokens.HeaderSupportingTextFont;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getHeaderTrailingIconColor() {
        return SearchViewTokens.HeaderTrailingIconColor;
    }
}
