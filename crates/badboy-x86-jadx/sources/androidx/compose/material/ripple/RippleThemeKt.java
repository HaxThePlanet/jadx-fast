package androidx.compose.material.ripple;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\"\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u000cX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"DarkThemeRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "LightThemeHighContrastRippleAlpha", "LightThemeLowContrastRippleAlpha", "LocalRippleTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/ripple/RippleTheme;", "getLocalRippleTheme$annotations", "()V", "getLocalRippleTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "RippleThemeDeprecationMessage", "", "material-ripple_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RippleThemeKt {

    private static final androidx.compose.material.ripple.RippleAlpha DarkThemeRippleAlpha = null;
    private static final androidx.compose.material.ripple.RippleAlpha LightThemeHighContrastRippleAlpha = null;
    private static final androidx.compose.material.ripple.RippleAlpha LightThemeLowContrastRippleAlpha = null;
    private static final ProvidableCompositionLocal<androidx.compose.material.ripple.RippleTheme> LocalRippleTheme = null;
    private static final String RippleThemeDeprecationMessage = "RippleTheme and LocalRippleTheme have been deprecated - they are not compatible with the new ripple implementation using the new Indication APIs that provide notable performance improvements. For a migration guide and background information, please visit developer.android.com";
    static {
        RippleThemeKt.LocalRippleTheme = CompositionLocalKt.staticCompositionLocalOf((Function0)RippleThemeKt.LocalRippleTheme.1.INSTANCE);
        int i3 = 1047904911;
        final int i5 = 1034147594;
        RippleAlpha rippleAlpha = new RippleAlpha(1042536202, i3, i5, i3);
        RippleThemeKt.LightThemeHighContrastRippleAlpha = rippleAlpha;
        int i2 = 1039516303;
        int i4 = 1025758986;
        RippleAlpha rippleAlpha2 = new RippleAlpha(i5, i2, i4, i2);
        RippleThemeKt.LightThemeLowContrastRippleAlpha = rippleAlpha2;
        RippleAlpha rippleAlpha3 = new RippleAlpha(i5, i2, i4, 1036831949);
        RippleThemeKt.DarkThemeRippleAlpha = rippleAlpha3;
    }

    public static final androidx.compose.material.ripple.RippleAlpha access$getDarkThemeRippleAlpha$p() {
        return RippleThemeKt.DarkThemeRippleAlpha;
    }

    public static final androidx.compose.material.ripple.RippleAlpha access$getLightThemeHighContrastRippleAlpha$p() {
        return RippleThemeKt.LightThemeHighContrastRippleAlpha;
    }

    public static final androidx.compose.material.ripple.RippleAlpha access$getLightThemeLowContrastRippleAlpha$p() {
        return RippleThemeKt.LightThemeLowContrastRippleAlpha;
    }

    public static final ProvidableCompositionLocal<androidx.compose.material.ripple.RippleTheme> getLocalRippleTheme() {
        return RippleThemeKt.LocalRippleTheme;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "RippleTheme and LocalRippleTheme have been deprecated - they are not compatible with the new ripple implementation using the new Indication APIs that provide notable performance improvements. For a migration guide and background information, please visit developer.android.com")
    public static void getLocalRippleTheme$annotations() {
    }
}
