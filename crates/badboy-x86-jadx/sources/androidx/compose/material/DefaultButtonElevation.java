package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J#\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017¢\u0006\u0002\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0011", d2 = {"Landroidx/compose/material/DefaultButtonElevation;", "Landroidx/compose/material/ButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "disabledElevation", "hoveredElevation", "focusedElevation", "(FFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "elevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultButtonElevation implements androidx.compose.material.ButtonElevation {

    private final float defaultElevation;
    private final float disabledElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;
    private DefaultButtonElevation(float defaultElevation, float pressedElevation, float disabledElevation, float hoveredElevation, float focusedElevation) {
        super();
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.disabledElevation = disabledElevation;
        this.hoveredElevation = hoveredElevation;
        this.focusedElevation = focusedElevation;
    }

    public DefaultButtonElevation(float f, float f2, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(f, f2, f3, f4, f5);
    }

    public static final float access$getFocusedElevation$p(androidx.compose.material.DefaultButtonElevation $this) {
        return $this.focusedElevation;
    }

    public static final float access$getHoveredElevation$p(androidx.compose.material.DefaultButtonElevation $this) {
        return $this.hoveredElevation;
    }

    public static final float access$getPressedElevation$p(androidx.compose.material.DefaultButtonElevation $this) {
        return $this.pressedElevation;
    }

    public State<Dp> elevation(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean changed;
        int i7;
        float disabledElevation;
        Object animatable2;
        boolean traceInProgress;
        Animatable it$iv;
        String str;
        float f;
        int i4;
        boolean changed3;
        int i8;
        int changed2;
        Object it$iv2;
        Object mutableStateListOf;
        Object empty;
        Object anon;
        Object animatable3;
        int i;
        Animatable animatable;
        Dp box-impl;
        Object obj;
        androidx.compose.animation.core.TwoWayConverter vectorConverter;
        int i2;
        int i3;
        int i5;
        int i6;
        final Object obj2 = this;
        boolean z4 = enabled;
        final Object obj5 = interactionSource;
        final Composer composer4 = $composer;
        final int i26 = $changed;
        int i9 = -1588756907;
        composer4.startReplaceGroup(i9);
        ComposerKt.sourceInformation(composer4, "C(elevation)507@20573L46,508@20662L1077,508@20628L1111,549@22188L51,551@22272L819,551@22249L842:Button.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, i26, -1, "androidx.compose.material.DefaultButtonElevation.elevation (Button.kt:506)");
        }
        String str3 = "CC(remember):Button.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer4, 1976547373, str3);
        int i11 = 0;
        Composer composer = $composer;
        i4 = 0;
        Object rememberedValue2 = composer.rememberedValue();
        int i27 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            int i28 = 0;
            composer.updateRememberedValue(SnapshotStateKt.mutableStateListOf());
        } else {
            mutableStateListOf = rememberedValue2;
        }
        androidx.compose.runtime.snapshots.SnapshotStateList list2 = mutableStateListOf;
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerStart(composer4, 1976551252, str3);
        int i21 = 32;
        int i29 = 0;
        if (i13 ^= 48 > i21) {
            if (!composer4.changed(obj5)) {
                i7 = i26 & 48 == i21 ? 1 : i29;
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i22 = 0;
        Object rememberedValue3 = composer2.rememberedValue();
        int i31 = 0;
        if (i7 == 0) {
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new DefaultButtonElevation.elevation.1.1(obj5, (SnapshotStateList)list2, 0);
                composer2.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue3;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        EffectsKt.LaunchedEffect(obj5, (Function2)anon, composer4, i14 &= 14);
        Object obj3 = lastOrNull;
        f = !z4 ? disabledElevation : z ? disabledElevation : z2 ? disabledElevation : z3 ? disabledElevation : disabledElevation;
        ComposerKt.sourceInformationMarkerStart(composer4, 1976599058, str3);
        int i17 = 0;
        Composer composer3 = $composer;
        int i30 = 0;
        Object rememberedValue4 = composer3.rememberedValue();
        int i35 = 0;
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            int i36 = 0;
            animatable = new Animatable(Dp.box-impl(f), VectorConvertersKt.getVectorConverter(Dp.Companion), 0, 0, 12, 0);
            composer3.updateRememberedValue(animatable);
        } else {
            animatable3 = rememberedValue4;
        }
        Animatable invalid$iv = animatable3;
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerStart(composer4, 1976602514, str3);
        int i32 = 4;
        if (i24 ^= 6 > i32) {
            if (!composer4.changed(z4)) {
                i8 = i26 & 6 == i32 ? 1 : i29;
            } else {
            }
        } else {
        }
        int i33 = 256;
        if (i25 ^= 384 > i33) {
            if (!composer4.changed(obj2)) {
                i = i26 & 384 == i33 ? 1 : i29;
            } else {
            }
        } else {
        }
        Composer composer5 = $composer;
        int i37 = 0;
        Object rememberedValue = composer5.rememberedValue();
        int i38 = 0;
        if (i20 | it$iv2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                animatable = 0;
                obj = obj4;
                animatable2 = new DefaultButtonElevation.elevation.2.1(invalid$iv, f, z4, obj2, obj3, 0);
                composer5.updateRememberedValue((Function2)animatable2);
            } else {
                it$iv = invalid$iv;
                animatable2 = obj;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        EffectsKt.LaunchedEffect(Dp.box-impl(f), (Function2)animatable2, composer4, i29);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer4.endReplaceGroup();
        return it$iv.asState();
    }
}
