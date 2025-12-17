package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationNodeFactory;
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
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u001a0\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a0\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0008\u0010\t\"\"\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000c\u0010\u0007\u001a\u0004\u0008\r\u0010\t\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"DefaultBoundedRipple", "Landroidx/compose/material3/RippleNodeFactory;", "DefaultUnboundedRipple", "LocalRippleConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/RippleConfiguration;", "getLocalRippleConfiguration$annotations", "()V", "getLocalRippleConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalUseFallbackRippleImplementation", "", "getLocalUseFallbackRippleImplementation$annotations", "getLocalUseFallbackRippleImplementation", "ripple", "Landroidx/compose/foundation/IndicationNodeFactory;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "bounded", "radius", "Landroidx/compose/ui/unit/Dp;", "ripple-wH6b6FI", "(Landroidx/compose/ui/graphics/ColorProducer;ZF)Landroidx/compose/foundation/IndicationNodeFactory;", "Landroidx/compose/ui/graphics/Color;", "ripple-H2RKhps", "(ZFJ)Landroidx/compose/foundation/IndicationNodeFactory;", "rippleOrFallbackImplementation", "Landroidx/compose/foundation/Indication;", "rippleOrFallbackImplementation-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RippleKt {

    private static final androidx.compose.material3.RippleNodeFactory DefaultBoundedRipple;
    private static final androidx.compose.material3.RippleNodeFactory DefaultUnboundedRipple;
    private static final ProvidableCompositionLocal<androidx.compose.material3.RippleConfiguration> LocalRippleConfiguration;
    private static final ProvidableCompositionLocal<Boolean> LocalUseFallbackRippleImplementation;
    static {
        RippleKt.LocalUseFallbackRippleImplementation = CompositionLocalKt.staticCompositionLocalOf((Function0)RippleKt.LocalUseFallbackRippleImplementation.1.INSTANCE);
        int i2 = 0;
        RippleKt.LocalRippleConfiguration = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)RippleKt.LocalRippleConfiguration.1.INSTANCE, 1, i2);
        final int i5 = 0;
        RippleNodeFactory rippleNodeFactory = new RippleNodeFactory(1, Dp.Companion.getUnspecified-D9Ej5fM(), Color.Companion.getUnspecified-0d7_KjU(), obj5, i5);
        RippleKt.DefaultBoundedRipple = rippleNodeFactory;
        RippleNodeFactory rippleNodeFactory2 = new RippleNodeFactory(0, Dp.Companion.getUnspecified-D9Ej5fM(), Color.Companion.getUnspecified-0d7_KjU(), i5, 0);
        RippleKt.DefaultUnboundedRipple = rippleNodeFactory2;
    }

    public static final ProvidableCompositionLocal<androidx.compose.material3.RippleConfiguration> getLocalRippleConfiguration() {
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
        androidx.compose.material3.RippleNodeFactory defaultUnboundedRipple;
        androidx.compose.material3.RippleNodeFactory rippleNodeFactory;
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
        int i2;
        int i3;
        int obj8;
        float obj9;
        long obj10;
        final int i4 = -1315814667;
        ComposerKt.sourceInformationMarkerStart($changed, i4, "C(rippleOrFallbackImplementation)P(!1,2:c#ui.unit.Dp,1:c#ui.graphics.Color):Ripple.kt#uh7d8r");
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
            ComposerKt.traceEventStart(i4, i6, -1, "androidx.compose.material3.rippleOrFallbackImplementation (Ripple.kt:230)");
        }
        $changed.startReplaceGroup(-1280632857);
        ComposerKt.sourceInformation($changed, "231@10696L7,232@10748L38");
        obj9 = 6;
        obj10 = 0;
        ComposerKt.sourceInformationMarkerStart($changed, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($changed);
        if ((Boolean)$changed.consume((CompositionLocal)RippleKt.LocalUseFallbackRippleImplementation).booleanValue()) {
            obj8 = RippleKt.rememberRipple-9IZ8Weo(i, f, l, obj4, $changed, obj8 | obj9);
        } else {
            $composer2 = $changed;
            obj8 = RippleKt.ripple-H2RKhps(i, f, l);
        }
        $composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        return obj8;
    }
}
