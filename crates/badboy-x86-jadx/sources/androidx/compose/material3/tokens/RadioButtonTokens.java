package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0016\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000c\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u001a\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006#", d2 = {"Landroidx/compose/material3/tokens/RadioButtonTokens;", "", "()V", "DisabledSelectedIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDisabledSelectedIconColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledSelectedIconOpacity", "", "DisabledUnselectedIconColor", "getDisabledUnselectedIconColor", "DisabledUnselectedIconOpacity", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "SelectedFocusIconColor", "getSelectedFocusIconColor", "SelectedHoverIconColor", "getSelectedHoverIconColor", "SelectedIconColor", "getSelectedIconColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "UnselectedFocusIconColor", "getUnselectedFocusIconColor", "UnselectedHoverIconColor", "getUnselectedHoverIconColor", "UnselectedIconColor", "getUnselectedIconColor", "UnselectedPressedIconColor", "getUnselectedPressedIconColor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RadioButtonTokens {

    public static final int $stable = 0;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens DisabledSelectedIconColor = null;
    public static final float DisabledSelectedIconOpacity = 0.38f;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens DisabledUnselectedIconColor = null;
    public static final float DisabledUnselectedIconOpacity = 0.38f;
    public static final androidx.compose.material3.tokens.RadioButtonTokens INSTANCE;
    private static final float IconSize;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedFocusIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedHoverIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens SelectedPressedIconColor;
    private static final float StateLayerSize;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedFocusIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedHoverIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedIconColor;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens UnselectedPressedIconColor;
    static {
        RadioButtonTokens radioButtonTokens = new RadioButtonTokens();
        RadioButtonTokens.INSTANCE = radioButtonTokens;
        RadioButtonTokens.DisabledSelectedIconColor = ColorSchemeKeyTokens.OnSurface;
        RadioButtonTokens.DisabledUnselectedIconColor = ColorSchemeKeyTokens.OnSurface;
        int i = 0;
        RadioButtonTokens.IconSize = Dp.constructor-impl((float)l);
        RadioButtonTokens.SelectedFocusIconColor = ColorSchemeKeyTokens.Primary;
        RadioButtonTokens.SelectedHoverIconColor = ColorSchemeKeyTokens.Primary;
        RadioButtonTokens.SelectedIconColor = ColorSchemeKeyTokens.Primary;
        RadioButtonTokens.SelectedPressedIconColor = ColorSchemeKeyTokens.Primary;
        int i2 = 0;
        RadioButtonTokens.StateLayerSize = Dp.constructor-impl((float)l2);
        RadioButtonTokens.UnselectedFocusIconColor = ColorSchemeKeyTokens.OnSurface;
        RadioButtonTokens.UnselectedHoverIconColor = ColorSchemeKeyTokens.OnSurface;
        RadioButtonTokens.UnselectedIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        RadioButtonTokens.UnselectedPressedIconColor = ColorSchemeKeyTokens.OnSurface;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getDisabledSelectedIconColor() {
        return RadioButtonTokens.DisabledSelectedIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getDisabledUnselectedIconColor() {
        return RadioButtonTokens.DisabledUnselectedIconColor;
    }

    public final float getIconSize-D9Ej5fM() {
        return RadioButtonTokens.IconSize;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedFocusIconColor() {
        return RadioButtonTokens.SelectedFocusIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedHoverIconColor() {
        return RadioButtonTokens.SelectedHoverIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedIconColor() {
        return RadioButtonTokens.SelectedIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getSelectedPressedIconColor() {
        return RadioButtonTokens.SelectedPressedIconColor;
    }

    public final float getStateLayerSize-D9Ej5fM() {
        return RadioButtonTokens.StateLayerSize;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedFocusIconColor() {
        return RadioButtonTokens.UnselectedFocusIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedHoverIconColor() {
        return RadioButtonTokens.UnselectedHoverIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedIconColor() {
        return RadioButtonTokens.UnselectedIconColor;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getUnselectedPressedIconColor() {
        return RadioButtonTokens.UnselectedPressedIconColor;
    }
}
