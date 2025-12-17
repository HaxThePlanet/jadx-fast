package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0014\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u000b\u001a\u00020\u000cø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000cø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0011\u0010\u000eR\u0019\u0010\u0012\u001a\u00020\u000cø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u000cø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0017\u0010\u000eR\u0019\u0010\u0018\u001a\u00020\u000cø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0019\u0010\u000eR\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0006R\u0011\u0010\u001c\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\nR\u0019\u0010\u001e\u001a\u00020\u000cø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u001f\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006 ", d2 = {"Landroidx/compose/material3/tokens/ProgressIndicatorTokens;", "", "()V", "ActiveIndicatorColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveIndicatorColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getActiveShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ActiveThickness", "Landroidx/compose/ui/unit/Dp;", "getActiveThickness-D9Ej5fM", "()F", "F", "ActiveTrackSpace", "getActiveTrackSpace-D9Ej5fM", "Size", "getSize-D9Ej5fM", "StopColor", "getStopColor", "StopShape", "getStopShape-D9Ej5fM", "StopSize", "getStopSize-D9Ej5fM", "TrackColor", "getTrackColor", "TrackShape", "getTrackShape", "TrackThickness", "getTrackThickness-D9Ej5fM", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProgressIndicatorTokens {

    public static final int $stable;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ActiveIndicatorColor;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens ActiveShape;
    private static final float ActiveThickness;
    private static final float ActiveTrackSpace;
    public static final androidx.compose.material3.tokens.ProgressIndicatorTokens INSTANCE;
    private static final float Size;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens StopColor;
    private static final float StopShape;
    private static final float StopSize;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens TrackColor;
    private static final androidx.compose.material3.tokens.ShapeKeyTokens TrackShape;
    private static final float TrackThickness;
    static {
        ProgressIndicatorTokens progressIndicatorTokens = new ProgressIndicatorTokens();
        ProgressIndicatorTokens.INSTANCE = progressIndicatorTokens;
        ProgressIndicatorTokens.ActiveIndicatorColor = ColorSchemeKeyTokens.Primary;
        ProgressIndicatorTokens.ActiveShape = ShapeKeyTokens.CornerFull;
        int i = 0;
        ProgressIndicatorTokens.ActiveThickness = Dp.constructor-impl((float)l);
        int i2 = 0;
        ProgressIndicatorTokens.ActiveTrackSpace = Dp.constructor-impl((float)l2);
        ProgressIndicatorTokens.StopColor = ColorSchemeKeyTokens.Primary;
        int i3 = 0;
        ProgressIndicatorTokens.StopShape = Dp.constructor-impl((float)l3);
        int i4 = 0;
        ProgressIndicatorTokens.StopSize = Dp.constructor-impl((float)l4);
        ProgressIndicatorTokens.TrackColor = ColorSchemeKeyTokens.SecondaryContainer;
        ProgressIndicatorTokens.TrackShape = ShapeKeyTokens.CornerFull;
        int i5 = 0;
        ProgressIndicatorTokens.TrackThickness = Dp.constructor-impl((float)l5);
        int i6 = 0;
        ProgressIndicatorTokens.Size = Dp.constructor-impl((float)l6);
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getActiveIndicatorColor() {
        return ProgressIndicatorTokens.ActiveIndicatorColor;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getActiveShape() {
        return ProgressIndicatorTokens.ActiveShape;
    }

    public final float getActiveThickness-D9Ej5fM() {
        return ProgressIndicatorTokens.ActiveThickness;
    }

    public final float getActiveTrackSpace-D9Ej5fM() {
        return ProgressIndicatorTokens.ActiveTrackSpace;
    }

    public final float getSize-D9Ej5fM() {
        return ProgressIndicatorTokens.Size;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getStopColor() {
        return ProgressIndicatorTokens.StopColor;
    }

    public final float getStopShape-D9Ej5fM() {
        return ProgressIndicatorTokens.StopShape;
    }

    public final float getStopSize-D9Ej5fM() {
        return ProgressIndicatorTokens.StopSize;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getTrackColor() {
        return ProgressIndicatorTokens.TrackColor;
    }

    public final androidx.compose.material3.tokens.ShapeKeyTokens getTrackShape() {
        return ProgressIndicatorTokens.TrackShape;
    }

    public final float getTrackThickness-D9Ej5fM() {
        return ProgressIndicatorTokens.TrackThickness;
    }
}
