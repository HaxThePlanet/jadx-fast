package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u000c\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0012", d2 = {"Landroidx/compose/material3/tokens/BottomAppBarTokens;", "", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BottomAppBarTokens {

    public static final int $stable;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final float ContainerHeight;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens ContainerShape;
    public static final androidx.compose.material3.tokens.BottomAppBarTokens INSTANCE;
    static {
        BottomAppBarTokens bottomAppBarTokens = new BottomAppBarTokens();
        BottomAppBarTokens.INSTANCE = bottomAppBarTokens;
        BottomAppBarTokens.ContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
        BottomAppBarTokens.ContainerElevation = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
        final int i = 0;
        BottomAppBarTokens.ContainerHeight = Dp.constructor-impl((float)l);
        BottomAppBarTokens.ContainerShape = ShapeKeyTokens.CornerNone;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getContainerColor() {
        return BottomAppBarTokens.ContainerColor;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return BottomAppBarTokens.ContainerElevation;
    }

    public final float getContainerHeight-D9Ej5fM() {
        return BottomAppBarTokens.ContainerHeight;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getContainerShape() {
        return BottomAppBarTokens.ContainerShape;
    }
}
