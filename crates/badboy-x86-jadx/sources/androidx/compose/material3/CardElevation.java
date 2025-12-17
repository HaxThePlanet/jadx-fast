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
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B7\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ#\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u000e2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J'\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0004\u0008\u0017\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0008\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0018", d2 = {"Landroidx/compose/material3/CardElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "(FFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CardElevation {

    public static final int $stable;
    private final float defaultElevation;
    private final float disabledElevation;
    private final float draggedElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;
    static {
    }

    private CardElevation(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation) {
        super();
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.focusedElevation = focusedElevation;
        this.hoveredElevation = hoveredElevation;
        this.draggedElevation = draggedElevation;
        this.disabledElevation = disabledElevation;
    }

    public CardElevation(float f, float f2, float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(f, f2, f3, f4, f5, f6);
    }

    public static final float access$getDraggedElevation$p(androidx.compose.material3.CardElevation $this) {
        return $this.draggedElevation;
    }

    public static final float access$getFocusedElevation$p(androidx.compose.material3.CardElevation $this) {
        return $this.focusedElevation;
    }

    public static final float access$getHoveredElevation$p(androidx.compose.material3.CardElevation $this) {
        return $this.hoveredElevation;
    }

    public static final float access$getPressedElevation$p(androidx.compose.material3.CardElevation $this) {
        return $this.pressedElevation;
    }

    private final State<Dp> animateElevation(boolean enabled, InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean changed2;
        int i;
        float disabledElevation;
        Object animatable;
        boolean traceInProgress;
        Object it$iv;
        String str;
        float f;
        int i3;
        int changed;
        int i7;
        int changed3;
        Object it$iv2;
        Object $i$a$CacheCardElevation$animateElevation$interactions$1;
        Object empty;
        Object anon;
        Object $i$a$CacheCardElevation$animateElevation$animatable$1;
        int i4;
        Animatable animatable2;
        Dp box-impl;
        Object obj;
        androidx.compose.animation.core.TwoWayConverter vectorConverter;
        int i2;
        int i5;
        int i8;
        int i6;
        final Object obj2 = this;
        boolean z5 = enabled;
        final Object obj5 = interactionSource;
        final Composer composer4 = $composer;
        final int i26 = $changed;
        int i9 = -1421890746;
        ComposerKt.sourceInformationMarkerStart(composer4, i9, "C(animateElevation)671@30002L46,672@30091L1473,672@30057L1507,724@32126L51,726@32210L936,726@32187L959:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, i26, -1, "androidx.compose.material3.CardElevation.animateElevation (Card.kt:670)");
        }
        String str3 = "CC(remember):Card.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer4, -1719589842, str3);
        int i11 = 0;
        Composer composer = $composer;
        i3 = 0;
        Object rememberedValue2 = composer.rememberedValue();
        int i27 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            int i28 = 0;
            composer.updateRememberedValue(SnapshotStateKt.mutableStateListOf());
        } else {
            $i$a$CacheCardElevation$animateElevation$interactions$1 = rememberedValue2;
        }
        androidx.compose.runtime.snapshots.SnapshotStateList list2 = $i$a$CacheCardElevation$animateElevation$interactions$1;
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerStart(composer4, -1719585567, str3);
        int i21 = 32;
        int i29 = 0;
        if (i13 ^= 48 > i21) {
            if (!composer4.changed(obj5)) {
                i = i26 & 48 == i21 ? 1 : i29;
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i22 = 0;
        Object rememberedValue3 = composer2.rememberedValue();
        int i31 = 0;
        if (i == 0) {
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new CardElevation.animateElevation.1.1(obj5, (SnapshotStateList)list2, 0);
                composer2.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue3;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer4);
        EffectsKt.LaunchedEffect(obj5, (Function2)anon, composer4, i14 &= 14);
        Object obj3 = lastOrNull;
        f = !z5 ? disabledElevation : z ? disabledElevation : z2 ? disabledElevation : z3 ? disabledElevation : z4 ? disabledElevation : disabledElevation;
        ComposerKt.sourceInformationMarkerStart(composer4, -1719521869, str3);
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
            $i$a$CacheCardElevation$animateElevation$animatable$1 = rememberedValue4;
        }
        Object invalid$iv = $i$a$CacheCardElevation$animateElevation$animatable$1;
        ComposerKt.sourceInformationMarkerEnd(composer4);
        ComposerKt.sourceInformationMarkerStart(composer4, -1719518296, str3);
        int i32 = 4;
        if (i24 ^= 6 > i32) {
            if (!composer4.changed(z5)) {
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
                animatable = new CardElevation.animateElevation.2.1(invalid$iv, f, z5, obj2, obj3, 0);
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
            if (!other instanceof CardElevation) {
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
        Object $i$a$CacheCardElevation$shadowElevation$1;
        Dp box-impl;
        int i2;
        int i;
        int i3 = -1763481333;
        $composer.startReplaceGroup(i3);
        ComposerKt.sourceInformation($composer, "C(shadowElevation)663@29753L74:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material3.CardElevation.shadowElevation (Card.kt:659)");
        }
        $composer.startReplaceGroup(-734838460);
        ComposerKt.sourceInformation($composer, "661@29682L45");
        if (interactionSource == null) {
            ComposerKt.sourceInformationMarkerStart($composer, -734836858, "CC(remember):Card.kt#9igjgp");
            int i6 = 0;
            Composer composer = $composer;
            int i12 = 0;
            final Object rememberedValue = composer.rememberedValue();
            final int i13 = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i14 = 0;
                i = 0;
                composer.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(Dp.box-impl(this.defaultElevation), i, 2, i));
            } else {
                $i$a$CacheCardElevation$shadowElevation$1 = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return (State)(MutableState)$i$a$CacheCardElevation$shadowElevation$1;
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return animateElevation(enabled, interactionSource, $composer, i8 |= i11);
    }
}
