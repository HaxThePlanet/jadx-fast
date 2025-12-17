package androidx.compose.material3.tokens;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0006R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0006R\u0011\u0010\u0018\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001a", d2 = {"Landroidx/compose/material3/tokens/MenuTokens;", "", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "FocusIndicatorColor", "getFocusIndicatorColor", "ListItemSelectedContainerColor", "getListItemSelectedContainerColor", "ListItemSelectedLabelTextColor", "getListItemSelectedLabelTextColor", "ListItemSelectedLeadingTrailingIconColor", "getListItemSelectedLeadingTrailingIconColor", "MenuListItemLeadingIconColor", "getMenuListItemLeadingIconColor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MenuTokens {

    public static final int $stable;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens ContainerShape;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens FocusIndicatorColor;
    public static final androidx.compose.material3.tokens.MenuTokens INSTANCE;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ListItemSelectedContainerColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ListItemSelectedLabelTextColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ListItemSelectedLeadingTrailingIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens MenuListItemLeadingIconColor;
    static {
        MenuTokens menuTokens = new MenuTokens();
        MenuTokens.INSTANCE = menuTokens;
        MenuTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        MenuTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
        MenuTokens.ContainerShape = ShapeKeyTokens.CornerExtraSmall;
        MenuTokens.FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
        MenuTokens.ListItemSelectedContainerColor = ColorSchemeKeyTokens.SecondaryContainer;
        MenuTokens.ListItemSelectedLabelTextColor = ColorSchemeKeyTokens.OnSecondaryContainer;
        MenuTokens.ListItemSelectedLeadingTrailingIconColor = ColorSchemeKeyTokens.OnSecondaryContainer;
        MenuTokens.MenuListItemLeadingIconColor = ColorSchemeKeyTokens.OnSecondaryContainer;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getContainerColor() {
        return MenuTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return MenuTokens.ContainerElevation;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getContainerShape() {
        return MenuTokens.ContainerShape;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getFocusIndicatorColor() {
        return MenuTokens.FocusIndicatorColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getListItemSelectedContainerColor() {
        return MenuTokens.ListItemSelectedContainerColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getListItemSelectedLabelTextColor() {
        return MenuTokens.ListItemSelectedLabelTextColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getListItemSelectedLeadingTrailingIconColor() {
        return MenuTokens.ListItemSelectedLeadingTrailingIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getMenuListItemLeadingIconColor() {
        return MenuTokens.MenuListItemLeadingIconColor;
    }
}
