package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0017\u0018\u00002\u00020\u0001B'\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0003¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0001¢\u0006\u0004\u0008\u0014\u0010\rJ\u0015\u0010\u0015\u001a\u00020\u0003H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0018", d2 = {"Landroidx/compose/material3/FloatingActionButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "animateElevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "", "other", "hashCode", "", "shadowElevation", "shadowElevation$material3_release", "tonalElevation", "tonalElevation-D9Ej5fM$material3_release", "()F", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class FloatingActionButtonElevation {

    public static final int $stable;
    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;
    static {
    }

    private FloatingActionButtonElevation(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation) {
        super();
        this.defaultElevation = defaultElevation;
        this.pressedElevation = pressedElevation;
        this.focusedElevation = focusedElevation;
        this.hoveredElevation = hoveredElevation;
    }

    public FloatingActionButtonElevation(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(f, f2, f3, f4);
    }

    public static final float access$getDefaultElevation$p(androidx.compose.material3.FloatingActionButtonElevation $this) {
        return $this.defaultElevation;
    }

    public static final float access$getFocusedElevation$p(androidx.compose.material3.FloatingActionButtonElevation $this) {
        return $this.focusedElevation;
    }

    public static final float access$getHoveredElevation$p(androidx.compose.material3.FloatingActionButtonElevation $this) {
        return $this.hoveredElevation;
    }

    public static final float access$getPressedElevation$p(androidx.compose.material3.FloatingActionButtonElevation $this) {
        return $this.pressedElevation;
    }

    private final State<Dp> animateElevation(InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean changed3;
        int i4;
        int changed2;
        boolean traceInProgress;
        int i5;
        String pressedElevation;
        int changed;
        int i2;
        int i3;
        float hoveredElevation;
        int focusedElevation;
        int empty2;
        Object rememberedValue;
        Object anon;
        Object anon2;
        Object empty;
        Object floatingActionButtonElevationAnimatable;
        float defaultElevation;
        float f2;
        float f3;
        float f;
        int i;
        final Object obj = this;
        final Object obj2 = interactionSource;
        final Composer composer = $composer;
        final int i6 = $changed;
        int i7 = -1845106002;
        ComposerKt.sourceInformationMarkerStart(composer, i7, "C(animateElevation)527@24330L345,536@24706L276,536@24685L297,545@25026L1282,545@24992L1316:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, i6, -1, "androidx.compose.material3.FloatingActionButtonElevation.animateElevation (FloatingActionButton.kt:525)");
        }
        String str2 = "CC(remember):FloatingActionButton.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, 1492982391, str2);
        focusedElevation = 4;
        if (i9 ^= 6 > focusedElevation) {
            if (!composer.changed(obj2)) {
                i4 = i6 & 6 == focusedElevation ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer4 = $composer;
        int i23 = 0;
        rememberedValue = composer4.rememberedValue();
        int i25 = 0;
        if (i4 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                floatingActionButtonElevationAnimatable = new FloatingActionButtonElevationAnimatable(obj.defaultElevation, obj.pressedElevation, obj.hoveredElevation, obj.focusedElevation, 0);
                composer4.updateRememberedValue(floatingActionButtonElevationAnimatable);
            } else {
                floatingActionButtonElevationAnimatable = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1492994354, str2);
        int i20 = 32;
        if (i18 ^= 48 > i20) {
            if (!composer.changed(obj)) {
                i2 = i6 & 48 == i20 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer3 = $composer;
        int i21 = 0;
        Object rememberedValue3 = composer3.rememberedValue();
        empty2 = 0;
        int i24 = 0;
        if (changedInstance |= i2 == 0) {
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue = 0;
                anon2 = new FloatingActionButtonElevation.animateElevation.1.1(floatingActionButtonElevationAnimatable, obj, i24);
                composer3.updateRememberedValue((Function2)anon2);
            } else {
                anon2 = rememberedValue3;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(obj, (Function2)anon2, composer, i12 &= 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1493005600, str2);
        if (i15 ^= 6 > 4) {
            if (!composer.changed(obj2)) {
                i3 = i6 & 6 == 4 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i19 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i22 = 0;
        if (changedInstance2 |= i3 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                empty2 = 0;
                anon = new FloatingActionButtonElevation.animateElevation.2.1(obj2, floatingActionButtonElevationAnimatable, i24);
                composer2.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(obj2, (Function2)anon, composer, i6 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return floatingActionButtonElevationAnimatable.asState();
    }

    public boolean equals(Object other) {
        boolean z;
        if (this == other) {
            return 1;
        }
        int i = 0;
        if (other != null) {
            if (!other instanceof FloatingActionButtonElevation) {
            } else {
                if (!Dp.equals-impl0(this.defaultElevation, obj2.defaultElevation)) {
                    return i;
                }
                if (!Dp.equals-impl0(this.pressedElevation, obj3.pressedElevation)) {
                    return i;
                }
                if (!Dp.equals-impl0(this.focusedElevation, obj4.focusedElevation)) {
                    return i;
                }
            }
            return Dp.equals-impl0(this.hoveredElevation, obj.hoveredElevation);
        }
        return i;
    }

    public int hashCode() {
        return result2 += i8;
    }

    public final State<Dp> shadowElevation$material3_release(InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -424810125;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(shadowElevation)517@24051L55:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FloatingActionButtonElevation.shadowElevation (FloatingActionButton.kt:516)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return animateElevation(interactionSource, $composer, i2 |= i4);
    }

    public final float tonalElevation-D9Ej5fM$material3_release() {
        return this.defaultElevation;
    }
}
