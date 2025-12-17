package androidx.compose.material3;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.PaletteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u00085\n\u0002\u0018\u0002\n\u0002\u0008\n\u001a\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a´\u0002\u0010\u0013\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u000b2\u0008\u0008\u0002\u0010 \u001a\u00020\u000b2\u0008\u0008\u0002\u0010!\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\"\u001a\u00020\u000b2\u0008\u0008\u0002\u0010#\u001a\u00020\u000b2\u0008\u0008\u0002\u0010$\u001a\u00020\u000b2\u0008\u0008\u0002\u0010%\u001a\u00020\u000b2\u0008\u0008\u0002\u0010&\u001a\u00020\u000b2\u0008\u0008\u0002\u0010'\u001a\u00020\u000b2\u0008\u0008\u0002\u0010(\u001a\u00020\u000b2\u0008\u0008\u0002\u0010)\u001a\u00020\u000b2\u0008\u0008\u0002\u0010*\u001a\u00020\u000b2\u0008\u0008\u0002\u0010+\u001a\u00020\u000b2\u0008\u0008\u0002\u0010,\u001a\u00020\u000b2\u0008\u0008\u0002\u0010-\u001a\u00020\u000b2\u0008\u0008\u0002\u0010.\u001a\u00020\u000b2\u0008\u0008\u0002\u0010/\u001a\u00020\u000b2\u0008\u0008\u0002\u00100\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u00081\u00102\u001aø\u0002\u0010\u0013\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u000b2\u0008\u0008\u0002\u0010 \u001a\u00020\u000b2\u0008\u0008\u0002\u0010!\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\"\u001a\u00020\u000b2\u0008\u0008\u0002\u0010#\u001a\u00020\u000b2\u0008\u0008\u0002\u0010$\u001a\u00020\u000b2\u0008\u0008\u0002\u0010%\u001a\u00020\u000b2\u0008\u0008\u0002\u0010&\u001a\u00020\u000b2\u0008\u0008\u0002\u0010'\u001a\u00020\u000b2\u0008\u0008\u0002\u0010(\u001a\u00020\u000b2\u0008\u0008\u0002\u0010)\u001a\u00020\u000b2\u0008\u0008\u0002\u0010*\u001a\u00020\u000b2\u0008\u0008\u0002\u0010+\u001a\u00020\u000b2\u0008\u0008\u0002\u0010,\u001a\u00020\u000b2\u0008\u0008\u0002\u0010-\u001a\u00020\u000b2\u0008\u0008\u0002\u0010.\u001a\u00020\u000b2\u0008\u0008\u0002\u0010/\u001a\u00020\u000b2\u0008\u0008\u0002\u00100\u001a\u00020\u000b2\u0008\u0008\u0002\u00103\u001a\u00020\u000b2\u0008\u0008\u0002\u00104\u001a\u00020\u000b2\u0008\u0008\u0002\u00105\u001a\u00020\u000b2\u0008\u0008\u0002\u00106\u001a\u00020\u000b2\u0008\u0008\u0002\u00107\u001a\u00020\u000b2\u0008\u0008\u0002\u00108\u001a\u00020\u000b2\u0008\u0008\u0002\u00109\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\u0008:\u0010;\u001a\u0008\u0010<\u001a\u00020\u0004H\u0000\u001a´\u0002\u0010=\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u000b2\u0008\u0008\u0002\u0010 \u001a\u00020\u000b2\u0008\u0008\u0002\u0010!\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\"\u001a\u00020\u000b2\u0008\u0008\u0002\u0010#\u001a\u00020\u000b2\u0008\u0008\u0002\u0010$\u001a\u00020\u000b2\u0008\u0008\u0002\u0010%\u001a\u00020\u000b2\u0008\u0008\u0002\u0010&\u001a\u00020\u000b2\u0008\u0008\u0002\u0010'\u001a\u00020\u000b2\u0008\u0008\u0002\u0010(\u001a\u00020\u000b2\u0008\u0008\u0002\u0010)\u001a\u00020\u000b2\u0008\u0008\u0002\u0010*\u001a\u00020\u000b2\u0008\u0008\u0002\u0010+\u001a\u00020\u000b2\u0008\u0008\u0002\u0010,\u001a\u00020\u000b2\u0008\u0008\u0002\u0010-\u001a\u00020\u000b2\u0008\u0008\u0002\u0010.\u001a\u00020\u000b2\u0008\u0008\u0002\u0010/\u001a\u00020\u000b2\u0008\u0008\u0002\u00100\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008>\u00102\u001aø\u0002\u0010=\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u000b2\u0008\u0008\u0002\u0010 \u001a\u00020\u000b2\u0008\u0008\u0002\u0010!\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\"\u001a\u00020\u000b2\u0008\u0008\u0002\u0010#\u001a\u00020\u000b2\u0008\u0008\u0002\u0010$\u001a\u00020\u000b2\u0008\u0008\u0002\u0010%\u001a\u00020\u000b2\u0008\u0008\u0002\u0010&\u001a\u00020\u000b2\u0008\u0008\u0002\u0010'\u001a\u00020\u000b2\u0008\u0008\u0002\u0010(\u001a\u00020\u000b2\u0008\u0008\u0002\u0010)\u001a\u00020\u000b2\u0008\u0008\u0002\u0010*\u001a\u00020\u000b2\u0008\u0008\u0002\u0010+\u001a\u00020\u000b2\u0008\u0008\u0002\u0010,\u001a\u00020\u000b2\u0008\u0008\u0002\u0010-\u001a\u00020\u000b2\u0008\u0008\u0002\u0010.\u001a\u00020\u000b2\u0008\u0008\u0002\u0010/\u001a\u00020\u000b2\u0008\u0008\u0002\u00100\u001a\u00020\u000b2\u0008\u0008\u0002\u00103\u001a\u00020\u000b2\u0008\u0008\u0002\u00104\u001a\u00020\u000b2\u0008\u0008\u0002\u00105\u001a\u00020\u000b2\u0008\u0008\u0002\u00106\u001a\u00020\u000b2\u0008\u0008\u0002\u00107\u001a\u00020\u000b2\u0008\u0008\u0002\u00108\u001a\u00020\u000b2\u0008\u0008\u0002\u00109\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\u0008?\u0010;\u001a&\u0010@\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020BH\u0001ø\u0001\u0000¢\u0006\u0004\u0008C\u0010D\u001a\u001e\u0010\u000f\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008E\u0010F\u001a\u0019\u0010G\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000cH\u0001¢\u0006\u0002\u0010H\u001a\u001e\u0010I\u001a\u00020\u000b*\u00020\u00042\u0006\u0010A\u001a\u00020BH\u0007ø\u0001\u0000¢\u0006\u0004\u0008J\u0010K\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0006\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\u000c8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006L", d2 = {"DisabledAlpha", "", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ColorScheme;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalTonalElevationEnabled", "", "getLocalTonalElevationEnabled", "value", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getValue", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "contentColorFor", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColorScheme", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "darkColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "surfaceBright", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "surfaceDim", "darkColorScheme-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "expressiveLightColorScheme", "lightColorScheme", "lightColorScheme-G1PFc-w", "lightColorScheme-C-Xl9yA", "applyTonalElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "applyTonalElevation-RFCenO8", "(Landroidx/compose/material3/ColorScheme;JFLandroidx/compose/runtime/Composer;I)J", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "fromToken", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "surfaceColorAtElevation", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorSchemeKt {

    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<androidx.compose.material3.ColorScheme> LocalColorScheme;
    private static final ProvidableCompositionLocal<Boolean> LocalTonalElevationEnabled;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal14;
            int ordinal27;
            int ordinal;
            int ordinal17;
            int ordinal21;
            int ordinal18;
            int ordinal25;
            int ordinal2;
            int ordinal26;
            int ordinal24;
            int ordinal22;
            int ordinal8;
            int ordinal31;
            int ordinal6;
            int ordinal30;
            int ordinal33;
            int ordinal19;
            int ordinal3;
            int ordinal36;
            int ordinal15;
            int ordinal7;
            int ordinal23;
            int ordinal32;
            int ordinal16;
            int ordinal20;
            int ordinal28;
            int ordinal5;
            int ordinal9;
            int ordinal29;
            int ordinal4;
            int ordinal13;
            int ordinal10;
            int ordinal34;
            int ordinal35;
            int ordinal11;
            int ordinal12;
            int[] iArr = new int[values.length];
            iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError e) {
                ColorSchemeKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
            }
            iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (java.lang.NoSuchFieldError e) {
            }
            iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            iArr[ColorSchemeKeyTokens.SurfaceBright.ordinal()] = 28;
            iArr[ColorSchemeKeyTokens.SurfaceContainer.ordinal()] = 29;
            iArr[ColorSchemeKeyTokens.SurfaceContainerHigh.ordinal()] = 30;
            iArr[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 31;
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLow.ordinal()] = 32;
                iArr[ColorSchemeKeyTokens.SurfaceContainerLowest.ordinal()] = 33;
                iArr[ColorSchemeKeyTokens.SurfaceDim.ordinal()] = 34;
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 35;
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 36;
            } catch (java.lang.NoSuchFieldError e) {
            }
        }
    }
    static {
        ColorSchemeKt.LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf((Function0)ColorSchemeKt.LocalColorScheme.1.INSTANCE);
        ColorSchemeKt.LocalTonalElevationEnabled = CompositionLocalKt.staticCompositionLocalOf((Function0)ColorSchemeKt.LocalTonalElevationEnabled.1.INSTANCE);
    }

    public static final long applyTonalElevation-RFCenO8(androidx.compose.material3.ColorScheme $this$applyTonalElevation_u2dRFCenO8, long backgroundColor, float elevation, Composer $composer, int $changed) {
        boolean traceInProgress;
        long surfaceColorAtElevation-3ABfNKs;
        String str;
        int i = -1610977682;
        ComposerKt.sourceInformationMarkerStart($changed, i, "C(applyTonalElevation)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)896@40465L7:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, obj10, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:895)");
        }
        int i2 = 6;
        ComposerKt.sourceInformationMarkerStart($changed, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($changed);
        if (Color.equals-impl0(backgroundColor, elevation) && (Boolean)$changed.consume((CompositionLocal)ColorSchemeKt.LocalTonalElevationEnabled).booleanValue()) {
            if ((Boolean)$changed.consume((CompositionLocal)ColorSchemeKt.LocalTonalElevationEnabled).booleanValue()) {
                surfaceColorAtElevation-3ABfNKs = ColorSchemeKt.surfaceColorAtElevation-3ABfNKs($this$applyTonalElevation_u2dRFCenO8, $composer);
            } else {
                surfaceColorAtElevation-3ABfNKs = backgroundColor;
            }
        } else {
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return surfaceColorAtElevation-3ABfNKs;
    }

    public static final long contentColorFor-4WTKRHQ(androidx.compose.material3.ColorScheme $this$contentColorFor_u2d4WTKRHQ, long backgroundColor) {
        long onTertiaryContainer-0d7_KjU;
        if (Color.equals-impl0(backgroundColor, obj4)) {
            onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnPrimary-0d7_KjU();
        } else {
            if (Color.equals-impl0(backgroundColor, obj4)) {
                onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSecondary-0d7_KjU();
            } else {
                if (Color.equals-impl0(backgroundColor, obj4)) {
                    onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnTertiary-0d7_KjU();
                } else {
                    if (Color.equals-impl0(backgroundColor, obj4)) {
                        onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnBackground-0d7_KjU();
                    } else {
                        if (Color.equals-impl0(backgroundColor, obj4)) {
                            onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnError-0d7_KjU();
                        } else {
                            if (Color.equals-impl0(backgroundColor, obj4)) {
                                onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnPrimaryContainer-0d7_KjU();
                            } else {
                                if (Color.equals-impl0(backgroundColor, obj4)) {
                                    onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSecondaryContainer-0d7_KjU();
                                } else {
                                    if (Color.equals-impl0(backgroundColor, obj4)) {
                                        onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnTertiaryContainer-0d7_KjU();
                                    } else {
                                        if (Color.equals-impl0(backgroundColor, obj4)) {
                                            onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnErrorContainer-0d7_KjU();
                                        } else {
                                            if (Color.equals-impl0(backgroundColor, obj4)) {
                                                onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getInverseOnSurface-0d7_KjU();
                                            } else {
                                                if (Color.equals-impl0(backgroundColor, obj4)) {
                                                    onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSurface-0d7_KjU();
                                                } else {
                                                    if (Color.equals-impl0(backgroundColor, obj4)) {
                                                        onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSurfaceVariant-0d7_KjU();
                                                    } else {
                                                        if (Color.equals-impl0(backgroundColor, obj4)) {
                                                            onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSurface-0d7_KjU();
                                                        } else {
                                                            if (Color.equals-impl0(backgroundColor, obj4)) {
                                                                onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSurface-0d7_KjU();
                                                            } else {
                                                                if (Color.equals-impl0(backgroundColor, obj4)) {
                                                                    onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSurface-0d7_KjU();
                                                                } else {
                                                                    if (Color.equals-impl0(backgroundColor, obj4)) {
                                                                        onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSurface-0d7_KjU();
                                                                    } else {
                                                                        if (Color.equals-impl0(backgroundColor, obj4)) {
                                                                            onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSurface-0d7_KjU();
                                                                        } else {
                                                                            if (Color.equals-impl0(backgroundColor, obj4)) {
                                                                                onTertiaryContainer-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSurface-0d7_KjU();
                                                                            } else {
                                                                                onTertiaryContainer-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return onTertiaryContainer-0d7_KjU;
    }

    public static final long contentColorFor-ek8zF_U(long backgroundColor, Composer $composer, int $changed) {
        long $this$takeOrElse_u2dDxMtmZc$iv;
        boolean traceInProgress;
        String str2;
        long $i$a$TakeOrElseDxMtmZcColorSchemeKt$contentColorFor$1;
        ProvidableCompositionLocal localContentColor;
        int i2;
        int i;
        Object consume;
        String str;
        int i3 = 509589638;
        ComposerKt.sourceInformationMarkerStart($changed, i3, "C(contentColorFor)P(0:c#ui.graphics.Color):ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, obj12, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:878)");
        }
        $changed.startReplaceGroup(-1680936624);
        ComposerKt.sourceInformation($changed, "*878@39525L11,879@39609L7");
        int i6 = 0;
        i2 = 0;
        i = Long.compare($i$a$TakeOrElseDxMtmZcColorSchemeKt$contentColorFor$1, i8) != 0 ? 1 : 0;
        if (i != 0) {
        } else {
            int i7 = 0;
            i2 = 6;
            i = 0;
            ComposerKt.sourceInformationMarkerStart($changed, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd($changed);
            $this$takeOrElse_u2dDxMtmZc$iv = $i$a$TakeOrElseDxMtmZcColorSchemeKt$contentColorFor$1;
        }
        $changed.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return $this$takeOrElse_u2dDxMtmZc$iv;
    }

    public static final androidx.compose.material3.ColorScheme darkColorScheme-C-Xl9yA(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim, long surfaceBright, long surfaceContainer, long surfaceContainerHigh, long surfaceContainerHighest, long surfaceContainerLow, long surfaceContainerLowest, long surfaceDim) {
        ColorScheme colorScheme = new ColorScheme(primary, obj2, primaryContainer, obj4, inversePrimary, obj6, onSecondary, obj8, onSecondaryContainer, obj10, onTertiary, obj12, onTertiaryContainer, obj14, onBackground, obj16, onSurface, obj18, onSurfaceVariant, obj20, inverseSurface, obj22, error, obj24, errorContainer, obj26, outline, obj28, scrim, obj30, surfaceContainer, obj32, surfaceContainerHighest, obj34, surfaceContainerLowest, obj36, obj110, obj38, obj112, obj40, obj114, obj42, obj116, obj44, obj118, obj46, obj120, obj48, obj122, obj50, obj124, obj52, obj126, obj54, obj128, obj56, obj130, obj58, obj132, obj60, obj144, obj62, obj134, obj64, obj136, obj66, obj138, obj68, obj140, obj70, obj142, obj72, 0);
        return colorScheme;
    }

    public static androidx.compose.material3.ColorScheme darkColorScheme-C-Xl9yA$default(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, long l26, long l27, long l28, long l29, long l30, long l31, long l32, long l33, long l34, long l35, long l36, int i37, int i38, Object object39) {
        ColorDarkTokens iNSTANCE2;
        int iNSTANCE3;
        ColorDarkTokens iNSTANCE4;
        int iNSTANCE5;
        ColorDarkTokens iNSTANCE;
        long primary-0d7_KjU;
        long onSecondaryContainer-0d7_KjU;
        long tertiary-0d7_KjU;
        long onTertiary-0d7_KjU;
        long tertiaryContainer-0d7_KjU;
        long onTertiaryContainer-0d7_KjU;
        long background-0d7_KjU;
        long onBackground-0d7_KjU;
        long onPrimary-0d7_KjU;
        long primaryContainer-0d7_KjU;
        long onPrimaryContainer-0d7_KjU;
        long inversePrimary-0d7_KjU;
        long secondary-0d7_KjU;
        long onSecondary-0d7_KjU;
        long secondaryContainer-0d7_KjU;
        long surface-0d7_KjU;
        long onSurface-0d7_KjU;
        long surfaceVariant-0d7_KjU;
        long onSurfaceVariant-0d7_KjU;
        long l37;
        long inverseSurface-0d7_KjU;
        long inverseOnSurface-0d7_KjU;
        long error-0d7_KjU;
        long onError-0d7_KjU;
        long errorContainer-0d7_KjU;
        long onErrorContainer-0d7_KjU;
        long outline-0d7_KjU;
        long outlineVariant-0d7_KjU;
        long scrim-0d7_KjU;
        long surfaceBright-0d7_KjU;
        long surfaceContainer-0d7_KjU;
        long surfaceContainerHigh-0d7_KjU;
        long surfaceContainerHighest-0d7_KjU;
        long surfaceContainerLow-0d7_KjU;
        long surfaceContainerLowest-0d7_KjU;
        long surfaceDim-0d7_KjU;
        int i = obj131;
        if (i & 1 != 0) {
            primary-0d7_KjU = ColorDarkTokens.INSTANCE.getPrimary-0d7_KjU();
        } else {
            primary-0d7_KjU = l;
        }
        if (i & 2 != 0) {
            onPrimary-0d7_KjU = ColorDarkTokens.INSTANCE.getOnPrimary-0d7_KjU();
        } else {
            onPrimary-0d7_KjU = l3;
        }
        if (i & 4 != 0) {
            primaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getPrimaryContainer-0d7_KjU();
        } else {
            primaryContainer-0d7_KjU = l5;
        }
        if (i & 8 != 0) {
            onPrimaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU();
        } else {
            onPrimaryContainer-0d7_KjU = l7;
        }
        if (i & 16 != 0) {
            inversePrimary-0d7_KjU = ColorDarkTokens.INSTANCE.getInversePrimary-0d7_KjU();
        } else {
            inversePrimary-0d7_KjU = l9;
        }
        if (i & 32 != 0) {
            secondary-0d7_KjU = ColorDarkTokens.INSTANCE.getSecondary-0d7_KjU();
        } else {
            secondary-0d7_KjU = l11;
        }
        if (i & 64 != 0) {
            onSecondary-0d7_KjU = ColorDarkTokens.INSTANCE.getOnSecondary-0d7_KjU();
        } else {
            onSecondary-0d7_KjU = l13;
        }
        if (i & 128 != 0) {
            secondaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getSecondaryContainer-0d7_KjU();
        } else {
            secondaryContainer-0d7_KjU = l15;
        }
        final long obj59 = primary-0d7_KjU;
        if (i & 256 != 0) {
            onSecondaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU();
        } else {
            onSecondaryContainer-0d7_KjU = l17;
        }
        if (i & 512 != 0) {
            tertiary-0d7_KjU = ColorDarkTokens.INSTANCE.getTertiary-0d7_KjU();
        } else {
            tertiary-0d7_KjU = l19;
        }
        if (i & 1024 != 0) {
            onTertiary-0d7_KjU = ColorDarkTokens.INSTANCE.getOnTertiary-0d7_KjU();
        } else {
            onTertiary-0d7_KjU = l21;
        }
        if (i & 2048 != 0) {
            tertiaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getTertiaryContainer-0d7_KjU();
        } else {
            tertiaryContainer-0d7_KjU = l23;
        }
        if (i & 4096 != 0) {
            onTertiaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU();
        } else {
            onTertiaryContainer-0d7_KjU = l25;
        }
        if (i & 8192 != 0) {
            background-0d7_KjU = ColorDarkTokens.INSTANCE.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = l27;
        }
        if (i & 16384 != 0) {
            onBackground-0d7_KjU = ColorDarkTokens.INSTANCE.getOnBackground-0d7_KjU();
        } else {
            onBackground-0d7_KjU = l29;
        }
        if (i & i17 != 0) {
            surface-0d7_KjU = ColorDarkTokens.INSTANCE.getSurface-0d7_KjU();
        } else {
            surface-0d7_KjU = l31;
        }
        if (i & i19 != 0) {
            onSurface-0d7_KjU = ColorDarkTokens.INSTANCE.getOnSurface-0d7_KjU();
        } else {
            onSurface-0d7_KjU = l33;
        }
        if (i & i21 != 0) {
            surfaceVariant-0d7_KjU = ColorDarkTokens.INSTANCE.getSurfaceVariant-0d7_KjU();
        } else {
            surfaceVariant-0d7_KjU = l35;
        }
        if (i & i23 != 0) {
            onSurfaceVariant-0d7_KjU = ColorDarkTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU();
        } else {
            onSurfaceVariant-0d7_KjU = i37;
        }
        l37 = i & i25 != 0 ? obj59 : object39;
        if (i & i27 != 0) {
            inverseSurface-0d7_KjU = ColorDarkTokens.INSTANCE.getInverseSurface-0d7_KjU();
        } else {
            inverseSurface-0d7_KjU = obj99;
        }
        if (i & i29 != 0) {
            inverseOnSurface-0d7_KjU = ColorDarkTokens.INSTANCE.getInverseOnSurface-0d7_KjU();
        } else {
            inverseOnSurface-0d7_KjU = obj101;
        }
        if (i & i31 != 0) {
            error-0d7_KjU = ColorDarkTokens.INSTANCE.getError-0d7_KjU();
        } else {
            error-0d7_KjU = obj103;
        }
        if (i & i33 != 0) {
            onError-0d7_KjU = ColorDarkTokens.INSTANCE.getOnError-0d7_KjU();
        } else {
            onError-0d7_KjU = obj105;
        }
        if (i & i35 != 0) {
            errorContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getErrorContainer-0d7_KjU();
        } else {
            errorContainer-0d7_KjU = obj107;
        }
        if (i & i39 != 0) {
            onErrorContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getOnErrorContainer-0d7_KjU();
        } else {
            onErrorContainer-0d7_KjU = obj109;
        }
        if (i & i41 != 0) {
            outline-0d7_KjU = ColorDarkTokens.INSTANCE.getOutline-0d7_KjU();
        } else {
            outline-0d7_KjU = obj111;
        }
        if (i & i43 != 0) {
            outlineVariant-0d7_KjU = ColorDarkTokens.INSTANCE.getOutlineVariant-0d7_KjU();
        } else {
            outlineVariant-0d7_KjU = obj113;
        }
        if (i & i45 != 0) {
            scrim-0d7_KjU = ColorDarkTokens.INSTANCE.getScrim-0d7_KjU();
        } else {
            scrim-0d7_KjU = obj115;
        }
        if (i & i47 != 0) {
            surfaceBright-0d7_KjU = ColorDarkTokens.INSTANCE.getSurfaceBright-0d7_KjU();
        } else {
            surfaceBright-0d7_KjU = obj117;
        }
        if (i & i49 != 0) {
            surfaceContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getSurfaceContainer-0d7_KjU();
        } else {
            surfaceContainer-0d7_KjU = obj119;
        }
        if (i &= i51 != 0) {
            surfaceContainerHigh-0d7_KjU = ColorDarkTokens.INSTANCE.getSurfaceContainerHigh-0d7_KjU();
        } else {
            surfaceContainerHigh-0d7_KjU = obj121;
        }
        if (obj132 & 1 != 0) {
            surfaceContainerHighest-0d7_KjU = ColorDarkTokens.INSTANCE.getSurfaceContainerHighest-0d7_KjU();
        } else {
            surfaceContainerHighest-0d7_KjU = obj123;
        }
        if (obj132 & 2 != 0) {
            surfaceContainerLow-0d7_KjU = ColorDarkTokens.INSTANCE.getSurfaceContainerLow-0d7_KjU();
        } else {
            surfaceContainerLow-0d7_KjU = obj125;
        }
        if (obj132 & 4 != 0) {
            surfaceContainerLowest-0d7_KjU = ColorDarkTokens.INSTANCE.getSurfaceContainerLowest-0d7_KjU();
        } else {
            surfaceContainerLowest-0d7_KjU = obj127;
        }
        if (obj132 & 8 != 0) {
            surfaceDim-0d7_KjU = ColorDarkTokens.INSTANCE.getSurfaceDim-0d7_KjU();
        } else {
            surfaceDim-0d7_KjU = obj129;
        }
        return ColorSchemeKt.darkColorScheme-C-Xl9yA(obj59, l2, onPrimary-0d7_KjU, l4, primaryContainer-0d7_KjU, l6, onPrimaryContainer-0d7_KjU, l8, inversePrimary-0d7_KjU, l10, secondary-0d7_KjU, l12, onSecondary-0d7_KjU, l14, secondaryContainer-0d7_KjU, l16, onSecondaryContainer-0d7_KjU, l18, tertiary-0d7_KjU, l20, onTertiary-0d7_KjU, l22, tertiaryContainer-0d7_KjU, l24, onTertiaryContainer-0d7_KjU, l26, background-0d7_KjU, l28, onBackground-0d7_KjU, l30, surface-0d7_KjU, l32, onSurface-0d7_KjU, l34, surfaceVariant-0d7_KjU, l36);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    public static final androidx.compose.material3.ColorScheme darkColorScheme-G1PFc-w(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return ColorSchemeKt.darkColorScheme-C-Xl9yA$default(primary, obj2, primaryContainer, obj4, inversePrimary, obj6, onSecondary, obj8, onSecondaryContainer, obj10, onTertiary, obj12, onTertiaryContainer, obj14, onBackground, obj16, onSurface, obj18, onSurfaceVariant, obj20, inverseSurface, obj22, error, obj24, errorContainer, obj26, outline, obj28, scrim, obj30, obj106, obj32, obj108, obj34, obj110, obj36, obj112, obj38, obj114);
    }

    public static androidx.compose.material3.ColorScheme darkColorScheme-G1PFc-w$default(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, long l26, long l27, long l28, long l29, int i30, Object object31) {
        int iNSTANCE;
        long primary-0d7_KjU;
        long onSecondaryContainer-0d7_KjU;
        long tertiary-0d7_KjU;
        long onTertiary-0d7_KjU;
        long tertiaryContainer-0d7_KjU;
        long onTertiaryContainer-0d7_KjU;
        long background-0d7_KjU;
        long onBackground-0d7_KjU;
        long onPrimary-0d7_KjU;
        long primaryContainer-0d7_KjU;
        long onPrimaryContainer-0d7_KjU;
        long inversePrimary-0d7_KjU;
        long secondary-0d7_KjU;
        long onSecondary-0d7_KjU;
        long secondaryContainer-0d7_KjU;
        long surface-0d7_KjU;
        long onSurface-0d7_KjU;
        long surfaceVariant-0d7_KjU;
        long onSurfaceVariant-0d7_KjU;
        long l30;
        long inverseSurface-0d7_KjU;
        long inverseOnSurface-0d7_KjU;
        long error-0d7_KjU;
        long onError-0d7_KjU;
        long errorContainer-0d7_KjU;
        long onErrorContainer-0d7_KjU;
        long outline-0d7_KjU;
        long outlineVariant-0d7_KjU;
        long scrim-0d7_KjU;
        int i = obj103;
        if (i & 1 != 0) {
            primary-0d7_KjU = ColorDarkTokens.INSTANCE.getPrimary-0d7_KjU();
        } else {
            primary-0d7_KjU = l;
        }
        if (i & 2 != 0) {
            onPrimary-0d7_KjU = ColorDarkTokens.INSTANCE.getOnPrimary-0d7_KjU();
        } else {
            onPrimary-0d7_KjU = l3;
        }
        if (i & 4 != 0) {
            primaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getPrimaryContainer-0d7_KjU();
        } else {
            primaryContainer-0d7_KjU = l5;
        }
        if (i & 8 != 0) {
            onPrimaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU();
        } else {
            onPrimaryContainer-0d7_KjU = l7;
        }
        if (i & 16 != 0) {
            inversePrimary-0d7_KjU = ColorDarkTokens.INSTANCE.getInversePrimary-0d7_KjU();
        } else {
            inversePrimary-0d7_KjU = l9;
        }
        if (i & 32 != 0) {
            secondary-0d7_KjU = ColorDarkTokens.INSTANCE.getSecondary-0d7_KjU();
        } else {
            secondary-0d7_KjU = l11;
        }
        if (i & 64 != 0) {
            onSecondary-0d7_KjU = ColorDarkTokens.INSTANCE.getOnSecondary-0d7_KjU();
        } else {
            onSecondary-0d7_KjU = l13;
        }
        if (i & 128 != 0) {
            secondaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getSecondaryContainer-0d7_KjU();
        } else {
            secondaryContainer-0d7_KjU = l15;
        }
        final long obj45 = primary-0d7_KjU;
        if (i & 256 != 0) {
            onSecondaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU();
        } else {
            onSecondaryContainer-0d7_KjU = l17;
        }
        if (i & 512 != 0) {
            tertiary-0d7_KjU = ColorDarkTokens.INSTANCE.getTertiary-0d7_KjU();
        } else {
            tertiary-0d7_KjU = l19;
        }
        if (i & 1024 != 0) {
            onTertiary-0d7_KjU = ColorDarkTokens.INSTANCE.getOnTertiary-0d7_KjU();
        } else {
            onTertiary-0d7_KjU = l21;
        }
        if (i & 2048 != 0) {
            tertiaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getTertiaryContainer-0d7_KjU();
        } else {
            tertiaryContainer-0d7_KjU = l23;
        }
        if (i & 4096 != 0) {
            onTertiaryContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU();
        } else {
            onTertiaryContainer-0d7_KjU = l25;
        }
        if (i & 8192 != 0) {
            background-0d7_KjU = ColorDarkTokens.INSTANCE.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = l27;
        }
        if (i & 16384 != 0) {
            onBackground-0d7_KjU = ColorDarkTokens.INSTANCE.getOnBackground-0d7_KjU();
        } else {
            onBackground-0d7_KjU = l29;
        }
        if (i & i17 != 0) {
            surface-0d7_KjU = ColorDarkTokens.INSTANCE.getSurface-0d7_KjU();
        } else {
            surface-0d7_KjU = object31;
        }
        if (i & i19 != 0) {
            onSurface-0d7_KjU = ColorDarkTokens.INSTANCE.getOnSurface-0d7_KjU();
        } else {
            onSurface-0d7_KjU = obj77;
        }
        if (i & i21 != 0) {
            surfaceVariant-0d7_KjU = ColorDarkTokens.INSTANCE.getSurfaceVariant-0d7_KjU();
        } else {
            surfaceVariant-0d7_KjU = obj79;
        }
        if (i & i23 != 0) {
            onSurfaceVariant-0d7_KjU = ColorDarkTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU();
        } else {
            onSurfaceVariant-0d7_KjU = obj81;
        }
        l30 = i & i25 != 0 ? obj45 : obj83;
        if (i & i27 != 0) {
            inverseSurface-0d7_KjU = ColorDarkTokens.INSTANCE.getInverseSurface-0d7_KjU();
        } else {
            inverseSurface-0d7_KjU = obj85;
        }
        if (i & i29 != 0) {
            inverseOnSurface-0d7_KjU = ColorDarkTokens.INSTANCE.getInverseOnSurface-0d7_KjU();
        } else {
            inverseOnSurface-0d7_KjU = obj87;
        }
        if (i & i32 != 0) {
            error-0d7_KjU = ColorDarkTokens.INSTANCE.getError-0d7_KjU();
        } else {
            error-0d7_KjU = obj89;
        }
        if (i & i34 != 0) {
            onError-0d7_KjU = ColorDarkTokens.INSTANCE.getOnError-0d7_KjU();
        } else {
            onError-0d7_KjU = obj91;
        }
        if (i & i36 != 0) {
            errorContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getErrorContainer-0d7_KjU();
        } else {
            errorContainer-0d7_KjU = obj93;
        }
        if (i & i38 != 0) {
            onErrorContainer-0d7_KjU = ColorDarkTokens.INSTANCE.getOnErrorContainer-0d7_KjU();
        } else {
            onErrorContainer-0d7_KjU = obj95;
        }
        if (i & i40 != 0) {
            outline-0d7_KjU = ColorDarkTokens.INSTANCE.getOutline-0d7_KjU();
        } else {
            outline-0d7_KjU = obj97;
        }
        if (i & i42 != 0) {
            outlineVariant-0d7_KjU = ColorDarkTokens.INSTANCE.getOutlineVariant-0d7_KjU();
        } else {
            outlineVariant-0d7_KjU = obj99;
        }
        if (i &= i44 != 0) {
            scrim-0d7_KjU = ColorDarkTokens.INSTANCE.getScrim-0d7_KjU();
        } else {
            scrim-0d7_KjU = obj101;
        }
        return ColorSchemeKt.darkColorScheme-G1PFc-w(obj45, l2, onPrimary-0d7_KjU, l4, primaryContainer-0d7_KjU, l6, onPrimaryContainer-0d7_KjU, l8, inversePrimary-0d7_KjU, l10, secondary-0d7_KjU, l12, onSecondary-0d7_KjU, l14, secondaryContainer-0d7_KjU, l16, onSecondaryContainer-0d7_KjU, l18, tertiary-0d7_KjU, l20, onTertiary-0d7_KjU, l22, tertiaryContainer-0d7_KjU, l24, onTertiaryContainer-0d7_KjU, l26, background-0d7_KjU, l28, onBackground-0d7_KjU);
    }

    public static final androidx.compose.material3.ColorScheme expressiveLightColorScheme() {
        return ColorSchemeKt.lightColorScheme-C-Xl9yA$default(0, obj2, 0, obj4, 0, obj6, PaletteTokens.INSTANCE.getPrimary30-0d7_KjU(), obj8, 0, obj10, 0, obj12, 0, obj14, 0, obj16, PaletteTokens.INSTANCE.getSecondary30-0d7_KjU(), obj18, 0, obj20, 0, obj22, 0, obj24, PaletteTokens.INSTANCE.getSecondary30-0d7_KjU(), obj26, 0, obj28, 0, obj30, 0, obj32, 0, obj34, 0, obj36, 0, obj38, 0);
    }

    public static final long fromToken(androidx.compose.material3.ColorScheme $this$fromToken, ColorSchemeKeyTokens value) {
        long onSecondaryContainer-0d7_KjU;
        switch (i2) {
            case 1:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getBackground-0d7_KjU();
                break;
            case 2:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getError-0d7_KjU();
                break;
            case 3:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getErrorContainer-0d7_KjU();
                break;
            case 4:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getInverseOnSurface-0d7_KjU();
                break;
            case 5:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getInversePrimary-0d7_KjU();
                break;
            case 6:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getInverseSurface-0d7_KjU();
                break;
            case 7:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOnBackground-0d7_KjU();
                break;
            case 8:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOnError-0d7_KjU();
                break;
            case 9:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOnErrorContainer-0d7_KjU();
                break;
            case 10:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOnPrimary-0d7_KjU();
                break;
            case 11:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOnPrimaryContainer-0d7_KjU();
                break;
            case 12:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOnSecondary-0d7_KjU();
                break;
            case 13:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOnSecondaryContainer-0d7_KjU();
                break;
            case 14:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOnSurface-0d7_KjU();
                break;
            case 15:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOnSurfaceVariant-0d7_KjU();
                break;
            case 16:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSurfaceTint-0d7_KjU();
                break;
            case 17:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOnTertiary-0d7_KjU();
                break;
            case 18:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOnTertiaryContainer-0d7_KjU();
                break;
            case 19:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOutline-0d7_KjU();
                break;
            case 20:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getOutlineVariant-0d7_KjU();
                break;
            case 21:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getPrimary-0d7_KjU();
                break;
            case 22:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getPrimaryContainer-0d7_KjU();
                break;
            case 23:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getScrim-0d7_KjU();
                break;
            case 24:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSecondary-0d7_KjU();
                break;
            case 25:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSecondaryContainer-0d7_KjU();
                break;
            case 26:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSurface-0d7_KjU();
                break;
            case 27:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSurfaceVariant-0d7_KjU();
                break;
            case 28:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSurfaceBright-0d7_KjU();
                break;
            case 29:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSurfaceContainer-0d7_KjU();
                break;
            case 30:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSurfaceContainerHigh-0d7_KjU();
                break;
            case 31:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSurfaceContainerHighest-0d7_KjU();
                break;
            case 32:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSurfaceContainerLow-0d7_KjU();
                break;
            case 33:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSurfaceContainerLowest-0d7_KjU();
                break;
            case 34:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getSurfaceDim-0d7_KjU();
                break;
            case 35:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getTertiary-0d7_KjU();
                break;
            case 36:
                onSecondaryContainer-0d7_KjU = $this$fromToken.getTertiaryContainer-0d7_KjU();
                break;
            default:
                onSecondaryContainer-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        }
        return onSecondaryContainer-0d7_KjU;
    }

    public static final ProvidableCompositionLocal<androidx.compose.material3.ColorScheme> getLocalColorScheme() {
        return ColorSchemeKt.LocalColorScheme;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalTonalElevationEnabled() {
        return ColorSchemeKt.LocalTonalElevationEnabled;
    }

    public static final long getValue(ColorSchemeKeyTokens $this$value, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -810780884;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1009@45379L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1009)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $this$value);
    }

    public static final androidx.compose.material3.ColorScheme lightColorScheme-C-Xl9yA(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim, long surfaceBright, long surfaceContainer, long surfaceContainerHigh, long surfaceContainerHighest, long surfaceContainerLow, long surfaceContainerLowest, long surfaceDim) {
        ColorScheme colorScheme = new ColorScheme(primary, obj2, primaryContainer, obj4, inversePrimary, obj6, onSecondary, obj8, onSecondaryContainer, obj10, onTertiary, obj12, onTertiaryContainer, obj14, onBackground, obj16, onSurface, obj18, onSurfaceVariant, obj20, inverseSurface, obj22, error, obj24, errorContainer, obj26, outline, obj28, scrim, obj30, surfaceContainer, obj32, surfaceContainerHighest, obj34, surfaceContainerLowest, obj36, obj110, obj38, obj112, obj40, obj114, obj42, obj116, obj44, obj118, obj46, obj120, obj48, obj122, obj50, obj124, obj52, obj126, obj54, obj128, obj56, obj130, obj58, obj132, obj60, obj144, obj62, obj134, obj64, obj136, obj66, obj138, obj68, obj140, obj70, obj142, obj72, 0);
        return colorScheme;
    }

    public static androidx.compose.material3.ColorScheme lightColorScheme-C-Xl9yA$default(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, long l26, long l27, long l28, long l29, long l30, long l31, long l32, long l33, long l34, long l35, long l36, int i37, int i38, Object object39) {
        ColorLightTokens iNSTANCE3;
        int iNSTANCE5;
        ColorLightTokens iNSTANCE;
        int iNSTANCE2;
        ColorLightTokens iNSTANCE4;
        long primary-0d7_KjU;
        long onSecondaryContainer-0d7_KjU;
        long tertiary-0d7_KjU;
        long onTertiary-0d7_KjU;
        long tertiaryContainer-0d7_KjU;
        long onTertiaryContainer-0d7_KjU;
        long background-0d7_KjU;
        long onBackground-0d7_KjU;
        long onPrimary-0d7_KjU;
        long primaryContainer-0d7_KjU;
        long onPrimaryContainer-0d7_KjU;
        long inversePrimary-0d7_KjU;
        long secondary-0d7_KjU;
        long onSecondary-0d7_KjU;
        long secondaryContainer-0d7_KjU;
        long surface-0d7_KjU;
        long onSurface-0d7_KjU;
        long surfaceVariant-0d7_KjU;
        long onSurfaceVariant-0d7_KjU;
        long l37;
        long inverseSurface-0d7_KjU;
        long inverseOnSurface-0d7_KjU;
        long error-0d7_KjU;
        long onError-0d7_KjU;
        long errorContainer-0d7_KjU;
        long onErrorContainer-0d7_KjU;
        long outline-0d7_KjU;
        long outlineVariant-0d7_KjU;
        long scrim-0d7_KjU;
        long surfaceBright-0d7_KjU;
        long surfaceContainer-0d7_KjU;
        long surfaceContainerHigh-0d7_KjU;
        long surfaceContainerHighest-0d7_KjU;
        long surfaceContainerLow-0d7_KjU;
        long surfaceContainerLowest-0d7_KjU;
        long surfaceDim-0d7_KjU;
        int i = obj131;
        if (i & 1 != 0) {
            primary-0d7_KjU = ColorLightTokens.INSTANCE.getPrimary-0d7_KjU();
        } else {
            primary-0d7_KjU = l;
        }
        if (i & 2 != 0) {
            onPrimary-0d7_KjU = ColorLightTokens.INSTANCE.getOnPrimary-0d7_KjU();
        } else {
            onPrimary-0d7_KjU = l3;
        }
        if (i & 4 != 0) {
            primaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getPrimaryContainer-0d7_KjU();
        } else {
            primaryContainer-0d7_KjU = l5;
        }
        if (i & 8 != 0) {
            onPrimaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU();
        } else {
            onPrimaryContainer-0d7_KjU = l7;
        }
        if (i & 16 != 0) {
            inversePrimary-0d7_KjU = ColorLightTokens.INSTANCE.getInversePrimary-0d7_KjU();
        } else {
            inversePrimary-0d7_KjU = l9;
        }
        if (i & 32 != 0) {
            secondary-0d7_KjU = ColorLightTokens.INSTANCE.getSecondary-0d7_KjU();
        } else {
            secondary-0d7_KjU = l11;
        }
        if (i & 64 != 0) {
            onSecondary-0d7_KjU = ColorLightTokens.INSTANCE.getOnSecondary-0d7_KjU();
        } else {
            onSecondary-0d7_KjU = l13;
        }
        if (i & 128 != 0) {
            secondaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getSecondaryContainer-0d7_KjU();
        } else {
            secondaryContainer-0d7_KjU = l15;
        }
        final long obj59 = primary-0d7_KjU;
        if (i & 256 != 0) {
            onSecondaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU();
        } else {
            onSecondaryContainer-0d7_KjU = l17;
        }
        if (i & 512 != 0) {
            tertiary-0d7_KjU = ColorLightTokens.INSTANCE.getTertiary-0d7_KjU();
        } else {
            tertiary-0d7_KjU = l19;
        }
        if (i & 1024 != 0) {
            onTertiary-0d7_KjU = ColorLightTokens.INSTANCE.getOnTertiary-0d7_KjU();
        } else {
            onTertiary-0d7_KjU = l21;
        }
        if (i & 2048 != 0) {
            tertiaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getTertiaryContainer-0d7_KjU();
        } else {
            tertiaryContainer-0d7_KjU = l23;
        }
        if (i & 4096 != 0) {
            onTertiaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU();
        } else {
            onTertiaryContainer-0d7_KjU = l25;
        }
        if (i & 8192 != 0) {
            background-0d7_KjU = ColorLightTokens.INSTANCE.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = l27;
        }
        if (i & 16384 != 0) {
            onBackground-0d7_KjU = ColorLightTokens.INSTANCE.getOnBackground-0d7_KjU();
        } else {
            onBackground-0d7_KjU = l29;
        }
        if (i & i17 != 0) {
            surface-0d7_KjU = ColorLightTokens.INSTANCE.getSurface-0d7_KjU();
        } else {
            surface-0d7_KjU = l31;
        }
        if (i & i19 != 0) {
            onSurface-0d7_KjU = ColorLightTokens.INSTANCE.getOnSurface-0d7_KjU();
        } else {
            onSurface-0d7_KjU = l33;
        }
        if (i & i21 != 0) {
            surfaceVariant-0d7_KjU = ColorLightTokens.INSTANCE.getSurfaceVariant-0d7_KjU();
        } else {
            surfaceVariant-0d7_KjU = l35;
        }
        if (i & i23 != 0) {
            onSurfaceVariant-0d7_KjU = ColorLightTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU();
        } else {
            onSurfaceVariant-0d7_KjU = i37;
        }
        l37 = i & i25 != 0 ? obj59 : object39;
        if (i & i27 != 0) {
            inverseSurface-0d7_KjU = ColorLightTokens.INSTANCE.getInverseSurface-0d7_KjU();
        } else {
            inverseSurface-0d7_KjU = obj99;
        }
        if (i & i29 != 0) {
            inverseOnSurface-0d7_KjU = ColorLightTokens.INSTANCE.getInverseOnSurface-0d7_KjU();
        } else {
            inverseOnSurface-0d7_KjU = obj101;
        }
        if (i & i31 != 0) {
            error-0d7_KjU = ColorLightTokens.INSTANCE.getError-0d7_KjU();
        } else {
            error-0d7_KjU = obj103;
        }
        if (i & i33 != 0) {
            onError-0d7_KjU = ColorLightTokens.INSTANCE.getOnError-0d7_KjU();
        } else {
            onError-0d7_KjU = obj105;
        }
        if (i & i35 != 0) {
            errorContainer-0d7_KjU = ColorLightTokens.INSTANCE.getErrorContainer-0d7_KjU();
        } else {
            errorContainer-0d7_KjU = obj107;
        }
        if (i & i39 != 0) {
            onErrorContainer-0d7_KjU = ColorLightTokens.INSTANCE.getOnErrorContainer-0d7_KjU();
        } else {
            onErrorContainer-0d7_KjU = obj109;
        }
        if (i & i41 != 0) {
            outline-0d7_KjU = ColorLightTokens.INSTANCE.getOutline-0d7_KjU();
        } else {
            outline-0d7_KjU = obj111;
        }
        if (i & i43 != 0) {
            outlineVariant-0d7_KjU = ColorLightTokens.INSTANCE.getOutlineVariant-0d7_KjU();
        } else {
            outlineVariant-0d7_KjU = obj113;
        }
        if (i & i45 != 0) {
            scrim-0d7_KjU = ColorLightTokens.INSTANCE.getScrim-0d7_KjU();
        } else {
            scrim-0d7_KjU = obj115;
        }
        if (i & i47 != 0) {
            surfaceBright-0d7_KjU = ColorLightTokens.INSTANCE.getSurfaceBright-0d7_KjU();
        } else {
            surfaceBright-0d7_KjU = obj117;
        }
        if (i & i49 != 0) {
            surfaceContainer-0d7_KjU = ColorLightTokens.INSTANCE.getSurfaceContainer-0d7_KjU();
        } else {
            surfaceContainer-0d7_KjU = obj119;
        }
        if (i &= i51 != 0) {
            surfaceContainerHigh-0d7_KjU = ColorLightTokens.INSTANCE.getSurfaceContainerHigh-0d7_KjU();
        } else {
            surfaceContainerHigh-0d7_KjU = obj121;
        }
        if (obj132 & 1 != 0) {
            surfaceContainerHighest-0d7_KjU = ColorLightTokens.INSTANCE.getSurfaceContainerHighest-0d7_KjU();
        } else {
            surfaceContainerHighest-0d7_KjU = obj123;
        }
        if (obj132 & 2 != 0) {
            surfaceContainerLow-0d7_KjU = ColorLightTokens.INSTANCE.getSurfaceContainerLow-0d7_KjU();
        } else {
            surfaceContainerLow-0d7_KjU = obj125;
        }
        if (obj132 & 4 != 0) {
            surfaceContainerLowest-0d7_KjU = ColorLightTokens.INSTANCE.getSurfaceContainerLowest-0d7_KjU();
        } else {
            surfaceContainerLowest-0d7_KjU = obj127;
        }
        if (obj132 & 8 != 0) {
            surfaceDim-0d7_KjU = ColorLightTokens.INSTANCE.getSurfaceDim-0d7_KjU();
        } else {
            surfaceDim-0d7_KjU = obj129;
        }
        return ColorSchemeKt.lightColorScheme-C-Xl9yA(obj59, l2, onPrimary-0d7_KjU, l4, primaryContainer-0d7_KjU, l6, onPrimaryContainer-0d7_KjU, l8, inversePrimary-0d7_KjU, l10, secondary-0d7_KjU, l12, onSecondary-0d7_KjU, l14, secondaryContainer-0d7_KjU, l16, onSecondaryContainer-0d7_KjU, l18, tertiary-0d7_KjU, l20, onTertiary-0d7_KjU, l22, tertiaryContainer-0d7_KjU, l24, onTertiaryContainer-0d7_KjU, l26, background-0d7_KjU, l28, onBackground-0d7_KjU, l30, surface-0d7_KjU, l32, onSurface-0d7_KjU, l34, surfaceVariant-0d7_KjU, l36);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    public static final androidx.compose.material3.ColorScheme lightColorScheme-G1PFc-w(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return ColorSchemeKt.lightColorScheme-C-Xl9yA$default(primary, obj2, primaryContainer, obj4, inversePrimary, obj6, onSecondary, obj8, onSecondaryContainer, obj10, onTertiary, obj12, onTertiaryContainer, obj14, onBackground, obj16, onSurface, obj18, onSurfaceVariant, obj20, inverseSurface, obj22, error, obj24, errorContainer, obj26, outline, obj28, scrim, obj30, obj106, obj32, obj108, obj34, obj110, obj36, obj112, obj38, obj114);
    }

    public static androidx.compose.material3.ColorScheme lightColorScheme-G1PFc-w$default(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, long l26, long l27, long l28, long l29, int i30, Object object31) {
        int iNSTANCE;
        long primary-0d7_KjU;
        long onSecondaryContainer-0d7_KjU;
        long tertiary-0d7_KjU;
        long onTertiary-0d7_KjU;
        long tertiaryContainer-0d7_KjU;
        long onTertiaryContainer-0d7_KjU;
        long background-0d7_KjU;
        long onBackground-0d7_KjU;
        long onPrimary-0d7_KjU;
        long primaryContainer-0d7_KjU;
        long onPrimaryContainer-0d7_KjU;
        long inversePrimary-0d7_KjU;
        long secondary-0d7_KjU;
        long onSecondary-0d7_KjU;
        long secondaryContainer-0d7_KjU;
        long surface-0d7_KjU;
        long onSurface-0d7_KjU;
        long surfaceVariant-0d7_KjU;
        long onSurfaceVariant-0d7_KjU;
        long l30;
        long inverseSurface-0d7_KjU;
        long inverseOnSurface-0d7_KjU;
        long error-0d7_KjU;
        long onError-0d7_KjU;
        long errorContainer-0d7_KjU;
        long onErrorContainer-0d7_KjU;
        long outline-0d7_KjU;
        long outlineVariant-0d7_KjU;
        long scrim-0d7_KjU;
        int i = obj103;
        if (i & 1 != 0) {
            primary-0d7_KjU = ColorLightTokens.INSTANCE.getPrimary-0d7_KjU();
        } else {
            primary-0d7_KjU = l;
        }
        if (i & 2 != 0) {
            onPrimary-0d7_KjU = ColorLightTokens.INSTANCE.getOnPrimary-0d7_KjU();
        } else {
            onPrimary-0d7_KjU = l3;
        }
        if (i & 4 != 0) {
            primaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getPrimaryContainer-0d7_KjU();
        } else {
            primaryContainer-0d7_KjU = l5;
        }
        if (i & 8 != 0) {
            onPrimaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU();
        } else {
            onPrimaryContainer-0d7_KjU = l7;
        }
        if (i & 16 != 0) {
            inversePrimary-0d7_KjU = ColorLightTokens.INSTANCE.getInversePrimary-0d7_KjU();
        } else {
            inversePrimary-0d7_KjU = l9;
        }
        if (i & 32 != 0) {
            secondary-0d7_KjU = ColorLightTokens.INSTANCE.getSecondary-0d7_KjU();
        } else {
            secondary-0d7_KjU = l11;
        }
        if (i & 64 != 0) {
            onSecondary-0d7_KjU = ColorLightTokens.INSTANCE.getOnSecondary-0d7_KjU();
        } else {
            onSecondary-0d7_KjU = l13;
        }
        if (i & 128 != 0) {
            secondaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getSecondaryContainer-0d7_KjU();
        } else {
            secondaryContainer-0d7_KjU = l15;
        }
        final long obj45 = primary-0d7_KjU;
        if (i & 256 != 0) {
            onSecondaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU();
        } else {
            onSecondaryContainer-0d7_KjU = l17;
        }
        if (i & 512 != 0) {
            tertiary-0d7_KjU = ColorLightTokens.INSTANCE.getTertiary-0d7_KjU();
        } else {
            tertiary-0d7_KjU = l19;
        }
        if (i & 1024 != 0) {
            onTertiary-0d7_KjU = ColorLightTokens.INSTANCE.getOnTertiary-0d7_KjU();
        } else {
            onTertiary-0d7_KjU = l21;
        }
        if (i & 2048 != 0) {
            tertiaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getTertiaryContainer-0d7_KjU();
        } else {
            tertiaryContainer-0d7_KjU = l23;
        }
        if (i & 4096 != 0) {
            onTertiaryContainer-0d7_KjU = ColorLightTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU();
        } else {
            onTertiaryContainer-0d7_KjU = l25;
        }
        if (i & 8192 != 0) {
            background-0d7_KjU = ColorLightTokens.INSTANCE.getBackground-0d7_KjU();
        } else {
            background-0d7_KjU = l27;
        }
        if (i & 16384 != 0) {
            onBackground-0d7_KjU = ColorLightTokens.INSTANCE.getOnBackground-0d7_KjU();
        } else {
            onBackground-0d7_KjU = l29;
        }
        if (i & i17 != 0) {
            surface-0d7_KjU = ColorLightTokens.INSTANCE.getSurface-0d7_KjU();
        } else {
            surface-0d7_KjU = object31;
        }
        if (i & i19 != 0) {
            onSurface-0d7_KjU = ColorLightTokens.INSTANCE.getOnSurface-0d7_KjU();
        } else {
            onSurface-0d7_KjU = obj77;
        }
        if (i & i21 != 0) {
            surfaceVariant-0d7_KjU = ColorLightTokens.INSTANCE.getSurfaceVariant-0d7_KjU();
        } else {
            surfaceVariant-0d7_KjU = obj79;
        }
        if (i & i23 != 0) {
            onSurfaceVariant-0d7_KjU = ColorLightTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU();
        } else {
            onSurfaceVariant-0d7_KjU = obj81;
        }
        l30 = i & i25 != 0 ? obj45 : obj83;
        if (i & i27 != 0) {
            inverseSurface-0d7_KjU = ColorLightTokens.INSTANCE.getInverseSurface-0d7_KjU();
        } else {
            inverseSurface-0d7_KjU = obj85;
        }
        if (i & i29 != 0) {
            inverseOnSurface-0d7_KjU = ColorLightTokens.INSTANCE.getInverseOnSurface-0d7_KjU();
        } else {
            inverseOnSurface-0d7_KjU = obj87;
        }
        if (i & i32 != 0) {
            error-0d7_KjU = ColorLightTokens.INSTANCE.getError-0d7_KjU();
        } else {
            error-0d7_KjU = obj89;
        }
        if (i & i34 != 0) {
            onError-0d7_KjU = ColorLightTokens.INSTANCE.getOnError-0d7_KjU();
        } else {
            onError-0d7_KjU = obj91;
        }
        if (i & i36 != 0) {
            errorContainer-0d7_KjU = ColorLightTokens.INSTANCE.getErrorContainer-0d7_KjU();
        } else {
            errorContainer-0d7_KjU = obj93;
        }
        if (i & i38 != 0) {
            onErrorContainer-0d7_KjU = ColorLightTokens.INSTANCE.getOnErrorContainer-0d7_KjU();
        } else {
            onErrorContainer-0d7_KjU = obj95;
        }
        if (i & i40 != 0) {
            outline-0d7_KjU = ColorLightTokens.INSTANCE.getOutline-0d7_KjU();
        } else {
            outline-0d7_KjU = obj97;
        }
        if (i & i42 != 0) {
            outlineVariant-0d7_KjU = ColorLightTokens.INSTANCE.getOutlineVariant-0d7_KjU();
        } else {
            outlineVariant-0d7_KjU = obj99;
        }
        if (i &= i44 != 0) {
            scrim-0d7_KjU = ColorLightTokens.INSTANCE.getScrim-0d7_KjU();
        } else {
            scrim-0d7_KjU = obj101;
        }
        return ColorSchemeKt.lightColorScheme-G1PFc-w(obj45, l2, onPrimary-0d7_KjU, l4, primaryContainer-0d7_KjU, l6, onPrimaryContainer-0d7_KjU, l8, inversePrimary-0d7_KjU, l10, secondary-0d7_KjU, l12, onSecondary-0d7_KjU, l14, secondaryContainer-0d7_KjU, l16, onSecondaryContainer-0d7_KjU, l18, tertiary-0d7_KjU, l20, onTertiary-0d7_KjU, l22, tertiaryContainer-0d7_KjU, l24, onTertiaryContainer-0d7_KjU, l26, background-0d7_KjU, l28, onBackground-0d7_KjU);
    }

    public static final long surfaceColorAtElevation-3ABfNKs(androidx.compose.material3.ColorScheme $this$surfaceColorAtElevation_u2d3ABfNKs, float elevation) {
        if (Dp.equals-impl0(elevation, Dp.constructor-impl((float)i))) {
            return $this$surfaceColorAtElevation_u2d3ABfNKs.getSurface-0d7_KjU();
        }
        int i9 = 1120403456;
        return ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default($this$surfaceColorAtElevation_u2d3ABfNKs.getSurfaceTint-0d7_KjU(), obj3, i5 / i9, 0, 0, 0, 14), i9);
    }
}
