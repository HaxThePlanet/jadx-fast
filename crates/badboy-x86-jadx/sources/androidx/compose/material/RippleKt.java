package androidx.compose.material;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a.\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001a\u001a0\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a0\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u001bH\u0001ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00088GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u000c\u0010\r\"\"\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u00088GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0010\u0010\u000b\u001a\u0004\u0008\u0011\u0010\r\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"DarkThemeRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "DefaultBoundedRipple", "Landroidx/compose/material/RippleNodeFactory;", "DefaultUnboundedRipple", "LightThemeHighContrastRippleAlpha", "LightThemeLowContrastRippleAlpha", "LocalRippleConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/RippleConfiguration;", "getLocalRippleConfiguration$annotations", "()V", "getLocalRippleConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalUseFallbackRippleImplementation", "", "getLocalUseFallbackRippleImplementation$annotations", "getLocalUseFallbackRippleImplementation", "ripple", "Landroidx/compose/foundation/IndicationNodeFactory;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "bounded", "radius", "Landroidx/compose/ui/unit/Dp;", "ripple-wH6b6FI", "(Landroidx/compose/ui/graphics/ColorProducer;ZF)Landroidx/compose/foundation/IndicationNodeFactory;", "Landroidx/compose/ui/graphics/Color;", "ripple-H2RKhps", "(ZFJ)Landroidx/compose/foundation/IndicationNodeFactory;", "rippleOrFallbackImplementation", "Landroidx/compose/foundation/Indication;", "rippleOrFallbackImplementation-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RippleKt {

    private static final RippleAlpha DarkThemeRippleAlpha;
    private static final androidx.compose.material.RippleNodeFactory DefaultBoundedRipple;
    private static final androidx.compose.material.RippleNodeFactory DefaultUnboundedRipple;
    private static final RippleAlpha LightThemeHighContrastRippleAlpha;
    private static final RippleAlpha LightThemeLowContrastRippleAlpha;
    private static final ProvidableCompositionLocal<androidx.compose.material.RippleConfiguration> LocalRippleConfiguration;
    private static final ProvidableCompositionLocal<Boolean> LocalUseFallbackRippleImplementation;
    static {
        RippleKt.LocalUseFallbackRippleImplementation = CompositionLocalKt.staticCompositionLocalOf((Function0)RippleKt.LocalUseFallbackRippleImplementation.1.INSTANCE);
        int i4 = 0;
        RippleKt.LocalRippleConfiguration = CompositionLocalKt.compositionLocalOf$default(i4, (Function0)RippleKt.LocalRippleConfiguration.1.INSTANCE, 1, i4);
        final int i11 = 0;
        RippleNodeFactory rippleNodeFactory = new RippleNodeFactory(1, Dp.Companion.getUnspecified-D9Ej5fM(), Color.Companion.getUnspecified-0d7_KjU(), obj5, i11);
        RippleKt.DefaultBoundedRipple = rippleNodeFactory;
        RippleNodeFactory rippleNodeFactory2 = new RippleNodeFactory(0, Dp.Companion.getUnspecified-D9Ej5fM(), Color.Companion.getUnspecified-0d7_KjU(), i11, 0);
        RippleKt.DefaultUnboundedRipple = rippleNodeFactory2;
        int i6 = 1047904911;
        int i9 = 1034147594;
        RippleAlpha rippleAlpha = new RippleAlpha(1042536202, i6, i9, i6);
        RippleKt.LightThemeHighContrastRippleAlpha = rippleAlpha;
        int i3 = 1039516303;
        int i7 = 1025758986;
        RippleAlpha rippleAlpha2 = new RippleAlpha(i9, i3, i7, i3);
        RippleKt.LightThemeLowContrastRippleAlpha = rippleAlpha2;
        RippleAlpha rippleAlpha3 = new RippleAlpha(i9, i3, i7, 1036831949);
        RippleKt.DarkThemeRippleAlpha = rippleAlpha3;
    }

    public static final RippleAlpha access$getDarkThemeRippleAlpha$p() {
        return RippleKt.DarkThemeRippleAlpha;
    }

    public static final RippleAlpha access$getLightThemeHighContrastRippleAlpha$p() {
        return RippleKt.LightThemeHighContrastRippleAlpha;
    }

    public static final RippleAlpha access$getLightThemeLowContrastRippleAlpha$p() {
        return RippleKt.LightThemeLowContrastRippleAlpha;
    }

    public static final ProvidableCompositionLocal<androidx.compose.material.RippleConfiguration> getLocalRippleConfiguration() {
        return RippleKt.LocalRippleConfiguration;
    }

    public static void getLocalRippleConfiguration$annotations() {
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUseFallbackRippleImplementation() {
        return RippleKt.LocalUseFallbackRippleImplementation;
    }

    public static void getLocalUseFallbackRippleImplementation$annotations() {
    }

    public static final IndicationNodeFactory ripple-H2RKhps(boolean bounded, float radius, long color) {
        boolean equals-impl0;
        androidx.compose.material.RippleNodeFactory defaultUnboundedRipple;
        androidx.compose.material.RippleNodeFactory rippleNodeFactory;
        boolean z;
        float f;
        long l;
        int i;
        if (Dp.equals-impl0(radius, Dp.Companion.getUnspecified-D9Ej5fM()) && Color.equals-impl0(color, obj10)) {
            if (Color.equals-impl0(color, obj10)) {
                if (bounded) {
                    return (IndicationNodeFactory)RippleKt.DefaultBoundedRipple;
                }
                defaultUnboundedRipple = RippleKt.DefaultUnboundedRipple;
                z = bounded;
                f = radius;
                l = color;
            } else {
                rippleNodeFactory = new RippleNodeFactory(bounded, radius, color, obj5, 0);
                defaultUnboundedRipple = rippleNodeFactory;
            }
        } else {
        }
        return defaultUnboundedRipple;
    }

    public static IndicationNodeFactory ripple-H2RKhps$default(boolean z, float f2, long l3, int i4, Object object5) {
        int obj0;
        float obj1;
        long obj2;
        if (object5 & 1 != 0) {
            obj0 = 1;
        }
        if (object5 & 2 != 0) {
            obj1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (object5 &= 4 != 0) {
            obj2 = Color.Companion.getUnspecified-0d7_KjU();
        }
        return RippleKt.ripple-H2RKhps(obj0, obj1, obj2);
    }

    public static final IndicationNodeFactory ripple-wH6b6FI(ColorProducer color, boolean bounded, float radius) {
        RippleNodeFactory rippleNodeFactory = new RippleNodeFactory(bounded, radius, color, 0);
        return (IndicationNodeFactory)rippleNodeFactory;
    }

    public static IndicationNodeFactory ripple-wH6b6FI$default(ColorProducer colorProducer, boolean z2, float f3, int i4, Object object5) {
        int obj1;
        float obj2;
        if (i4 & 2 != 0) {
            obj1 = 1;
        }
        if (i4 &= 4 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return RippleKt.ripple-wH6b6FI(colorProducer, obj1, obj2);
    }

    public static final Indication rippleOrFallbackImplementation-9IZ8Weo(boolean bounded, float radius, long color, Composer $composer, int $changed, int i6) {
        int i;
        float f;
        long l;
        Composer $composer2;
        int i3;
        int i2;
        int obj8;
        float obj9;
        long obj10;
        final int i4 = -58830494;
        ComposerKt.sourceInformationMarkerStart($changed, i4, "C(rippleOrFallbackImplementation)P(!1,2:c#ui.unit.Dp,1:c#ui.graphics.Color)265@11741L7:Ripple.kt#jmzs0o");
        i = obj14 & 1 != 0 ? obj8 : bounded;
        if (obj14 & 2 != 0) {
            f = obj9;
        } else {
            f = radius;
        }
        if (obj14 & 4 != 0) {
            l = obj10;
        } else {
            l = color;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, i6, -1, "androidx.compose.material.rippleOrFallbackImplementation (Ripple.kt:264)");
        }
        obj9 = 6;
        obj10 = 0;
        ComposerKt.sourceInformationMarkerStart($changed, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($changed);
        if ((Boolean)$changed.consume((CompositionLocal)RippleKt.LocalUseFallbackRippleImplementation).booleanValue()) {
            $changed.startReplaceGroup(96412190);
            ComposerKt.sourceInformation($changed, "266@11793L38");
            $composer2 = $changed;
            obj8 = RippleKt.rememberRipple-9IZ8Weo(i, f, l, obj4, $composer2, obj8 | obj9);
            $composer2.endReplaceGroup();
        } else {
            $composer2 = $changed;
            $composer2.startReplaceGroup(96503175);
            $composer2.endReplaceGroup();
            obj8 = RippleKt.ripple-H2RKhps(i, f, l);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        return obj8;
    }
}
