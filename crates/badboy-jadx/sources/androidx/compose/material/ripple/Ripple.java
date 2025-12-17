package androidx.compose.material.ripple;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Deprecated(message = "Replaced by the new RippleNode implementation")
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008!\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0013\u0010\u000b\u001a\u00020\u00032\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0096\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014JF\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0007H'ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001b", d2 = {"Landroidx/compose/material/ripple/Ripple;", "Landroidx/compose/foundation/Indication;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", "other", "", "hashCode", "", "rememberUpdatedInstance", "Landroidx/compose/foundation/IndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/IndicationInstance;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Ripple implements Indication {

    public static final int $stable;
    private final boolean bounded;
    private final State<Color> color;
    private final float radius;
    static {
    }

    private Ripple(boolean bounded, float radius, State<Color> color) {
        super();
        this.bounded = bounded;
        this.radius = radius;
        this.color = color;
    }

    public Ripple(boolean z, float f2, State state3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(z, f2, state3);
    }

    @Override // androidx.compose.foundation.Indication
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof Ripple) {
            return i2;
        }
        if (this.bounded != obj.bounded) {
            return i2;
        }
        if (!Dp.equals-impl0(this.radius, obj2.radius)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.color, obj3.color)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.Indication
    public int hashCode() {
        return result += i6;
    }

    @Deprecated(message = "Super method is deprecated")
    public final IndicationInstance rememberUpdatedInstance(InteractionSource interactionSource, Composer $composer, int $changed) {
        int $this$isSpecified$iv;
        long defaultColor-WaAFU9c;
        boolean changed;
        boolean traceInProgress;
        String str;
        int i;
        Object empty;
        Object anon;
        int i2;
        final Composer composer2 = $composer;
        final int i22 = $changed;
        int i3 = 988743187;
        composer2.startReplaceGroup(i3);
        ComposerKt.sourceInformation(composer2, "C(rememberUpdatedInstance)197@9514L7,198@9542L221,207@9856L13,207@9829L41,209@9895L155,217@10104L491,217@10060L535:Ripple.kt#vhb33q");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, i22, -1, "androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:196)");
        }
        int i15 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer2);
        final Object obj2 = consume;
        int i16 = 0;
        int i23 = 0;
        $this$isSpecified$iv = Long.compare(unbox-impl, unspecified-0d7_KjU) != 0 ? i : i23;
        if ($this$isSpecified$iv != 0) {
            composer2.startReplaceGroup(-303571590);
            composer2.endReplaceGroup();
            defaultColor-WaAFU9c = (Color)this.color.getValue().unbox-impl();
        } else {
            composer2.startReplaceGroup(-303521246);
            ComposerKt.sourceInformation(composer2, "203@9725L14");
            defaultColor-WaAFU9c = (RippleTheme)obj2.defaultColor-WaAFU9c(composer2, i23);
            composer2.endReplaceGroup();
        }
        InteractionSource interactionSource2 = interactionSource;
        androidx.compose.material.ripple.RippleIndicationInstance rememberUpdatedRippleInstance-942rkJo = this.rememberUpdatedRippleInstance-942rkJo(interactionSource2, this.bounded, this.radius, SnapshotStateKt.rememberUpdatedState(Color.box-impl(defaultColor-WaAFU9c), composer2, i23), SnapshotStateKt.rememberUpdatedState(obj2.rippleAlpha(composer2, i23), composer2, i23), composer2, i6 | i14);
        ComposerKt.sourceInformationMarkerStart(composer2, -9776216, "CC(remember):Ripple.kt#9igjgp");
        int i18 = 4;
        if (i8 ^= 6 > i18) {
            if (!composer2.changed(interactionSource2)) {
                if (i22 & 6 == i18) {
                } else {
                    i = i23;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i21 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i24 = 0;
        if (changedInstance |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new Ripple.rememberUpdatedInstance.1.1(interactionSource2, rememberUpdatedRippleInstance-942rkJo, 0);
                composer.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.LaunchedEffect(rememberUpdatedRippleInstance-942rkJo, interactionSource2, (Function2)anon, composer2, i10 &= 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceGroup();
        return (IndicationInstance)rememberUpdatedRippleInstance-942rkJo;
    }

    public abstract androidx.compose.material.ripple.RippleIndicationInstance rememberUpdatedRippleInstance-942rkJo(InteractionSource interactionSource, boolean z2, float f3, State<Color> state4, State<androidx.compose.material.ripple.RippleAlpha> state5, Composer composer6, int i7);
}
