package androidx.compose.material3;

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
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B/\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J#\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\r2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J%\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0004\u0008\u0016\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0017", d2 = {"Landroidx/compose/material3/ButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "(FFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ButtonElevation {

    public static final int $stable;
    private final float defaultElevation;
    private final float disabledElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;
    static {
    }

    private ButtonElevation(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float disabledElevation) {
        super();
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.focusedElevation = focusedElevation;
        this.hoveredElevation = hoveredElevation;
        this.disabledElevation = disabledElevation;
    }

    public ButtonElevation(float f, float f2, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(f, f2, f3, f4, f5);
    }

    public static final float access$getFocusedElevation$p(androidx.compose.material3.ButtonElevation $this) {
        return $this.focusedElevation;
    }

    public static final float access$getHoveredElevation$p(androidx.compose.material3.ButtonElevation $this) {
        return $this.hoveredElevation;
    }

    public static final float access$getPressedElevation$p(androidx.compose.material3.ButtonElevation $this) {
        return $this.pressedElevation;
    }

    private final State<Dp> animateElevation(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean changed;
        int i6;
        float disabledElevation;
        Object animatable;
        boolean traceInProgress;
        Animatable it$iv;
        String str;
        float f;
        int i5;
        boolean changed3;
        int i7;
        int changed2;
        Object it$iv2;
        Object $i$a$CacheButtonElevation$animateElevation$interactions$1;
        Object empty;
        Object anon;
        Object $i$a$CacheButtonElevation$animateElevation$animatable$1;
        int i4;
        Animatable animatable2;
        Dp box-impl;
        Object obj;
        androidx.compose.animation.core.TwoWayConverter vectorConverter;
        int i2;
        int i;
        int i3;
        int i8;
        final Object obj2 = this;
        boolean z4 = enabled;
        final Object obj5 = interactionSource;
        final Composer composer4 = $composer;
        final int i26 = $changed;
        int i9 = -1312510462;
        ComposerKt.sourceInformationMarkerStart(composer4, i9, "C(animateElevation)939@43442L46,940@43531L1077,940@43497L1111,982@45105L51,984@45189L863,984@45166L886:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, i26, -1, "androidx.compose.material3.ButtonElevation.animateElevation (Button.kt:938)");
        }
        String str3 = "CC(remember):Button.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer4, -842871664, str3);
        int i11 = 0;
        Composer composer = $composer;
        i5 = 0;
        Object rememberedValue2 = composer.rememberedValue();
        int i27 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            int i28 = 0;
            composer.updateRememberedValue(SnapshotStateKt.mutableStateListOf());
        } else {
            $i$a$CacheButtonElevation$animateElevation$interactions$1 = rememberedValue2;
        }
        androidx.compose.runtime.snapshots.SnapshotStateList list2 = $i$a$CacheButtonElevation$animateElevation$interactions$1;
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerStart(composer4, -842867785, str3);
        int i21 = 32;
        int i29 = 0;
        if (i13 ^= 48 > i21) {
            if (!composer4.changed(obj5)) {
                i6 = i26 & 48 == i21 ? 1 : i29;
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i22 = 0;
        Object rememberedValue3 = composer2.rememberedValue();
        int i31 = 0;
        if (i6 == 0) {
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new ButtonElevation.animateElevation.1.1(obj5, (SnapshotStateList)list2, 0);
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
        ComposerKt.sourceInformationMarkerStart(composer4, -842818443, str3);
        int i17 = 0;
        Composer composer3 = $composer;
        int i30 = 0;
        Object rememberedValue4 = composer3.rememberedValue();
        int i35 = 0;
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            int i36 = 0;
            animatable2 = new Animatable(Dp.box-impl(f), VectorConvertersKt.getVectorConverter(Dp.Companion), 0, 0, 12, 0);
            composer3.updateRememberedValue(animatable2);
        } else {
            $i$a$CacheButtonElevation$animateElevation$animatable$1 = rememberedValue4;
        }
        Animatable invalid$iv = $i$a$CacheButtonElevation$animateElevation$animatable$1;
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerStart(composer4, -842814943, str3);
        int i32 = 4;
        if (i24 ^= 6 > i32) {
            if (!composer4.changed(z4)) {
                i7 = i26 & 6 == i32 ? 1 : i29;
            } else {
            }
        } else {
        }
        int i33 = 256;
        if (i25 ^= 384 > i33) {
            if (!composer4.changed(obj2)) {
                i4 = i26 & 384 == i33 ? 1 : i29;
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
                animatable2 = 0;
                obj = obj4;
                animatable = new ButtonElevation.animateElevation.2.1(invalid$iv, f, z4, obj2, obj3, 0);
                composer5.updateRememberedValue((Function2)animatable);
            } else {
                it$iv = invalid$iv;
                animatable = obj;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        EffectsKt.LaunchedEffect(Dp.box-impl(f), (Function2)animatable, composer4, i29);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        return it$iv.asState();
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof ButtonElevation) {
            } else {
                if (!Dp.equals-impl0(this.defaultElevation, obj.defaultElevation)) {
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

    public int hashCode() {
        return result2 += i10;
    }

    public final State<Dp> shadowElevation$material3_release(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -2045116089;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(shadowElevation)931@43193L74:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonElevation.shadowElevation (Button.kt:930)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return animateElevation(enabled, interactionSource, $composer, i3 |= i6);
    }
}
