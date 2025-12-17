package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\u0008\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ#\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016J%\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0004\u0008\u001e\u0010\u0018R\u0019\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\r\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u000e\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u000f\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u0010\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u0011\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001f²\u0006\u000c\u0010 \u001a\u0004\u0018\u00010!X\u008a\u008e\u0002", d2 = {"Landroidx/compose/material3/SelectableChipElevation;", "", "elevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisabledElevation-D9Ej5fM", "()F", "F", "getDraggedElevation-D9Ej5fM", "getElevation-D9Ej5fM", "getFocusedElevation-D9Ej5fM", "getHoveredElevation-D9Ej5fM", "getPressedElevation-D9Ej5fM", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "material3_release", "lastInteraction", "Landroidx/compose/foundation/interaction/Interaction;"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectableChipElevation {

    public static final int $stable;
    private final float disabledElevation;
    private final float draggedElevation;
    private final float elevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;
    static {
    }

    private SelectableChipElevation(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation) {
        super();
        this.elevation = elevation;
        this.pressedElevation = pressedElevation;
        this.focusedElevation = focusedElevation;
        this.hoveredElevation = hoveredElevation;
        this.draggedElevation = draggedElevation;
        this.disabledElevation = disabledElevation;
    }

    public SelectableChipElevation(float f, float f2, float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(f, f2, f3, f4, f5, f6);
    }

    public static final Interaction access$animateElevation$lambda$2(MutableState $lastInteraction$delegate) {
        return SelectableChipElevation.animateElevation$lambda$2($lastInteraction$delegate);
    }

    public static final void access$animateElevation$lambda$3(MutableState $lastInteraction$delegate, Interaction value) {
        SelectableChipElevation.animateElevation$lambda$3($lastInteraction$delegate, value);
    }

    private final State<Dp> animateElevation(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean changed2;
        int i5;
        float disabledElevation;
        Object animatable;
        boolean traceInProgress;
        Object it$iv2;
        String str;
        Object empty;
        float f;
        int changed;
        Object it$iv;
        Object mutableStateListOf;
        Object mutableStateOf$default;
        Object anon;
        int i;
        Object obj2;
        Composer.Companion companion;
        int i7;
        Animatable animatable2;
        Dp box-impl;
        Object obj;
        androidx.compose.animation.core.TwoWayConverter vectorConverter;
        int i2;
        int i3;
        int i4;
        int i6;
        final Object obj3 = this;
        boolean z5 = enabled;
        final Object obj6 = interactionSource;
        final Composer composer4 = $composer;
        final int i30 = $changed;
        int i8 = 664514136;
        ComposerKt.sourceInformationMarkerStart(composer4, i8, "C(animateElevation)2319@110330L46,2320@110408L47,2321@110498L1473,2321@110464L1507,2373@112526L51,2375@112610L514,2375@112587L537:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, i30, -1, "androidx.compose.material3.SelectableChipElevation.animateElevation (Chip.kt:2318)");
        }
        String str3 = "CC(remember):Chip.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer4, -208085728, str3);
        int i10 = 0;
        Composer composer = $composer;
        int i22 = 0;
        Object rememberedValue2 = composer.rememberedValue();
        int i25 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            int i31 = 0;
            composer.updateRememberedValue(SnapshotStateKt.mutableStateListOf());
        } else {
            mutableStateListOf = rememberedValue2;
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerStart(composer4, -208083231, str3);
        int i12 = 0;
        empty = $composer;
        int i23 = 0;
        Object rememberedValue3 = empty.rememberedValue();
        int i26 = 0;
        int i34 = 0;
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            int i32 = 0;
            empty.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(i34, i34, 2, i34));
        } else {
            mutableStateOf$default = rememberedValue3;
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerStart(composer4, -208078925, str3);
        int i24 = 32;
        if (i14 ^= 48 > i24) {
            if (!composer4.changed(obj6)) {
                i5 = i30 & 48 == i24 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i27 = 0;
        Object rememberedValue5 = composer2.rememberedValue();
        int i38 = 0;
        if (i5 == 0) {
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new SelectableChipElevation.animateElevation.1.1(obj6, (SnapshotStateList)mutableStateListOf, i34);
                composer2.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue5;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        EffectsKt.LaunchedEffect(obj6, (Function2)anon, composer4, i15 &= 14);
        Object obj4 = lastOrNull;
        f = !z5 ? disabledElevation : z ? disabledElevation : z2 ? disabledElevation : z3 ? disabledElevation : z4 ? disabledElevation : disabledElevation;
        ComposerKt.sourceInformationMarkerStart(composer4, -208015451, str3);
        int i18 = 0;
        Composer composer3 = $composer;
        int i33 = 0;
        Object rememberedValue4 = composer3.rememberedValue();
        int i37 = 0;
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            int i39 = 0;
            animatable2 = new Animatable(Dp.box-impl(f), VectorConvertersKt.getVectorConverter(Dp.Companion), 0, 0, 12, 0);
            composer3.updateRememberedValue(animatable2);
        } else {
            obj2 = rememberedValue4;
        }
        Object invalid$iv = obj2;
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerStart(composer4, -208012300, str3);
        int i35 = 4;
        if (i29 ^= 6 > i35) {
            if (!composer4.changed(z5)) {
                i7 = i30 & 6 == i35 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer5 = $composer;
        int i40 = 0;
        Object rememberedValue = composer5.rememberedValue();
        int i41 = 0;
        if (i20 | it$iv == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                animatable2 = 0;
                obj = obj5;
                animatable = new SelectableChipElevation.animateElevation.2.1(invalid$iv, f, z5, obj4, (MutableState)mutableStateOf$default, 0);
                composer5.updateRememberedValue((Function2)animatable);
            } else {
                it$iv2 = invalid$iv;
                animatable = obj;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        EffectsKt.LaunchedEffect(Dp.box-impl(f), (Function2)animatable, composer4, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        return it$iv2.asState();
    }

    private static final Interaction animateElevation$lambda$2(MutableState<Interaction> $lastInteraction$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Interaction)(State)$lastInteraction$delegate.getValue();
    }

    private static final void animateElevation$lambda$3(MutableState<Interaction> $lastInteraction$delegate, Interaction value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $lastInteraction$delegate.setValue(value);
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof SelectableChipElevation) {
            } else {
                if (!Dp.equals-impl0(this.elevation, obj.elevation)) {
                    return i2;
                }
                if (!Dp.equals-impl0(this.pressedElevation, obj2.pressedElevation)) {
                    return i2;
                }
                if (!Dp.equals-impl0(this.focusedElevation, obj3.focusedElevation)) {
                    return i2;
                }
                if (!Dp.equals-impl0(this.hoveredElevation, obj4.hoveredElevation)) {
                    return i2;
                }
                if (!Dp.equals-impl0(this.disabledElevation, obj5.disabledElevation)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final float getDisabledElevation-D9Ej5fM() {
        return this.disabledElevation;
    }

    public final float getDraggedElevation-D9Ej5fM() {
        return this.draggedElevation;
    }

    public final float getElevation-D9Ej5fM() {
        return this.elevation;
    }

    public final float getFocusedElevation-D9Ej5fM() {
        return this.focusedElevation;
    }

    public final float getHoveredElevation-D9Ej5fM() {
        return this.hoveredElevation;
    }

    public final float getPressedElevation-D9Ej5fM() {
        return this.pressedElevation;
    }

    public int hashCode() {
        return result2 += i10;
    }

    public final State<Dp> shadowElevation$material3_release(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1888175651;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(shadowElevation)2311@110081L74:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.SelectableChipElevation.shadowElevation (Chip.kt:2310)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return animateElevation(enabled, interactionSource, $composer, i3 |= i6);
    }
}
